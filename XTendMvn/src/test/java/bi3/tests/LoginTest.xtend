package bi3.tests

import bi3.pages.HomePage
import bi3.pages.LoginPage
import bi3.pages.mms001.MMS001
import bi3.pages.mms001.MMS001C
import bi3.pages.mms001.MMS001E
import bi3.pages.mms001.MMS001F
import bi3.pages.mms001.MMS001G
import bi3.pages.mms001.MMS001H
import bi3.pages.mms001.MMS001I
import bi3.pages.mms001.MMS001J
import bi3.pages.mms001.MMS001K
import bi3.pages.mms001.MMS001M
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import org.testng.Assert
import bi3.pages.mms001.MMS001ConnectWarehouse
import bi3.pages.mms001.MMS001ConnectWarehouseE
import bi3.pages.mms001.MMS001ConnectWarehouseF
import bi3.pages.mms001.MMS001ConnectWarehouseG
import bi3.pages.mms001.MMS001ConnectWarehouseH
import bi3.pages.mms001.MMS001ConnectWarehouseI
import bi3.pages.mms077.MMS077
import bi3.pages.mms077.MMS077_SelectMedia
import org.testng.annotations.BeforeMethod

class LoginTest extends BaseTest {

	LoginPage loginPage
	HomePage homePage
	MMS001 mms001
	MMS001C mms001C
	MMS001E mms001E
	MMS001F mms001F
	MMS001G mms001G
	MMS001H mms001H
	MMS001I mms001I
	MMS001J mms001J
	MMS001K mms001K
	MMS001M mms001M
	MMS001ConnectWarehouse mms001ConnectWarehouse
	MMS001ConnectWarehouseE connectWarehouseE
	MMS001ConnectWarehouseF connectWarehouseF
	MMS001ConnectWarehouseG connectWarehouseG
	MMS001ConnectWarehouseH connectWarehouseH
	MMS001ConnectWarehouseI connectWarehouseI
	MMS077 mms077
	MMS077_SelectMedia mms077_SelectMedia

	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		mms001 = new MMS001(driver);
		mms001C = new MMS001C(driver);
		mms001E = new MMS001E(driver);
		mms001F = new MMS001F(driver);
		mms001G = new MMS001G(driver);
		mms001H = new MMS001H(driver);
		mms001I = new MMS001I(driver);
		mms001J = new MMS001J(driver);
		mms001K = new MMS001K(driver);
		mms001M = new MMS001M(driver);
		mms001ConnectWarehouse = new MMS001ConnectWarehouse(driver)
		connectWarehouseE = new MMS001ConnectWarehouseE(driver)
		connectWarehouseF = new MMS001ConnectWarehouseF(driver)
		connectWarehouseG = new MMS001ConnectWarehouseG(driver)
		connectWarehouseH = new MMS001ConnectWarehouseH(driver)
		connectWarehouseI = new MMS001ConnectWarehouseI(driver)
		mms077  = new MMS077(driver);
		mms077_SelectMedia = new MMS077_SelectMedia (driver);
		
	}

	@Test
	def void Test1() {
		loginPage.GoTo();
		homePage.GoToMMS001();
		mms001.SearchByItemNumber("Y3001");
		mms001.CopyItem("Y3001");

		mms001C.Next();

		mms001E.SelectInvAccounting("1-Inv accounting");
		mms001E.SelectLotCtrlMethod("3-In lot master");
		mms001E.SelectLotNumbMethod("5-Auto order no");
		var newItemNumber = mms001E.GetItemNumber();

		mms001E.Next();
		mms001F.Next();

		mms001G.SelectSalesItem("1-Sales item");
		mms001G.Next();
		mms001H.Next();
		mms001I.Next();
		mms001J.Next();
		mms001K.Next();
		mms001M.Next();

		mms001.SearchByItemNumber(newItemNumber);
		//var aaa =mms001.GetItemNumberList();
		Assert.assertTrue(mms001.GetItemNumberList().contains(newItemNumber),
			"Item number" + newItemNumber + "is not found in the grid");
			
	}
	@Test
	def void Test2()
	{
		loginPage.GoTo()
		
		//Copying an item
		homePage.GoToMMS001()
		mms001.SearchByItemNumber("Y3001")
		mms001.CopyItem("Y3001")

		mms001C.Next()

		mms001E.SelectInvAccounting("1-Inv accounting")
		mms001E.SelectLotCtrlMethod("3-In lot master")
		mms001E.SelectLotNumbMethod("5-Auto order no")
		var newItemNumber = mms001E.GetItemNumber()

		mms001E.Next()
		mms001F.Next()

		mms001G.SelectSalesItem("1-Sales item")
		mms001G.Next()
		mms001H.Next()
		mms001I.Next()
		mms001J.Next()
		mms001K.Next()
		mms001M.Next()

		//var newItemNumber = "Y3222"
		mms001.SearchByItemNumber(newItemNumber);
		
		//Check if item is created.
		Assert.assertTrue(mms001.GetItemNumberList().contains(newItemNumber),"Item number" + newItemNumber + "is not found in the grid");		
		
		mms001.setItemWarehouse(newItemNumber);
		
		//Assert.assertEquals(mms001ConnectWarehouse.getpageTitle().contains("Item. Connect Warehouse"),"Did not reach the Connect Warehouse page.Actual value was "+mms001ConnectWarehouse.getpageTitle());		
		
		mms001ConnectWarehouse.changeWarehouse()
		
		Assert.assertTrue(connectWarehouseE.getPageSubTitle().contains("Planning Parameters"),"Did not reach the Main warehouse change page");
		
		
		connectWarehouseE.setMastrSchedule("0-Not mstr sch it")
		connectWarehouseE.setPlanningPolicy("A6")
		connectWarehouseE.setSupplyPolicy("A01")	
		connectWarehouseE.selectContNetChange()
		connectWarehouseE.clickNext()
		
		connectWarehouseF.clickNext()
		
		connectWarehouseG.untickCrossDock()
		connectWarehouseG.clickNext();
		
		connectWarehouseH.clickNext()
		connectWarehouseI.clickNext()
				
		System.out.println("Copied Item Number : "+newItemNumber)
		mms001ConnectWarehouse.close()   
		
		//Goto Home
		mms001I.GoToHome();
		
		//Go To MMS077
		homePage.GoToMMS077();
		mms077.CreateItemsByMatrix(newItemNumber);
		mms077.navigateToselectMedia();
		mms077_SelectMedia.ConfirmOutput();
		          
		Assert.assertEquals(mms077.ConfirmMsg(),"Job MMS078CL has been submitted");
		           
	}

}
