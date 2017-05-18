package bi3.pages.pms070

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PMS070E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WOUMAT")
	WebElement txtLabRunTime
	
	@FindBy(id="Next")
	WebElement btnNext
	
	def void setLabRuntime(String runtime){
		waitToBeClickable(txtLabRunTime)
		txtLabRunTime.click()
		clearRobustly(txtLabRunTime)
		txtLabRunTime.sendKeys(runtime)
	}
	
	def void clickNext(){
		waitToBeClickable(btnNext)
		btnNext.click()
		waitForLoadingComplete()
	}
	
}