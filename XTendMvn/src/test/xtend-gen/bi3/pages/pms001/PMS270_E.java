package bi3.pages.pms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS270_E extends BasePage {
  public PMS270_E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWTX40")
  private WebElement txtDescription;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void EnterDescription(final String ScheduleNo) {
    this.txtDescription.click();
    BasePage.clearRobustly(this.txtDescription);
    this.txtDescription.sendKeys(ScheduleNo);
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
