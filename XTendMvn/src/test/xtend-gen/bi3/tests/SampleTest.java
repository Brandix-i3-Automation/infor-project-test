package bi3.tests;

import bi3.framework.TakeScreenShot;
import bi3.framework.extentReport.ExtentManagerChrome;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class SampleTest {
  public final static String TEXT_TEST_PASS = "Test Case : {} PASSED!";
  
  public final static String TEXT_TEST_FAIL = "Test Case : {} FAILED!";
  
  /**
   * Defining log4j
   */
  private final static Logger logger = LogManager.getLogger(SampleTest.class.getName());
  
  /**
   * Defining Report
   */
  private static ExtentReports extent;
  
  private static ExtentTest parent;
  
  private static ExtentTest child1;
  
  /**
   * Define WebDriver
   */
  private static WebDriver driver;
  
  /**
   * Define className
   */
  public static String className = SampleTest.class.getSimpleName();
  
  /**
   * Declares ExtentReports Configurations here
   * SeleniumWebdriver Specification (Set capabilities of Platform,BrowserName,Version)
   * RemoteWebdriver Specification(new RemoteWebDriver(new URL(NODEURL),capability))
   * Grid Specification
   * 
   * @return
   * 
   * @throws Exception
   */
  @BeforeTest(alwaysRun = true)
  public static void beforeClass() throws IOException {
    SampleTest.extent = ExtentManagerChrome.getReporter(("C:\\Users\\RashadR\\Desktop\\Reports\\Chrome\\" + "chromeFullReport.html"));
    SampleTest.parent = SampleTest.extent.startTest("<b>loginTest in Chrome</b>", "This is loginTest,Create new user & <b>Check whether particular user can login</b>,Once test is excute,Delete the user");
    SampleTest.logger.info("Testcases Started");
  }
  
  /**
   * Call the browser
   * Maximize the window
   * Navigate to URL
   * 
   * 
   * @return
   * 
   * @throws MalformedURLException
   */
  @BeforeMethod(alwaysRun = true)
  public static void beforemethod() throws MalformedURLException {
  }
  
  /**
   * @Test createUser
   * @return
   * 
   * @throws Exception InterruptedException, IOException
   */
  @Test(testName = "Search Google", priority = 1)
  public void googleSearch(final String searchElement, final String screenShotName) throws InterruptedException, IOException {
    SampleTest.child1 = SampleTest.extent.startTest("Search Element", (("Search Element : \" " + searchElement) + " \""));
    SampleTest.logger.info("Test case searchElement started executing");
    SampleTest.child1.log(LogStatus.INFO, 
      "Test case searchElement started executing");
    SampleTest.logger.info("Accessing the Google Page");
    SampleTest.child1.log(LogStatus.INFO, "Accessing the Google Page");
    SampleTest.logger.info("Navigate to Google");
    SampleTest.child1.log(LogStatus.INFO, "Navigate to Google");
    Thread.sleep(5000);
    System.out.println("Start System of Down");
    if (true) {
      Thread.sleep(2000);
      SampleTest.logger.info(SampleTest.TEXT_TEST_PASS, "User is Sucessfully Logged in");
      SampleTest.child1.log(LogStatus.PASS, "<font color=green>User is Sucessfully Logged in<font>");
      TakeScreenShot ts = new TakeScreenShot();
      ts.takeScreenShot(SampleTest.driver, SampleTest.className, "screenshot1");
      String _addScreenCapture = SampleTest.child1.addScreenCapture((("C:\\Users\\RashadR\\Desktop\\Reports\\Chrome\\" + SampleTest.className) + "\\Screenshot1.png"));
      String _plus = ("User is created : " + _addScreenCapture);
      SampleTest.child1.log(LogStatus.PASS, _plus);
      SampleTest.logger.info("Screenshot Taken Successfully!!!!");
      SampleTest.extent.flush();
    } else {
      SampleTest.logger.error(SampleTest.TEXT_TEST_FAIL, "User is NOT Sucessfully Logged in");
      SampleTest.child1.log(LogStatus.FAIL, "<font color=RED>User is NOT Sucessfully Logged in<font>");
      TakeScreenShot ts_1 = new TakeScreenShot();
      ts_1.takeScreenShot(SampleTest.driver, SampleTest.className, "screenshot2");
      String _addScreenCapture_1 = SampleTest.child1.addScreenCapture((("C:\\Users\\RashadR\\Desktop\\Reports\\Chrome\\" + SampleTest.className) + "/screenShotName.png"));
      String _plus_1 = ("User is created : " + _addScreenCapture_1);
      SampleTest.child1.log(LogStatus.FAIL, _plus_1);
      SampleTest.logger.info("Screenshot Taken Successfully!!!!");
      SampleTest.extent.flush();
    }
    SampleTest.extent.endTest(SampleTest.child1);
  }
  
  /**
   * Get the results status of each method
   * 
   * 
   * @param method,result
   * 
   * @throws Exception
   */
  @AfterMethod
  public void aftermethod(final Method method, final ITestResult result) throws MalformedURLException {
    boolean _equals = method.getName().equals("createUser");
    if (_equals) {
      int _status = result.getStatus();
      boolean _equals_1 = (_status == ITestResult.FAILURE);
      if (_equals_1) {
        Throwable _throwable = result.getThrowable();
        String _plus = ("createUser Test failed because " + _throwable);
        SampleTest.child1.log(LogStatus.FAIL, _plus);
        SampleTest.extent.flush();
      } else {
        int _status_1 = result.getStatus();
        boolean _equals_2 = (_status_1 == ITestResult.SKIP);
        if (_equals_2) {
          Throwable _throwable_1 = result.getThrowable();
          String _plus_1 = ("createUser Test skipped because" + _throwable_1);
          SampleTest.child1.log(LogStatus.SKIP, _plus_1);
          SampleTest.extent.flush();
        } else {
          SampleTest.child1.log(LogStatus.PASS, "createUser Test got executed successfully");
          SampleTest.extent.flush();
        }
      }
    }
    SampleTest.driver.quit();
  }
  
  /**
   * Append the child/merge all the child to one parent report
   * Close the driver
   */
  @AfterTest(alwaysRun = true)
  public void extent() {
    SampleTest.logger.info("Test case closed");
    SampleTest.parent.appendChild(SampleTest.child1);
    SampleTest.extent.endTest(SampleTest.parent);
    SampleTest.extent.close();
    SampleTest.driver.quit();
  }
}
