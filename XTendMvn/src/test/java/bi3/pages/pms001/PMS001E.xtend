package bi3.pages.pms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PMS001E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WWORQA")
	WebElement txtOrderQty
	
	@FindBy(id="WAFIDT")
	WebElement txtFinishDate
	
	@FindBy(id="WASTDT")
	WebElement txtStartDate
	
	@FindBy(id="Next")
	WebElement btnNext
	
	def void setOrderQuantity(String qty)
	{
		waitForLoadingComplete();
		txtOrderQty.click();
		txtOrderQty.clearRobustly();
		txtOrderQty.sendKeys(qty);
	}
	
	def void setFinishDate(String date){
		waitForLoadingComplete();
		txtFinishDate.click();
		txtFinishDate.clearRobustly();
		txtFinishDate.sendKeys(date);
	}
	
	def void setStartDate(String date){
		waitForLoadingComplete();
		txtStartDate.click();
		txtStartDate.clearRobustly();
		txtStartDate.sendKeys(date);
	}
	
	def void clickNext(){
		
		btnNext.click()
		waitForLoadingComplete()
	}
	
}