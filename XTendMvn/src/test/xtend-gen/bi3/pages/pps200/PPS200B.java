package bi3.pages.pps200;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS200B extends BasePage {
  public PPS200B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1OBKV")
  private WebElement txtPONo;
  
  @FindBy(css = "div[id*=\'PPA200BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(xpath = "//a/span[text()=\'Copy\']")
  private WebElement linkCopy;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[text()=\'Lines\']")
  private WebElement linkLines;
  
  public boolean SearchPONo(final String po) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtPONo);
    this.txtPONo.click();
    BasePage.clearRobustly(this.txtPONo);
    this.txtPONo.sendKeys(po);
    this.txtPONo.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> row = grid.getCellsFromRow(0);
    boolean _equals = row.get(0).getText().equals(po);
    if (_equals) {
      return true;
    } else {
      return false;
    }
  }
  
  public void copyPO(final String po) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    WebElement row = grid.getRowContainingTextInColumn(1, po);
    WebDriverExtensions.waitToBeClickable(row);
    this.rightClick(row);
    WebDriverExtensions.waitToBeClickable(this.linkCopy);
    this.linkCopy.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String GetLstOfRecordWithPO(final String po) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    List<String> rowData = grid.getDataOfRowContainingTextInColumn(1, po);
    return rowData.get(1);
  }
  
  public void GoToLinesOfRecordWithPO(final String po) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    WebElement row = grid.getRowContainingTextInColumn(1, po);
    WebDriverExtensions.waitToBeClickable(row);
    this.rightClick(row);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkLines);
    this.linkLines.click();
  }
}
