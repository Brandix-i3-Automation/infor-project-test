package bi3.pages.ois101;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS101E extends BasePage {
  public OIS101E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WBUCOS")
  private WebElement txtBoxCost;
  
  @FindBy(id = "WBSAPR")
  private WebElement txtBoxSalesPrice;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void fillPricingInformation(final String SalesPrice, final String CostPrice) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtBoxSalesPrice);
    BasePage.clearRobustly(this.txtBoxSalesPrice);
    this.txtBoxSalesPrice.sendKeys(SalesPrice);
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtBoxCost);
    BasePage.clearRobustly(this.txtBoxCost);
    this.txtBoxCost.sendKeys(CostPrice);
    this.btnNext.click();
  }
  
  public void clickNext() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
