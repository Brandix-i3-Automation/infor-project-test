package bi3.pages.mms001

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import bi3.pages.BasePage

class MMS001ItemFacility extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(xpath="//a/span[contains(text(),'Change')]")
	WebElement linkChange
	
	@FindBy(css=".slick-cell.l1.r1")
	WebElement gridFirstLine;
	
	def void selectChnage()
	{
		waitForLoadingComplete();
		rightClick(gridFirstLine);

		// Change Item
		waitToBeClickable(linkChange);
		linkChange.click()
		
		waitForLoadingComplete();
		
	}
	
}