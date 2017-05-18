package bi3.pages.mms077;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS077 extends BasePage {
  public MMS077(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWSTYN")
  private WebElement txtStyle;
  
  @FindBy(css = "div[panelname=\'MMA077BC\'] #XT_0168")
  private WebElement btnApply;
  
  @FindBy(id = "X__6204")
  private WebElement btnCreate;
  
  @FindBy(css = "div[panelname=\'MMA077BC\'] span[class=\'errorMessage inforLabel noColon\']")
  private WebElement lblErrorMessage;
  
  public void CreateItemsByMatrix(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtStyle);
    this.txtStyle.clear();
    this.txtStyle.sendKeys(itemNumber);
    WebDriverExtensions.pressEnterKey(this.txtStyle);
    BasePage.waitForLoadingComplete();
    this.btnApply.click();
    BasePage.waitForLoadingComplete();
    this.btnApply.click();
    BasePage.waitForLoadingComplete();
    this.btnCreate.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void navigateToselectMedia() {
    BasePage.waitForLoadingComplete();
    this.txtStyle.sendKeys(Keys.chord(Keys.SHIFT, Keys.F2));
    BasePage.waitForLoadingComplete();
  }
  
  public String ConfirmMsg() {
    return this.lblErrorMessage.getText().toString();
  }
}
