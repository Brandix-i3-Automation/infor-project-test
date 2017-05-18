package bi3.pages.mms100

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import bi3.framework.exceptions.FrameworkException

class MMS100B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WWQTTP-shdo")
	WebElement cmbSortingOrder;
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listCmbSortingOrder
	
	@FindBy(id="W3RORC")
	WebElement txtRoc;
	
	@FindBy(id="W3RORN")
	WebElement txtRefOrder;
	
	@FindBy(css="div[id*='MMA100BS'][class*='inforDataGrid']")
	WebElement gridElementDistrOrder;
	
	@FindBy(css="div[id*='MWA420BS'][class*='inforDataGrid']")
	WebElement gridElementPickingList;
	
	@FindBy(id="toolBoxBtnCont")
	WebElement btnToolBox;
	
	@FindBy(css=".inforIconButton.refresh")
	WebElement btnRefresh;
	
	@FindBy(id="W1TRNR")
	WebElement txtOrderNumber;
	
	@FindBy(id="W1RESP")
	WebElement txtResp;
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	@FindBy(linkText="Related")
	WebElement linkRelated;
	
	@FindBy(xpath=".//a/span[contains(text(),'Order Lines')]")
	WebElement linkOrderLines;
	
	@FindBy(xpath=".//a/span[contains(text(),'Delivery Toolbox')]")
	WebElement linkDeliveryToolbox;
	
	/**
	 * Select sorting order drop down.
	 */
	def selectSortingOrder(String cmbLable) {
		waitForLoadingComplete();
		selectFromDropdown(cmbSortingOrder, listCmbSortingOrder, cmbLable);
		waitForLoadingComplete();
	}
	
	def filterRequestOrder(String roc, String refOrdNo) {
		txtRoc.sendKeys(roc);
		txtRefOrder.sendKeys(refOrdNo);
		txtRefOrder.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}
	
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
	
	/**
	 * refresh Page.
	 */
	def void refreshPage() {
		waitToBeClickable(btnRefresh)
		btnRefresh.click()
		waitForLoadingComplete()
	}
	
	/**
	 * Get column value using column header name and row index.
	 */
	def String getColumnVal(String colHeaderName, int rowIndex) {
		waitForLoadingComplete()
		var InforGrid grid = new InforGrid(gridElementDistrOrder);
		return grid.getColumnValByColumnHeader(colHeaderName, rowIndex);
	}
	
	def void SearchOrder(String ordernumber, String resp){
		waitForLoadingComplete()		
		waitToBeDisplayed(txtOrderNumber);
		txtOrderNumber.sendKeys(ordernumber);
		txtResp.sendKeys(resp);
		txtResp.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}
	
	def void GoToOrderLines(){
		waitForLoadingComplete();
		gridFirstLine.rightClick;
		waitToBeDisplayed(linkRelated);
		linkRelated.click();
		waitToBeDisplayed(linkOrderLines);
		linkOrderLines.click();
	}
	
	def void GoToDeliveryToolbox(){
		waitForLoadingComplete()
		gridFirstLine.rightClick;
		waitToBeDisplayed((linkRelated));
		linkRelated.click();
		waitToBeDisplayed(linkDeliveryToolbox);
		linkDeliveryToolbox.click();
		println("Delivery Toolbox");
		waitForLoadingComplete();
	}
}