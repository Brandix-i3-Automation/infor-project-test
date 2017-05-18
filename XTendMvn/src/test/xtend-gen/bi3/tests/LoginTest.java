package bi3.tests;

import bi3.framework.TakeScreenShot;
import bi3.framework.extentReport.ExtentManagerChrome;
import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.mms001.MMS001;
import bi3.pages.mms001.MMS001C;
import bi3.pages.mms001.MMS001ConnectWarehouse;
import bi3.pages.mms001.MMS001ConnectWarehouseE;
import bi3.pages.mms001.MMS001ConnectWarehouseF;
import bi3.pages.mms001.MMS001ConnectWarehouseG;
import bi3.pages.mms001.MMS001ConnectWarehouseH;
import bi3.pages.mms001.MMS001ConnectWarehouseI;
import bi3.pages.mms001.MMS001E;
import bi3.pages.mms001.MMS001F;
import bi3.pages.mms001.MMS001G;
import bi3.pages.mms001.MMS001H;
import bi3.pages.mms001.MMS001I;
import bi3.pages.mms001.MMS001J;
import bi3.pages.mms001.MMS001K;
import bi3.pages.mms001.MMS001M;
import bi3.pages.mms077.MMS077;
import bi3.pages.mms077.MMS077_SelectMedia;
import bi3.tests.BaseTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class LoginTest extends BaseTest {
  /**
   * Define className
   */
  public static String className = LoginTest.class.getSimpleName();
  
  public final static String TEXT_TEST_PASS = "Test Case : {} PASSED!";
  
  public final static String TEXT_TEST_FAIL = "Test Case : {} FAILED!";
  
  /**
   * Defining log4j
   */
  private final static Logger logger = LogManager.getLogger(LoginTest.class.getName());
  
  /**
   * Defining Report
   */
  private static ExtentReports extent;
  
  private static ExtentTest parent;
  
  private static ExtentTest child1;
  
  private static ExtentTest child2;
  
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private MMS001 mms001;
  
  private MMS001C mms001C;
  
  private MMS001E mms001E;
  
  private MMS001F mms001F;
  
  private MMS001G mms001G;
  
  private MMS001H mms001H;
  
  private MMS001I mms001I;
  
  private MMS001J mms001J;
  
  private MMS001K mms001K;
  
  private MMS001M mms001M;
  
  private MMS001ConnectWarehouse mms001ConnectWarehouse;
  
  private MMS001ConnectWarehouseE connectWarehouseE;
  
  private MMS001ConnectWarehouseF connectWarehouseF;
  
  private MMS001ConnectWarehouseG connectWarehouseG;
  
  private MMS001ConnectWarehouseH connectWarehouseH;
  
  private MMS001ConnectWarehouseI connectWarehouseI;
  
  private MMS077 mms077;
  
  private MMS077_SelectMedia mms077_SelectMedia;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    MMS001 _mMS001 = new MMS001(BaseTest.driver);
    this.mms001 = _mMS001;
    MMS001C _mMS001C = new MMS001C(BaseTest.driver);
    this.mms001C = _mMS001C;
    MMS001E _mMS001E = new MMS001E(BaseTest.driver);
    this.mms001E = _mMS001E;
    MMS001F _mMS001F = new MMS001F(BaseTest.driver);
    this.mms001F = _mMS001F;
    MMS001G _mMS001G = new MMS001G(BaseTest.driver);
    this.mms001G = _mMS001G;
    MMS001H _mMS001H = new MMS001H(BaseTest.driver);
    this.mms001H = _mMS001H;
    MMS001I _mMS001I = new MMS001I(BaseTest.driver);
    this.mms001I = _mMS001I;
    MMS001J _mMS001J = new MMS001J(BaseTest.driver);
    this.mms001J = _mMS001J;
    MMS001K _mMS001K = new MMS001K(BaseTest.driver);
    this.mms001K = _mMS001K;
    MMS001M _mMS001M = new MMS001M(BaseTest.driver);
    this.mms001M = _mMS001M;
    MMS001ConnectWarehouse _mMS001ConnectWarehouse = new MMS001ConnectWarehouse(BaseTest.driver);
    this.mms001ConnectWarehouse = _mMS001ConnectWarehouse;
    MMS001ConnectWarehouseE _mMS001ConnectWarehouseE = new MMS001ConnectWarehouseE(BaseTest.driver);
    this.connectWarehouseE = _mMS001ConnectWarehouseE;
    MMS001ConnectWarehouseF _mMS001ConnectWarehouseF = new MMS001ConnectWarehouseF(BaseTest.driver);
    this.connectWarehouseF = _mMS001ConnectWarehouseF;
    MMS001ConnectWarehouseG _mMS001ConnectWarehouseG = new MMS001ConnectWarehouseG(BaseTest.driver);
    this.connectWarehouseG = _mMS001ConnectWarehouseG;
    MMS001ConnectWarehouseH _mMS001ConnectWarehouseH = new MMS001ConnectWarehouseH(BaseTest.driver);
    this.connectWarehouseH = _mMS001ConnectWarehouseH;
    MMS001ConnectWarehouseI _mMS001ConnectWarehouseI = new MMS001ConnectWarehouseI(BaseTest.driver);
    this.connectWarehouseI = _mMS001ConnectWarehouseI;
    MMS077 _mMS077 = new MMS077(BaseTest.driver);
    this.mms077 = _mMS077;
    MMS077_SelectMedia _mMS077_SelectMedia = new MMS077_SelectMedia(BaseTest.driver);
    this.mms077_SelectMedia = _mMS077_SelectMedia;
  }
  
  @BeforeTest(alwaysRun = true)
  public static void beforeClass() throws IOException {
    ExtentTest _extentTest = new ExtentTest("Login Test", "User1 creation");
    LoginTest.child1 = _extentTest;
    ExtentTest _extentTest_1 = new ExtentTest("Login Test", "User2 creation");
    LoginTest.child2 = _extentTest_1;
    String path = (("C:\\Users\\RashadR\\Desktop\\Reports\\Chrome" + LoginTest.className) + "\\LoginTestzz.html");
    LoginTest.extent = ExtentManagerChrome.getReporter(path);
    LoginTest.parent = LoginTest.extent.startTest("<b>loginTest in Chrome</b>", 
      "This is loginTest,Create new user & <b>Check whether particular user can login</b>,Once test is excute,Delete the user");
    LoginTest.logger.info("Testcases Started");
  }
  
  @Test
  public void Test2() {
    try {
      this.loginPage.GoTo();
      this.homePage.GoToMMS001();
      if (true) {
        Thread.sleep(2000);
        LoginTest.logger.info(LoginTest.TEXT_TEST_PASS, "User is Sucessfully Logged in");
        LoginTest.child1.log(LogStatus.PASS, "<font color=green>User is Sucessfully Logged in<font>");
        TakeScreenShot ts1 = new TakeScreenShot();
        ts1.takeScreenShot(BaseTest.driver, LoginTest.className, "screenshot2");
        String _addScreenCapture = LoginTest.child1.addScreenCapture(
          (("C:\\Users\\RashadR\\Desktop\\Reports\\Chrome" + LoginTest.className) + "\\Screenshot2.png"));
        String _plus = ("User is created : " + _addScreenCapture);
        LoginTest.child1.log(LogStatus.PASS, _plus);
        LoginTest.logger.info("Screenshot Taken Successfully!!!!");
        LoginTest.extent.flush();
      } else {
        LoginTest.logger.error(LoginTest.TEXT_TEST_FAIL, "User is NOT Sucessfully Logged in");
        LoginTest.child1.log(LogStatus.FAIL, "<font color=RED>User is NOT Sucessfully Logged in<font>");
        TakeScreenShot ts1_1 = new TakeScreenShot();
        ts1_1.takeScreenShot(BaseTest.driver, LoginTest.className, "screenshot2");
        String _addScreenCapture_1 = LoginTest.child1.addScreenCapture(
          (("C:\\Users\\RashadR\\Desktop\\Reports\\Chrome" + LoginTest.className) + "\\screenShotName2.png"));
        String _plus_1 = ("User is created : " + _addScreenCapture_1);
        LoginTest.child1.log(LogStatus.FAIL, _plus_1);
        LoginTest.logger.info("Screenshot Taken Successfully!!!!");
        LoginTest.extent.flush();
      }
      LoginTest.extent.endTest(LoginTest.child1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * @Test
   * def void Test3() {
   * loginPage.GoTo()
   * 
   * // Copying an item
   * homePage.GoToMMS001()
   * 
   * if (!true) {
   * 
   * Thread.sleep(2000);
   * logger.info(TEXT_TEST_PASS, "User is Sucessfully Logged in");
   * child2.log(LogStatus.PASS, "<font color=green>User is Sucessfully Logged in<font>");
   * 
   * var TakeScreenShot ts = new TakeScreenShot();
   * // ts.takeScreenShot(driver,className, screenShotName+"3");
   * ts.takeScreenShot(driver, className, "screenshot1")
   * child2.log(LogStatus.PASS,
   * "User is created : " +
   * child1.addScreenCapture(
   * "C:\\Users\\RashadR\\Desktop\\Reports\\Chrome" + className + "\\Screenshot1.png"));
   * logger.info("Screenshot Taken Successfully!!!!");
   * extent.flush();
   * } else {
   * 
   * logger.error(TEXT_TEST_FAIL, "User is NOT Sucessfully Logged in");
   * child2.log(LogStatus.FAIL, "<font color=RED>User is NOT Sucessfully Logged in<font>");
   * 
   * var TakeScreenShot ts = new TakeScreenShot();
   * ts.takeScreenShot(driver, className, "screenshot2");
   * child2.log(LogStatus.FAIL,
   * "User is created : " +
   * child1.addScreenCapture(
   * "C:\\Users\\RashadR\\Desktop\\Reports\\Chrome" + className + "\\Screenshot1.png"));
   * logger.info("Screenshot Taken Successfully!!!!");
   * extent.flush();
   * 
   * }
   * 
   * // extent.flush();
   * extent.endTest(child2);
   * }
   */
  @AfterMethod
  public void aftermethod(final Method method, final ITestResult result) throws MalformedURLException {
    int _status = result.getStatus();
    boolean _equals = (_status == ITestResult.FAILURE);
    if (_equals) {
      Throwable _throwable = result.getThrowable();
      String _plus = ("createUser Test failed because " + _throwable);
      LoginTest.child1.log(LogStatus.FAIL, _plus);
      LoginTest.extent.flush();
    } else {
      int _status_1 = result.getStatus();
      boolean _equals_1 = (_status_1 == ITestResult.SKIP);
      if (_equals_1) {
        Throwable _throwable_1 = result.getThrowable();
        String _plus_1 = ("createUser Test skipped because" + _throwable_1);
        LoginTest.child1.log(LogStatus.SKIP, _plus_1);
        LoginTest.extent.flush();
      } else {
        LoginTest.child1.log(LogStatus.PASS, "createUser Test got executed successfully");
        LoginTest.extent.flush();
      }
    }
    BaseTest.driver.quit();
  }
  
  /**
   * Append the child/merge all the child to one parent report
   * Close the driver
   */
  @AfterTest(alwaysRun = true)
  public void extent() {
    LoginTest.logger.info("Test case closed");
    LoginTest.parent.appendChild(LoginTest.child1);
    LoginTest.parent.appendChild(LoginTest.child2);
    LoginTest.extent.endTest(LoginTest.parent);
    LoginTest.extent.close();
    BaseTest.driver.quit();
  }
}
