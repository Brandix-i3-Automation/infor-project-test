package bi3.pages.pps320

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class PPS320A extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "WWREPN")
	WebElement txtRecvngNo
	
	@FindBy(id = "WWWHLO")
	WebElement txtWarehouse
	
	@FindBy(id = "Next")
	WebElement btnNext
	
	@FindBy(id="MyCanvasLbl")
 	WebElement linkStart
 	
 	@FindBy(id="WWRESP")
 	WebElement txtResponsile
	
	
	def void setReceivingNo(String rcvngNo){
		waitForLoadingComplete()
		txtRecvngNo.waitToBeClickable()
		txtRecvngNo.click()
		txtRecvngNo.clearRobustly()
		txtRecvngNo.sendKeys(rcvngNo)
	}
	
	def void setWarehouse(String warehouse){
		waitForLoadingComplete()
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
	
	def void goToStartPage(){
		waitForLoadingComplete();
		waitToBeClickable(linkStart);
		linkStart.click();
		
	}
	
	def void GoToOutputSelectMedia(){
		waitForLoadingComplete()		
		waitToBeClickable(txtResponsile);
		txtResponsile.click();
		waitForLoadingComplete();
		txtResponsile.sendKeys(Keys.F3);
	}
	
	
	
	
}