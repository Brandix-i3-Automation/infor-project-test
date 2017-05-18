package bi3.pages.pms230

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PMS230B1 extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	
	@FindBy(id="ActionsBtn")
	WebElement btnAction;
	
	@FindBy(xpath="//*[contains(text(),'Select')]//span")
	WebElement btnSelect;
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	
	@FindBy(css="div[row='0']")
	WebElement firstGridCell;

	@FindBy(xpath="//a[contains(text(),'Related')]")
	WebElement linkRelated;
	
	@FindBy(xpath="//a/span[contains(text(),'Report Issue')]")
	WebElement linkReportIssue;
	
	@FindBy(xpath="//a/span[contains(text(),'Report Operations')]")
	WebElement linkReportOperations;
	
	
	
	def SelectScheduleNo() {
		btnAction.click();
		btnSelect.click();
		waitForLoadingComplete();
		

	}
	
	def void ClickReportIssue() {
		waitForLoadingComplete();
		rightClick(gridFirstLine);
		waitToBeClickable(linkRelated);
		linkRelated.click();
		linkReportIssue.click();
		waitForLoadingComplete();
	}
	
	
		def void ClickReportOperations() {
		waitForLoadingComplete();
		rightClick(gridFirstLine);
		waitToBeClickable(linkRelated);
		linkRelated.click();
		linkReportOperations.click();
		waitForLoadingComplete();
	}
	
	def void SelectFirstRow() {
		
		firstGridCell.click();

	}
	
}













