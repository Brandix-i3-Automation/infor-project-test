package bi3.pages.mms080

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.testng.Assert
import bi3.framework.elements.inforelements.InforGrid
import java.util.List
import bi3.pages.ToolbarPage
import bi3.pages.ProgramCommons
import org.openqa.selenium.Keys

class MMS080B1 extends ProgramCommons{
	new(WebDriver driver) {
		super(driver)
	}
	
	/*
	 * PAGE OBJECTS
	 * 
	 */
	@FindBy(id="WWITNO") 
	WebElement txtBoxItemNo;
	
	@FindBy(id="div[id*='MMA080B1']") 
	WebElement grid;
	
	@FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Calculate MRP')]") 
	WebElement btncalculateMRP;
	
	@FindBy(xpath="//*[@id='commandBar']/div[2]/span/button[7]") 
	WebElement btnRefresh;

	@FindBy(id="WWWHLO")
	WebElement txtWarehouse;
	
	@FindBy(id="XT_0168") 
	WebElement btnApply;
	
	@FindBy(css="div[id*='MMA080B1'][class*='inforDataGrid']") 
	WebElement gridMMA080;
	
	@FindBy(id = "W1ORCA")
	WebElement txtOct
	
	
	
	
	/*
	 * ACTIONS ( TEST METHODS )
	 * 
	 */	
	 /**
	  * Set values to fields in the header section of the program
	  * @param itemNumber Item Number
	  * @param warehouse Warehouse
	  */
	def void setHeaderDetails(String itemNumber, String warehouse) {
		waitForLoadingComplete()

		if (itemNumber != "") {
			// Inserting itemNo 
			txtBoxItemNo.click()
			txtBoxItemNo.clear()
			txtBoxItemNo.sendKeys(itemNumber)
			txtBoxItemNo.click()
		}

		if (warehouse != "") {
			txtWarehouse.click()
			txtWarehouse.clearRobustly()
			txtWarehouse.sendKeys(warehouse)
		}

		// Apply
		btnApply.click();
		waitForLoadingComplete();
	}
	
	def List<String> getDetailsFromGrid(String Pldt){
		var InforGrid grid = new InforGrid(gridMMA080);
		var List<String> dataList = grid.getDataOfRowContainingTextInColumn(2,Pldt);		
		return dataList;
	}
	
	/**
	 * FNB Details
	 */
	
	def List<String> getFnbDetailsFromGrid(){
		var InforGrid grid = new InforGrid(gridMMA080);
		var List<String> dataList = grid.getDataOfColumn("Oct");		
		return dataList;
	}
	
	/**
	 * @param columnIndex Column index starts from 1
	 */
	def List<String> getDetailsFromGrid(int columnIndex, String value){
		var InforGrid grid = new InforGrid(gridMMA080);
		var List<String> dataList = grid.getDataOfRowContainingTextInColumn(columnIndex,value);		
		return dataList;
	}
	
	def void EditWarehouse(String warehouse){
		waitForLoadingComplete();
		txtWarehouse.clearRobustly();
		waitToBeDisplayed(txtWarehouse);
		txtWarehouse.sendKeys(warehouse);
		txtWarehouse.sendKeys(Keys.ENTER); 
	}
	
	def void calculateMRPAndRefreshPage() {
		btnActionBtn.clickWhenReady();
		btncalculateMRP.clickWhenReady();
		waitForLoadingComplete();

		// Wait till calculation is performed
		lblFooterMessage.waitForContainText("Requirements calculation performed", 15);

		// Refresh page
		btnRefresh.clickWhenReady();
		waitForLoadingComplete();			
	}
	
	def void SearchByOct(String oct){
		 txtOct.EnterText(oct)
		 txtOct.sendKeys(Keys.ENTER)
		 waitForLoadingComplete()
	}
	
	def String GetOrderNoOfRecordWithOct(String oct){
		var data = getDetailsFromGrid(6,oct)
		return data.get(8)
	}
	
	/*
	 * Get the order number base on OCT column.
	 */
	def List<String> getDataOfRow(String colHeaderName, String value) {
		waitForLoadingComplete();
		var InforGrid InforGrid = new InforGrid(gridMMA080);
		var colIndex = InforGrid.getColumnIndexByname(colHeaderName);
		var List<String> cells = InforGrid.getDataOfRowContainingTextInColumn(colIndex+1,value);
		return cells;
	}
	
}