package bi3.pages.pms050

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PMS050E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "WWORQA")
	WebElement txtOrderQty
	
	@FindBy(id = "WHMAQA")
	WebElement txtManufQty
	
	@FindBy(id = "Next")
	WebElement btnNext
	
	def void enterManufQtyAsOrderQty(){
		txtManufQty.waitToBeClickable()
		txtManufQty.click()
		txtManufQty.clearRobustly()
		txtManufQty.sendKeys(txtOrderQty.GetTextBoxvalue())
	}
	
	def void ClickNext(){
		btnNext.waitToBeClickable()
		btnNext.click()
		waitForLoadingComplete()
	}
}