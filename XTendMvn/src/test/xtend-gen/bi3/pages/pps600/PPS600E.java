package bi3.pages.pps600;

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS600E extends BasePage {
  public PPS600E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WFPUNO")
  private WebElement txtPONumberFrom;
  
  @FindBy(id = "WTPUNO")
  private WebElement txtPONumberTo;
  
  @FindBy(id = "WTPUSL")
  private WebElement txtLowestStatusTo;
  
  @FindBy(id = "WTPUST")
  private WebElement txtHighestStatusTo;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void FillPONumbers(final String PONumber) {
    BasePage.waitForLoadingComplete();
    this.txtPONumberFrom.click();
    BasePage.clearRobustly(this.txtPONumberFrom);
    this.txtPONumberFrom.sendKeys(PONumber);
    this.txtPONumberTo.click();
    BasePage.clearRobustly(this.txtPONumberTo);
    this.txtPONumberTo.sendKeys(PONumber);
  }
  
  public void FillLowestStatus(final String lowestStaus) {
    BasePage.waitForLoadingComplete();
    this.txtLowestStatusTo.click();
    BasePage.clearRobustly(this.txtLowestStatusTo);
    this.txtLowestStatusTo.sendKeys(lowestStaus);
  }
  
  public void FillHighestStatus(final String highestStatus) {
    BasePage.waitForLoadingComplete();
    this.txtHighestStatusTo.click();
    BasePage.clearRobustly(this.txtHighestStatusTo);
    this.txtHighestStatusTo.sendKeys(highestStatus);
  }
  
  public void clickNext() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
