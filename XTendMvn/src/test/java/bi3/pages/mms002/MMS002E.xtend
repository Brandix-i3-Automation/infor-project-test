package bi3.pages.mms002

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class MMS002E extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(id="MBCONC")
	WebElement chkContNetChange

	@FindBy(id="Next")
	WebElement btnNext;
    
    @FindBy(css="#tabsList > li.ui-tabs-selected.ui-state-active > button")
	WebElement btnClose
	/**
	 * Check Count Net Change box
	 */
	def void checkContNetChange() {
		waitForLoadingComplete()
		//chkContNetChange.waitToBeDisplayed();
		chkContNetChange.click()
		waitForLoadingComplete()

	}

	/**
	 * Go to F panel
	 */
	def void clickNext() {
		waitForLoadingComplete()
		btnNext.click()
		waitForLoadingComplete()
	}
	
		def close() {
		btnClose.click()
		System.out.println("MMS001 tab closed")
	}
}
