package bi3.pages.pps390;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS390B1 extends BasePage {
  public PPS390B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'PPA390BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElementReturnToSupplier;
  
  @FindBy(css = ".inforIconButton.refresh")
  private WebElement btnRefresh;
  
  @FindBy(id = "WWQTTP-shdo")
  private WebElement btnFilterDropdown;
  
  @FindBy(css = "#dropdown-list>li")
  private List<WebElement> listFilterOptions;
  
  @FindBy(id = "W1CLRE")
  private WebElement txtOurRef;
  
  @FindBy(id = "W1WHLO")
  private WebElement txtWhs;
  
  @FindBy(id = "W1CLAN")
  private WebElement txtRno;
  
  /**
   * Select last row.
   */
  public void selectLastRow() {
    InforGrid grid = new InforGrid(this.gridElementReturnToSupplier);
    List<WebElement> rows = grid.getAllRows();
    IterableExtensions.<WebElement>last(rows).click();
  }
  
  /**
   * Get column value using column header name and row index.
   */
  public String getColumnVal(final String colHeaderName) {
    InforGrid grid = new InforGrid(this.gridElementReturnToSupplier);
    return grid.getColumnValByColumnHeader(colHeaderName, 0);
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
   * Change the grid sorting order.
   */
  public void changeSortingOrder(final String stat) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.btnFilterDropdown, this.listFilterOptions, stat);
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * Filter the grid.
   */
  public void filterGrid(final String ourRef, final String whs, final String rno) {
    BasePage.waitForLoadingComplete();
    this.txtOurRef.sendKeys(ourRef);
    this.txtOurRef.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    this.txtWhs.sendKeys(whs);
    this.txtWhs.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    this.txtRno.sendKeys(rno);
    this.txtRno.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
}
