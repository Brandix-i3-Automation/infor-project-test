package bi3.pages.Pms

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.pages.BasePage
import java.util.List

class PMS extends BasePage {
	new(WebDriver driver) { // Constructor
		super(driver)
	}

	@FindBy(xpath="//div[@class='gvWidgetHeader']/span[contains(text(),'Menu')]")
	WebElement headerMenu;

	@FindBy(css="input.inforSearchField")
	WebElement txtSearch;

	@FindBy(xpath="//div[@class='gvWidgetHeader']/span[contains(text(),'Menu')]/../..//div[@class='gvFillAbsolute']//li")
	WebElement MenuWidgetOptions;

	@FindBy(id='ActionsBtn')
	WebElement btnActions;

	@FindBy(css="#WDPAVRContainer>button")
	WebElement btnView;

	@FindBy(id="#POS")
	WebElement txtPOS;

	@FindBy(css="a[href='#F13']")
	WebElement btnSettings;

	@FindBy(css="div[id*='BROWSE_LIST'] div.slick-cell.l0.r0")
	WebElement gridFirstLine;

	@FindBy(xpath="//*[contains(text(),'A01SCHSTY')]")
	WebElement gridFirstLineT1;

//	@FindBy(css="div[id*='BROWSE_LIST'] div.slick-cell.l0.r0")
//	WebElement gridFirstLine;
	@FindBy(id="BTN_L52T24")
	WebElement btnSelect;

	@FindBy(id="Next")
	WebElement btnSelect1;

	@FindBy(css="div[class='grid-canvas grid-canvas-top grid-canvas-left']>div")
	WebElement gridFirst;

	@FindBy(xpath="//a[text()='Related']")
	WebElement linkRelated;

	@FindBy(xpath="//a//*[contains(text(), 'Report Issue')]") // a[text()='Report Issue']/span
	WebElement linkReportIssue;

	@FindBy(css="#WMSPMT-shdo")
	WebElement comboSelectIsseMTD;

	@FindBy(css="#WMSPMT-shdo")
	WebElement cmbIssueMtd;

	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listInvAccounting;

	@FindBy(id="#XT_0168")
	WebElement btnApply;

	@FindBy(css="div[class='grid-canvas grid-canvas-top grid-canvas-left']>div")
	WebElement gridFirstManufatOrder;

	@FindBy(xpath="//a//*[contains(text(), 'Confirmation')]") // a[text()='Report Issue']/span
	WebElement linkReportIssue1;

	@FindBy(css="#startDiv")
	WebElement btnStart;

	@FindBy(css="#tabsList > li.ui-tabs-selected.ui-state-active > button")
	WebElement btnClose

	// ===============================================================================

	def void GoToPMS230() {
		// Wait for Home page loaded
		waitToBeDisplayed(MenuWidgetOptions, 60);
		// Search for MMS0012
		headerMenu.click();
		waitToBeDisplayed(txtSearch);
		txtSearch.click();
		txtSearch.sendKeys("PMS230");
		txtSearch.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}

	// Go to Actions Tab
	def void ClickActions() {
		btnActions.waitToBeDisplayed();
		btnActions.click();
		Thread.sleep(2000);
	}

	// Go to settings
	def void GoToSettings() {
		btnSettings.waitToBeDisplayed();
		Thread.sleep(2000);
		btnSettings.click();
	}

	// GO to PopUp View
	def void GoToViewAndCompleActions() {

		// btnSettings.waitToBeDisplayed();	
		btnView.click();
		// System.out.println("Ended");	
		gridFirstLineT1.click();
		Thread.sleep(2000);
		btnSelect.click();
		System.out.println("Ended");

	}

	def void ClickNext() {

		Thread.sleep(1000);
		btnSelect1.click();

	}

	def void setItemsOPtions() {

		waitForLoadingComplete();
		gridFirst.click();
		rightClick(gridFirst);
		Thread.sleep(1000);
		linkRelated.click();
		Thread.sleep(2000);
		linkReportIssue.click();

	// waitToBeClickable(linkItemWarehouse);
	// linkItemWarehouse.click();
	// waitForLoadingComplete();
	}

	def void selectIssueMTDCombo() {

		waitForLoadingComplete();
		comboSelectIsseMTD.click();

	}

	def void SelectInvAccounting(String value) {
		waitForLoadingComplete();
		selectFromDropdown(cmbIssueMtd, listInvAccounting, value);
	}

	def void clickButtonApply() {

		// waitForLoadingComplete();	
		btnApply.click();
	}

	def void realtedConfirmation() {

		gridFirstManufatOrder.click();

		rightClick(gridFirstManufatOrder);

		Thread.sleep(1000);
		linkRelated.click();

		Thread.sleep(2000);
		linkReportIssue1.click();
	}

	def void gotoMain() {

		btnClose.click();
	}

}
