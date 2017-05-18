package bi3.pages.pps390;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS390E extends BasePage {
  public PPS390E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WHCLAL-shdo")
  private WebElement btnStatusDropdown;
  
  @FindBy(css = "#dropdown-list>li")
  private List<WebElement> listStatusOptions;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "CHCLAN")
  private WebElement txtRtsOrderNo;
  
  public void ClickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void SelectStatusAs(final String stat) {
    this.selectFromDropdown(this.btnStatusDropdown, this.listStatusOptions, stat);
  }
  
  public String GetRtsOrderNo() {
    WebDriverExtensions.waitToBeClickable(this.txtRtsOrderNo);
    return BasePage.GetTextBoxvalue(this.txtRtsOrderNo);
  }
}
