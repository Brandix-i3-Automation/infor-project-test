package bi3.pages.pps200;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS200C extends BasePage {
  public PPS200C(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "CPPUNO")
  private WebElement txtNewPONum;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void ClickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void SetNewPONum(final String po) {
    WebDriverExtensions.waitToBeClickable(this.txtNewPONum);
    this.txtNewPONum.click();
    BasePage.clearRobustly(this.txtNewPONum);
    this.txtNewPONum.sendKeys(po);
  }
  
  public void ClearNewPONumber() {
    WebDriverExtensions.waitToBeClickable(this.txtNewPONum);
    this.txtNewPONum.click();
    BasePage.clearRobustly(this.txtNewPONum);
  }
}
