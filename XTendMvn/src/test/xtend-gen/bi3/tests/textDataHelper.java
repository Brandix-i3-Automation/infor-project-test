package bi3.tests;

import bi3.infor.dataHelper.dataHelper;
import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.mms001.MMS001;
import bi3.pages.ois300.OIS300;
import bi3.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class textDataHelper extends BaseTest {
  private HomePage homePage;
  
  private LoginPage loginPage;
  
  private OIS300 ois300;
  
  private MMS001 mms001;
  
  private dataHelper dataHelper;
  
  @BeforeMethod
  public void Initialize() {
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    OIS300 _oIS300 = new OIS300(BaseTest.driver);
    this.ois300 = _oIS300;
    MMS001 _mMS001 = new MMS001(BaseTest.driver);
    this.mms001 = _mMS001;
    dataHelper _dataHelper = new dataHelper();
    this.dataHelper = _dataHelper;
  }
  
  @Test
  public void ProductOrderProposal() {
    this.loginPage.GoTo();
    this.homePage.GoToMMS001();
    this.mms001.SearchByItemNumber(this.dataHelper.getItemNumber());
  }
}
