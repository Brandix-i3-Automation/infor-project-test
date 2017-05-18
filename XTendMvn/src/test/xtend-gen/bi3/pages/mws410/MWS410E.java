package bi3.pages.mws410;

import bi3.framework.core.DefaultWebDriver;
import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MWS410E extends BasePage {
  public MWS410E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "OQDLIX")
  private WebElement txtDeliveryNo;
  
  public String getDeliveryNumber() {
    return this.txtDeliveryNo.getText();
  }
  
  public void GoToPanel(final String panelId) {
    WebElement btnPanel = DefaultWebDriver.driver.findElement(By.cssSelector((("div[class=\'lawsonPanelSequenceItem\'][value=\'" + panelId) + "\']")));
    WebDriverExtensions.waitToBeClickable(btnPanel);
    btnPanel.click();
    BasePage.waitForLoadingComplete();
  }
}
