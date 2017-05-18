package bi3.pages.ois390

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys

class OIS390A extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}



	@FindBy(id="Next")
	WebElement btnNext;

	@FindBy(css="#WWWHLO")
	WebElement warehouse;

	@FindBy(css="#WWRORN")
	WebElement refOrderNo;

	@FindBy(xpath="//div[@id='pRow10']/div/label")
	WebElement labelM3InforBox;

	@FindBy(css="#dbtnok")
	WebElement clickOk
	
		@FindBy(css="#Prev")
	WebElement btnPrev;
	
	def void ClickPrev() {	
		waitForLoadingComplete()
		btnPrev.click();
		waitForLoadingComplete()
		
		}

	def void SetPanelSqequence(String wh) {
		warehouse.click();
		warehouse.clearRobustly();
		warehouse.sendKeys("00" + wh);
	// warehouse.sendKeys(Keys.ENTER);
	}

	def void selectCoNumber(String coNumber) {
		waitForLoadingComplete()
		refOrderNo.click();
		refOrderNo.clearRobustly();
		refOrderNo.sendKeys("00" + coNumber);
		waitForLoadingComplete()
	// refOrderNo.sendKeys(Keys.ENTER);
	}

	def void clickNext() {
		waitToBeClickable(btnNext)
		btnNext.click()
		waitForLoadingComplete()
	}

	def String getM3lblValue() {
		waitToBeDisplayed(labelM3InforBox)
		return labelM3InforBox.text;
	}

	def void confirmInfoBox() {
		waitToBeClickable(clickOk)
		clickOk.click()
		waitForLoadingComplete()
	}

}














