package bi3.pages.pps300;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS300E extends BasePage {
  public PPS300E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWCFQA")
  private WebElement txtConfirmedQty;
  
  @FindBy(id = "WBRVQA")
  private WebElement txtRecievedQty;
  
  @FindBy(id = "WTBREM")
  private WebElement txtRemark;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void SetRecieveQtyAsConfirmedQty() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtRecievedQty);
    this.txtRecievedQty.click();
    BasePage.clearRobustly(this.txtRecievedQty);
    String confQty = BasePage.GetTextBoxvalue(this.txtConfirmedQty);
    System.out.println((("Setting confirmed qty " + confQty) + " as recieved qty"));
    this.txtRecievedQty.sendKeys(confQty);
  }
  
  public void ClickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void fillRemarks(final String Remark) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtRemark);
    this.txtRemark.click();
    this.txtRemark.sendKeys(Remark);
  }
}
