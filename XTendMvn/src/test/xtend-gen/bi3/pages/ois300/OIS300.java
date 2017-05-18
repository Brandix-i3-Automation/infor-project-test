package bi3.pages.ois300;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS300 extends BasePage {
  public OIS300(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1OBKV")
  private WebElement txtCONumber;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement FirstCell;
  
  @FindBy(linkText = "Related")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Order lines\')]")
  private WebElement linkOrderLines;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Delivery Toolbox\')]")
  private WebElement linkDeliveryToolbox;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(id = "WWQTTP-shdo")
  private WebElement cmbSortingOrder;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listSortingOrder;
  
  @FindBy(id = "W4OBKV")
  private WebElement txtCoNumber_fnb;
  
  @FindBy(css = "div[id*=\'OIA300BS\'][class*=\'inforDataGrid\']")
  private WebElement popInforGrid;
  
  public void searchCONumber(final String CONumber) {
    BasePage.waitForLoadingComplete();
    this.txtCONumber.click();
    BasePage.clearRobustly(this.txtCONumber);
    WebDriverExtensions.waitToBeDisplayed(this.txtCONumber);
    this.txtCONumber.sendKeys(CONumber);
    this.txtCONumber.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void searchCONumber_fnb(final String CONumber) {
    BasePage.waitForLoadingComplete();
    this.txtCoNumber_fnb.click();
    BasePage.clearRobustly(this.txtCoNumber_fnb);
    WebDriverExtensions.waitToBeDisplayed(this.txtCoNumber_fnb);
    this.txtCoNumber_fnb.sendKeys(CONumber);
    this.txtCoNumber_fnb.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void goToOrderLines() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkOrderLines);
    this.linkOrderLines.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void setSortingOrder(final String value) {
    try {
      BasePage.waitForLoadingComplete();
      Thread.sleep(3000);
      this.selectFromDropdown(this.cmbSortingOrder, this.listSortingOrder, value);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void goToDeliveryToolbox() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkDeliveryToolbox);
    this.linkDeliveryToolbox.click();
    BasePage.waitForLoadingComplete();
  }
}
