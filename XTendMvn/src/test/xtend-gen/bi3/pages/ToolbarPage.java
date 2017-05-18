package bi3.pages;

import bi3.framework.core.DefaultWebDriver;
import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class ToolbarPage extends BasePage {
  public ToolbarPage(final WebDriver driver) {
    super(driver);
  }
  
  /**
   * MAIN ELEMENTS ON TOP
   */
  @FindBy(id = "ActionsBtn")
  public WebElement btnActionBtn;
  
  @FindBy(id = "OptionsBtn")
  public WebElement btnOptionBtn;
  
  @FindBy(id = "RelatedBtn")
  public WebElement btnRelatedBtn;
  
  @FindBy(id = "ToolsBtn")
  public WebElement btnToolsBtn;
  
  /**
   * Logo Buttons
   * 
   * ( some elements are commented until assigning a suitable name for elements )
   */
  @FindBy(css = "div[class=cmdBarLeft2] button:nth-child(1)")
  private WebElement btnCreateLogo;
  
  @FindBy(css = "div[class=cmdBarLeft2] button:nth-child(2)")
  private WebElement btnSelectLogo;
  
  @FindBy(css = "div[class=cmdBarLeft2] button:nth-child(3)")
  private WebElement btnChangeLogo;
  
  @FindBy(css = "div[class=cmdBarLeft2] button:nth-child(6)")
  private WebElement btnDisplayLogo;
  
  @FindBy(id = "pSeqBtn")
  private WebElement btnPanelNavigatorLogo;
  
  @FindBy(id = "qn")
  private WebElement btnQuickNote;
  
  @FindBy(id = "helpIcon")
  private WebElement btnHelpLogo;
  
  @FindBy(id = "toolBoxBtnCont")
  private WebElement btnExpandToolbox;
  
  /**
   * ELEMENTS INSIDE DROPDOWNS
   */
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Settings\')]")
  private WebElement btnSettings;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Update\')]")
  private WebElement btnUpdate;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Retrieve\')]")
  private WebElement btnRetrieve;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Browse\')]")
  private WebElement btnBrowse;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Field Help\')]")
  private WebElement btnFieldHelp;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Refresh\')]")
  private WebElement btnRefresh;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Cancel\')]")
  private WebElement btnCancel;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Select all\')]")
  private WebElement btnSelectAll;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Confirm All\')]")
  private WebElement btnConfirmAll;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Close\')]")
  private WebElement btnClose;
  
  /**
   * List Elements in Options Tab
   */
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Select\')]]")
  private WebElement btnSelect;
  
  @FindBy(xpath = "//a[contains(text(),\'Change\')]")
  private WebElement btnChange;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Copy\')]]")
  private WebElement btnCopy;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Delete\')]]")
  private WebElement btnDelete;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Display\')]]")
  private WebElement btnDisplay;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Copy to Clipboard\')]]")
  private WebElement btnCopyToClipBoard;
  
  /**
   * Page Actions FOR ACTION TAB
   */
  public void ClickAction() {
    BasePage.waitForLoadingComplete();
    this.btnActionBtn.click();
  }
  
  public void ClickOption() {
    WebDriverExtensions.waitToBeClickable(this.btnOptionBtn);
    this.btnOptionBtn.click();
  }
  
  public void ClickAction_Settings() {
    try {
      WebDriverExtensions.waitToBeClickable(this.btnActionBtn);
      Thread.sleep(3000);
      this.btnActionBtn.click();
      BasePage.waitForLoadingComplete();
      this.btnSettings.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void ClickAction_Update() {
    try {
      WebDriverExtensions.waitToBeClickable(this.btnActionBtn);
      Thread.sleep(3000);
      this.btnActionBtn.click();
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeClickable(this.btnUpdate);
      this.btnUpdate.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void ClickAction_Retrieve() {
    try {
      WebDriverExtensions.waitToBeClickable(this.btnActionBtn);
      Thread.sleep(3000);
      this.btnActionBtn.click();
      BasePage.waitForLoadingComplete();
      this.btnRetrieve.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void ClickAction_Browse() {
    WebDriverExtensions.waitToBeClickable(this.btnActionBtn);
    this.btnActionBtn.click();
    BasePage.waitForLoadingComplete();
    this.btnBrowse.click();
  }
  
  public void ClickAction_FieldHelp() {
    WebDriverExtensions.waitToBeClickable(this.btnActionBtn);
    this.btnActionBtn.click();
    BasePage.waitForLoadingComplete();
    this.btnFieldHelp.click();
  }
  
  public void ClickAction_Refresh() {
    WebDriverExtensions.waitToBeClickable(this.btnActionBtn);
    this.btnActionBtn.click();
    BasePage.waitForLoadingComplete();
    this.btnRefresh.click();
  }
  
  public void ClickAction_Cancel() {
    WebDriverExtensions.waitToBeClickable(this.btnActionBtn);
    this.btnActionBtn.click();
    BasePage.waitForLoadingComplete();
    this.btnCancel.click();
  }
  
  public void ClickAction_SelectAll() {
    WebDriverExtensions.waitToBeClickable(this.btnActionBtn);
    this.btnActionBtn.click();
    BasePage.waitForLoadingComplete();
    this.btnSelectAll.click();
  }
  
  public void ClickAction_Close() {
    WebDriverExtensions.waitToBeClickable(this.btnActionBtn);
    this.btnActionBtn.click();
    BasePage.waitForLoadingComplete();
    this.btnClose.click();
  }
  
  public void ClickAction_ConfirmAll() {
    WebDriverExtensions.waitToBeClickable(this.btnActionBtn);
    this.btnActionBtn.click();
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.btnConfirmAll);
    this.btnConfirmAll.click();
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * Page Actions FOR OPTIONS TAB
   */
  public void ClickOption_Select() {
    WebDriverExtensions.waitToBeClickable(this.btnOptionBtn);
    this.btnOptionBtn.click();
    BasePage.waitForLoadingComplete();
    this.btnSelect.click();
  }
  
  public void ClickOption_Change() {
    WebDriverExtensions.waitToBeClickable(this.btnOptionBtn);
    this.btnOptionBtn.click();
    BasePage.waitForLoadingComplete();
    this.btnChange.click();
  }
  
  public void ClickOption_Copy() {
    WebDriverExtensions.waitToBeClickable(this.btnOptionBtn);
    this.btnOptionBtn.click();
    BasePage.waitForLoadingComplete();
    this.btnCopy.click();
  }
  
  public void ClickOption_Delete() {
    WebDriverExtensions.waitToBeClickable(this.btnOptionBtn);
    this.btnOptionBtn.click();
    BasePage.waitForLoadingComplete();
    this.btnDelete.click();
  }
  
  public void ClickOption_Display() {
    WebDriverExtensions.waitToBeClickable(this.btnOptionBtn);
    this.btnOptionBtn.click();
    BasePage.waitForLoadingComplete();
    this.btnDisplay.click();
  }
  
  public void ClickOption_CopyToClipboard() {
    WebDriverExtensions.waitToBeClickable(this.btnOptionBtn);
    this.btnOptionBtn.click();
    BasePage.waitForLoadingComplete();
    this.btnCopyToClipBoard.click();
  }
  
  /**
   * Page actions for RELATED  TOOLS
   */
  public WebElement findElementInRelated(final String DropDownElement) {
    String element = (("//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'" + DropDownElement) + "\')]");
    return DefaultWebDriver.driver.findElement(By.xpath(element));
  }
  
  public WebElement findElementInTools(final String DropDownElement) {
    String element = (("//ul[@class=\'inforContextMenu ToolsMenu inforMenuOptions\']//li/a[contains(text(),\'" + DropDownElement) + "\')]");
    return DefaultWebDriver.driver.findElement(By.xpath(element));
  }
  
  public void clickRelated(final String DropDownElement) {
    WebDriverExtensions.waitToBeClickable(this.btnRelatedBtn);
    this.btnRelatedBtn.click();
    BasePage.waitForLoadingComplete();
    this.findElementInRelated(DropDownElement).click();
  }
  
  public void clickTools(final String DropDownElement) {
    WebDriverExtensions.waitToBeClickable(this.btnToolsBtn);
    this.btnToolsBtn.click();
    BasePage.waitForLoadingComplete();
    this.findElementInTools(DropDownElement).click();
  }
  
  /**
   * Actions to click LOGO's
   */
  public void clickCreateLogo() {
    WebDriverExtensions.waitToBeClickable(this.btnCreateLogo);
    this.btnCreateLogo.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void clickSelectLogo() {
    WebDriverExtensions.waitToBeClickable(this.btnSelectLogo);
    this.btnSelectLogo.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void clickChangeLogo() {
    WebDriverExtensions.waitToBeClickable(this.btnChangeLogo);
    this.btnChangeLogo.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void clickDisplayLogo() {
    WebDriverExtensions.waitToBeClickable(this.btnDisplayLogo);
    this.btnDisplayLogo.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void clickPanelNavigatorLogo() {
    WebDriverExtensions.waitToBeClickable(this.btnPanelNavigatorLogo);
    this.btnPanelNavigatorLogo.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void clickHelpLogo() {
    WebDriverExtensions.waitToBeClickable(this.btnHelpLogo);
    this.btnHelpLogo.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void clickExpandToolboxLogo() {
    WebDriverExtensions.waitToBeClickable(this.btnExpandToolbox);
    this.btnExpandToolbox.click();
    BasePage.waitForLoadingComplete();
  }
}
