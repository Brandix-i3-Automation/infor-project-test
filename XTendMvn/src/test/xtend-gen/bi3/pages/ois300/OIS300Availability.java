package bi3.pages.ois300;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS300Availability extends BasePage {
  public OIS300Availability(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(xpath = "//a/span[contains(text(),\'Material Plan\')]")
  private WebElement linkMaterialPlan;
  
  @FindBy(linkText = "Related")
  private WebElement linkRelated;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  public void goToMaterilaPlan() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkMaterialPlan);
    this.linkMaterialPlan.click();
    BasePage.waitForLoadingComplete();
  }
}
