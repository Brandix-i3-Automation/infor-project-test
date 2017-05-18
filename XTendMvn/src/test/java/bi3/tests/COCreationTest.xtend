package bi3.tests

import bi3.pages.LoginPage
import bi3.pages.HomePage
import org.testng.annotations.BeforeTest
import bi3.pages.ois100.OIS100A
import org.testng.annotations.Test
import java.util.Date
import bi3.pages.ois101.OIS101B1
import bi3.pages.ois101.OIS101E
import bi3.pages.pds001.PDS600E
import bi3.pages.BasePage
import bi3.pages.ois100.OIS100G
import bi3.pages.crs207.CRS207_B
import org.testng.Assert
import org.apache.bcel.generic.CHECKCAST
import org.testng.annotations.BeforeMethod

class COCreationTest extends BaseTest{
	
	LoginPage loginPage
	HomePage homePage
	OIS100A ois100A
	OIS100G ois100G
	OIS101B1 ois101B1
	PDS600E pds600E
	OIS101E ois101e
	CRS207_B crs207B
	
	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		ois100A = new OIS100A(driver);
		ois100G = new OIS100G(driver);
		ois101B1 = new OIS101B1(driver);
		pds600E = new PDS600E(driver);
		ois101e = new OIS101E(driver);
		crs207B = new CRS207_B(driver);
		
	}
	
	@Test
	def void CustomerOrderCreation(){
		loginPage.GoTo();
		homePage.GoToOIS100();
		
		ois100A.clearCOno();
		ois100A.clearCustomer();
		ois100A.fillCustomer("Y00001");	
		ois100A.fillCOType("A01");
		ois100A.fillReqDeliveryDate("170810");
		
		ois100A.clickNext();
		ois100G.handleAbnormalException();
		
     	ois100A.clickNext();
		
		if(ois100A.getPageId().equals("OIS100/G")){
			ois100G.fillCustomerOrd("Y00001-190");
			ois100G.clickNext();
			ois100G.handleWarning();
		}
		ois101B1.fillOrderLine("Y3210","30");
		crs207B.fillMatrix("10");
		
		crs207B.clickNext();
		
		
		//Enter price for Black item
		crs207B.handleAbnormalException();
		ois101e.fillPricingInformation("350","200");
		
//		//Enter price for Green item
//		crs207B.handleAbnormalException();
//		ois101e.fillPricingInformation("350","300");
//				
//		//Enter price for Red item
//		crs207B.handleAbnormalException();
//		ois101e.fillPricingInformation("350","325");
		
		//asserting the table
		Assert.assertTrue(ois101B1.checkItemPresence().contains("Y3210-Y01-010"));
					
	}
}