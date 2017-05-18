package bi3.pages.mws420;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MWS420B extends BasePage {
  public MWS420B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement firstCell;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a//*[contains(text(), \'Confirm Issues\')]")
  private WebElement linkConfirmIssues;
  
  @FindBy(css = "div[id*=\'MWA420BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  public void ConfirmIssues() {
    WebDriverExtensions.waitToBeClickable(this.firstCell);
    this.rightClick(this.firstCell);
    this.linkRelated.click();
    this.linkConfirmIssues.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String getPiSOfRow(final int rowId) {
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> cells = grid.getCellsFromRow(0);
    return cells.get(1).getText();
  }
}
