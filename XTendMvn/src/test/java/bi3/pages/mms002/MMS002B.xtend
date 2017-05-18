package bi3.pages.mms002

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class MMS002B extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(id="W1OBKV")
	WebElement txtItemNumber;

	@FindBy(css=".slick-cell.l1.r1")
	WebElement gridFirstLine;

	@FindBy(xpath="//a/span[contains(text(),'Change')]")
	WebElement linkChange
	
	@FindBy(id="Next")
	WebElement btnNext;

	/**
	 * Enter Item Number
	 */
	def void enterItemNumber(String newRawMatNumber) {
        
        waitForLoadingComplete()
		//txtItemNumber.waitToBeDisplayed();
		txtItemNumber.clearRobustly();
		txtItemNumber.sendKeys(newRawMatNumber);
		waitForLoadingComplete();
		txtItemNumber.sendKeys(Keys.ENTER);
		waitForLoadingComplete()
	}

	/**
	 * Select Change Item
	 */
	def void selectChange() {
		waitForLoadingComplete();
		rightClick(gridFirstLine);

		// Change Item
		waitToBeClickable(linkChange);
		linkChange.click()

		waitForLoadingComplete();

	}
	
		/**
	 * Go to H panel
	 */
	def void clickNext() {
		waitForLoadingComplete()
		btnNext.click()
		waitForLoadingComplete()
	}

}
