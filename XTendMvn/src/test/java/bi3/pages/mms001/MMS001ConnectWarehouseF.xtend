package bi3.pages.mms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class MMS001ConnectWarehouseF extends BasePage {

	new(WebDriver driver) { // Constructor
		super(driver)
	}

	@FindBy(id="Next")
	WebElement btnNext;

//	def void clickNext() {
//		waitForLoadingComplete()
//		btnNext.click()
//		waitForLoadingComplete()
//	}
//	
	@FindBy(css="div[class='lawsonPanelSequenceItem'][focused='focused']")
	WebElement FSeqenceItem;
	
	def void clickNext() {
		btnNext.click();
		waitForLoadingComplete();
		
		// retry
		try {
			if (FSeqenceItem.getAttribute("value") == "F") {
				btnNext.click();
				waitForLoadingComplete();
			}
		} catch (Exception e) {
			
		}
	}
}
