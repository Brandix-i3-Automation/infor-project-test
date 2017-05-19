package bi3.pages.ois390;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS390SettingPage extends BasePage {
  public OIS390SettingPage(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "#WWSPIC-shdo")
  private WebElement cmdOpeningPanel;
  
  @FindBy(css = "#dropdown-list li")
  private List<WebElement> listSortingOrder;
  
  @FindBy(xpath = "//*[contains(text(),\'Opening panel\')]")
  private WebElement txtOpeningPanel;
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void selectOpeningPanel(final String openingPanelValue) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmdOpeningPanel, this.listSortingOrder, openingPanelValue);
    WebDriverExtensions.waitForAnyText(this.txtOpeningPanel, 100);
  }
}
