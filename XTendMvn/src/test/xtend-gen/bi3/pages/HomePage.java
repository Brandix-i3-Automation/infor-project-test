package bi3.pages;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class HomePage extends BasePage {
  public HomePage(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(linkText = "SLS - Sales Management")
  private WebElement linkServiceManagement;
  
  @FindBy(xpath = "//div[@class=\'gvWidgetHeader\']/span[contains(text(),\'Menu\')]")
  private WebElement headerMenu;
  
  @FindBy(css = "input.inforSearchField ")
  private WebElement txtSearch;
  
  @FindBy(xpath = "//div[@class=\'gvWidgetHeader\']/span[contains(text(),\'Menu\')]/../..//div[@class=\'gvFillAbsolute\']//li")
  private WebElement MenuWidgetOptions;
  
  @FindBy(css = "li[data-gv-link=\'PDS001\']")
  private WebElement linkProductStructure;
  
  @FindBy(css = "button.inforIconButton.new")
  private WebElement btnCreate;
  
  @FindBy(css = "li[data-gv-link=\'MMS077\']")
  private WebElement linkCreateItem;
  
  @FindBy(css = "li[data-gv-link=\'PMS170\']")
  private WebElement linkPlannedMo;
  
  @FindBy(css = "li[data-gv-link=\'PMS230\']")
  private WebElement linkReportMo;
  
  @FindBy(xpath = "//li[text()=\'Customer Order. Open\']")
  private WebElement linkCustomerOrder;
  
  @FindBy(xpath = "//li[text()=\'Customer Order. Open Toolbox\']")
  private WebElement linkCustomerOrderOIS300;
  
  @FindBy(css = "li[data-gv-link=\'PMS001\']")
  private WebElement linkManufactOrder;
  
  @FindBy(css = "li[data-gv-link=\'PMS100\']")
  private WebElement linkManufacturingOrder;
  
  @FindBy(css = "li[data-gv-link=\'PMS050\']")
  private WebElement linkManufactOrderReportReceipt;
  
  @FindBy(css = "li[data-gv-link=\'PPS310\']")
  private WebElement linkInspectItems;
  
  @FindBy(css = "li[data-gv-link=\'PPS320\']")
  private WebElement linkPutAwayGoods;
  
  @FindBy(css = "li[data-gv-link=\'PPS300\']")
  private WebElement linkPORecieveGoods;
  
  @FindBy(css = "li[data-gv-link=\'MMS100\']")
  private WebElement linkReqDistrOrder;
  
  @FindBy(css = "li[data-gv-link=\'PPS200\']")
  private WebElement linkPurchaseOrder;
  
  @FindBy(css = "li[data-gv-link=\'PPS390\']")
  private WebElement linkReturnToSupplier;
  
  @FindBy(css = "li[data-gv-link=\'OIS275\']")
  private WebElement linkBatchCoOrderOpen;
  
  @FindBy(css = "li[data-gv-link=\'MMS080\']")
  private WebElement linkMaterialPlan;
  
  @FindBy(css = "li[data-gv-link=\'PPS600\']")
  private WebElement linkPrintDocument;
  
  @FindBy(css = "li[data-gv-link=\'PPS250\']")
  private WebElement linkPurchaseOrderConfirm;
  
  @FindBy(css = "li[data-gv-link=\'PPS270\']")
  private WebElement linkNotifyTranspotation;
  
  @FindBy(css = "li[data-gv-link=\'PPS330\']")
  private WebElement linkPurchaseOrderDispLine;
  
  @FindBy(css = "li[data-gv-link=\'MWS060\']")
  private WebElement linkOpenToolBox;
  
  @FindBy(css = "li[data-gv-link=\'CAS310\']")
  private WebElement linkOrderCostingDisplay;
  
  @FindBy(css = "li[data-gv-link=\'OIS150\']")
  private WebElement linkCoOpen;
  
  public void GoToMMS001() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.clear();
    WebDriverExtensions.waitToBeClickable(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    WebDriverExtensions.waitToBeClickable(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("MMS001");
    this.txtSearch.sendKeys(Keys.ENTER);
  }
  
  public void GoToMMS002() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.clear();
    WebDriverExtensions.waitToBeClickable(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    WebDriverExtensions.waitToBeClickable(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("MMS002");
    this.txtSearch.sendKeys(Keys.ENTER);
  }
  
  public void GoToPDS001() {
    try {
      WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
      this.headerMenu.click();
      WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
      BasePage.waitForLoadingComplete();
      BasePage.clickWhenReady(this.txtSearch);
      BasePage.clearRobustly(this.txtSearch);
      this.txtSearch.sendKeys("PDS001");
      Thread.sleep(1000);
      this.txtSearch.sendKeys(Keys.ENTER);
      WebDriverExtensions.waitToBeClickable(this.linkProductStructure);
      this.linkProductStructure.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void GoToMMS077() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.clear();
    this.txtSearch.click();
    this.txtSearch.sendKeys("MMS077");
    WebDriverExtensions.waitToBeDisplayed(this.linkCreateItem);
    this.linkCreateItem.click();
  }
  
  public void GoToPMS170() {
    try {
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
      this.headerMenu.click();
      WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
      this.txtSearch.click();
      BasePage.clearRobustly(this.txtSearch);
      this.txtSearch.click();
      this.txtSearch.sendKeys("PMS170");
      Thread.sleep(2000);
      this.txtSearch.sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void GoToOIS300() {
    try {
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
      Thread.sleep(1000);
      this.headerMenu.click();
      WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
      this.txtSearch.clear();
      this.txtSearch.click();
      this.txtSearch.sendKeys("OIS300");
      Thread.sleep(500);
      WebDriverExtensions.waitToBeDisplayed(this.linkCustomerOrderOIS300);
      this.linkCustomerOrderOIS300.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void GoToOIS100() {
    try {
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
      this.headerMenu.click();
      WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
      BasePage.waitForLoadingComplete();
      BasePage.clickWhenReady(this.txtSearch);
      BasePage.clearRobustly(this.txtSearch);
      this.txtSearch.sendKeys("OIS100");
      Thread.sleep(1000);
      WebDriverExtensions.waitToBeClickable(this.linkCustomerOrder);
      this.linkCustomerOrder.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void GoToPMS001() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("PMS001");
    WebDriverExtensions.waitToBeDisplayed(this.linkManufactOrder);
    this.linkManufactOrder.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPMS100() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("PMS100");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPPS310() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("PPS310");
    WebDriverExtensions.waitToBeDisplayed(this.linkInspectItems);
    this.linkInspectItems.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPMS230() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("PMS230");
    WebDriverExtensions.waitToBeDisplayed(this.linkReportMo);
    this.linkReportMo.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPMS050() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("PMS050");
    WebDriverExtensions.waitToBeDisplayed(this.linkManufactOrderReportReceipt);
    this.linkManufactOrderReportReceipt.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPPS320() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("PPS320");
    WebDriverExtensions.waitToBeDisplayed(this.linkPutAwayGoods);
    try {
      this.linkPutAwayGoods.click();
    } catch (final Throwable _t) {
      if (_t instanceof NoSuchElementException) {
        final NoSuchElementException e = (NoSuchElementException)_t;
        BasePage.clearRobustly(this.txtSearch);
        this.txtSearch.sendKeys("PPS320");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPPS220() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    WebDriverExtensions.waitToBeClickable(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("PPS220");
    this.txtSearch.sendKeys(Keys.ENTER);
  }
  
  public void GoToPPS300() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("PPS300");
    try {
      WebDriverExtensions.waitToBeDisplayed(this.linkPORecieveGoods);
      this.linkPORecieveGoods.click();
      BasePage.waitForLoadingComplete();
    } catch (final Throwable _t) {
      if (_t instanceof NoSuchElementException) {
        final NoSuchElementException e = (NoSuchElementException)_t;
        this.txtSearch.click();
        BasePage.clearRobustly(this.txtSearch);
        this.txtSearch.sendKeys("PPS300");
        this.linkPORecieveGoods.click();
        BasePage.waitForLoadingComplete();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void GoToPPS330() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.clear();
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("PPS330");
    WebDriverExtensions.waitToBeClickable(this.linkPurchaseOrderDispLine);
    this.linkPurchaseOrderDispLine.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPMS070() {
    try {
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
      this.headerMenu.click();
      WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
      this.txtSearch.click();
      BasePage.clearRobustly(this.txtSearch);
      this.txtSearch.sendKeys("PMS070");
      Thread.sleep(2000);
      this.txtSearch.sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void GoToMWS060() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("MWS060");
    WebDriverExtensions.waitToBeDisplayed(this.linkOpenToolBox);
    this.linkOpenToolBox.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToMWS460() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("MWS460");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPCS230() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("PCS230");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToCAS950() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("CAS950");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToMMS100() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("ABC");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("MMS100");
    WebDriverExtensions.waitToBeDisplayed(this.linkReqDistrOrder);
    this.linkReqDistrOrder.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToFCS350() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    BasePage.waitForLoadingComplete();
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("FCS350");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPSS310() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("PSS310");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToMMS080() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("MMS080");
    try {
      WebDriverExtensions.waitToBeDisplayed(this.linkMaterialPlan);
      this.linkMaterialPlan.click();
    } catch (final Throwable _t) {
      if (_t instanceof NoSuchElementException) {
        final NoSuchElementException e = (NoSuchElementException)_t;
        this.txtSearch.sendKeys(Keys.ENTER);
        BasePage.waitForLoadingComplete();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void GoToPPS200() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("PPS200");
    BasePage.waitForLoadingComplete();
    try {
      WebDriverExtensions.waitToBeDisplayed(this.linkPurchaseOrder);
      this.linkPurchaseOrder.click();
    } catch (final Throwable _t) {
      if (_t instanceof NoSuchElementException) {
        final NoSuchElementException e = (NoSuchElementException)_t;
        this.txtSearch.sendKeys(Keys.ENTER);
        BasePage.waitForLoadingComplete();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void GoToDPS170() {
    try {
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
      this.headerMenu.click();
      WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
      this.txtSearch.click();
      BasePage.clearRobustly(this.txtSearch);
      this.txtSearch.click();
      this.txtSearch.sendKeys("DPS170");
      Thread.sleep(2000);
      this.txtSearch.sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void GoToPPS390() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("PPS390");
    BasePage.waitForLoadingComplete();
    try {
      WebDriverExtensions.waitToBeDisplayed(this.linkReturnToSupplier);
      this.linkReturnToSupplier.click();
    } catch (final Throwable _t) {
      if (_t instanceof NoSuchElementException) {
        final NoSuchElementException e = (NoSuchElementException)_t;
        this.txtSearch.sendKeys(Keys.ENTER);
        BasePage.waitForLoadingComplete();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void GoToOIS390() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("OIS390");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToOIS275() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("ois275");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPPS170() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("PPS170");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPPS600() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("PPS600");
    WebDriverExtensions.waitToBeDisplayed(this.linkPrintDocument);
    this.linkPrintDocument.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPPS250() {
    try {
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
      Thread.sleep(1000);
      this.headerMenu.click();
      WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
      this.txtSearch.clear();
      this.txtSearch.click();
      this.txtSearch.sendKeys("PPS250");
      Thread.sleep(500);
      WebDriverExtensions.waitToBeDisplayed(this.linkPurchaseOrderConfirm);
      this.linkPurchaseOrderConfirm.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void GoToPPS270() {
    try {
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
      Thread.sleep(1000);
      this.headerMenu.click();
      WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
      this.txtSearch.clear();
      this.txtSearch.click();
      this.txtSearch.sendKeys("PPS270");
      Thread.sleep(500);
      WebDriverExtensions.waitToBeDisplayed(this.linkNotifyTranspotation);
      this.linkNotifyTranspotation.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void GoToCAS310() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.sendKeys("CAS310");
    WebDriverExtensions.waitToBeDisplayed(this.linkOrderCostingDisplay);
    this.linkOrderCostingDisplay.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToOIS150() {
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 120);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    BasePage.clearRobustly(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("OIS150");
    WebDriverExtensions.waitToBeDisplayed(this.linkCoOpen);
    this.linkCoOpen.click();
    BasePage.waitForLoadingComplete();
  }
}
