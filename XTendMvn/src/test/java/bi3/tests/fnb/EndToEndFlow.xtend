package bi3.tests.fnb

import bi3.tests.BaseTest
import bi3.pages.LoginPage
import bi3.pages.HomePage
import bi3.pages.mms001.MMS001
import bi3.pages.mms001.MMS001C
import bi3.pages.mms001.MMS001E
import bi3.pages.mms001.MMS001F
import bi3.pages.mms001.MMS001G
import bi3.pages.mms001.MMS001H
import bi3.pages.mms001.MMS001J
import bi3.pages.mms001.MMS001I
import bi3.pages.mms001.MMS001K
import bi3.pages.mms001.MMS001L
import bi3.pages.mms001.MMS001M
import bi3.pages.mms077.MMS077
import bi3.pages.mms077.MMS077_SelectMedia
import bi3.pages.mms001.MMS001ConnectWarehouseE
import bi3.pages.mms001.MMS001ConnectWarehouse
import bi3.pages.mms001.MMS001ConnectWarehouseG
import bi3.pages.mms001.MMS001ConnectWarehouseF
import bi3.pages.mms001.MMS001ConnectWarehouseH
import bi3.pages.mms001.MMS001ConnectWarehouseI
import bi3.pages.mms001.MMS001ItemFacility
import bi3.pages.mms001.MMS001ItemFacilityE
import bi3.pages.mms001.MMS001ItemFacilityF
import bi3.pages.pds001.PDS001
import bi3.pages.pds001.PDS001F
import bi3.pages.pds001.PDS001E
import bi3.pages.pds001.PDS001ConnectMaterialOperation
import bi3.pages.pds001.PDS001ConnectOperations
import bi3.pages.ois100.OIS100A
import bi3.pages.ois100.OIS100G
import bi3.pages.ois101.OIS101B1
import bi3.pages.pds001.PDS600E
import bi3.pages.ois101.OIS101E
import bi3.pages.crs207.CRS207_B
import org.testng.annotations.Test
import org.testng.Assert
import bi3.pages.ois300.OIS300
import bi3.pages.ois300.OIS300CutomerOrderOpenLines
import bi3.pages.ois300.OIS300Availability
import bi3.pages.ois300.OIS300MaterialPlan
import bi3.pages.ois300.OIS300PlannedPurchaseOrder
import bi3.pages.ois300.OIS300SimulateForMaterial
import bi3.pages.pms170.PMS170
import bi3.pages.pms170.PMS170A
import bi3.pages.pms170.PMS170E
import bi3.pages.pms170.PMS170B
import bi3.pages.pms100.PMS100_B
import bi3.pages.pps220.PPS220B
import bi3.pages.pps220.PPS220G1
import bi3.pages.pps220.PPS220J1
import bi3.pages.pps300.PPS300B
import bi3.pages.pps330.PPS330B
import bi3.pages.pps310.PPS310B1
import bi3.pages.pps310.PPS310E
import bi3.pages.pps320.PPS320B1
import bi3.pages.pps320.PPS320E
import bi3.pages.mws410.MWS410B
import org.testng.annotations.BeforeMethod
import bi3.pages.pms070.*
import bi3.pages.pms050.PMS050A
import bi3.pages.pms050.PMS050B1
import bi3.pages.mws460.MWS460B
import bi3.pages.mws060.MWS060B
import org.eclipse.xtend.lib.annotations.Accessors
import bi3.pages.mws420.MWS420B
import bi3.pages.mws410.MWS410E
import bi3.pages.mws410.MWS410I
import bi3.configuration.settings.MMS001SettingsTest
import bi3.configuration.settings.PDS001SettingsTest
import bi3.configuration.settings.PMS001SettingsTest
import bi3.configuration.settings.OIS101SettingsTest
import bi3.pages.ois100.OIS100FANDB
import bi3.pages.ois100.OIS100H
import bi3.pages.mms080.MMS080B1
import java.util.List
import bi3.pages.pps600.PPS600E
import bi3.pages.pps600.PPS600F
import bi3.pages.pps600.PPS600SelectMedia
import bi3.pages.pps250.PPS250B1
import bi3.pages.pps270.PPS270B1
import bi3.pages.pps270.PPS270E
import bi3.pages.pps300.PPS300E
import bi3.pages.pcs200.PCS200E
import bi3.pages.pcs200.PCS200F
import bi3.pages.mms002.MMS002B
import bi3.pages.mms002.MMS002G
import bi3.pages.mms002.MMS002I
import bi3.pages.mms002.MMS002E
import bi3.pages.mms002.MMS002F
import bi3.pages.mms002.MMS002H
import bi3.pages.pps170.PPS170B

class EndToEndFlow extends BaseTest {

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

	OIS100A ois100A
	OIS100G ois100G
	OIS101B1 ois101B1
	PDS600E pds600E
	OIS101E ois101e
	CRS207_B crs207B
	OIS100H ois100H

	OIS300 ois300
	OIS300Availability ois300Availability
	OIS300CutomerOrderOpenLines ois300CustomerOrderOpenLines
	OIS300MaterialPlan ois300MaterialPlan
	OIS300PlannedPurchaseOrder ois300PlannedPurchaseOrder
	OIS300SimulateForMaterial ois300SimulateForMaterial

	PMS170 pms170
	PMS170A pms170a
	PMS170E pms170e
	PMS170B pms170b
	PMS100_B pms100_b

	PPS220B pps220b
	PPS220G1 pps220g1
	PPS220J1 pps220j1

	PPS300B pps300b
	PPS300E pps300e
	PPS330B pps330b
	PPS310B1 pps310b1
	PPS310E pps310e
	PPS320B1 pps320b1
	PPS320E pps320e

	MWS410B mws410b
	PMS070A pms070a
	PMS070B1 pms070b1
	PMS070E pms070e
	PMS050A pms050a
	PMS050B1 pms050b1
	MWS060B mws060b
	MWS460B mws460b

	MWS420B mws420b

	MWS410E mws410e
	MWS410I mws410i

	MMS001SettingsTest mms001SettingsTest
	PDS001SettingsTest pds001SettingsTest
	PMS001SettingsTest pms001SettingsTest
	OIS101SettingsTest ois101SettingsTest

	OIS100FANDB OIS100FANDB
	MMS080B1 mms080b1

	PPS220B pps220B
	PPS600E pps600E
	PPS600F pps600F
	PPS600SelectMedia pps600SelectMedia

	PPS250B1 pps250B1

	PPS270B1 pps270B1
	PPS270E pps270E

	PCS200E pcs200e
	PCS200F pcs200f

	MMS002B mms002b
	MMS002G mms002g
	MMS002I mms002i
	MMS002E mms002e
	MMS002F mms002f
	MMS002H mms002h
	PPS170B pps170b

	EndToEndMadeToOrderTest EndToEndMadeToOrderTest

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
		mms077 = new MMS077(driver);
		pps170b = new PPS170B(driver);

		mms002b = new MMS002B(driver);
		mms002g = new MMS002G(driver);
		mms002i = new MMS002I(driver);
		mms002e = new MMS002E(driver);

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

		ois100A = new OIS100A(driver);
		ois100G = new OIS100G(driver);
		ois101B1 = new OIS101B1(driver);
		pds600E = new PDS600E(driver);
		ois101e = new OIS101E(driver);
		crs207B = new CRS207_B(driver);
		ois100H = new OIS100H(driver);

		ois300Availability = new OIS300Availability(driver)
		ois300CustomerOrderOpenLines = new OIS300CutomerOrderOpenLines(driver)
		ois300MaterialPlan = new OIS300MaterialPlan(driver)
		ois300PlannedPurchaseOrder = new OIS300PlannedPurchaseOrder(driver)
		ois300SimulateForMaterial = new OIS300SimulateForMaterial(driver)
		ois300 = new OIS300(driver)

		pps220b = new PPS220B(driver)
		pps220g1 = new PPS220G1(driver)
		pps220j1 = new PPS220J1(driver)

		pps300b = new PPS300B(driver)
		pps300e = new PPS300E(driver)
		pps330b = new PPS330B(driver)
		pps310b1 = new PPS310B1(driver)
		pps310e = new PPS310E(driver)
		pps320b1 = new PPS320B1(driver)
		pps320e = new PPS320E(driver)

		pms170 = new PMS170(driver);
		pms170a = new PMS170A(driver);
		pms170e = new PMS170E(driver);
		pms170b = new PMS170B(driver);
		pms100_b = new PMS100_B(driver);

		mws410b = new MWS410B(driver)
		pms070a = new PMS070A(driver)
		pms070b1 = new PMS070B1(driver)
		pms070e = new PMS070E(driver)

		pms050a = new PMS050A(driver)
		pms050b1 = new PMS050B1(driver)
		mws060b = new MWS060B(driver)
		mws460b = new MWS460B(driver)

		mws420b = new MWS420B(driver)
		mws410e = new MWS410E(driver)
		mws410i = new MWS410I(driver)
		mms080b1 = new MMS080B1(driver)
		mms002f = new MMS002F(driver);
		mms002h = new MMS002H(driver);

		mms001SettingsTest = new MMS001SettingsTest(driver);
		pds001SettingsTest = new PDS001SettingsTest(driver);
		pms001SettingsTest = new PMS001SettingsTest(driver);
		ois101SettingsTest = new OIS101SettingsTest(driver);

		pps220B = new PPS220B(driver);

		pps600E = new PPS600E(driver);
		pps600F = new PPS600F(driver);
		pps600SelectMedia = new PPS600SelectMedia(driver);

		pps250B1 = new PPS250B1(driver);

		pps270B1 = new PPS270B1(driver);
		pps270E = new PPS270E(driver);

		pcs200e = new PCS200E(driver);
		pcs200f = new PCS200F(driver);
		EndToEndMadeToOrderTest = new EndToEndMadeToOrderTest(driver);
	}

	@Test
	def void FullFlow() {
		// mms001 user settings
		// mms001SettingsTest.updateItemsSetting("2-Always update");
		var String finishedGoodTemplateItemNo = "DSTK01";
		var String rawMaterialTemplateItemNo = "DRM001";
		var String warehouse2Id = "001";

		// Copy Finished Good
		var newItemNumber = this.copyFinishedGoodItem(finishedGoodTemplateItemNo);
		System.out.println("copyFinishedGoodItem Finished");
		// Create Raw Material
		var newRawMatNumber = this.copyRawMaterialItem(rawMaterialTemplateItemNo);
		System.out.println("copyRawMaterialItem Finished");
		// Create SKUs using MMS077
		// this.createSku(newItemNumber,newRawMatNumber);
		// pds001 settings page
		// pds001SettingsTest.updateProductVariantSetting("2-Always update")		
		// Create Product Structure
		this.createProductStructure(newItemNumber, newRawMatNumber);
		System.out.println("createProductStructure Finished");

		var createCustomerOrder = this.createCustomerOrder(newItemNumber);

		this.runMRPCheckStatus(newRawMatNumber, warehouse2Id, newItemNumber);

		this.checkPopExist(newRawMatNumber, warehouse2Id);

		var PoNumber = this.poCreation(createCustomerOrder, newRawMatNumber);

		var moDto1 = EndToEndMadeToOrderTest.MOPVerification("001", newItemNumber);
		

	}

	def void checkPopExist(String newRawMatNumber, String warehouse2Id) {

		mms080b1.closeAllTabs();
		homePage.goToHome();
		homePage.GoToPPS170();
		pps170b.setFilterOptions("1-Buy,Sup,Whs,Ite", "");
		pps170b.fillTableHeaderInformation("FABPLANNER", "Y50001", warehouse2Id, newRawMatNumber)
		var List<String> itemList = pps170b.getItemNumberFromGrid();
		Assert.assertEquals(itemList.get(0), newRawMatNumber, "Item Number Not In PPS170");

	}

	def void runMRPCheckStatus(String newRawMatNumber, String warehouse2Id, String newItemNumber) {

		ois101B1.closeAllTabs();

		homePage.goToHome();

		homePage.GoToMMS080();

		mms080b1.setHeaderDetails(newItemNumber, "");

		mms080b1.setHeaderDetails(newRawMatNumber, warehouse2Id);
		mms080b1.calculateMRPAndRefreshPage();
		var List<String> dataList = mms080b1.getFnbDetailsFromGrid();
		Assert.assertEquals(dataList.get(1), "250", "Oct is not 250");

	}

	def String copyFinishedGoodItem(String templateItemNumber) {
		loginPage.GoTo()

		homePage.GoToMMS001()
		mms001.SearchByItemNumber(templateItemNumber)
		mms001.CopyItem(templateItemNumber)

		mms001C.Next()
//		mms001E.SelectInvAccounting("1-Inv accounting")
//		mms001E.SelectLotCtrlMethod("3-In lot master")
//		mms001E.SelectLotNumbMethod("5-Auto order no")
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
		Assert.assertTrue(mms001.GetItemNumberList().contains(newItemNumber), "Item number" + newItemNumber +
			"is not found in the grid"); // Check if item is created.		
		System.out.println("Set Item Warehouse Information");
		// Set Item Warehouse Information		
		mms001.setItemWarehouse(newItemNumber);
		mms001ConnectWarehouse.changeWarehouse()
		Assert.assertTrue(connectWarehouseE.getPageSubTitle().contains("Planning Parameters"),
			"Did not reach the Main warehouse change page");

//		connectWarehouseE.setMastrSchedule("0-Not mstr sch it")
//		connectWarehouseE.setPlanningPolicy("A6")
//		connectWarehouseE.setSupplyPolicy("A01")	
		connectWarehouseE.selectContNetChange()
		connectWarehouseE.clickNext()
		connectWarehouseF.clickNext()
		connectWarehouseG.untickCrossDock()
		connectWarehouseG.clickNext();
		connectWarehouseH.clickNext()
		connectWarehouseI.clickNext()
		System.out.println("Copied Item Number : " + newItemNumber)
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
		println("New Item Number " + newItemNumber)
		return newItemNumber;

	}

	def String copyRawMaterialItem(String templateItemNumber) {
		homePage.GoToMMS001();
		mms001.SearchByItemNumber(templateItemNumber);
		mms001.CopyItem(templateItemNumber);
//		mms001.clearItemInsertNewNo(templateItemNumber2);		Thread.sleep(1000);
		mms001C.Next();
//		mms001E.SelectInvAccounting("1-Inv accounting");
//		mms001E.SelectLotCtrlMethod("3-In lot master");
//		mms001E.SelectLotNumbMethod("3-Auto, seq no");
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
		Assert.assertTrue(mms001.GetItemNumberList().contains(newRawMatNumber), "Item number" + newRawMatNumber +
			"is not found in the grid");
		System.out.println(newRawMatNumber)
		mms001.close()

		loginPage.GoTo()
		homePage.GoToMMS002();
		System.out.println("GO to MMS002")
		mms002b.enterItemNumber(newRawMatNumber);
		mms002b.selectChange();
		// mms002b.clickNext();
		mms002e.checkContNetChange();
		mms002e.clickNext();
		mms002f.clickNext();
		mms002g.clickNext();
		mms002g.clickNext();
		mms002h.clickNext();
		mms002i.clickNext();
		// Thread.sleep(2000);
		// mms002e.closeAllTabs();
		// mms002b.close();
		mms002b.closeAllTabs();

		return newRawMatNumber;
	}

	def void createProductStructure(String newItemNumber, String newRawMatNumber) {
		mms001E.closeAllTabs();
		// mms001E.goToHome();	
		homePage.GoToPDS001();
		// Assert.assertEquals(pds001.getpageTitle().contains("Product Structure. Open"),"Did not reach the Product Structure page.Actual value was "+pds001.getpageTitle());
		pds001.SearchByItemNumber(newItemNumber);
		pds001.FillItemNumber(newItemNumber, 0);
		pds001.FillSerialNumber("001", 0);
		pds001.FillFacility("A01", 0);
		pds001.createButton();
		pds001.clickNext();
		pds001.clickNext();
		pds001.clickGridNext();
		// pds001F.setM3Text("Test");
		// pds001.goToMaterialAndOperations(newItemNumber);					
		connectMaterialOperation.setSno("140");
		connectMaterialOperation.setOperation("10");
		connectMaterialOperation.setComponent(newRawMatNumber);
		connectMaterialOperation.clickAddButton();
		pds002E.setQuantity("10"); // This should be PDS002E
		pds001.clickNext();
		pds001.clickNext();
		
		// operation binding
		var lastAddedComponentId = connectMaterialOperation.getLastAddedComponentId();
		Assert.assertEquals(lastAddedComponentId, newRawMatNumber,
			"Actual value :" + lastAddedComponentId + " value expected is " + newItemNumber);

		connectMaterialOperation.clearTextSno();
		connectMaterialOperation.selectOperationFromLookUp("Y0010");
		connectMaterialOperation.clickAddButton();
		connectOperations.setRuntime("10");

		pds001.clickNext();
		pds001.clickNext();

		lastAddedComponentId = connectMaterialOperation.getLastAddedComponentId();
		Assert.assertTrue(lastAddedComponentId.contains("Y0010"),
			"Actual value :" + lastAddedComponentId + " value expected is YACUT01");

		connectMaterialOperation.closeAllTabs();
		
		
		//pds001E.closeAllTabs();

		// ProductCosting
		// homePage.goToHome()
		homePage.GoToPDS001();
		pds001.SearchByItemNumber(newItemNumber);
		pds001.goToCalculateProductCost();

		var costingtype = "3";

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
		pds001.SearchByItemNumber(newItemNumber);
		pds001.goToDisplayProductCosting();
		
		pds001.closeAllTabs();

		
		

	}

	def String createCustomerOrder(String newItemNumber) {
		pds001.closeAllTabs();
		// homePage.GoToOIS100();
		// loginPage.GoTo()
		// homePage.GoToMMS001()
		// OIS100FANDB.GoToOIS100();
		homePage.GoToOIS100();
		print("Went inside GoToOIS100");
		ois100A.clearCOno();
		ois100A.clearCustomer();
		ois100A.fillCustomer("D10000");
		ois100A.fillCOType("F10");
		ois100A.fillReqDeliveryDate("170810");

		ois100A.clickNext();

		ois100G.handleAbnormalException();

		ois100A.clickNext();

		if (ois100A.getPageId().equals("OIS100/G")) {

			ois100G.fillCustomerOrd("Y00001-190");
			ois100G.clickNext();
			ois100G.handleWarning();

		}

		ois100A.clickNext();

		println("completed here ois300 ");

		ois100H.FillPicingAndConditionsFNB("BEZ", "CRE");
		ois100H.ClickPrevious();

		// ois101B1.fillOrderLine(newItemNumber,"30");
		// crs207B.clickNext();
		ois101B1.CustomerOrderOPenLine(newItemNumber, "72", "72");

		ois100A.clickNext();

		var coNumber = ois101B1.GetCONumber();

		println("This is co " + coNumber);

//	crs207B.CloseActiveTab();
//		
//		crs207B.fillMatrix("10");
//		
//		crs207B.clickNext();
		// Enter price for Black item
//		crs207B.handleAbnormalException();
//		ois101e.fillPricingInformation("350","200");
//		//Enter price for Green item
//		crs207B.handleAbnormalException();
//		ois101e.fillPricingInformation("350","300");
//				
//		//Enter price for Red item
//		crs207B.handleAbnormalException();
//		ois101e.fillPricingInformation("350","325");
		// asserting the table
//		Assert.assertTrue(ois101B1.checkItemPresence().contains(newItemNumber+"-Y01-010"));	
//		var coNumber = ois101B1.getTheCONumber();
//		System.out.println("CO Number :"+coNumber)
		return coNumber;
	}

	// insert the method
	def String poCreation(String coNumber, String newRawMaterialNumber) {
		// Close ALl Tabs
		ois300.closeAllTabs();

		// Go To OIS300
		homePage.GoToOIS300();

		System.out.println("GoToOIS300");
		// Set the sorting order to 1
		ois300.setSortingOrder("1-Order Number")

		// Search CO Number
		ois300.searchCONumber(coNumber)

		// Go To Order Lines
		ois300.goToOrderLines();

		// Go To Sim comp Avail
		ois300CustomerOrderOpenLines.goToSimCopAvail();

		// Go To Material Plans
		ois300SimulateForMaterial.goToMaterialPlan();

		// Calculate the MRP
		ois300MaterialPlan.calculateMRP();

		val orderNumber = ois300MaterialPlan.getTheOrderNumber("250");
		// Go To Planned Purchase Order
		ois300MaterialPlan.changeMaterialPlan(orderNumber);

		// Set status to 60
		ois300PlannedPurchaseOrder.setStatus("60-Released");
		ois300PlannedPurchaseOrder.Next();
		ois300PlannedPurchaseOrder.Next();
		ois300PlannedPurchaseOrder.Next();

		// Remove the buyer
		ois300PlannedPurchaseOrder.clearBuyerFrom();
		ois300PlannedPurchaseOrder.clearBuyerTo();
		ois300PlannedPurchaseOrder.Next();

		// Refresh the grid
		ois300MaterialPlan.refreshTheGrid();
		ois300MaterialPlan.refreshTheGrid();

		// Verify
		Assert.assertTrue(ois300MaterialPlan.isGridEmpty());

		// Get the PO Number
		ois300MaterialPlan.searchForStat("251")
		var PoNumber = ois300MaterialPlan.getTheOrderNumber("251");
		println("PO Number is " + PoNumber);

		ois300MaterialPlan.closeAllTabs();

		// POP Confirmation
		homePage.GoToPPS220();
		pps220B.searchPONumber(PoNumber);
		Assert.assertTrue(pps220B.checkTheLst("15"));

		pps220B.closeAllTabs();

		// Print PO
		homePage.GoToPPS600();
		pps600E.FillPONumbers(PoNumber);
		pps600E.FillLowestStatus("15");
		pps600E.FillHighestStatus("15")
		pps600E.clickNext();
		pps600F.FillReportText(PoNumber);
		pps600F.clickNext();
		pps600SelectMedia.ConfirmOutput();

		// Verify the status 20
		pps600SelectMedia.closeAllTabs();
		homePage.GoToPPS220();
		pps220B.searchPONumber(PoNumber);
		Assert.assertEquals(pps220B.voidCheckTheStatus(PoNumber), "20");

		// Po Confirmation
		pps220B.closeAllTabs();
		homePage.GoToPPS250();
		pps250B1.enterPoNumber(PoNumber);
		pps250B1.clickConfirmation(newRawMaterialNumber);

		// verify the status 35
		Assert.assertEquals(pps250B1.checkStatus(newRawMaterialNumber), "35")

		// Change the status to 45
		pps250B1.closeAllTabs();
		homePage.GoToPPS270();
		pps270B1.enterPoNumber(PoNumber);
		pps270B1.goToChange()
		pps270E.clickNext()

		// Verify the Status 45
		Assert.assertEquals(pps270B1.checkStatus(newRawMaterialNumber), "45")

		pps270B1.closeAllTabs();

		// PPS300
		homePage.GoToPPS300();
		pps300b.setSortingOrder("1-Open lines");
		pps300b.enterPONum(PoNumber);
		pps300b.goToChange();

		pps300e.SetRecieveQtyAsConfirmedQty();
		pps300e.ClickNext();
		pps300e.closeAllTabs();

		homePage.GoToPPS330();
		pps330b.searchPONum(PoNumber);

		pps330b.checkStatusForPO(PoNumber, "50");
		var recievingNo = pps330b.getRecievingNoOf(PoNumber);
		pps330b.closeAllTabs();

		// PPS320
		homePage.GoToPPS320();
		pps320b1.enterTheRecivingNo(recievingNo);
		pps320b1.clickApply();
		pps320b1.editFirstRow();
		pps320e.EnterStoredQtyAsRecieved();
		pps320e.Next();
		pps320e.closeAllTabs();

		homePage.GoToPPS330();
		pps330b.searchPONum(PoNumber);
		pps330b.checkStatusForPO(PoNumber, "51");
		pps330b.closeAllTabs();

		// PPS310
		homePage.GoToPPS310();
		pps310b1.enterTheRecivingNo(recievingNo);
		pps310b1.clickApply();
		pps310b1.editFirstRecord();
		pps310e.enterApprovedQty();
		pps310e.Next();
		pps310e.closeAllTabs();

		homePage.GoToPPS330();
		pps330b.searchPONum(PoNumber);
		pps330b.checkStatusForPO(PoNumber, "65");
		pps330b.closeAllTabs();

		// Check the status 2 in MWS060
		homePage.GoToMWS060();
		mws060b.enterItemNumber(newRawMaterialNumber);

		// Verify The status
		Assert.assertEquals(mws060b.checkStatus(newRawMaterialNumber), "2");
		mws060b.closeAllTabs();
		return PoNumber;
	}

	/**
	 * Material Issuing PMS070
	 */
	def meterialIssue(String lastJointSchNo) {
        homePage.closeAllTabs();
		homePage.GoToPMS070
		pms070a.setSchedNumberFromLookUp(lastJointSchNo)
		pms070a.clearMONumber()
		pms070a.clearProductNo()
		pms070a.Next();
		println("end");
// 		verify for status 90	
		var stat = pms070b1.getStatusOfGridRow(0)
		Assert.assertEquals(stat, "90")

		System.out.println("meterialIssue Executed ");

		pms070a.closeAllTabs()

	}

	/**
	 * FG Reporting
	 */
	def FGReporting(String scheduleNo) {

		homePage.GoToPMS050
		pms070a.setSchedNumberFromLookUp(scheduleNo)
		pms070a.clearMONumber()
		pms070a.clearProductNo()

		pms070b1.ConfirmationRecord(0);
		pms070b1.closeOperationsWithStatus80();
		var stat = pms070b1.getStatusOfGridRow(0)
		Assert.assertEquals(stat, "90")
		System.out.println("FGReporting Executed ");

	}
}
//
//@Accessors
//class moDto {
//	String lastJointSchNo;
//	String fullScheduleNo;
//}
