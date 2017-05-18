package bi3.pages.mms001;

import bi3.pages.BasePage;
import com.google.common.base.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001ConnectWarehouseG extends BasePage {
  public MMS001ConnectWarehouseG(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "MBCDYN")
  private WebElement checkCrossDock;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void untickCrossDock() {
    String checked = this.checkCrossDock.getAttribute("aria-checked");
    boolean _equals = Objects.equal(checked, Boolean.valueOf(true));
    if (_equals) {
      this.checkCrossDock.click();
      System.out.println("Crossdock was clicked");
    }
  }
  
  public void clickNext() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
