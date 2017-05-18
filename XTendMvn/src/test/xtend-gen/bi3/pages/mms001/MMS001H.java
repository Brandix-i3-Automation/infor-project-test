package bi3.pages.mms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001H extends BasePage {
  public MMS001H(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WMPUPR")
  private WebElement txtPurchasePrice;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "MMSPUC-shdo")
  private WebElement cmbFixDynUM;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listFixDynUM;
  
  public void Next() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void setPurchasePrice(final String purchasePrice) {
    WebDriverExtensions.waitToBeDisplayed(this.txtPurchasePrice);
    this.txtPurchasePrice.click();
    BasePage.clearRobustly(this.txtPurchasePrice);
    this.txtPurchasePrice.sendKeys(purchasePrice);
  }
  
  public void selectFromFixDynUM(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbFixDynUM, this.listFixDynUM, value);
  }
}
