package bi3.pages.ois101

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import java.util.List

class OIS101SettingsPage extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(id="WWDSEQ")
	WebElement txtPanelSequence;
	
	@FindBy(id="WWDTFM-shdo")
	WebElement cmbBoxDateFormat;
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listDateFormat;
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listFullScreenOpt;
	
	@FindBy(id="WWSIMU")
	WebElement chkBoxPriceSimulatn;
	
	@FindBy(id="WWXO73")
	WebElement txtSearchSeqAli;
	
	@FindBy(id="WWXMAT-shdo")
	WebElement cmbBoxFullScreenOpt;
	
	
	def void clickNext(){
		btnNext.waitToBeClickable();
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void enterPanelSequence(String panelSequence){
		waitForLoadingComplete();
		waitToBeClickable(txtPanelSequence);
		txtPanelSequence.click();
		txtPanelSequence.clearRobustly();
		txtPanelSequence.sendKeys(panelSequence);
		
	}
	
	def void selectDateFormat(String optionDate){
		waitForLoadingComplete();
		selectFromDropdown(cmbBoxDateFormat,listDateFormat,optionDate);
	}
	
	def void unselectCheckboxPriceSimulatn(){
		if(chkBoxPriceSimulatn.selected){
			chkBoxPriceSimulatn.click();
			waitForLoadingComplete();
		}
	}
	
	def void selectFullScreenOpt(String optionScreenOpt){
		waitForLoadingComplete();
		selectFromDropdown(cmbBoxFullScreenOpt,listFullScreenOpt,optionScreenOpt);
	}
	
	def void enterSearchSeqAli(String valueSeqAli){
		waitForLoadingComplete();
		waitToBeClickable(txtSearchSeqAli);
		txtSearchSeqAli.click();
		txtSearchSeqAli.clearRobustly();
		txtSearchSeqAli.sendKeys(valueSeqAli);
		
	}
	
	def void customerOrderOpenLineSettingSetUp(String panelSequence, String optionDate, String optionScreenOpt,String valueSeqAli){
		waitForLoadingComplete();
		enterPanelSequence(panelSequence);
		selectDateFormat(optionDate);
		unselectCheckboxPriceSimulatn();
		selectFullScreenOpt(optionScreenOpt);
		enterSearchSeqAli(valueSeqAli);
		clickNext();
		
		
	}
	
	
}