package bi3.tests

import bi3.pages.LoginPage
import bi3.pages.HomePage
import bi3.pages.ois300.OIS300
import bi3.pages.ois300.OIS300Availability
import bi3.pages.ois300.OIS300CutomerOrderOpenLines
import bi3.pages.ois300.OIS300MaterialPlan
import bi3.pages.ois300.OIS300PlannedPurchaseOrder
import org.testng.annotations.BeforeTest
import bi3.pages.ois300.OIS300SimulateForMaterial
import org.testng.annotations.Test
import org.testng.Assert
import bi3.pages.ois100.OIS100A
import bi3.pages.ois100.OIS100G
import bi3.pages.ois101.OIS101B1
import bi3.pages.ois101.OIS101E
import bi3.pages.crs207.CRS207_B
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
import bi3.pages.mms001.MMS001ItemFacilityE
import bi3.pages.mms001.MMS001ItemFacility
import bi3.pages.mms001.MMS001ItemFacilityF
import bi3.pages.pds001.PDS001
import bi3.pages.pds001.PDS001ConnectMaterialOperation
import bi3.pages.pds001.PDS001E
import bi3.pages.pds001.PDS001ConnectOperations
import bi3.pages.pds001.PDS001F
import bi3.pages.pps220.*
import bi3.pages.pps300.PPS300B
import bi3.pages.pps330.*
import bi3.pages.pps310.PPS310B1
import bi3.pages.pps310.PPS310E
import bi3.pages.pps320.PPS320B1
import bi3.pages.pps320.PPS320E

class POPTest extends BaseTest{
 	
 	HomePage homePage
 	LoginPage loginPage
 	OIS300 ois300
 	OIS300Availability ois300Availability
 	OIS300CutomerOrderOpenLines ois300CustomerOrderOpenLines
 	OIS300MaterialPlan ois300MaterialPlan
 	OIS300PlannedPurchaseOrder ois300PlannedPurchaseOrder
 	OIS300SimulateForMaterial ois300SimulateForMaterial
 	
 	OIS100A ois100A
 	OIS100G ois100G
 	OIS101B1 ois101B1
 	OIS101E ois101e
 	CRS207_B crs207B
 	
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
	
	PDS001 pds001
	PDS001F pds001F
	PDS001ConnectMaterialOperation connectMaterialOperation;
	PDS001E pds001E
	PDS001E pds002E
	PDS001ConnectOperations connectOperations
	
	PPS220B pps220b
	PPS220G1 pps220g1
	PPS220J1 pps220j1
	
	PPS300B pps300b
	
	PPS330B pps330b
	
	PPS310B1 pps310b1
	PPS310E pps310e
	
	PPS320B1 pps320b1
	PPS320E pps320e 
	
 	
 	@BeforeTest
 	def void Initialize()
 	{
 		homePage = new HomePage(driver)
 		loginPage = new LoginPage(driver)
 		ois300Availability = new OIS300Availability(driver)
 		ois300CustomerOrderOpenLines = new OIS300CutomerOrderOpenLines(driver)
 		ois300MaterialPlan = new OIS300MaterialPlan(driver)
 		ois300PlannedPurchaseOrder = new OIS300PlannedPurchaseOrder(driver)
 		ois300SimulateForMaterial = new OIS300SimulateForMaterial(driver)
 		ois300 = new OIS300(driver)
 		
 		ois100A = new OIS100A(driver)
 		ois100G = new OIS100G(driver)
 		ois101B1 = new OIS101B1(driver)
 		ois101e = new OIS101E(driver) 
 		crs207B = new CRS207_B(driver)
 		
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
		
		pds001 = new PDS001(driver)
		pds001F = new PDS001F(driver)
		connectMaterialOperation = new PDS001ConnectMaterialOperation(driver)
		pds001E = new PDS001E(driver)
		pds002E = new PDS001E(driver)
		connectOperations = new PDS001ConnectOperations(driver)
		
		pps220b = new PPS220B(driver)
		pps220g1 = new PPS220G1(driver)
		pps220j1 = new PPS220J1(driver)
		
		pps300b = new PPS300B(driver)
		
		pps330b = new PPS330B(driver)
		
		pps310b1 = new PPS310B1(driver)
		pps310e = new PPS310E(driver)
		
		pps320b1 = new PPS320B1(driver)
		pps320e = new PPS320E(driver)
 	}
 	@Test
 	def void ProductOrderProposal()
 	{
 			loginPage.GoTo()
		
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
		mms001.SearchByItemNumber(newItemNumber);		
		Assert.assertTrue(mms001.GetItemNumberList().contains(newItemNumber),"Item number" + newItemNumber + "is not found in the grid"); //Check if item is created.		
				
		// Set Item Warehouse Information		
		mms001.setItemWarehouse(newItemNumber);		
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
		Assert.assertTrue(mms001.GetItemNumberList().contains(newRawMatNumber),"Item number" + newRawMatNumber + "is not found in the grid");
		System.out.println(newRawMatNumber)		
		mms001.close()
				
		// Creating SKUs using MMS077 ----------------------------------------------
		mms001.goToHome();
		homePage.GoToMMS077();
		mms077.CreateItemsByMatrix(newItemNumber);
		mms077.navigateToselectMedia();
		mms077_SelectMedia.ConfirmOutput();		          
		Assert.assertEquals(mms077.ConfirmMsg(),"Job MMS078CL has been submitted");	
		
		// Create SKU for Raw Material(Fabric)
		mms077.CreateItemsByMatrix(newRawMatNumber);
		mms077.navigateToselectMedia();
		mms077_SelectMedia.ConfirmOutput();		          
		Assert.assertEquals(mms077.ConfirmMsg(),"Job MMS078CL has been submitted");			
		
		// Go to MMS001 and make sure All SKUs have the status 20. If not update the status to 20 manually.
		mms077.closeAllTabs();
		mms077.goToHome();
		homePage.GoToMMS001();
		mms001.SearchByItemNumber(newItemNumber);		
		var itemData = mms001.getDataOfItem(newItemNumber);
		Assert.assertEquals(itemData.get(3),"20-Released", "Finished Good item status is not 20-Released");	
		
		mms001.SearchByItemNumber(newRawMatNumber);		
		var rawItemData = mms001.getDataOfItem(newRawMatNumber);
		Assert.assertEquals(rawItemData.get(3),"20-Released", "Raw Material item status is not 20-Released");
		
		mms001.EditItem(newRawMatNumber);
		mms001E.setStatus("20-Released");
		mms001E.Next();
		mms001E.closeAllTabs();
		mms001E.goToHome();
		homePage.GoToMMS001();
		
		mms001.SearchByItemNumber(newRawMatNumber);
		var rawItemData_sku1 = mms001.getDataOfItem(newRawMatNumber + "-Y01");
		Assert.assertEquals(rawItemData_sku1.get(3), "20-Released", "Raw Material item status is not 20-Released");
				
		// Create Product Structure----------------------------------------------
		mms001E.closeAllTabs();
		mms001E.goToHome();	
		homePage.GoToPDS001();	
		//Assert.assertEquals(pds001.getpageTitle().contains("Product Structure. Open"),"Did not reach the Product Structure page.Actual value was "+pds001.getpageTitle());
		
		pds001.SearchByItemNumber(newItemNumber);
		
		pds001.goToMaterialAndOperations(newItemNumber);
		
		
		connectMaterialOperation.setSno("10");
		connectMaterialOperation.setOperation("10");
		connectMaterialOperation.setComponent(newRawMatNumber);
		connectMaterialOperation.clickAddButton();		
		pds002E.setQuantity("10"); // This should be PDS002E
		
		pds001.clickNext();
		pds001.clickNext();
		
		var lastAddedComponentId = connectMaterialOperation.getLastAddedComponentId();
		Assert.assertEquals(lastAddedComponentId,newRawMatNumber,"Actual value :"+ lastAddedComponentId +" value expected is " + newItemNumber);
		
		connectMaterialOperation.clearTextSno();
		connectMaterialOperation.selectOperationFromLookUp("YACUT01");
		connectMaterialOperation. clickAddButton();	
		connectOperations.setRuntime("10");
		
		pds001.clickNext();
		pds001.clickNext();
		
		lastAddedComponentId = connectMaterialOperation.getLastAddedComponentId();
		Assert.assertTrue(lastAddedComponentId.contains("YACUT01"),"Actual value :" + lastAddedComponentId +" value expected is YACUT01");
		
		println("-----Item Number: " + newItemNumber);
		println("-----Raw Material Number: " + newRawMatNumber);	          		
		        		
		// Release the Raw Matirial Item (Fabric) to Status 20-Released
		connectMaterialOperation.close();
		pds001.SearchByItemNumber(newRawMatNumber);
		pds001.EditItem(newRawMatNumber);
		pds001E.setStatus("20-Released");
		pds001E.Next();
		pds001E.closeAllTabs();
		pds001E.goToHome();
		homePage.GoToPDS001()
		
		pds001.SearchByItemNumber(newRawMatNumber);
		var psData_sku1 = pds001.getDataOfItem(newRawMatNumber + "-Y01");
		Assert.assertEquals(psData_sku1.get(7), "20-Released", "Product Structure SKU item status is not 20-Released");
		
		//Customer Order Creation
		//-----------------------------------------------------------------
		//-----------------------------------------------------------------
		pds001.closeAllTabs();
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
		ois101B1.fillOrderLine( newItemNumber,"30");
		crs207B.fillMatrix("10");
		
		crs207B.clickNext();
		
		
		//Enter price for Black item
		crs207B.handleAbnormalException();
		ois101e.fillPricingInformation("350","200");

		var CONumber = ois101B1.getTheCONumber();
		
		//Close ALl Tabs
		ois300.closeAllTabs();
 		
 		//Go To OIS300
 		homePage.GoToOIS300();
 		
 		//Set the sorting order to 1
 		ois300.setSortingOrder("1-Order Number")
 		
 		//Search CO Number
 		ois300.searchCONumber(CONumber)
 		
 		//Go To Order Lines
 		ois300.goToOrderLines();
 		
 		//Go To Sim comp Avail
 		ois300CustomerOrderOpenLines.goToSimCopAvail();
 		
 		//Go To Material Plans
 		ois300SimulateForMaterial.goToMaterialPlan();
 		
 		//Calculate the MRP
 		ois300MaterialPlan.calculateMRP();
 		
 		ois300MaterialPlan.searchForStat("250")
 		val orderNumber = ois300MaterialPlan.getTheOrderNumber("250");
 		//Go To Planned Purchase Order
 		ois300MaterialPlan.changeMaterialPlan(orderNumber);
 		
 		//Set status to 60
 		ois300PlannedPurchaseOrder.setStatus("60-Released");
 		ois300PlannedPurchaseOrder.Next();
 		ois300PlannedPurchaseOrder.Next();
 		ois300PlannedPurchaseOrder.Next();
 		
 		//Remove the buyer
 		ois300PlannedPurchaseOrder.clearBuyerFrom();
 		ois300PlannedPurchaseOrder.clearBuyerTo();
 		ois300PlannedPurchaseOrder.Next();
 		
 		//Refresh the grid
 		ois300MaterialPlan.refreshTheGrid();
 		ois300MaterialPlan.refreshTheGrid();
 		
 		//Verify
 		Assert.assertTrue(ois300MaterialPlan.isGridEmpty());
 		
 		//------------------------------
 		//------------------------------
 		//Addtional steps required after POP and before MOP
 		ois300MaterialPlan.searchForStat("251")
 		var newPONum = ois300MaterialPlan.getTheOrderNumber("251")
 		
 		ois300MaterialPlan.closeAllTabs()
 		
 		homePage.GoToPPS220()
 		
 		pps220b.searchPONumber(newPONum)
 		pps220b.confirmOrder(newPONum)
 	
 		Assert.assertEquals(pps220g1.getPONumberOfRow(0),newPONum)
 		pps220g1.selectAction("Confirm Update")
 		System.out.println("Confirmed the order")
 		
 		pps220b.searchPONumber(newPONum)
 		pps220b.goodsReceipt(newPONum)
 		
 		Assert.assertEquals(pps220j1.getPONumberOfRow(0),newPONum) 		
 		pps220j1.selectAction("Confirm Update")
 		System.out.println("Goods reciept completed")
 		
 		pps220b.closeAllTabs() 	 		
 		
 		homePage.GoToPPS300()
 		 		
 		pps300b.enterPONum(newPONum)
 		pps300b.clickApply()
 		
 		pps300b.closeAllTabs()
 		
 		homePage.GoToPPS330()
 		
 		pps330b.searchPONum(newPONum)
 		var recievingNo = pps330b.getRecievingNoOf(newPONum)
 		System.out.println("Recieving number : "+recievingNo)
 		
 		pps330b.closeAllTabs()
 		
 		homePage.GoToPPS310()
 		
 		pps310b1.enterTheRecivingNo(recievingNo)
 		pps310b1.clickApply()
 		pps310b1.editFirstRecord()
 		
 		//Approved quantity is as same as the recieved quantity
 		pps310e.enterApprovedQty()
 		pps310e.Next()
 		
 		pps310b1.closeAllTabs()
 		
 		homePage.GoToPPS320()
 		
 		pps320b1.enterTheRecivingNo(recievingNo)
 		pps320b1.clickApply()
 		pps320b1.editFirstRow()
 		//Stored qty is as same as the apprived qty
 		pps320e.enterStoredQty()
 		pps320e.Next()
 		
 		pps320b1.closeAllTabs()
 		
 		homePage.GoToPPS330()
 		
 		pps330b.searchPONum(newPONum)
 		Assert.assertTrue(pps330b.checkStatus75ForPO(newPONum),"Status 75 was not found for PO number "+newPONum) 		
 		
 	}
 	
}