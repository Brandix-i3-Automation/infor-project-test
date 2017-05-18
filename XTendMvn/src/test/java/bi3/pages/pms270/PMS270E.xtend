package bi3.pages.pms270

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PMS270E extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "WWTX40")
	WebElement txtSchedNo
	
	@FindBy(id = "Next")
	WebElement btnNext
	
	def String GetSchedNo(){
		return txtSchedNo.GetTextBoxvalue()
	}
	
	def void clickNext() {
        btnNext.waitToBeClickable()
		btnNext.click()
		waitForLoadingComplete()
	}
}