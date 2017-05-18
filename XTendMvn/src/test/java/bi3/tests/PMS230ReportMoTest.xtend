package bi3.tests

import bi3.pages.LoginPage
import bi3.pages.HomePage
import bi3.pages.pms230.PMS230B1
import bi3.pages.pms230.PMS230S
import bi3.pages.pms230.PMS060B1
import bi3.pages.pms070.PMS070B1
import org.testng.annotations.Test
import bi3.pages.pms070.PMS070A
import bi3.pages.pms050.PMS050A
import bi3.pages.pms050.PMS050B1
import bi3.pages.pms100.PMS100_B
import bi3.pages.mws410.MWS410B
import org.testng.annotations.BeforeMethod
import org.testng.Assert

class PMS230ReportMoTest extends BaseTest {

	LoginPage loginPage
	HomePage homePage
	PMS230B1 pms230b1
	PMS230S pms230s
	PMS060B1 pms060b1
	PMS070A pms070a
	PMS070B1 pms070b1
	PMS050A pms050a
	PMS050B1 pms050b1
	PMS100_B pms100_b
	MWS410B mws410b

	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver)
		homePage = new HomePage(driver)
		pms230b1 = new PMS230B1(driver)
		pms230s = new PMS230S(driver)
		pms060b1 = new PMS060B1(driver)
		pms070a = new PMS070A(driver)
		pms070b1 = new PMS070B1(driver)
		pms050a = new PMS050A(driver)
		pms050b1 = new PMS050B1(driver)
		pms100_b = new PMS100_B(driver)
		mws410b = new MWS410B(driver)

	}

	@Test
	def void ReportMo() {

		loginPage.GoTo();
		homePage.GoToPMS230();
		pms230b1.SelectScheduleNo();
		pms230s.SelectingScheduleNo("430");
		// pms230s.SelectFirstRow();
		// pms230s.PickScheduleNo();
		pms230s.ClickNext();
		pms230b1.ClickReportIssue();

		Assert.assertEquals(pms060b1.getlblValue, "Manufact Order. Report Issue")
		pms060b1.SelectAllRows();
		var schNo = pms060b1.getSelectedSchNo();
		pms060b1.Confirmation();

		pms060b1.ClickPrev();

		// ReportOperations
		pms230b1.SelectFirstRow();

		pms230b1.ClickReportOperations();
		Assert.assertEquals(pms070a.getOperationReportlblValue, "MO Operation. Report")
		pms070a.clearProductNo();
		pms070a.clearMONumber();
		pms070a.Next();
		pms070b1.SelectAllRows();
		pms070b1.ConfirmationRecord(0);
		pms070b1.closeAllTabs();
		homePage.GoToPMS050();
		Assert.assertEquals(pms050a.getMoReportReceiptlblValue, "Manufact Order. Report Receipt")
		pms050a.EnterScheduleNo(schNo);
		pms050a.clearProductNo();
		pms050a.clearMONumber();
		pms050a.Next();
		pms050b1.SelectAllRows();
		pms050b1.Confirmation();
		pms070b1.closeAllTabs();

		homePage.GoToPMS100();
		pms100_b.ClearProduct();
		pms100_b.ClearMoNo();
		pms100_b.selectRowsWithSchedNum(schNo);
		var listStatus = pms100_b.GetStatuses(schNo);

		if (listStatus.get(0) == "90" && listStatus.get(1) == "90" && listStatus.get(2) == "99") {

			Assert.assertEquals(listStatus.get(0), "90", "Status 1 is incorrect");
			Assert.assertEquals(listStatus.get(1), "90", "Ho is incorrect");
			Assert.assertEquals(listStatus.get(2), "99", "Status 2 is incorrect");
		} else {
			pms100_b.DeliveryToolBox();
			mws410b.SelectAllRows();
			mws410b.relaseForPicking()

			var RipValues = mws410b.TakeRipValue()
			Assert.assertEquals(RipValues.get(0), "1", "Status 1 is incorrect");
			Assert.assertEquals(RipValues.get(1), "1", "Status 1 is incorrect");
			Assert.assertEquals(RipValues.get(2), "1", "Status 1 is incorrect");

			mws410b.SelectAllRows();
			mws410b.PackingList();
			mws410b.ConfirmIssues();

			mws410b.ClickPrev();
			mws410b.ConfirmIssues();
			mws410b.ClickPrev();
			mws410b.ConfirmIssues();
			mws410b.ClickPrev();
			mws410b.ClickPrev();

		}
		if (listStatus.get(0) == "90" && listStatus.get(1) == "90" && listStatus.get(2) == "99") {

			Assert.assertEquals(listStatus.get(0), "90", "Status 1 is incorrect");
			Assert.assertEquals(listStatus.get(1), "90", "Ho is incorrect");
			Assert.assertEquals(listStatus.get(2), "99", "Status 2 is incorrect");

		} else {

			this.doAdditionalStepsToStatusChange(schNo);

		}
	}

	def void doAdditionalStepsToStatusChange(String schedNum) {
		pms100_b.closeAllTabs();
		loginPage.GoTo();

		homePage.GoToPMS070();

		Thread.sleep(1000);

		pms070a.enterScheduleNo(schedNum);
		pms070a.Next();
		pms070b1.SelectAllRows();
		pms070b1.closeOperationsWithStatus80();

		pms070b1.closeAllTabs();

		// homePage.goToHome();
		loginPage.GoTo();
		homePage.GoToPMS050();
		pms050a.EnterScheduleNo(schedNum);
		pms050a.Next();
		pms050b1.SelectAllRows();
		pms050b1.Confirmation();
		pms050b1.closeAllTabs();
		homePage.GoToPMS100();
		pms100_b.selectRowsWithSchedNum(schedNum);
		var listStatus = pms100_b.GetStatuses(schedNum);
		Assert.assertEquals(listStatus.get(0), "90", "Status 1 is incorrect");
		Assert.assertEquals(listStatus.get(1), "90", "Ho is incorrect");
		Assert.assertEquals(listStatus.get(2), "99", "Status 2 is incorrect");

	}
}
