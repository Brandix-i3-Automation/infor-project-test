package bi3.pages.pms050;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@SuppressWarnings("all")
public class PMS050A extends BasePage {
  public PMS050A(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "#WHSCHN+button")
  private WebElement btnSchedNoLookUp;
  
  @FindBy(id = "POS")
  private WebElement txtLookUpSearch;
  
  @FindBy(css = "div[row=\'0\']>div[class=\'slick-cell l0 r0\']")
  private WebElement firstCellLookUpGrid;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelectLookUpGrid;
  
  @FindBy(id = "WHPRNO")
  private WebElement txtProdNumber;
  
  @FindBy(id = "WHMFNO")
  private WebElement txtMONo;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "WHSCHN")
  private WebElement txtSchNo;
  
  @FindBy(xpath = ".//*[@class=\'ui-tabs-selected ui-state-active\']//div/div")
  private WebElement lblMoReportReceipt;
  
  public void EnterScheduleNo(final String ScheduleNo) {
    WebDriverExtensions.waitToBeClickable(this.txtSchNo);
    this.txtSchNo.click();
    this.txtSchNo.sendKeys(ScheduleNo);
  }
  
  public String getMoReportReceiptlblValue() {
    WebDriverExtensions.waitToBeDisplayed(this.lblMoReportReceipt);
    return this.lblMoReportReceipt.getText();
  }
  
  public void setSchedNumberFromLookUp(final String schedNo) {
    WebDriverExtensions.waitToBeClickable(this.btnSchedNoLookUp);
    this.btnSchedNoLookUp.click();
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtLookUpSearch);
    this.txtLookUpSearch.click();
    BasePage.clearRobustly(this.txtLookUpSearch);
    this.txtLookUpSearch.sendKeys(schedNo);
    this.txtLookUpSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    boolean _equals = this.firstCellLookUpGrid.getText().equals(schedNo);
    if (_equals) {
      this.firstCellLookUpGrid.click();
      this.btnSelectLookUpGrid.click();
    } else {
      Assert.fail((("Schedule Number " + schedNo) + " could not be found on the look up grid"));
    }
  }
  
  public void clearProductNo() {
    WebDriverExtensions.waitToBeClickable(this.txtProdNumber);
    this.txtProdNumber.click();
    BasePage.clearRobustly(this.txtProdNumber);
  }
  
  public void clearMONumber() {
    WebDriverExtensions.waitToBeClickable(this.txtMONo);
    this.txtMONo.click();
    BasePage.clearRobustly(this.txtMONo);
  }
  
  public void Next() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
