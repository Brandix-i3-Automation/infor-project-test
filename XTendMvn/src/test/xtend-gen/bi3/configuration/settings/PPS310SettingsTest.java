package bi3.configuration.settings;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.ToolbarPage;
import bi3.pages.pps320.PPS320P;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("all")
public class PPS310SettingsTest {
  private WebDriver driver = null;
  
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private ToolbarPage toolbarPage;
  
  private PPS320P pps320p;
  
  public PPS320P init() {
    PPS320P _xblockexpression = null;
    {
      LoginPage _loginPage = new LoginPage(this.driver);
      this.loginPage = _loginPage;
      HomePage _homePage = new HomePage(this.driver);
      this.homePage = _homePage;
      ToolbarPage _toolbarPage = new ToolbarPage(this.driver);
      this.toolbarPage = _toolbarPage;
      PPS320P _pPS320P = new PPS320P(this.driver);
      _xblockexpression = this.pps320p = _pPS320P;
    }
    return _xblockexpression;
  }
  
  public PPS310SettingsTest(final WebDriver driver) {
    this.driver = driver;
    this.init();
  }
  
  public void SetOpeningPanel(final String openningPanel) {
    this.loginPage.GoTo();
    this.homePage.GoToPPS310();
    this.toolbarPage.ClickAction_Settings();
    this.pps320p.SelectPanelOpen(openningPanel);
    this.pps320p.ClickNext();
  }
}
