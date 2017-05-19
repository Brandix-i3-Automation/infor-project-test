package bi3.tests;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.cas310.CAS310B1;
import bi3.pages.cas950.CAS950E;
import bi3.pages.mns212.MNS212B1;
import bi3.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class ReceiveMOinFactoryTrackTests extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private CAS950E cas950e;
  
  private MNS212B1 mns212b1;
  
  private CAS310B1 cas310b1;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    CAS950E _cAS950E = new CAS950E(BaseTest.driver);
    this.cas950e = _cAS950E;
    MNS212B1 _mNS212B1 = new MNS212B1(BaseTest.driver);
    this.mns212b1 = _mNS212B1;
    CAS310B1 _cAS310B1 = new CAS310B1(BaseTest.driver);
    this.cas310b1 = _cAS310B1;
  }
  
  @Test
  public void RecieveMo() {
    this.loginPage.GoTo();
    this.homePage.GoToCAS950();
    this.cas950e.FillDivision("AAA");
    this.cas950e.selectFromDate("170518");
    this.cas950e.selectToDate("170519");
    this.cas950e.Next();
    this.mns212b1.ConfirmOutput();
    this.mns212b1.closeAllTabs();
    this.homePage.GoToCAS310();
    this.cas310b1.FillFacility("A01");
    this.cas310b1.setSortingOrder("2-Per facility and order no");
    this.cas310b1.searchMONumber("0003000028");
  }
}
