package bi3.pages.ois390;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS392E extends BasePage {
  public OIS392E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "#WWREQ6")
  private WebElement txtRejectedQty;
  
  @FindBy(id = "WWBANO")
  private WebElement txtLotNumber;
  
  @FindBy(css = "#W6BANO")
  private WebElement txtDetailsLotNumber;
  
  @FindBy(css = "#W6WHSL")
  private WebElement txtLocation;
  
  public void enterLotNumber(final String schNo) {
    BasePage.waitForLoadingComplete();
    this.txtDetailsLotNumber.click();
    this.txtDetailsLotNumber.sendKeys(schNo);
  }
  
  public void enterRejectedQty(final String rejectedQty) {
    this.txtRejectedQty.click();
    BasePage.clearRobustly(this.txtRejectedQty);
    this.txtRejectedQty.sendKeys(rejectedQty);
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String getLotValue() {
    WebDriverExtensions.waitToBeDisplayed(this.txtLotNumber);
    return BasePage.GetTextBoxvalue(this.txtLotNumber);
  }
  
  public void enterLocation(final String location) {
    BasePage.waitForLoadingComplete();
    this.txtLocation.click();
    BasePage.clearRobustly(this.txtLocation);
    this.txtLocation.sendKeys(location);
    BasePage.waitForLoadingComplete();
  }
}
