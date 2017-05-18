package bi3.pages.pps310;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS310E extends BasePage {
  public PPS310E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WBCAQA")
  private WebElement txtApprovedQty;
  
  @FindBy(id = "WWRVQA")
  private WebElement txtReceivedQty;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "WWQCRA-shdo")
  private WebElement btnQIResDropdown;
  
  @FindBy(css = "#dropdown-list>li")
  private List<WebElement> listQIResOptions;
  
  @FindBy(id = "WBRJQA")
  private WebElement txtRejQty;
  
  @FindBy(id = "WWSCRE")
  private WebElement txtRejReason;
  
  public void Next() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void enterApprovedQty() {
    BasePage.waitForLoadingComplete();
    this.txtApprovedQty.sendKeys(BasePage.GetTextBoxvalue(this.txtReceivedQty));
  }
  
  public void SetQIResult(final String res) {
    this.selectFromDropdown(this.btnQIResDropdown, this.listQIResOptions, res);
  }
  
  public void EnterRejectedQtyAsRecieved() {
    WebDriverExtensions.waitToBeClickable(this.txtRejQty);
    this.txtRejQty.click();
    BasePage.clearRobustly(this.txtRejQty);
    this.txtRejQty.sendKeys(BasePage.GetTextBoxvalue(this.txtReceivedQty));
  }
  
  public void EnterRejectReason(final String rejReasonCode) {
    WebDriverExtensions.waitToBeClickable(this.txtRejReason);
    this.txtRejReason.click();
    BasePage.clearRobustly(this.txtRejReason);
    this.txtRejReason.sendKeys(rejReasonCode);
  }
}
