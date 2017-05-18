package bi3.pages.mms077
import org.openqa.selenium.WebDriver

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys
import bi3.pages.BasePage
import java.util.List
class MMS077_SelectMedia extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(id="WCN1915")
	WebElement btnConfirm;
	
	def  ConfirmOutput()
	{
		waitForLoadingComplete();
		btnConfirm.click();
		
	}
}