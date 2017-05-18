package bi3.pages.mws460;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MWS460B extends BasePage {
  public MWS460B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWQTTP-shdo")
  private WebElement btnSortingSelect;
  
  @FindBy(css = "#dropdown-list>li")
  private List<WebElement> listSortingOptions;
  
  @FindBy(id = "W1OBKV")
  private WebElement txtWarehouse;
  
  @FindBy(id = "W2OBKV")
  private WebElement txtItemNumber;
  
  @FindBy(css = "div[id*=\'MWA460BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[text()=\'Process\']")
  private WebElement linkProcess;
  
  @FindBy(css = ".errorMessage.inforLabel.noColon")
  private WebElement lblFooterMessage;
  
  @FindBy(css = ".inforIconButton.refresh")
  private WebElement btnRefresh;
  
  public void selectSortingOrder(final String sorting) {
    this.selectFromDropdown(this.btnSortingSelect, this.listSortingOptions, sorting);
  }
  
  public void setWarehouse(final String warehouse) {
    try {
      WebDriverExtensions.waitToBeClickable(this.txtWarehouse);
      this.txtWarehouse.click();
      BasePage.clearRobustly(this.txtWarehouse);
      this.txtWarehouse.sendKeys(warehouse);
      this.txtWarehouse.sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
    } catch (final Throwable _t) {
      if (_t instanceof ElementNotFoundException) {
        final ElementNotFoundException n = (ElementNotFoundException)_t;
        this.selectSortingOrder("30-Item,Acquis ord");
        this.setWarehouse(warehouse);
      } else if (_t instanceof ElementNotVisibleException) {
        final ElementNotVisibleException n_1 = (ElementNotVisibleException)_t;
        this.selectSortingOrder("30-Item,Acquis ord");
        this.setWarehouse(warehouse);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void setItemNumber(final String itemNumber) {
    try {
      WebDriverExtensions.waitToBeClickable(this.txtItemNumber);
      this.txtItemNumber.click();
      BasePage.clearRobustly(this.txtItemNumber);
      this.txtItemNumber.sendKeys(itemNumber);
      this.txtItemNumber.sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
    } catch (final Throwable _t) {
      if (_t instanceof ElementNotFoundException) {
        final ElementNotFoundException n = (ElementNotFoundException)_t;
        this.selectSortingOrder("30-Item,Acquis ord");
        this.setItemNumber(itemNumber);
      } else if (_t instanceof ElementNotVisibleException) {
        final ElementNotVisibleException n_1 = (ElementNotVisibleException)_t;
        this.selectSortingOrder("30-Item,Acquis ord");
        this.setItemNumber(itemNumber);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void processGridRow(final int recordNum) {
    InforGrid grid = new InforGrid(this.gridElement);
    WebElement row = grid.getRow(recordNum);
    this.rightClick(row);
    this.linkRelated.click();
    this.linkProcess.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String getFooterMessage() {
    return this.lblFooterMessage.getText();
  }
  
  public boolean checkRecordExists(final String itemNumber) {
    try {
      this.setItemNumber(itemNumber);
      InforGrid grid = new InforGrid(this.gridElement);
      List<String> row = grid.getDataOfRow(0);
      String _get = row.get(1);
      String _plus = ("Row 1 item : " + _get);
      System.out.println(_plus);
      boolean _contains = row.get(1).contains(itemNumber);
      if (_contains) {
        return true;
      } else {
        return false;
      }
    } catch (final Throwable _t) {
      if (_t instanceof ElementNotFoundException) {
        final ElementNotFoundException e = (ElementNotFoundException)_t;
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void refreshPage(final int reloadAfterTimeout) {
    try {
      Thread.sleep(reloadAfterTimeout);
      WebDriverExtensions.waitToBeClickable(this.btnRefresh);
      this.btnRefresh.click();
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
