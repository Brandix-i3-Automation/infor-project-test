package bi3.pages.pms001;

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS001E extends BasePage {
  public PMS001E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWORQA")
  private WebElement txtOrderQty;
  
  @FindBy(id = "WAFIDT")
  private WebElement txtFinishDate;
  
  @FindBy(id = "WASTDT")
  private WebElement txtStartDate;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void setOrderQuantity(final String qty) {
    BasePage.waitForLoadingComplete();
    this.txtOrderQty.click();
    BasePage.clearRobustly(this.txtOrderQty);
    this.txtOrderQty.sendKeys(qty);
  }
  
  public void setFinishDate(final String date) {
    BasePage.waitForLoadingComplete();
    this.txtFinishDate.click();
    BasePage.clearRobustly(this.txtFinishDate);
    this.txtFinishDate.sendKeys(date);
  }
  
  public void setStartDate(final String date) {
    BasePage.waitForLoadingComplete();
    this.txtStartDate.click();
    BasePage.clearRobustly(this.txtStartDate);
    this.txtStartDate.sendKeys(date);
  }
  
  public void clickNext() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
