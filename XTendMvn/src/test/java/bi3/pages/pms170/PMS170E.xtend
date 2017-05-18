package bi3.pages.pms170

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List

class PMS170E extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}
	
	
	
	@FindBy(id="WEFIDT")
	WebElement txtDate;
	
	@FindBy(id="WEORQA")
	WebElement txtPlaneQty;
	
	@FindBy(id="WEPSTS-shdo")
	WebElement cmbStatus;

	@FindBy(css="#dropdown-list li")
	List<WebElement> listStatus;
	
	@FindBy(id="WEORTY")
	WebElement txtOrderType;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(css="#Prev")
	WebElement btnPrev;
	
	
	def void EnterFinishDate(String date) {
		txtDate.sendKeys(date);

	}
	
	def void EnterPlanQty(String qty) {
		txtPlaneQty.sendKeys(qty);

	}
	
	def void SelectStatus(String value) {
		waitForLoadingComplete();
		selectFromDropdown(cmbStatus, listStatus, value);
	}
	
		def void SelectOrderType(String orderType) {
		txtOrderType.click();
		txtOrderType.sendKeys(orderType);

	}
	
	def void clickNext() {
       btnNext.click()
		waitForLoadingComplete()
	}
	
	def void ClickPrev() {	
		btnPrev.click();
		waitForLoadingComplete()
	

	}
	
}
















