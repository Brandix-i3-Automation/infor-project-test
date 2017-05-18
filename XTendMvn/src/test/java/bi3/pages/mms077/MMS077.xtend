package bi3.pages.mms077
import org.openqa.selenium.WebDriver

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys
import bi3.pages.BasePage
import java.util.List
class MMS077 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(id="WWSTYN")
	WebElement txtStyle;
	
	@FindBy(css="div[panelname='MMA077BC'] #XT_0168")
	WebElement btnApply;
	
	@FindBy(id ="X__6204")
	WebElement btnCreate;
	
	@FindBy(css="div[panelname='MMA077BC'] span[class='errorMessage inforLabel noColon']")
	WebElement lblErrorMessage;
	
	def CreateItemsByMatrix(String itemNumber)
	{
		waitForLoadingComplete();
		waitToBeClickable(txtStyle);
		txtStyle.clear();
		txtStyle.sendKeys(itemNumber);
		txtStyle.pressEnterKey();
		waitForLoadingComplete();
		btnApply.click();
		waitForLoadingComplete();
		btnApply.click();
		waitForLoadingComplete();
		btnCreate.click();
		waitForLoadingComplete();				
	}
	
	def navigateToselectMedia()
	{
		waitForLoadingComplete();						
		txtStyle.sendKeys(Keys.chord(Keys.SHIFT, Keys.F2));
		waitForLoadingComplete();								
	}
	
	def String ConfirmMsg()
	{
		return lblErrorMessage.text.toString();
	}
	
}