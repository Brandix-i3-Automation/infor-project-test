package bi3.pages.pms230

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class PMS060B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[row='0']>div")
	WebElement firstGridCell;
	
	@FindBy(id="RelatedBtn")
	WebElement btnRealted;
	
	@FindBy(xpath="//*[contains(text(),'Confirmation')]/span")
	WebElement btnConfirmation;
	
	@FindBy(css="#WMSCHN")
	WebElement selectedSchNo;
	
	@FindBy(xpath=".//*[@href='#tabhost_0']/div/div")
	WebElement lblMoReportIssue;
	
	@FindBy(css="#Prev")
	WebElement btnPrev;
	
	
	
	
	def String getSelectedSchNo() {
		waitToBeDisplayed(selectedSchNo)
		return selectedSchNo.GetTextBoxvalue();
	}
	
	def String getlblValue() {
		waitToBeDisplayed(lblMoReportIssue)
		return lblMoReportIssue.text;
	}
	
	
	def SelectAllRows(){
		waitForLoadingComplete();
		firstGridCell.click();
		firstGridCell.SelectAllGridRows();
		
	
	}
	
	def Confirmation(){
	  btnRealted.click();
	  btnConfirmation.click();
	}
	
	def void ClickPrev() {	
		waitForLoadingComplete()
		btnPrev.click();
		waitForLoadingComplete()
	

	}
}











