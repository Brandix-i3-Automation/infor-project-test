package bi3.pages.mms101

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class MMS101B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	def void GoBack(){
		waitForLoadingComplete();
		waitToBeDisplayed(btnNext);
 		btnNext.sendKeys(Keys.F12);
		waitForLoadingComplete();
	}
	
}