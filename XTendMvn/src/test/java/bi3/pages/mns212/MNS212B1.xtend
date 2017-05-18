package bi3.pages.mns212

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class MNS212B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id='WCN1915')
	WebElement btnConfirmOutput;
	
	/**
	 * confirm output function.
	 */
	def confirmOutPut() {
		waitForLoadingComplete()		
		btnConfirmOutput.click();
		waitForLoadingComplete();
		ClickPrevious();
	}
	
	def void ConfirmOutput(){
		waitForLoadingComplete()		
		waitToBeDisplayed(btnConfirmOutput);
		btnConfirmOutput.click();
	}
}