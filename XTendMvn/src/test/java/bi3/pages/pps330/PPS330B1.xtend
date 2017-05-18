package bi3.pages.pps330

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import org.openqa.selenium.By

class PPS330B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="W1PUNO")
	WebElement txtPONumber;
	
	@FindBy(id="W1WHLO")
	WebElement txtWarehouse;
	
	@FindBy(linkText="Start")
	WebElement linkStart;
	
	def void SearchPO(String ponumber){
		waitForLoadingComplete()		
		waitToBeDisplayed(txtPONumber);
		txtPONumber.clearRobustly;
		txtPONumber.sendKeys(ponumber);
		//txtPONumber.sendKeys(Keys.ENTER);
		
		waitToBeDisplayed(txtWarehouse);
		txtWarehouse.clearRobustly;
		txtWarehouse.sendKeys("002");
		txtWarehouse.sendKeys(Keys.ENTER); 
		waitForLoadingComplete();
	}
	
	def void GoToStart(){
		linkStart.click();
	}
	
	def boolean checkStatus65ForPO(String po) {
		waitForLoadingComplete()		
		var exists = false;
		var xpath = "//div[contains(@class, 'slick-cell l0')][contains(text(),'" + po + "')]/../div[9]"
		var stats = driver.findElements(By.xpath(xpath))
		for (var i = 1; i < stats.size; i++) {
			waitToBeDisplayed(stats.get(i));
			var temp = stats.get(i)
			if ((exists == false) && (temp.text.equals("65"))) {
				exists = true
			}
		}
		
		/*if(recNo.equals("")){
			Assert.fail("Receiving number could not be found for "+po+" in PPS330B")
		}*/

		return exists
	}
	
	
	
	
}