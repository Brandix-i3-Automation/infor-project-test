package bi3.pages.pps270;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS270E extends BasePage {
  public PPS270E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WCFWRF")
  private WebElement txtFwd;
  
  @FindBy(id = "WCBOLN")
  private WebElement txtBillOfLading;
  
  @FindBy(id = "WCCARN")
  private WebElement txtCarrirer;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void clickNext() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void fillFwd(final String Fwd) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtFwd);
    this.txtFwd.click();
    this.txtFwd.sendKeys(Fwd);
  }
  
  public void fillBilOfLading(final String Bol) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtBillOfLading);
    this.txtBillOfLading.click();
    this.txtBillOfLading.sendKeys(Bol);
  }
  
  public void fillCarrierName(final String CarrierName) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtCarrirer);
    this.txtCarrirer.click();
    this.txtCarrirer.sendKeys(CarrierName);
  }
}
