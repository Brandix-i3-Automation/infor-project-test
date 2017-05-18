package bi3.pages.pms070;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@SuppressWarnings("all")
public class PMS070A extends BasePage {
  public PMS070A(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "#WOSCHN+button")
  private WebElement btnSchedNoLookUp;
  
  @FindBy(id = "POS")
  private WebElement txtLookUpSearch;
  
  @FindBy(css = "div[row=\'0\']>div[class=\'slick-cell l0 r0\']")
  private WebElement firstCellLookUpGrid;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelectLookUpGrid;
  
  @FindBy(id = "WOPRNO")
  private WebElement txtProdNumber;
  
  @FindBy(id = "WOMFNO")
  private WebElement txtMONo;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(xpath = ".//*[@href=\'#tabhost_0\']/div/div")
  private WebElement lblMoOperationReport;
  
  @FindBy(id = "WOSCHN")
  private WebElement txtSchNo;
  
  public void enterScheduleNo(final String scheduleNo) {
    WebDriverExtensions.waitToBeClickable(this.txtSchNo);
    this.txtSchNo.click();
    this.txtSchNo.sendKeys(scheduleNo);
  }
  
  public String getOperationReportlblValue() {
    WebDriverExtensions.waitToBeDisplayed(this.lblMoOperationReport);
    return this.lblMoOperationReport.getText();
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
    try {
      WebDriverExtensions.waitToBeClickable(this.txtMONo);
      Thread.sleep(2000);
      this.txtMONo.click();
      BasePage.clearRobustly(this.txtMONo);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void Next() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
