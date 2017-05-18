package bi3.pages.pps270

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PPS270E extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WCFWRF")
	WebElement txtFwd
	
	@FindBy(id="WCBOLN")
	WebElement txtBillOfLading
	
	@FindBy(id="WCCARN")
	WebElement txtCarrirer
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	
	def void clickNext()
	{
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void fillFwd(String Fwd){
		waitForLoadingComplete();
		
		waitToBeClickable(txtFwd);
		txtFwd.click();
		txtFwd.sendKeys(Fwd);
		
	}
	
	def void fillBilOfLading(String Bol){
		waitForLoadingComplete();
		
		waitToBeClickable(txtBillOfLading);
		txtBillOfLading.click();
		txtBillOfLading.sendKeys(Bol);
		
	}
	
	def void fillCarrierName(String CarrierName){
		waitForLoadingComplete();
		
		waitToBeClickable(txtCarrirer);
		txtCarrirer.click();
		txtCarrirer.sendKeys(CarrierName);
		
	}
	
	
}