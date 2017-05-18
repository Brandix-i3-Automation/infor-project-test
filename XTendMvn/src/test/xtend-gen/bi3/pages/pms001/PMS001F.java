package bi3.pages.pms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import com.google.common.base.Objects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS001F extends BasePage {
  public PMS001F(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "input[id=\'WFSCHN\'] + button")
  private WebElement btnScheduleNumberLookUp;
  
  @FindBy(id = "POS")
  private WebElement txtSchedNo;
  
  @FindBy(css = "div[row=\'0\']>div[class=\'slick-cell l0 r0\']")
  private WebElement firstGridCell;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void selectSchedNoFromLookUp(final String schedNo) {
    WebDriverExtensions.waitToBeDisplayed(this.btnScheduleNumberLookUp);
    WebDriverExtensions.waitToBeClickable(this.btnScheduleNumberLookUp);
    this.btnScheduleNumberLookUp.click();
    BasePage.waitForLoadingComplete();
    this.txtSchedNo.click();
    BasePage.clearRobustly(this.txtSchedNo);
    this.txtSchedNo.sendKeys(schedNo);
    this.txtSchedNo.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    String _text = this.firstGridCell.getText();
    boolean _equals = Objects.equal(_text, schedNo);
    if (_equals) {
      this.firstGridCell.click();
      this.btnSelect.click();
    } else {
      System.out.println((("Operation ID " + schedNo) + " not found"));
    }
    BasePage.waitForLoadingComplete();
  }
  
  public void clickNext() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
