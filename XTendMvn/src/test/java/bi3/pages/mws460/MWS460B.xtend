package bi3.pages.mws460

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List
import com.gargoylesoftware.htmlunit.ElementNotFoundException
import org.openqa.selenium.ElementNotVisibleException
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid

class MWS460B extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WWQTTP-shdo")
	WebElement btnSortingSelect
	
	@FindBy(css="#dropdown-list>li")
	List<WebElement> listSortingOptions
	
	@FindBy(id="W1OBKV")
	WebElement txtWarehouse
	
	@FindBy(id="W2OBKV")
	WebElement txtItemNumber
	
	@FindBy(css="div[id*='MWA460BS'][class*='inforDataGrid']") 
 	WebElement gridElement;
 	
 	@FindBy(xpath="//a[text()='Related']")
 	WebElement linkRelated
 	
 	@FindBy(xpath="//a/span[text()='Process']")
 	WebElement linkProcess
 	
 	@FindBy(css=".errorMessage.inforLabel.noColon")
 	WebElement lblFooterMessage
 	
 	@FindBy(css=".inforIconButton.refresh")
 	WebElement btnRefresh
	
	def void selectSortingOrder(String sorting){
		selectFromDropdown(btnSortingSelect,listSortingOptions,sorting)
	}
	
	def void setWarehouse(String warehouse){
		try{
			waitToBeClickable(txtWarehouse)
			txtWarehouse.click()
			clearRobustly(txtWarehouse)
			txtWarehouse.sendKeys(warehouse)
			txtWarehouse.sendKeys(Keys.ENTER)
			waitForLoadingComplete()
		}catch(ElementNotFoundException n){
			selectSortingOrder("30-Item,Acquis ord")
			setWarehouse(warehouse)
		}catch(ElementNotVisibleException n){
			selectSortingOrder("30-Item,Acquis ord")
			setWarehouse(warehouse)
		}
	}
	
	def void setItemNumber(String itemNumber){
		try{
			waitToBeClickable(txtItemNumber)
			txtItemNumber.click()
			clearRobustly(txtItemNumber)
			txtItemNumber.sendKeys(itemNumber)
			txtItemNumber.sendKeys(Keys.ENTER)
			waitForLoadingComplete()
		}catch(ElementNotFoundException n){
			selectSortingOrder("30-Item,Acquis ord")
			setItemNumber(itemNumber)
		}catch(ElementNotVisibleException n){
			selectSortingOrder("30-Item,Acquis ord")
			setItemNumber(itemNumber)
		}
	}
	
	def void processGridRow(int recordNum){
		var InforGrid grid= new InforGrid(gridElement);
		var row = grid.getRow(recordNum)
		rightClick(row)
		linkRelated.click()
		linkProcess.click()
		waitForLoadingComplete()		
	}
	
	def String getFooterMessage(){
		return lblFooterMessage.text;
	}
	
	def boolean checkRecordExists(String itemNumber){
		try{
			setItemNumber(itemNumber)
			var InforGrid grid= new InforGrid(gridElement);
			var row = grid.getDataOfRow(0)
			System.out.println("Row 1 item : "+row.get(1))
			if(row.get(1).contains(itemNumber)){
				return true;	
			}else{
				return false;
			}			
		}catch(ElementNotFoundException e){
			return false;
		}
	}
	
	def void refreshPage(int reloadAfterTimeout){
		Thread.sleep(reloadAfterTimeout)
		waitToBeClickable(btnRefresh)
		btnRefresh.click()
		waitForLoadingComplete()
	}
}