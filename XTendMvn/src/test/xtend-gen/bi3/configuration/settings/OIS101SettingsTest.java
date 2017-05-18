package bi3.configuration.settings;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.ToolbarPage;
import bi3.pages.ois101.OIS101SettingsPage;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("all")
public class OIS101SettingsTest {
  private WebDriver driver = null;
  
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private ToolbarPage toolbarPage;
  
  private OIS101SettingsPage ois101SettingsPage;
  
  public OIS101SettingsPage init() {
    OIS101SettingsPage _xblockexpression = null;
    {
      LoginPage _loginPage = new LoginPage(this.driver);
      this.loginPage = _loginPage;
      HomePage _homePage = new HomePage(this.driver);
      this.homePage = _homePage;
      ToolbarPage _toolbarPage = new ToolbarPage(this.driver);
      this.toolbarPage = _toolbarPage;
      OIS101SettingsPage _oIS101SettingsPage = new OIS101SettingsPage(this.driver);
      _xblockexpression = this.ois101SettingsPage = _oIS101SettingsPage;
    }
    return _xblockexpression;
  }
  
  public OIS101SettingsTest(final WebDriver driver) {
    this.driver = driver;
    this.init();
  }
  
  public void customerOrderOpenLineSettingSetUp(final String panelSequence, final String optionDate, final String optionScreenOpt, final String valueSeqAli) {
    this.toolbarPage.ClickAction_Settings();
    this.ois101SettingsPage.enterPanelSequence(panelSequence);
    this.ois101SettingsPage.selectDateFormat(optionDate);
    this.ois101SettingsPage.unselectCheckboxPriceSimulatn();
    this.ois101SettingsPage.selectFullScreenOpt(optionScreenOpt);
    this.ois101SettingsPage.enterSearchSeqAli(valueSeqAli);
    this.ois101SettingsPage.clickNext();
  }
}
