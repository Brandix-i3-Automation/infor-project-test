package bi3.pages.pcs230

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PCS230SettingsPage extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(id="WWDSEQ")
	WebElement txtPanelSequence;
	
	def void clickNext(){
		btnNext.waitToBeClickable();
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void enterPanelSequence(String panelSequence){
		waitForLoadingComplete();
		waitToBeClickable(txtPanelSequence);
		txtPanelSequence.click();
		txtPanelSequence.clearRobustly();
		txtPanelSequence.sendKeys(panelSequence);
	}
	
}