package bi3.pages.pps820;

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS820E extends BasePage {
  public PPS820E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WFCLRE")
  private WebElement txtOurReferenceFrom;
  
  @FindBy(id = "WTCLRE")
  private WebElement txtOurReferenceTo;
  
  @FindBy(id = "WFCLAN")
  private WebElement txtRstOrdNoFrom;
  
  @FindBy(id = "WTCLAN")
  private WebElement txtRstOrdNoTo;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  /**
   * clear from - to textbox references.
   */
  public void clearReference() {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtOurReferenceFrom);
    BasePage.clearRobustly(this.txtOurReferenceTo);
  }
  
  /**
   * fill the rts order no.
   */
  public void fillRtsOrderNo(final String rtsOrderNo) {
    this.txtRstOrdNoFrom.sendKeys(rtsOrderNo);
    this.txtRstOrdNoTo.sendKeys(rtsOrderNo);
    this.btnNext.click();
  }
}
