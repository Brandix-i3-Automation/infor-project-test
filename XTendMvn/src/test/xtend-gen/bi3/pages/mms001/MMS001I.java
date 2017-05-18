package bi3.pages.mms001;

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001I extends BasePage {
  public MMS001I(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "startDiv")
  private WebElement btnHome;
  
  public void Next() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToHome() {
    this.btnHome.click();
    BasePage.waitForLoadingComplete();
  }
}
