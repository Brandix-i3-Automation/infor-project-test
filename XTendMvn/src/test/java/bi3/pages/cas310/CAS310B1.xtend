package bi3.pages.cas310

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import java.util.ArrayList

class CAS310B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "WWQTTP-shdo")
	WebElement cmbSortingOrder;
	
	@FindBy(id="list-option1")
	List<WebElement> listSortingOrder;
	
	@FindBy(id="WGFACI")
	WebElement txtFacility
	
	@FindBy(id = "W2RIDN")
	WebElement txtMONumber;
		
	@FindBy(css="div[id*='CAA310BS'][class*='inforDataGrid']") 
	WebElement gridElement;
		
	def void setSortingOrder(String value)
	{
		waitForLoadingComplete();
		Thread.sleep(3000)
		selectFromDropdown(cmbSortingOrder, listSortingOrder, value);
		
	}
	
	def void FillFacility(String Division){
		waitForLoadingComplete();
		txtFacility.sendKeys(Division);
	}
	
	def void searchMONumber(String CONumber)
	{
		waitForLoadingComplete();
		txtMONumber.click();
		txtMONumber.clearRobustly();
		
		txtMONumber.waitToBeDisplayed();
		txtMONumber.sendKeys(CONumber);
		txtMONumber.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		
	}
	
	def List<String> GetStatuses(String Sno)
	 {
		waitForLoadingComplete();
		Thread.sleep(3000);
		var InforGrid grid = new InforGrid(gridElement);
		var data = grid.getDataOfRowContainingTextInColumn(8, Sno);

		var newList = new ArrayList<String>();
		newList.add(0, data.get(8).toString);
		

		return newList;

	}	
	
	
}