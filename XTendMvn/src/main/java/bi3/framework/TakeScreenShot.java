package bi3.framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class TakeScreenShot {

	public static final Logger LOGGER = LogManager
			.getLogger();
	
	
	/**
  	 * Take & Save the screenshot in chrome path,This method is allocated for chrome browser
  	 * 
  	 */
	
	public void takeScreenShot(WebDriver driver,String className,String screenShotName) {

        
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test
		// method name
		try {
				FileUtils.copyFile(scrFile,
						new File("C:\\Users\\RashadR\\Desktop\\Reports\\Chrome"+className+"/"+screenShotName+".png"));
		
			
		} catch (IOException e) {
			LOGGER.info(e);
			
		}
		}
	
	
}
