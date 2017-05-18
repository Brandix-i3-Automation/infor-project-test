package bi3.pages.ois300

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys
import bi3.pages.BasePage
import java.util.List

class OIS300PlannedPurchaseOrder extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(id="WEPSTS-shdo")
	WebElement cmbStatus;
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listStatus;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(id="WFBUYE")
	WebElement txtBuyerFrom;
	
	@FindBy(id="WTBUYE")
	WebElement txtBuyerTo;
	
	def void setStatus(String value)
	{
		waitForLoadingComplete();
		selectFromDropdown(cmbStatus,listStatus,value);
	}
	
	def void Next()
	{
		waitForLoadingComplete();
		btnNext.click();
		
	}
	
	def void clearBuyerFrom()
	{
		waitForLoadingComplete();
		txtBuyerFrom.clearRobustly();
	}
	
	def void clearBuyerTo()
	{
		waitForLoadingComplete();
		txtBuyerTo.clearRobustly();
	}
}
