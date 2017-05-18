package bi3.pages.ois390;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS390A extends BasePage {
  public OIS390A(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "#WWWHLO")
  private WebElement warehouse;
  
  @FindBy(css = "#WWRORN")
  private WebElement refOrderNo;
  
  @FindBy(xpath = "//div[@id=\'pRow10\']/div/label")
  private WebElement labelM3InforBox;
  
  @FindBy(css = "#dbtnok")
  private WebElement clickOk;
  
  @FindBy(css = "#Prev")
  private WebElement btnPrev;
  
  public void ClickPrev() {
    BasePage.waitForLoadingComplete();
    this.btnPrev.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void SetPanelSqequence(final String wh) {
    this.warehouse.click();
    BasePage.clearRobustly(this.warehouse);
    this.warehouse.sendKeys(("00" + wh));
  }
  
  public void selectCoNumber(final String coNumber) {
    BasePage.waitForLoadingComplete();
    this.refOrderNo.click();
    BasePage.clearRobustly(this.refOrderNo);
    this.refOrderNo.sendKeys(("00" + coNumber));
    BasePage.waitForLoadingComplete();
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String getM3lblValue() {
    WebDriverExtensions.waitToBeDisplayed(this.labelM3InforBox);
    return this.labelM3InforBox.getText();
  }
  
  public void confirmInfoBox() {
    WebDriverExtensions.waitToBeClickable(this.clickOk);
    this.clickOk.click();
    BasePage.waitForLoadingComplete();
  }
}
