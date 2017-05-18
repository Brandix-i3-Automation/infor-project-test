package bi3.pages.ois100

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.apache.commons.lang3.NotImplementedException
import java.util.concurrent.TimeUnit

class OIS100G extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(id="OACUOR")
	WebElement txtCustomerOrd;

	@FindBy(id="Next")
	WebElement btnNext;

	@FindBy(id="dbtnok")
	WebElement btnOk;

	def void clickNext() {
		btnNext.click()
		waitForLoadingComplete()
	}

	def void fillCustomerOrd(String CustomerOrd) {
		waitForLoadingComplete();
		txtCustomerOrd.click();
		txtCustomerOrd.clearRobustly();
		txtCustomerOrd.sendKeys(CustomerOrd);
	}

	def void handleWarning() {
		waitForLoadingComplete();
		btnOk.click();
	}

	def void handleAbnormalException() {
		try {
			waitForLoadingComplete();
        	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			while (btnOk.isDisplayed()) {
				btnOk.clickWhenReady();
				waitForLoadingComplete();
			}
		} catch (Exception e) {
		}
		finally{
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);			
		}
	}

}
