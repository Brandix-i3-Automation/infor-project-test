package bi3.pages.mms101

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid

class MMS101B extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[id*='MMA101BS'][class*='inforDataGrid']")
	WebElement gridElementDistrOrder;
	
	/**
	 * navigate to related option.
	 */
	def goToRelatedOption(String option) {
		// distr Order
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(gridElementDistrOrder);
		var WebElement gridRow = null; 
		if(grid.rowCount > 0){
			gridRow = grid.getRow(0);
			gridRow.click();
			rightClick(gridRow, true, option);
		}
		waitForLoadingComplete();
	}
	
	
}