package bi3.pages.pms070;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS070E extends BasePage {
  public PMS070E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WOUMAT")
  private WebElement txtLabRunTime;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void setLabRuntime(final String runtime) {
    WebDriverExtensions.waitToBeClickable(this.txtLabRunTime);
    this.txtLabRunTime.click();
    BasePage.clearRobustly(this.txtLabRunTime);
    this.txtLabRunTime.sendKeys(runtime);
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
