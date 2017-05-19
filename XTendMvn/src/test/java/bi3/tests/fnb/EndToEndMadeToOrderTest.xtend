package bi3.tests.fnb

import bi3.tests.BaseTest
import bi3.pages.*
import org.testng.annotations.*

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
import bi3.pages.ois100.OIS100H
import bi3.pages.mms080.MMS080B1
import bi3.pages.pms270.PMS270E
import bi3.pages.ois145.OIS145E
import bi3.pages.pcs200.PCS200E
import bi3.pages.pcs200.PCS200F
import bi3.pages.pcs300.PCS300
import bi3.configuration.settings.PMS100SettingsTest
import bi3.pages.pps600.PPS600E
import bi3.pages.pps600.PPS600F
import bi3.pages.pps600.PPS600SelectMedia
import bi3.pages.pps250.PPS250B1
import bi3.pages.pps270.PPS270B1
import bi3.pages.pps270.PPS270E
import bi3.pages.pps300.PPS300E
import bi3.configuration.settings.PPS300SettingsTest
import bi3.configuration.settings.PPS320SettingsTest
import bi3.configuration.settings.PPS310SettingsTest
import bi3.pages.pms040.PMS040B
import bi3.pages.mms121.MMS121B1
import org.openqa.selenium.WebDriver
import java.util.Base64
import bi3.pages.pms050.PMS050E
import bi3.pages.mws420.MWS420B1

public class EndToEndMadeToOrderTest extends BaseTest {
	
	//private WebDriver driver = null;
	
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
	
	OIS100H ois100H
	
	MMS080B1 mms080b1
	
	PMS270E pms270e
	
	OIS145E ois145e
	
	PCS200E pcs200e
	PCS200F pcs200f
	
	PCS300 pcs300
	
	PPS220B pps220B
	
	PPS600E pps600E
	
	PPS600F pps600F
	
	PPS600SelectMedia pps600SelectMedia
	
	PPS250B1 pps250B1
	
	PPS270B1 pps270B1
	
	PPS270E pps270E
	
	PPS300E pps300e
	
	PPS300SettingsTest pps300Settings
	PPS320SettingsTest pps320Settings
	PPS310SettingsTest pps310Settings
	
	PMS040B pms040b
	
	MMS121B1 mms121b1
	PMS050E pms050e
	
	MWS420B1 mws420b1
	
	new(WebDriver driver) {
		this.driver = driver;
		this.Initialize();
	}
	
	new(){
	}
	
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

		mms001SettingsTest = new MMS001SettingsTest(driver);
		pds001SettingsTest = new PDS001SettingsTest(driver);
		pms001SettingsTest = new PMS001SettingsTest(driver);
		ois101SettingsTest = new OIS101SettingsTest(driver);
		pps300Settings = new PPS300SettingsTest(driver)
		pps320Settings = new PPS320SettingsTest(driver)
		pps310Settings = new PPS310SettingsTest(driver)

		ois100H = new OIS100H(driver)
		
		mms080b1 = new MMS080B1(driver)
		
		pms270e = new PMS270E(driver)
		
		ois145e = new OIS145E(driver)
		
		pcs200e = new PCS200E(driver)
		pcs200f = new PCS200F(driver)
		
		pcs300 = new PCS300(driver)
		
	
		pps220B = new PPS220B(driver)
		
		pps600E = new PPS600E(driver)
		
		pps600F = new PPS600F(driver)
		
		pps600SelectMedia = new PPS600SelectMedia(driver)
		
		pps250B1 = new PPS250B1(driver)
		
		pps270B1 = new PPS270B1(driver)
	
		pps270E = new PPS270E(driver)
		
		pps300e = new PPS300E(driver)
		
		pms040b = new PMS040B(driver)
		
		mms121b1 = new MMS121B1(driver)
		pms050e = new PMS050E(driver)
		mws420b1 = new MWS420B1(driver)
	}

	/**
	 * @TestCaseID: MTO001
	 * @CloudSuite: F&B
	 * @Description: This test case includes the End to End Made to Order Test
	 * @author:	rasithae
	 * @author: dasunik
	 */
	@Test
	def void EndToEndMadeToOrderTest() {
		/* Test Data */
		var String finishedGoodTemplateItemNo = "DORD01";
		var String rawMaterialTemplateItemNo = "DRM001";
		
		/* Test*/
		// mms001 user settings
		//mms001SettingsTest.updateItemsSetting("2-Always update");

		// Copy Finished Good
		var newItemNumber = this.copyFinishedGoodItem(finishedGoodTemplateItemNo);
		System.out.println("copyFinishedGoodItem Finished:"+newItemNumber);
		
		// Create Raw Material
		var newRawMatNumber = this.copyRawMaterialItem(rawMaterialTemplateItemNo);
		System.out.println("copyRawMaterialItem Finished"+newRawMatNumber);
		
		// pds001 settings page
		pds001SettingsTest.updateProductVariantSetting("2-Always update")	
			
		// Create Product Structure
		this.createProductStructure(newItemNumber, newRawMatNumber);
		System.out.println("createProductStructure Finished");
		
		this.StandardCosting(newItemNumber,"3")
		
		var createCustomerOrder = this.createCustomerOrder(newItemNumber);
		
		this.POCreation(createCustomerOrder,newRawMatNumber)
		
		var moDto1 = this.MOPVerification("001",newItemNumber)
	}
	
	

	def String copyFinishedGoodItem(String templateItemNumber) {
		loginPage.GoTo()

		homePage.GoToMMS001()
		mms001.SearchByItemNumber(templateItemNumber)
		mms001.CopyItem(templateItemNumber)

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
//		connectWarehouseE.selectContNetChange()
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
		return newItemNumber;

	}

	def String copyRawMaterialItem(String templateItemNumber) {
		homePage.GoToMMS001();
		mms001.SearchByItemNumber(templateItemNumber);
		mms001.CopyItem(templateItemNumber);
		//mms001.clearItemInsertNewNo(templateItemNumber2);
		Thread.sleep(1000);
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
		Assert.assertTrue(mms001.GetItemNumberList().contains(newRawMatNumber), "Item number" + newRawMatNumber +
			"is not found in the grid");
		System.out.println(newRawMatNumber)
		mms001.close()

		return newRawMatNumber;
	}

	def void createProductStructure(String newItemNumber, String newRawMatNumber) {
		mms001E.closeAllTabs();
		//mms001E.goToHome();	
		homePage.GoToPDS001();	
		//Assert.assertEquals(pds001.getpageTitle().contains("Product Structure. Open"),"Did not reach the Product Structure page.Actual value was "+pds001.getpageTitle());
		
		pds001.SearchByItemNumber(newItemNumber);
		pds001.FillItemNumber(newItemNumber,0);
		pds001.FillSerialNumber("001",0);
		pds001.FillFacility("A01",0);
		pds001.createButton();
		pds001.clickNext();
		pds001.clickNext();
		pds001.clickGridNext();
		//pds001F.setM3Text("Test");
		
		//pds001.goToMaterialAndOperations(newItemNumber);					
		connectMaterialOperation.setSno("140");
		connectMaterialOperation.setOperation("10");
		connectMaterialOperation.setComponent(newRawMatNumber);
		connectMaterialOperation.clickAddButton();		
		pds002E.setQuantity("10"); // This should be PDS002E
		
		pds001.clickNext();
		pds001.clickNext();
		
		var lastAddedComponentId = connectMaterialOperation.getLastAddedComponentId();
		Assert.assertEquals(lastAddedComponentId,newRawMatNumber,"Actual value :"+ lastAddedComponentId +" value expected is " + newItemNumber);
		
		connectMaterialOperation.clearTextSno();
		connectMaterialOperation.selectOperationFromLookUp("Y0010");
		connectMaterialOperation. clickAddButton();	
		connectOperations.setRuntime("10");
		
		pds001.clickNext();
		pds001.clickNext();
		
		lastAddedComponentId = connectMaterialOperation.getLastAddedComponentId();
		Assert.assertTrue(lastAddedComponentId.contains("Y0010"),"Actual value :" + lastAddedComponentId +" value expected is YACUT01");
		
		connectMaterialOperation.closeAllTabs();
	}
	
	
	def String createCustomerOrder(String newItemNumber){
		pds001.closeAllTabs();
		//homePage.GoToOIS100();

		//loginPage.GoTo()
		
		//homePage.GoToMMS001()
		//OIS100FANDB.GoToOIS100();
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

		if(ois100A.getPageId().equals("OIS100/G")){
			
			ois100G.fillCustomerOrd("Y00001-190");
			ois100G.clickNext();
			ois100G.handleWarning();
			
		}
				
		ois100A.clickNext();
		

		println("completed here ois300 ");
		
		
		ois100H.FillPicingAndConditionsFNB("BEZ","CRE");
		ois100H.ClickPrevious();
		
		//ois101B1.fillOrderLine(newItemNumber,"30");
		//crs207B.clickNext();
		
		
		
		ois101B1.CustomerOrderOPenLine(newItemNumber,"72","72");
		ois101B1.ClickAdd()
				
		ois145e.Update()
		
		var coNumber = ois101B1.GetCONumber();
		
		println("CO Number "+ coNumber);
		
		ois101B1.closeAllTabs()
		
		return coNumber;		
	}
	
	def moDto MOPVerification(String warehouse,String newItemNumber){
		
		homePage.GoToMMS080()
		mms080b1.setHeaderDetails(newItemNumber,warehouse);
		mms080b1.calculateMRPAndRefreshPage();
		mms080b1.SearchByOct("100")
		var orderNo = mms080b1.GetOrderNoOfRecordWithOct("100")
		System.out.println("Order number from MMS080 is "+orderNo)
		mms080b1.closeAllTabs()
		
		homePage.GoToPMS170()
		pms170b.SelectSortingOrder("99-PlanOrder")
		pms170b.clearResponsible()
		pms170b.SearchWithPlanOrderNo(orderNo)
		pms170b.JointSchedulling()
		
		var scheduleNo = pms270e.GetSchedNo()
		System.out.println("Schedule Number : "+scheduleNo)
		pms270e.clickNext()
		
		pms170b.ReleaseItem()
		
		Assert.assertEquals(pms170b.GetStsOfPlnOrd(orderNo),"60","MOP with Order num "+orderNo+" was not released")
		
		pms170b.closeAllTabs()
		
		homePage.goToHome()
		homePage.GoToPMS100()
		
		if(pms100_b.getPageId().contains("PMS100/A")){
			pms100_b.closeAllTabs()
			var pms100Settings = new PMS100SettingsTest(driver)
			pms100Settings.SetOpeningPanel("B-Browse")
		}
		
		
		pms100_b.SelectSortingOrder("91-SchNo/Product")
		pms100_b.EnterMainProduct(newItemNumber)

		var shortSched = scheduleNo.replaceFirst("^0+(?!$)", "")

		pms100_b.ClearMoNo()
		pms100_b.SearchScheduleNo(shortSched)
		
		var MONumber = pms100_b.GetMONumOfSchedule(shortSched)
		var listStatus = pms100_b.GetStatusesWithSorting91(shortSched);
		
		Assert.assertEquals(listStatus.get(0), "20", "Status 1 is incorrect");
		Assert.assertEquals(listStatus.get(1), "22", "Ho is incorrect");
		Assert.assertEquals(listStatus.get(2), "40", "Status 2 is incorrect");
		
		pms100_b.goToCheckCompAvailability(MONumber)
		
		pms040b.changeFirstRecord()
		
		mms121b1.AddAllocatedQty()
		mms121b1.ClickPrevious()
		
		pms040b.clickRefresh()
		Assert.assertEquals(pms040b.getStatusOfFirstRecord(),"33","Status was not 33 at PMS040")
		
		pms040b.closeAllTabs()
		
		System.out.println("Material Allocating completed.")
		
		//Raw material issuing
		homePage.GoToPMS100()
		
		pms100_b.SelectSortingOrder("91-SchNo/Product")
		pms100_b.EnterMainProduct(newItemNumber)
		pms100_b.ClearMoNo()
		pms100_b.SearchScheduleNo(shortSched)
		pms100_b.goToDeliveryToolbox()
		mws410b.relaseForPicking()
		Assert.assertEquals(mws410b.getRIPOFRow1(),"1")
		mws410b.MoveToPickingList()
		mws420b1.ConfirmIssues()
		Assert.assertEquals(mws420b1.getPiSOfFirstRow(),"90")
		mws420b1.closeAllTabs()
		
		//Operation reporting
		homePage.GoToPMS070()
		pms070a.setSchedNumberFromLookUp(shortSched)
		pms070a.clearMONumber()
		pms070a.clearProductNo()
		pms070a.Next();

		pms070b1.confirmGridRow(0)
		var stat = pms070b1.getStatusOfGridRow(0)
		Assert.assertEquals(stat, "80","Status was not 80 at PMS070 after confirming")
		
		pms070b1.closeOperationsWithStatus80()
// 		verify for status 90	
		stat = pms070b1.getStatusOfGridRow(0)
		Assert.assertEquals(stat, "90","Status was not 90 at PMS070 after closing operation")
		pms070b1.closeAllTabs()
		System.out.println("Material Issuing Completed ");
		
		//FG Reporting
		homePage.GoToPMS050()
		pms050a.setSchedNumberFromLookUp(shortSched)
		pms050a.clearMONumber()
		pms050a.clearProductNo()
		pms050a.Next()
		//pms070b1.ConfirmationRecord(0)
		pms050b1.goToChangeOfGridRow(0)
		pms050e.enterManufQtyAsOrderQty()
		pms050e.ClickNext()
		pms050e.ClickNext()
		pms050e.ClickNext()
		pms050b1.refreshPage()
		stat = pms050b1.getStatusOfGridRow(0)
		Assert.assertEquals(stat, "90")
		System.out.println("FG Reporting Executed ");

		pms050a.closeAllTabs()
		
		var moDto data = new moDto();
		data.lastJointSchNo = shortSched;
		data.fullScheduleNo = scheduleNo;
		data.moNum = MONumber
		
		return data
	}
	
	def void StandardCosting(String finishedGood,String costingtype){
		
		homePage.goToHome()
		homePage.GoToPDS001()
		
		pds001.SearchByItemNumber(finishedGood)
		pds001.goToCalculateProductCost()
		
		pcs200e.SetCostingType(costingtype);
		 
		pcs200e.SelectPrtCosting("0-No");
		pcs200e.SetCostingName("STD");
		pcs200e.SelectAllLevels("1-Explosion, all");
		pcs200e.SetView("STD");
		pcs200e.SelectCalspurchdist("3-Yes, purch & distr items & subcontr op");
		pcs200e.clickNext();
		pcs200e.clickNext();
		pcs200f.clickNext();
		pds001.SearchByItemNumber(finishedGood);
		pds001.goToDisplayProductCosting();
		val gridcostingtype = pcs300.getDataOfItem(costingtype).get(0);
		Assert.assertEquals(gridcostingtype,costingtype);	
			
		pcs300.closeAllTabs()
	}
	
	def void POCreation(String coNumber,String newRawMaterialNumber){
 		//Go To OIS300
 		homePage.GoToOIS300();
 		
 		//Set the sorting order to 1
 		ois300.setSortingOrder("1-Order Number")
 		
 		//Search CO Number
 		ois300.searchCONumber(coNumber)
 		
 		//Go To Order Lines
 		ois300.goToOrderLines();
 		
 		//Go To Sim comp Avail
 		ois300CustomerOrderOpenLines.goToSimCopAvail();
 		
 		//Go To Material Plans
 		ois300SimulateForMaterial.goToMaterialPlan();
 		
 		//Calculate the MRP
 		ois300MaterialPlan.calculateMRP();
 		
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
 		
 		//Get the PO Number
 		ois300MaterialPlan.searchForStat("251")
 		var PoNumber = ois300MaterialPlan.getTheOrderNumber("251");
 		println("PO Number is " +PoNumber);
 		
 		ois300MaterialPlan.closeAllTabs();
 		
 		//POP Confirmation
 		homePage.GoToPPS220();
 		pps220B.searchPONumber(PoNumber);
 		Assert.assertTrue(pps220B.checkTheLst("15"));
 		
 		pps220B.closeAllTabs();
 		
 		//Print PO
 		homePage.GoToPPS600();
 		pps600E.FillPONumbers(PoNumber);
 		pps600E.FillLowestStatus("15");
 		pps600E.FillHighestStatus("15")
 		pps600E.clickNext();
 		pps600F.FillReportText(PoNumber);
 		pps600F.clickNext();
 		pps600SelectMedia.ConfirmOutput();
 		
 		//Verify the status 20
 		pps600SelectMedia.closeAllTabs();
 		homePage.GoToPPS220();
 		pps220B.searchPONumber(PoNumber);
 		Assert.assertEquals(pps220B.voidCheckTheStatus(PoNumber),"20");
 		
 		//Po Confirmation
 		pps220B.closeAllTabs();
 		homePage.GoToPPS250();
 		pps250B1.enterPoNumber(PoNumber);
 		pps250B1.clickConfirmation(newRawMaterialNumber);
 		
 		//verify the status 35
 		Assert.assertEquals(pps250B1.checkStatus(newRawMaterialNumber),"35")
 		
 		pps250B1.closeAllTabs();
 		homePage.GoToPPS270();
 		pps270B1.enterPoNumber(PoNumber);
 		pps270B1.goToChange()
 		pps270E.clickNext()
 		
 		//Verify the Status 45
 		Assert.assertEquals(pps270B1.checkStatus(newRawMaterialNumber),"45")
 		
 		pps270B1.closeAllTabs();
 		
 		//PPS300
 		homePage.GoToPPS300();
 		
 		if(!pps300b.pageId.contains("PPS300/B1")){
 			pps300b.closeAllTabs()
 			//Settings to set opening panel as browsing
 			pps300Settings.SetOpeningPanel("B-Browse")
 		}
 		
 		pps300b.setSortingOrder("1-Open lines");
 		pps300b.enterPONum(PoNumber);
 		pps300b.goToChange();
 		
 		pps300e.SetRecieveQtyAsConfirmedQty();
 		pps300e.ClickNext();
 		pps300e.closeAllTabs();
 		
 		homePage.GoToPPS330();
 		pps330b.searchPONum(PoNumber);
 		Assert.assertTrue(pps330b.checkStatusForPO(PoNumber,"50"))
 		var recievingNo = pps330b.getRecievingNoOf(PoNumber)
 		pps330b.closeAllTabs()
 		
 		homePage.GoToPPS320();
 		if(!pps320b1.pageId.contains("PPS320/B1")){
 			pps320b1.closeAllTabs()
 			//Settings to set opening panel as browsing
 			pps320Settings.SetOpeningPanel("B-Browse")
 		}
 		
 		pps320b1.enterTheRecivingNo(recievingNo);
 		pps320b1.clickApply();
 		pps320b1.editFirstRow();
 		pps320e.EnterStoredQtyAsRecieved();
 		pps320e.Next();
 		pps320b1.closeAllTabs()
 		
 		homePage.GoToPPS330();
 		pps330b.searchPONum(PoNumber);
 		Assert.assertTrue(pps330b.checkStatusForPO(PoNumber,"51"))
 		pps330b.closeAllTabs()
 		
 		//PPS310
 		homePage.GoToPPS310();
 		if(!pps310b1.pageId.contains("PPS310/B1")){
 			pps310b1.closeAllTabs()
 			//Settings to set opening panel as browsing
 			pps310Settings.SetOpeningPanel("B-Browse")
 		}
 		
 		pps310b1.enterTheRecivingNo(recievingNo);
 		pps310b1.clickApply();
 		pps310b1.editFirstRecord();
 		pps310e.enterApprovedQty();
 		pps310e.Next();
 		pps310b1.closeAllTabs()
 		
 		homePage.GoToPPS330();
 		pps330b.searchPONum(PoNumber);
 		pps330b.checkStatusForPO(PoNumber,"65");
 		pps330b.closeAllTabs();
 		
 		homePage.GoToMWS060()
 		mws060b.enterItemNumber(newRawMaterialNumber)
 		Assert.assertEquals(mws060b.checkStatus(newRawMaterialNumber),"2","Status at MWS060 was not 2")
 		mws060b.closeAllTabs()
	}

}

@Accessors
class moDto {
	String lastJointSchNo;
	String fullScheduleNo;
	String moNum;
}
