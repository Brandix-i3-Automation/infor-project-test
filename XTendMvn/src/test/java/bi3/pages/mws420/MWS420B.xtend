package bi3.pages.mws420

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid

class MWS420B extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement firstCell
	
	@FindBy(xpath="//a[text()='Related']")
	WebElement linkRelated;
	
	@FindBy(xpath="//a//*[contains(text(), 'Confirm Issues')]")
	WebElement linkConfirmIssues;
	
	@FindBy(css="div[id*='MWA420BS'][class*='inforDataGrid']") 
 	WebElement gridElement;
	
	// Confirm Issues	
	def void ConfirmIssues() {
		waitToBeClickable(firstCell)
		rightClick(firstCell);
		linkRelated.click();
		linkConfirmIssues.click();
		waitForLoadingComplete();
	}
	
	def String getPiSOfRow(int rowId){
		var grid = new InforGrid(gridElement)
		var cells = grid.getCellsFromRow(0)
		return cells.get(1).text
	}

}