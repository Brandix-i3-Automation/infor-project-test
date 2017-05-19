package bi3.pages.mms001

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys
import bi3.pages.BasePage
import java.util.List
import bi3.framework.elements.inforelements.InforGrid

class MMS001 extends BasePage {

	new(WebDriver driver) { // Constructor
		super(driver)
	}

	@FindBy(id="W1OBKV")
	WebElement txtItemNumber;

	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;

	@FindBy(xpath="//a/span[contains(text(),'Copy')]")
	WebElement linkCopy;

	@FindBy(css="div.slick-cell.l0.r0>a")
	List<WebElement> listItemNumbers;	
	
	@FindBy(css="#tabsList > li.ui-tabs-selected.ui-state-active > button")
	WebElement btnClose
	
	@FindBy(xpath="//a[text()='Related']")
	WebElement linkRelated;
	
	@FindBy(xpath="//a/span[contains(text(),'Item/Warehouse')]")
	WebElement linkItemWarehouse;

	@FindBy(xpath="//a/span[contains(text(),'Item/Facility')]")
	WebElement linkItemFacility;
	
	@FindBy(css="div[id*='MMA001BS'][class*='inforDataGrid']")
	WebElement gridMMS001;
	
	@FindBy(css="button.inforIconButton.edit")
	WebElement btnEdit;
	
	@FindBy(id="CPITNO")
	WebElement txtChangeItemNumber;
	
	def void SearchByItemNumber(String itemNumber) {
		waitForLoadingComplete();
		txtItemNumber.click();
		waitForLoadingComplete();
		txtItemNumber.clearRobustly();
		
		txtItemNumber.waitToBeDisplayed();
		txtItemNumber.sendKeys(itemNumber);
		waitForLoadingComplete();
		txtItemNumber.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}

	def void CopyItem(String itemNumber) {
		waitForLoadingComplete();
		rightClick(gridFirstLine);
		
		// Copy Item
		waitToBeDisplayed(linkCopy)
		waitToBeClickable(linkCopy);
		linkCopy.click()
		waitForLoadingComplete();
	}

	def List<String> GetItemNumberList() {
		waitForLoadingComplete();
		return getTextList(listItemNumbers);
	}
	
	def void setItemWarehouse(String itemNumber){
		/*
		waitForLoadingComplete();
		Thread.sleep(1000);
		//rightClick(gridFirstLine);
		try{
			rightClick(gridFirstLine,true,"Item/Warehouse");
			
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				rightClick(gridFirstLine,true,"Item/Warehouse");
			}
		
//		waitToBeClickable(linkRelated);
//		linkRelated.click();
//		
//		waitToBeClickable(linkItemWarehouse);
//		linkItemWarehouse.click();
		
//		waitForLoadingComplete();
*/
		try {
			gridFirstLine.sendKeys(Keys.chord(Keys.CONTROL, "11"));
		} catch (Exception e) {
			//System.out.println("Element " + element + " cannot select All Rows" + e.getStackTrace());
		}
	}	
	
	
	
	def close() {
		btnClose.click()
		System.out.println("MMS001 tab closed")
	}
	
	/**
	 * Navigate to Item Warehouse link in Item
	 */
	def void ItemWarehouse(String itemNumber){
		waitForLoadingComplete();
		gridFirstLine.sendKeys(Keys.chord(Keys.CONTROL,"11"));
		waitForLoadingComplete();	
	}
	
	def void setItemFacility(String itemNumber)
	{
		waitForLoadingComplete();
		rightClick(gridFirstLine);
		
		waitToBeClickable(linkRelated);
		linkRelated.click();
		
		waitToBeClickable(linkItemFacility);
		linkItemFacility.click();
		
		waitForLoadingComplete();
	}
	
	def List<String> getDataOfItem(String itemNumber){
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(gridMMS001);
		var dataList = grid.getDataOfRowContainingTextInColumn(1, itemNumber);
		return dataList;		
	}
	
	def void EditItem(String itemNumber) {
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(gridMMS001);
		var cell = grid.getCell("Item number",itemNumber);
		waitToBeClickable(cell)
		cell.click();
		waitForLoadingComplete();
	
		btnEdit.clickWhenReady();
		waitForLoadingComplete();			
	}
	
	def void clearItemInsertNewNo(String itemNumber){
		
		waitForLoadingComplete();
		txtChangeItemNumber.clear;
		txtChangeItemNumber.sendKeys(itemNumber);
		
	}
}
