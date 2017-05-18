package bi3.pages.ois145;

import bi3.framework.core.DefaultWebDriver;
import bi3.pages.BasePage;
import bi3.pages.ToolbarPage;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("all")
public class OIS145E extends BasePage {
  public OIS145E(final WebDriver driver) {
    super(driver);
  }
  
  public void Update() {
    ToolbarPage toolbar = new ToolbarPage(DefaultWebDriver.driver);
    toolbar.ClickAction_Update();
    BasePage.waitForLoadingComplete();
  }
}
