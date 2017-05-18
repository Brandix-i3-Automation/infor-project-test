package bi3.pages.pcs200;

import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PCS200E extends BasePage {
  public PCS200E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWPCTP")
  private WebElement txtCostingType;
  
  @FindBy(id = "WWPRTC-shdo")
  private WebElement cmbPrtCosting;
  
  @FindBy(css = "ul[id=\'dropdown-list\'] li")
  private List<WebElement> lstPrtCosting;
  
  @FindBy(id = "WWCOSN")
  private WebElement txtCostingName;
  
  @FindBy(id = "WWALVL-shdo")
  private WebElement cmbAllLevels;
  
  @FindBy(css = "ul[id=\'dropdown-list\'] li")
  private List<WebElement> lstAllLevels;
  
  @FindBy(id = "WWCOUP-shdo")
  private WebElement cmbCalcpurchdist;
  
  @FindBy(css = "ul[id=\'dropdown-list\'] li")
  private List<WebElement> lstCalcpurchdist;
  
  @FindBy(id = "WWPAVR")
  private WebElement txtView;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void clickNext() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void SelectPrtCosting(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbPrtCosting, this.lstPrtCosting, value);
  }
  
  public void SelectAllLevels(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbAllLevels, this.lstAllLevels, value);
  }
  
  public void SelectCalspurchdist(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbCalcpurchdist, this.lstCalcpurchdist, value);
  }
  
  public void SetCostingType(final String CostingType) {
    BasePage.waitForLoadingComplete();
    this.txtCostingType.click();
    BasePage.clearRobustly(this.txtCostingType);
    this.txtCostingType.sendKeys(CostingType);
    BasePage.waitForLoadingComplete();
  }
  
  public void SetCostingName(final String CostingName) {
    BasePage.waitForLoadingComplete();
    this.txtCostingName.click();
    BasePage.clearRobustly(this.txtCostingName);
    this.txtCostingName.sendKeys(CostingName);
    BasePage.waitForLoadingComplete();
  }
  
  public void SetView(final String View) {
    BasePage.waitForLoadingComplete();
    this.txtView.click();
    BasePage.clearRobustly(this.txtView);
    this.txtView.sendKeys(View);
    BasePage.waitForLoadingComplete();
  }
}
