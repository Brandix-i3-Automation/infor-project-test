package bi3.pages.pps390

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class PPS390 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id='ActionsBtn')
	WebElement btnActions;
	
	@FindBy(css="a[href='#F14']")
	WebElement btnPrint;
	
	/**
	 * Action to go to print page.
	 */
	def goToPrintPage() {
		waitForLoadingComplete();
		btnActions.click();
		btnPrint.click();
	}
}