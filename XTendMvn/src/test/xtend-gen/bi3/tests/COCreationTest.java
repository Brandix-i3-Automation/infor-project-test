package bi3.tests;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.crs207.CRS207_B;
import bi3.pages.ois100.OIS100A;
import bi3.pages.ois100.OIS100G;
import bi3.pages.ois101.OIS101B1;
import bi3.pages.ois101.OIS101E;
import bi3.pages.pds001.PDS600E;
import bi3.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class COCreationTest extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private OIS100A ois100A;
  
  private OIS100G ois100G;
  
  private OIS101B1 ois101B1;
  
  private PDS600E pds600E;
  
  private OIS101E ois101e;
  
  private CRS207_B crs207B;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    OIS100A _oIS100A = new OIS100A(BaseTest.driver);
    this.ois100A = _oIS100A;
    OIS100G _oIS100G = new OIS100G(BaseTest.driver);
    this.ois100G = _oIS100G;
    OIS101B1 _oIS101B1 = new OIS101B1(BaseTest.driver);
    this.ois101B1 = _oIS101B1;
    PDS600E _pDS600E = new PDS600E(BaseTest.driver);
    this.pds600E = _pDS600E;
    OIS101E _oIS101E = new OIS101E(BaseTest.driver);
    this.ois101e = _oIS101E;
    CRS207_B _cRS207_B = new CRS207_B(BaseTest.driver);
    this.crs207B = _cRS207_B;
  }
  
  @Test
  public void CustomerOrderCreation() {
    this.loginPage.GoTo();
    this.homePage.GoToOIS100();
    this.ois100A.clearCOno();
    this.ois100A.clearCustomer();
    this.ois100A.fillCustomer("Y00001");
    this.ois100A.fillCOType("A01");
    this.ois100A.fillReqDeliveryDate("170810");
    this.ois100A.clickNext();
    this.ois100G.handleAbnormalException();
    this.ois100A.clickNext();
    boolean _equals = this.ois100A.getPageId().equals("OIS100/G");
    if (_equals) {
      this.ois100G.fillCustomerOrd("Y00001-190");
      this.ois100G.clickNext();
      this.ois100G.handleWarning();
    }
    this.ois101B1.fillOrderLine("Y3210", "30");
    this.crs207B.fillMatrix("10");
    this.crs207B.clickNext();
    this.crs207B.handleAbnormalException();
    this.ois101e.fillPricingInformation("350", "200");
    Assert.assertTrue(this.ois101B1.checkItemPresence().contains("Y3210-Y01-010"));
  }
}
