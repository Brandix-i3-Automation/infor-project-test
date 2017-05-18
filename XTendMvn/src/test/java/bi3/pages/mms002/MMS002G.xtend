package bi3.pages.mms002

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class MMS002G extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(id="Next")
	WebElement btnNext;

	/**
	 * Go to H panel
	 */
	def void clickNext() {
		waitForLoadingComplete()
		btnNext.click()
		waitForLoadingComplete()
	}

}
