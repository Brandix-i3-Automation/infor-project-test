package bi3.configuration.settings

import bi3.tests.BaseTest
import bi3.pages.LoginPage
import bi3.pages.HomePage

import org.testng.annotations.BeforeMethod
import bi3.pages.pds001.PDS001SettingsPage
import org.testng.annotations.Test
import org.openqa.selenium.WebDriver
import bi3.pages.ToolbarPage

class PDS001SettingsTest {
	private WebDriver driver = null;
	
	private LoginPage loginPage
	private HomePage homePage
	private ToolbarPage toolbarPage
	private PDS001SettingsPage pds001SettingsPage
	
	
	def init(){
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		toolbarPage=new ToolbarPage(driver);
		pds001SettingsPage=new PDS001SettingsPage(driver);
		
	}
	
	new(WebDriver driver) {
		this.driver = driver;
		this.init();
	}
	
	
	//@Test(groups="PDS001")
	def void updateProductVariantSetting(String option){
		loginPage.GoTo();
		
		homePage.GoToPDS001();
		
		toolbarPage.ClickAction_Settings();
		
		pds001SettingsPage.selectUpdateItems(option);
		pds001SettingsPage.selectDisplayProductVariants();
		pds001SettingsPage.clickNext();
		
		pds001SettingsPage.closeAllTabs();
	}
	
	
	
}