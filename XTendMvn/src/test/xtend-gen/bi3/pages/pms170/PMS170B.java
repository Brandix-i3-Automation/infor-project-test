package bi3.pages.pms170;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS170B extends BasePage {
  public PMS170B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "#WWQTTP-shdo")
  private WebElement cmdSortingOrder;
  
  @FindBy(css = "#dropdown-list li")
  private List<WebElement> listSortingOrder;
  
  @FindBy(xpath = "//*[contains(text(),\'Sched no\')]")
  private WebElement lblSchNo;
  
  @FindBy(css = "#W3OBKV")
  private WebElement txtMainProduct;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(xpath = "//a[contains(text(),\'Related\')]")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Joint Scheduling\')]")
  private WebElement linkJointScheduling;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(xpath = ".//*[@fkey=\'F5\']")
  private WebElement btnRefresh;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Release\')]")
  private WebElement linkRelease;
  
  @FindBy(css = "#W2OBKV")
  private WebElement txtSchNo;
  
  @FindBy(id = "W1RESP")
  private WebElement respLookUpText;
  
  @FindBy(id = "W1OBKV")
  private WebElement txtSearchResp;
  
  @FindBy(css = "div[id*=\'PMA170BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(id = "W1OBKV")
  private WebElement txtPlnOrdNo;
  
  public void SelectSortingOrder(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmdSortingOrder, this.listSortingOrder, value);
    WebDriverExtensions.waitForAnyText(this.lblSchNo, 100);
  }
  
  public void EnterMainProduct(final String mainProduct) {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtMainProduct);
    this.txtMainProduct.sendKeys(mainProduct);
    WebDriverExtensions.waitToBeDisplayed(this.txtMainProduct);
    this.txtMainProduct.sendKeys(Keys.ENTER);
  }
  
  public void JointSchedulling() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    this.linkJointScheduling.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void clickNext() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void RefreshPage() {
    this.btnRefresh.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void ReleaseItem() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    this.linkRelease.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void SearchScheduleNo(final String schNo) {
    BasePage.waitForLoadingComplete();
    this.txtSchNo.click();
    this.txtSchNo.sendKeys(schNo);
    this.txtSchNo.sendKeys(Keys.ENTER);
  }
  
  public void EnterScheduleNo(final String scheduleNo) {
    this.txtSchNo.click();
    this.txtSchNo.sendKeys(scheduleNo);
    this.txtSchNo.sendKeys(Keys.ENTER);
  }
  
  public String getScheduleNumberOf(final String newItemNumber) {
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> cells = grid.getCellsFromRow(0);
    boolean _equals = cells.get(2).getText().equals(newItemNumber);
    if (_equals) {
      String _text = cells.get(1).getText();
      String _plus = ("Last schedule number :" + _text);
      System.out.println(_plus);
      return cells.get(1).getText();
    } else {
      System.out.println("Entered item number was not found in PMS170 grid");
      return "";
    }
  }
  
  public void clearResponsible() {
    WebDriverExtensions.waitToBeClickable(this.respLookUpText);
    this.respLookUpText.click();
    BasePage.clearRobustly(this.respLookUpText);
  }
  
  public void enterRespSearchKey(final String resp) {
    WebDriverExtensions.waitToBeClickable(this.txtSearchResp);
    this.txtSearchResp.click();
    BasePage.clearRobustly(this.txtSearchResp);
    this.txtSearchResp.sendKeys(resp);
    this.txtSearchResp.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void SearchWithPlanOrderNo(final String PlnOrd) {
    WebDriverExtensions.EnterText(this.txtPlnOrdNo, PlnOrd);
    this.txtPlnOrdNo.sendKeys(Keys.ENTER);
  }
  
  public String GetStsOfPlnOrd(final String plnOrd) {
    InforGrid grid = new InforGrid(this.gridElement);
    List<String> data = grid.getDataOfRowContainingTextInColumn(1, plnOrd.replaceFirst("^0+(?!$)", ""));
    return data.get(7);
  }
}
