package bi3.pages.pps310

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List

class PPS310E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(id="WBCAQA")
	WebElement txtApprovedQty;
	
	@FindBy(id="WWRVQA")
	WebElement txtReceivedQty;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(id = "WWQCRA-shdo")
	WebElement btnQIResDropdown
	
	@FindBy(css = "#dropdown-list>li")
	List<WebElement> listQIResOptions
	
	@FindBy(id = "WBRJQA")
	WebElement txtRejQty
	
	@FindBy(id = "WWSCRE")
	WebElement txtRejReason
	
	def void Next()
	{
		btnNext.waitToBeClickable()
		btnNext.click();
		waitForLoadingComplete();
		
	}
	
	def void enterApprovedQty()
	{
		waitForLoadingComplete();
		txtApprovedQty.sendKeys(txtReceivedQty.GetTextBoxvalue());
	}
	
	def void SetQIResult(String res){
		selectFromDropdown(btnQIResDropdown,listQIResOptions,res)
	}
	
	def void EnterRejectedQtyAsRecieved(){
		txtRejQty.waitToBeClickable()
		txtRejQty.click()
		txtRejQty.clearRobustly()
		txtRejQty.sendKeys(txtReceivedQty.GetTextBoxvalue())
	}
	
	def void EnterRejectReason(String rejReasonCode){
		txtRejReason.waitToBeClickable()
		txtRejReason.click()
		txtRejReason.clearRobustly()
		txtRejReason.sendKeys(rejReasonCode)
	}
}