package bi3.configuration.settings;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.ToolbarPage;
import bi3.pages.ois390.OIS390SettingPage;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("all")
public class OIS390SettingTest {
  private WebDriver driver = null;
  
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private ToolbarPage toolbarPage;
  
  private OIS390SettingPage ois390settingPage;
  
  public OIS390SettingPage init() {
    OIS390SettingPage _xblockexpression = null;
    {
      LoginPage _loginPage = new LoginPage(this.driver);
      this.loginPage = _loginPage;
      HomePage _homePage = new HomePage(this.driver);
      this.homePage = _homePage;
      ToolbarPage _toolbarPage = new ToolbarPage(this.driver);
      this.toolbarPage = _toolbarPage;
      OIS390SettingPage _oIS390SettingPage = new OIS390SettingPage(this.driver);
      _xblockexpression = this.ois390settingPage = _oIS390SettingPage;
    }
    return _xblockexpression;
  }
  
  public OIS390SettingTest(final WebDriver driver) {
    this.driver = driver;
    this.init();
  }
  
  public void SetOpeningPanel(final String Option) {
    this.loginPage.GoTo();
    this.toolbarPage.ClickAction_Settings();
    this.ois390settingPage.selectOpeningPanel(Option);
    this.ois390settingPage.clickNext();
  }
}
