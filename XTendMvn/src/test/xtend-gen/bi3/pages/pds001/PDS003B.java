package bi3.pages.pds001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PDS003B extends BasePage {
  public PDS003B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WNOTYP")
  private WebElement txtStp;
  
  @FindBy(id = "WNFTID")
  private WebElement txtSelectionId;
  
  @FindBy(id = "WNOPTN")
  private WebElement txtOption;
  
  @FindBy(id = "POS")
  private WebElement txtFeature;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  public void setstp(final String stp) {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtStp);
    this.txtStp.sendKeys(stp);
  }
  
  public void setSelectId(final String Id) {
    try {
      BasePage.waitForLoadingComplete();
      BasePage.clearRobustly(this.txtSelectionId);
      this.txtSelectionId.sendKeys(Keys.F4);
      BasePage.waitForLoadingComplete();
      this.txtFeature.sendKeys(Id);
      this.txtFeature.sendKeys(Keys.ENTER);
      try {
        this.gridFirstLine.click();
      } catch (final Throwable _t) {
        if (_t instanceof StaleElementReferenceException) {
          final StaleElementReferenceException ex = (StaleElementReferenceException)_t;
          Thread.sleep(2000);
          WebDriverExtensions.waitToBeDisplayed(this.gridFirstLine);
          this.gridFirstLine.click();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      this.btnSelect.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void setOption(final String option) {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtOption);
    this.txtOption.sendKeys(Keys.F4);
    BasePage.waitForLoadingComplete();
    this.txtOption.sendKeys(option);
    this.txtOption.sendKeys(Keys.ENTER);
    this.gridFirstLine.click();
    this.btnSelect.click();
  }
}
