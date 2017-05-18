package bi3.pages.pds001;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PDS001 extends BasePage {
  public PDS001(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[class=\'tabTitle\'][title]")
  private WebElement pageTitle;
  
  @FindBy(id = "W1OBKV")
  private List<WebElement> txtItemNumber;
  
  @FindBy(css = "input[type=\'text\'][id=\'W2OBKV\']")
  private List<WebElement> listTxtSerialNumber;
  
  @FindBy(css = "input[type=\'text\'][id=\'W3OBKV\']")
  private List<WebElement> listTxtFacilityNumber;
  
  @FindBy(css = "button[class=\'inforIconButton new\']")
  private List<WebElement> btnPlus;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//div[@class=\'inforMenu submenu\']//a/span[contains(text(),\'Material and Operation\')]")
  private WebElement linkMaterialAndOperation;
  
  @FindBy(xpath = "//div[@class=\'inforMenu submenu\']//a/span[contains(text(),\'Calculate Product Cost\')]")
  private WebElement linkCalculateProductCost;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(xpath = "//button[@id=\'dbtnent\']")
  private WebElement btnGridNext;
  
  @FindBy(css = "#tabsList > li.ui-tabs-selected.ui-state-active > button")
  private WebElement btnClose;
  
  @FindBy(css = "div[id*=\'PDA001BS\'][class*=\'inforDataGrid\']")
  private WebElement gridPDS001;
  
  @FindBy(css = "XT_0168")
  private WebElement btnApply;
  
  @FindBy(xpath = "//a[text()=\'Change\']")
  private WebElement linkChange;
  
  @FindBy(css = "div.listHeaderToolTip")
  private WebElement tooltip;
  
  @FindBy(xpath = "//input[@id=\'WMMSEQ\']")
  private WebElement txtseqNum;
  
  @FindBy(xpath = "//input[@id=\'WBOPNO\']")
  private WebElement txtopNo;
  
  @FindBy(xpath = "//input[@id=\'WWMTPL\']")
  private WebElement txtcmpNum;
  
  @FindBy(xpath = "//button[@class=\'inforIconButton new\']")
  private WebElement btnCrt;
  
  @FindBy(id = "W1CNQT")
  private WebElement txtQty;
  
  @FindBy(xpath = "//button[@class=\'inforIconButton refresh\']")
  private WebElement btnRefresh;
  
  @FindBy(xpath = "//span[text()=\'Options/Line\']/ancestor::a[@href=\'#14\']")
  private WebElement linkOptionLine;
  
  @FindBy(xpath = "//input[@id=\'WNOTYP\']")
  private WebElement txtStp;
  
  @FindBy(xpath = "//input[@id=\'WNFTID\']")
  private WebElement txtSelecId;
  
  @FindBy(css = "div[id*=\'BROWSE_LIST\'][class*=\'inforDataGrid\']")
  private WebElement gridSize;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(xpath = "//input [@id=\'WNOPTN\']")
  private WebElement txtSetExctSize;
  
  @FindBy(id = "WNOPTN")
  private WebElement txtOption;
  
  @FindBy(xpath = "//div[text()=\'X016\']")
  private WebElement gridExctSize;
  
  @FindBy(xpath = "//span[text()=\'Indented BoM\']/ancestor::a[@href=\'#22\']")
  private WebElement linkIndentendBoM;
  
  public void FillItemNumber(final String itemNumber, final int tab) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.txtItemNumber.get(tab));
    WebDriverExtensions.waitToBeClickable(this.txtItemNumber.get(tab));
    this.txtItemNumber.get(tab).click();
    BasePage.clearRobustly(this.txtItemNumber.get(tab));
    this.txtItemNumber.get(tab).sendKeys(itemNumber);
  }
  
  public void FillSerialNumber(final String serialNumber, final int tab) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.listTxtSerialNumber.get(tab));
    WebDriverExtensions.waitToBeClickable(this.listTxtSerialNumber.get(tab));
    this.listTxtSerialNumber.get(tab).click();
    BasePage.clearRobustly(this.listTxtSerialNumber.get(tab));
    this.listTxtSerialNumber.get(tab).sendKeys(serialNumber);
  }
  
  public void FillFacility(final String facility, final int tab) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.listTxtFacilityNumber.get(tab));
    WebDriverExtensions.waitToBeClickable(this.listTxtFacilityNumber.get(tab));
    this.listTxtFacilityNumber.get(tab).click();
    BasePage.clearRobustly(this.listTxtFacilityNumber.get(tab));
    this.listTxtFacilityNumber.get(tab).sendKeys(facility);
  }
  
  public String getpageTitle() {
    BasePage.waitForLoadingComplete();
    return this.pageTitle.getText();
  }
  
  public void CreateProductStructure(final int tab) {
    this.btnPlus.get(tab).click();
  }
  
  public void SearchByItemNumber(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    this.txtItemNumber.get(0).click();
    BasePage.clearRobustly(this.txtItemNumber.get(0));
    this.txtItemNumber.get(0).sendKeys(itemNumber);
    this.txtItemNumber.get(0).sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeHidden(this.tooltip);
  }
  
  public void goToMaterialAndOperations(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkMaterialAndOperation);
    this.linkMaterialAndOperation.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void goToCalculateProductCost() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine, Boolean.valueOf(true), "Calculate Product Cost");
  }
  
  public void goToDisplayProductCosting() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine, Boolean.valueOf(true), "Display Product Costing");
  }
  
  public void clickNext() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void createButton() {
    this.btnCrt.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void clickGridNext() {
    this.btnGridNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void close() {
    this.btnClose.click();
    System.out.println("PDS001 tab closed");
  }
  
  public void clickApply() {
    BasePage.clickWhenReady(this.btnApply);
    BasePage.waitForLoadingComplete();
  }
  
  public void EditItem(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridPDS001);
    List<WebElement> cell = grid.getCellsFromRow(0);
    cell.get(2).click();
    WebElement _get = cell.get(2);
    String _plus = (Keys.CONTROL + "2");
    _get.sendKeys(_plus);
    BasePage.waitForLoadingComplete();
  }
  
  public List<String> getDataOfItem(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridPDS001);
    List<String> dataList = grid.getDataOfRowContainingTextInColumn(1, itemNumber);
    return dataList;
  }
  
  public void addOneMoreButtton(final String sn, final String opno, final String cmpNo, final String qty) {
    try {
      BasePage.waitForLoadingComplete();
      this.txtseqNum.clear();
      this.txtseqNum.sendKeys(sn);
      this.txtopNo.clear();
      this.txtopNo.sendKeys(opno);
      this.txtcmpNum.clear();
      this.txtcmpNum.sendKeys(cmpNo);
      Thread.sleep(1000);
      this.btnCrt.click();
      this.txtQty.clear();
      this.txtQty.sendKeys(qty);
      this.btnNext.click();
      BasePage.waitForLoadingComplete();
      this.btnNext.click();
      BasePage.waitForLoadingComplete();
      this.btnRefresh.click();
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void goToOptionLine() {
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.linkOptionLine);
    this.linkOptionLine.click();
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * def addButtonSize(String stp, String btnSize){
   * 
   * txtStp.sendKeys(stp)
   * txtSelecId.sendKeys(Keys.F4)
   * waitToBeClickable(gridSize);
   * gridSize.click();
   * btnSelect.click
   * txtSetExctSize.sendKeys(Keys.F4)
   * 
   * }
   */
  public void selectItemFromM3Browse(final String stp, final int cellNum, final String btnSiz, final int cellNum2, final String exctSize) {
    BasePage.waitForLoadingComplete();
    this.txtStp.sendKeys(stp);
    this.txtSelecId.sendKeys(Keys.F4);
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridSize);
    System.out.println("Test");
    grid.getCell(cellNum, btnSiz).click();
    BasePage.waitForLoadingComplete();
    this.btnSelect.click();
    this.txtOption.sendKeys(Keys.F4);
    BasePage.waitForLoadingComplete();
    this.gridExctSize.click();
    this.btnSelect.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void creationProcess() {
    BasePage.waitForLoadingComplete();
    this.btnCrt.click();
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
    this.btnClose.click();
    BasePage.waitForLoadingComplete();
    this.btnClose.click();
  }
  
  public void intendedBom() {
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.linkIndentendBoM);
    this.linkIndentendBoM.click();
  }
}
