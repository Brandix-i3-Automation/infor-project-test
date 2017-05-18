package bi3.pages.mms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001SettingsPage extends BasePage {
  public MMS001SettingsPage(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WWUPIP-shdo")
  private WebElement cmbBoxUpdateItems;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listUpdateItems;
  
  @FindBy(id = "WWUPIW")
  private WebElement chkBoxUpdateItems;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void selectUpdateItems(final String option) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbBoxUpdateItems, this.listUpdateItems, option);
  }
  
  public void selectUpdateItemsCheckBox() {
    boolean _isSelected = this.chkBoxUpdateItems.isSelected();
    boolean _not = (!_isSelected);
    if (_not) {
      this.chkBoxUpdateItems.click();
      BasePage.waitForLoadingComplete();
    }
  }
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
