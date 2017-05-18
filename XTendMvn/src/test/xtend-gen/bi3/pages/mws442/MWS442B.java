package bi3.pages.mws442;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MWS442B extends BasePage {
  public MWS442B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'MWA442BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[text()=\'Report DO/RO Receipt\']")
  private WebElement linkDOROReceipt;
  
  public void goToDOROReceiptOfRow(final int rowId) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> cells = grid.getCellsFromRow(rowId);
    WebDriverExtensions.waitToBeClickable(cells.get(0));
    this.rightClick(cells.get(0));
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkDOROReceipt);
    this.linkDOROReceipt.click();
    BasePage.waitForLoadingComplete();
  }
}
