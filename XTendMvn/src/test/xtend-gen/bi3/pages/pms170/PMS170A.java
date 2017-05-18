package bi3.pages.pms170;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS170A extends BasePage {
  public PMS170A(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1PRNO")
  private WebElement txtProduct;
  
  @FindBy(css = "#W1PRNOContainer button")
  private WebElement btnPrduct;
  
  @FindBy(css = "#POS")
  private WebElement txtSku;
  
  @FindBy(css = "div[row=\'0\']>div[class=\'slick-cell l0 r0  uppercase\']")
  private WebElement firstGridCell;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void EnterProduct(final String product) {
    WebDriverExtensions.waitToBeDisplayed(this.txtProduct);
    this.txtProduct.click();
    BasePage.clearRobustly(this.txtProduct);
    this.txtProduct.sendKeys(product);
  }
  
  public void ClickProduct() {
    BasePage.waitForLoadingComplete();
    this.btnPrduct.click();
  }
  
  public void EnterSku(final String sku) {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtSku);
    this.txtSku.sendKeys(sku);
    this.txtSku.sendKeys(Keys.ENTER);
  }
  
  public void SelectFirstRow() {
    try {
      Thread.sleep(1000);
      this.firstGridCell.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void SelectSku() {
    try {
      Thread.sleep(1000);
      this.btnSelect.click();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void clickNext() {
    try {
      Thread.sleep(1000);
      this.btnNext.click();
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
