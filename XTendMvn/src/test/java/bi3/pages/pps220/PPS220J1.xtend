package bi3.pages.pps220

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import org.testng.Assert
import java.util.List

class PPS220J1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[id*='PPA220JS'][class*='inforDataGrid']") 
 	WebElement gridElement;
 	
 	@FindBy(id="ActionsBtn")
 	WebElement btnAction
 	
 	@FindBy(css="ul[id*='ActionsMenu']>li")
 	List<WebElement> listActions
 	
 	def String getPONumberOfRow(int rowId){
 		var grid= new InforGrid(gridElement);
 		var po = grid.getDataOfRow(rowId)
 		return po.get(0)
 		
 	}
 	
 	def void selectAction(String action){
		selectFromDropdown(btnAction,listActions,action)
	}
}