package bi3.pages.mms002;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS002B extends BasePage {
  public MMS002B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1OBKV")
  private WebElement txtItemNumber;
  
  @FindBy(css = ".slick-cell.l1.r1")
  private WebElement gridFirstLine;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Change\')]")
  private WebElement linkChange;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  /**
   * Enter Item Number
   */
  public void enterItemNumber(final String newRawMatNumber) {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtItemNumber);
    this.txtItemNumber.sendKeys(newRawMatNumber);
    BasePage.waitForLoadingComplete();
    this.txtItemNumber.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * Select Change Item
   */
  public void selectChange() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkChange);
    this.linkChange.click();
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * Go to H panel
   */
  public void clickNext() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
