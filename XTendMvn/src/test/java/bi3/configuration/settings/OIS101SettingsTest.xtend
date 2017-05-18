package bi3.configuration.settings

import org.openqa.selenium.WebDriver
import bi3.pages.LoginPage
import bi3.pages.HomePage

import bi3.pages.ois101.OIS101SettingsPage
import bi3.pages.ToolbarPage

public class OIS101SettingsTest {
	private WebDriver driver = null;
	
	private LoginPage loginPage
	private HomePage homePage
	private ToolbarPage toolbarPage
	private OIS101SettingsPage ois101SettingsPage
	
	def init(){
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		toolbarPage=new ToolbarPage(driver);
		ois101SettingsPage=new OIS101SettingsPage(driver);
		
	}
	
	new(WebDriver driver) {
		this.driver = driver;
		this.init();
	}
	
	def void customerOrderOpenLineSettingSetUp(String panelSequence, String optionDate, String optionScreenOpt,String valueSeqAli){
		toolbarPage.ClickAction_Settings();
		ois101SettingsPage.enterPanelSequence(panelSequence);
		ois101SettingsPage.selectDateFormat(optionDate);
		ois101SettingsPage.unselectCheckboxPriceSimulatn();
		ois101SettingsPage.selectFullScreenOpt(optionScreenOpt);
		ois101SettingsPage.enterSearchSeqAli(valueSeqAli);
		ois101SettingsPage.clickNext();
		
		
	}
	
}