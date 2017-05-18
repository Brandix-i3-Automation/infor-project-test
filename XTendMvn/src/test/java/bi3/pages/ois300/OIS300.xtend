package bi3.pages.ois300

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import java.util.List
import bi3.framework.elements.inforelements.InforGrid

class OIS300 extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id = "W1OBKV")
	WebElement txtCONumber;
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement FirstCell;
	
	@FindBy(linkText = "Related")
	WebElement linkRelated;
	
	@FindBy(xpath="//a/span[contains(text(),'Order lines')]")
	WebElement linkOrderLines;
	
	@FindBy(xpath="//a/span[contains(text(),'Delivery Toolbox')]")
	WebElement linkDeliveryToolbox;
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	@FindBy(id="WWQTTP-shdo")
	WebElement cmbSortingOrder;
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listSortingOrder;
	
	@FindBy(id="W4OBKV")
	WebElement txtCoNumber_fnb
	
	
	@FindBy(css="div[id*='OIA300BS'][class*='inforDataGrid']")
	WebElement popInforGrid;
	
	def void searchCONumber(String CONumber)
	{
		waitForLoadingComplete();
		txtCONumber.click();
		txtCONumber.clearRobustly();
		
		txtCONumber.waitToBeDisplayed();
		txtCONumber.sendKeys(CONumber);
		txtCONumber.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		
	}
	
	def void searchCONumber_fnb(String CONumber)
	{
		waitForLoadingComplete();
		
	
		txtCoNumber_fnb.click();
		txtCoNumber_fnb.clearRobustly();
		
		txtCoNumber_fnb.waitToBeDisplayed();
		txtCoNumber_fnb.sendKeys(CONumber);
		txtCoNumber_fnb.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}
	def void goToOrderLines()
	{
		waitForLoadingComplete();
//		var InforGrid inforGrid = new InforGrid(popInforGrid);
//		Thread.sleep(3000);
//		var matchingCell = inforGrid.getCell("CO no",coNumber);
		rightClick(gridFirstLine);
		//matchingCell.rightClick();
		waitToBeClickable(linkRelated);
		linkRelated.click();
		
		waitToBeClickable(linkOrderLines);
		linkOrderLines.click();
		
		waitForLoadingComplete();
	}
	
	def void setSortingOrder(String value)
	{
		waitForLoadingComplete();
		Thread.sleep(3000)
		selectFromDropdown(cmbSortingOrder, listSortingOrder, value);
	}
	
	def void goToDeliveryToolbox()
	{
		waitForLoadingComplete();
		rightClick(gridFirstLine);
		
		waitToBeClickable(linkRelated);
		linkRelated.click();
		
		waitToBeClickable(linkDeliveryToolbox);
		linkDeliveryToolbox.click();
		
		waitForLoadingComplete();
	}
}