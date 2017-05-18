package bi3.pages.pds001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PDS001F extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="TX60")
	WebElement txtAreaM3Text
	
	@FindBy(id="dbtnent")
	WebElement btnM3Textnext
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	def void setM3Text(String text){
		waitForLoadingComplete()
		txtAreaM3Text.sendKeys(text)
		waitToBeClickable(btnM3Textnext);
		btnM3Textnext.click()
		waitForLoadingComplete()
	}
	
	def void Next() {
		btnNext.click();
		waitForLoadingComplete();
	}
}