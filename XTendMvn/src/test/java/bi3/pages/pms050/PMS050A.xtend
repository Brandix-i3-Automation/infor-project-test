package bi3.pages.pms050

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import org.testng.Assert

class PMS050A extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="#WHSCHN+button")
	WebElement btnSchedNoLookUp
	
	@FindBy(id="POS")
	WebElement txtLookUpSearch
	
	@FindBy(css="div[row='0']>div[class='slick-cell l0 r0']")
	WebElement firstCellLookUpGrid
	
	@FindBy(id="BTN_L52T24")
	WebElement btnSelectLookUpGrid
	
	@FindBy(id="WHPRNO")
	WebElement txtProdNumber
	
	@FindBy(id="WHMFNO")
	WebElement txtMONo
	
	@FindBy(id="Next")
	WebElement btnNext
	
	@FindBy(id="WHSCHN")
	WebElement txtSchNo
	
	
	
	@FindBy(xpath=".//*[@class='ui-tabs-selected ui-state-active']//div/div")
	WebElement lblMoReportReceipt;
	
	
	def void EnterScheduleNo(String ScheduleNo){
		waitToBeClickable(txtSchNo);
		txtSchNo.click();
		txtSchNo.sendKeys(ScheduleNo);
	
	}
	
	def String getMoReportReceiptlblValue() {
		waitToBeDisplayed(lblMoReportReceipt)
		return lblMoReportReceipt.text;
	}
	
	def void setSchedNumberFromLookUp(String schedNo){
		waitToBeClickable(btnSchedNoLookUp)
		btnSchedNoLookUp.click()
		waitForLoadingComplete()
		waitToBeClickable(txtLookUpSearch)
		txtLookUpSearch.click()
		clearRobustly(txtLookUpSearch)
		txtLookUpSearch.sendKeys(schedNo)
		txtLookUpSearch.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		if(firstCellLookUpGrid.text.equals(schedNo)){
			firstCellLookUpGrid.click()
			btnSelectLookUpGrid.click()
		}
		else{
			Assert.fail("Schedule Number "+schedNo+" could not be found on the look up grid")
		}
	}
	
	def void clearProductNo(){
		waitToBeClickable(txtProdNumber)
		txtProdNumber.click()
		clearRobustly(txtProdNumber)
	}
	
	def void clearMONumber(){
		waitToBeClickable(txtMONo)
		txtMONo.click()
		clearRobustly(txtMONo)
	}
	
	def void Next(){
		waitToBeClickable(btnNext)
		btnNext.click()
		waitForLoadingComplete()
	}
	
}