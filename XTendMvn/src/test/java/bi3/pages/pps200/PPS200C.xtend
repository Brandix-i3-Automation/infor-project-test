package bi3.pages.pps200

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PPS200C extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "CPPUNO")
	WebElement txtNewPONum
	
	@FindBy(id = "Next")
	WebElement btnNext
	
	def void ClickNext(){
		btnNext.waitToBeClickable()
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void SetNewPONum(String po){
		txtNewPONum.waitToBeClickable()
		txtNewPONum.click()
		txtNewPONum.clearRobustly()
		txtNewPONum.sendKeys(po)
	}
	
	def void ClearNewPONumber(){
		txtNewPONum.waitToBeClickable()
		txtNewPONum.click()
		txtNewPONum.clearRobustly()
	}
	
}