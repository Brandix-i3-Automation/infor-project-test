package bi3.pages.ois101;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS101B1 extends BasePage {
  public OIS101B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWBITNO")
  private WebElement txtItem;
  
  @FindBy(id = "WBORQA")
  private WebElement txtQuantity;
  
  @FindBy(id = "WAD74C0")
  private WebElement addBtn;
  
  @FindBy(css = "#WBITNOContainer>button")
  private WebElement itemSelectArrow;
  
  @FindBy(css = "#WBITNO")
  private WebElement itemName;
  
  @FindBy(css = "#WBSAPR")
  private WebElement itemSalesPrice;
  
  @FindBy(id = "POS")
  private WebElement txtSearchBoxPOS;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(css = "div[id*=\'BROWSE_LIST\'] div.slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(css = "#tabsList > li.ui-tabs-selected.ui-state-active > button")
  private WebElement btnClose;
  
  @FindBy(id = "OAORNO")
  private WebElement txtCONumber;
  
  @FindBy(css = "#OAEXCD")
  private WebElement txtServiceNumber;
  
  @FindBy(css = "#OAPYCD")
  private WebElement txtPaymentMtd;
  
  @FindBy(css = "#OATAXC")
  private WebElement taxCode;
  
  @FindBy(css = "#OAORNO")
  private WebElement textCoCode;
  
  @FindBy(css = "div[id*=\'pRow9\'][class*=\'lawsonModuleRow\']")
  private WebElement COtable;
  
  @FindBy(id = "WAD74C0")
  private WebElement btnAdd;
  
  public List<String> checkItemPresence() {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.COtable);
    System.out.println(grid.getDataOfColumn(2));
    return grid.getDataOfColumn(2);
  }
  
  public void fillOrderLine(final String Item, final String Quantity) {
    try {
      this.txtPaymentMtd.click();
      this.txtPaymentMtd.sendKeys("BEZ");
      Thread.sleep(1000);
      this.taxCode.click();
      this.taxCode.sendKeys("CRE");
      Thread.sleep(1000);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getTheCONumber() {
    BasePage.waitForLoadingComplete();
    final String CONumber = BasePage.GetTextBoxvalue(this.txtCONumber);
    System.out.println(CONumber);
    return CONumber;
  }
  
  public void closeN1() {
    this.btnClose.click();
    System.out.println("PDS001 tab closed");
  }
  
  public void CustomerOrderOPenLine(final String item, final String qty, final String salesPrice) {
    this.itemName.click();
    this.itemName.sendKeys(item);
    this.txtQuantity.click();
    this.txtQuantity.sendKeys(qty);
    this.itemSalesPrice.click();
    this.itemSalesPrice.sendKeys(salesPrice);
  }
  
  public String GetCONumber() {
    String co = BasePage.GetTextBoxvalue(this.textCoCode);
    return co;
  }
  
  public void ClickAdd() {
    WebDriverExtensions.waitToBeClickable(this.btnAdd);
    this.btnAdd.click();
    BasePage.waitForLoadingComplete();
  }
}
