package bi3.pages.mms121

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid
import java.util.List
import org.openqa.selenium.Keys
import org.openqa.selenium.By.ByCssSelector

class MMS121B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[id*='MMA121BS'][class*='inforDataGrid']")
	WebElement gridAllocated;
	
	def void AddAllocatedQty(){
		waitForLoadingComplete()
		var InforGrid grid = new InforGrid(gridAllocated);
		var List<WebElement> cellList =  grid.getCellsFromRow(0);
		var WebElement c = cellList.get(8);
		c.waitToBeClickable()
		c.click()
		
		var editableCell = driver.findElement(ByCssSelector.cssSelector("#R1C9"))
		editableCell.click()
		editableCell.clearRobustly()
		editableCell.sendKeys("+");
		editableCell.sendKeys(Keys.ENTER);
		waitForLoadingComplete()
	}




	
	
}