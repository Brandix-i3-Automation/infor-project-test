package bi3.framework.extentReport;

import java.util.HashMap;
import java.util.Map;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManagerChrome {

	static Map extentTestMap = new HashMap();
	   private static ExtentReports extent = ExtentManagerChrome.getReporter();

	   public static synchronized ExtentTest getTest() {
	       return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	   }

	   public static synchronized void endTest() {
	       extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
	   }

	   public static synchronized ExtentTest startTest(String testName) {
	       return startTest(testName, "");
	   }

	   public static synchronized ExtentTest startTest(String testName, String desc) {
	       ExtentTest test = extent.startTest(testName, desc);
	       extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

	       return test;
	   }  
	
	
}
