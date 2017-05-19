package bi3.tests

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit
import org.openqa.selenium.chrome.ChromeOptions  
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.ie.InternetExplorerDriverService
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeSuite
import bi3.framework.config.ConfigKeys
import org.testng.annotations.AfterMethod

class BaseTest {

	public static WebDriver driver;

	@BeforeSuite (alwaysRun= true)
    def void beforeSuite() {
        ConfigKeys.setProperties();
    }


	@BeforeMethod
	def void BeforeTest() {
		var _BROWSER = ConfigKeys.BROWSER_TYPE.toUpperCase();

		if (_BROWSER == "CHROME") {
			System.setProperty("webdriver.chrome.driver", ConfigKeys.CHROME_DRIVER_PATH);
			var ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
		}
		if (_BROWSER == "IE") {
			System.setProperty("webdriver.ie.driver", ConfigKeys.IE_32_DRIVER_PATH);
			
			var driverService = InternetExplorerDriverService.createDefaultService();
						
			var DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capabilities.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, "60000");
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
			
			driver = new InternetExplorerDriver(capabilities);			
		}
		if (_BROWSER == "FF") {
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
			
	@AfterMethod
	def void AfterTest(){
		//driver.quit();
	}
}
