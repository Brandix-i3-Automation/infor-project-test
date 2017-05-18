package bi3.pages.mms001

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import bi3.pages.BasePage
import java.util.List

class MMS001E extends BasePage {

	new(WebDriver driver) { // Constructor
		super(driver)
	}

	@FindBy(id="WEITNO")
	WebElement txtItemNumber;

	@FindBy(id="MMSTCD-shdo")
	WebElement cmbInvAccounting;

	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listInvAccounting;

	@FindBy(id="MMINDI-shdo")
	WebElement cmbLotCtrlMethod;

	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listLotCtrlMethod;

	@FindBy(id="MMBACD-shdo")
	WebElement cmbLotNumbMethod;

	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listLotNumbMethod;

	@FindBy(id="MMSTAT-shdo")
	WebElement cmbStatus;

	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listStatus;

	@FindBy(id="Next")
	WebElement btnNext;

	def void Next() {
		waitForLoadingComplete();
		btnNext.click();
		waitForLoadingComplete();
	}

	def void SelectInvAccounting(String value) {
		waitForLoadingComplete();
		selectFromDropdown(cmbInvAccounting, listInvAccounting, value);
		waitForLoadingComplete();
	}

	def void SelectLotCtrlMethod(String value) {
		waitForLoadingComplete();
		selectFromDropdown(cmbLotCtrlMethod, listLotCtrlMethod, value);
		waitForLoadingComplete();
	}

	def void SelectLotNumbMethod(String value) {
		waitForLoadingComplete();
		selectFromDropdown(cmbLotNumbMethod, listLotNumbMethod, value);
		waitForLoadingComplete();
	}

	def String GetItemNumber(){
		waitForLoadingComplete();
		return txtItemNumber.GetTextBoxvalue();
	}
	
	def void setStatus(String status) {
		waitForLoadingComplete();
		selectFromDropdown(cmbStatus, listStatus, status);
		waitForLoadingComplete();
	}
	
	
}
