package bi3.pages.pps300

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PPS300SettingsPage extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
		
	@FindBy(xpath="//a[text()='Settings']")
 	WebElement linkSettings
	
	@FindBy(id="WWSPIC-shdo")
 	WebElement openingPanel
 	
 	@FindBy(id="list-option0")
 	WebElement listOption1
 	
	@FindBy(id="Next")
	WebElement btnNext;
	
	
	def void clickNext()
	{
		btnNext.click()
		waitForLoadingComplete()
	}
	
	
	def void goToSettings(){
		waitForLoadingComplete();
		
		waitToBeClickable(linkSettings);
		linkSettings.click();
	}
	
	def void changeOpeningPanel(){
		waitForLoadingComplete();
		waitToBeClickable(openingPanel);
		openingPanel.click();
		
		waitToBeClickable(listOption1);
		listOption1.click();
		
	}
	
	
}