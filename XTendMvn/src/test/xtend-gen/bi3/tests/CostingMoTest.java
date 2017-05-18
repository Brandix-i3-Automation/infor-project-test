package bi3.tests;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.cas950.CAS950E;
import bi3.tests.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class CostingMoTest extends BaseTest {
  private HomePage homePage;
  
  private LoginPage loginPage;
  
  private CAS950E cas950_e;
  
  @BeforeTest
  public void Initialize() {
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    CAS950E _cAS950E = new CAS950E(BaseTest.driver);
    this.cas950_e = _cAS950E;
  }
  
  @Test
  public void ProductOrderProposal() {
    this.loginPage.GoTo();
    this.homePage.GoToCAS950();
    this.cas950_e.selectFromDate("170502");
    this.cas950_e.selectToDate("170503");
    this.cas950_e.checkStockTrance();
    this.cas950_e.checkOpTranceMo();
    this.cas950_e.checkOtherTrance();
    this.cas950_e.checkOpTranceWo();
    this.cas950_e.checkOrderCosting();
    this.cas950_e.Next();
  }
}
