package bi3.pages.ois390

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class OIS390B1 extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(id="Next")
	WebElement btnNext;

	@FindBy(css=".slick-cell.l1.r1")
	WebElement firstGridCell;
	
	@FindBy(css="#W1REPN")
	WebElement txtRecvngNo;
	
	

	def selectFirstRows() {
		waitForLoadingComplete();
		firstGridCell.click();
		waitForLoadingComplete();

	}
	
		def void enterRecvnNo(String recvnNo) {
		waitForLoadingComplete();
		txtRecvngNo.clearRobustly();
		txtRecvngNo.sendKeys(recvnNo);
		txtRecvngNo.sendKeys(Keys.ENTER);
		waitForLoadingComplete();

	}

}
