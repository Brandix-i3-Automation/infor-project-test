package bi3.pages;

import bi3.framework.core.DefaultWebDriver;
import bi3.pages.BasePage;
import java.util.concurrent.TimeUnit;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
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
  
  @FindBy(id = "MenuTabLabel")
  private WebElement lblMenu;
  
  public void GoTo() {
    try {
      DefaultWebDriver.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
      String labelName = this.lblMenu.getText();
      InputOutput.<String>println(labelName);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        DefaultWebDriver.driver.get("http://rasithae:ras8@brandixi3@bi3-m313-01.brandixlk.org:44056/mne/");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      DefaultWebDriver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
  }
}
