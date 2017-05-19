package bi3.pages.cas310;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class CAS310B1 extends BasePage {
  public CAS310B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWQTTP-shdo")
  private WebElement cmbSortingOrder;
  
  @FindBy(id = "list-option1")
  private List<WebElement> listSortingOrder;
  
  @FindBy(id = "WGFACI")
  private WebElement txtFacility;
  
  @FindBy(id = "W2RIDN")
  private WebElement txtMONumber;
  
  @FindBy(css = "div[id*=\'CAA310BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  public void setSortingOrder(final String value) {
    try {
      BasePage.waitForLoadingComplete();
      Thread.sleep(3000);
      this.selectFromDropdown(this.cmbSortingOrder, this.listSortingOrder, value);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void FillFacility(final String Division) {
    BasePage.waitForLoadingComplete();
    this.txtFacility.sendKeys(Division);
  }
  
  public void searchMONumber(final String CONumber) {
    BasePage.waitForLoadingComplete();
    this.txtMONumber.click();
    BasePage.clearRobustly(this.txtMONumber);
    WebDriverExtensions.waitToBeDisplayed(this.txtMONumber);
    this.txtMONumber.sendKeys(CONumber);
    this.txtMONumber.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public List<String> GetStatuses(final String Sno) {
    try {
      BasePage.waitForLoadingComplete();
      Thread.sleep(3000);
      InforGrid grid = new InforGrid(this.gridElement);
      List<String> data = grid.getDataOfRowContainingTextInColumn(8, Sno);
      ArrayList<String> newList = new ArrayList<String>();
      newList.add(0, data.get(8).toString());
      return newList;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
