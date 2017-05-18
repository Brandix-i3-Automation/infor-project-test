package bi3.pages.mms100;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS100B extends BasePage {
  public MMS100B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1TRNR")
  private WebElement txtOrdNum;
  
  @FindBy(css = "div[id*=\'MMA100BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[text()=\'DO/RO Toolbox\']")
  private WebElement linkDOROToolbox;
  
  @FindBy(id = "WWQTTP-shdo")
  private WebElement cmbSortingOrder;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listCmbSortingOrder;
  
  /**
   * Select sorting order drop down.
   */
  public void selectSortingOrder(final String cmbLable) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbSortingOrder, this.listCmbSortingOrder, cmbLable);
    BasePage.waitForLoadingComplete();
  }
  
  public void searchOrderNum(final String ordNum) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtOrdNum);
    this.txtOrdNum.click();
    BasePage.clearRobustly(this.txtOrdNum);
    this.txtOrdNum.sendKeys(ordNum);
    this.txtOrdNum.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void goToDOROToolbox(final String ordNum) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> cells = grid.getRowsContainingTextInColumn(1, ordNum);
    WebDriverExtensions.waitToBeClickable(cells.get(0));
    this.rightClick(cells.get(0));
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkDOROToolbox);
    this.linkDOROToolbox.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String GetLwsOfOrder(final String ordNum) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> rows = grid.getRowsContainingTextInColumn(1, ordNum);
    List<WebElement> row = grid.getCellsFromRow(rows.get(0));
    return row.get(10).getText();
  }
  
  public String GetHisOfOrder(final String ordNum) {
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> rows = grid.getRowsContainingTextInColumn(1, ordNum);
    List<WebElement> row = grid.getCellsFromRow(rows.get(0));
    return row.get(11).getText();
  }
}
