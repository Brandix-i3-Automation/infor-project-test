package bi3.pages.mms101;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS101B1 extends BasePage {
  public MMS101B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void GoBack() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.btnNext);
    this.btnNext.sendKeys(Keys.F12);
    BasePage.waitForLoadingComplete();
  }
}
