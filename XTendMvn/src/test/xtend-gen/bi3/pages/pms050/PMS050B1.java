package bi3.pages.pms050;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS050B1 extends BasePage {
  public PMS050B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'PMA050BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(css = ".inforIconButton.refresh")
  private WebElement btnRefresh;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement firstGridCell;
  
  @FindBy(id = "RelatedBtn")
  private WebElement btnRealted;
  
  @FindBy(xpath = "//*[contains(text(),\'Confirmation\')]/span/..")
  private WebElement btnConfirmation;
  
  @FindBy(xpath = "//a/span[text()=\'Change\']")
  private WebElement linkChange;
  
  public void Confirmation() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.btnRealted);
    this.btnRealted.click();
    WebDriverExtensions.waitToBeClickable(this.btnConfirmation);
    this.btnConfirmation.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void SelectAllRows() {
    BasePage.waitForLoadingComplete();
    this.firstGridCell.click();
    BasePage.SelectAllGridRows(this.firstGridCell);
    BasePage.waitForLoadingComplete();
  }
  
  public String getStatusOfGridRow(final int gridRow) {
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> row = grid.getCellsFromRow(gridRow);
    return row.get(7).getText();
  }
  
  public void refreshPage() {
    WebDriverExtensions.waitToBeClickable(this.btnRefresh);
    this.btnRefresh.click();
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
}
