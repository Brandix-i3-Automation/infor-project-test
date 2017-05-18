package bi3.pages.pps330

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import org.openqa.selenium.By
import org.testng.Assert

class PPS330B extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="W1PUNO")
	WebElement txtPOSearch
	
	@FindBy(id = "W1WHLO")
	WebElement txtWarehouseSearch
	
	@FindBy(css="div[id*='PPA330BS'][class*='inforDataGrid']") 
 	WebElement gridElement;
 	
 	@FindBy(id="MyCanvasLbl")
 	WebElement linkStart
 	
 	@FindBy(xpath="//a[text()='Add Text to Quicknote...']")
 	WebElement linkRelated
 	
	
	def void searchPONum(String po){
		txtPOSearch.waitToBeClickable()
		txtPOSearch.clearRobustly()
		txtPOSearch.sendKeys(po)
		txtPOSearch.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
	}
	
	def String getRecievingNoOf(String po){
		waitForLoadingComplete()		
		var recNo = ""
		
		var xpath = "//div[contains(@class, 'slick-cell l0')][contains(text(),'"+po+"')]/../div[5]"
		
		var recNos = driver.findElements(By.xpath(xpath))
		
		for(var i=0;i<recNos.size;i++){
			var temp = recNos.get(i)
			if(!temp.text.equals("")){
				recNo = temp.text
			}
		}
		
		if(recNo.equals("")){
			Assert.fail("Recieving number could not be found for "+po+" in PPS330B")
		}

		return recNo	
	}
	
	def boolean checkStatus75ForPO(String po){
		var exists = false;
		
		var xpath = "//div[contains(@class, 'slick-cell l0')][contains(text(),'"+po+"')]/../div[9]"
		
		var stats = driver.findElements(By.xpath(xpath))
		
		for(var i=1;i<stats.size;i++){
			var temp = stats.get(i)
			if((exists==false)&&(temp.text.equals("75"))){
				exists = true
			}
		}
		
		/*if(recNo.equals("")){
			Assert.fail("Recieving number could not be foounf for "+po+" in PPS330B")
		}*/

		return exists
	}
	
	def void searchForPO(String po, String warehouse){
		waitForLoadingComplete()
		txtPOSearch.waitToBeClickable()
		txtPOSearch.clearRobustly()
		txtPOSearch.sendKeys(po)
		
		txtWarehouseSearch.waitToBeClickable()
		txtWarehouseSearch.clearRobustly()
		txtWarehouseSearch.sendKeys(warehouse)
		txtWarehouseSearch.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		
		//retry
		txtWarehouseSearch.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
	}
	
	
	def boolean checkStatusForPO(String po, String status) {
		waitForLoadingComplete()
		var exists = false;

		var xpath = "//div[contains(@class, 'slick-cell l0')][contains(text(),'" + po + "')]/../div[9]"

		var stats = driver.findElements(By.xpath(xpath))

		for (var i = 1; i < stats.size; i++) {
			var temp = stats.get(i)
			if ((exists == false) && (temp.text.equals(status))) {
				temp.click();
				exists = true
			}
		}

		return exists
	}
	
	def void goToStartPage(){
		waitForLoadingComplete();
		waitToBeClickable(linkStart);
		linkStart.click();
		
	}
	
		
	
}