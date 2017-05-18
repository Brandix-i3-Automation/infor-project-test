package bi3.pages.mms001
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import bi3.pages.BasePage
import java.util.List

class MMS001ItemFacilityE extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(id="M9VAMT-shdo")
	WebElement cmbInvAccMethod
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listInvAccMethod;
	
	@FindBy(id="Next")
	WebElement btnNext;

	def void clickNext() {
		waitForLoadingComplete()
		btnNext.click()
		waitForLoadingComplete()
	}	
	
	def void selectInvAccMethod(String value)
	{
		waitForLoadingComplete();
		selectFromDropdown(cmbInvAccMethod, listInvAccMethod, value)
	}
}