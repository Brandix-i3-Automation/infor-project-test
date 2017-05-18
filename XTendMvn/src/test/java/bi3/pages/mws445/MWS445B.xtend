package bi3.pages.mws445

import bi3.pages.BasePage


import org.openqa.selenium.WebDriver
import bi3.pages.ToolbarPage

class MWS445B extends BasePage{
	
	ToolbarPage toolbarPage
	
	new(WebDriver driver) {
		super(driver)
		toolbarPage = new ToolbarPage(driver)
	}
	
	def void ConfirmAll(){
		waitForLoadingComplete()		
		toolbarPage.ClickAction_ConfirmAll()
	}
}