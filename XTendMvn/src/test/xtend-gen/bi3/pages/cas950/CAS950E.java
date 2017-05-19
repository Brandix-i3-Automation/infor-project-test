package bi3.pages.cas950;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class CAS950E extends BasePage {
  public CAS950E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(xpath = ".//*[@id=\'WFTRDT\']")
  private WebElement txtFromDate;
  
  @FindBy(xpath = ".//*[@id=\'WTTRDT\']")
  private WebElement txtToDate;
  
  @FindBy(xpath = ".//*[@id=\'WWMITT\']")
  private WebElement chBoxStockTrans;
  
  @FindBy(xpath = ".//*[@id=\'WWMWOP\']")
  private WebElement chBoxOpTransMo;
  
  @FindBy(xpath = ".//*[@id=\'WWCRAC\']")
  private WebElement chBoxOtherTrans;
  
  @FindBy(xpath = ".//*[@id=\'WWMMOP\']")
  private WebElement chBoxOpTransWo;
  
  @FindBy(xpath = ".//*[@id=\'WWCPOC\']")
  private WebElement chBoxOrderCosting;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "WWDIVI")
  private WebElement txtDivision;
  
  public void selectFromDate(final String fromDate) {
    BasePage.waitForLoadingComplete();
    this.txtFromDate.click();
    BasePage.clearRobustly(this.txtFromDate);
    this.txtFromDate.sendKeys(fromDate);
  }
  
  public void selectToDate(final String toDate) {
    BasePage.waitForLoadingComplete();
    this.txtToDate.click();
    BasePage.clearRobustly(this.txtToDate);
    this.txtToDate.sendKeys(toDate);
  }
  
  public void checkStockTrance() {
    BasePage.waitForLoadingComplete();
    this.chBoxStockTrans.click();
  }
  
  public void checkOpTranceMo() {
    BasePage.waitForLoadingComplete();
    this.chBoxOpTransMo.click();
  }
  
  public void checkOtherTrance() {
    BasePage.waitForLoadingComplete();
    this.chBoxOtherTrans.click();
  }
  
  public void checkOpTranceWo() {
    BasePage.waitForLoadingComplete();
    this.chBoxOpTransWo.click();
  }
  
  public void checkOrderCosting() {
    BasePage.waitForLoadingComplete();
    this.chBoxOrderCosting.click();
  }
  
  public void Next() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void FillDivision(final String Division) {
    BasePage.waitForLoadingComplete();
    this.txtDivision.sendKeys(Division);
  }
}
