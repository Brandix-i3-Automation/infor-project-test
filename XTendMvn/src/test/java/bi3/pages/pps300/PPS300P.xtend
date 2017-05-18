/*
 * Settings page of program PPS300
 */

package bi3.pages.pps300

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List

class PPS300P extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "WWSPIC-shdo")
	WebElement btnOpenPanelDropdown
	
	@FindBy(css = "#dropdown-list>li")
	List<WebElement> listPanelOpenOptions
	
	@FindBy(id = "Next")
	WebElement btnNext
	
	def void SelectPanelOpen(String option){
		selectFromDropdown(btnOpenPanelDropdown,listPanelOpenOptions,option)
	}
	
	def void ClickNext(){
		btnNext.waitToBeClickable()
		btnNext.click()
		waitForLoadingComplete()
	}
}