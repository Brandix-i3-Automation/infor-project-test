package bi3.configuration.settings

import bi3.tests.BaseTest
import bi3.pages.LoginPage
import bi3.pages.HomePage
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import bi3.pages.pcs230.PCS230SettingsPage
import org.openqa.selenium.WebDriver
import bi3.pages.ToolbarPage

class PCS230SettingsTes {
	private WebDriver driver = null;
	
	private LoginPage loginPage;
	private HomePage homePage;
	private ToolbarPage toolbarPage;
	private PCS230SettingsPage pcs230SettingsPage;
	

	
	
	def init(){
		loginPage =new LoginPage(driver);
		homePage=new HomePage(driver);
		toolbarPage=new ToolbarPage(driver);
		pcs230SettingsPage=new PCS230SettingsPage(driver);
		
	}
	new(WebDriver driver) {
		this.driver = driver;
		this.init();
	}
	
	//@Test(groups="PCS230")
	def void SetPanelSqequence(){
		loginPage.GoTo();
		homePage.GoToPCS230();
		
		toolbarPage.ClickAction_Settings();
		pcs230SettingsPage.enterPanelSequence("EF");
		pcs230SettingsPage.clickNext();
		
		pcs230SettingsPage.closeAllTabs();
		
		
		
	}
	
}