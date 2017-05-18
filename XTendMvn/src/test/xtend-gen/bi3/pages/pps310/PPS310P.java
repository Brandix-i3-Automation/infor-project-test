package bi3.pages.pps310;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS310P extends BasePage {
  public PPS310P(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWSPIC-shdo")
  private WebElement btnOpenPanelDropdown;
  
  @FindBy(css = "#dropdown-list>li")
  private List<WebElement> listPanelOpenOptions;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void SelectPanelOpen(final String option) {
    this.selectFromDropdown(this.btnOpenPanelDropdown, this.listPanelOpenOptions, option);
  }
  
  public void ClickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
