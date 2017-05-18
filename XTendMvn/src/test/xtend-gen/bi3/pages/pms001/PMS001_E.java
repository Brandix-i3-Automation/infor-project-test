package bi3.pages.pms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import com.google.common.base.Objects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS001_E extends BasePage {
  public PMS001_E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWORQA")
  private WebElement txtOrderQty;
  
  @FindBy(id = "WAFIDT")
  private WebElement txtFinishDate;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "#WAORTY+ button")
  private WebElement btnOrderTypeOpen;
  
  @FindBy(id = "pos")
  private WebElement txtOtp;
  
  @FindBy(css = "div[row=\'0\'] div.slick-cell.l0.r0.uppercase")
  private WebElement firstGridCell;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  public void EnterOrderQty(final String Qty) {
    BasePage.waitForLoadingComplete();
    this.txtOrderQty.click();
    this.txtOrderQty.sendKeys(Qty);
  }
  
  public void EnterFinishDate(final String finishDate) {
    BasePage.waitForLoadingComplete();
    this.txtFinishDate.click();
    BasePage.clearRobustly(this.txtFinishDate);
    this.txtFinishDate.sendKeys(finishDate);
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void setOrderType(final String orderType) {
    this.btnOrderTypeOpen.click();
    BasePage.waitForLoadingComplete();
    this.txtOtp.click();
    BasePage.clearRobustly(this.txtOtp);
    this.txtOtp.sendKeys(orderType);
    this.txtOtp.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    String _text = this.firstGridCell.getText();
    String _plus = ("First cell content : " + _text);
    System.out.println(_plus);
    String _text_1 = this.firstGridCell.getText();
    boolean _equals = Objects.equal(_text_1, orderType);
    if (_equals) {
      this.firstGridCell.click();
      this.btnSelect.click();
    } else {
      System.out.println((("order type " + orderType) + " not found"));
    }
    BasePage.waitForLoadingComplete();
  }
}
