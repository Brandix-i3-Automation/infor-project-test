package bi3.pages.ois300;

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
public class OIS300MaterialPlan extends BasePage {
  public OIS300MaterialPlan(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(xpath = "//a/span[contains(text(),\'Change\')]")
  private WebElement linkChange;
  
  @FindBy(css = "div[id*=\'MMA080B1\'][class*=\'inforDataGrid\'")
  private WebElement inforGridOIS300;
  
  @FindBy(id = "W1ORCA")
  private WebElement txtOct;
  
  @FindBy(css = "button[class=\'inforIconButton refresh\']")
  private WebElement btnRefresh;
  
  @FindBy(id = "ActionsBtn")
  private WebElement btnAction;
  
  @FindBy(css = "ul[class=\'inforContextMenu inforMenuOptions\'] >li")
  private List<WebElement> listActionbtn;
  
  public String getTheOrderNumber(final String stat) {
    InforGrid inforGridOIS300 = new InforGrid(this.inforGridOIS300);
    final List<String> data = inforGridOIS300.getDataOfRowContainingTextInColumn(6, stat);
    System.out.println(data);
    final String orderNo = data.get(8).toString();
    System.out.println(orderNo);
    return orderNo;
  }
  
  public void changeMaterialPlan(final String orderNo) {
    InforGrid inforGridOIS300 = new InforGrid(this.inforGridOIS300);
    BasePage.waitForLoadingComplete();
    final WebElement element = inforGridOIS300.getRowContainingTextInColumn(9, orderNo);
    System.out.println(element);
    this.rightClick(element);
    this.linkChange.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void refreshTheGrid() {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtOct);
    this.btnRefresh.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void calculateMRP() {
    try {
      BasePage.waitForLoadingComplete();
      this.selectFromDropdown(this.btnAction, this.listActionbtn, "Calculate MRP");
      Thread.sleep(10000);
      this.btnRefresh.click();
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean isGridEmpty() {
    BasePage.waitForLoadingComplete();
    InforGrid inforGridOIS300 = new InforGrid(this.inforGridOIS300);
    this.txtOct.sendKeys("250");
    this.txtOct.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    System.out.println(inforGridOIS300);
    int _rowCount = inforGridOIS300.getRowCount();
    boolean _equals = (_rowCount == 0);
    if (_equals) {
      return true;
    } else {
      return false;
    }
  }
  
  public void searchForStat(final String stat) {
    WebDriverExtensions.waitToBeClickable(this.txtOct);
    this.txtOct.click();
    BasePage.clearRobustly(this.txtOct);
    this.txtOct.sendKeys(stat);
    this.txtOct.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
}
