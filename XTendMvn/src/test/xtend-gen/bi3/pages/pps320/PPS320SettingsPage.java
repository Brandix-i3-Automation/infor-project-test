package bi3.pages.pps320;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS320SettingsPage extends BasePage {
  public PPS320SettingsPage(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(xpath = "//a[text()=\'Settings\']")
  private WebElement linkSettings;
  
  @FindBy(id = "WWSPIC-shdo")
  private WebElement openingPanel;
  
  @FindBy(id = "list-option0")
  private WebElement listOption1;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void clickNext() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void goToSettings() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.linkSettings);
    this.linkSettings.click();
  }
  
  public void changeOpeningPanel() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.openingPanel);
    this.openingPanel.click();
    WebDriverExtensions.waitToBeClickable(this.listOption1);
    this.listOption1.click();
  }
}
