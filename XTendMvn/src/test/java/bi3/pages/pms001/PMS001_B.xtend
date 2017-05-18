package bi3.pages.pms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid

class PMS001_B extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	//Page elements
	@FindBy(id="WAPRNO") 
	WebElement txtProductNo;
	
	@FindBy(css="button.inforIconButton.new") 
	WebElement btnCreate;
	
	@FindBy(css="div[id*='PMA001BS'][class*='inforDataGrid']") 
	WebElement gridElementPMA001BS;
	
	//Page actions
	
	def void EnterProductNumber(String productNumber) {
		waitForLoadingComplete();
		txtProductNo.click();
		clearRobustly(txtProductNo);
		
		txtProductNo.sendKeys(productNumber);
		txtProductNo.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}
	
	def void ClickOnCreate() {
		waitToBeClickable(btnCreate);
		btnCreate.click();
		waitForLoadingComplete();
		
	}
	def EnterProductNumInGrid(String productNumber){
		var InforGrid grid= new InforGrid(gridElementPMA001BS);
		grid.setValueToColumnSearchField("Product",productNumber);
		txtProductNo.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		
	}
	
	
}