package bi3.pages.pps220;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS220B extends BasePage {
  public PPS220B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1OBKV")
  private WebElement txtPOSearch;
  
  @FindBy(css = "div[id*=\'PPA220BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[text()=\'Confirm Order\']")
  private WebElement linkConfirmOrder;
  
  @FindBy(xpath = "//a/span[text()=\'Goods Receipt\']")
  private WebElement linkGoodsRec;
  
  @FindBy(css = "button[class=\'inforTabCloseButton\'][title=\'Close\']")
  private List<WebElement> btnClose;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(xpath = "//a/span[text()=\'Advise Shipment\']")
  private WebElement linkAdviseShipment;
  
  @FindBy(id = "W1OBKV")
  private WebElement txtPOno;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Transport Notification\')]")
  private WebElement linkTransportNotification;
  
  @FindBy(id = "MyCanvasLbl")
  private WebElement linkStart;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Purchase Order Transactions\')]")
  private WebElement linkPurchaseOrderTransactions;
  
  public void searchPONumber(final String po) {
    WebDriverExtensions.waitToBeClickable(this.txtPOSearch);
    this.txtPOSearch.click();
    BasePage.clearRobustly(this.txtPOSearch);
    this.txtPOSearch.sendKeys(po);
    this.txtPOSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void confirmOrder(final String po) {
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> row = grid.getCellsFromRow(0);
    String _text = row.get(1).getText();
    String _plus = ("row.get(1) : " + _text);
    System.out.println(_plus);
    this.rightClick(row.get(1));
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkConfirmOrder);
    this.linkConfirmOrder.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void goodsReceipt(final String po) {
    InforGrid grid = new InforGrid(this.gridElement);
    WebElement row = grid.getRow(0);
    this.rightClick(row);
    WebDriverExtensions.waitToBeDisplayed(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkGoodsRec);
    this.linkGoodsRec.click();
    BasePage.waitForLoadingComplete();
  }
  
  public boolean close() {
    try {
      int _size = this.btnClose.size();
      boolean _equals = (_size == 2);
      if (_equals) {
        WebDriverExtensions.waitToBeClickable(this.btnClose.get(1));
        this.btnClose.get(1).click();
        BasePage.waitForLoadingComplete();
      }
      return true;
    } catch (final Throwable _t) {
      if (_t instanceof ElementNotFoundException) {
        final ElementNotFoundException e = (ElementNotFoundException)_t;
        return false;
      } else if (_t instanceof ElementNotVisibleException) {
        final ElementNotVisibleException e_1 = (ElementNotVisibleException)_t;
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void GotoRelatedAndAdviceShipment() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.gridFirstLine);
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkAdviseShipment);
    this.linkAdviseShipment.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String getLstOfFirstRow() {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> cellElementList = grid.getCellsFromRow(0);
    WebElement cellLst = cellElementList.get(12);
    String Lst = cellLst.getText();
    InputOutput.<String>println("Lst value returned");
    return Lst;
  }
  
  public String getHstOfFirstRow() {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> cellElementList = grid.getCellsFromRow(0);
    WebElement cellHst = cellElementList.get(13);
    String Hst = cellHst.getText();
    InputOutput.<String>println("Hst value returned");
    return Hst;
  }
  
  public void goToRelatedAndClickTransportNotification() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkTransportNotification);
    this.linkTransportNotification.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void goToStartPage() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.linkStart);
    this.linkStart.click();
  }
  
  public void goToRelatedAndClickPurchaseOrderTransactions() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkPurchaseOrderTransactions);
    this.linkPurchaseOrderTransactions.click();
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * @param columnIndex Column index starts from 1
   */
  public List<String> getDetailsFromGrid(final int columnIndex, final String value) {
    InforGrid grid = new InforGrid(this.gridElement);
    List<String> dataList = grid.getDataOfRowContainingTextInColumn(columnIndex, value);
    return dataList;
  }
  
  public boolean checkTheLst(final String sts) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> cellElementList = grid.getCellsFromRow(0);
    WebElement cellLst = cellElementList.get(12);
    String Lst = cellLst.getText();
    InputOutput.<String>println("Lst value returned");
    boolean _equals = Objects.equal(Lst, sts);
    if (_equals) {
      return true;
    } else {
      return false;
    }
  }
  
  public String voidCheckTheStatus(final String PONumber) {
    InforGrid inforGrid = new InforGrid(this.gridElement);
    WebElement row = inforGrid.getRowContainingTextInColumn(1, PONumber);
    InputOutput.<String>println(("WebElement of Row " + row));
    List<WebElement> cells = inforGrid.getCellsFromRow(row);
    InputOutput.<String>println(("Cell List  " + cells));
    String status = cells.get(12).getText();
    InputOutput.<String>println(("Status is " + status));
    return status;
  }
}
