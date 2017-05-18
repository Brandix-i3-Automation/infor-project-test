package bi3.configuration.settings;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.ToolbarPage;
import bi3.pages.pps300.PPS300P;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("all")
public class PPS300SettingsTest {
  private WebDriver driver = null;
  
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private ToolbarPage toolbarPage;
  
  private PPS300P pps300p;
  
  public PPS300P init() {
    PPS300P _xblockexpression = null;
    {
      LoginPage _loginPage = new LoginPage(this.driver);
      this.loginPage = _loginPage;
      HomePage _homePage = new HomePage(this.driver);
      this.homePage = _homePage;
      ToolbarPage _toolbarPage = new ToolbarPage(this.driver);
      this.toolbarPage = _toolbarPage;
      PPS300P _pPS300P = new PPS300P(this.driver);
      _xblockexpression = this.pps300p = _pPS300P;
    }
    return _xblockexpression;
  }
  
  public PPS300SettingsTest(final WebDriver driver) {
    this.driver = driver;
    this.init();
  }
  
  public void SetOpeningPanel(final String openningPanel) {
    this.loginPage.GoTo();
    this.homePage.GoToPPS300();
    this.toolbarPage.ClickAction_Settings();
    this.pps300p.SelectPanelOpen(openningPanel);
    this.pps300p.ClickNext();
  }
}
