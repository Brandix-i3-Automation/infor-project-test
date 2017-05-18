package bi3.framework.core

import org.openqa.selenium.WebDriver

class DefaultWebDriver {

	public static WebDriver driver;

	def WebDriver getDriver() {
		return this.driver;
	}
}
