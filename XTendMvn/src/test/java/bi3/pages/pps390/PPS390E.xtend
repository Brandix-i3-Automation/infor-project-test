package bi3.pages.pps390

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List

class PPS390E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "WHCLAL-shdo")
	WebElement btnStatusDropdown
	
	@FindBy(css = "#dropdown-list>li")
	List<WebElement> listStatusOptions
	
	@FindBy(id = "Next")
	WebElement btnNext
	
	@FindBy(id = "CHCLAN")
	WebElement txtRtsOrderNo
	
	def void ClickNext(){
		btnNext.waitToBeClickable()
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void SelectStatusAs(String stat){
		selectFromDropdown(btnStatusDropdown,listStatusOptions,stat)
	}
	
	def String GetRtsOrderNo(){
		txtRtsOrderNo.waitToBeClickable()
		return txtRtsOrderNo.GetTextBoxvalue()
	}
	
}