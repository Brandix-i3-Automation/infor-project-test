package bi3.pages.ois101

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class OIS101E extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(id="WBUCOS")
	WebElement txtBoxCost
	
	@FindBy(id="WBSAPR")
	WebElement txtBoxSalesPrice

	@FindBy(id="Next")
	WebElement btnNext

	// Page Actions
	def void fillPricingInformation(String SalesPrice,String CostPrice) {
		waitForLoadingComplete()

		waitToBeClickable(txtBoxSalesPrice)
		// filling Sales Price Information
		txtBoxSalesPrice.clearRobustly()
		txtBoxSalesPrice.sendKeys(SalesPrice)
		waitForLoadingComplete()
		
		waitToBeClickable(txtBoxCost)		
		
		// filling Cost Price Information
		txtBoxCost.clearRobustly()
		txtBoxCost.sendKeys(CostPrice)
				
		btnNext.click()
	}
	
	def void clickNext(){
		waitForLoadingComplete
		btnNext.click();
		waitForLoadingComplete
		
	}

}
