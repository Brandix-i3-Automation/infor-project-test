package bi3.framework.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import bi3.framework.extentReport.ExtentManagerRetry;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ChromeRetryAnalyzer implements IRetryAnalyzer  
{ 
	
	/**
	 * 
	 * Defining log4j
	 */

	private static final Logger logger = LogManager
			.getLogger(ChromeRetryAnalyzer.class.getName());
	
	/**
	 * 
	 * Get the className
	 */
	
	public static String className = ChromeRetryAnalyzer.class.getSimpleName();
	
	/**
	 * 
	 * Set the path for saving retry report
	 */
	
	ExtentReports extent = ExtentManagerRetry.getReporter("C:\\Users\\RashadR\\Desktop\\Reports\\Retry\\"+className+".html");
	
	
	private int count = 0; 

	//set your count to re-run test
	private int maxCount = 3; 


/**
 * 
 * Get the result status,while testcases are running
 */

public String getResultStatusName(int status) {
   	String resultName = null;
   	if(status==1)
   		resultName = "SUCCESS";
   	if(status==2)
   		resultName = "FAILURE";
   	if(status==3)
   		resultName = "SKIP";
		return resultName;
   }

/**
 * 
 * 	Get the results of retry testcases
 */

public boolean retry(ITestResult result) { 
	ExtentTest test = extent.startTest(result.getName(),"This "+result.getName()+" test method got fail/skip");
	

	
        if(count < maxCount) {                     
             
        	if (result.getStatus() == ITestResult.FAILURE) {
    	        test.log(LogStatus.FAIL, result.getThrowable());
    	        extent.flush();
    	    } else if (result.getStatus() == ITestResult.SKIP) {
    	        test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
    	        extent.flush();
    	    } else {
    	        test.log(LogStatus.PASS, "Test passed");
    	        extent.flush();
    	    }
            	
            	logger.info("Retrying test " + result.getName() + " with status "
                        + getResultStatusName(result.getStatus()) + " for the " + (count+1) + " time(s).");
                
            	
                test.log(LogStatus.FAIL, "Retrying test " + result.getName() + " with status "
                        + getResultStatusName(result.getStatus()) + " for the " + (count+1) + " time(s).");  
            	
            	   count++; 
            	   
            	   
            	   	extent.flush();
                  	extent.endTest(test); 
              
                return true;
                
        } 
       
        return false; 
}


@AfterTest
public void CloseDriver() {
	
	
	extent.close();		
	

} 
}
