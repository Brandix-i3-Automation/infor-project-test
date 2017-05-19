package bi3.tests.fnb

import bi3.pages.HomePage
import bi3.pages.LoginPage
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import bi3.framework.config.ConfigKeys
import bi3.framework.util.ExcelUtil
import java.util.HashMap
import org.testng.Assert
import bi3.pages.ToolbarPage
import bi3.tests.BaseTest
import bi3.pages.ois390.OIS390A
import bi3.pages.ois390.OIS390E
import bi3.pages.ois390.OIS391E
import bi3.pages.ois390.OIS392E
import bi3.pages.ois390.OIS391B1
import bi3.pages.ois390.OIS390B1
import bi3.pages.ois390.OIS393B
import bi3.pages.ois275.OIS275B_1
import bi3.pages.ois100.OIS100H
import bi3.pages.ois276.OIS276B
import bi3.pages.ois101.OIS101E
import bi3.pages.ois300.OIS300B
import bi3.configuration.settings.OIS390SettingTest

class CustomerReturnTest extends BaseTest {

	LoginPage loginPage
	HomePage homePage
	OIS390A ois390a
	OIS390E ois390e
	OIS391E ois391e
	OIS392E ois392e
	OIS391B1 ois391b1
	private ToolbarPage toolbarPage
	OIS390SettingTest ois390settingTest
	OIS390B1 ois390b1
	OIS393B ois393b
	OIS275B_1 OIS275b_1;
	OIS100H ois100h;
	OIS276B ois276b
	OIS101E ois101e
	ToolbarPage toolBarPage
	OIS300B ois300b

	ExcelUtil ois390Adata;
	HashMap<String, String> hashMap;

	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		ois390a = new OIS390A(driver);
		ois390e = new OIS390E(driver);
		toolbarPage = new ToolbarPage(driver);
		ois391e = new OIS391E(driver);
		ois392e = new OIS392E(driver);
		ois391b1 = new OIS391B1(driver);
		ois390settingTest = new OIS390SettingTest(driver);
		ois390b1 = new OIS390B1(driver);
		ois393b = new OIS393B(driver);
		OIS275b_1 = new OIS275B_1(driver);
		ois100h = new OIS100H(driver);
		ois276b = new OIS276B(driver)
		ois101e = new OIS101E(driver);
		toolBarPage = new ToolbarPage(driver);
		ois300b = new OIS300B(driver);

		val path = ConfigKeys.DATA_HELPER_PATH;
		val sheetOIS390A = "OIS390A";

		ois390Adata = new ExcelUtil(path, sheetOIS390A);
		hashMap = ois390Adata.getExcelActiveSheetFirstTwoColumnData;

	}

	@Test
	def void CustomerOrderCreation() {

		// TestData
		var String warehouse = hashMap.get("Warehouse").toString();
		var String coNumber = hashMap.get("Refordercat").toString();
		var String transReason = hashMap.get("TransReason").toString();
		var String returnedQty = hashMap.get("ReturnedQty").toString();
		var String rejectedQty = hashMap.get("RejectedQty").toString();
		var String location = hashMap.get("Location").toString();

		// Test
		ois390settingTest.SetOpeningPanel("A-Entry")
		// loginPage.GoTo();
		// homePage.GoToOIS390();
		ois390a.SetPanelSqequence(warehouse);
		ois390a.selectCoNumber(coNumber);
		ois390a.clickNext();
		Assert.assertEquals(ois390a.getM3lblValue, "Order already returned Order number " + "00" + coNumber + "");
		ois390a.confirmInfoBox();
		ois390e.selectTransReason(transReason);
		ois390e.clickNext();
		var receivingNo = ois391b1.getReceivingNoValue()
		toolbarPage.ClickAction_Retrieve();
		ois391e.SelectFirstRows();
		toolbarPage.ClickOption_Change();
		ois391e.enterReturnedQty(returnedQty);
		ois391e.clickNext();
		ois391e.clickNext();
		ois392e.enterRejectedQty(rejectedQty);
		var lotNumber = ois392e.getLotValue;
		ois392e.enterLotNumber(lotNumber);
		ois392e.enterLocation(location);
		ois392e.clickNext();
		toolbarPage.ClickAction_Update();
		toolbarPage.clickRelated("Inspection");
		ois392e.enterLotNumber(lotNumber);
		ois392e.enterLocation(location);
		toolbarPage.ClickAction_Update();
		ois391b1.closeAllTabs();
		/*ois391b1.ClickPrev();
		 * ois390e.ClickPrev();
		 * ois390a.ClickPrev();
		 ois390a.ClickPrev();*/
		ois390settingTest.SetOpeningPanel("B-Browse")
		ois390b1.enterRecvnNo(receivingNo);
		ois390b1.selectFirstRows();
		toolbarPage.clickRelated("Crt credit");
		toolbarPage.ClickAction_Update();

		var temporaryOrder = ois393b.getTemporaryOrderValue().split(" ");

		var genaratedtemporaryOrder = temporaryOrder.get(4);

		ois390b1.closeAllTabs();
		homePage.GoToOIS275();
		// check/release CO Number 
		OIS275b_1.enterTemporaryOrdrNo(genaratedtemporaryOrder);
		toolBarPage.clickRelated("Check/release");

		ois100h.FillTax("NOT");
		ois100h.ClickNext();
		ois276b.ClickPreviousPage;

		// check/release CO Number
		OIS275b_1.enterTemporaryOrdrNo(genaratedtemporaryOrder);
		toolBarPage.clickRelated("Check/release");

		// OIS276B page
		ois276b.Release();
		ois276b.ClickWarningOkButton();
		ois101e.clickNext();
		toolBarPage.ClickAction_Refresh();

		// Copy CoNumber
		var CONumber = ois276b.CopyCONumber();
		System.out.println("CO Number :" + CONumber)

		ois276b.closeAllTabs;

		// Go To OIS300
		homePage.GoToOIS300();

		ois300b.searchCONumber(CONumber);

		// Set the sorting order to 1
		ois300b.setSortingOrder("1-Order Number");
		var status = ois300b.getFirstRowStatus();
		Assert.assertEquals(status,"66");

	}

}

