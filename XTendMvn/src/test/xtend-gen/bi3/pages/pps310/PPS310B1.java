package bi3.pages.pps310;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS310B1 extends BasePage {
  public PPS310B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWREPN")
  private WebElement txtRecivingNo;
  
  @FindBy(id = "WWREPN")
  private WebElement btnApply;
  
  @FindBy(id = "div[id*=\'PPA310BS\'][class*=\'inforDataGrid\']")
  private WebElement inforGridPPS310;
  
  @FindBy(css = "button[class=\'inforIconButton edit\']")
  private WebElement btnEdit;
  
  @FindBy(css = "div[class=\'slick-cell l0 r0  alignRight\']")
  private WebElement firstGridCell;
  
  public void enterTheRecivingNo(final String recivingNo) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtRecivingNo);
    this.txtRecivingNo.click();
    BasePage.clearRobustly(this.txtRecivingNo);
    this.txtRecivingNo.sendKeys(recivingNo);
    this.txtRecivingNo.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void editFirstRecord() {
    WebDriverExtensions.waitToBeClickable(this.firstGridCell);
    this.firstGridCell.click();
    this.btnEdit.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void clickApply() {
    WebDriverExtensions.waitToBeClickable(this.btnApply);
    this.btnApply.click();
    BasePage.waitForLoadingComplete();
  }
}
