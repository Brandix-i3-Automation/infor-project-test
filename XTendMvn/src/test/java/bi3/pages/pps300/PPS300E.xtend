package bi3.pages.pps300

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PPS300E extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "WWCFQA")
	WebElement txtConfirmedQty
	
	@FindBy(id = "WBRVQA")
	WebElement txtRecievedQty
	
	@FindBy(id = "WTBREM")
	WebElement txtRemark
	
	@FindBy(id = "Next")
	WebElement btnNext
	
	def void SetRecieveQtyAsConfirmedQty(){
		waitForLoadingComplete();
		txtRecievedQty.waitToBeClickable()
		txtRecievedQty.click()
		txtRecievedQty.clearRobustly()
		
		var confQty = txtConfirmedQty.GetTextBoxvalue()
		System.out.println("Setting confirmed qty "+confQty+" as recieved qty")
		txtRecievedQty.sendKeys(confQty)
	}
	
	def void ClickNext(){
		btnNext.waitToBeClickable()
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void fillRemarks(String Remark){
		waitForLoadingComplete();
		waitToBeClickable(txtRemark);
		txtRemark.click();
		txtRemark.sendKeys(Remark);
	}
	
	
	
}