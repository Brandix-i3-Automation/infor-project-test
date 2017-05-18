package bi3.pages.pps820

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PPS820E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id='WFCLRE')
	WebElement txtOurReferenceFrom;
	
	@FindBy(id='WTCLRE')
	WebElement txtOurReferenceTo;
	
	@FindBy(id='WFCLAN')
	WebElement txtRstOrdNoFrom;
	
	@FindBy(id='WTCLAN')
	WebElement txtRstOrdNoTo;
	
	@FindBy(id='Next')
	WebElement btnNext;
	
	/**
	 * clear from - to textbox references.
	 */
	def clearReference() {
		waitForLoadingComplete();
		clearRobustly(txtOurReferenceFrom);
		clearRobustly(txtOurReferenceTo);
	}
	
	/**
	 * fill the rts order no.
	 */
	def fillRtsOrderNo(String rtsOrderNo) {
		txtRstOrdNoFrom.sendKeys(rtsOrderNo);
		txtRstOrdNoTo.sendKeys(rtsOrderNo);
		btnNext.click();
	}
}