package bi3.pages.pps913;

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS913E extends BasePage {
  public PPS913E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WFBUYE")
  private WebElement txtBuyerFrom;
  
  @FindBy(id = "WTBUYE")
  private WebElement txtBuyerTo;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void clearBuyer() {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtBuyerFrom);
    BasePage.clearRobustly(this.txtBuyerTo);
  }
  
  public void Next() {
    BasePage.clickWhenReady(this.btnNext);
    BasePage.waitForLoadingComplete();
  }
}
