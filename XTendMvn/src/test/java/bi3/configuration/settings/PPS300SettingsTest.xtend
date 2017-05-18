package bi3.configuration.settings

import org.openqa.selenium.WebDriver
import bi3.pages.LoginPage
import bi3.pages.HomePage
import bi3.pages.ToolbarPage
import bi3.pages.pps300.PPS300P

class PPS300SettingsTest {
	private WebDriver driver = null;
	
	private LoginPage loginPage
	private HomePage homePage
	private ToolbarPage toolbarPage
	private PPS300P pps300p
	
	def init(){
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		toolbarPage=new ToolbarPage(driver);
		pps300p = new PPS300P(driver)
	}
	
	new(WebDriver driver) {
		this.driver = driver;
		this.init();
	}
	
	def void SetOpeningPanel(String openningPanel){
		loginPage.GoTo();
		homePage.GoToPPS300();
		toolbarPage.ClickAction_Settings();
		pps300p.SelectPanelOpen(openningPanel)
		pps300p.ClickNext()
	}
}