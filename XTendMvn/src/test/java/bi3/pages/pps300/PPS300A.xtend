package bi3.pages.pps300

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import org.openqa.selenium.By
import java.util.List

class PPS300A extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "WWPUNO")
	WebElement txtPONum
	
	@FindBy(css = "#pRow6>div:nth-child(2)>div>button")
	WebElement btnPNLILookUp
	
	@FindBy(css = "#pRow6>div:nth-child(3)>div>button")
	WebElement btnPNLSLookUp
	
	@FindBy(id = "POS")
	WebElement txtLookUpPOSearch
	
	@FindBy(css="div[id*='BROWSE_LIST'][class*='inforDataGrid']") 
 	WebElement gridElement;
 	
 	@FindBy(id = "BTN_L52T24")
 	WebElement btnSelect
 	
 	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(id = "WWWHLO")
	WebElement txtWarehouse
	
	@FindBy(id = "WWPNLI")
	WebElement txtPONumTxtBox1
	
	@FindBy(xpath="//div[text()='Purchase Order. Display Lines']")
 	WebElement linkPurchaseOrderDisplayLines
 	
	@FindBy(id="MyCanvasLbl")
 	WebElement linkStart
	
	
	def void setPONum(String po){
		waitForLoadingComplete()
		txtPONum.waitToBeClickable()
		txtPONum.click()
		txtPONum.clearRobustly()
		txtPONum.sendKeys(po)
		waitForLoadingComplete()
	}
	
	def void SetPurchaseOrderLineFromLookUp(String po){
		waitForLoadingComplete()
		btnPNLILookUp.waitToBeClickable()
		btnPNLILookUp.click()
		waitForLoadingComplete()
		txtLookUpPOSearch.waitToBeClickable()
		txtLookUpPOSearch.click()
		txtLookUpPOSearch.clearRobustly()
		txtLookUpPOSearch.sendKeys(po)
		txtLookUpPOSearch.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		var grid = new InforGrid(gridElement)
		var row = grid.getRow(0)
		row.waitToBeClickable()
		row.click()
		btnSelect.waitToBeClickable()
		btnSelect.click()
		waitForLoadingComplete()
	}
	
	def void SetPurchaseOrderLineSubNumFromLookUp(String po){
		waitForLoadingComplete()		
		btnPNLSLookUp.waitToBeClickable()
		btnPNLSLookUp.click()
		waitForLoadingComplete()
		txtLookUpPOSearch.waitToBeClickable()
		txtLookUpPOSearch.click()
		txtLookUpPOSearch.clearRobustly()
		txtLookUpPOSearch.sendKeys(po)
		txtLookUpPOSearch.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		var grid = new InforGrid(gridElement)
		var row = grid.getRow(0)
		row.waitToBeClickable()
		row.click()
		btnSelect.waitToBeClickable()
		btnSelect.click()
		waitForLoadingComplete()
	}
	
	def void setWarehouse(String warehouse){
		txtWarehouse.waitToBeClickable()
		txtWarehouse.click()
		txtWarehouse.clearRobustly()
		txtWarehouse.sendKeys(warehouse)
	}
	
	def void ClickNext(){
		waitToBeDisplayed(btnNext)
		btnNext.waitToBeClickable()
		btnNext.click()
		waitForLoadingComplete()
	}
	
	
	def void fillPOtxtBox1(String POno){
		waitForLoadingComplete();
		waitToBeClickable(txtPONumTxtBox1);
		txtPONumTxtBox1.click();
		
		txtPONumTxtBox1.clearRobustly();
		txtPONumTxtBox1.sendKeys(POno);
			
	}
	
	def void GoToPurchaseOrderDisplayLines(){
		waitForLoadingComplete();
		waitToBeClickable(linkPurchaseOrderDisplayLines);
		linkPurchaseOrderDisplayLines.click();
	}
	
//	def void clickNextOfActiveTab(){
//		waitForLoadingComplete();
//		var List<WebElement> nextList = driver.findElements(By.id("Next"))
//		var activeNext = nextList.get(1);
//		
//		waitToBeClickable(activeNext);
//		activeNext.click();
//	
//		
//	}

	def void goToStartPage(){
		waitForLoadingComplete();
		waitToBeClickable(linkStart);
		linkStart.click();
		
	}
	
}