package bi3.pages.mms001

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import bi3.pages.BasePage
import java.util.List

class MMS001G extends BasePage {

	new(WebDriver driver) { // Constructor
		super(driver)
	}

	@FindBy(id="Next")
	WebElement btnNext;

	@FindBy(id="MMSALE-shdo")
	WebElement cmbSalesItem;

	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listSalesItem;
	
	@FindBy(id="MMCHCD-shdo")
	WebElement cmbConfigCode;
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listConfigCode;
	
	def void Next() {
		btnNext.click();
		waitForLoadingComplete();
	}

	def void SelectSalesItem(String value) {
		waitForLoadingComplete();
		selectFromDropdown(cmbSalesItem, listSalesItem, value);

	}
	
	def void SelectConfigCode(String value)
	{
		waitForLoadingComplete();
		selectFromDropdown(cmbConfigCode, listConfigCode, value);
	}
}
