package bi3.pages.pms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS001SettingsPage extends BasePage {
  public PMS001SettingsPage(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWXCRM-shdo")
  private WebElement cmbBoxFullScrOption;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listFullScrOption;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void selectFullScrOption(final String option) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbBoxFullScrOption, this.listFullScrOption, option);
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
