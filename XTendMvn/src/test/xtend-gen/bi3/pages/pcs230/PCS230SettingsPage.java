package bi3.pages.pcs230;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PCS230SettingsPage extends BasePage {
  public PCS230SettingsPage(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "WWDSEQ")
  private WebElement txtPanelSequence;
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void enterPanelSequence(final String panelSequence) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtPanelSequence);
    this.txtPanelSequence.click();
    BasePage.clearRobustly(this.txtPanelSequence);
    this.txtPanelSequence.sendKeys(panelSequence);
  }
}
