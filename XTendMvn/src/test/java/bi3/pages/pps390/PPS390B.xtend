package bi3.pages.pps390

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid
import bi3.pages.ToolbarPage
import java.util.List
import org.openqa.selenium.Keys

class PPS390B extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[id*='PPA390BS'][class*='inforDataGrid']") 
 	WebElement gridElement;
 	
 	@FindBy(xpath = "//a[text()='Related']")
 	WebElement linkRelated
 	
 	@FindBy(xpath = "//a/span[text()='Lines']")
 	WebElement linkLines
 	
 	@FindBy(id = "WWQTTP-shdo")
	WebElement btnOrderSelect
	
	@FindBy(css = "#dropdown-list>li")
	List<WebElement> listOrderOptions
	
	@FindBy(id = "W5FACI")
	WebElement txtFac
	
	@FindBy(id = "W5WHLO")
	WebElement txtWarehouse
	
	@FindBy(id = "W5PUNO")
	WebElement txtPO
	
	def void GoToRelatedLinesOfPO(String po){
		var grid = new InforGrid(gridElement)
		var row = grid.getRowContainingTextInColumn(7,po)
		row.waitToBeClickable()
		row.rightClick()
		linkRelated.waitToBeClickable()
		linkRelated.click()
		linkLines.waitToBeClickable()
		linkLines.click()
		waitForLoadingComplete()
	}
	
	def void ChangeRecordWithPO(String po){
		var grid = new InforGrid(gridElement)
		var row = grid.getRowContainingTextInColumn(3,po)
		row.waitToBeClickable()
		row.click()
		var toolbar = new ToolbarPage(driver)
		toolbar.clickChangeLogo()
	}
	
	def void SelectSortingOrder(String sorting){
		selectFromDropdown(btnOrderSelect,listOrderOptions,sorting)
		waitForLoadingComplete()
	}
	
	def void SearchBy(String po,String fac,String warehouse){
		txtFac.waitToBeClickable()
		txtFac.click()
		txtFac.clearRobustly()
		txtFac.sendKeys(fac)
		
		txtWarehouse.waitToBeClickable()
		txtWarehouse.click()
		txtWarehouse.clearRobustly()
		txtWarehouse.sendKeys(warehouse)
		
		txtPO.waitToBeClickable()
		txtPO.click()
		txtPO.clearRobustly()
		txtPO.sendKeys(po)
		txtPO.sendKeys(Keys.ENTER)
		
		waitForLoadingComplete()	
	}
}