package bi3.pages.mms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001ConnectWarehouseE extends BasePage {
  public MMS001ConnectWarehouseE(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "LBL_L1T6")
  private WebElement pageSubTitle;
  
  @FindBy(id = "MBMSCH-shdo")
  private WebElement btnMastrScheduled;
  
  @FindBy(id = "list-option2")
  private WebElement listItemMastrSchedule;
  
  @FindBy(id = "list-option0")
  private WebElement listItemMastrScheduleCO;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listItemMastrSchedule1;
  
  @FindBy(css = "div[id=\'MBPLCDContainer\']>button")
  private WebElement btnPlanningPolicyOpen;
  
  @FindBy(css = "#POS")
  private WebElement txtPolicy;
  
  @FindBy(css = ".slick-cell.l0.r0.uppercase")
  private WebElement firstGridCell;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnPPSelect;
  
  @FindBy(css = "div[id=\'MBSCPOContainer\']>button")
  private WebElement btnSupplyPolicyOpen;
  
  @FindBy(id = "MBCONC")
  private WebElement checkContNetChange;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public String getPageSubTitle() {
    BasePage.waitForLoadingComplete();
    return this.pageSubTitle.getText();
  }
  
  public void setMastrSchedule(final String mastrScheduled) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.btnMastrScheduled, this.listItemMastrSchedule1, mastrScheduled);
  }
  
  public void setMastrScheduleCO() {
    this.btnMastrScheduled.click();
    this.listItemMastrScheduleCO.click();
  }
  
  public void setPlanningPolicy(final String planningPolicy) {
    try {
      this.btnPlanningPolicyOpen.click();
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeClickable(this.txtPolicy);
      BasePage.clickWhenReady(this.txtPolicy);
      BasePage.clearRobustly(this.txtPolicy);
      this.txtPolicy.sendKeys(planningPolicy);
      this.txtPolicy.sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
      Thread.sleep(2000);
      String _text = this.firstGridCell.getText();
      String _plus = ("First cell content : " + _text);
      System.out.println(_plus);
      String _text_1 = this.firstGridCell.getText();
      boolean _equals = Objects.equal(_text_1, planningPolicy);
      if (_equals) {
        this.firstGridCell.click();
        this.btnPPSelect.click();
      } else {
        System.out.println((("Planning Policy " + planningPolicy) + " not found"));
      }
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void setSupplyPolicy(final String supplyPolicy) {
    try {
      this.btnSupplyPolicyOpen.click();
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeClickable(this.txtPolicy);
      BasePage.clickWhenReady(this.txtPolicy);
      BasePage.clearRobustly(this.txtPolicy);
      this.txtPolicy.sendKeys(supplyPolicy);
      this.txtPolicy.sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
      Thread.sleep(2000);
      String _text = this.firstGridCell.getText();
      boolean _equals = Objects.equal(_text, supplyPolicy);
      if (_equals) {
        this.firstGridCell.click();
        this.btnPPSelect.click();
      } else {
        System.out.println((("Supply Policy " + supplyPolicy) + " not found"));
      }
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void selectContNetChange() {
    String checked = this.checkContNetChange.getAttribute("aria-checked");
    boolean _equals = Objects.equal(checked, "false");
    if (_equals) {
      this.checkContNetChange.click();
    }
  }
  
  public void clickNext() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void selectItemMastrSchedule(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.btnMastrScheduled, this.listItemMastrSchedule1, value);
  }
}
