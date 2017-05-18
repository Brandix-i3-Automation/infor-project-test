package bi3.pages.ois145

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import bi3.pages.ToolbarPage

class OIS145E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	def void Update(){
		var toolbar = new ToolbarPage(driver)
		toolbar.ClickAction_Update()
		waitForLoadingComplete()
	}
	
}