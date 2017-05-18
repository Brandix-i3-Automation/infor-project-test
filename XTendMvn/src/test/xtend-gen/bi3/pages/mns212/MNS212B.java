package bi3.pages.mns212;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MNS212B extends BasePage {
  public MNS212B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WCN1915")
  private WebElement btnConfirmOutput;
  
  public void ConfirmOutput() {
    WebDriverExtensions.waitToBeClickable(this.btnConfirmOutput);
    this.btnConfirmOutput.click();
    BasePage.waitForLoadingComplete();
  }
}
