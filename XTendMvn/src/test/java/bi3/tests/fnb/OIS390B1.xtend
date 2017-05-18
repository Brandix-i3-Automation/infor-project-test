package bi3.tests.fnb

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

	@FindBy(css=".slick-cell.l0.r0")
	WebElement firstGridCell;
	
	@FindBy(css="#W1REPN")
	WebElement txtRecvngNo;
	
	

	def selectFirstRows() {
		waitForLoadingComplete();
		firstGridCell.click();
		waitForLoadingComplete();

	}
	
		def void enterRecvnNo(String recvnNo) {
		txtRecvngNo.clearRobustly();
		txtRecvngNo.sendKeys(recvnNo);
		txtRecvngNo.sendKeys(Keys.ENTER);

	}

}
