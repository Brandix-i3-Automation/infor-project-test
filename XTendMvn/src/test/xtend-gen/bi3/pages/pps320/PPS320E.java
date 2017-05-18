package bi3.pages.pps320;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@SuppressWarnings("all")
public class PPS320E extends BasePage {
  public PPS320E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWCAQA")
  private WebElement txtApprovedQty;
  
  @FindBy(id = "WWRVQA")
  private WebElement txtRecvdQty;
  
  @FindBy(id = "WBRPQA")
  private WebElement txtStoredQty;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "#pRow18>div:nth-child(1)>div>button")
  private WebElement btnLocationLookUp;
  
  @FindBy(id = "POS")
  private WebElement txtLookUpSearch;
  
  @FindBy(css = "div[id*=\'BROWSE_LIST\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(id = "WLWHSL")
  private WebElement txtLocation;
  
  public void enterStoredQty() {
    BasePage.waitForLoadingComplete();
    this.txtStoredQty.sendKeys(BasePage.GetTextBoxvalue(this.txtApprovedQty));
  }
  
  public void Next() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void SetLocationFromText(final String location) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtLocation);
    this.txtLocation.click();
    BasePage.clearRobustly(this.txtLocation);
    this.txtLocation.sendKeys(location);
  }
  
  public void SetLocationFromLookUp(final String location) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.btnLocationLookUp);
    this.btnLocationLookUp.click();
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtLookUpSearch);
    this.txtLookUpSearch.click();
    BasePage.clearRobustly(this.txtLookUpSearch);
    this.txtLookUpSearch.sendKeys(location);
    this.txtLookUpSearch.sendKeys(Keys.ENTER);
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> row = grid.getCellsFromRow(0);
    boolean _equals = row.get(0).getText().equals(location);
    if (_equals) {
      WebDriverExtensions.waitToBeDisplayed(row.get(0));
      WebDriverExtensions.waitToBeClickable(row.get(0));
      row.get(0).click();
      this.btnSelect.click();
      BasePage.waitForLoadingComplete();
    } else {
      String _text = row.get(0).getText();
      String _plus = ("Location look up first cell :" + _text);
      String _plus_1 = (_plus + " not equal to ");
      String _plus_2 = (_plus_1 + location);
      System.out.println(_plus_2);
      Assert.fail((("Location " + location) + " was not found in PPS320E location lookup"));
    }
  }
  
  public void EnterStoredQtyAsRecieved() {
    BasePage.waitForLoadingComplete();
    this.txtStoredQty.sendKeys(BasePage.GetTextBoxvalue(this.txtRecvdQty));
  }
}
