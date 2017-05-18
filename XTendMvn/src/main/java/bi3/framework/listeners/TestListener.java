package bi3.framework.listeners;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;



public class TestListener implements ITestListener {

	private static final Logger logger = LogManager
			.getLogger(TestListener.class.getName());
	
    public static WebDriver driver;

	
	
	public void onTestStart(ITestResult result) {
		logger.info( " ****** "+result.getName() + " Started *****");

	}

	public void onTestSuccess(ITestResult result) {
		
		logger.info( " ****** "+result.getName() + " Success *****");
	}

	public void onTestFailure(ITestResult result) {

		

		
		 if (result.getStatus() == ITestResult.FAILURE) {            
             logger.info("***** Error " + result.getName()
                      + " test has failed *****");
            
         }
        
	}

	
	public void onTestSkipped(ITestResult result) {
		
		 if (result.getStatus() == ITestResult.SKIP) {
            
             logger.info("***** Error " + result.getName()
                      + " test has skiped *****");
            
         }
         

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		logger.info( " ****** "+result.getName() + " onTestFailedButWithinSuccessPercentage *****");

	}

	public void onStart(ITestContext context) {
		
		logger.info( " ****** Testcase got executed*****");
	}


	public void onFinish(ITestContext context) {

		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}
			}
		}
		
			
					
	}

	

	

}

