package bi3.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.awt.Robot
import java.awt.event.KeyEvent

class LoginPage extends BasePage {

	new(WebDriver driver) { // Constructor
		super(driver)
	}

	@FindBy(css = ".table.table-striped.table-bordered")
    WebElement txtUserName;
    
    @FindBy(css = ".table.table-striped.table-bordered")
    WebElement txtPassword; 
    
	def void GoTo() {
		driver.get("http://Priyankara:bi3passwordQ8892@bi3-m313-01.brandixlk.org:44056/mne/");
//	driver.get("http://bi3-m313-01.brandixlk.org:44056/mne/");
//	Thread.sleep(5000);
//		 var Robot rb = new Robot();
//		 
//		 
//	    	rb.keyPress(KeyEvent.VK_TAB);
//	    	rb.keyRelease(KeyEvent.VK_TAB);
//	    	rb.keyPress(KeyEvent.VK_TAB);
//	    	rb.keyRelease(KeyEvent.VK_TAB);
////	    	rb.keyPress(KeyEvent.VK_TAB);
////	    	rb.keyRelease(KeyEvent.VK_TAB);
////	    	rb.keyPress(KeyEvent.VK_TAB);
////	    	rb.keyRelease(KeyEvent.VK_TAB);
////	    	
////	    	rb.keyPress(KeyEvent.VK_CLEAR);
////	    	rb.keyRelease(KeyEvent.VK_INSERT);
////	    	rb.keyRelease(KeyEvent.VK_CONTROL);
//	    	Thread.sleep(2000);
//	    	rb.keyPress(KeyEvent.VK_ENTER);
//	    	rb.keyRelease(KeyEvent.VK_ENTER);
//	    	Thread.sleep(2000);
	
		//driver.get("http://google.lk"); 
	}

}
