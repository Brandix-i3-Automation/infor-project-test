package bi3.pages.pps300

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import java.util.List
import bi3.framework.elements.inforelements.InforGrid

class PPS300B extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="XT_0168")
	WebElement btnApply
	
	@FindBy(id="WWPUNO")
	WebElement txtPONum
	
	@FindBy(id="WWQTTP-shdo")
	WebElement cmbSortingOrder;
	
	@FindBy(css="#dropdown-list li")
	List<WebElement> listSortingOrder;
	
	@FindBy(xpath="//a/span[text()='Change']")
 	WebElement linkChange;
 	
 	@FindBy(css="div[id*='PPA300BS'][class*='inforDataGrid']")
 	WebElement inforGrid;
	
	def void enterPONum(String po){
		txtPONum.waitToBeClickable()
		txtPONum.click()
		txtPONum.clearRobustly()
		txtPONum.sendKeys(po)
		txtPONum.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
	}
	
	def void clickApply(){
		waitToBeClickable(btnApply)
		btnApply.click()
		waitForLoadingComplete()
	}
	
	def void setSortingOrder(String value)
	{
		waitForLoadingComplete();
		Thread.sleep(3000)
		selectFromDropdown(cmbSortingOrder, listSortingOrder, value);
	}
	
	def void goToChange()
	{
		waitForLoadingComplete()
		var InforGrid inforGrid = new InforGrid(inforGrid);
		var matchingElement = inforGrid.getRow(0);
		println("WEbELement "+matchingElement)
		matchingElement.rightClick();
		linkChange.clickWhenReady();
		waitForLoadingComplete();
	
	}
}