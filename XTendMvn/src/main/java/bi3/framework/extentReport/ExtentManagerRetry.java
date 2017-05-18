package bi3.framework.extentReport;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManagerRetry {

	
private static ExtentReports extent;
    
    public synchronized static ExtentReports getReporter(String filePath) {
        
           extent = new ExtentReports(filePath, false);
            
            extent
                 .addSystemInfo("Environment", "QA");
            

       
        
        
        return extent;
    }
    
    public synchronized static ExtentReports getReporter() {
        return extent;
    }  
    
    
}
