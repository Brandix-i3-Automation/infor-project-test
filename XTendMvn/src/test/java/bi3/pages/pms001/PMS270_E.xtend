package bi3.pages.pms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class PMS270_E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WWTX40") 
	WebElement txtDescription;
	
	@FindBy(id="Next") 
	WebElement btnNext;
	
	def void EnterDescription(String ScheduleNo)
	{
		txtDescription.click();
		clearRobustly(txtDescription);
		txtDescription.sendKeys(ScheduleNo);
		
	}
	
	def void clickNext(){
		waitToBeClickable(btnNext)
		btnNext.click();
		waitForLoadingComplete();
	}
	
	
	
}