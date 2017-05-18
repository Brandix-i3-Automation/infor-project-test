package bi3.infor.templates;

import bi3.pages.HomePage;
import bi3.pages.mms001.MMS001;
import bi3.pages.mms077.MMS077;
import bi3.pages.mms077.MMS077_SelectMedia;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Infor business process template class for item creation.
 * 
 * @author Niranga
 */
@SuppressWarnings("all")
public class SKUCreationTemplate {
  /**
   * WebDriver.
   */
  private WebDriver driver = null;
  
  /**
   * Page MMS001.
   */
  private MMS001 mms001;
  
  /**
   * Page MMs077.
   */
  private MMS077 mms077;
  
  /**
   * Page MMS077_SelectMedia
   */
  private MMS077_SelectMedia mms077_SelectMedia;
  
  /**
   * Page HomePage
   */
  private HomePage homePage;
  
  public SKUCreationTemplate(final WebDriver driver) {
    this.driver = driver;
    this.init();
  }
  
  /**
   * Method init.
   */
  private MMS077_SelectMedia init() {
    MMS077_SelectMedia _xblockexpression = null;
    {
      MMS001 _mMS001 = new MMS001(this.driver);
      this.mms001 = _mMS001;
      MMS077 _mMS077 = new MMS077(this.driver);
      this.mms077 = _mMS077;
      HomePage _homePage = new HomePage(this.driver);
      this.homePage = _homePage;
      MMS077_SelectMedia _mMS077_SelectMedia = new MMS077_SelectMedia(this.driver);
      _xblockexpression = this.mms077_SelectMedia = _mMS077_SelectMedia;
    }
    return _xblockexpression;
  }
  
  /**
   * Method CreateSKU.
   * Create the SKU
   */
  public void CreateSKU(final String itemNumber, final String newRawMatNumber) {
    try {
      boolean methodExecutionStatus = false;
      try {
        this.mms001.goToHome();
        this.homePage.GoToMMS077();
        this.mms077.CreateItemsByMatrix(itemNumber);
        this.mms077.navigateToselectMedia();
        this.mms077_SelectMedia.ConfirmOutput();
        Assert.assertEquals(this.mms077.ConfirmMsg(), "Job MMS078CL has been submitted");
        this.mms077.CreateItemsByMatrix(newRawMatNumber);
        this.mms077.navigateToselectMedia();
        this.mms077_SelectMedia.ConfirmOutput();
        Assert.assertEquals(this.mms077.ConfirmMsg(), "Job MMS078CL has been submitted");
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
          throw ex;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
