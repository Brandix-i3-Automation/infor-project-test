package bi3.pages.pms070

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid
import org.openqa.selenium.Keys
import org.testng.Assert
import java.util.List

class PMS070B1 extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(css="div[id*='PMA070BS'][class*='inforDataGrid']")
	WebElement gridElement;

	@FindBy(xpath="//a/span[text()='Change']")
	WebElement linkChange;

	@FindBy(xpath="//a[text()='Related']")
	WebElement linkRelated;

	@FindBy(xpath="//a/span[text()='Confirmation']")
	WebElement linkConfirmation

	@FindBy(css="#WOSCHN+button")
	WebElement btnSchedNoLookUp

	@FindBy(id="POS")
	WebElement txtLookUpSearch

	@FindBy(css="div[row='0']>div[class='slick-cell l0 r0']")
	WebElement firstCellLookUpGrid


	@FindBy(id="BTN_L52T24")
	WebElement btnSelectLookUpGrid

	@FindBy(css="div[row='0']>div")
	WebElement firstGridCell;

	@FindBy(id="RelatedBtn")
	WebElement btnRealted;

	@FindBy(xpath="//*[contains(text(),'Confirmation')]/span")
	WebElement btnConfirmation;

	@FindBy(css="#tabsList > li.ui-tabs-selected.ui-state-active > button")
	WebElement btnClose

	@FindBy(xpath="//ul[contains(@id,'relOptsmenu_')]//a/span[contains(text(),'Close Operation')]")
	WebElement btnCloseOperation

	@FindBy(xpath="//ul[contains(@id,'menu_')]//li/a[contains(text(),'Related')]")
	WebElement btnRealtedToCloseOperation

	def ClosePage() {
		btnClose.click();
		System.out.println("PMS230 tab closed")

	}

	def SelectAllRows() {
		waitForLoadingComplete();
		firstGridCell.click();
		firstGridCell.SelectAllGridRows();

	}

	def ConfirmationRecord(int rowId) {
		var InforGrid grid = new InforGrid(gridElement);
		var row = grid.getRow(rowId)
		waitToBeClickable(row)
		rightClick(row)
		waitToBeClickable(btnRealted)
		btnRealted.click();
		btnConfirmation.click();
		waitForLoadingComplete();
	}

	def void goToChangeOfGridRow(int gridRowNumber) {
		var InforGrid grid = new InforGrid(gridElement);
		var row = grid.getRow(gridRowNumber)
		waitToBeClickable(row)
		rightClick(row)
		linkChange.click()
		waitForLoadingComplete()
	}

	def void confirmGridRow(int gridRowNumber) {
		var InforGrid grid = new InforGrid(gridElement);
		var row = grid.getRow(gridRowNumber)
		waitToBeClickable(row)
		rightClick(row)
		
		linkRelated.waitToBeClickable()
		linkRelated.click()
		linkConfirmation.waitToBeClickable()
		linkConfirmation.click()
		waitForLoadingComplete()
	}

	def String getStatusOfGridRow(int gridRow) {
		var InforGrid grid = new InforGrid(gridElement);
		var row = grid.getCellsFromRow(gridRow)
		return row.get(7).text;
	}

	def void setSchedNumberFromLookUp(String schedNo) {
		waitToBeClickable(btnSchedNoLookUp)
		btnSchedNoLookUp.click()
		waitForLoadingComplete()
		waitToBeClickable(txtLookUpSearch)
		txtLookUpSearch.click()
		clearRobustly(txtLookUpSearch)
		txtLookUpSearch.sendKeys(schedNo)
		txtLookUpSearch.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		if (firstCellLookUpGrid.text.equals(schedNo)) {
			firstCellLookUpGrid.click()
			btnSelectLookUpGrid.click()
		} else {
			Assert.fail("Schedule Number " + schedNo + " could not be found on the look up grid")
		}
	}

	def void closeOperationsWithStatus80() {
		waitForLoadingComplete();
		rightClick(firstGridCell);
		waitToBeClickable(btnRealtedToCloseOperation);
		btnRealtedToCloseOperation.click();
		waitForLoadingComplete();
		btnCloseOperation.click();
		waitForLoadingComplete();
		
	}

}
