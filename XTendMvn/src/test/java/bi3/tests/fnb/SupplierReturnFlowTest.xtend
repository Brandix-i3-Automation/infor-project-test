package bi3.tests.fnb

import bi3.pages.HomePage
import bi3.pages.LoginPage
import bi3.tests.BaseTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import bi3.pages.pps390.PPS390
import bi3.pages.pps820.PPS820E
import bi3.pages.mns212.MNS212B1
import bi3.pages.mms100.MMS100B1
import bi3.pages.mws410.MWS410B
import bi3.pages.mws420.MWS420B1
import org.testng.Assert
import bi3.pages.pps390.PPS390B1

import bi3.pages.pps200.*
import bi3.pages.pps201.PPS201B
import org.testng.Assert
import bi3.configuration.settings.PPS300SettingsTest
import bi3.pages.pps300.PPS300A
import bi3.pages.pps300.PPS300E
import bi3.configuration.settings.PPS320SettingsTest
import bi3.pages.pps330.PPS330B
import bi3.pages.pps320.PPS320A
import bi3.pages.pps320.PPS320E
import bi3.pages.mns212.MNS212B
import bi3.configuration.settings.PPS310SettingsTest
import bi3.pages.pps310.PPS310A
import bi3.pages.pps310.PPS310E
import bi3.pages.pps311.PPS311E
import bi3.pages.pps390.PPS390B
import bi3.pages.pps390.PPS390E
import bi3.pages.pps390.PPS390F
import bi3.pages.pps390.PPS390G
import bi3.framework.util.DataUtil

class SupplierReturnFlowTest extends BaseTest {

	HomePage homePage
	LoginPage loginPage
	PPS390 pps390
	PPS820E pps820e
	MNS212B1 mns212b1
	MMS100B1 mms100b1
	MWS410B mws410b
	MWS420B1 mws420b1
	PPS390B1 pps390b1

	PPS200B pps200b
	PPS200C pps200c
	PPS200E pps200e
	PPS200F pps200f
	PPS200G pps200g
	PPS200H pps200h
	
	PPS201B pps201b
	
	PPS300SettingsTest pps300Settings
	PPS300A pps300a
	PPS300E pps300e
	
	PPS330B pps330b
	
	PPS320SettingsTest pps320Settings
	PPS320A pps320a
	PPS320E pps320e
	
	MNS212B mns212b
	
	PPS310SettingsTest pps310Settings
	PPS310A pps310a
	PPS310E pps310e 
	
	PPS311E pps311e
	
	PPS390B pps390b
	PPS390E pps390e
	PPS390F pps390f
	PPS390G pps390g

	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver)
		homePage = new HomePage(driver)
		pps390 = new PPS390(driver)
		pps820e = new PPS820E(driver)
		mns212b1 = new MNS212B1(driver)
		mms100b1 = new MMS100B1(driver)
		mws410b = new MWS410B(driver)
		mws420b1 = new MWS420B1(driver)
		pps390b1 = new PPS390B1(driver)
		pps200b = new PPS200B(driver)
		pps200c = new PPS200C(driver)
		pps200e = new PPS200E(driver)
		pps200f = new PPS200F(driver)
		pps200g = new PPS200G(driver)
		pps200h = new PPS200H(driver)
		
		pps201b = new PPS201B(driver)
		
		pps300Settings = new PPS300SettingsTest(driver)
		pps300a = new PPS300A(driver)
		
		pps300e = new PPS300E(driver)
		
		pps330b = new PPS330B(driver)
		
		pps320Settings = new PPS320SettingsTest(driver)
		pps320a = new PPS320A(driver)
		pps320e = new PPS320E(driver)
		
		mns212b = new MNS212B(driver)
		
		pps310Settings = new PPS310SettingsTest(driver)
		pps310a = new PPS310A(driver)
		pps310e = new PPS310E(driver)
		
		pps311e = new PPS311E(driver)
		
		pps390b = new PPS390B(driver)
		pps390e = new PPS390E(driver)
		pps390f = new PPS390F(driver)
		pps390g = new PPS390G(driver)
	}

	/**
	 * @TestCaseID: SRT001
	 * @CloudSuite: F&B
	 * @Description: This test case includes the Supplier Return Flow
	 * @author:	rasithae
	 */
	@Test
	def void SupplierReturnFlowTest() {
		
		//var String rtsOrderNo = "0002000010";
		var String sortingOrderLabel = "3-Ref order cat";
		var String roc = "9";
		var String relatedOption1 = "Picking Lists";
		var String relatedOption2 = "Delivery Toolbox";
		var String relatedOption3 = "Confirm Issues";
		
		var poNumCopied = "2000157"
		var newPONum = ""
		var warehouse = "002"
		var facility = "A01"
		var location = "YRA0104"
		var QIResult = "4-Rejected"
		var rejReasonCode = "01"
		
		loginPage.GoTo()
		homePage.GoToPPS200()
		
		pps200b.SearchPONo(poNumCopied)
		
		//Copying PO 
		pps200b.copyPO(poNumCopied)
		//pps200c.SetNewPONum(newPONum)
		pps200c.ClearNewPONumber()
		pps200c.ClickNext()
		
		
		newPONum = pps200e.getNewPONumber()
		System.out.println("New PO Number :"+newPONum)
		
		pps200e.ClickNext()
		pps200f.ClickNext()
		pps200g.ClickNext()
		
		Assert.assertEquals(pps201b.getPageId(),"PPS201/B1")
		Assert.assertFalse(pps201b.CheckIfDetailsGridEmpty(),"Details grid in PPS201B was empty")
		
		pps201b.ClickPrevious()
		pps200g.ClickPrevious()
		pps200f.ClickPrevious()
		pps200e.ClickPrevious()
		
		Assert.assertTrue(pps200b.SearchPONo(newPONum),"Copied PO was not found in the PPS200 grid")
		
		pps200b.closeAllTabs()
		
		//GRN
		//Settings to set opening panel of PPS300 as Entry
		pps300Settings.SetOpeningPanel("A-Entry")
		pps300a.setPONum(newPONum)
		pps300a.SetPurchaseOrderLineFromLookUp(newPONum)
		//pps300a.SetPurchaseOrderLineSubNumFromLookUp(newPONum)
		pps300a.setWarehouse(warehouse)
		pps300a.ClickNext()
		
		if(pps300a.getPageId().contains("PPS300/A")){
			pps300a.ClickNext()
		}
		
		if(pps300a.getPageId().contains("PPS300/A")){
			pps300a.ClickNext()
		}
		
		pps300e.SetRecieveQtyAsConfirmedQty()
		pps300e.ClickNext()
		
		pps300a.closeAllTabs()
		
		homePage.GoToPPS330()
		
		pps330b.searchForPO(newPONum,warehouse)
		var recievingNo = pps330b.getRecievingNoOf(newPONum)
		System.out.println("Recieving Number : "+recievingNo)
		pps330b.closeAllTabs()
		
		//PO Put away in PPS320
		//Settings to set opening panel of PPS320 as Entry
		pps320Settings.SetOpeningPanel("A-Entry")
		
		pps320a.setReceivingNo(recievingNo)
		pps320a.setWarehouse(warehouse)
		pps320a.ClickNext()
		
		if(pps320a.getPageId().contains("PPS320/A")){
			pps320a.ClickNext()
		}

		pps320e.EnterStoredQtyAsRecieved()
		pps320e.SetLocationFromText(location)
		pps320e.Next()
		pps320e.ClickPrevious()
		
		mns212b.ConfirmOutput()
		mns212b.closeAllTabs()
		
		//Inspection PPS310
		pps310Settings.SetOpeningPanel("A-Entry")
		pps310a.SetWarehouse(warehouse)
		pps310a.SetRecievingNo(recievingNo)
		pps310a.ClickNext()
		
		if(pps310a.getPageId().contains("PPS310/A")){
			pps310a.ClickNext()
		}
		
		pps310e.SetQIResult(QIResult)
		pps310e.EnterRejectedQtyAsRecieved()
		pps310e.EnterRejectReason(rejReasonCode)
		pps310e.Next()
		
		pps311e.ClickNext()
		
		pps310a.ClickPrevious()
		
		mns212b.ConfirmOutput()
		mns212b.closeAllTabs()
		
		homePage.GoToPPS390()
		pps390b.SelectSortingOrder("5-Facility, warehouse, PO no, return no")
		pps390b.SearchBy(newPONum,facility,warehouse);
		pps390b.ChangeRecordWithPO(newPONum)
		pps390e.SelectStatusAs("06-Active")
		var rtsNo = pps390e.GetRtsOrderNo()
		System.out.println("RTS Order No : "+rtsNo)
		pps390e.ClickNext()
		pps390f.ClickNext()
		pps390g.ClickNext()
		
		pps390g.closeAllTabs()
		
		homePage.goToHome()
		homePage.GoToPPS200()
		
		pps200b.SearchPONo(newPONum)var stat = pps200b.GetLstOfRecordWithPO(newPONum)
		Assert.assertEquals(stat,"15","Status was not 15 in PPS200b")
		
		pps200b.closeAllTabs()

		homePage.GoToPPS390();
		pps390b1.selectLastRow();
		pps390.goToPrintPage();
		pps820e.clearReference();
		pps820e.fillRtsOrderNo(rtsNo);
		mns212b1.confirmOutPut();
		pps390b1.refreshPage();
		pps390b1.changeSortingOrder("1-Our responsible, warehouse, return no");
		pps390b1.refreshPage();
		pps390b1.filterGrid("FABPLANNER", "002", rtsNo);
		
		// TO:Do - confirm the status 20 in PPS390
		Assert.assertEquals(pps390b1.getColumnVal("Lst"), "20");
		Assert.assertEquals(pps390b1.getColumnVal("Hst"), "20");
		
		mns212b1.closeAllTabs();
		
		homePage.GoToMMS100();
		
		mms100b1.selectSortingOrder(sortingOrderLabel);
		mms100b1.filterRequestOrder(roc, rtsNo);
		mms100b1.goToRelatedOption(relatedOption2);
		
		mws410b.goToRelatedOption(relatedOption1);
		
		mws420b1.goToRelatedOption(relatedOption3);
		mws420b1.ClickPrevious();
		
		mws410b.refreshPage();
		mws410b.ClickPrevious();
		
		mms100b1.refreshPage();
		
		// TO:Do - confirm the status 99
		Assert.assertEquals(mms100b1.getColumnVal("Lws", 0), "99");
		Assert.assertEquals(mms100b1.getColumnVal("His", 0), "99");
	}
}
