package bi3.pages.pps320

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List

class PPS320P extends BasePage {
	
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