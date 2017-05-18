package bi3.pages.pps220;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS220I1 extends BasePage {
  public PPS220I1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(xpath = "//a/span[text()=\'Change\']")
  private WebElement linkChange;
  
  @FindBy(xpath = "//a[text()=\'Confirm Update\']")
  private WebElement linkConfirmUpdate;
  
  public void clickChange() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkChange);
    this.linkChange.click();
  }
  
  public void clickConfirmUpdate() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.linkConfirmUpdate);
    this.linkConfirmUpdate.click();
  }
}
