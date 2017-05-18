package bi3.pages.pps913

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PPS913E extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(id='WFBUYE')
	WebElement txtBuyerFrom;

	@FindBy(id='WTBUYE')
	WebElement txtBuyerTo;

	@FindBy(id='Next')
	WebElement btnNext;

	def void clearBuyer() {
		waitForLoadingComplete();
		txtBuyerFrom.clearRobustly();
		txtBuyerTo.clearRobustly();
	}

	def void Next() {
		btnNext.clickWhenReady();
		waitForLoadingComplete();
	}
	
}
