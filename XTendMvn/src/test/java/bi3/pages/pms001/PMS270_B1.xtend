package bi3.pages.pms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys

class PMS270_B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="W1SCHN") 
	WebElement txtScheduleNo;
	
	@FindBy(css="button.inforIconButton.new") 
	WebElement btnCreate;
	
	@FindBy(id="Next") 
	WebElement btnNext;

	def void EnterScheduleNo(String ScheduleNo){
				
		txtScheduleNo.click();
		clearRobustly(txtScheduleNo);
		txtScheduleNo.sendKeys(ScheduleNo);
		txtScheduleNo.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		
		
	}
	
	def void ClickOnCreate() {
		waitToBeClickable(btnCreate);
		btnCreate.click();
		waitForLoadingComplete();
		
	}
	
	def void clickNext(){
		waitToBeClickable(btnNext)
		btnNext.click();
		waitForLoadingComplete();
	}
	
	def void EnterF12(){
		txtScheduleNo.click();
		txtScheduleNo.sendKeys(Keys.F12);
		waitForLoadingComplete();
		
	}
}