package bi3.pages.mms100;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS100B1 extends BasePage {
  public MMS100B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWQTTP-shdo")
  private WebElement cmbSortingOrder;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listCmbSortingOrder;
  
  @FindBy(id = "W3RORC")
  private WebElement txtRoc;
  
  @FindBy(id = "W3RORN")
  private WebElement txtRefOrder;
  
  @FindBy(css = "div[id*=\'MMA100BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElementDistrOrder;
  
  @FindBy(css = "div[id*=\'MWA420BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElementPickingList;
  
  @FindBy(id = "toolBoxBtnCont")
  private WebElement btnToolBox;
  
  @FindBy(css = ".inforIconButton.refresh")
  private WebElement btnRefresh;
  
  @FindBy(id = "W1TRNR")
  private WebElement txtOrderNumber;
  
  @FindBy(id = "W1RESP")
  private WebElement txtResp;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(linkText = "Related")
  private WebElement linkRelated;
  
  @FindBy(xpath = ".//a/span[contains(text(),\'Order Lines\')]")
  private WebElement linkOrderLines;
  
  @FindBy(xpath = ".//a/span[contains(text(),\'Delivery Toolbox\')]")
  private WebElement linkDeliveryToolbox;
  
  /**
   * Select sorting order drop down.
   */
  public void selectSortingOrder(final String cmbLable) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbSortingOrder, this.listCmbSortingOrder, cmbLable);
    BasePage.waitForLoadingComplete();
  }
  
  public void filterRequestOrder(final String roc, final String refOrdNo) {
    this.txtRoc.sendKeys(roc);
    this.txtRefOrder.sendKeys(refOrdNo);
    this.txtRefOrder.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * navigate to related option.
   */
  public void goToRelatedOption(final String option) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElementDistrOrder);
    WebElement gridRow = null;
    int _rowCount = grid.getRowCount();
    boolean _greaterThan = (_rowCount > 0);
    if (_greaterThan) {
      gridRow = grid.getRow(0);
      gridRow.click();
      this.rightClick(gridRow, Boolean.valueOf(true), option);
    }
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * refresh Page.
   */
  public void refreshPage() {
    WebDriverExtensions.waitToBeClickable(this.btnRefresh);
    this.btnRefresh.click();
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * Get column value using column header name and row index.
   */
  public String getColumnVal(final String colHeaderName, final int rowIndex) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElementDistrOrder);
    return grid.getColumnValByColumnHeader(colHeaderName, rowIndex);
  }
  
  public void SearchOrder(final String ordernumber, final String resp) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.txtOrderNumber);
    this.txtOrderNumber.sendKeys(ordernumber);
    this.txtResp.sendKeys(resp);
    this.txtResp.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToOrderLines() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeDisplayed(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeDisplayed(this.linkOrderLines);
    this.linkOrderLines.click();
  }
  
  public void GoToDeliveryToolbox() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeDisplayed(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeDisplayed(this.linkDeliveryToolbox);
    this.linkDeliveryToolbox.click();
    InputOutput.<String>println("Delivery Toolbox");
    BasePage.waitForLoadingComplete();
  }
}
