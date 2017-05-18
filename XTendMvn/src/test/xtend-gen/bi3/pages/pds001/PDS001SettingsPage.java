package bi3.pages.pds001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PDS001SettingsPage extends BasePage {
  public PDS001SettingsPage(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "WWUPDV-shdo")
  private WebElement cmbBoxUpdateItems;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listUpdateItems;
  
  @FindBy(id = "WWSHVP")
  private WebElement chkBoxDisplayProductVariants;
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void selectUpdateItems(final String option) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbBoxUpdateItems, this.listUpdateItems, option);
  }
  
  public void selectDisplayProductVariants() {
    boolean _isSelected = this.chkBoxDisplayProductVariants.isSelected();
    boolean _not = (!_isSelected);
    if (_not) {
      this.chkBoxDisplayProductVariants.click();
      BasePage.waitForLoadingComplete();
    }
  }
}
