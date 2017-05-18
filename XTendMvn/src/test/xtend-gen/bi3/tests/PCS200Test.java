package bi3.tests;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.pcs200.PCS200E;
import bi3.pages.pcs200.PCS200F;
import bi3.pages.pcs300.PCS300;
import bi3.pages.pds001.PDS001;
import bi3.tests.BaseTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class PCS200Test extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private PCS200E pcs200e;
  
  private PDS001 pds001;
  
  private PCS200F pcs200f;
  
  private PCS300 pcs300;
  
  @BeforeTest
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    PCS200E _pCS200E = new PCS200E(BaseTest.driver);
    this.pcs200e = _pCS200E;
    PDS001 _pDS001 = new PDS001(BaseTest.driver);
    this.pds001 = _pDS001;
    PCS200F _pCS200F = new PCS200F(BaseTest.driver);
    this.pcs200f = _pCS200F;
    PCS300 _pCS300 = new PCS300(BaseTest.driver);
    this.pcs300 = _pCS300;
  }
  
  @Test
  public void ProductCostingTest() {
    try {
      this.loginPage.GoTo();
      this.homePage.GoToPDS001();
      this.pds001.SearchByItemNumber("Y3516");
      this.pds001.goToCalculateProductCost();
      String costingtype = "3";
      this.pcs200e.SetCostingType(costingtype);
      Thread.sleep(1000);
      this.pcs200e.SelectPrtCosting("0-No");
      this.pcs200e.SetCostingName("STD");
      this.pcs200e.SelectAllLevels("1-Explosion, all");
      this.pcs200e.SetView("STD");
      this.pcs200e.SelectCalspurchdist("3-Yes, purch & distr items & subcontr op");
      this.pcs200e.clickNext();
      this.pcs200e.clickNext();
      this.pcs200f.clickNext();
      this.pds001.SearchByItemNumber("Y3516");
      this.pds001.goToDisplayProductCosting();
      final String gridcostingtype = this.pcs300.getDataOfItem(costingtype).get(0);
      Assert.assertEquals(gridcostingtype, costingtype);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
