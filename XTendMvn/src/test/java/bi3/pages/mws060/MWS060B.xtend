package bi3.pages.mws060

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid

class MWS060B extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "W2OBKV")
	WebElement txtItemNum
	
	@FindBy(css="slick-cell.l0.r0")
	WebElement firstGridCell
	
	@FindBy(xpath="//a[text()='Related']")
	WebElement linkRelated;
	
	@FindBy(xpath="//a//*[contains(text(), 'Allocation Survey')]") //a[text()='Report Issue']/span
	WebElement linkAllocationSurvey;
	
	@FindBy(css="div[id*='MWA060BS'][class*='inforDataGrid']")
	WebElement inforGrid;
	
	def void enterItemNumber(String item){
		waitToBeClickable(txtItemNum)
		txtItemNum.click()
		txtItemNum.clearRobustly()
		txtItemNum.sendKeys(item)
		txtItemNum.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
	}
	
	def void goToAllocationsurveyOfRowFirstRow(){
		waitToBeClickable(firstGridCell)
		firstGridCell.rightClick()
		waitToBeDisplayed(linkRelated)
		linkRelated.click()
		waitToBeDisplayed(linkAllocationSurvey)
		linkAllocationSurvey.click()
		waitForLoadingComplete()
	}
	
	def String checkStatus(String newRawMaterialNumber)
	{
		waitForLoadingComplete();
		var InforGrid inforGridMWS060B = new InforGrid(inforGrid);
		var row = inforGridMWS060B.getRowContainingTextInColumn(2,newRawMaterialNumber)
		println("WebElement of Row "+row);
		var cells = inforGridMWS060B.getCellsFromRow(row);
		println("Cell List  "+cells);
		var status = cells.get(10).text;
		println("Status is " +status);
		
		return status;
		
	}
}