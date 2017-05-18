package bi3.tests.fnb

import bi3.tests.BaseTest
import org.testng.annotations.BeforeMethod
import bi3.pages.*
import org.testng.annotations.Test
import bi3.pages.fcs350.FCS350_B
import org.testng.Assert
import bi3.pages.mms080.MMS080B1
import java.util.List
import bi3.pages.pps310.PPS310A
import bi3.pages.pps310.PPS310E
import bi3.pages.mns212.MNS212B1
import bi3.pages.pps330.PPS330B1
import bi3.configuration.settings.*
import bi3.pages.pps170.PPS170B
import bi3.pages.pps913.PPS913E
import bi3.pages.pps220.*
import bi3.pages.pps270.PPS270E
import bi3.pages.pps300.PPS300SettingsPage
import bi3.pages.pps300.PPS300A
import bi3.pages.pps330.PPS330B
import bi3.pages.pps300.PPS300E
import bi3.pages.pps320.PPS320SettingsPage
import bi3.pages.pps320.PPS320A
import bi3.pages.pps320.PPS320E
import bi3.pages.dps170.DPS170B
import bi3.pages.mms100.MMS100B1
import bi3.pages.mms121.MMS121B1
import bi3.pages.mms101.MMS101B
import bi3.pages.mms101.MMS101B1
import bi3.pages.mws410.MWS410B
import bi3.pages.mws423.MWS423B1
import bi3.pages.mws420.MWS420B1
import bi3.pages.mms100.MMS100B
import bi3.pages.mws442.MWS442B
import bi3.pages.mws445.MWS445B

class DistributionOrderFlowTest extends FnBCommons {

	LoginPage loginPage
	HomePage homePage
	FCS350_B fcs350b
	MMS080B1 mms080b1

	// Relates to Distribution Order Flow Video2
	PPS220B pps220B
	PPS220H1 pps220H1
	ToolbarPage toolBarPage
	PPS220I1 pps220I1
	PPS270E pps270E
	PPS300SettingsPage pps300settingsPage
	PPS300A pps300A
	PPS300E pps300E
	PPS330B pps330B
	PPS320SettingsPage pps320settingsPage
	PPS320A pps320A
	PPS320E pps320E
	MNS212B1 mns212B1

	// Video 3
	PPS310A pps310a
	PPS310E pps310e
	MNS212B1 mns212b1
	PPS330B1 pps330b1
	PPS310SettingsTest pps310SettingsTest
	MMS001SettingsTest mms001SettingsTest
	PDS001SettingsTest pds001SettingsTest
	PMS001SettingsTest pms001SettingsTest
	OIS101SettingsTest ois101SettingsTest
	DPS170B dps170b
	MMS100B1 mms100b1
	MMS101B mms101b
	MMS121B1 mms121b1
	MMS101B1 mms101b1
	MWS423B1 mws423b1
	MWS410B mws410b

	PPS170B pps170
	MMS080B1 mmso80b1
	PPS913E pps913e
	PPS220B pps220b
	PPS220G1 pps220g1
	MWS420B1 mws420b1
	
	//Video 4
	MMS100B mms100b
	MWS442B mws442b
	MWS445B mws445b

	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver)
		homePage = new HomePage(driver)
		fcs350b = new FCS350_B(driver)
		mms080b1 = new MMS080B1(driver)

		pps310a = new PPS310A(driver);
		pps310SettingsTest = new PPS310SettingsTest(driver);
		pps310e = new PPS310E(driver);
		mns212b1 = new MNS212B1(driver);
		pps330b1 = new PPS330B1(driver);

		mms001SettingsTest = new MMS001SettingsTest(driver);
		pds001SettingsTest = new PDS001SettingsTest(driver);
		pms001SettingsTest = new PMS001SettingsTest(driver);
		ois101SettingsTest = new OIS101SettingsTest(driver);

		pps170 = new PPS170B(driver);
		mmso80b1 = new MMS080B1(driver);
		pps913e = new PPS913E(driver);
		pps220b = new PPS220B(driver);
		pps220g1 = new PPS220G1(driver);

		// Relates to Distribution Order Flow Video2
		pps220B = new PPS220B(driver);
		pps220H1 = new PPS220H1(driver);
		toolBarPage = new ToolbarPage(driver);
		pps220I1 = new PPS220I1(driver);
		pps270E = new PPS270E(driver);
		pps300settingsPage = new PPS300SettingsPage(driver);
		pps300A = new PPS300A(driver);
		pps300E = new PPS300E(driver);
		pps330B = new PPS330B(driver);
		pps320settingsPage = new PPS320SettingsPage(driver);
		pps320A = new PPS320A(driver);
		pps320E = new PPS320E(driver);
		mns212B1 = new MNS212B1(driver);

		// Related to Video 3
		dps170b = new DPS170B(driver);
		mms100b1 = new MMS100B1(driver);
		mms101b = new MMS101B(driver);
		mms121b1 = new MMS121B1(driver);
		mms101b1 = new MMS101B1(driver);
		mws423b1 = new MWS423B1(driver);
		mws410b = new MWS410B(driver);
		mws420b1 = new MWS420B1(driver);
		
		//Related to Video 4
		mms100b = new MMS100B(driver);
		mws442b = new MWS442B(driver);
		mws445b = new MWS445B(driver);

	}

	/**
	 * @TestCaseID: DOT001
	 * @CloudSuite: F&B
	 * @Description: This test case includes the Distribution Order Flow
	 * @author:	rasithae
	 */
	@Test
	def void DistributionOrderFlowTest() {
		/* Test Data */
		var String newItemNumber = ""; // "D10165";
		var String newRawMaterialNumber = ""; // "D50154";
		var String periodFrame = "170505";
		var String periodType = "1-Period type";
		var String periodWithinCalYear = "1705";
		var String fcQty = "25";

		var String warehouse2Id = "002";

		var String finishedGoodTemplateItemNo = "D10031";
		var String rawMaterialTemplateItemNo = "D50011";

		// PPS170 data
		var String pps170SortingOrder = "1-Buy,Sup,Whs,Ite"
		var String pps170View = "PANEL3-Buyer, supplier, warehouse, item"

		/* Test*/
		loginPage.GoTo();

		// mms001 user settings
		mms001SettingsTest.updateItemsSetting("2-Always update");

		// Copy Finished Good
		newItemNumber = this.copyFinishedGoodItem(finishedGoodTemplateItemNo);
		System.out.println("copyFinishedGoodItem Finished: " + newItemNumber);
		// Create Raw Material
		newRawMaterialNumber = this.copyRawMaterialItem(rawMaterialTemplateItemNo);
		System.out.println("copyRawMaterialItem Finished: " + newRawMaterialNumber);

		// pds001 settings page
		pds001SettingsTest.updateProductVariantSetting("2-Always update")
		// Create Product Structure
		this.createProductStructure(newItemNumber, newRawMaterialNumber);
		System.out.println("createProductStructure Finished");

		// 1. Create a forecast to the future period from FCS350
		homePage.GoToFCS350();
		fcs350b.setHeaderDetails(newItemNumber, periodFrame, periodType);
		var String frDt = fcs350b.setFCQtyForTheEmptyPeriod(periodWithinCalYear, fcQty);
		fcs350b.Next();

		// 2. Go to MMS080 and check the demand for the forecast and calculate MRP
		fcs350b.closeAllTabs();
		homePage.goToHome();
		homePage.GoToMMS080();

		mms080b1.setHeaderDetails(newItemNumber, "");
		var List<String> dataList = mms080b1.getDetailsFromGrid(periodWithinCalYear);
		Assert.assertEquals(dataList.get(4), "999999999", "ATP cum is not correct"); // Verify ATP cum is 999999999		
		mms080b1.calculateMRPAndRefreshPage();
		dataList = mms080b1.getDetailsFromGrid(16, "F20"); // Get data of the 16th column with value F20		
		Assert.assertEquals(dataList.get(5), "100", "Oct is not 100"); // Verify Oct is 100		
		// Verify the status here
		mms080b1.setHeaderDetails(newRawMaterialNumber, "");
		mms080b1.calculateMRPAndRefreshPage();
		dataList = mms080b1.getDetailsFromGrid(16, "D19"); // Get data of the 16th column with value D19		
		Assert.assertEquals(dataList.get(5), "500", "Oct is not 500"); // Verify Oct is 500		
		// Verify the status here
		// 3. Go to the raw material and calculate MRP in warehouse 002
		mms080b1.setHeaderDetails(newRawMaterialNumber, warehouse2Id);
		mms080b1.calculateMRPAndRefreshPage();
		dataList = mms080b1.getDetailsFromGrid(16, "D20"); // Get data of the 16th column with value D20		
		Assert.assertEquals(dataList.get(5), "250", "Oct is not 250"); // Verify Oct is 250		
		// 4. Release the created POP in status 250 from PPS170
		mms080b1.closeAllTabs();
		homePage.goToHome();
		homePage.GoToPPS170();
		pps170.setFilterOptions(pps170SortingOrder, pps170View);
		pps170.fillTableHeaderInformation("FABPLANNER", "Y50001", warehouse2Id, newRawMaterialNumber);
		pps170.releaseLine(newRawMaterialNumber)

		// Goto mms080 and verify the status is 251
		pps170.CloseActiveTab();
		pps913e.clearBuyer();
		pps913e.Next();

		homePage.goToHome();
		homePage.GoToMMS080();
		mms080b1.setHeaderDetails(newRawMaterialNumber, warehouse2Id);
		dataList = mms080b1.getDetailsFromGrid(16, "D20"); // Get data of the 16th column with value D20		
		Assert.assertEquals(dataList.get(5), "251", "Oct is not 251"); // Verify Oct is 251
		var String newPoNumber = dataList.get(8);
		println("New PO number is : " + newPoNumber);

		// 5. Get the order number and GRN the PO
		mms080b1.closeAllTabs();
		homePage.goToHome();
		homePage.GoToPPS220();

		pps220b.searchPONumber(newPoNumber);
		pps220b.confirmOrder(newPoNumber);

		pps220g1.setHeaderDetails("SUP" + newRawMaterialNumber, "SUP" + newRawMaterialNumber);
		pps220g1.selectAction("Confirm Update")
		System.out.println("Confirmed the order")

		var List<String> pps220DataList = pps220b.getDetailsFromGrid(1, newPoNumber); // Get data from grid
		Assert.assertEquals(pps220DataList.get(12), "35", "Lst is not 35"); // Verify Lst is 35
		Assert.assertEquals(pps220DataList.get(13), "35", "Hst is not 35"); // Verify Hst is 35

		// --------Video 2 Starts Here------------------
		pps220g1.closeAllTabs();
		homePage.GoToPPS220();

		// 1.Confirm Order
		pps220B.searchPONumber(newPoNumber)
		// Assert Lst = 35
		Assert.assertEquals("35", pps220B.getLstOfFirstRow());
		// Assert Hst = 35
		Assert.assertEquals("35", pps220B.getHstOfFirstRow());

		// 2.Advise Shipment
		pps220B.GotoRelatedAndAdviceShipment();

		pps220H1.fillDelyNote("DELN001")
		pps220H1.fillPackageNo("PKG001");
		pps220H1.fillSSCCNumber("123456")

		toolBarPage.ClickAction();
		pps220H1.clickConfirmUpdate();
		// Assert Lst = 40
		Assert.assertEquals("40", pps220B.getLstOfFirstRow());
		// Assert Hst = 40
		Assert.assertEquals("40", pps220B.getHstOfFirstRow());

		// 3.Transport Notification
		pps220B.goToRelatedAndClickTransportNotification();

		pps220I1.clickChange();

		// fill ordered/confirmed details
		pps270E.fillFwd("FEDEX");
		pps270E.fillBilOfLading("BOL001");
		pps270E.fillCarrierName("CARRIER");
		pps270E.clickNext();

		toolBarPage.ClickAction();
		pps220I1.clickConfirmUpdate();

		// Assert Lst = 45
		Assert.assertEquals("45", pps220B.getLstOfFirstRow());
		// Assert Hst = 45
		Assert.assertEquals("45", pps220B.getHstOfFirstRow());

		pps220B.closeAllTabs();

		// 4.Good Receipt
		homePage.GoToPPS300();

		// settings
		if (pps220B.getPageId().equals("PPS300/B1")) {
			toolBarPage.ClickAction();
			pps300settingsPage.goToSettings();
			pps300settingsPage.changeOpeningPanel();
			pps300settingsPage.clickNext();
		}

		pps300A.setPONum(newPoNumber);
		pps300A.setWarehouse(warehouse2Id);
		pps300A.fillPOtxtBox1("1");
		pps300A.ClickNext();
		pps300A.ClickNext();

		pps300E.SetRecieveQtyAsConfirmedQty();
		pps300E.fillRemarks("GOOD");
		pps300E.ClickNext();

		pps300A.goToStartPage();
		homePage.GoToPPS220();
		pps220B.searchPONumber(newPoNumber);

		// Assert Lst = 50
		Assert.assertEquals("50", pps220B.getLstOfFirstRow());
		// Assert Hst = 50
		Assert.assertEquals("50", pps220B.getHstOfFirstRow());

		pps220B.goToRelatedAndClickPurchaseOrderTransactions();

		// Assert for status=50
		Assert.assertEquals(true, pps330B.checkStatusForPO(newPoNumber, "50"));

		// 5.Put Away
		pps330B.closeAllTabs();
		homePage.GoToPPS320();

		// settings
		if (pps320A.getPageId().equals("PPS320/B")) {
			toolBarPage.ClickAction();
			pps320settingsPage.goToSettings();
			pps320settingsPage.changeOpeningPanel();
			pps320settingsPage.clickNext();
		}

		pps320A.closeAllTabs();
		homePage.GoToPPS330();
		pps330B.searchForPO(newPoNumber, warehouse2Id);
		var String ReceivingNo = pps330B.getRecievingNoOf(newPoNumber);

		pps330B.closeAllTabs();
		homePage.GoToPPS320();
		pps320A.setWarehouse(warehouse2Id);
		pps320A.setReceivingNo(ReceivingNo);
		pps320A.ClickNext();
		pps320A.ClickNext();

		pps320E.EnterStoredQtyAsRecieved();
		pps320E.SetLocationFromText("YCD");
		pps320E.Next();

		pps320A.GoToOutputSelectMedia();
		mns212B1.ConfirmOutput();

		homePage.closeAllTabs();
		homePage.GoToPPS330();

		// Assert for status=51
		pps330B.searchForPO(newPoNumber, warehouse2Id)
		Assert.assertEquals(true, pps330B.checkStatusForPO(newPoNumber, "51"));

		// --------Video 2 Ends Here------------------
		
		// --------Video 3 Starts Here-----------------
		
		// 6. Inspection flow
		homePage.closeAllTabs();
		pps310SettingsTest.SetOpeningPanel("A-Entry");

		pps310a.EditDetails(newPoNumber);
		pps310a.GoToPPS310E();

		pps310e.enterApprovedQty();
		pps310e.Next();
		pps310a.PressF12();

		mns212b1.ConfirmOutput();
		homePage.GoToPPS330();
		pps330b1.SearchPO(newPoNumber);
		// verify status 65
		Assert.assertTrue(pps330b1.checkStatus65ForPO(newPoNumber));
		println("Inspection done");
		homePage.closeAllTabs();

		// 7. Releasing DOP
		pps330b1.GoToStart();
		homePage.GoToDPS170();
		dps170b.SearchItem("FABPLANNER", "002", "001", newRawMaterialNumber);
		dps170b.goToRelatedOption("Release");

		homePage.closeAllTabs();
		homePage.GoToMMS080();
		mms080b1.setHeaderDetails(newRawMaterialNumber, warehouse2Id);
		var data = mms080b1.getDataOfRow("Oct", "511");
		var orderNo = data.get(8);
		println(orderNo);

		homePage.closeAllTabs();
		homePage.GoToMMS100();
		mms100b1.selectSortingOrder("1-Order number");
		mms100b1.SearchOrder(orderNo, "FABPLANNER");
		mms100b1.goToRelatedOption("Order Lines");
		mms101b.goToRelatedOption("Allocate");
		mms121b1.AddAllocatedQty();
		mms101b1.GoBack();
		mms101b1.GoBack();

		// 8.Release for picking, packaging and confirm issues
		mms100b1.GoToDeliveryToolbox();
		mws410b.goToRelatedOption("Release for Picking");
		Thread.sleep(6000);
		mws410b.refreshPage();
		mws410b.refreshPage();
		
		// mws410b.GoToPackages();		
		// mws423b1.SelectPackaging("SSCC");
		
		mws410b.MoveToPickingList();
		
		mws420b1.goToRelatedOption("Confirm Issues");

		// Assert PiS = 70
		Assert.assertEquals(mws420b1.getPiSOfFirstRow(), "70");

		// --------Video 3 Ends Here------------------
		
		// --------Video 4 Starts Here----------------
			
		homePage.closeAllTabs();
		homePage.goToHome();
		homePage.GoToMMS100()
		
		mms100b.selectSortingOrder("1-Order number");

		mms100b.searchOrderNum(orderNo)
		mms100b.goToDOROToolbox(orderNo)

		mws442b.goToDOROReceiptOfRow(0)

		mws445b.ConfirmAll()
		mws445b.ClickPrevious()

		mws442b.ClickPrevious()

		Assert.assertEquals(mms100b.GetLwsOfOrder(orderNo), "99", "Lws stat was incorrect")
		Assert.assertEquals(mms100b.GetHisOfOrder(orderNo), "99", "His stat was incorrect")

		mms100b.closeAllTabs()
		
		// --------Video 4 Ends Here------------------
	}
}
