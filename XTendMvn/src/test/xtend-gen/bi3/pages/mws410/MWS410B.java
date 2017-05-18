package bi3.pages.mws410;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@SuppressWarnings("all")
public class MWS410B extends BasePage {
  public MWS410B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WOPAVR-shdo")
  private WebElement btnSelectView;
  
  @FindBy(css = "#dropdown-list>li")
  private List<WebElement> listViewOptions;
  
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
  
  @FindBy(css = "div[id*=\'MWA410BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(css = "#W1OBKV")
  private WebElement txtConsignee;
  
  @FindBy(css = "#W1OBKV")
  private WebElement txtProject;
  
  @FindBy(css = "div[class=\'grid-canvas grid-canvas-top grid-canvas-left\']>div")
  private WebElement gridFirstConsignee;
  
  @FindBy(css = "#WOPAVR-shdo")
  private WebElement cmbSortingOptionsView;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listInvView;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[text()=\'Change\']")
  private WebElement linkChange;
  
  @FindBy(xpath = "//a//*[contains(text(), \'Release for Picking\')]")
  private WebElement linkReleaseForPicking;
  
  @FindBy(xpath = "//a//*[contains(text(), \'Picking Lists\')]")
  private WebElement linkPickingLists;
  
  @FindBy(xpath = "//a//*[contains(text(), \'Confirm Issues\')]")
  private WebElement linkConfirmIssues;
  
  @FindBy(css = ".inforIconButton.refresh")
  private WebElement btnRefresh;
  
  @FindBy(css = ".slick-cell.l8.r8")
  private WebElement lblRIP;
  
  @FindBy(css = "div[row=\'0\'] >div ")
  private WebElement firstGridCell;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Picking List\')]")
  private WebElement linPickingList;
  
  @FindBy(css = "#Prev")
  private WebElement btnPrev;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(xpath = ".//a/span[contains(text(),\'Packages\')]")
  private WebElement linkPackages;
  
  @FindBy(css = "div[id*=\'MWA410BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElementDelivery;
  
  private int elementValue = 90;
  
  public void ClickPrev() {
    BasePage.waitForLoadingComplete();
    this.btnPrev.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void PackingList() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.firstGridCell);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    this.linPickingList.click();
    BasePage.waitForLoadingComplete();
  }
  
  public List<String> TakeRipValue() {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    List<String> data = grid.getDataOfColumn(11);
    return data;
  }
  
  public void SelectAllRows() {
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> deliveryBoxCol = grid.getCellsFromColumn(1);
    WebElement secoundCell = deliveryBoxCol.get(1);
    BasePage.waitForLoadingComplete();
    BasePage.SelectAllGridRows(secoundCell);
  }
  
  public void selectView(final String view) {
    this.selectFromDropdown(this.btnSelectView, this.listViewOptions, view);
    BasePage.waitForLoadingComplete();
  }
  
  public void goToDeliveryToolbox() {
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> schedCol = grid.getCellsFromColumn(1);
    WebElement firstCell = schedCol.get(0);
    this.rightClick(firstCell);
    BasePage.waitForLoadingComplete();
    this.linkRelated.click();
    BasePage.waitForLoadingComplete();
    this.linkReleaseForPicking.click();
    BasePage.waitForLoadingComplete();
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
    BasePage.waitForLoadingComplete();
  }
  
  public void searchConsignee(final String consignee) {
    BasePage.waitForLoadingComplete();
    this.txtConsignee.click();
    this.txtConsignee.sendKeys(consignee);
    this.txtConsignee.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public boolean relaseForPicking() {
    try {
      BasePage.waitForLoadingComplete();
      InforGrid grid = new InforGrid(this.gridElement);
      List<WebElement> deliveryBoxCol = grid.getCellsFromColumn(1);
      WebElement secoundCell = deliveryBoxCol.get(0);
      BasePage.waitForLoadingComplete();
      BasePage.SelectAllGridRows(secoundCell);
      this.rightClick(this.gridFirstConsignee);
      this.linkRelated.click();
      this.linkReleaseForPicking.click();
      BasePage.waitForLoadingComplete();
      Thread.sleep(7000);
      this.refreshPage();
      String rip = this.getRIPOFRow1();
      int loopC = 1;
      while (((loopC < 3) && (!Objects.equal(rip, "1")))) {
        {
          Thread.sleep(3000);
          this.refreshPage();
          rip = this.getRIPOFRow1();
          loopC = (loopC + 1);
        }
      }
      boolean _equals = Objects.equal(rip, "1");
      if (_equals) {
        return true;
      } else {
        return false;
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void AddToPickingList(final String consignee) {
    this.txtConsignee.click();
    this.txtConsignee.sendKeys(consignee);
    this.txtConsignee.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    this.gridFirstConsignee.click();
    this.rightClick(this.gridFirstConsignee);
    this.linkRelated.click();
    this.linkReleaseForPicking.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void MoveToPickingList() {
    try {
      BasePage.waitForLoadingComplete();
      this.gridFirstConsignee.click();
      Thread.sleep(2000);
      this.rightClick(this.gridFirstConsignee);
      this.linkRelated.click();
      WebDriverExtensions.waitToBeClickable(this.linkPickingLists);
      Thread.sleep(2000);
      this.linkPickingLists.click();
      BasePage.waitForLoadingComplete();
      Thread.sleep(2000);
      InputOutput.<String>println("Picking List");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void ConfirmIssues() {
    WebDriverExtensions.waitToBeClickable(this.gridFirstConsignee);
    this.rightClick(this.gridFirstConsignee);
    this.linkRelated.click();
    this.linkConfirmIssues.click();
    BasePage.waitForLoadingComplete();
    InputOutput.<String>println("Confirm Issues");
  }
  
  public void ReleaseForPicking() {
    Assert.assertEquals(Integer.valueOf(this.elementValue), "90", "Error");
  }
  
  public void refreshPage() {
    WebDriverExtensions.waitToBeClickable(this.btnRefresh);
    this.btnRefresh.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String getRIPOFRow1() {
    InforGrid gridDelivery = new InforGrid(this.gridElementDelivery);
    int colId = gridDelivery.getColumnIndexByname("RlP");
    List<String> rip = gridDelivery.getDataOfColumn(colId);
    String _get = rip.get(0);
    String _plus = ("RIP was " + _get);
    System.out.println(_plus);
    return rip.get(0);
  }
  
  public void changeRecord() {
    WebDriverExtensions.waitToBeClickable(this.gridFirstConsignee);
    this.rightClick(this.gridFirstConsignee);
    this.linkChange.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void ReleaseForPickingDOP() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.gridFirstLine);
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeDisplayed(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeDisplayed(this.linkReleaseForPicking);
    this.linkReleaseForPicking.click();
    InputOutput.<String>println("Release for picking");
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToPackages() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.gridFirstLine);
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeDisplayed(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeDisplayed(this.linkPackages);
    this.linkPackages.click();
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * navigate to related option.
   */
  public void goToRelatedOption(final String option) {
    BasePage.waitForLoadingComplete();
    InforGrid gridDelivery = new InforGrid(this.gridElementDelivery);
    WebElement gridRowDelivery = null;
    int _rowCount = gridDelivery.getRowCount();
    boolean _greaterThan = (_rowCount > 0);
    if (_greaterThan) {
      gridRowDelivery = gridDelivery.getRow(0);
      gridRowDelivery.click();
      this.rightClick(gridRowDelivery, Boolean.valueOf(true), option);
    }
    BasePage.waitForLoadingComplete();
  }
}
