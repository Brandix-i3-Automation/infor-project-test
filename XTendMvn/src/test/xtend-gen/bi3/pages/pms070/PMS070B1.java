package bi3.pages.pms070;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@SuppressWarnings("all")
public class PMS070B1 extends BasePage {
  public PMS070B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'PMA070BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(xpath = "//a/span[text()=\'Change\']")
  private WebElement linkChange;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[text()=\'Confirmation\']")
  private WebElement linkConfirmation;
  
  @FindBy(css = "#WOSCHN+button")
  private WebElement btnSchedNoLookUp;
  
  @FindBy(id = "POS")
  private WebElement txtLookUpSearch;
  
  @FindBy(css = "div[row=\'0\']>div[class=\'slick-cell l0 r0\']")
  private WebElement firstCellLookUpGrid;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelectLookUpGrid;
  
  @FindBy(css = "div[row=\'0\']>div")
  private WebElement firstGridCell;
  
  @FindBy(id = "RelatedBtn")
  private WebElement btnRealted;
  
  @FindBy(xpath = "//*[contains(text(),\'Confirmation\')]/span")
  private WebElement btnConfirmation;
  
  @FindBy(css = "#tabsList > li.ui-tabs-selected.ui-state-active > button")
  private WebElement btnClose;
  
  @FindBy(xpath = "//ul[contains(@id,\'relOptsmenu_\')]//a/span[contains(text(),\'Close Operation\')]")
  private WebElement btnCloseOperation;
  
  @FindBy(xpath = "//ul[contains(@id,\'menu_\')]//li/a[contains(text(),\'Related\')]")
  private WebElement btnRealtedToCloseOperation;
  
  public void ClosePage() {
    this.btnClose.click();
    System.out.println("PMS230 tab closed");
  }
  
  public void SelectAllRows() {
    BasePage.waitForLoadingComplete();
    this.firstGridCell.click();
    BasePage.SelectAllGridRows(this.firstGridCell);
  }
  
  public void ConfirmationRecord(final int rowId) {
    InforGrid grid = new InforGrid(this.gridElement);
    WebElement row = grid.getRow(rowId);
    WebDriverExtensions.waitToBeClickable(row);
    this.rightClick(row);
    WebDriverExtensions.waitToBeClickable(this.btnRealted);
    this.btnRealted.click();
    this.btnConfirmation.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void goToChangeOfGridRow(final int gridRowNumber) {
    InforGrid grid = new InforGrid(this.gridElement);
    WebElement row = grid.getRow(gridRowNumber);
    WebDriverExtensions.waitToBeClickable(row);
    this.rightClick(row);
    this.linkChange.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void confirmGridRow(final int gridRowNumber) {
    InforGrid grid = new InforGrid(this.gridElement);
    WebElement row = grid.getRow(gridRowNumber);
    WebDriverExtensions.waitToBeClickable(row);
    this.rightClick(row);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkConfirmation);
    this.linkConfirmation.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String getStatusOfGridRow(final int gridRow) {
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> row = grid.getCellsFromRow(gridRow);
    return row.get(7).getText();
  }
  
  public void setSchedNumberFromLookUp(final String schedNo) {
    WebDriverExtensions.waitToBeClickable(this.btnSchedNoLookUp);
    this.btnSchedNoLookUp.click();
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtLookUpSearch);
    this.txtLookUpSearch.click();
    BasePage.clearRobustly(this.txtLookUpSearch);
    this.txtLookUpSearch.sendKeys(schedNo);
    this.txtLookUpSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    boolean _equals = this.firstCellLookUpGrid.getText().equals(schedNo);
    if (_equals) {
      this.firstCellLookUpGrid.click();
      this.btnSelectLookUpGrid.click();
    } else {
      Assert.fail((("Schedule Number " + schedNo) + " could not be found on the look up grid"));
    }
  }
  
  public void closeOperationsWithStatus80() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.firstGridCell);
    WebDriverExtensions.waitToBeClickable(this.btnRealtedToCloseOperation);
    this.btnRealtedToCloseOperation.click();
    BasePage.waitForLoadingComplete();
    this.btnCloseOperation.click();
    BasePage.waitForLoadingComplete();
  }
}
