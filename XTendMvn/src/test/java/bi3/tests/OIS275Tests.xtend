package bi3.tests

import bi3.pages.HomePage
import bi3.pages.LoginPage
import bi3.pages.ois100.OIS100H
import bi3.pages.ois101.OIS101E
import bi3.pages.ois275.OIS275B_1
import bi3.pages.ois276.OIS276B
import bi3.pages.ois300.OIS300B
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import bi3.pages.ToolbarPage

class OIS275Tests extends BaseTest{
	LoginPage loginPage;
	HomePage homePage;
	OIS275B_1 OIS275b_1;
	OIS100H ois100h;
	OIS276B ois276b
	OIS101E ois101e
	ToolbarPage toolBarPage
	OIS300B ois300b
	
	@BeforeMethod
	def void Initialize() 
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		OIS275b_1=new OIS275B_1(driver);
		ois100h=new OIS100H(driver);
		ois276b=new OIS276B(driver)
		ois101e=new OIS101E(driver);
		toolBarPage =new ToolbarPage(driver);
		ois300b =new OIS300B(driver);	
		}
		
		@Test
	def void CustomerOrderReturn(){
		
		loginPage.GoTo();
		homePage.GoToOIS275();
		// check/release CO Number 
		//OIS275b_1.enterTemporaryOrdrNo();
		toolBarPage.clickRelated("Check/release");
		
		ois100h.FillTax("NOT");
		ois100h.ClickNext();
		ois276b.ClickPreviousPage;
		
		// check/release CO Number
		//OIS275b_1.EnterNo();
		toolBarPage.clickRelated("Check/release");
		
		//OIS276B page
		ois276b.Release();
		ois276b.ClickWarningOkButton();
		ois101e.clickNext();
		toolBarPage.ClickAction_Refresh();
		
		//Copy CoNumber
		var CONumber = ois276b.CopyCONumber();
		System.out.println("CO Number :"+CONumber)
		
		ois276b.closeAllTabs;
		
		//Go To OIS300
 		homePage.GoToOIS300();
		
		ois300b.searchCONumber(CONumber);
		
		//Set the sorting order to 1
 		ois300b.setSortingOrder("1-Order Number");
	}
}