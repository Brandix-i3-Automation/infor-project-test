package bi3.tests

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit
import org.testng.annotations.BeforeTest
import org.testng.annotations.AfterTest
import org.openqa.selenium.chrome.ChromeOptions import org.testng.annotations.BeforeMethod
import org.testng.annotations.AfterMethod
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.Capabilities
import com.relevantcodes.extentreports.ExtentReports
import com.relevantcodes.extentreports.ExtentTest
import java.io.IOException
import bi3.framework.extentReport.ExtentManagerChrome
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.testng.ITestResult
import java.lang.reflect.Method
import java.net.MalformedURLException

class BaseTest {
	
	public static WebDriver driver;
	
	   
	@BeforeMethod
	def void BeforeTest(){
		System.setProperty("webdriver.chrome.driver",".\\src\\main\\resources\\driver\\chromedriver.exe");
		var ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		
		driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        
        
        
        
        
//       System.setProperty("webdriver.ie.driver",".\\src\\main\\resources\\driver\\IEDriverServer.exe");
//       driver = new InternetExplorerDriver();
		//driver.get("http://google.lk"); 
//		var InternetExplorerDriver options1 = new InternetExplorerDriver();
//		options1.addArguments("test1");
//		
//		
//		driver = new InternetExplorerDriver();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        return 
//	}
//	
//	def setDriver(InternetExplorerDriver driver, InternetExplorerDriver driver2) {
//		throw new UnsupportedOperationException("TODO: auto-generated method stub")
//	}
	
	
	}		
	@AfterMethod
	def void AfterTest(){
		//driver.quit();
	}
}
