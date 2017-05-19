package bi3.pages.mms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class MMS001ConnectWarehouse extends BasePage {
	
	new(WebDriver driver) { // Constructor
		super(driver)
	}
	
	@FindBy(css="div[class='tabTitle'][title]")
	WebElement pageTitle;
	
	@FindBy(css=".slick-cell.l1.r1")
	WebElement gridFirstLine;
	
	@FindBy(xpath="//a/span[contains(text(),'Change')]")
	WebElement linkChange;
	
	@FindBy(id="startDiv")
	WebElement btnStart	
	
	@FindBy(css="#tabsList > li.ui-tabs-selected.ui-state-active > button")
	WebElement btnClose
	
	def String getpageTitle(){
		waitForLoadingComplete()
		return pageTitle.text;
	}
	
	def void changeWarehouse(){
		
		waitForLoadingComplete();
		rightClick(gridFirstLine);

		// Copy Item
		waitToBeClickable(linkChange);
		linkChange.click()
		
		waitForLoadingComplete();
	}
	
	def close() {
		btnClose.click()
		System.out.println("Connect Warehouse tab closed")
	}
	
	
}