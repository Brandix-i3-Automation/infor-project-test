package bi3.pages.mms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001ItemFacility extends BasePage {
  public MMS001ItemFacility(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(xpath = "//a/span[contains(text(),\'Change\')]")
  private WebElement linkChange;
  
  @FindBy(css = ".slick-cell.l1.r1")
  private WebElement gridFirstLine;
  
  public void selectChnage() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkChange);
    this.linkChange.click();
    BasePage.waitForLoadingComplete();
  }
}
