package bi3.pages.Pms;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS extends BasePage {
  public PMS(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(xpath = "//div[@class=\'gvWidgetHeader\']/span[contains(text(),\'Menu\')]")
  private WebElement headerMenu;
  
  @FindBy(css = "input.inforSearchField")
  private WebElement txtSearch;
  
  @FindBy(xpath = "//div[@class=\'gvWidgetHeader\']/span[contains(text(),\'Menu\')]/../..//div[@class=\'gvFillAbsolute\']//li")
  private WebElement MenuWidgetOptions;
  
  @FindBy(id = "ActionsBtn")
  private WebElement btnActions;
  
  @FindBy(css = "#WDPAVRContainer>button")
  private WebElement btnView;
  
  @FindBy(id = "#POS")
  private WebElement txtPOS;
  
  @FindBy(css = "a[href=\'#F13\']")
  private WebElement btnSettings;
  
  @FindBy(css = "div[id*=\'BROWSE_LIST\'] div.slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(xpath = "//*[contains(text(),\'A01SCHSTY\')]")
  private WebElement gridFirstLineT1;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(id = "Next")
  private WebElement btnSelect1;
  
  @FindBy(css = "div[class=\'grid-canvas grid-canvas-top grid-canvas-left\']>div")
  private WebElement gridFirst;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a//*[contains(text(), \'Report Issue\')]")
  private WebElement linkReportIssue;
  
  @FindBy(css = "#WMSPMT-shdo")
  private WebElement comboSelectIsseMTD;
  
  @FindBy(css = "#WMSPMT-shdo")
  private WebElement cmbIssueMtd;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listInvAccounting;
  
  @FindBy(id = "#XT_0168")
  private WebElement btnApply;
  
  @FindBy(css = "div[class=\'grid-canvas grid-canvas-top grid-canvas-left\']>div")
  private WebElement gridFirstManufatOrder;
  
  @FindBy(xpath = "//a//*[contains(text(), \'Confirmation\')]")
  private WebElement linkReportIssue1;
  
  @FindBy(css = "#startDiv")
  private WebElement btnStart;
  
  @FindBy(css = "#tabsList > li.ui-tabs-selected.ui-state-active > button")
  private WebElement btnClose;
  
  public void GoToPMS230() {
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("PMS230");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void ClickActions() {
    try {
      WebDriverExtensions.waitToBeDisplayed(this.btnActions);
      this.btnActions.click();
      Thread.sleep(2000);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void GoToSettings() {
    try {
      WebDriverExtensions.waitToBeDisplayed(this.btnSettings);
      Thread.sleep(2000);
      this.btnSettings.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void GoToViewAndCompleActions() {
    try {
      this.btnView.click();
      this.gridFirstLineT1.click();
      Thread.sleep(2000);
      this.btnSelect.click();
      System.out.println("Ended");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void ClickNext() {
    try {
      Thread.sleep(1000);
      this.btnSelect1.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void setItemsOPtions() {
    try {
      BasePage.waitForLoadingComplete();
      this.gridFirst.click();
      this.rightClick(this.gridFirst);
      Thread.sleep(1000);
      this.linkRelated.click();
      Thread.sleep(2000);
      this.linkReportIssue.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void selectIssueMTDCombo() {
    BasePage.waitForLoadingComplete();
    this.comboSelectIsseMTD.click();
  }
  
  public void SelectInvAccounting(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbIssueMtd, this.listInvAccounting, value);
  }
  
  public void clickButtonApply() {
    this.btnApply.click();
  }
  
  public void realtedConfirmation() {
    try {
      this.gridFirstManufatOrder.click();
      this.rightClick(this.gridFirstManufatOrder);
      Thread.sleep(1000);
      this.linkRelated.click();
      Thread.sleep(2000);
      this.linkReportIssue1.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void gotoMain() {
    this.btnClose.click();
  }
}
