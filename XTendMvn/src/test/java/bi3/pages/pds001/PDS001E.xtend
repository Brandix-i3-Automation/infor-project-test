package bi3.pages.pds001

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid
import java.util.List

class PDS001E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	//ELEMENTS
	@FindBy(id="W1CNQT")
	WebElement txtQuantity
	
	//PAGE ACTIONS
	def void setQuantity(String qty){
		waitToBeDisplayed(txtQuantity)
		txtQuantity.clearRobustly();
		txtQuantity.sendKeys(qty)
		
	}
	
	@FindBy(id="div[id*='OIA101BS'][class*='inforDataGrid']")
	WebElement gridOIS100
	
	def void getDetails(){
		var InforGrid grid = new InforGrid(gridOIS100);
		grid.getCell(1,"A1000").rightClick();
		grid.getDataOfRowContainingTextInColumn(1,"Y121212")
	}
	
	
	//
	@FindBy(id="WHSTAT-shdo")
	WebElement cmbStatus
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listStatus;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	def void setStatus(String status) {
		waitForLoadingComplete();
		selectFromDropdown(cmbStatus, listStatus, status);
		waitForLoadingComplete();
	}
	
	def void Next() {
		btnNext.click();
		waitForLoadingComplete();
	}
	
}