package bi3.pages.pms230

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PMS230S extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="#WFSCHN")
	WebElement txtSchNo;
	
	@FindBy(xpath=".//*[@id='WFSCHNContainer']//span")
	WebElement btnOpenSchNo;
	
	@FindBy(css="div[row='0']")
	WebElement firstGridCell;
	
	@FindBy(id="BTN_L52T24")
	WebElement btnSelect;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	
	
	
	
	def void SelectingScheduleNo(String ScNOs){
		txtSchNo.click();
		txtSchNo.sendKeys(ScNOs);
		//btnOpenSchNo.click();
		waitForLoadingComplete();
		
	}
	
	def void SelectFirstRow() {
		
		firstGridCell.click();

	}
	
	def void PickScheduleNo() {
		btnSelect.click();

	}
	
	def void ClickNext() {
        waitForLoadingComplete()
		btnNext.click()
		waitForLoadingComplete()
	}
}











