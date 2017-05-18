package bi3.pages.pds001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PDS001F extends BasePage {
  public PDS001F(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "TX60")
  private WebElement txtAreaM3Text;
  
  @FindBy(id = "dbtnent")
  private WebElement btnM3Textnext;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void setM3Text(final String text) {
    BasePage.waitForLoadingComplete();
    this.txtAreaM3Text.sendKeys(text);
    WebDriverExtensions.waitToBeClickable(this.btnM3Textnext);
    this.btnM3Textnext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void Next() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
