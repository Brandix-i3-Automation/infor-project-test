package bi3.pages.mms077;

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS077_SelectMedia extends BasePage {
  public MMS077_SelectMedia(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WCN1915")
  private WebElement btnConfirm;
  
  public void ConfirmOutput() {
    BasePage.waitForLoadingComplete();
    this.btnConfirm.click();
  }
}
