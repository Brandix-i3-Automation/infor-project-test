package bi3.pages.ois100;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS100H extends BasePage {
  public OIS100H(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "#OATAXCContainer > button")
  private WebElement btnTaxCode;
  
  @FindBy(css = "#POS")
  private WebElement txtTax;
  
  @FindBy(css = "div[id*=\'BROWSE_LIST\'][class*=\'inforDataGrid\']")
  private WebElement gridOIS100H;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(css = "#OATAXC")
  private WebElement txtTaxN;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "Prev")
  private WebElement btnPrev;
  
  @FindBy(css = "#tabsList > li.ui-tabs-selected.ui-state-active > button")
  private WebElement btnClose;
  
  @FindBy(css = "input[id=\'OAPYCD\']")
  private WebElement txtMtdAR;
  
  @FindBy(css = "input[id=\'OATAXC\']")
  private WebElement txtTaxCode;
  
  public void FillTax(final String Keyvalue) {
    BasePage.waitForLoadingComplete();
    this.txtTaxN.sendKeys(Keyvalue);
  }
  
  public void ClickNext() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void ClickPreviousPage() {
    WebDriverExtensions.waitToBeClickable(this.btnPrev);
    this.btnPrev.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void close() {
    this.btnClose.click();
    System.out.println("OIS276B tab closed");
  }
  
  public void FillPicingAndConditionsFNB(final String mtdAR, final String taxCode) {
    WebDriverExtensions.EnterText(this.txtMtdAR, mtdAR);
    WebDriverExtensions.EnterText(this.txtTaxCode, taxCode);
    this.ClickNext();
  }
}
