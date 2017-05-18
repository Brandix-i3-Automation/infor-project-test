package bi3.pages.pps310;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS310SettingsPage extends BasePage {
  public PPS310SettingsPage(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWSPIC-shdo")
  private WebElement drpOpenningPanel;
  
  @FindBy(css = "li#list-option0")
  private WebElement optOpenningPanel;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void SelectUpdateOpenningPanel() {
    WebDriverExtensions.waitToBeDisplayed(this.drpOpenningPanel);
    this.drpOpenningPanel.click();
    WebDriverExtensions.waitToBeDisplayed(this.optOpenningPanel, 60000);
    this.optOpenningPanel.click();
    this.btnNext.click();
  }
}
