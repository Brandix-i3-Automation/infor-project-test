package bi3.pages.pds001;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import com.google.common.base.Objects;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PDS001ConnectMaterialOperation extends BasePage {
  public PDS001ConnectMaterialOperation(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WMMSEQ")
  private WebElement txtSno;
  
  @FindBy(id = "WBOPNO")
  private WebElement txtOp;
  
  @FindBy(id = "WWMTPL")
  private WebElement txtComp;
  
  @FindBy(css = "button[class=\'inforIconButton new\']")
  private WebElement btnAdd;
  
  @FindBy(css = "div[class=\'grid-canvas grid-canvas-top grid-canvas-left\']>div[role=\'row\']:last-child>div:nth-child(4)")
  private WebElement lastAddedComponentId;
  
  @FindBy(id = "POS")
  private WebElement txtOperationId;
  
  @FindBy(css = "div[row=\'0\']>div[class=\'slick-cell l0 r0  uppercase\']")
  private WebElement firstGridCell;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(css = "#tabsList > li.ui-tabs-selected.ui-state-active > button")
  private WebElement btnClose;
  
  @FindBy(css = "div[id*=\'PDA002US\'][class*=\'inforDataGrid\'")
  private WebElement inforGridPDS001;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//div[@class=\'inforMenu submenu\']//a/span[contains(text(),\'Options/Line\')]")
  private WebElement linkOptionsLine;
  
  public void setSno(final String sno) {
    WebDriverExtensions.waitToBeDisplayed(this.txtSno);
    WebDriverExtensions.waitToBeClickable(this.txtSno);
    this.txtSno.click();
    BasePage.clearRobustly(this.txtSno);
    this.txtSno.sendKeys(sno);
  }
  
  public void clearTextSno() {
    WebDriverExtensions.waitToBeDisplayed(this.txtSno);
    WebDriverExtensions.waitToBeClickable(this.txtSno);
    this.txtSno.click();
    BasePage.clearRobustly(this.txtSno);
  }
  
  public void setOperation(final String op) {
    WebDriverExtensions.waitToBeDisplayed(this.txtOp);
    WebDriverExtensions.waitToBeClickable(this.txtOp);
    this.txtOp.click();
    BasePage.clearRobustly(this.txtOp);
    this.txtOp.sendKeys(op);
  }
  
  public void setComponent(final String comp) {
    WebDriverExtensions.waitToBeDisplayed(this.txtComp);
    WebDriverExtensions.waitToBeClickable(this.txtComp);
    this.txtComp.click();
    BasePage.clearRobustly(this.txtComp);
    this.txtComp.sendKeys(comp);
  }
  
  public void selectOperationFromLookUp(final String operationId) {
    try {
      WebDriverExtensions.waitToBeDisplayed(this.txtComp);
      WebDriverExtensions.waitToBeClickable(this.txtComp);
      this.txtComp.click();
      BasePage.clearRobustly(this.txtComp);
      this.txtComp.sendKeys(Keys.F4);
      BasePage.waitForLoadingComplete();
      Thread.sleep(2000);
      this.txtOperationId.click();
      BasePage.clearRobustly(this.txtOperationId);
      this.txtOperationId.sendKeys(operationId);
      this.txtOperationId.sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
      Thread.sleep(2000);
      String _text = this.firstGridCell.getText();
      boolean _equals = Objects.equal(_text, operationId);
      if (_equals) {
        this.firstGridCell.click();
        this.btnSelect.click();
      } else {
        System.out.println((("Operation ID " + operationId) + " not found"));
      }
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void clickAddButton() {
    this.btnAdd.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String getLastAddedComponentId() {
    WebDriverExtensions.waitToBeDisplayed(this.lastAddedComponentId);
    return this.lastAddedComponentId.getText();
  }
  
  public void close() {
    this.btnClose.click();
    BasePage.waitForLoadingComplete();
    System.out.println("PDS001 Connect Materials/Operation tab closed");
  }
  
  public void selectOperation(final String value) {
    BasePage.waitForLoadingComplete();
    InforGrid inforGridPDS001 = new InforGrid(this.inforGridPDS001);
    WebElement selectedCell = inforGridPDS001.getCell("Comp no/Wrk ctr", value);
    this.rightClick(selectedCell);
    this.linkRelated.click();
    this.linkOptionsLine.click();
  }
}
