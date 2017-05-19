package bi3.tests

import bi3.pages.LoginPage
import bi3.pages.HomePage
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import bi3.pages.cas950.CAS950E
import bi3.pages.mns212.MNS212B1
import bi3.pages.cas310.CAS310B1
import org.testng.Assert

class ReceiveMOinFactoryTrackTests extends BaseTest{
	
	LoginPage loginPage
	HomePage homePage
	CAS950E cas950e
	MNS212B1 mns212b1
	CAS310B1 cas310b1
	
	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver)
		homePage = new HomePage(driver)
		cas950e=new CAS950E(driver);
		mns212b1=new MNS212B1(driver);
		cas310b1=new CAS310B1(driver);
		
		}
		
		@Test
	def  void RecieveMo(){	
		loginPage.GoTo();
		homePage.GoToCAS950();
		cas950e.FillDivision("AAA");
		cas950e.selectFromDate("170518");
		cas950e.selectToDate("170519");
		//cas950e.checkStockTrance();
		cas950e.Next();
		mns212b1.ConfirmOutput();
		mns212b1.closeAllTabs();
		homePage.GoToCAS310();
		cas310b1.FillFacility("A01");
		cas310b1.setSortingOrder("2-Per facility and order no");
		cas310b1.searchMONumber("0003000028");
		
		//var status=cas310b1.GetStatuses("0003000028");
		//Assert.assertEquals(status.get(0),"0003000028","Status is incorrect");
		
		}
	
}