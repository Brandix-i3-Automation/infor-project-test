package bi3.pages.pms050

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import bi3.framework.elements.inforelements.InforGrid
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class PMS050B1 extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(css="div[id*='PMA050BS'][class*='inforDataGrid']")
	WebElement gridElement;

	@FindBy(css=".inforIconButton.refresh")
	WebElement btnRefresh

	@FindBy(css=".slick-cell.l0.r0")
	WebElement firstGridCell;

	@FindBy(id="RelatedBtn")
	WebElement btnRealted;

	@FindBy(xpath="//*[contains(text(),'Confirmation')]/span/..")
	WebElement btnConfirmation;
	
	@FindBy(xpath="//a/span[text()='Change']")
	WebElement linkChange;
	
	
	
	
	def Confirmation(){
		waitForLoadingComplete()
		waitToBeClickable(btnRealted)
	  	btnRealted.click();
	  	waitToBeClickable(btnConfirmation)
	  	btnConfirmation.click();
	  waitForLoadingComplete();
	}

	def SelectAllRows() {
		waitForLoadingComplete();
		firstGridCell.click();
		firstGridCell.SelectAllGridRows();
		waitForLoadingComplete();

	}

	def String getStatusOfGridRow(int gridRow) {
		var InforGrid grid = new InforGrid(gridElement);
		var row = grid.getCellsFromRow(gridRow)
		return row.get(7).text;
	}

	def void refreshPage() {
		waitToBeClickable(btnRefresh)
		btnRefresh.click()
		waitForLoadingComplete()
	}
	
	def void goToChangeOfGridRow(int gridRowNumber) {
		var InforGrid grid = new InforGrid(gridElement);
		var row = grid.getRow(gridRowNumber)
		waitToBeClickable(row)
		rightClick(row)
		linkChange.click()
		waitForLoadingComplete()
	}
}
