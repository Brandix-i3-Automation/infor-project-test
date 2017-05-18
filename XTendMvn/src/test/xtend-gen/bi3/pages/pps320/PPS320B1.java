package bi3.pages.pps320;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS320B1 extends BasePage {
  public PPS320B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWREPN")
  private WebElement txtReceivingNo;
  
  @FindBy(css = "button[class=\'inforIconButton edit\']")
  private WebElement btnEdit;
  
  @FindBy(css = "div[id*=\'PPA320BS\'][class*=\'inforDataGrid\']")
  private WebElement inforGridPPS320;
  
  @FindBy(id = "XT_0168")
  private WebElement btnApply;
  
  @FindBy(css = "div[class=\'slick-cell l0 r0  alignRight\']")
  private WebElement firstGridCell;
  
  public void enterTheRecivingNo(final String recivingNo) {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtReceivingNo);
    this.txtReceivingNo.sendKeys(recivingNo);
    this.txtReceivingNo.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void editFirstRow() {
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
