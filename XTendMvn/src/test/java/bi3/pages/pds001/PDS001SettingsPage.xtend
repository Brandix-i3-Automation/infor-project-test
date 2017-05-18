package bi3.pages.pds001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List

class PDS001SettingsPage extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(id="WWUPDV-shdo")
	WebElement cmbBoxUpdateItems;
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listUpdateItems;
	
	@FindBy(id="WWSHVP")
	WebElement chkBoxDisplayProductVariants;
	
	
	def void clickNext(){
		btnNext.waitToBeClickable();
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void selectUpdateItems(String option){
		waitForLoadingComplete();
		selectFromDropdown(cmbBoxUpdateItems,listUpdateItems,option);
	}
	
	def void selectDisplayProductVariants(){
		if(!chkBoxDisplayProductVariants.isSelected){
			chkBoxDisplayProductVariants.click();
			waitForLoadingComplete();
		}
		
	}
	
}