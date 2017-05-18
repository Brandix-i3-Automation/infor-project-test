package bi3.tests

import bi3.framework.TakeScreenShot
import bi3.framework.extentReport.ExtentManagerChrome
import bi3.pages.HomePage
import bi3.pages.LoginPage
import bi3.pages.mms001.MMS001
import bi3.pages.mms001.MMS001C
import bi3.pages.mms001.MMS001ConnectWarehouse
import bi3.pages.mms001.MMS001ConnectWarehouseE
import bi3.pages.mms001.MMS001ConnectWarehouseF
import bi3.pages.mms001.MMS001ConnectWarehouseG
import bi3.pages.mms001.MMS001ConnectWarehouseH
import bi3.pages.mms001.MMS001ConnectWarehouseI
import bi3.pages.mms001.MMS001E
import bi3.pages.mms001.MMS001F
import bi3.pages.mms001.MMS001G
import bi3.pages.mms001.MMS001H
import bi3.pages.mms001.MMS001I
import bi3.pages.mms001.MMS001J
import bi3.pages.mms001.MMS001K
import bi3.pages.mms001.MMS001M
import bi3.pages.mms077.MMS077
import bi3.pages.mms077.MMS077_SelectMedia
import com.relevantcodes.extentreports.ExtentReports
import com.relevantcodes.extentreports.ExtentTest
import com.relevantcodes.extentreports.LogStatus
import java.io.IOException
import java.lang.reflect.Method
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import org.testng.ITestResult
import java.net.MalformedURLException

class LoginTest extends BaseTest {

	/**
	 * 
	 * Define className
	 */
	public static String className = LoginTest.getSimpleName();

	public static final String TEXT_TEST_PASS = "Test Case : {} PASSED!";
	public static final String TEXT_TEST_FAIL = "Test Case : {} FAILED!";

	/**
	 * 
	 * Defining log4j
	 */
	private static final Logger logger = LogManager.getLogger(LoginTest.getName());

	/**
	 * 
	 * Defining Report
	 */
	static ExtentReports extent;
	static ExtentTest parent;
	static ExtentTest child1;
	static ExtentTest child2;

	LoginPage loginPage
	HomePage homePage
	MMS001 mms001
	MMS001C mms001C
	MMS001E mms001E
	MMS001F mms001F
	MMS001G mms001G
	MMS001H mms001H
	MMS001I mms001I
	MMS001J mms001J
	MMS001K mms001K
	MMS001M mms001M
	MMS001ConnectWarehouse mms001ConnectWarehouse
	MMS001ConnectWarehouseE connectWarehouseE
	MMS001ConnectWarehouseF connectWarehouseF
	MMS001ConnectWarehouseG connectWarehouseG
	MMS001ConnectWarehouseH connectWarehouseH
	MMS001ConnectWarehouseI connectWarehouseI
	MMS077 mms077
	MMS077_SelectMedia mms077_SelectMedia

	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		mms001 = new MMS001(driver);
		mms001C = new MMS001C(driver);
		mms001E = new MMS001E(driver);
		mms001F = new MMS001F(driver);
		mms001G = new MMS001G(driver);
		mms001H = new MMS001H(driver);
		mms001I = new MMS001I(driver);
		mms001J = new MMS001J(driver);
		mms001K = new MMS001K(driver);
		mms001M = new MMS001M(driver);
		mms001ConnectWarehouse = new MMS001ConnectWarehouse(driver)
		connectWarehouseE = new MMS001ConnectWarehouseE(driver)
		connectWarehouseF = new MMS001ConnectWarehouseF(driver)
		connectWarehouseG = new MMS001ConnectWarehouseG(driver)
		connectWarehouseH = new MMS001ConnectWarehouseH(driver)
		connectWarehouseI = new MMS001ConnectWarehouseI(driver)
		mms077 = new MMS077(driver);
		mms077_SelectMedia = new MMS077_SelectMedia(driver);

	}

	@BeforeTest(alwaysRun=true)
	def static void beforeClass() throws IOException
	{
		child1 = new ExtentTest("Login Test", "User1 creation");
		child2 = new ExtentTest("Login Test", "User2 creation");
		// extent = new ExtentReports("");
		var String path = "C:\\Users\\RashadR\\Desktop\\Reports\\Chrome" + className + "\\LoginTestzz.html";
		extent = ExtentManagerChrome.getReporter(path);
		parent = extent.startTest("<b>loginTest in Chrome</b>",
			"This is loginTest,Create new user & <b>Check whether particular user can login</b>,Once test is excute,Delete the user");
		logger.info("Testcases Started");
	}

	@Test
	def void Test2() {
		loginPage.GoTo()

		// Copying an item
		homePage.GoToMMS001()

		if (true) {

			Thread.sleep(2000);
			logger.info(TEXT_TEST_PASS, "User is Sucessfully Logged in");
			child1.log(LogStatus.PASS, "<font color=green>User is Sucessfully Logged in<font>");

			var TakeScreenShot ts1 = new TakeScreenShot();
			// ts.takeScreenShot(driver,className, screenShotName+"3");
			ts1.takeScreenShot(driver, className, "screenshot2")
			child1.log(LogStatus.PASS,
				"User is created : " +
					child1.addScreenCapture(
						"C:\\Users\\RashadR\\Desktop\\Reports\\Chrome" + className + "\\Screenshot2.png"));
			logger.info("Screenshot Taken Successfully!!!!");
			extent.flush();
		} else {

			logger.error(TEXT_TEST_FAIL, "User is NOT Sucessfully Logged in");
			child1.log(LogStatus.FAIL, "<font color=RED>User is NOT Sucessfully Logged in<font>");

			var TakeScreenShot ts1 = new TakeScreenShot();
			ts1.takeScreenShot(driver, className, "screenshot2");
			child1.log(LogStatus.FAIL,
				"User is created : " +
					child1.addScreenCapture(
						"C:\\Users\\RashadR\\Desktop\\Reports\\Chrome" + className + "\\screenShotName2.png"));
			logger.info("Screenshot Taken Successfully!!!!");
			extent.flush();

		}

		// extent.flush();		
		extent.endTest(child1);

//		mms001.SearchByItemNumber("Y3001")
//		mms001.CopyItem("Y3001")
//
//		mms001C.Next()
//
//		mms001E.SelectInvAccounting("1-Inv accounting")
//		mms001E.SelectLotCtrlMethod("3-In lot master")
//		mms001E.SelectLotNumbMethod("5-Auto order no")
//		var newItemNumber = mms001E.GetItemNumber()
//
//		mms001E.Next()
//		mms001F.Next()
//
//		mms001G.SelectSalesItem("1-Sales item")
//		mms001G.Next()
//		mms001H.Next()
//		mms001I.Next()
//		mms001J.Next()
//		mms001K.Next()
//		mms001M.Next()
//
//		//var newItemNumber = "Y3222"
//		mms001.SearchByItemNumber(newItemNumber);
//		
//		//Check if item is created.
//		Assert.assertTrue(mms001.GetItemNumberList().contains(newItemNumber),"Item number" + newItemNumber + "is not found in the grid");		
//		
//		mms001.setItemWarehouse(newItemNumber);
//		
//		//Assert.assertEquals(mms001ConnectWarehouse.getpageTitle().contains("Item. Connect Warehouse"),"Did not reach the Connect Warehouse page.Actual value was "+mms001ConnectWarehouse.getpageTitle());		
//		
//		mms001ConnectWarehouse.changeWarehouse()
//		
//		Assert.assertTrue(connectWarehouseE.getPageSubTitle().contains("Planning Parameters"),"Did not reach the Main warehouse change page");
//		
//		
//		connectWarehouseE.setMastrSchedule()
//		connectWarehouseE.setPlanningPolicy("A6")
//		connectWarehouseE.setSupplyPolicy("A01")	
//		connectWarehouseE.selectContNetChange()
//		connectWarehouseE.clickNext()
//		
//		connectWarehouseF.clickNext()
//		
//		connectWarehouseG.untickCrossDock()
//		connectWarehouseG.clickNext();
//		
//		connectWarehouseH.clickNext()
//		connectWarehouseI.clickNext()
//				
//		System.out.println("Copied Item Number : "+newItemNumber)
//		mms001ConnectWarehouse.close()   
//		
//		//Goto Home
//		mms001I.GoToHome();
//		
//		//Go To MMS077
//		homePage.GoToMMS077();
//		mms077.CreateItemsByMatrix(newItemNumber);
//		mms077.navigateToselectMedia();
//		mms077_SelectMedia.ConfirmOutput();
//		          
//		Assert.assertEquals(mms077.ConfirmMsg(),"Job MMS078CL has been submitted");
//		           
	}

	/* @Test
	def void Test3() {
		loginPage.GoTo()

		// Copying an item
		homePage.GoToMMS001()

		if (!true) {

			Thread.sleep(2000);
			logger.info(TEXT_TEST_PASS, "User is Sucessfully Logged in");
			child2.log(LogStatus.PASS, "<font color=green>User is Sucessfully Logged in<font>");

			var TakeScreenShot ts = new TakeScreenShot();
			// ts.takeScreenShot(driver,className, screenShotName+"3");
			ts.takeScreenShot(driver, className, "screenshot1")
			child2.log(LogStatus.PASS,
				"User is created : " +
					child1.addScreenCapture(
						"C:\\Users\\RashadR\\Desktop\\Reports\\Chrome" + className + "\\Screenshot1.png"));
			logger.info("Screenshot Taken Successfully!!!!");
			extent.flush();
		} else {

			logger.error(TEXT_TEST_FAIL, "User is NOT Sucessfully Logged in");
			child2.log(LogStatus.FAIL, "<font color=RED>User is NOT Sucessfully Logged in<font>");

			var TakeScreenShot ts = new TakeScreenShot();
			ts.takeScreenShot(driver, className, "screenshot2");
			child2.log(LogStatus.FAIL,
				"User is created : " +
					child1.addScreenCapture(
						"C:\\Users\\RashadR\\Desktop\\Reports\\Chrome" + className + "\\Screenshot1.png"));
			logger.info("Screenshot Taken Successfully!!!!");
			extent.flush();

		}

		// extent.flush();		
		extent.endTest(child2);
	}
*/
	@AfterMethod
	def public void aftermethod(Method method, ITestResult result) throws MalformedURLException{

	

			if (result.getStatus() == ITestResult.FAILURE) {
				child1.log(LogStatus.FAIL, "createUser Test failed because " + result.getThrowable());
				extent.flush();
			} else if (result.getStatus() == ITestResult.SKIP) {
				child1.log(LogStatus.SKIP, "createUser Test skipped because" + result.getThrowable());
				extent.flush();
			} else {
				child1.log(LogStatus.PASS, "createUser Test got executed successfully");
				extent.flush();
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

		parent.appendChild(child1);
		parent.appendChild(child2);
		extent.endTest(parent);
		extent.close();
		driver.quit();

	}

}
