package bi3.pages.ois390;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS391B1 extends BasePage {
  public OIS391B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "#Prev")
  private WebElement btnPrev;
  
  @FindBy(css = "#WWREPN")
  private WebElement txtReceivingNo;
  
  public void ClickPrev() {
    BasePage.waitForLoadingComplete();
    this.btnPrev.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String getReceivingNoValue() {
    WebDriverExtensions.waitToBeDisplayed(this.txtReceivingNo);
    return BasePage.GetTextBoxvalue(this.txtReceivingNo);
  }
}
