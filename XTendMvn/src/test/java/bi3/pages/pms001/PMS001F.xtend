package bi3.pages.pms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class PMS001F extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="input[id='WFSCHN'] + button")
	WebElement btnScheduleNumberLookUp
	
	@FindBy(id="POS")
	WebElement txtSchedNo
	
	@FindBy(css="div[row='0']>div[class='slick-cell l0 r0']")
	WebElement firstGridCell
	
	@FindBy(id="BTN_L52T24")
	WebElement btnSelect
	
	@FindBy(id="Next")
	WebElement btnNext
	
	def void selectSchedNoFromLookUp(String schedNo){
		waitToBeDisplayed(btnScheduleNumberLookUp)
		waitToBeClickable(btnScheduleNumberLookUp)
		btnScheduleNumberLookUp.click();
		
		waitForLoadingComplete()
		txtSchedNo.click();
		txtSchedNo.clearRobustly();
		txtSchedNo.sendKeys(schedNo)
		txtSchedNo.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		if(firstGridCell.text==schedNo)
		{
			firstGridCell.click();
			btnSelect.click();
		}
		else
		{
			System.out.println("Operation ID "+schedNo+" not found");
		}
		waitForLoadingComplete()
	}
	
	def void clickNext(){
		
		btnNext.click()
		waitForLoadingComplete()
	}
}