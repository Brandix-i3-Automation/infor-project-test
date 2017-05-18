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
import org.testng.Assert;

@SuppressWarnings("all")
public class PPS330B extends BasePage {
  public PPS330B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1PUNO")
  private WebElement txtPOSearch;
  
  @FindBy(id = "W1WHLO")
  private WebElement txtWarehouseSearch;
  
  @FindBy(css = "div[id*=\'PPA330BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(id = "MyCanvasLbl")
  private WebElement linkStart;
  
  @FindBy(xpath = "//a[text()=\'Add Text to Quicknote...\']")
  private WebElement linkRelated;
  
  public void searchPONum(final String po) {
    WebDriverExtensions.waitToBeClickable(this.txtPOSearch);
    BasePage.clearRobustly(this.txtPOSearch);
    this.txtPOSearch.sendKeys(po);
    this.txtPOSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public String getRecievingNoOf(final String po) {
    BasePage.waitForLoadingComplete();
    String recNo = "";
    String xpath = (("//div[contains(@class, \'slick-cell l0\')][contains(text(),\'" + po) + "\')]/../div[5]");
    List<WebElement> recNos = DefaultWebDriver.driver.findElements(By.xpath(xpath));
    for (int i = 0; (i < recNos.size()); i++) {
      {
        WebElement temp = recNos.get(i);
        boolean _equals = temp.getText().equals("");
        boolean _not = (!_equals);
        if (_not) {
          recNo = temp.getText();
        }
      }
    }
    boolean _equals = recNo.equals("");
    if (_equals) {
      Assert.fail((("Recieving number could not be found for " + po) + " in PPS330B"));
    }
    return recNo;
  }
  
  public boolean checkStatus75ForPO(final String po) {
    boolean exists = false;
    String xpath = (("//div[contains(@class, \'slick-cell l0\')][contains(text(),\'" + po) + "\')]/../div[9]");
    List<WebElement> stats = DefaultWebDriver.driver.findElements(By.xpath(xpath));
    for (int i = 1; (i < stats.size()); i++) {
      {
        WebElement temp = stats.get(i);
        if (((exists == false) && temp.getText().equals("75"))) {
          exists = true;
        }
      }
    }
    return exists;
  }
  
  public void searchForPO(final String po, final String warehouse) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtPOSearch);
    BasePage.clearRobustly(this.txtPOSearch);
    this.txtPOSearch.sendKeys(po);
    WebDriverExtensions.waitToBeClickable(this.txtWarehouseSearch);
    BasePage.clearRobustly(this.txtWarehouseSearch);
    this.txtWarehouseSearch.sendKeys(warehouse);
    this.txtWarehouseSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    this.txtWarehouseSearch.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public boolean checkStatusForPO(final String po, final String status) {
    BasePage.waitForLoadingComplete();
    boolean exists = false;
    String xpath = (("//div[contains(@class, \'slick-cell l0\')][contains(text(),\'" + po) + "\')]/../div[9]");
    List<WebElement> stats = DefaultWebDriver.driver.findElements(By.xpath(xpath));
    for (int i = 1; (i < stats.size()); i++) {
      {
        WebElement temp = stats.get(i);
        if (((exists == false) && temp.getText().equals(status))) {
          temp.click();
          exists = true;
        }
      }
    }
    return exists;
  }
  
  public void goToStartPage() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.linkStart);
    this.linkStart.click();
  }
}
