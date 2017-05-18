package bi3.pages.pps200;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS200E extends BasePage {
  public PPS200E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "WWPUNO")
  private WebElement txtNewPO;
  
  public void ClickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String getNewPONumber() {
    WebDriverExtensions.waitToBeDisplayed(this.txtNewPO);
    return BasePage.GetTextBoxvalue(this.txtNewPO);
  }
}
