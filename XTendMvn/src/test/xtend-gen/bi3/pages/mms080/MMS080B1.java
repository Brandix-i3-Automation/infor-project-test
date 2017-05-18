package bi3.pages.mms080;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import bi3.pages.ProgramCommons;
import com.google.common.base.Objects;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS080B1 extends ProgramCommons {
  public MMS080B1(final WebDriver driver) {
    super(driver);
  }
  
  /**
   * PAGE OBJECTS
   */
  @FindBy(id = "WWITNO")
  private WebElement txtBoxItemNo;
  
  @FindBy(id = "div[id*=\'MMA080B1\']")
  private WebElement grid;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Calculate MRP\')]")
  private WebElement btncalculateMRP;
  
  @FindBy(xpath = "//*[@id=\'commandBar\']/div[2]/span/button[7]")
  private WebElement btnRefresh;
  
  @FindBy(id = "WWWHLO")
  private WebElement txtWarehouse;
  
  @FindBy(id = "XT_0168")
  private WebElement btnApply;
  
  @FindBy(css = "div[id*=\'MMA080B1\'][class*=\'inforDataGrid\']")
  private WebElement gridMMA080;
  
  @FindBy(id = "W1ORCA")
  private WebElement txtOct;
  
  /**
   * Set values to fields in the header section of the program
   * @param itemNumber Item Number
   * @param warehouse Warehouse
   */
  public void setHeaderDetails(final String itemNumber, final String warehouse) {
    BasePage.waitForLoadingComplete();
    boolean _notEquals = (!Objects.equal(itemNumber, ""));
    if (_notEquals) {
      this.txtBoxItemNo.click();
      this.txtBoxItemNo.clear();
      this.txtBoxItemNo.sendKeys(itemNumber);
      this.txtBoxItemNo.click();
    }
    boolean _notEquals_1 = (!Objects.equal(warehouse, ""));
    if (_notEquals_1) {
      this.txtWarehouse.click();
      BasePage.clearRobustly(this.txtWarehouse);
      this.txtWarehouse.sendKeys(warehouse);
    }
    this.btnApply.click();
    BasePage.waitForLoadingComplete();
  }
  
  public List<String> getDetailsFromGrid(final String Pldt) {
    InforGrid grid = new InforGrid(this.gridMMA080);
    List<String> dataList = grid.getDataOfRowContainingTextInColumn(2, Pldt);
    return dataList;
  }
  
  /**
   * FNB Details
   */
  public List<String> getFnbDetailsFromGrid() {
    InforGrid grid = new InforGrid(this.gridMMA080);
    List<String> dataList = grid.getDataOfColumn("Oct");
    return dataList;
  }
  
  /**
   * @param columnIndex Column index starts from 1
   */
  public List<String> getDetailsFromGrid(final int columnIndex, final String value) {
    InforGrid grid = new InforGrid(this.gridMMA080);
    List<String> dataList = grid.getDataOfRowContainingTextInColumn(columnIndex, value);
    return dataList;
  }
  
  public void EditWarehouse(final String warehouse) {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtWarehouse);
    WebDriverExtensions.waitToBeDisplayed(this.txtWarehouse);
    this.txtWarehouse.sendKeys(warehouse);
    this.txtWarehouse.sendKeys(Keys.ENTER);
  }
  
  public void calculateMRPAndRefreshPage() {
    BasePage.clickWhenReady(this.btnActionBtn);
    BasePage.clickWhenReady(this.btncalculateMRP);
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitForContainText(this.lblFooterMessage, "Requirements calculation performed", 15);
    BasePage.clickWhenReady(this.btnRefresh);
    BasePage.waitForLoadingComplete();
  }
  
  public void SearchByOct(final String oct) {
    WebDriverExtensions.EnterText(this.txtOct, oct);
    this.txtOct.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public String GetOrderNoOfRecordWithOct(final String oct) {
    List<String> data = this.getDetailsFromGrid(6, oct);
    return data.get(8);
  }
  
  /**
   * Get the order number base on OCT column.
   */
  public List<String> getDataOfRow(final String colHeaderName, final String value) {
    BasePage.waitForLoadingComplete();
    InforGrid InforGrid = new bi3.framework.elements.inforelements.InforGrid(this.gridMMA080);
    int colIndex = InforGrid.getColumnIndexByname(colHeaderName);
    List<String> cells = InforGrid.getDataOfRowContainingTextInColumn((colIndex + 1), value);
    return cells;
  }
}
