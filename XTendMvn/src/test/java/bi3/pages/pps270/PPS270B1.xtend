package bi3.pages.pps270

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid

class PPS270B1 extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(id="WWPUNO")
	WebElement txtPoNumber;
	
	@FindBy(css="button[id*='XT']")
	WebElement btnApply;
	
	@FindBy(xpath="//a/span[text()='Change']")
 	WebElement linkChange;
 	
 	@FindBy(css="div[id*='PPA270BS'][class*='inforDataGrid']")
 	WebElement inforGrid;
	
	def void enterPoNumber(String PoNumber)
	{
		waitForLoadingComplete();
		txtPoNumber.clearRobustly();
		txtPoNumber.sendKeys(PoNumber);
		btnApply.click();
	}
	
	def void goToChange()
	{
		waitForLoadingComplete()
		var InforGrid inforGrid = new InforGrid(inforGrid);
		var matchingElement = inforGrid.getRow(0);
		println("WEbELement "+matchingElement)
		matchingElement.rightClick();
		linkChange.clickWhenReady();
		waitForLoadingComplete();
	
	}
	
	def String checkStatus(String newRawMaterialNumber)
	{
		waitForLoadingComplete();
		var InforGrid inforGridPPS270 = new InforGrid(inforGrid);
		var row = inforGridPPS270.getRowContainingTextInColumn(3,newRawMaterialNumber)
		println("WebElement of Row "+row);
		var cells = inforGridPPS270.getCellsFromRow(row);
		println("Cell List  "+cells);
		var status = cells.get(8).text;
		println("Status is " +status);
		
		return status;
		
	}
}