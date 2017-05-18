package bi3.pages.pps200

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid

class PPS200B extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="W1OBKV")
	WebElement txtPONo
	
	@FindBy(css="div[id*='PPA200BS'][class*='inforDataGrid']") 
 	WebElement gridElement;
	
	@FindBy(xpath = "//a/span[text()='Copy']")
	WebElement linkCopy
	
	@FindBy(xpath = "//a[text()='Related']")
	WebElement linkRelated
	
	@FindBy(xpath = "//a/span[text()='Lines']")
	WebElement linkLines
	
	def boolean SearchPONo(String po){
		waitForLoadingComplete();
		txtPONo.waitToBeClickable()
		txtPONo.click()
		txtPONo.clearRobustly()
		txtPONo.sendKeys(po)
		txtPONo.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		
		var grid = new InforGrid(gridElement)
		var row = grid.getCellsFromRow(0)
		
		if(row.get(0).text.equals(po)){
			return true;
		}else{
			return false;
		}
		
	}
	
	def void copyPO(String po){
		waitForLoadingComplete();
		var grid = new InforGrid(gridElement)
		var row = grid.getRowContainingTextInColumn(1,po)
		row.waitToBeClickable()
		row.rightClick()
		linkCopy.waitToBeClickable()
		linkCopy.click()
		waitForLoadingComplete()
	}
	
	def String GetLstOfRecordWithPO(String po){
		waitForLoadingComplete();
		var grid = new InforGrid(gridElement)
		var rowData = grid.getDataOfRowContainingTextInColumn(1,po)
		return rowData.get(1)
	}
	
	def void GoToLinesOfRecordWithPO(String po){
		waitForLoadingComplete();
		var grid = new InforGrid(gridElement)
		var row = grid.getRowContainingTextInColumn(1,po)
		row.waitToBeClickable()
		row.rightClick()
		linkRelated.waitToBeClickable()
		linkRelated.click()
		linkLines.waitToBeClickable()
		linkLines.click()
	}
	
}