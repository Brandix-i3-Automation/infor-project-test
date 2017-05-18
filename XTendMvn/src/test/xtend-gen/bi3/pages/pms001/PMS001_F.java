package bi3.pages.pms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS001_F extends BasePage {
  public PMS001_F(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WFSCHN")
  private WebElement txtScheduleNo;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "#WFSCHN +button")
  private WebElement btnScheduleNoLookUp;
  
  @FindBy(id = "POS")
  private WebElement txtScheduleNoM3Browse;
  
  public void EnterScheduleNo(final String ScheduleNo) {
    BasePage.waitForLoadingComplete();
    this.txtScheduleNo.sendKeys(ScheduleNo);
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void ClickScheduleNoLookUp() {
    this.btnScheduleNoLookUp.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void EnterF4() {
    this.txtScheduleNoM3Browse.click();
    this.txtScheduleNoM3Browse.sendKeys(Keys.F4);
    BasePage.waitForLoadingComplete();
  }
}
