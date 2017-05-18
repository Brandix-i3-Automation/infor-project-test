package bi3.configuration.settings;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.ToolbarPage;
import bi3.pages.mms001.MMS001SettingsPage;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("all")
public class MMS001SettingsTest {
  private WebDriver driver = null;
  
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private ToolbarPage toolbarPage;
  
  private MMS001SettingsPage mms001SettingsPage;
  
  public MMS001SettingsTest(final WebDriver driver) {
    this.driver = driver;
    this.init();
  }
  
  public MMS001SettingsPage init() {
    MMS001SettingsPage _xblockexpression = null;
    {
      LoginPage _loginPage = new LoginPage(this.driver);
      this.loginPage = _loginPage;
      HomePage _homePage = new HomePage(this.driver);
      this.homePage = _homePage;
      ToolbarPage _toolbarPage = new ToolbarPage(this.driver);
      this.toolbarPage = _toolbarPage;
      MMS001SettingsPage _mMS001SettingsPage = new MMS001SettingsPage(this.driver);
      _xblockexpression = this.mms001SettingsPage = _mMS001SettingsPage;
    }
    return _xblockexpression;
  }
  
  public void updateItemsSetting(final String option) {
    this.loginPage.GoTo();
    this.homePage.GoToMMS001();
    this.toolbarPage.ClickAction_Settings();
    this.mms001SettingsPage.selectUpdateItems(option);
    this.mms001SettingsPage.selectUpdateItemsCheckBox();
    this.mms001SettingsPage.closeAllTabs();
  }
}
