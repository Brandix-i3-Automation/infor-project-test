package bi3.pages.mms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class MMS001ConnectWarehouseG extends BasePage {
	
	new(WebDriver driver) { // Constructor
		super(driver)
	}
	
	@FindBy(id="MBCDYN")
	WebElement checkCrossDock
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	def void untickCrossDock(){
		var checked = checkCrossDock.getAttribute("aria-checked")
		
		if(checked==true)
		{
			checkCrossDock.click();
			System.out.println("Crossdock was clicked");
		}
	}
	
	def void clickNext()
	{	
		waitForLoadingComplete()
		btnNext.click()
		waitForLoadingComplete()
	}
}