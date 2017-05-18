package bi3.pages.mms100

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import javax.xml.xpath.XPath
import java.util.List

class MMS100B extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="W1TRNR")
	WebElement txtOrdNum
	
	@FindBy(css="div[id*='MMA100BS'][class*='inforDataGrid']") 
 	WebElement gridElement;
	
	@FindBy(xpath = "//a[text()='Related']")
	WebElement linkRelated
	
	@FindBy(xpath = "//a/span[text()='DO/RO Toolbox']")
	WebElement linkDOROToolbox
	
	@FindBy(id="WWQTTP-shdo")
	WebElement cmbSortingOrder;
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listCmbSortingOrder
	
	/**
	 * Select sorting order drop down.
	 */
	def selectSortingOrder(String cmbLable) {
		waitForLoadingComplete();
		selectFromDropdown(cmbSortingOrder, listCmbSortingOrder, cmbLable);
		waitForLoadingComplete();
	}
	
	def void searchOrderNum(String ordNum){
		waitForLoadingComplete()		
		txtOrdNum.waitToBeClickable()
		txtOrdNum.click()
		txtOrdNum.clearRobustly()
		txtOrdNum.sendKeys(ordNum)
		txtOrdNum.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
	}
	
	def void goToDOROToolbox(String ordNum){
		waitForLoadingComplete()		
		var grid = new InforGrid(gridElement)
		var cells = grid.getRowsContainingTextInColumn(1,ordNum)
		cells.get(0).waitToBeClickable()
		cells.get(0).rightClick()
		linkRelated.waitToBeClickable()
		linkRelated.click()
		linkDOROToolbox.waitToBeClickable()
		linkDOROToolbox.click()
		waitForLoadingComplete()	
	}
	
	def String GetLwsOfOrder(String ordNum){
		waitForLoadingComplete()		
		var grid = new InforGrid(gridElement)
		var rows = grid.getRowsContainingTextInColumn(1,ordNum)
		var row = grid.getCellsFromRow(rows.get(0))
		return row.get(10).text
	}
	
	def String GetHisOfOrder(String ordNum){
		var grid = new InforGrid(gridElement)
		var rows = grid.getRowsContainingTextInColumn(1,ordNum)
		var row = grid.getCellsFromRow(rows.get(0))
		return row.get(11).text
	}
	
}