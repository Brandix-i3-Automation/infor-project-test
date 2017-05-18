package bi3.pages.mws410;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MWS410I extends BasePage {
  public MWS410I(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWTSID")
  private WebElement txtTranspId;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void setTransId(final String transpId) {
    WebDriverExtensions.waitToBeClickable(this.txtTranspId);
    this.txtTranspId.click();
    BasePage.clearRobustly(this.txtTranspId);
    this.txtTranspId.sendKeys(transpId);
  }
  
  public void Next() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
