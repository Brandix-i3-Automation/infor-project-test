package bi3.pages.pps330;

import bi3.framework.core.DefaultWebDriver;
import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS330B1 extends BasePage {
  public PPS330B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1PUNO")
  private WebElement txtPONumber;
  
  @FindBy(id = "W1WHLO")
  private WebElement txtWarehouse;
  
  @FindBy(linkText = "Start")
  private WebElement linkStart;
  
  public void SearchPO(final String ponumber) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.txtPONumber);
    BasePage.clearRobustly(this.txtPONumber);
    this.txtPONumber.sendKeys(ponumber);
    WebDriverExtensions.waitToBeDisplayed(this.txtWarehouse);
    BasePage.clearRobustly(this.txtWarehouse);
    this.txtWarehouse.sendKeys("002");
    this.txtWarehouse.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void GoToStart() {
    this.linkStart.click();
  }
  
  public boolean checkStatus65ForPO(final String po) {
    BasePage.waitForLoadingComplete();
    boolean exists = false;
    String xpath = (("//div[contains(@class, \'slick-cell l0\')][contains(text(),\'" + po) + "\')]/../div[9]");
    List<WebElement> stats = DefaultWebDriver.driver.findElements(By.xpath(xpath));
    for (int i = 1; (i < stats.size()); i++) {
      {
        WebDriverExtensions.waitToBeDisplayed(stats.get(i));
        WebElement temp = stats.get(i);
        if (((exists == false) && temp.getText().equals("65"))) {
          exists = true;
        }
      }
    }
    return exists;
  }
}
