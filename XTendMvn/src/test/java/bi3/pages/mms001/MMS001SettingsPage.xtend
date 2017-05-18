package bi3.pages.mms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List

class MMS001SettingsPage extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WWUPIP-shdo")
	WebElement cmbBoxUpdateItems;
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listUpdateItems;
	
	@FindBy(id="WWUPIW")
	WebElement chkBoxUpdateItems;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	
	
	def void selectUpdateItems(String option){
		waitForLoadingComplete();
		selectFromDropdown(cmbBoxUpdateItems,listUpdateItems,option);
	}
	
	def void selectUpdateItemsCheckBox(){
		if(!chkBoxUpdateItems.isSelected){
			chkBoxUpdateItems.click();
			waitForLoadingComplete();
		}
		
	}
	
	def void clickNext(){
		btnNext.waitToBeClickable();
		btnNext.click()
		waitForLoadingComplete()
	}
}