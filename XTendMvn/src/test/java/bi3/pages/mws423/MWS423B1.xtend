package bi3.pages.mws423

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class MWS423B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div#W1PACTContainer button span")
	WebElement btnnavPackaging;
	
	@FindBy(id="POS")
	WebElement txtPckgng;
	
	@FindBy(id="BTN_L52T24")
	WebElement btnSelect;
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	@FindBy(id="Next")
	WebElement btnDisplay;
	
	def void SelectPackaging(String packgng){
		waitForLoadingComplete();
		waitToBeDisplayed(btnnavPackaging);
		btnnavPackaging.click();
		waitForLoadingComplete();
		waitToBeDisplayed(txtPckgng);
		txtPckgng.sendKeys(packgng);
		txtPckgng.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		gridFirstLine.click();
		btnSelect.click();	
		waitForLoadingComplete();	
	}
	
	def void GoToNext(){
		waitToBeDisplayed(btnDisplay);
		btnDisplay.click();
	}
	
	
	
	
	
	
	
}