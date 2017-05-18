package bi3.pages.ois300;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS300CutomerOrderOpenLines extends BasePage {
  public OIS300CutomerOrderOpenLines(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(linkText = "Related")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Sim comp avail\')]")
  private WebElement linkSimCompAvail;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  public void goToSimCopAvail() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkSimCompAvail);
    this.linkSimCompAvail.click();
    BasePage.waitForLoadingComplete();
  }
}
