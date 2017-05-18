package bi3.pages.ois100;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS100FANDB extends BasePage {
  public OIS100FANDB(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(xpath = "//div[@class=\'gvWidgetHeader\']/span[contains(text(),\'Menu\')]")
  private WebElement headerMenu;
  
  @FindBy(css = "input.inforSearchField")
  private WebElement txtSearch;
  
  @FindBy(xpath = "//div[@class=\'gvWidgetHeader\']/span[contains(text(),\'Menu\')]/../..//div[@class=\'gvFillAbsolute\']//li")
  private WebElement MenuWidgetOptions;
  
  @FindBy(css = "#ActionsBtn")
  private WebElement btnActions;
  
  @FindBy(css = "#WDPAVRContainer>button")
  private WebElement btnView;
  
  @FindBy(id = "#POS")
  private WebElement txtPOS;
  
  @FindBy(css = "#OACUNOContainer > button")
  private WebElement btnCustomer;
  
  @FindBy(css = "#OAORTPContainer > button")
  private WebElement btnCOtype;
  
  @FindBy(css = "input[hlp=\'OIS10004\']")
  private WebElement txtReqDeliveryDate;
  
  @FindBy(css = "div[class=\'slick-headerrow-column l0 r0\']>input")
  private WebElement gridSearchKey;
  
  @FindBy(css = ".slick-cell.l0.r0.uppercase")
  private WebElement firstGridCell;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(id = "dbtnok")
  private WebElement btnOK_PopUp;
  
  @FindBy(id = "dbtnok")
  private WebElement btnOk;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "div[id*=\'BROWSE_LIST\'][class*=\'inforDataGrid\']")
  private WebElement gridOIS100A;
  
  @FindBy(css = "#OAORNO")
  private WebElement txtCOno;
  
  @FindBy(css = "#OACUNO")
  private WebElement txtCustomer;
  
  public String GoToOIS100() {
    String _xblockexpression = null;
    {
      WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
      this.headerMenu.click();
      WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
      this.txtSearch.click();
      this.txtSearch.sendKeys("OIS100");
      this.txtSearch.sendKeys(Keys.ENTER);
      _xblockexpression = InputOutput.<String>println("OIS100 Done");
    }
    return _xblockexpression;
  }
  
  public String getCONumber() {
    WebDriverExtensions.waitToBeDisplayed(this.txtCOno);
    return this.txtCOno.getText();
  }
  
  public void clickNext() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void clearCOno() {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtCOno);
  }
  
  public void clearCustomer() {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtCustomer);
    BasePage.waitForLoadingComplete();
  }
  
  public void fillCustomer(final String customer) {
    try {
      this.btnCustomer.click();
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeDisplayed(this.gridSearchKey);
      WebDriverExtensions.waitToBeClickable(this.gridSearchKey);
      try {
        this.gridSearchKey.click();
      } catch (final Throwable _t) {
        if (_t instanceof StaleElementReferenceException) {
          final StaleElementReferenceException ex = (StaleElementReferenceException)_t;
          Thread.sleep(2000);
          BasePage.waitForLoadingComplete();
          WebDriverExtensions.waitToBeDisplayed(this.gridSearchKey);
          WebDriverExtensions.waitToBeClickable(this.gridSearchKey);
          this.gridSearchKey.click();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      BasePage.clearRobustly(this.gridSearchKey);
      try {
        this.gridSearchKey.sendKeys(customer);
      } catch (final Throwable _t_1) {
        if (_t_1 instanceof StaleElementReferenceException) {
          final StaleElementReferenceException ex_1 = (StaleElementReferenceException)_t_1;
          Thread.sleep(2000);
          BasePage.waitForLoadingComplete();
          BasePage.clearRobustly(this.gridSearchKey);
          this.gridSearchKey.sendKeys(customer);
        } else {
          throw Exceptions.sneakyThrow(_t_1);
        }
      }
      this.gridSearchKey.sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
      Thread.sleep(2000);
      InforGrid inforGrid = new InforGrid(this.gridOIS100A);
      WebElement matchingCell = inforGrid.getCell("Customer", customer);
      boolean _isDisplayed = matchingCell.isDisplayed();
      if (_isDisplayed) {
        matchingCell.click();
        this.btnSelect.click();
      } else {
        System.out.println((("Customer " + customer) + " not found."));
      }
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void fillCOType(final String COType) {
    try {
      this.btnCOtype.click();
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeDisplayed(this.gridSearchKey);
      WebDriverExtensions.waitToBeClickable(this.gridSearchKey);
      try {
        this.gridSearchKey.click();
      } catch (final Throwable _t) {
        if (_t instanceof StaleElementReferenceException) {
          final StaleElementReferenceException ex = (StaleElementReferenceException)_t;
          Thread.sleep(2000);
          BasePage.waitForLoadingComplete();
          WebDriverExtensions.waitToBeDisplayed(this.gridSearchKey);
          WebDriverExtensions.waitToBeClickable(this.gridSearchKey);
          this.gridSearchKey.click();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      BasePage.clearRobustly(this.gridSearchKey);
      try {
        this.gridSearchKey.sendKeys(COType);
      } catch (final Throwable _t_1) {
        if (_t_1 instanceof StaleElementReferenceException) {
          final StaleElementReferenceException ex_1 = (StaleElementReferenceException)_t_1;
          Thread.sleep(2000);
          BasePage.waitForLoadingComplete();
          BasePage.clearRobustly(this.gridSearchKey);
          this.gridSearchKey.sendKeys(COType);
        } else {
          throw Exceptions.sneakyThrow(_t_1);
        }
      }
      this.gridSearchKey.sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
      Thread.sleep(2000);
      InforGrid inforGrid = new InforGrid(this.gridOIS100A);
      WebElement matchingCell = inforGrid.getCell("Otp", COType);
      boolean _isDisplayed = matchingCell.isDisplayed();
      if (_isDisplayed) {
        matchingCell.click();
        this.btnSelect.click();
      } else {
        System.out.println((("CO Type " + COType) + " not found."));
      }
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void fillReqDeliveryDate(final String Date) {
    BasePage.clearRobustly(this.txtReqDeliveryDate);
    this.txtReqDeliveryDate.sendKeys(Date);
  }
}
