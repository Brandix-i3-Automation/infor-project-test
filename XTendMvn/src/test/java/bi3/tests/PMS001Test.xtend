package bi3.tests

import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import org.testng.Assert
import bi3.pages.LoginPage
import bi3.pages.HomePage
import bi3.pages.mms001.*
import bi3.pages.pds001.*
import bi3.pages.pms001.*
import bi3.pages.pms100.*
import org.testng.annotations.BeforeMethod

class PMS001Test extends BaseTest {
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
	MMS001L mms001L
	MMS001M mms001M
	MMS001ConnectWarehouse mms001ConnectWarehouse
	MMS001ConnectWarehouseE connectWarehouseE
	MMS001ConnectWarehouseF connectWarehouseF
	MMS001ConnectWarehouseG connectWarehouseG
	MMS001ConnectWarehouseH connectWarehouseH
	MMS001ConnectWarehouseI connectWarehouseI
	
	PDS001 pds001
	PDS001F pds001F
	PDS001ConnectMaterialOperation connectMaterialOperation;
	PDS001E pds001E
	PDS001ConnectOperations connectOperations
	
	PMS001 pms001
	PMS001E pms001E
	PMS001F pms001F
	
	PMS100 pms100
	
	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver)
		homePage = new HomePage(driver)
		mms001 = new MMS001(driver);
		mms001C = new MMS001C(driver);
		mms001E = new MMS001E(driver);
		mms001F = new MMS001F(driver);
		mms001G = new MMS001G(driver);
		mms001H = new MMS001H(driver);
		mms001I = new MMS001I(driver);
		mms001J = new MMS001J(driver);
		mms001K = new MMS001K(driver);
		mms001L = new MMS001L(driver);
		mms001M = new MMS001M(driver);
		mms001ConnectWarehouse = new MMS001ConnectWarehouse(driver)
		connectWarehouseE = new MMS001ConnectWarehouseE(driver)
		connectWarehouseF = new MMS001ConnectWarehouseF(driver)
		connectWarehouseG = new MMS001ConnectWarehouseG(driver)
		connectWarehouseH = new MMS001ConnectWarehouseH(driver)
		connectWarehouseI = new MMS001ConnectWarehouseI(driver)
		
		pds001 = new PDS001(driver)
		pds001F = new PDS001F(driver)
		connectMaterialOperation = new PDS001ConnectMaterialOperation(driver)
		pds001E = new PDS001E(driver)
		connectOperations = new PDS001ConnectOperations(driver)
	
		pms001 = new PMS001(driver)
		pms001E = new PMS001E(driver)
		pms001F= new PMS001F(driver)
	
		pms100 = new PMS100(driver)
	
	}	
	
	@Test
	def void CreateNewMO() {
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
		//mms001ConnectWarehouse.goToHome()
		
		//Create Raw Material
		mms001.SearchByItemNumber("Y7001");
		mms001.CopyItem("Y7001");
		
		mms001C.Next();

		mms001E.SelectInvAccounting("1-Inv accounting");
		mms001E.SelectLotCtrlMethod("3-In lot master");
		mms001E.SelectLotNumbMethod("5-Auto order no");
		var newRawMatNumber = mms001E.GetItemNumber();
		
		mms001E.Next();
		mms001F.Next();
		mms001G.Next();
		
		mms001H.setPurchasePrice("200")
		mms001H.Next();
		
		
		mms001I.Next();
		mms001J.Next();
		mms001K.Next();
		mms001L.Next();
		mms001M.Next();
		
		mms001.SearchByItemNumber(newRawMatNumber);
		//var aaa =mms001.GetItemNumberList();
		Assert.assertTrue(mms001.GetItemNumberList().contains(newRawMatNumber),"Item number" + newRawMatNumber + "is not found in the grid");
		System.out.println("Created raw material ID : "+newRawMatNumber)
		
		mms001.close()
		//mms001.goToHome()
		
		homePage.GoToPDS001()
		
		//Assert.assertEquals(pds001.getpageTitle().contains("Product Structure. Open"),"Did not reach the Product Structure page.Actual value was "+pds001.getpageTitle());
		
		pds001.FillItemNumber(newItemNumber,0)
		pds001.FillSerialNumber("001",0)
		pds001.FillFacility("A01",0)
		pds001.CreateProductStructure(0)
		
		pds001.clickNext()
		pds001.clickNext()
		
		
		pds001F.setM3Text("Creating product structure for item "+newItemNumber)
		
		connectMaterialOperation.setSno("10")
		connectMaterialOperation.setOperation("10")
		connectMaterialOperation.setComponent(newRawMatNumber)
		connectMaterialOperation. clickAddButton()
		
		pds001E.setQuantity("10")
		
		pds001.clickNext()
		pds001.clickNext()
		
		var lastAddedComponentId = connectMaterialOperation.getLastAddedComponentId()
		Assert.assertEquals(lastAddedComponentId,newRawMatNumber,"Actual value :"+lastAddedComponentId+" value expected is "+newItemNumber)
		
		connectMaterialOperation.clearTextSno()
		connectMaterialOperation.selectOperationFromLookUp("YACUT01")
		
		connectMaterialOperation. clickAddButton()
		
		connectOperations.setRuntime("10")
		
		pds001.clickNext()
		pds001.clickNext()
		
		
		lastAddedComponentId = connectMaterialOperation.getLastAddedComponentId()
		Assert.assertTrue(lastAddedComponentId.contains("YACUT01"),"Actual value :"+lastAddedComponentId+" value expected is YACUT01")	
		
		pds001.closeAllTabs()
		
		homePage.GoToPMS001()		
		
		pms001.setProductNo(newItemNumber)
		pms001.setStructureType("001")
		pms001.clickAddButton()
		
		pms001E.setOrderQuantity("100")
		
		//Date format to be inserted to the text box : YYMMDD
		pms001E.setFinishDate("170412")
		pms001E.setStartDate("170411")
		
		pms001E.clickNext()
		
		pms001F.selectSchedNoFromLookUp("12")
		pms001F.clickNext()
		
		pms001.searchForMOWithItemNo(newItemNumber)
		var firstGridItemText = pms001.getItemNumberOfFirstRecord()
		
		Assert.assertEquals(firstGridItemText,newItemNumber)
		
		pms001.closeAllTabs()
		 
		homePage.GoToPMS100()
		
		pms100.searchMOBy("12",newItemNumber)
		Assert.assertEquals(pms100.getScedNoOfRow1(),"12")
		Assert.assertEquals(pms100.getProdNoOfRow1(),newItemNumber)
	}
}