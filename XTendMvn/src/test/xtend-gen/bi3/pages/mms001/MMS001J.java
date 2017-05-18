package bi3.pages.mms001;

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001J extends BasePage {
  public MMS001J(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void Next() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
