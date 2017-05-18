package bi3.pages.mws423;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MWS423B1 extends BasePage {
  public MWS423B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div#W1PACTContainer button span")
  private WebElement btnnavPackaging;
  
  @FindBy(id = "POS")
  private WebElement txtPckgng;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(id = "Next")
  private WebElement btnDisplay;
  
  public void SelectPackaging(final String packgng) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.btnnavPackaging);
    this.btnnavPackaging.click();
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.txtPckgng);
    this.txtPckgng.sendKeys(packgng);
    this.txtPckgng.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    this.gridFirstLine.click();
    this.btnSelect.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToNext() {
    WebDriverExtensions.waitToBeDisplayed(this.btnDisplay);
    this.btnDisplay.click();
  }
}
