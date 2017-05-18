package bi3.pages.pms070

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import org.testng.Assert

class PMS070A extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="#WOSCHN+button")
	WebElement btnSchedNoLookUp
	
	@FindBy(id="POS")
	WebElement txtLookUpSearch
	
	@FindBy(css="div[row='0']>div[class='slick-cell l0 r0']")
	WebElement firstCellLookUpGrid
	
	@FindBy(id="BTN_L52T24")
	WebElement btnSelectLookUpGrid
	
	@FindBy(id="WOPRNO")
	WebElement txtProdNumber
	
	@FindBy(id="WOMFNO")
	WebElement txtMONo
	
	@FindBy(id="Next")
	WebElement btnNext
	
	@FindBy(xpath=".//*[@href='#tabhost_0']/div/div")
	WebElement lblMoOperationReport;
	
	@FindBy(id="WOSCHN")
	WebElement txtSchNo;
	
	
	def void enterScheduleNo(String scheduleNo){
		waitToBeClickable(txtSchNo);
		txtSchNo.click();
		txtSchNo.sendKeys(scheduleNo);
		
	}
	def String getOperationReportlblValue() {
		waitToBeDisplayed(lblMoOperationReport)
		return lblMoOperationReport.text;
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
		Thread.sleep(2000)
		txtMONo.click()
		clearRobustly(txtMONo)
	}
	
	def void Next(){
		waitToBeClickable(btnNext)
		btnNext.click()
		waitForLoadingComplete()
	}	
}