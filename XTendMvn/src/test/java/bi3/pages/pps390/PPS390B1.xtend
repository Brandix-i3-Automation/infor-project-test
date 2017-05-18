package bi3.pages.pps390

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid
import java.util.List
import org.openqa.selenium.Keys

class PPS390B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[id*='PPA390BS'][class*='inforDataGrid']")
	WebElement gridElementReturnToSupplier;
	
	@FindBy(css=".inforIconButton.refresh")
	WebElement btnRefresh;
	
	@FindBy(id = "WWQTTP-shdo")
	WebElement btnFilterDropdown;
	
	@FindBy(css = "#dropdown-list>li")
	List<WebElement> listFilterOptions;
	
	@FindBy(id = "W1CLRE")
	WebElement txtOurRef;
	
	@FindBy(id = "W1WHLO")
	WebElement txtWhs;
	
	@FindBy(id = "W1CLAN")
	WebElement txtRno;
	
	/**
	 * Select last row.
	 */
	def selectLastRow() {
		var InforGrid grid = new InforGrid(gridElementReturnToSupplier);
		var List<WebElement> rows = grid.allRows;
		rows.last.click();
	}
	
	/**
	 * Get column value using column header name and row index.
	 */
	def String getColumnVal(String colHeaderName) {
		var InforGrid grid = new InforGrid(gridElementReturnToSupplier);
		// Get the last row of the table
		return grid.getColumnValByColumnHeader(colHeaderName, 0);
	}
	
	/**
	 * refresh Page.
	 */
	def void refreshPage() {
		waitToBeClickable(btnRefresh)
		btnRefresh.click()
		waitForLoadingComplete()
	}
	
	/**
	 * Change the grid sorting order.
	 */
	def void changeSortingOrder(String stat){
		waitForLoadingComplete();
		selectFromDropdown(btnFilterDropdown,listFilterOptions,stat)
		waitForLoadingComplete();
	}
	
	/**
	 * Filter the grid.
	 */
	def filterGrid(String ourRef, String whs, String rno) {
		waitForLoadingComplete();
		txtOurRef.sendKeys(ourRef);
		txtOurRef.sendKeys(Keys.ENTER);
		
		waitForLoadingComplete();
		txtWhs.sendKeys(whs);
		txtWhs.sendKeys(Keys.ENTER);
		
		waitForLoadingComplete();
		txtRno.sendKeys(rno);
		txtRno.sendKeys(Keys.ENTER);
		
		waitForLoadingComplete();
	}
}