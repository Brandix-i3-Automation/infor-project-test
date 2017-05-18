package bi3.pages.pps220

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid
import java.util.List

class PPS220G1 extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="Prev")
	WebElement btnPrevious
	
	@FindBy(css="div[id*='PPA220GS'][class*='inforDataGrid']") 
 	WebElement gridElement;
 	
 	@FindBy(id="ActionsBtn")
 	WebElement btnAction
 	
 	@FindBy(css="ul[id*='ActionsMenu']>li")
 	List<WebElement> listActions
 	
 	@FindBy(id="WGSORN")
	WebElement txtSupplOrderNo;

	@FindBy(id="WGYRE1")
	WebElement txtYourRef;
 	
 	def String getPONumberOfRow(int rowId){
 		var grid= new InforGrid(gridElement);
 		var po = grid.getDataOfRow(rowId)
 		return po.get(0) 		
 	}
	
	def void goBack(){
		waitToBeClickable(btnPrevious)
		btnPrevious.click()
		waitForLoadingComplete()
	}
	
	def void selectAction(String action){
		waitForLoadingComplete();
		selectFromDropdown(btnAction,listActions,action)
		waitForLoadingComplete();
	}
	
	def void setHeaderDetails(String supplOrderNo, String yourRef) {
		waitForLoadingComplete();
		txtSupplOrderNo.sendKeys(supplOrderNo);
		txtYourRef.sendKeys(yourRef);
		waitForLoadingComplete();
	}	
	
}