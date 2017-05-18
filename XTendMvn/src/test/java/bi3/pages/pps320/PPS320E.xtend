package bi3.pages.pps320

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid
import org.testng.Assert
import org.openqa.selenium.Keys

class PPS320E extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(id="WWCAQA")
	WebElement txtApprovedQty;
	
	@FindBy(id = "WWRVQA")
	WebElement txtRecvdQty
	
	@FindBy(id="WBRPQA")
	WebElement txtStoredQty;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(css = "#pRow18>div:nth-child(1)>div>button")
	WebElement btnLocationLookUp
	
	@FindBy(id = "POS")
	WebElement txtLookUpSearch
	
	@FindBy(css="div[id*='BROWSE_LIST'][class*='inforDataGrid']") 
 	WebElement gridElement;
 	
 	@FindBy(id = "BTN_L52T24")
 	WebElement btnSelect
 	
 	@FindBy(id = "WLWHSL")
 	WebElement txtLocation
	
	def void enterStoredQty()
	{
		waitForLoadingComplete();
		txtStoredQty.sendKeys(txtApprovedQty.GetTextBoxvalue());
	}
	
	def void Next()
	{
		btnNext.waitToBeClickable()
		btnNext.click();
		waitForLoadingComplete();
	}
	
	def void SetLocationFromText(String location){
		waitForLoadingComplete()		
		txtLocation.waitToBeClickable()
		txtLocation.click()
		txtLocation.clearRobustly()
		txtLocation.sendKeys(location)
	}
	
	def void SetLocationFromLookUp(String location){
		waitForLoadingComplete()		
		btnLocationLookUp.waitToBeClickable()
		btnLocationLookUp.click()
		waitForLoadingComplete()
		
		txtLookUpSearch.waitToBeClickable()
		txtLookUpSearch.click()
		txtLookUpSearch.clearRobustly()
		txtLookUpSearch.sendKeys(location)
		txtLookUpSearch.sendKeys(Keys.ENTER)
		
		var grid = new InforGrid(gridElement)
		var row = grid.getCellsFromRow(0)
		
		if(row.get(0).text.equals(location)){
			row.get(0).waitToBeDisplayed()
			row.get(0).waitToBeClickable()
			row.get(0).click()
			btnSelect.click()
			waitForLoadingComplete()
		}else{
			System.out.println("Location look up first cell :"+row.get(0).text+" not equal to "+location)
			Assert.fail("Location "+location+" was not found in PPS320E location lookup")
		}
	}
	
	def void EnterStoredQtyAsRecieved(){
		waitForLoadingComplete();
		txtStoredQty.sendKeys(txtRecvdQty.GetTextBoxvalue());
	}
}