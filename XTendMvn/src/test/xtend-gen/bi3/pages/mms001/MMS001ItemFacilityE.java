package bi3.pages.mms001;

import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001ItemFacilityE extends BasePage {
  public MMS001ItemFacilityE(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "M9VAMT-shdo")
  private WebElement cmbInvAccMethod;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listInvAccMethod;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void clickNext() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void selectInvAccMethod(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbInvAccMethod, this.listInvAccMethod, value);
  }
}
