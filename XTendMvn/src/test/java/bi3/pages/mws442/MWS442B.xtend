package bi3.pages.mws442

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid

class MWS442B extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[id*='MWA442BS'][class*='inforDataGrid']") 
 	WebElement gridElement;
	
	@FindBy(xpath = "//a[text()='Related']")
	WebElement linkRelated
	
	@FindBy(xpath = "//a/span[text()='Report DO/RO Receipt']")
	WebElement linkDOROReceipt
	
	def void goToDOROReceiptOfRow(int rowId){
		waitForLoadingComplete()		
		var grid = new InforGrid(gridElement)
		var cells = grid.getCellsFromRow(rowId)
		cells.get(0).waitToBeClickable()
		cells.get(0).rightClick()
		linkRelated.waitToBeClickable()
		linkRelated.click()
		linkDOROReceipt.waitToBeClickable()
		linkDOROReceipt.click()
		waitForLoadingComplete()	
	}
}