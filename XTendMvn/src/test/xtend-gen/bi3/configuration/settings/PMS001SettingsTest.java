package bi3.configuration.settings;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.ToolbarPage;
import bi3.pages.pms001.PMS001SettingsPage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("all")
public class PMS001SettingsTest {
  private WebDriver driver = null;
  
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private PMS001SettingsPage pms001SettingsPage;
  
  private ToolbarPage toolbarPage;
  
  public ToolbarPage init() {
    ToolbarPage _xblockexpression = null;
    {
      LoginPage _loginPage = new LoginPage(this.driver);
      this.loginPage = _loginPage;
      HomePage _homePage = new HomePage(this.driver);
      this.homePage = _homePage;
      PMS001SettingsPage _pMS001SettingsPage = new PMS001SettingsPage(this.driver);
      this.pms001SettingsPage = _pMS001SettingsPage;
      ToolbarPage _toolbarPage = new ToolbarPage(this.driver);
      _xblockexpression = this.toolbarPage = _toolbarPage;
    }
    return _xblockexpression;
  }
  
  public PMS001SettingsTest(final WebDriver driver) {
    this.driver = driver;
    this.init();
  }
  
  public void scrOptionForTwoMatrix() {
    try {
      this.loginPage.GoTo();
      this.homePage.GoToPMS001();
      this.toolbarPage.ClickAction_Settings();
      this.pms001SettingsPage.selectFullScrOption("2-Matrix");
      this.pms001SettingsPage.clickNext();
      this.pms001SettingsPage.closeAllTabs();
      Thread.sleep(2000);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
