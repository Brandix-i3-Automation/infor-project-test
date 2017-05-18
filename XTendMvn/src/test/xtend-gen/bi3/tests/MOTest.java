package bi3.tests;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.crs207.CRS207_B;
import bi3.pages.mms001.MMS001;
import bi3.pages.pms001.PMS001;
import bi3.pages.pms001.PMS001_B;
import bi3.pages.pms001.PMS001_E;
import bi3.pages.pms001.PMS001_F;
import bi3.pages.pms001.PMS270_B1;
import bi3.pages.pms001.PMS270_E;
import bi3.pages.pms100.PMS100_B;
import bi3.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class MOTest extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private PMS001 pms001;
  
  private PMS001_B pms001_b;
  
  private PMS001_E pms001_e;
  
  private PMS001_F pms001_f;
  
  private PMS270_B1 pms270_b1;
  
  private PMS270_E pms270_e;
  
  private CRS207_B crs207_b;
  
  private MMS001 mms001;
  
  private PMS100_B pms100_b;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    PMS001 _pMS001 = new PMS001(BaseTest.driver);
    this.pms001 = _pMS001;
    PMS001_B _pMS001_B = new PMS001_B(BaseTest.driver);
    this.pms001_b = _pMS001_B;
    PMS001_E _pMS001_E = new PMS001_E(BaseTest.driver);
    this.pms001_e = _pMS001_E;
    PMS001_F _pMS001_F = new PMS001_F(BaseTest.driver);
    this.pms001_f = _pMS001_F;
    PMS270_B1 _pMS270_B1 = new PMS270_B1(BaseTest.driver);
    this.pms270_b1 = _pMS270_B1;
    PMS270_E _pMS270_E = new PMS270_E(BaseTest.driver);
    this.pms270_e = _pMS270_E;
    CRS207_B _cRS207_B = new CRS207_B(BaseTest.driver);
    this.crs207_b = _cRS207_B;
    MMS001 _mMS001 = new MMS001(BaseTest.driver);
    this.mms001 = _mMS001;
    PMS100_B _pMS100_B = new PMS100_B(BaseTest.driver);
    this.pms100_b = _pMS100_B;
  }
  
  @Test
  public void CreateManufactureOrder() {
    this.loginPage.GoTo();
    this.homePage.GoToPMS001();
  }
}
