package bi3.pages.pms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class PMS001_E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	//Page elements
	@FindBy(id="WWORQA") 
	WebElement txtOrderQty;
	
	@FindBy(id="WAFIDT") 
	WebElement txtFinishDate;
	
	@FindBy(id="Next") 
	WebElement btnNext;
	
	@FindBy(css="#WAORTY+ button") 
	WebElement btnOrderTypeOpen;
	
	@FindBy(id="pos") 
	WebElement txtOtp;
	
	@FindBy(css="div[row='0'] div.slick-cell.l0.r0.uppercase")
	WebElement firstGridCell
	
	@FindBy(id="BTN_L52T24")
	WebElement btnSelect
	
	
	
	//Page Actions
	def void EnterOrderQty(String Qty){
		waitForLoadingComplete();
		txtOrderQty.click();
		txtOrderQty.sendKeys(Qty);	
	}
	
	def void EnterFinishDate(String finishDate){
		waitForLoadingComplete();
		txtFinishDate.click();
		clearRobustly(txtFinishDate)
		txtFinishDate.sendKeys(finishDate);	
	}
	
	def void clickNext(){
		waitToBeClickable(btnNext)
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void setOrderType(String orderType){
		
		btnOrderTypeOpen.click();
		waitForLoadingComplete()
		txtOtp.click();
		clearRobustly(txtOtp);
		txtOtp.sendKeys(orderType)
		txtOtp.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		System.out.println("First cell content : "+firstGridCell.text)
		
		if(firstGridCell.text==orderType)
		{
			firstGridCell.click();
			btnSelect.click();
		}
		else
		{
			System.out.println("order type "+orderType+" not found");
		}
		waitForLoadingComplete()
	}
	
	
	
	
}