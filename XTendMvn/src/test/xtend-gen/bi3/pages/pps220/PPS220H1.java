package bi3.pages.pps220;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS220H1 extends BasePage {
  public PPS220H1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'PPA220HS\'][class*=\'inforDataGrid\']")
  private WebElement gridPPS220H1;
  
  @FindBy(xpath = "//a[text()=\'Confirm Update\']")
  private WebElement linkConfirmUpdate;
  
  public void fillDelyNote(final String DelyNote) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridPPS220H1);
    List<WebElement> cellElementList = grid.getCellsFromRow(0);
    WebElement cellDelyNote = cellElementList.get(10);
    WebDriverExtensions.waitToBeClickable(cellDelyNote);
    cellDelyNote.click();
    WebElement inputDelyNote = cellDelyNote.findElement(By.id("R1C11"));
    BasePage.clearRobustly(inputDelyNote);
    inputDelyNote.sendKeys(DelyNote);
  }
  
  public void fillPackageNo(final String Package) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridPPS220H1);
    List<WebElement> cellElementList = grid.getCellsFromRow(0);
    WebElement cellPackageNo = cellElementList.get(16);
    WebDriverExtensions.waitToBeClickable(cellPackageNo);
    cellPackageNo.click();
    WebElement inputPackageNo = cellPackageNo.findElement(By.id("R1C17"));
    BasePage.clearRobustly(inputPackageNo);
    inputPackageNo.sendKeys(Package);
  }
  
  public void fillSSCCNumber(final String SSCC) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridPPS220H1);
    List<WebElement> cellElementList = grid.getCellsFromRow(0);
    WebElement cellSSCCNo = cellElementList.get(19);
    WebDriverExtensions.waitToBeClickable(cellSSCCNo);
    cellSSCCNo.click();
    WebElement inputSSCCNo = cellSSCCNo.findElement(By.id("R1C20"));
    BasePage.clearRobustly(inputSSCCNo);
    inputSSCCNo.sendKeys(SSCC);
  }
  
  public void clickConfirmUpdate() {
    WebDriverExtensions.waitToBeDisplayed(this.linkConfirmUpdate);
    WebDriverExtensions.waitToBeClickable(this.linkConfirmUpdate);
    this.linkConfirmUpdate.click();
  }
}
