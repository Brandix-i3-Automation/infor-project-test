package bi3.pages.pps320;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS320A extends BasePage {
  public PPS320A(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWREPN")
  private WebElement txtRecvngNo;
  
  @FindBy(id = "WWWHLO")
  private WebElement txtWarehouse;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "MyCanvasLbl")
  private WebElement linkStart;
  
  @FindBy(id = "WWRESP")
  private WebElement txtResponsile;
  
  public void setReceivingNo(final String rcvngNo) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtRecvngNo);
    this.txtRecvngNo.click();
    BasePage.clearRobustly(this.txtRecvngNo);
    this.txtRecvngNo.sendKeys(rcvngNo);
  }
  
  public void setWarehouse(final String warehouse) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtWarehouse);
    this.txtWarehouse.click();
    BasePage.clearRobustly(this.txtWarehouse);
    this.txtWarehouse.sendKeys(warehouse);
  }
  
  public void ClickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void goToStartPage() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.linkStart);
    this.linkStart.click();
  }
  
  public void GoToOutputSelectMedia() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtResponsile);
    this.txtResponsile.click();
    BasePage.waitForLoadingComplete();
    this.txtResponsile.sendKeys(Keys.F3);
  }
}
