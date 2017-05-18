package bi3.tests

import bi3.pages.LoginPage
import bi3.pages.HomePage
import bi3.pages.pcs200.PCS200E
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import bi3.pages.pds001.PDS001
import bi3.pages.pcs200.PCS200F
import bi3.pages.pcs300.PCS300
import org.testng.Assert

class PCS200Test extends BaseTest {
	
	LoginPage loginPage
	HomePage homePage
	PCS200E pcs200e
	PDS001 pds001
	PCS200F pcs200f
	PCS300 pcs300
	
	@BeforeTest
	def void Initialize() {
		loginPage = new LoginPage(driver)
		homePage = new HomePage(driver)
		pcs200e = new PCS200E(driver);
		pds001= new PDS001(driver);
		pcs200f=new PCS200F(driver);
		pcs300= new PCS300 (driver)
	}
	
	@Test
	def void ProductCostingTest(){
	 loginPage.GoTo();
	 homePage.GoToPDS001();
	 pds001.SearchByItemNumber("Y3516");
	 pds001.goToCalculateProductCost();
	 
	 var costingtype="3";
	 
	 pcs200e.SetCostingType(costingtype);
	 Thread.sleep(1000);
	 pcs200e.SelectPrtCosting("0-No");
	 pcs200e.SetCostingName("STD");
	 pcs200e.SelectAllLevels("1-Explosion, all");
	 pcs200e.SetView("STD");
	 pcs200e.SelectCalspurchdist("3-Yes, purch & distr items & subcontr op");
	 pcs200e.clickNext();
	 pcs200e.clickNext();
	 pcs200f.clickNext();
	 pds001.SearchByItemNumber("Y3516");
	 pds001.goToDisplayProductCosting();
	 val gridcostingtype=pcs300.getDataOfItem(costingtype).get(0);
	 
	 Assert.assertEquals(gridcostingtype,costingtype);	
	 
	 }
}