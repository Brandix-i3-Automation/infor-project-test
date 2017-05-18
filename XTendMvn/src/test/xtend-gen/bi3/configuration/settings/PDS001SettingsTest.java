package bi3.configuration.settings;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.ToolbarPage;
import bi3.pages.pds001.PDS001SettingsPage;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("all")
public class PDS001SettingsTest {
  private WebDriver driver = null;
  
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private ToolbarPage toolbarPage;
  
  private PDS001SettingsPage pds001SettingsPage;
  
  public PDS001SettingsPage init() {
    PDS001SettingsPage _xblockexpression = null;
    {
      LoginPage _loginPage = new LoginPage(this.driver);
      this.loginPage = _loginPage;
      HomePage _homePage = new HomePage(this.driver);
      this.homePage = _homePage;
      ToolbarPage _toolbarPage = new ToolbarPage(this.driver);
      this.toolbarPage = _toolbarPage;
      PDS001SettingsPage _pDS001SettingsPage = new PDS001SettingsPage(this.driver);
      _xblockexpression = this.pds001SettingsPage = _pDS001SettingsPage;
    }
    return _xblockexpression;
  }
  
  public PDS001SettingsTest(final WebDriver driver) {
    this.driver = driver;
    this.init();
  }
  
  public void updateProductVariantSetting(final String option) {
    this.loginPage.GoTo();
    this.homePage.GoToPDS001();
    this.toolbarPage.ClickAction_Settings();
    this.pds001SettingsPage.selectUpdateItems(option);
    this.pds001SettingsPage.selectDisplayProductVariants();
    this.pds001SettingsPage.clickNext();
    this.pds001SettingsPage.closeAllTabs();
  }
}
