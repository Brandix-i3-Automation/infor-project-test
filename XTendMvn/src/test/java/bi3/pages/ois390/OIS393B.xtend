package bi3.pages.ois390

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class OIS393B extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(xpath=".//*[@id='messageBarContent']/span")
	WebElement lblWarning;

	def String getTemporaryOrderValue() {
		waitToBeDisplayed(lblWarning)
		return lblWarning.text;

	}

}
