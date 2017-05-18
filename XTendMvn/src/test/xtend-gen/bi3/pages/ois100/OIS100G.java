package bi3.pages.ois100;

import bi3.framework.core.DefaultWebDriver;
import bi3.pages.BasePage;
import java.util.concurrent.TimeUnit;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS100G extends BasePage {
  public OIS100G(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "OACUOR")
  private WebElement txtCustomerOrd;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "dbtnok")
  private WebElement btnOk;
  
  public void clickNext() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void fillCustomerOrd(final String CustomerOrd) {
    BasePage.waitForLoadingComplete();
    this.txtCustomerOrd.click();
    BasePage.clearRobustly(this.txtCustomerOrd);
    this.txtCustomerOrd.sendKeys(CustomerOrd);
  }
  
  public void handleWarning() {
    BasePage.waitForLoadingComplete();
    this.btnOk.click();
  }
  
  public void handleAbnormalException() {
    try {
      BasePage.waitForLoadingComplete();
      DefaultWebDriver.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      while (this.btnOk.isDisplayed()) {
        {
          BasePage.clickWhenReady(this.btnOk);
          BasePage.waitForLoadingComplete();
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      DefaultWebDriver.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
  }
}
