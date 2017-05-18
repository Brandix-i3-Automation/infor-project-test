package bi3.pages.pps600;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS600F extends BasePage {
  public PPS600F(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WRLITX")
  private WebElement txtReport;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void FillReportText(final String PoNumber) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.txtReport);
    this.txtReport.click();
    BasePage.clearRobustly(this.txtReport);
    this.txtReport.sendKeys(PoNumber);
  }
  
  public void clickNext() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
