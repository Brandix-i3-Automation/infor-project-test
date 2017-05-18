package bi3.pages.mms001

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import bi3.pages.BasePage

class MMS001C extends BasePage {

	new(WebDriver driver) { // Constructor
		super(driver)
	}

	@FindBy(id="Next")
	WebElement btnNext;

	def void Next() {
		btnNext.click();
		waitForLoadingComplete();
	}

}
