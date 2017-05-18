package bi3.pages.pps390;

import bi3.framework.core.DefaultWebDriver;
import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import bi3.pages.ToolbarPage;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS390B extends BasePage {
  public PPS390B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'PPA390BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[text()=\'Lines\']")
  private WebElement linkLines;
  
  @FindBy(id = "WWQTTP-shdo")
  private WebElement btnOrderSelect;
  
  @FindBy(css = "#dropdown-list>li")
  private List<WebElement> listOrderOptions;
  
  @FindBy(id = "W5FACI")
  private WebElement txtFac;
  
  @FindBy(id = "W5WHLO")
  private WebElement txtWarehouse;
  
  @FindBy(id = "W5PUNO")
  private WebElement txtPO;
  
  public void GoToRelatedLinesOfPO(final String po) {
    InforGrid grid = new InforGrid(this.gridElement);
    WebElement row = grid.getRowContainingTextInColumn(7, po);
    WebDriverExtensions.waitToBeClickable(row);
    this.rightClick(row);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkLines);
    this.linkLines.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void ChangeRecordWithPO(final String po) {
    InforGrid grid = new InforGrid(this.gridElement);
    WebElement row = grid.getRowContainingTextInColumn(3, po);
    WebDriverExtensions.waitToBeClickable(row);
    row.click();
    ToolbarPage toolbar = new ToolbarPage(DefaultWebDriver.driver);
    toolbar.clickChangeLogo();
  }
  
  public void SelectSortingOrder(final String sorting) {
    this.selectFromDropdown(this.btnOrderSelect, this.listOrderOptions, sorting);
    BasePage.waitForLoadingComplete();
  }
  
  public void SearchBy(final String po, final String fac, final String warehouse) {
    WebDriverExtensions.waitToBeClickable(this.txtFac);
    this.txtFac.click();
    BasePage.clearRobustly(this.txtFac);
    this.txtFac.sendKeys(fac);
    WebDriverExtensions.waitToBeClickable(this.txtWarehouse);
    this.txtWarehouse.click();
    BasePage.clearRobustly(this.txtWarehouse);
    this.txtWarehouse.sendKeys(warehouse);
    WebDriverExtensions.waitToBeClickable(this.txtPO);
    this.txtPO.click();
    BasePage.clearRobustly(this.txtPO);
    this.txtPO.sendKeys(po);
    this.txtPO.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
}
