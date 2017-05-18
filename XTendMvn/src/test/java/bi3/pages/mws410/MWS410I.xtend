package bi3.pages.mws410

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class MWS410I extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WWTSID")
	WebElement txtTranspId
	
	@FindBy(id="Next")
	WebElement btnNext
	
	def void setTransId(String transpId){
		waitToBeClickable(txtTranspId)
		txtTranspId.click()
		txtTranspId.clearRobustly()
		txtTranspId.sendKeys(transpId)		
	}
	
	def void Next(){
		waitToBeClickable(btnNext)
		btnNext.click()
		waitForLoadingComplete()
	}
}