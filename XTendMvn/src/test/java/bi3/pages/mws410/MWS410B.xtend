package bi3.pages.mws410

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List
import bi3.framework.elements.inforelements.InforGrid
import org.testng.Assert
import org.openqa.selenium.Keys

class MWS410B extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(id="WOPAVR-shdo")
	WebElement btnSelectView

	@FindBy(css="#dropdown-list>li")
	List<WebElement> listViewOptions

	@FindBy(xpath="//div[@class='gvWidgetHeader']/span[contains(text(),'Menu')]")
	WebElement headerMenu;

	@FindBy(css="input.inforSearchField")
	WebElement txtSearch;

	@FindBy(xpath="//div[@class='gvWidgetHeader']/span[contains(text(),'Menu')]/../..//div[@class='gvFillAbsolute']//li")
	WebElement MenuWidgetOptions;

	@FindBy(css='#ActionsBtn')
	WebElement btnActions;

	@FindBy(css="#WDPAVRContainer>button")
	WebElement btnView;
//	@FindBy(xpath="//a[text()='Related']")
//	WebElement linkRelated;
//	
//	@FindBy(xpath="//a/span[contains(text(),'Release for Picking')]")
//	WebElement linkReleaseForPicking;
	@FindBy(css="div[id*='MWA410BS'][class*='inforDataGrid']")
	WebElement gridElement;

	// / New works Raw Meterial Issueing
	@FindBy(css="#W1OBKV")
	WebElement txtConsignee;

	@FindBy(css="#W1OBKV")
	WebElement txtProject;

	@FindBy(css="div[class='grid-canvas grid-canvas-top grid-canvas-left']>div")
	WebElement gridFirstConsignee;

	@FindBy(css="#WOPAVR-shdo")
	WebElement cmbSortingOptionsView;

	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listInvView;

	@FindBy(xpath="//a[text()='Related']")
	WebElement linkRelated;
	
	@FindBy(xpath="//a/span[text()='Change']")
	WebElement linkChange;

	@FindBy(xpath="//a//*[contains(text(), 'Release for Picking')]") // a[text()='Report Issue']/span
	WebElement linkReleaseForPicking;

	@FindBy(xpath="//a//*[contains(text(), 'Picking Lists')]") // a[text()='Report Issue']/span
	WebElement linkPickingLists;

	@FindBy(xpath="//a//*[contains(text(), 'Confirm Issues')]")
	WebElement linkConfirmIssues;

	@FindBy(css=".inforIconButton.refresh")
	WebElement btnRefresh

	@FindBy(css=".slick-cell.l8.r8")
	WebElement lblRIP
	
	@FindBy(css="div[row='0'] >div ")
	WebElement firstGridCell;
	
	@FindBy(xpath="//a/span[contains(text(),'Picking List')]")
	WebElement linPickingList;
	
	@FindBy(css="#Prev")
	WebElement btnPrev;
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	@FindBy(xpath=".//a/span[contains(text(),'Packages')]")
	WebElement linkPackages;
	
	
	@FindBy(css="div[id*='MWA410BS'][class*='inforDataGrid']")
	WebElement gridElementDelivery;
	
	var elementValue = 90;
	
		def void ClickPrev() {
		waitForLoadingComplete()
		btnPrev.click();
		waitForLoadingComplete()

	}
	
	def void PackingList() {
		waitForLoadingComplete();
		rightClick(firstGridCell);
		waitToBeClickable(linkRelated);
		linkRelated.click();
		linPickingList.click();
		waitForLoadingComplete();
	}

	def List<String> TakeRipValue() {
		waitForLoadingComplete();
		
		var InforGrid grid = new InforGrid(gridElement);

		var List<String> data = grid.getDataOfColumn(11);

		return data;

	}

	def SelectAllRows() {

		var InforGrid grid = new InforGrid(gridElement);

		var deliveryBoxCol = grid.getCellsFromColumn(1)
		var secoundCell = deliveryBoxCol.get(1)
		waitForLoadingComplete()

		secoundCell.SelectAllGridRows();

	}

	

	def void selectView(String view) {
		selectFromDropdown(btnSelectView, listViewOptions, view)
		waitForLoadingComplete()
	}

	def void goToDeliveryToolbox() {
		var InforGrid grid = new InforGrid(gridElement);

		var schedCol = grid.getCellsFromColumn(1)
		var firstCell = schedCol.get(0)

		rightClick(firstCell)
		waitForLoadingComplete()

		linkRelated.click()
		waitForLoadingComplete()

		linkReleaseForPicking.click()
		waitForLoadingComplete()
	}

	// MWS410 Navigated
	def void GoToMWS410() {
		// Wait for Home page loaded
		waitToBeDisplayed(MenuWidgetOptions, 60);
		// Search for MMS0012
		headerMenu.click();
		waitToBeDisplayed(txtSearch);
		txtSearch.click();
		txtSearch.sendKeys("MWS410");
		txtSearch.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}

	// View Combo Box changed to A84
	def void selectComboValuesView(String value) {
		waitForLoadingComplete();
		selectFromDropdown(cmbSortingOptionsView, listInvView, value);
		waitForLoadingComplete();
	}

	def void searchConsignee(String consignee) {
		waitForLoadingComplete();
		txtConsignee.click();
		txtConsignee.sendKeys(consignee);
		txtConsignee.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}

	// Release for picking
	def boolean relaseForPicking() {
		
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(gridElement);

		var deliveryBoxCol = grid.getCellsFromColumn(1)
		var secoundCell = deliveryBoxCol.get(0)
		waitForLoadingComplete()

		secoundCell.SelectAllGridRows();
		rightClick(gridFirstConsignee);
		linkRelated.click();
		linkReleaseForPicking.click();
		waitForLoadingComplete();
		Thread.sleep(7000)
		refreshPage()
		
		var rip = getRIPOFRow1()
		var loopC = 1
		
		while((loopC<3)&&(rip!="1")){
			Thread.sleep(3000)
			refreshPage()
			rip = getRIPOFRow1()
			loopC = loopC + 1
		}
		
		if(rip=="1"){
			return true;
		} else {
			return false
		}
	}

	// Add to Picking list
	def void AddToPickingList(String consignee) {

		txtConsignee.click();
		txtConsignee.sendKeys(consignee);
		txtConsignee.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		gridFirstConsignee.click();
		rightClick(gridFirstConsignee);
		linkRelated.click();
		linkReleaseForPicking.click();
		waitForLoadingComplete();

	}

	// Move to picking list
	def void MoveToPickingList() {
		waitForLoadingComplete();
		gridFirstConsignee.click();
		Thread.sleep(2000);
		rightClick(gridFirstConsignee);
		linkRelated.click();
		waitToBeClickable(linkPickingLists)
		Thread.sleep(2000)
		linkPickingLists.click();
		waitForLoadingComplete();
		Thread.sleep(2000)
		println("Picking List");
	}

	// Confirm Issues	
	def void ConfirmIssues() {
		waitToBeClickable(gridFirstConsignee)
		rightClick(gridFirstConsignee);
		linkRelated.click();
		linkConfirmIssues.click();
		waitForLoadingComplete();
		println("Confirm Issues");
	}

	// Release for picking and confirm
	def void ReleaseForPicking() {
		// Confirmation for 90 status
		Assert.assertEquals(elementValue, "90", "Error");

	}

	def void refreshPage() {
		waitToBeClickable(btnRefresh)
		btnRefresh.click()
		waitForLoadingComplete()
	}

	def String getRIPOFRow1() {
		var InforGrid gridDelivery = new InforGrid(gridElementDelivery);
		var colId = gridDelivery.getColumnIndexByname("RlP")
		var rip = gridDelivery.getDataOfColumn(colId)
		System.out.println("RIP was "+rip.get(0))
		return rip.get(0)
	}
	
	def void changeRecord(){
		waitToBeClickable(gridFirstConsignee)
		rightClick(gridFirstConsignee);
		linkChange.click();
		waitForLoadingComplete();
	}
	
	def void ReleaseForPickingDOP(){
		waitForLoadingComplete();
		waitToBeDisplayed(gridFirstLine);
		gridFirstLine.rightClick;
		waitToBeDisplayed(linkRelated);
		linkRelated.click();
		waitToBeDisplayed(linkReleaseForPicking);
		linkReleaseForPicking.click();
		println("Release for picking")
		waitForLoadingComplete();
	}
	
	def void GoToPackages(){
		waitForLoadingComplete();
		waitToBeDisplayed(gridFirstLine);
		gridFirstLine.rightClick;
		waitToBeDisplayed(linkRelated);
		linkRelated.click();
		waitToBeDisplayed(linkPackages)
		linkPackages.click();
		waitForLoadingComplete();
	}
	
	
	/**
	 * navigate to related option.
	 */
	def goToRelatedOption(String option) {
		// Delivery. Open Toolbox
		waitForLoadingComplete();
		var InforGrid gridDelivery = new InforGrid(gridElementDelivery);
		var WebElement gridRowDelivery = null;
		if(gridDelivery.rowCount > 0){
			gridRowDelivery = gridDelivery.getRow(0);
			gridRowDelivery.click();
			rightClick(gridRowDelivery, true, option);
		}
		waitForLoadingComplete();
	}


}
