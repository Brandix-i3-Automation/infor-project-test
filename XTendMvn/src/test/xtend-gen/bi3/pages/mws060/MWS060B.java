package bi3.pages.mws060;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MWS060B extends BasePage {
  public MWS060B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W2OBKV")
  private WebElement txtItemNum;
  
  @FindBy(css = "slick-cell.l0.r0")
  private WebElement firstGridCell;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a//*[contains(text(), \'Allocation Survey\')]")
  private WebElement linkAllocationSurvey;
  
  @FindBy(css = "div[id*=\'MWA060BS\'][class*=\'inforDataGrid\']")
  private WebElement inforGrid;
  
  public void enterItemNumber(final String item) {
    WebDriverExtensions.waitToBeClickable(this.txtItemNum);
    this.txtItemNum.click();
    BasePage.clearRobustly(this.txtItemNum);
    this.txtItemNum.sendKeys(item);
    this.txtItemNum.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void goToAllocationsurveyOfRowFirstRow() {
    WebDriverExtensions.waitToBeClickable(this.firstGridCell);
    this.rightClick(this.firstGridCell);
    WebDriverExtensions.waitToBeDisplayed(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeDisplayed(this.linkAllocationSurvey);
    this.linkAllocationSurvey.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String checkStatus(final String newRawMaterialNumber) {
    BasePage.waitForLoadingComplete();
    InforGrid inforGridMWS060B = new InforGrid(this.inforGrid);
    WebElement row = inforGridMWS060B.getRowContainingTextInColumn(2, newRawMaterialNumber);
    InputOutput.<String>println(("WebElement of Row " + row));
    List<WebElement> cells = inforGridMWS060B.getCellsFromRow(row);
    InputOutput.<String>println(("Cell List  " + cells));
    String status = cells.get(10).getText();
    InputOutput.<String>println(("Status is " + status));
    return status;
  }
}
