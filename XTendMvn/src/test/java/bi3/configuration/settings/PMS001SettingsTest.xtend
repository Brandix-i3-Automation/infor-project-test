package bi3.configuration.settings

import org.testng.annotations.Test
import bi3.pages.BasePage
import bi3.tests.BaseTest
import bi3.pages.LoginPage
import bi3.pages.HomePage
import bi3.pages.pms001.PMS001SettingsPage
import org.testng.annotations.BeforeTest
import org.testng.annotations.BeforeMethod
import org.openqa.selenium.WebDriver
import bi3.pages.ToolbarPage

class PMS001SettingsTest {
	private WebDriver driver = null;
	
	private LoginPage loginPage
	private HomePage homePage
	private PMS001SettingsPage pms001SettingsPage
	private ToolbarPage toolbarPage
	
	
	def init(){
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		pms001SettingsPage=new PMS001SettingsPage(driver);
		toolbarPage=new ToolbarPage(driver);
	}
		
	new(WebDriver driver) {
		this.driver = driver;
		this.init();
	}
	
	//@Test(groups="PMS001")
	def void scrOptionForTwoMatrix(){
		loginPage.GoTo();
		
		homePage.GoToPMS001();
		
		toolbarPage.ClickAction_Settings();
		pms001SettingsPage.selectFullScrOption("2-Matrix");
		
		pms001SettingsPage.clickNext();
		
		pms001SettingsPage.closeAllTabs();
		
		Thread.sleep(2000);
	}
}
