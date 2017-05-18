package bi3.infor.templates

import bi3.pages.HomePage
import bi3.pages.mms001.MMS001
import bi3.pages.mms077.MMS077
import bi3.pages.mms077.MMS077_SelectMedia
import org.openqa.selenium.WebDriver
import org.testng.Assert

/**
 * Infor business process template class for item creation.
 * 
 * @author Niranga
 */
public class SKUCreationTemplate {

	/** WebDriver. */
	private WebDriver driver = null;

	/** Page MMS001. */
	private MMS001 mms001;
	
	/** Page MMs077. */
	private MMS077 mms077;
	
	/** Page MMS077_SelectMedia */
	private MMS077_SelectMedia mms077_SelectMedia
	
	/** Page HomePage */
	private HomePage homePage;

	new(WebDriver driver) {
		this.driver = driver;
		this.init();
	}
		
	/**
	 * Method init.
	 */
	private def init() {
		mms001  = new MMS001(this.driver);
		mms077 = new MMS077(this.driver);	
		homePage = new HomePage(driver);
		mms077_SelectMedia = new MMS077_SelectMedia(driver)
		
	}

	/**
	 * Method CreateSKU.
	 * Create the SKU
	 */ 
	
	def void CreateSKU(String itemNumber ,String newRawMatNumber ) {
		
		var boolean  methodExecutionStatus = false;
		
		try{	
				  
	     	mms001.goToHome();
			homePage.GoToMMS077();
			mms077.CreateItemsByMatrix(itemNumber);
			mms077.navigateToselectMedia();
			mms077_SelectMedia.ConfirmOutput();		          
			Assert.assertEquals(mms077.ConfirmMsg(),"Job MMS078CL has been submitted");	
			
			// Create SKU for Raw Material(Fabric)
			mms077.CreateItemsByMatrix(newRawMatNumber);
			mms077.navigateToselectMedia();
			mms077_SelectMedia.ConfirmOutput();		          
			Assert.assertEquals(mms077.ConfirmMsg(),"Job MMS078CL has been submitted");		
		
		} catch (Exception ex) {
			
			// catch the logs and logging should goes here
			throw ex;
			
		}
	}
	


	
}
