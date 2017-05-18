package bi3.pages.pps310

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PPS310SettingsPage extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WWSPIC-shdo")
	WebElement drpOpenningPanel;
	
	@FindBy(css = "li#list-option0")
	WebElement optOpenningPanel;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	
	def void SelectUpdateOpenningPanel(){
		waitToBeDisplayed(drpOpenningPanel);
		drpOpenningPanel.click();
		waitToBeDisplayed(optOpenningPanel, 60000)
		optOpenningPanel.click();
		btnNext.click();		
	}
	
	
	
	
	
	
}