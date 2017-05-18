package bi3.pages.ois390

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class OIS392E extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(css="#WWREQ6")
	WebElement txtRejectedQty;
	
	@FindBy(id="WWBANO")
	WebElement txtLotNumber;
	
	@FindBy(css="#W6BANO")
	WebElement txtDetailsLotNumber;
	
	@FindBy(css="#W6WHSL")
	WebElement txtLocation;
	
	
		def enterLotNumber(String schNo) {
		waitForLoadingComplete();
		txtDetailsLotNumber.click();
		txtDetailsLotNumber.sendKeys(schNo);
		//txtDetailsLotNumber.sendKeys(Keys.ENTER);

	}
	
		def void enterRejectedQty(String rejectedQty) {
		txtRejectedQty.click();
		txtRejectedQty.clearRobustly();
		txtRejectedQty.sendKeys(rejectedQty);
	// warehouse.sendKeys(Keys.ENTER);
	}
	
	def void clickNext() {
		waitToBeClickable(btnNext)
		btnNext.click()
		waitForLoadingComplete()
	}
	def String getLotValue() {
		waitToBeDisplayed(txtLotNumber)
		return txtLotNumber.GetTextBoxvalue;
		
	}
	
	def void enterLocation(String location) {
		waitForLoadingComplete()
		txtLocation.click();
		txtLocation.clearRobustly();
		txtLocation.sendKeys(location);
		waitForLoadingComplete()
	// warehouse.sendKeys(Keys.ENTER);
	}
	


}














