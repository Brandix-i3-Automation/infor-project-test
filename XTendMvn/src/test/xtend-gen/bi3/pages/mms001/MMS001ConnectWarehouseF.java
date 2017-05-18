package bi3.pages.mms001;

import bi3.pages.BasePage;
import com.google.common.base.Objects;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001ConnectWarehouseF extends BasePage {
  public MMS001ConnectWarehouseF(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "div[class=\'lawsonPanelSequenceItem\'][focused=\'focused\']")
  private WebElement FSeqenceItem;
  
  public void clickNext() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
    try {
      String _attribute = this.FSeqenceItem.getAttribute("value");
      boolean _equals = Objects.equal(_attribute, "F");
      if (_equals) {
        this.btnNext.click();
        BasePage.waitForLoadingComplete();
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
