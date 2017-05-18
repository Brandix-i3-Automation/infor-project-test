package bi3.tests;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.mws410.MWS410B;
import bi3.pages.pms100.PMS100;
import bi3.pages.pms100.PMS100_B;
import bi3.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class PMS100Test extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private PMS100 pms100;
  
  private PMS100_B pms100_b;
  
  private MWS410B mws410b;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    PMS100 _pMS100 = new PMS100(BaseTest.driver);
    this.pms100 = _pMS100;
    PMS100_B _pMS100_B = new PMS100_B(BaseTest.driver);
    this.pms100_b = _pMS100_B;
    MWS410B _mWS410B = new MWS410B(BaseTest.driver);
    this.mws410b = _mWS410B;
  }
  
  @Test
  public void OpenPMS001() {
    this.loginPage.GoTo();
    this.homePage.GoToPMS100();
    String pageTitle = this.pms100.getpageTitle();
    Assert.assertTrue(pageTitle.contains("Manufacturing Order. Open"));
  }
  
  @Test
  public void ReleaseForPicking() {
    String schedNo = "178";
    this.loginPage.GoTo();
    this.homePage.GoToPMS100();
    String pageTitle = this.pms100.getpageTitle();
    Assert.assertTrue(pageTitle.contains("Manufacturing Order. Open"));
    this.pms100_b.SearchScheduleNo(schedNo);
    String firstSchedNo = this.pms100_b.GetFirstRowScheduleNumber();
    Assert.assertEquals(firstSchedNo, schedNo, 
      ((("Could not find the schedule number " + schedNo) + " found ") + firstSchedNo));
    this.pms100_b.goToDeliveryToolbox();
    this.mws410b.selectView("A84-MO Schedules/Work centers");
  }
}
