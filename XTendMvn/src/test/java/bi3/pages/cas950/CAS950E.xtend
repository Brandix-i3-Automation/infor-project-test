package bi3.pages.cas950

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class CAS950E extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(xpath=".//*[@id='WFTRDT']")
	WebElement txtFromDate

	@FindBy(xpath=".//*[@id='WTTRDT']")
	WebElement txtToDate

	@FindBy(xpath=".//*[@id='WWMITT']")
	WebElement chBoxStockTrans;

	@FindBy(xpath=".//*[@id='WWMWOP']")
	WebElement chBoxOpTransMo;

	@FindBy(xpath=".//*[@id='WWCRAC']")
	WebElement chBoxOtherTrans;

	@FindBy(xpath=".//*[@id='WWMMOP']")
	WebElement chBoxOpTransWo;

	@FindBy(xpath=".//*[@id='WWCPOC']")
	WebElement chBoxOrderCosting;

	@FindBy(id="Next")
	WebElement btnNext

	@FindBy(id="WWDIVI")
	WebElement txtDivision

	def void selectFromDate(String fromDate) {
		waitForLoadingComplete();
		txtFromDate.click();
		clearRobustly(txtFromDate)
		txtFromDate.sendKeys(fromDate);
	}

	def void selectToDate(String toDate) {
		waitForLoadingComplete();
		txtToDate.click();
		clearRobustly(txtToDate)
		txtToDate.sendKeys(toDate);
	}

	def checkStockTrance() {
		waitForLoadingComplete();
		chBoxStockTrans.click();

	}

	def checkOpTranceMo() {
		waitForLoadingComplete();
		chBoxOpTransMo.click();

	}

	def checkOtherTrance() {
		waitForLoadingComplete();
		chBoxOtherTrans.click();

	}

	def checkOpTranceWo() {
		waitForLoadingComplete();
		chBoxOpTransWo.click();

	}

	def checkOrderCosting() {
		waitForLoadingComplete();
		chBoxOrderCosting.click();

	}

	def void Next() {
		waitToBeClickable(btnNext)
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void FillDivision(String Division){
		waitForLoadingComplete();
		txtDivision.sendKeys(Division);
	}
}























