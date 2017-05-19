package bi3.pages.ois390

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List

class OIS390SettingPage extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="Next")
	WebElement btnNext;

	@FindBy(css="#WWSPIC-shdo")
	WebElement cmdOpeningPanel;
	
	@FindBy(css="#dropdown-list li")
	List<WebElement> listSortingOrder;
	
	@FindBy(xpath="//*[contains(text(),'Opening panel')]")
	WebElement txtOpeningPanel;
	
		def void clickNext(){
		btnNext.waitToBeClickable();
		btnNext.click()
		waitForLoadingComplete()
	}

	def void selectOpeningPanel(String openingPanelValue){
		waitForLoadingComplete();
		selectFromDropdown(cmdOpeningPanel, listSortingOrder, openingPanelValue);
		waitForAnyText(txtOpeningPanel, 100);
	}
}












