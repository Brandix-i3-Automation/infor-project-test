package bi3.pages.pms270;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS270E extends BasePage {
  public PMS270E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWTX40")
  private WebElement txtSchedNo;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public String GetSchedNo() {
    return BasePage.GetTextBoxvalue(this.txtSchedNo);
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
