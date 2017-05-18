package bi3.configuration.settings;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.ToolbarPage;
import bi3.pages.pcs230.PCS230SettingsPage;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("all")
public class PCS230SettingsTes {
  private WebDriver driver = null;
  
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private ToolbarPage toolbarPage;
  
  private PCS230SettingsPage pcs230SettingsPage;
  
  public PCS230SettingsPage init() {
    PCS230SettingsPage _xblockexpression = null;
    {
      LoginPage _loginPage = new LoginPage(this.driver);
      this.loginPage = _loginPage;
      HomePage _homePage = new HomePage(this.driver);
      this.homePage = _homePage;
      ToolbarPage _toolbarPage = new ToolbarPage(this.driver);
      this.toolbarPage = _toolbarPage;
      PCS230SettingsPage _pCS230SettingsPage = new PCS230SettingsPage(this.driver);
      _xblockexpression = this.pcs230SettingsPage = _pCS230SettingsPage;
    }
    return _xblockexpression;
  }
  
  public PCS230SettingsTes(final WebDriver driver) {
    this.driver = driver;
    this.init();
  }
  
  public void SetPanelSqequence() {
    this.loginPage.GoTo();
    this.homePage.GoToPCS230();
    this.toolbarPage.ClickAction_Settings();
    this.pcs230SettingsPage.enterPanelSequence("EF");
    this.pcs230SettingsPage.clickNext();
    this.pcs230SettingsPage.closeAllTabs();
  }
}
