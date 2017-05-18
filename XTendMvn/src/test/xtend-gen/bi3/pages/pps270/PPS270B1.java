package bi3.pages.pps270;

import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS270B1 extends BasePage {
  public PPS270B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWPUNO")
  private WebElement txtPoNumber;
  
  @FindBy(css = "button[id*=\'XT\']")
  private WebElement btnApply;
  
  @FindBy(xpath = "//a/span[text()=\'Change\']")
  private WebElement linkChange;
  
  @FindBy(css = "div[id*=\'PPA270BS\'][class*=\'inforDataGrid\']")
  private WebElement inforGrid;
  
  public void enterPoNumber(final String PoNumber) {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtPoNumber);
    this.txtPoNumber.sendKeys(PoNumber);
    this.btnApply.click();
  }
  
  public void goToChange() {
    BasePage.waitForLoadingComplete();
    InforGrid inforGrid = new InforGrid(this.inforGrid);
    WebElement matchingElement = inforGrid.getRow(0);
    InputOutput.<String>println(("WEbELement " + matchingElement));
    this.rightClick(matchingElement);
    BasePage.clickWhenReady(this.linkChange);
    BasePage.waitForLoadingComplete();
  }
  
  public String checkStatus(final String newRawMaterialNumber) {
    BasePage.waitForLoadingComplete();
    InforGrid inforGridPPS270 = new InforGrid(this.inforGrid);
    WebElement row = inforGridPPS270.getRowContainingTextInColumn(3, newRawMaterialNumber);
    InputOutput.<String>println(("WebElement of Row " + row));
    List<WebElement> cells = inforGridPPS270.getCellsFromRow(row);
    InputOutput.<String>println(("Cell List  " + cells));
    String status = cells.get(8).getText();
    InputOutput.<String>println(("Status is " + status));
    return status;
  }
}
