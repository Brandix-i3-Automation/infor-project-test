package bi3.pages.ois390;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS391E extends BasePage {
  public OIS391E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "#WWREQ1")
  private WebElement txtReturnedQty;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement firstGridCell;
  
  public void SelectFirstRows() {
    BasePage.waitForLoadingComplete();
    this.firstGridCell.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void enterReturnedQty(final String returnedQty) {
    this.txtReturnedQty.click();
    BasePage.clearRobustly(this.txtReturnedQty);
    this.txtReturnedQty.sendKeys(returnedQty);
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
