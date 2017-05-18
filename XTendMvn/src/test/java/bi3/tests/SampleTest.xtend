package bi3.tests

import com.relevantcodes.extentreports.ExtentTest
import org.openqa.selenium.WebDriver
import org.testng.annotations.Test
import org.testng.annotations.AfterMethod
import org.testng.ITestResult
import org.testng.annotations.BeforeTest
import com.relevantcodes.extentreports.ExtentReports
import java.lang.reflect.Method
import java.net.MalformedURLException
import org.openqa.selenium.By
import org.testng.annotations.BeforeMethod
import java.io.IOException
import org.testng.annotations.AfterTest
import org.apache.logging.log4j.Logger
import com.relevantcodes.extentreports.LogStatus
import org.testng.annotations.Parameters

import org.apache.logging.log4j.LogManager
import bi3.framework.extentReport.ExtentManagerChrome
import bi3.framework.SamplePro
import bi3.framework.TakeScreenShot

class SampleTest {
	
	
	val public static final String TEXT_TEST_PASS = "Test Case : {} PASSED!";
	val public static final String TEXT_TEST_FAIL = "Test Case : {} FAILED!";
	
	
	
	
	/**
	 * 
	 * Defining log4j
	 */

	private static final Logger logger = LogManager
			.getLogger(SampleTest.getName());
	
	/**
	 * 
	 * Defining Report
	 */
	static ExtentReports extent;
	static ExtentTest parent;
	static ExtentTest child1;

    
	/**
	 * 
	 * Define WebDriver
	 */

	private static WebDriver driver;	
	
	
	
	/**
	 * 
	 * Define className
	 */

	public static String className = SampleTest
			.getSimpleName();

	
		
		
	
	/**
	 * 
	 * Declares ExtentReports Configurations here 
	 * SeleniumWebdriver Specification (Set capabilities of Platform,BrowserName,Version)
	 * RemoteWebdriver Specification(new RemoteWebDriver(new URL(NODEURL),capability)) 
	 * Grid Specification
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */

	@BeforeTest(alwaysRun=true)
	def public static void beforeClass() throws IOException

	{
		
		extent = ExtentManagerChrome.getReporter("C:\\Users\\RashadR\\Desktop\\Reports\\Chrome\\"+"chromeFullReport.html");
		parent=extent.startTest("<b>loginTest in Chrome</b>","This is loginTest,Create new user & <b>Check whether particular user can login</b>,Once test is excute,Delete the user");
		logger.info("Testcases Started");
		
		
	}
	
	/**
	 * 
	 * Call the browser
	 * Maximize the window
	 * Navigate to URL
	 * 
	 * 
	 * @return
	 * 
	 * @throws MalformedURLException
	 */
	
	@BeforeMethod(alwaysRun=true)
	def public static void beforemethod() throws MalformedURLException{
				
				
				
	}
	
	/**
	 * 
	 * @Test createUser	 
	 * @return
	 * 
	 * @throws Exception InterruptedException, IOException
	 */

	
	@Test(testName = "Search Google",priority = 1)
	def public void googleSearch(String searchElement, String screenShotName) throws InterruptedException, IOException

	{

		
		//parent=extent.startTest("Login in Chrome");
		//Extent Report Start Configuration(testCaseName,Definition of testCase)
		 child1 = extent.startTest("Search Element","Search Element : \" "+searchElement+" \"");
		
		logger.info("Test case searchElement started executing");
		child1.log(LogStatus.INFO,
				"Test case searchElement started executing");		

		logger.info("Accessing the Google Page");
        child1.log(LogStatus.INFO, "Accessing the Google Page");        
               	 		         
        logger.info("Navigate to Google");
        child1.log(LogStatus.INFO, "Navigate to Google"); 
       // extent.flush();
        
//                TakeScreenShot ts=new TakeScreenShot();
//     	   	ts.takeScreenShot(driver,className, screenShotName+"1");
//     	   	child1.log(LogStatus.INFO, "User is alredy created : " +child1.addScreenCapture("./"+className+"/"+screenShotName+"1"+".png"));
//     	   	logger.info("Screenshot Taken Successfully!!!!");  
//            extent.flush();   
            
            Thread.sleep(5000);
            
         
            
   	   
   	    System.out.println("Start System of Down")
   	    
   	    
   	
	if (true){
			
			Thread.sleep(2000);
			logger.info(TEXT_TEST_PASS,"User is Sucessfully Logged in");
			child1.log(LogStatus.PASS, "<font color=green>User is Sucessfully Logged in<font>");
			
		var TakeScreenShot ts=new TakeScreenShot();
  	   	//ts.takeScreenShot(driver,className, screenShotName+"3");
  	   	ts.takeScreenShot(driver,className, "screenshot1" )
  	   	child1.log(LogStatus.PASS, "User is created : " +child1.addScreenCapture("C:\\Users\\RashadR\\Desktop\\Reports\\Chrome\\"+className+"\\Screenshot1.png"));
  	   	logger.info("Screenshot Taken Successfully!!!!");  
         extent.flush(); 
		}else{
			
			
			logger.error(TEXT_TEST_FAIL,"User is NOT Sucessfully Logged in");
			child1.log(LogStatus.FAIL, "<font color=RED>User is NOT Sucessfully Logged in<font>");
			
		var	TakeScreenShot ts=new TakeScreenShot();
  	   	ts.takeScreenShot(driver,className, "screenshot2");
  	   	child1.log(LogStatus.FAIL, "User is created : " +child1.addScreenCapture("C:\\Users\\RashadR\\Desktop\\Reports\\Chrome\\"+className+"/screenShotName.png"));
  	   	logger.info("Screenshot Taken Successfully!!!!");  
         extent.flush();   
			
		}
		
		
			 
   	    //extent.flush();		
		extent.endTest(child1);
		
   	    
   	 
 }
 
 
   	   
           
        
       

	/**
	 * 
	 * Get the results status of each method
	 * 
	 * 
	 * @param method,result
	 * 
	 * @throws Exception
	 */
	
@AfterMethod
	  def public void aftermethod(Method method,ITestResult result) throws MalformedURLException{
		
		if(method.getName().equals("createUser")) {			
			
			if (result.getStatus() == ITestResult.FAILURE) {
		        child1.log(LogStatus.FAIL,"createUser Test failed because " + result.getThrowable());
		        extent.flush();
		    } else if (result.getStatus() == ITestResult.SKIP) {
		    	child1.log(LogStatus.SKIP, "createUser Test skipped because" + result.getThrowable());
		        extent.flush();
		    } else {
		    	child1.log(LogStatus.PASS, "createUser Test got executed successfully");
		        extent.flush();
		    }
			}
			
		
		driver.quit(); 
		
	   }
   
	
	/**
	 * 
	 * Append the child/merge all the child to one parent report
	 * Close the driver
	 */
	
	@AfterTest(alwaysRun=true)
	def public void extent() {
		
		logger.info("Test case closed");		
		
		parent
		  .appendChild(child1);
		extent.endTest(parent);
		extent.close();	
		driver.quit();
		

	} 
	
	
	
}