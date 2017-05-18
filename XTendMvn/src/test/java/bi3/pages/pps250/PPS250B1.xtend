package bi3.pages.pps250

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid

class PPS250B1 extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WWPUNO")
	WebElement txtPoNumber;
	
	@FindBy(css="button[id*='XT']")
	WebElement btnApply;
	
	@FindBy(xpath="//a[text()='Related']")
 	WebElement linkRelated
	
	@FindBy(xpath="//a/span[text()='Confirmation']")
	WebElement linkConfirmation;
	
	@FindBy(css="div[id*='PPA250BS'][class*='inforDataGrid']")
	WebElement inforGrid;
	def void enterPoNumber(String PoNumber)
	{
		waitForLoadingComplete();
		txtPoNumber.clearRobustly();
		txtPoNumber.sendKeys(PoNumber);
		btnApply.click();
	}
	
	def void clickConfirmation(String newRawMaterialNumber)
	{
		waitForLoadingComplete();
		var InforGrid inforGridPPS250 = new InforGrid(inforGrid);
		var matchingElement = inforGridPPS250.getRowContainingTextInColumn(3, newRawMaterialNumber);
		println("WEbELement "+matchingElement)
		matchingElement.rightClick();
		linkRelated.clickWhenReady();
		linkConfirmation.waitToBeClickable();
		linkConfirmation.click();
		
	}
	
	def String checkStatus(String newRawMaterialNumber)
	{
		waitForLoadingComplete();
		var InforGrid inforGridPPS250 = new InforGrid(inforGrid);
		var row = inforGridPPS250.getRowContainingTextInColumn(3,newRawMaterialNumber)
		println("WebElement of Row "+row);
		var cells = inforGridPPS250.getCellsFromRow(row);
		println("Cell List  "+cells);
		var status = cells.get(10).text;
		println("Status is " +status);
		
		return status;
		
	}
}