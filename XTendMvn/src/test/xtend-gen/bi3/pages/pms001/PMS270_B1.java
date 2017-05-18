package bi3.pages.pms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS270_B1 extends BasePage {
  public PMS270_B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1SCHN")
  private WebElement txtScheduleNo;
  
  @FindBy(css = "button.inforIconButton.new")
  private WebElement btnCreate;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void EnterScheduleNo(final String ScheduleNo) {
    this.txtScheduleNo.click();
    BasePage.clearRobustly(this.txtScheduleNo);
    this.txtScheduleNo.sendKeys(ScheduleNo);
    this.txtScheduleNo.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void ClickOnCreate() {
    WebDriverExtensions.waitToBeClickable(this.btnCreate);
    this.btnCreate.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void EnterF12() {
    this.txtScheduleNo.click();
    this.txtScheduleNo.sendKeys(Keys.F12);
    BasePage.waitForLoadingComplete();
  }
}
