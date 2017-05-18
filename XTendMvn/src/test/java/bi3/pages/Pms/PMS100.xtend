package bi3.pages.Pms

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.pages.BasePage
import java.util.List
import org.testng.Assert

class PMS100 extends BasePage {
	new(WebDriver driver) { // Constructor
		super(driver)
	}

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

	@FindBy(id="#POS")
	WebElement txtPOS;

	@FindBy(css="#W1OBKV")
	WebElement txtConsignee;

	@FindBy(css="#W1OBKV")
	WebElement txtProject;

	@FindBy(css="div[class='grid-canvas grid-canvas-top grid-canvas-left']>div")
	WebElement gridFirstConsignee;

	@FindBy(xpath="//a[text()='Related']")
	WebElement linkRelatedold;

	@FindBy(xpath="//a//*[contains(text(), 'Check Component Availability')]") // a[text()='Report Issue']/span
	WebElement linkReportIssue;

	@FindBy(css="#WWQTTP-shdo")
	WebElement cmbSortingOptions;

	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listInvAccounting;

	// / New works Raw Meterial Issueing
	@FindBy(css="#WWQTTP-shdo")
	WebElement cmbSortingOptionsView;

	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listInvView;

	@FindBy(css="#W1OBKV")
	WebElement txtConsignee1;

	@FindBy(css="#W1OBKV")
	WebElement txtProject1;

	@FindBy(css="div[class='grid-canvas grid-canvas-top grid-canvas-left']>div")
	WebElement gridFirstConsignee1;

	@FindBy(xpath="//a[text()='Related']")
	WebElement linkRelated;

	@FindBy(xpath="//a//*[contains(text(), 'Check Component Availability')]") // a[text()='Report Issue']/span
	WebElement linkReleaseForPicking;

	@FindBy(xpath="//a//*[contains(text(), 'Picking Lists')]") // a[text()='Report Issue']/span
	WebElement linkPickingLists;

	@FindBy(xpath="//a//*[contains(text(), 'Confirm Issues')]")
	WebElement linkConfirmIssues;

	// Elements for last
	@FindBy(xpath="//a//*[contains(text(), 'Delivery Toolbox')]") // a[text()='Report Issue']/span
	WebElement linkDeliveryToolBox;

	@FindBy(css="div[class='grid-canvas grid-canvas-top grid-canvas-left']>div")
	WebElement gridFirstOrder;

	@FindBy(css="div[class='grid-canvas grid-canvas-top grid-canvas-left']>div")
	WebElement gridFirstConsignee12;

	var elementValue = 90;

	def void GoToPMS100() {
		// Wait for Home page loaded
		waitToBeDisplayed(MenuWidgetOptions, 60);
		// Search for MMS0012
		headerMenu.click();
		waitToBeDisplayed(txtSearch);
		txtSearch.click();
		txtSearch.sendKeys("PMS100");
		txtSearch.sendKeys(Keys.ENTER);
	// waitForLoadingComplete();
	}

	def void AddScheduleNOAndProduct() {

		waitForLoadingComplete();

		txtConsignee.click();
		txtConsignee.sendKeys("12");

		txtConsignee.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		gridFirstConsignee.click();

		// rightClick(gridFirstConsignee , true,"Scrap");
		rightClick(gridFirstConsignee, false, "Change");
		// rightClick(gridFirstConsignee);
		// linkRelated.click();
		// linkReportIssue.click();
		Thread.sleep(3000);

//		var InforGrid ig = new InforGrid(gridOIS300);
//		var WebElement tblRow = ig.getCell("CO no", cono);
//		
//		tblRow.click();
	// gridFirstConsignee.sendKeys(Keys.CONTROL + "22"); 
//		Thread.sleep(1000);
//		txtProject.click();
//		txtProject.sendKeys("Y3494");
	}

	def void selectComboValues(String value) {

		waitForLoadingComplete();
		selectFromDropdown(cmbSortingOptions, listInvAccounting, value);
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
	}

	// Search Consignee and mark for picking
	def void MarkRelaseForPicking() {

		waitForLoadingComplete();
		txtConsignee.click();
		txtConsignee.sendKeys("0000018");
		txtConsignee.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		gridFirstConsignee.click();
		rightClick(gridFirstConsignee);
		linkRelated.click();
		linkReleaseForPicking.click();
		waitForLoadingComplete();

	}

	// Add to Picking list
	def void AddToPickingList() {

		txtConsignee.click();
		txtConsignee.sendKeys("0000018");
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

		gridFirstConsignee.click();
		rightClick(gridFirstConsignee);
		linkRelated.click();
		linkPickingLists.click();
		waitForLoadingComplete();
	}

	// Confirm Issues	
	def void ConfirmIssues() {

		gridFirstConsignee.click();
		rightClick(gridFirstConsignee);
		linkRelated.click();
		linkConfirmIssues.click();
		waitForLoadingComplete();
	}

	// Release for picking and confirm
	def void ReleaseForPicking() {

		// Confirmation for 90 status
		Assert.assertEquals(elementValue, "90", "Error");

	}

	// Navigate to PMS70
	def void GoTopms70() {
		// Wait for Home page loaded
		waitToBeDisplayed(MenuWidgetOptions, 60);
		// Search for MMS0012
		headerMenu.click();
		waitToBeDisplayed(txtSearch);
		txtSearch.click();
		txtSearch.sendKeys("pms70");
		txtSearch.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}

	// 3 rd video process starts
	// Navigate to PMS100 
	def void GoTopms100() {
		// Wait for Home page loaded
		waitToBeDisplayed(MenuWidgetOptions, 60);
		// Search for MMS0012
		headerMenu.click();
		waitToBeDisplayed(txtSearch);
		txtSearch.click();
		txtSearch.sendKeys("pms100");
		txtSearch.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}

	var scheduleNo = 1;

	// Navigate to Delivery tooblox
	def void NavigateToDeliveryToolBox() {

		waitForLoadingComplete();
		gridFirstOrder.click();
		rightClick(gridFirstOrder);
		linkRelated.click();
		linkDeliveryToolBox.click();
		waitForLoadingComplete();

	}

	// Navigate to Release for picking
	def void NavigateToRelseForPicking() {

		gridFirstOrder.click();
		rightClick(gridFirstOrder);
		linkRelated.click();
		linkDeliveryToolBox.click();
		waitForLoadingComplete();

	}

	def void NavigateToPickingLists() {
	}

	def void ConfirmIssuesForRelease() {
	}

	var pisValue = 90;

	def void ConfirmPIS90() {

		// Confirmation for 90 status
		Assert.assertEquals(elementValue, "90", "PIS Value Confirmed");
	}

}
