package bi3.configuration.settings

import bi3.tests.BaseTest
import bi3.pages.LoginPage
import bi3.pages.HomePage
import bi3.pages.ToolbarPage
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import bi3.pages.mms001.MMS001SettingsPage
import org.openqa.selenium.WebDriver

public class MMS001SettingsTest{
	
	private WebDriver driver = null;
	
	
	private LoginPage loginPage
	private HomePage homePage
	private ToolbarPage toolbarPage
	private MMS001SettingsPage mms001SettingsPage
	
	new(WebDriver driver) {
		this.driver = driver;
		this.init();
	}
	
	def init() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		toolbarPage=new ToolbarPage(driver);
		mms001SettingsPage=new MMS001SettingsPage(driver);
	}
		
	def void updateItemsSetting(String option ){
		loginPage.GoTo();
		
		homePage.GoToMMS001();
		
		toolbarPage.ClickAction_Settings();
		
		mms001SettingsPage.selectUpdateItems(option);
		mms001SettingsPage.selectUpdateItemsCheckBox();
		
		mms001SettingsPage.closeAllTabs();
	}
	
	
	
}