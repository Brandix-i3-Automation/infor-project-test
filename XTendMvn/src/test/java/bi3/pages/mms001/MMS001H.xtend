package bi3.pages.mms001

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import bi3.pages.BasePage
import java.util.List

class MMS001H extends BasePage {

	new(WebDriver driver) { // Constructor
		super(driver)
	}
	
	@FindBy(id="WMPUPR")
	WebElement txtPurchasePrice
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(id="MMSPUC-shdo")
	WebElement cmbFixDynUM;
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listFixDynUM;

	def void Next() {
		btnNext.click();
		waitForLoadingComplete();
	}
	
	def void setPurchasePrice(String purchasePrice)
	{
		waitToBeDisplayed(txtPurchasePrice)
		txtPurchasePrice.click();
		txtPurchasePrice.clearRobustly();
		
		txtPurchasePrice.sendKeys(purchasePrice);
	}
	
	def void selectFromFixDynUM(String value)
	{
		waitForLoadingComplete();
		selectFromDropdown(cmbFixDynUM, listFixDynUM, value);	
	}

}
