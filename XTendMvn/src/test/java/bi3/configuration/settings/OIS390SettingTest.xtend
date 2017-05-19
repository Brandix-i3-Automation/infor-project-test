package bi3.configuration.settings

import bi3.pages.LoginPage
import bi3.pages.HomePage
import org.openqa.selenium.WebDriver
import bi3.pages.ToolbarPage
import bi3.pages.ois390.OIS390SettingPage

class OIS390SettingTest {

	private WebDriver driver = null;

	private LoginPage loginPage;
	private HomePage homePage;
	private ToolbarPage toolbarPage;
	private OIS390SettingPage ois390settingPage;

	def init() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		toolbarPage = new ToolbarPage(driver);
		ois390settingPage = new OIS390SettingPage(driver);

	}

	new(WebDriver driver) {
		this.driver = driver;
		this.init();
	}
	
		def void SetOpeningPanel(String Option){
		loginPage.GoTo();
		//homePage.GoToOIS390();
		
		toolbarPage.ClickAction_Settings();
		ois390settingPage.selectOpeningPanel(Option);
		ois390settingPage.clickNext();
		//ois390settingPage.closeAllTabs();
		
	
	}

}








