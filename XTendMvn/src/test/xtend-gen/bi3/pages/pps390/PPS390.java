package bi3.pages.pps390;

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS390 extends BasePage {
  public PPS390(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "ActionsBtn")
  private WebElement btnActions;
  
  @FindBy(css = "a[href=\'#F14\']")
  private WebElement btnPrint;
  
  /**
   * Action to go to print page.
   */
  public void goToPrintPage() {
    BasePage.waitForLoadingComplete();
    this.btnActions.click();
    this.btnPrint.click();
  }
}
