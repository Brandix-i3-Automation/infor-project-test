package bi3.pages.pms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS001_B extends BasePage {
  public PMS001_B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WAPRNO")
  private WebElement txtProductNo;
  
  @FindBy(css = "button.inforIconButton.new")
  private WebElement btnCreate;
  
  @FindBy(css = "div[id*=\'PMA001BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElementPMA001BS;
  
  public void EnterProductNumber(final String productNumber) {
    BasePage.waitForLoadingComplete();
    this.txtProductNo.click();
    BasePage.clearRobustly(this.txtProductNo);
    this.txtProductNo.sendKeys(productNumber);
    this.txtProductNo.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void ClickOnCreate() {
    WebDriverExtensions.waitToBeClickable(this.btnCreate);
    this.btnCreate.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void EnterProductNumInGrid(final String productNumber) {
    InforGrid grid = new InforGrid(this.gridElementPMA001BS);
    grid.setValueToColumnSearchField("Product", productNumber);
    this.txtProductNo.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
}
