package bi3.pages.Pms;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@SuppressWarnings("all")
public class PMS100 extends BasePage {
  public PMS100(final WebDriver driver) {
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
  
  @FindBy(css = "#W1OBKV")
  private WebElement txtConsignee;
  
  @FindBy(css = "#W1OBKV")
  private WebElement txtProject;
  
  @FindBy(css = "div[class=\'grid-canvas grid-canvas-top grid-canvas-left\']>div")
  private WebElement gridFirstConsignee;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelatedold;
  
  @FindBy(xpath = "//a//*[contains(text(), \'Check Component Availability\')]")
  private WebElement linkReportIssue;
  
  @FindBy(css = "#WWQTTP-shdo")
  private WebElement cmbSortingOptions;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listInvAccounting;
  
  @FindBy(css = "#WWQTTP-shdo")
  private WebElement cmbSortingOptionsView;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listInvView;
  
  @FindBy(css = "#W1OBKV")
  private WebElement txtConsignee1;
  
  @FindBy(css = "#W1OBKV")
  private WebElement txtProject1;
  
  @FindBy(css = "div[class=\'grid-canvas grid-canvas-top grid-canvas-left\']>div")
  private WebElement gridFirstConsignee1;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a//*[contains(text(), \'Check Component Availability\')]")
  private WebElement linkReleaseForPicking;
  
  @FindBy(xpath = "//a//*[contains(text(), \'Picking Lists\')]")
  private WebElement linkPickingLists;
  
  @FindBy(xpath = "//a//*[contains(text(), \'Confirm Issues\')]")
  private WebElement linkConfirmIssues;
  
  @FindBy(xpath = "//a//*[contains(text(), \'Delivery Toolbox\')]")
  private WebElement linkDeliveryToolBox;
  
  @FindBy(css = "div[class=\'grid-canvas grid-canvas-top grid-canvas-left\']>div")
  private WebElement gridFirstOrder;
  
  @FindBy(css = "div[class=\'grid-canvas grid-canvas-top grid-canvas-left\']>div")
  private WebElement gridFirstConsignee12;
  
  private int elementValue = 90;
  
  public void GoToPMS100() {
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("PMS100");
    this.txtSearch.sendKeys(Keys.ENTER);
  }
  
  public void AddScheduleNOAndProduct() {
    try {
      BasePage.waitForLoadingComplete();
      this.txtConsignee.click();
      this.txtConsignee.sendKeys("12");
      this.txtConsignee.sendKeys(Keys.ENTER);
      Thread.sleep(3000);
      this.gridFirstConsignee.click();
      this.rightClick(this.gridFirstConsignee, Boolean.valueOf(false), "Change");
      Thread.sleep(3000);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void selectComboValues(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbSortingOptions, this.listInvAccounting, value);
  }
  
  public void GoToMWS410() {
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("MWS410");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void selectComboValuesView(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbSortingOptionsView, this.listInvView, value);
  }
  
  public void MarkRelaseForPicking() {
    BasePage.waitForLoadingComplete();
    this.txtConsignee.click();
    this.txtConsignee.sendKeys("0000018");
    this.txtConsignee.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    this.gridFirstConsignee.click();
    this.rightClick(this.gridFirstConsignee);
    this.linkRelated.click();
    this.linkReleaseForPicking.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void AddToPickingList() {
    this.txtConsignee.click();
    this.txtConsignee.sendKeys("0000018");
    this.txtConsignee.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    this.gridFirstConsignee.click();
    this.rightClick(this.gridFirstConsignee);
    this.linkRelated.click();
    this.linkReleaseForPicking.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void MoveToPickingList() {
    this.gridFirstConsignee.click();
    this.rightClick(this.gridFirstConsignee);
    this.linkRelated.click();
    this.linkPickingLists.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void ConfirmIssues() {
    this.gridFirstConsignee.click();
    this.rightClick(this.gridFirstConsignee);
    this.linkRelated.click();
    this.linkConfirmIssues.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void ReleaseForPicking() {
    Assert.assertEquals(Integer.valueOf(this.elementValue), "90", "Error");
  }
  
  public void GoTopms70() {
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("pms70");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void GoTopms100() {
    WebDriverExtensions.waitToBeDisplayed(this.MenuWidgetOptions, 60);
    this.headerMenu.click();
    WebDriverExtensions.waitToBeDisplayed(this.txtSearch);
    this.txtSearch.click();
    this.txtSearch.sendKeys("pms100");
    this.txtSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  private int scheduleNo = 1;
  
  public void NavigateToDeliveryToolBox() {
    BasePage.waitForLoadingComplete();
    this.gridFirstOrder.click();
    this.rightClick(this.gridFirstOrder);
    this.linkRelated.click();
    this.linkDeliveryToolBox.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void NavigateToRelseForPicking() {
    this.gridFirstOrder.click();
    this.rightClick(this.gridFirstOrder);
    this.linkRelated.click();
    this.linkDeliveryToolBox.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void NavigateToPickingLists() {
  }
  
  public void ConfirmIssuesForRelease() {
  }
  
  private int pisValue = 90;
  
  public void ConfirmPIS90() {
    Assert.assertEquals(Integer.valueOf(this.elementValue), "90", "PIS Value Confirmed");
  }
}
