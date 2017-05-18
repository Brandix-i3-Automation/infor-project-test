package bi3.pages.pps300;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS300A extends BasePage {
  public PPS300A(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWPUNO")
  private WebElement txtPONum;
  
  @FindBy(css = "#pRow6>div:nth-child(2)>div>button")
  private WebElement btnPNLILookUp;
  
  @FindBy(css = "#pRow6>div:nth-child(3)>div>button")
  private WebElement btnPNLSLookUp;
  
  @FindBy(id = "POS")
  private WebElement txtLookUpPOSearch;
  
  @FindBy(css = "div[id*=\'BROWSE_LIST\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "WWWHLO")
  private WebElement txtWarehouse;
  
  @FindBy(id = "WWPNLI")
  private WebElement txtPONumTxtBox1;
  
  @FindBy(xpath = "//div[text()=\'Purchase Order. Display Lines\']")
  private WebElement linkPurchaseOrderDisplayLines;
  
  @FindBy(id = "MyCanvasLbl")
  private WebElement linkStart;
  
  public void setPONum(final String po) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtPONum);
    this.txtPONum.click();
    BasePage.clearRobustly(this.txtPONum);
    this.txtPONum.sendKeys(po);
    BasePage.waitForLoadingComplete();
  }
  
  public void SetPurchaseOrderLineFromLookUp(final String po) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.btnPNLILookUp);
    this.btnPNLILookUp.click();
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtLookUpPOSearch);
    this.txtLookUpPOSearch.click();
    BasePage.clearRobustly(this.txtLookUpPOSearch);
    this.txtLookUpPOSearch.sendKeys(po);
    this.txtLookUpPOSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    WebElement row = grid.getRow(0);
    WebDriverExtensions.waitToBeClickable(row);
    row.click();
    WebDriverExtensions.waitToBeClickable(this.btnSelect);
    this.btnSelect.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void SetPurchaseOrderLineSubNumFromLookUp(final String po) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.btnPNLSLookUp);
    this.btnPNLSLookUp.click();
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtLookUpPOSearch);
    this.txtLookUpPOSearch.click();
    BasePage.clearRobustly(this.txtLookUpPOSearch);
    this.txtLookUpPOSearch.sendKeys(po);
    this.txtLookUpPOSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    WebElement row = grid.getRow(0);
    WebDriverExtensions.waitToBeClickable(row);
    row.click();
    WebDriverExtensions.waitToBeClickable(this.btnSelect);
    this.btnSelect.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void setWarehouse(final String warehouse) {
    WebDriverExtensions.waitToBeClickable(this.txtWarehouse);
    this.txtWarehouse.click();
    BasePage.clearRobustly(this.txtWarehouse);
    this.txtWarehouse.sendKeys(warehouse);
  }
  
  public void ClickNext() {
    WebDriverExtensions.waitToBeDisplayed(this.btnNext);
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void fillPOtxtBox1(final String POno) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtPONumTxtBox1);
    this.txtPONumTxtBox1.click();
    BasePage.clearRobustly(this.txtPONumTxtBox1);
    this.txtPONumTxtBox1.sendKeys(POno);
  }
  
  public void GoToPurchaseOrderDisplayLines() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.linkPurchaseOrderDisplayLines);
    this.linkPurchaseOrderDisplayLines.click();
  }
  
  public void goToStartPage() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.linkStart);
    this.linkStart.click();
  }
}
