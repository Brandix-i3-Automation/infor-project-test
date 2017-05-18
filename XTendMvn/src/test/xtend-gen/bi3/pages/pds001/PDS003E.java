package bi3.pages.pds001;

import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PDS003E extends BasePage {
  public PDS003E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WNINCE-shdo")
  private WebElement cmbInclExclStruc;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listIncExcld;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void selectFromInclExcl(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbInclExclStruc, this.listIncExcld, value);
  }
  
  public void clickNext() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
