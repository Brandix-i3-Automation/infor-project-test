package bi3.pages.mns212;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MNS212B1 extends BasePage {
  public MNS212B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WCN1915")
  private WebElement btnConfirmOutput;
  
  /**
   * confirm output function.
   */
  public void confirmOutPut() {
    BasePage.waitForLoadingComplete();
    this.btnConfirmOutput.click();
    BasePage.waitForLoadingComplete();
    this.ClickPrevious();
  }
  
  public void ConfirmOutput() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.btnConfirmOutput);
    this.btnConfirmOutput.click();
  }
}
