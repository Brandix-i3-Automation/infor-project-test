package bi3.pages.pps250;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS250B1 extends BasePage {
  public PPS250B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWPUNO")
  private WebElement txtPoNumber;
  
  @FindBy(css = "button[id*=\'XT\']")
  private WebElement btnApply;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[text()=\'Confirmation\']")
  private WebElement linkConfirmation;
  
  @FindBy(css = "div[id*=\'PPA250BS\'][class*=\'inforDataGrid\']")
  private WebElement inforGrid;
  
  public void enterPoNumber(final String PoNumber) {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtPoNumber);
    this.txtPoNumber.sendKeys(PoNumber);
    this.btnApply.click();
  }
  
  public void clickConfirmation(final String newRawMaterialNumber) {
    BasePage.waitForLoadingComplete();
    InforGrid inforGridPPS250 = new InforGrid(this.inforGrid);
    WebElement matchingElement = inforGridPPS250.getRowContainingTextInColumn(3, newRawMaterialNumber);
    InputOutput.<String>println(("WEbELement " + matchingElement));
    this.rightClick(matchingElement);
    BasePage.clickWhenReady(this.linkRelated);
    WebDriverExtensions.waitToBeClickable(this.linkConfirmation);
    this.linkConfirmation.click();
  }
  
  public String checkStatus(final String newRawMaterialNumber) {
    BasePage.waitForLoadingComplete();
    InforGrid inforGridPPS250 = new InforGrid(this.inforGrid);
    WebElement row = inforGridPPS250.getRowContainingTextInColumn(3, newRawMaterialNumber);
    InputOutput.<String>println(("WebElement of Row " + row));
    List<WebElement> cells = inforGridPPS250.getCellsFromRow(row);
    InputOutput.<String>println(("Cell List  " + cells));
    String status = cells.get(10).getText();
    InputOutput.<String>println(("Status is " + status));
    return status;
  }
}
