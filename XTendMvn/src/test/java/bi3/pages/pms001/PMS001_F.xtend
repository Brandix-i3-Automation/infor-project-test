package bi3.pages.pms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List
import org.openqa.selenium.Keys

class PMS001_F extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	
	@FindBy(id="WFSCHN") 
	WebElement txtScheduleNo;
	
	@FindBy(id="Next") 
	WebElement btnNext;
	
	@FindBy(css="#WFSCHN +button") 
	WebElement btnScheduleNoLookUp;
	
	@FindBy(id="POS") 
	WebElement txtScheduleNoM3Browse;
	
	
	
	def void EnterScheduleNo(String ScheduleNo){
		
		waitForLoadingComplete();
//		txtScheduleNo.click();
//		clearRobustly(txtScheduleNo);
		txtScheduleNo.sendKeys(ScheduleNo);
		
	}
	
	
	def void clickNext(){
		waitToBeClickable(btnNext)
		btnNext.click();
		waitForLoadingComplete();
	}
	
	def void ClickScheduleNoLookUp(){
		btnScheduleNoLookUp.click();
		waitForLoadingComplete();
	}
	
	def void EnterF4(){
		txtScheduleNoM3Browse.click();
		txtScheduleNoM3Browse.sendKeys(Keys.F4);
		waitForLoadingComplete();
		
	}
	
	
}