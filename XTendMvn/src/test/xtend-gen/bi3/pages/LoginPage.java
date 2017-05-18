package bi3.pages;

import bi3.framework.core.DefaultWebDriver;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class LoginPage extends BasePage {
  public LoginPage(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = ".table.table-striped.table-bordered")
  private WebElement txtUserName;
  
  @FindBy(css = ".table.table-striped.table-bordered")
  private WebElement txtPassword;
  
  public void GoTo() {
    DefaultWebDriver.driver.get("http://Priyankara:bi3passwordQ8892@bi3-m313-01.brandixlk.org:44056/mne/");
  }
}
