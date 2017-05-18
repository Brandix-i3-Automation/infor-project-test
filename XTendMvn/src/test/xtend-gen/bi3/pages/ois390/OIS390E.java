package bi3.pages.ois390;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS390E extends BasePage {
  public OIS390E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "#WWRSCD")
  private WebElement txtTransReason;
  
  @FindBy(css = "#Prev")
  private WebElement btnPrev;
  
  public void ClickPrev() {
    BasePage.waitForLoadingComplete();
    this.btnPrev.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void selectTransReason(final String tranceReason) {
    this.txtTransReason.click();
    BasePage.clearRobustly(this.txtTransReason);
    this.txtTransReason.sendKeys(tranceReason);
  }
}
