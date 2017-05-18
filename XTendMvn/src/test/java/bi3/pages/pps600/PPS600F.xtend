package bi3.pages.pps600

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PPS600F extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(id="WRLITX")
	WebElement txtReport;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	def void FillReportText(String PoNumber)
	{
		waitForLoadingComplete();
		txtReport.waitToBeDisplayed();
		txtReport.click();
		txtReport.clearRobustly();
		txtReport.sendKeys(PoNumber);
	}
	
	def void clickNext()
	{
		waitForLoadingComplete()
		btnNext.click()
		waitForLoadingComplete()
	}
}