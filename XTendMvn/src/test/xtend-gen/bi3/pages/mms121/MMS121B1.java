package bi3.pages.mms121;

import bi3.framework.core.DefaultWebDriver;
import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS121B1 extends BasePage {
  public MMS121B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'MMA121BS\'][class*=\'inforDataGrid\']")
  private WebElement gridAllocated;
  
  public void AddAllocatedQty() {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridAllocated);
    List<WebElement> cellList = grid.getCellsFromRow(0);
    WebElement c = cellList.get(8);
    WebDriverExtensions.waitToBeClickable(c);
    c.click();
    WebElement editableCell = DefaultWebDriver.driver.findElement(By.ByCssSelector.cssSelector("#R1C9"));
    editableCell.click();
    BasePage.clearRobustly(editableCell);
    editableCell.sendKeys("+");
    editableCell.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
}
