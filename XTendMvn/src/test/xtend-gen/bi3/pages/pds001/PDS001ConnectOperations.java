package bi3.pages.pds001;

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PDS001ConnectOperations extends BasePage {
  public PDS001ConnectOperations(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "POPITI")
  private WebElement txtRuntime;
  
  public void setRuntime(final String runtime) {
    BasePage.waitForLoadingComplete();
    this.txtRuntime.click();
    BasePage.clearRobustly(this.txtRuntime);
    this.txtRuntime.sendKeys(runtime);
  }
}
