package bi3.pages.mws410

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

class MWS410E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="OQDLIX")
	WebElement txtDeliveryNo
	
	def String getDeliveryNumber(){
		return txtDeliveryNo.text
	}
	
	def void GoToPanel(String panelId){
		var btnPanel = driver.findElement(By.cssSelector("div[class='lawsonPanelSequenceItem'][value='"+panelId+"']"))
		waitToBeClickable(btnPanel)
		btnPanel.click()
		waitForLoadingComplete()
	}
	
}