package bi3.pages.pms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import com.gargoylesoftware.htmlunit.ElementNotFoundException

class PMS001 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}	
	
	@FindBy(id="WAPRNO")
	WebElement txtProductNo
	
	@FindBy(id="WASTRT")
	WebElement txtStrType
	
	@FindBy(css="button[class='inforIconButton new']")
	WebElement btnAdd
	
	@FindBy(css="div[row='0']>div.l0.r0")
	WebElement firstGridCell
	
	def void setProductNo(String itemNumber){
		waitForLoadingComplete();
		txtProductNo.click();
		txtProductNo.clearRobustly();
		txtProductNo.sendKeys(itemNumber);
	}
	
	def void setStructureType(String strType){
		waitForLoadingComplete();
		txtStrType.click();
		txtStrType.clearRobustly();
		txtStrType.sendKeys(strType);
	}
	
	def void clearStructureType()
	{
		waitForLoadingComplete();
		txtStrType.click();
		txtStrType.clearRobustly();
	}
	
	def void searchForMOWithItemNo(String itemNo){
		clearStructureType()
		setProductNo(itemNo)
		txtProductNo.sendKeys(Keys.ENTER);
		waitForLoadingComplete()
	}
	
	def void clickAddButton(){
		btnAdd.click()
		waitForLoadingComplete()
	}
	
	def String getItemNumberOfFirstRecord(){
		
		try{
			waitToBeDisplayed(firstGridCell)
			var firstGridText = firstGridCell.text			
			return firstGridText
		}
		catch(ElementNotFoundException e)
		{
			e.printStackTrace()
			return "Null";
		}	
		catch(Exception e)	
		{
			e.printStackTrace()
			return "Null";
		}
	}
}