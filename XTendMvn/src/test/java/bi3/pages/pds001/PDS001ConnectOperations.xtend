package bi3.pages.pds001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PDS001ConnectOperations extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="POPITI")
	WebElement txtRuntime
	
	def void setRuntime(String runtime){
		waitForLoadingComplete();
		txtRuntime.click();
		txtRuntime.clearRobustly();
		
		txtRuntime.sendKeys(runtime);
	}
	
	
}