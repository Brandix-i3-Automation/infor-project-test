package bi3.pages.pps310;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS310A extends BasePage {
  public PPS310A(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWREPN")
  private WebElement txtRecvngNo;
  
  @FindBy(id = "WWWHLO")
  private WebElement txtWarehouse;
  
  @FindBy(id = "WWPUNO")
  private WebElement txtPONo;
  
  @FindBy(css = "div#WWPUNOContainer button.inforTriggerButton.inforBrowseIcon")
  private WebElement navPONumber;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void SetRecievingNo(final String rcvngNo) {
    WebDriverExtensions.waitToBeClickable(this.txtRecvngNo);
    this.txtRecvngNo.click();
    BasePage.clearRobustly(this.txtRecvngNo);
    this.txtRecvngNo.sendKeys(rcvngNo);
  }
  
  public void SetWarehouse(final String warehouse) {
    WebDriverExtensions.waitToBeClickable(this.txtWarehouse);
    this.txtWarehouse.click();
    BasePage.clearRobustly(this.txtWarehouse);
    this.txtWarehouse.sendKeys(warehouse);
  }
  
  public void ClickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void EditDetails(final String ponumber) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.txtWarehouse);
    BasePage.clearRobustly(this.txtWarehouse);
    this.txtWarehouse.sendKeys("002");
    WebDriverExtensions.waitToBeDisplayed(this.txtPONo);
    this.txtPONo.sendKeys(ponumber);
    this.navPONumber.click();
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.gridFirstLine);
    this.gridFirstLine.click();
    BasePage.waitForLoadingComplete();
    this.btnSelect.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPPS310E() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
  }
  
  public void PressF12() {
    BasePage.waitForLoadingComplete();
    this.txtWarehouse.sendKeys(Keys.F12);
  }
}
