package bi3.tests.fnb

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class OIS391B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="#Prev")
	WebElement btnPrev;
	
	@FindBy(css="#WWREPN")
	WebElement txtReceivingNo;
	
	
	def void ClickPrev() {	
		btnPrev.click();
		waitForLoadingComplete()
	

	}
	
	def String getReceivingNoValue() {
		waitToBeDisplayed(txtReceivingNo)
		return txtReceivingNo.GetTextBoxvalue;
		
	}
	
	
	
}