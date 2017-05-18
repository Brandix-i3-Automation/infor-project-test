package bi3.pages.dps170

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid

class DPS170B extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="W1OBKV")
	WebElement txtResp;
	
	@FindBy(id="W2OBKV")
	WebElement txtFwh;
	
	@FindBy(id="W3OBKV")
	WebElement txtTwh;
	
	@FindBy(id="W4OBKV")
	WebElement txtItemNumber;
	
	@FindBy(linkText="Related")
	WebElement linkRelated;
	
	@FindBy(xpath=".//a/span[contains(text(),'Release')]")
	WebElement linkPreAllocation;
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	@FindBy(xpath=".//a/span[contains(text(),'Release')]")
	WebElement linkRelease;
	
	@FindBy(css="div[id*='DPA170BS'][class*='inforDataGrid']")
	WebElement gridElementDistrOrder;
	
	
	def void SearchItem(String resp, String fwh, String twh, String itemnumber){
		waitForLoadingComplete()
		waitToBeDisplayed(txtResp);
		txtResp.clearRobustly;
		txtResp.sendKeys(resp);
		txtFwh.clearRobustly;
		txtFwh.sendKeys(fwh);
		txtTwh.clearRobustly();
		txtTwh.sendKeys(twh);
		txtItemNumber.clearRobustly;
		txtItemNumber.sendKeys(itemnumber);
		txtItemNumber.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}
	
	def goToRelatedOption(String option) {
		// distr Order
		waitForLoadingComplete()
		var InforGrid grid = new InforGrid(gridElementDistrOrder);
		var WebElement gridRow = null; 
		if(grid.rowCount > 0){
			gridRow = grid.getRow(0);
			gridRow.click();
			rightClick(gridRow, true, option);
		}
		waitForLoadingComplete();
		print("DOP Released");
	} 

	def releaseDOP() {
		var InforGrid grid = new InforGrid(gridElementDistrOrder);
		var WebElement gridRow = null; 
		if(grid.rowCount > 0){
			gridRow = grid.getRow(0);
			gridRow.click();
			
			
			waitForLoadingComplete();
			gridRow.sendKeys(Keys.CONTROL + "11");
		
		}
		waitForLoadingComplete();
	}

}