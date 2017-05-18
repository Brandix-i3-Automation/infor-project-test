package bi3.pages.pms040

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid
import bi3.pages.ToolbarPage

class PMS040B extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[id*='PMA040BS'][class*='inforDataGrid']") 
 	WebElement gridElement;
 	
 	@FindBy(xpath="//a/span[text()='Change']")
	WebElement linkChange;
	
	def void changeFirstRecord(){
		var InforGrid grid= new InforGrid(gridElement);
		var row = grid.getRow(0)
		row.waitToBeClickable()
		row.rightClick()
		linkChange.waitToBeClickable()
		linkChange.click()
		waitForLoadingComplete()
	}
	
	def String getStatusOfFirstRecord(){
		var InforGrid grid= new InforGrid(gridElement);
		var colId = grid.getColumnIndexByname("Sts")
		var data = grid.getDataOfRow(0)
		return data.get(colId)
	}
	
	def void clickRefresh(){
		var toolbar = new ToolbarPage(driver)
		toolbar.ClickAction_Refresh()
		waitForLoadingComplete()
	}
	
}