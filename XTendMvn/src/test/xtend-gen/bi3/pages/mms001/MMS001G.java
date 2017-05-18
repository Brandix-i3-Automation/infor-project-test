package bi3.pages.mms001;

import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001G extends BasePage {
  public MMS001G(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "MMSALE-shdo")
  private WebElement cmbSalesItem;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listSalesItem;
  
  @FindBy(id = "MMCHCD-shdo")
  private WebElement cmbConfigCode;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listConfigCode;
  
  public void Next() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void SelectSalesItem(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbSalesItem, this.listSalesItem, value);
  }
  
  public void SelectConfigCode(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbConfigCode, this.listConfigCode, value);
  }
}
