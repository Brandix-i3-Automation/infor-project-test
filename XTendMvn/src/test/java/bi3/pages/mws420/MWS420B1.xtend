package bi3.pages.mws420

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid
import java.util.List

class MWS420B1 extends BasePage {
	
	@FindBy(css="div[id*='MWA420BS'][class*='inforDataGrid']")
	WebElement gridElementPickingList;
	
	@FindBy(css="div[class='grid-canvas grid-canvas-top grid-canvas-left']>div")
	WebElement gridFirstConsignee;
	
	@FindBy(xpath="//a[text()='Related']")
	WebElement linkRelated;
	
	@FindBy(xpath="//a//*[contains(text(), 'Confirm Issues')]")
	WebElement linkConfirmIssues;
	
	new(WebDriver driver) {
		super(driver)
	}
	
	/**
	 * navigate to related option.
	 */
	def goToRelatedOption(String option) {
		// Picking list
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(gridElementPickingList);
		var WebElement gridRow = null;
		if(grid.rowCount > 0){
			gridRow = grid.getRow(0);
			gridRow.click();
			rightClick(gridRow, true, option);
		}
		waitForLoadingComplete();
	}
	
	def String getPiSOfFirstRow(){
		waitForLoadingComplete();
		
		var InforGrid grid = new InforGrid(gridElementPickingList);
		var List<WebElement> cellElementList =  grid.getCellsFromRow(0);
		
		var cellPiS = cellElementList.get(1);
		var PiS = cellPiS.text;
	
		println("PiS value Returned");
		return PiS;
	}
	
	def void ConfirmIssues() {
		waitToBeClickable(gridFirstConsignee)
		rightClick(gridFirstConsignee);
		linkRelated.waitToBeClickable()
		linkRelated.click();
		linkConfirmIssues.waitToBeClickable()
		linkConfirmIssues.click();
		waitForLoadingComplete();
	}
	
}