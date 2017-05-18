package bi3.configuration.settings

import org.openqa.selenium.WebDriver
import bi3.pages.LoginPage
import bi3.pages.HomePage
import bi3.pages.ToolbarPage
import bi3.pages.pps320.PPS320P

class PMS100SettingsTest {
	private WebDriver driver = null;
	
	private LoginPage loginPage
	private HomePage homePage
	private ToolbarPage toolbarPage
	private PPS320P pps320p
	
	def init(){
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		toolbarPage=new ToolbarPage(driver);
		pps320p = new PPS320P(driver)
	}
	
	new(WebDriver driver) {
		this.driver = driver;
		this.init();
	}
	
	def void SetOpeningPanel(String openningPanel){
		loginPage.GoTo();
		homePage.GoToPMS100();
		toolbarPage.ClickAction_Settings();
		pps320p.SelectPanelOpen(openningPanel)
		pps320p.ClickNext()
	}
}