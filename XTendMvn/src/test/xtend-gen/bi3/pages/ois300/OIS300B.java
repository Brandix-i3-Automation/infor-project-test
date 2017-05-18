package bi3.pages.ois300;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS300B extends BasePage {
  public OIS300B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W4OBKV")
  private WebElement txtCONumber;
  
  @FindBy(id = "WWQTTP-shdo")
  private WebElement cmbSortingOrder;
  
  @FindBy(id = "list-option0")
  private List<WebElement> listSortingOrder;
  
  @FindBy(css = "div[id*=\'OIA300BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  public void searchCONumber(final String CONumber) {
    BasePage.waitForLoadingComplete();
    this.txtCONumber.click();
    BasePage.clearRobustly(this.txtCONumber);
    WebDriverExtensions.waitToBeDisplayed(this.txtCONumber);
    this.txtCONumber.sendKeys(CONumber);
    this.txtCONumber.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void setSortingOrder(final String value) {
    try {
      BasePage.waitForLoadingComplete();
      Thread.sleep(3000);
      this.selectFromDropdown(this.cmbSortingOrder, this.listSortingOrder, value);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getFirstRowStatus() {
    Object _xblockexpression = null;
    {
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeDisplayed(this.gridElement);
      Object _xtrycatchfinallyexpression = null;
      try {
        InforGrid grid = new InforGrid(this.gridElement);
        List<WebElement> status = grid.getCellsFromColumn(8);
        return status.get(0).getText();
      } catch (final Throwable _t) {
        if (_t instanceof StaleElementReferenceException) {
          final StaleElementReferenceException ex = (StaleElementReferenceException)_t;
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return ((String)_xblockexpression);
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
