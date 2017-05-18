package bi3.pages.pms230;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS230B1 extends BasePage {
  public PMS230B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "ActionsBtn")
  private WebElement btnAction;
  
  @FindBy(xpath = "//*[contains(text(),\'Select\')]//span")
  private WebElement btnSelect;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(css = "div[row=\'0\']")
  private WebElement firstGridCell;
  
  @FindBy(xpath = "//a[contains(text(),\'Related\')]")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Report Issue\')]")
  private WebElement linkReportIssue;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Report Operations\')]")
  private WebElement linkReportOperations;
  
  public void SelectScheduleNo() {
    this.btnAction.click();
    this.btnSelect.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void ClickReportIssue() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    this.linkReportIssue.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void ClickReportOperations() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    this.linkReportOperations.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void SelectFirstRow() {
    this.firstGridCell.click();
  }
}
