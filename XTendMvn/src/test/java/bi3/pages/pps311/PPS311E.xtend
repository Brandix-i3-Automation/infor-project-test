package bi3.pages.pps311

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PPS311E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	def void ClickNext(){
		btnNext.waitToBeClickable()
		btnNext.click();
		waitForLoadingComplete();
	}
}