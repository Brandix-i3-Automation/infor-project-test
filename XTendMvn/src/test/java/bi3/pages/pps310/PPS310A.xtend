package bi3.pages.pps310

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class PPS310A extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "WWREPN")
	WebElement txtRecvngNo
	
	@FindBy(id = "WWWHLO")
	WebElement txtWarehouse
	
	@FindBy(id="WWPUNO")
	WebElement txtPONo;
	
	@FindBy(css="div#WWPUNOContainer button.inforTriggerButton.inforBrowseIcon")
	WebElement navPONumber;
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	@FindBy(id="BTN_L52T24")
	WebElement btnSelect;
	@FindBy(id="Next")
	WebElement btnNext;
	
	def void SetRecievingNo(String rcvngNo){
		txtRecvngNo.waitToBeClickable()
		txtRecvngNo.click()
		txtRecvngNo.clearRobustly()
		txtRecvngNo.sendKeys(rcvngNo)
	}
	
	def void SetWarehouse(String warehouse){
		txtWarehouse.waitToBeClickable()
		txtWarehouse.click()
		txtWarehouse.clearRobustly()
		txtWarehouse.sendKeys(warehouse)
	}
	
	def void ClickNext(){
		btnNext.waitToBeClickable()
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void EditDetails(String ponumber){
		waitForLoadingComplete()		
		waitToBeDisplayed(txtWarehouse);
		txtWarehouse.clearRobustly;
		txtWarehouse.sendKeys("002");
		
		waitToBeDisplayed(txtPONo);
		txtPONo.sendKeys(ponumber);
		navPONumber.click();
		waitForLoadingComplete();
		waitToBeDisplayed(gridFirstLine);
		gridFirstLine.click();
		waitForLoadingComplete();
		btnSelect.click();
		waitForLoadingComplete();
	}
	
		def void GoToPPS310E(){
		btnNext.waitToBeClickable;
		btnNext.click();
		btnNext.waitToBeClickable;
		btnNext.click();
	}
	
	def void PressF12(){
		waitForLoadingComplete()		
		txtWarehouse.sendKeys(Keys.F12);
	}
	
	
}