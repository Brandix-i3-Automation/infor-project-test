package bi3.pages.ois390

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class OIS391E extends BasePage{
	
		new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(css="#WWREQ1")
	WebElement txtReturnedQty;
	
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement firstGridCell;
	
	
	def SelectFirstRows() {
		waitForLoadingComplete();
		firstGridCell.click();
		waitForLoadingComplete();

	}
	
	
	def void enterReturnedQty(String returnedQty) {
		txtReturnedQty.click();
		txtReturnedQty.clearRobustly();
		txtReturnedQty.sendKeys(returnedQty);
	// warehouse.sendKeys(Keys.ENTER);
	}
	
	def void clickNext() {
		waitToBeClickable(btnNext)
		btnNext.click()
		waitForLoadingComplete()
	}
	

	
}