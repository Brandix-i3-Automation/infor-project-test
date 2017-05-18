package bi3.pages.crs207;

import bi3.framework.core.DefaultWebDriver;
import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class CRS207_B extends BasePage {
  public CRS207_B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div.slick-viewport.slick-viewport-top.slick-viewport-left div.edit-cell")
  private List<WebElement> listTxtDescription;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "div[id*=\'CRA207BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(id = "dbtnok")
  private WebElement btnOk;
  
  public void EnterDescriptionGrid(final String qty) {
    InforGrid grid = new InforGrid(this.gridElement);
    final WebElement row = grid.getRowContainingTextInColumn(1, "Black");
    System.out.println(row);
    final List<WebElement> cells = grid.getCellsFromRow(row);
    System.out.println(cells.size());
    System.out.println(cells.get(1).getText());
    cells.get(1).click();
    cells.get(1).findElement(By.cssSelector("input")).sendKeys(qty);
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void searchBySchedule() {
    InforGrid grid = new InforGrid(this.gridElement);
    this.rightClick(grid.getCell("Sched no", "131300"));
    this.rightClick(grid.getCell(0, "131300"));
    grid.setValueToColumnSearchField("", "");
  }
  
  public void fillMatrix(final String qty) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    final WebElement rowBlack = grid.getRowContainingTextInColumn(1, "Black");
    final List<WebElement> cellsBlack = grid.getCellsFromRow(rowBlack);
    cellsBlack.get(3).click();
    BasePage.waitForLoadingComplete();
    cellsBlack.get(3).findElement(By.cssSelector("input")).sendKeys(qty);
  }
  
  public void handleWarning() {
    BasePage.waitForLoadingComplete();
    this.btnOk.click();
  }
  
  public void handleAbnormalException() {
    try {
      BasePage.waitForLoadingComplete();
      DefaultWebDriver.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      while (this.btnOk.isDisplayed()) {
        {
          BasePage.clickWhenReady(this.btnOk);
          BasePage.waitForLoadingComplete();
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      DefaultWebDriver.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
  }
}
