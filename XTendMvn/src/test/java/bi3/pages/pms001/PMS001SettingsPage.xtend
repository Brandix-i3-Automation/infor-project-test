package bi3.pages.pms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List
import org.testng.annotations.Test

class PMS001SettingsPage extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WWXCRM-shdo")
	WebElement cmbBoxFullScrOption;
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listFullScrOption;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	
	
	
	
	def void selectFullScrOption(String option){
		waitForLoadingComplete();
		selectFromDropdown(cmbBoxFullScrOption,listFullScrOption,option);
	}
	
	def void clickNext(){
		btnNext.waitToBeClickable();
		btnNext.click()
		waitForLoadingComplete()
	}
	
	
	
}