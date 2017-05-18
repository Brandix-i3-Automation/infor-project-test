package bi3.pages.ois390

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class OIS390E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(css="#WWRSCD")
	WebElement txtTransReason;
	
		@FindBy(css="#Prev")
	WebElement btnPrev;
	
	def void ClickPrev() {	
		waitForLoadingComplete()
		btnPrev.click();
		waitForLoadingComplete()
		
		}
	
	def void clickNext() {
		waitToBeClickable(btnNext)
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void selectTransReason(String tranceReason) {
		txtTransReason.click();
		txtTransReason.clearRobustly();
		txtTransReason.sendKeys(tranceReason);
	// warehouse.sendKeys(Keys.ENTER);
	}
	
}