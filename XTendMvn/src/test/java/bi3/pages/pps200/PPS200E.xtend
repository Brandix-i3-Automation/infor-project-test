package bi3.pages.pps200

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PPS200E extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "Next")
	WebElement btnNext
	
	@FindBy(id = "WWPUNO")
	WebElement txtNewPO
	
	def void ClickNext(){
		btnNext.waitToBeClickable()
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def String getNewPONumber(){
		txtNewPO.waitToBeDisplayed()
		return txtNewPO.GetTextBoxvalue()
	}
	
}