package bi3.pages.mms002;

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS002E extends BasePage {
  public MMS002E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "MBCONC")
  private WebElement chkContNetChange;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "#tabsList > li.ui-tabs-selected.ui-state-active > button")
  private WebElement btnClose;
  
  /**
   * Check Count Net Change box
   */
  public void checkContNetChange() {
    BasePage.waitForLoadingComplete();
    this.chkContNetChange.click();
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * Go to F panel
   */
  public void clickNext() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void close() {
    this.btnClose.click();
    System.out.println("MMS001 tab closed");
  }
}
