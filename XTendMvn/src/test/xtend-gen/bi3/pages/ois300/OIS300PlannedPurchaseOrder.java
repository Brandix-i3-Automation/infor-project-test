package bi3.pages.ois300;

import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS300PlannedPurchaseOrder extends BasePage {
  public OIS300PlannedPurchaseOrder(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WEPSTS-shdo")
  private WebElement cmbStatus;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listStatus;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "WFBUYE")
  private WebElement txtBuyerFrom;
  
  @FindBy(id = "WTBUYE")
  private WebElement txtBuyerTo;
  
  public void setStatus(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbStatus, this.listStatus, value);
  }
  
  public void Next() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
  }
  
  public void clearBuyerFrom() {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtBuyerFrom);
  }
  
  public void clearBuyerTo() {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtBuyerTo);
  }
}
