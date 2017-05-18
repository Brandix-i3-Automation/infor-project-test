package bi3.pages.mws445;

import bi3.pages.BasePage;
import bi3.pages.ToolbarPage;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("all")
public class MWS445B extends BasePage {
  private ToolbarPage toolbarPage;
  
  public MWS445B(final WebDriver driver) {
    super(driver);
    ToolbarPage _toolbarPage = new ToolbarPage(driver);
    this.toolbarPage = _toolbarPage;
  }
  
  public void ConfirmAll() {
    BasePage.waitForLoadingComplete();
    this.toolbarPage.ClickAction_ConfirmAll();
  }
}
