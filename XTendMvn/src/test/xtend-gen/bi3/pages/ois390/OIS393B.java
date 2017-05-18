package bi3.pages.ois390;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS393B extends BasePage {
  public OIS393B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(xpath = ".//*[@id=\'messageBarContent\']/span")
  private WebElement lblWarning;
  
  public String getTemporaryOrderValue() {
    WebDriverExtensions.waitToBeDisplayed(this.lblWarning);
    return this.lblWarning.getText();
  }
}
