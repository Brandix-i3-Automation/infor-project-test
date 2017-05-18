package bi3.pages.pms050;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS050E extends BasePage {
  public PMS050E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWORQA")
  private WebElement txtOrderQty;
  
  @FindBy(id = "WHMAQA")
  private WebElement txtManufQty;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void enterManufQtyAsOrderQty() {
    WebDriverExtensions.waitToBeClickable(this.txtManufQty);
    this.txtManufQty.click();
    BasePage.clearRobustly(this.txtManufQty);
    this.txtManufQty.sendKeys(BasePage.GetTextBoxvalue(this.txtOrderQty));
  }
  
  public void ClickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
