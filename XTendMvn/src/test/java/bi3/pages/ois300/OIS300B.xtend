package bi3.pages.ois300

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import java.util.List
import bi3.framework.elements.inforelements.InforGrid
import org.openqa.selenium.StaleElementReferenceException
import java.util.ArrayList

class OIS300B extends BasePage  {
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(id = "W4OBKV")
	WebElement txtCONumber;
	
	@FindBy(id = "WWQTTP-shdo")
	WebElement cmbSortingOrder;
	
	@FindBy(id="list-option0")
	List<WebElement> listSortingOrder;
	
	@FindBy(css="div[id*='OIA300BS'][class*='inforDataGrid']") 
	WebElement gridElement;

	
	
	def void searchCONumber(String CONumber)
	{
		waitForLoadingComplete();
		txtCONumber.click();
		txtCONumber.clearRobustly();
		
		txtCONumber.waitToBeDisplayed();
		txtCONumber.sendKeys(CONumber);
		txtCONumber.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		
	}
	
		def void setSortingOrder(String value)
	{
		waitForLoadingComplete();
		Thread.sleep(3000)
		selectFromDropdown(cmbSortingOrder, listSortingOrder, value);
		
	}
	
	
		def String getFirstRowStatus() {
			waitForLoadingComplete();
			waitToBeDisplayed(gridElement);
				try {
		
					var InforGrid grid = new InforGrid(gridElement);

					var status = grid.getCellsFromColumn(8)
				return status.get(0).text;
			
			} 	catch (StaleElementReferenceException ex) {
			
			}
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
	
	
















