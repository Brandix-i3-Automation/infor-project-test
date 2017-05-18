package bi3.pages.mns212

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class MNS212B extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "WCN1915")
	WebElement btnConfirmOutput
	
	def void ConfirmOutput(){
		btnConfirmOutput.waitToBeClickable()
		btnConfirmOutput.click()
		waitForLoadingComplete()
	}
}