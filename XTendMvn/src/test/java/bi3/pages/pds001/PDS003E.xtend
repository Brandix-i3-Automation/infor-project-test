package bi3.pages.pds001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List

class PDS003E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WNINCE-shdo")
	WebElement cmbInclExclStruc;
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listIncExcld;
	
	@FindBy(id="Next")
	WebElement btnNext
	
	def void selectFromInclExcl(String value)
	{
		waitForLoadingComplete();
		selectFromDropdown(cmbInclExclStruc,listIncExcld,value);
	}
	
	def void clickNext(){		
		btnNext.click()
		waitForLoadingComplete()
	}
	
}