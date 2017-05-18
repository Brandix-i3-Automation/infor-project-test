package bi3.tests

import bi3.pages.HomePage
import bi3.pages.LoginPage
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import bi3.pages.pds001.PDS001
import bi3.pages.pds001.PDS001ConnectMaterialOperation

import bi3.pages.pds001.PDS001E
import bi3.pages.pds001.PDS001F
import bi3.pages.pds001.PDS003B
import bi3.pages.pds001.PDS003E
import org.testng.annotations.BeforeMethod
import bi3.infor.templates.ItemCreationTemplate
import bi3.infor.templates.dto.ItemTemplate
import bi3.pages.mms001.MMS001
import bi3.pages.mms001.MMS001C
import bi3.pages.mms001.MMS001E
import bi3.pages.mms001.MMS001F
import bi3.pages.mms001.MMS001G
import bi3.pages.mms001.MMS001H
import bi3.pages.mms001.MMS001I
import bi3.pages.mms001.MMS001J
import bi3.pages.mms001.MMS001K
import bi3.pages.mms001.MMS001L
import bi3.pages.mms001.MMS001M
import bi3.pages.mms077.MMS077
import bi3.pages.mms077.MMS077_SelectMedia
import bi3.pages.mms001.MMS001ConnectWarehouse
import bi3.pages.mms001.MMS001ConnectWarehouseE
import bi3.pages.mms001.MMS001ConnectWarehouseF
import bi3.pages.mms001.MMS001ConnectWarehouseG
import bi3.pages.mms001.MMS001ConnectWarehouseH
import bi3.pages.mms001.MMS001ConnectWarehouseI
import bi3.pages.mms001.MMS001ItemFacility
import bi3.pages.mms001.MMS001ItemFacilityE
import bi3.pages.mms001.MMS001ItemFacilityF
import bi3.pages.pds001.PDS001ConnectOperations
import bi3.pages.ToolbarPage

class OptionConnectLineTest extends BaseTest {

	HomePage homePage	
	LoginPage loginPage
	PDS001 pds001	
	PDS001ConnectMaterialOperation pds001ConnectMaterialOperation
	ToolbarPage toolbarPage
	PDS001E pds001E
	PDS001F pds001F
	PDS003B pds003B
	PDS003E pds003E
	PDS001E pds002E
	
	ItemCreationTemplate ItemCreationTemplate
	ItemTemplate ItemTemplate
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
	MMS077 mms077
	MMS077_SelectMedia mms077_SelectMedia
	MMS001ConnectWarehouse mms001ConnectWarehouse
	MMS001ConnectWarehouseE connectWarehouseE
	MMS001ConnectWarehouseF connectWarehouseF
	MMS001ConnectWarehouseG connectWarehouseG
	MMS001ConnectWarehouseH connectWarehouseH
	MMS001ConnectWarehouseI connectWarehouseI
	MMS001ItemFacility itemFacility
	MMS001ItemFacilityE itemFacilityE
	MMS001ItemFacilityF itemFacilityF
	
	PDS001ConnectOperations connectOperations
	
	@BeforeMethod
	def void Initialize()
	{
		homePage = new HomePage(driver)
		loginPage = new LoginPage(driver)
		pds001 = new PDS001(driver)
		pds001ConnectMaterialOperation = new PDS001ConnectMaterialOperation(driver)
		toolbarPage = new ToolbarPage(driver)
		pds001E = new PDS001E(driver)
		pds001F = new PDS001F(driver)
		pds003B = new PDS003B(driver)
		pds003E = new PDS003E(driver)
		connectOperations = new PDS001ConnectOperations(driver)
		pds002E = new PDS001E(driver)
		
		ItemCreationTemplate =  new ItemCreationTemplate(driver);
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
		mms077 = new MMS077(driver);
		mms077_SelectMedia = new MMS077_SelectMedia(driver);
		mms001ConnectWarehouse = new MMS001ConnectWarehouse(driver)
		connectWarehouseE = new MMS001ConnectWarehouseE(driver)
		connectWarehouseF = new MMS001ConnectWarehouseF(driver)
		connectWarehouseG = new MMS001ConnectWarehouseG(driver)
		connectWarehouseH = new MMS001ConnectWarehouseH(driver)
		connectWarehouseI = new MMS001ConnectWarehouseI(driver)
		itemFacility = new MMS001ItemFacility(driver);
		itemFacilityE = new MMS001ItemFacilityE(driver);
		itemFacilityF = new MMS001ItemFacilityF(driver);
		
	}
	@Test
	def void optionConnectTest()
	{
		//Login
		loginPage.GoTo();
		
		homePage.GoToMMS001()
		// uses item template to crete a item 
	    ItemTemplate =  new ItemTemplate();	
	    ItemTemplate = ItemCreationTemplate.createItem("Y3001");
		
		//var new1 = ItemTemplate.methodExecutionStatus;
		var newItemNumber =  ItemTemplate.itemCode;
		
	    
		// Set Item Warehouse Information		
		mms001.setItemWarehouse(newItemNumber);		
		mms001ConnectWarehouse.changeWarehouse()		
		
				
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
		System.out.println("Copied Item Number : "+ newItemNumber)
		mms001ConnectWarehouse.close()
		
		// TODO: Set Item Facility
		mms001.setItemFacility(newItemNumber)		
		itemFacility.selectChnage();
		itemFacilityE.selectInvAccMethod("1-Standard cost")
		itemFacilityE.clickNext();
		itemFacilityF.clickNext();
		mms001.close;
		mms001.close;
		mms001.closeAllTabs();
		mms001.goToHome();

		// Create Raw Material-----------------------------------------------------
		homePage.GoToMMS001();
		mms001.SearchByItemNumber("Y7005");
		mms001.CopyItem("Y7005");
		
		mms001C.Next();
		mms001E.SelectInvAccounting("1-Inv accounting");
		mms001E.SelectLotCtrlMethod("3-In lot master");
		mms001E.SelectLotNumbMethod("3-Auto, seq no");
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
		
		System.out.println(newRawMatNumber)		
		mms001.close()
				
		// Creating SKUs using MMS077 ----------------------------------------------
		mms001.goToHome();
		homePage.GoToMMS077();
		mms077.CreateItemsByMatrix(newItemNumber);
		mms077.navigateToselectMedia();
		mms077_SelectMedia.ConfirmOutput();		          
		
		
		// Create SKU for Raw Material(Fabric)
		mms077.CreateItemsByMatrix(newRawMatNumber);
		mms077.navigateToselectMedia();
		mms077_SelectMedia.ConfirmOutput();		          
			
		
		// Go to MMS001 and make sure All SKUs have the status 20. If not update the status to 20 manually.
		mms077.closeAllTabs();
		mms077.goToHome();
		homePage.GoToMMS001();
		mms001.SearchByItemNumber(newItemNumber);		
		var itemData = mms001.getDataOfItem(newItemNumber);
		
		
		mms001.SearchByItemNumber(newRawMatNumber);		
		
		
		mms001.EditItem(newRawMatNumber);
		mms001E.setStatus("20-Released");
		mms001E.Next();
		mms001E.closeAllTabs();
		mms001E.goToHome();
		homePage.GoToMMS001();
		
		mms001.SearchByItemNumber(newRawMatNumber);
		
				
		// Create Product Structure----------------------------------------------
		mms001E.closeAllTabs();
		mms001E.goToHome();	
		homePage.GoToPDS001();	
		//Assert.assertEquals(pds001.getpageTitle().contains("Product Structure. Open"),"Did not reach the Product Structure page.Actual value was "+pds001.getpageTitle());
		
		pds001.SearchByItemNumber(newItemNumber);
		pds001.goToMaterialAndOperations(newItemNumber);
					
		pds001ConnectMaterialOperation.setSno("10");
		pds001ConnectMaterialOperation.setOperation("10");
		pds001ConnectMaterialOperation.setComponent(newRawMatNumber);
		pds001ConnectMaterialOperation.clickAddButton();		
		pds002E.setQuantity("10"); // This should be PDS002E
		
		pds001.clickNext();
		pds001.clickNext();
		
		var lastAddedComponentId = pds001ConnectMaterialOperation.getLastAddedComponentId();
		
		pds001ConnectMaterialOperation.clearTextSno();
		pds001ConnectMaterialOperation.selectOperationFromLookUp("YACUT01");
		pds001ConnectMaterialOperation. clickAddButton();	
		connectOperations.setRuntime("10");
		
		pds001.clickNext();
		pds001.clickNext();
		
		lastAddedComponentId = pds001ConnectMaterialOperation.getLastAddedComponentId();
		//Assert.assertTrue(lastAddedComponentId.contains("YACUT01"),"Actual value :" + lastAddedComponentId +" value expected is YACUT01");
		
		println("-----Item Number: " + newItemNumber);
		println("-----Raw Material Number: " + newRawMatNumber);	          		
		        		
		// Release the Raw Matirial Item (Fabric) to Status 20-Released
		pds001ConnectMaterialOperation.close();
		pds001.SearchByItemNumber(newRawMatNumber);
		pds001.EditItem(newRawMatNumber);
		pds001E.setStatus("20-Released");
		pds001E.Next();
		pds001E.closeAllTabs();
		
		//Navigate to PDS001
		homePage.GoToPDS001();
		
		//Search Item NUmber
		pds001.SearchByItemNumber(newItemNumber);
		
		//Navigate to Material and operation
		pds001.goToMaterialAndOperations("Y3645");
		
		//Create new sqno
		pds001ConnectMaterialOperation.setSno("25");
		
		//Set new op
		pds001ConnectMaterialOperation.setOperation("20");
		
		//Add new button
		pds001ConnectMaterialOperation.setComponent("Y80012");
		
		//Create 
		toolbarPage.clickCreateLogo();
		
		//Set quantity
		pds001E.setQuantity("1");
		
		//Navigate to PDS001F
		pds001E.Next();
		
		pds001F.Next();
		
		//Refresh the page
		toolbarPage.ClickAction_Refresh();
		
		//Set Operation
		pds001ConnectMaterialOperation.selectOperation("Y80012");
		
		//Set Stp
		pds003B.setstp("3");
		
		//Set Selection ID
		pds003B.setSelectId("XY01");
		
		//Set Option
		pds003B.setOption("X016");
		
		//Create 
		toolbarPage.clickCreateLogo();
		
		//Select Include
		pds003E.selectFromInclExcl("1-Include");
		
		pds003E.clickNext();
		
		pds003E.closeAllTabs();
		
		//Navigate to PDS001
		homePage.GoToPDS001();
		
		//Search Item Number
		pds001.SearchByItemNumber(newItemNumber);
		
		
		
	}
	
	
}