package bi3.pages.mms002;

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS002F extends BasePage {
  public MMS002F(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  /**
   * Go to G panel
   */
  public void clickNext() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
