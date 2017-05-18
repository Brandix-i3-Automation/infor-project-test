package bi3.pages.pms100;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS100 extends BasePage {
  public PMS100(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[class=\'tabTitle\'][title]")
  private WebElement pageTitle;
  
  @FindBy(id = "W1OBKV")
  private WebElement txtSchedNo;
  
  @FindBy(id = "W2OBKV")
  private WebElement txtProdNo;
  
  @FindBy(id = "W3OBKV")
  private WebElement txtMoNo;
  
  @FindBy(css = "div[row=\'0\']>div.l0.r0")
  private WebElement schedNoRow1;
  
  @FindBy(css = "div[row=\'0\']>div.l2.r2")
  private WebElement prodNoRow1;
  
  @FindBy(css = "div[row=\'0\']>div.l4.r4")
  private WebElement MONoRow1;
  
  public String getScedNoOfRow1() {
    WebDriverExtensions.waitToBeDisplayed(this.schedNoRow1);
    return this.schedNoRow1.getText();
  }
  
  public String getProdNoOfRow1() {
    WebDriverExtensions.waitToBeDisplayed(this.prodNoRow1);
    return this.prodNoRow1.getText();
  }
  
  public String getpageTitle() {
    BasePage.waitForLoadingComplete();
    return this.pageTitle.getText();
  }
  
  public void setSchedNo(final String schedNo) {
    BasePage.waitForLoadingComplete();
    this.txtSchedNo.click();
    BasePage.clearRobustly(this.txtSchedNo);
    this.txtSchedNo.sendKeys(schedNo);
  }
  
  public void setProdNo(final String prodNo) {
    BasePage.waitForLoadingComplete();
    this.txtProdNo.click();
    BasePage.clearRobustly(this.txtProdNo);
    this.txtProdNo.sendKeys(prodNo);
  }
  
  public void clearMONoText() {
    BasePage.waitForLoadingComplete();
    this.txtMoNo.click();
    BasePage.clearRobustly(this.txtMoNo);
  }
  
  public void searchMOBy(final String schedNo, final String prodNo) {
    this.setSchedNo(schedNo);
    this.txtSchedNo.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
}
