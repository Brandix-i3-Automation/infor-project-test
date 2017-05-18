package bi3.pages.pps170;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import com.google.common.base.Objects;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS170B extends BasePage {
  public PPS170B(final WebDriver driver) {
    super(driver);
  }
  
  /**
   * PAGE OBJECTS
   */
  @FindBy(id = "WWQTTP-shdo")
  private WebElement cmbSortingOrder;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listSortingOrder;
  
  @FindBy(id = "WOPAVR-shdo")
  private WebElement cmbView;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listView;
  
  @FindBy(id = "W1OBKV")
  private WebElement txtBoxbuyer;
  
  @FindBy(id = "W3OBKV")
  private WebElement txtWhs;
  
  @FindBy(id = "W2OBKV")
  private WebElement txtSupplier;
  
  @FindBy(id = "W4OBKV")
  private WebElement txtItemNumber;
  
  @FindBy(css = "div[id*=\'PPA170BS\'][class*=\'inforDataGrid\']")
  private WebElement gridPPS170;
  
  /**
   * ACTIONS
   */
  public void fillHeaderInformation() {
    WebDriverExtensions.selectFromDropdown(this.cmbSortingOrder, "1-Buy,Sup,Whs,Ite");
  }
  
  public void fillTableHeaderInformation(final String buyer, final String supplier, final String whs, final String itemNo) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridPPS170);
    grid.setValueToColumnSearchField("Buyer", buyer);
    grid.setValueToColumnSearchField("Supplier", supplier);
    grid.setValueToColumnSearchField("Whs", whs);
    grid.setValueToColumnSearchField("Item number", itemNo).sendKeys(Keys.ENTER);
  }
  
  /**
   * Set filter options
   */
  public void setFilterOptions(final String sortingOrder, final String view) {
    BasePage.waitForLoadingComplete();
    boolean _notEquals = (!Objects.equal(sortingOrder, ""));
    if (_notEquals) {
      this.selectFromDropdown(this.cmbSortingOrder, this.listSortingOrder, sortingOrder);
      BasePage.waitForLoadingComplete();
    }
    boolean _notEquals_1 = (!Objects.equal(view, ""));
    if (_notEquals_1) {
      this.selectFromDropdown(this.cmbView, this.listView, view);
      BasePage.waitForLoadingComplete();
    }
  }
  
  /**
   * Release purchase order
   */
  public void releaseLine(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridPPS170);
    WebElement matchingCell = grid.getCell("Item number", itemNumber);
    this.rightClick(matchingCell, Boolean.valueOf(true), "Release Line");
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * Check whether POP exist in PPS170
   */
  public List<String> getItemNumberFromGrid() {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridPPS170);
    List<String> dataList = grid.getDataOfColumn("Item number");
    BasePage.waitForLoadingComplete();
    System.out.println(dataList);
    return dataList;
  }
}
