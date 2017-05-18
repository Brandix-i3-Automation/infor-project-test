package bi3.pages.pps220

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PPS220I1 extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	@FindBy(xpath="//a/span[text()='Change']")
 	WebElement linkChange
 	
	@FindBy(xpath="//a[text()='Confirm Update']")
 	WebElement linkConfirmUpdate
	
	
	def void clickChange(){
		waitForLoadingComplete();
		
		rightClick(gridFirstLine);
		
		waitToBeClickable(linkChange);
		linkChange.click();
	}
	
	def void clickConfirmUpdate(){
		waitForLoadingComplete();
		waitToBeClickable(linkConfirmUpdate);
		linkConfirmUpdate.click();
	}
	
}