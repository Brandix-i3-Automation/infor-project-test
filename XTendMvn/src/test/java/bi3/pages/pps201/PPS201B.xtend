package bi3.pages.pps201

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid

class PPS201B extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[id*='PPA201BS'][class*='inforDataGrid']") 
 	WebElement gridElement;
	
	def boolean CheckIfDetailsGridEmpty(){
		var grid = new InforGrid(gridElement)
		if(grid.rowCount==0){
			return true;
		}else{
			return false;
		}
	}
}