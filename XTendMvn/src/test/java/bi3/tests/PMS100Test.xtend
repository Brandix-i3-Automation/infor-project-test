package bi3.tests

import bi3.pages.*
import bi3.pages.pms100.*

import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import org.testng.Assert
import bi3.pages.mws410.MWS410B
import org.testng.annotations.BeforeMethod

class PMS100Test extends BaseTest{
	
	LoginPage loginPage
	HomePage homePage
	PMS100 pms100
	PMS100_B pms100_b
	
	MWS410B mws410b
	
	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver)
		homePage = new HomePage(driver)
		
		pms100 = new PMS100(driver)
		pms100_b = new PMS100_B(driver)
		
		mws410b = new MWS410B(driver)
		
	}
	
	@Test
	def void OpenPMS001(){
		loginPage.GoTo()
		homePage.GoToPMS100()	
		var pageTitle = pms100.getpageTitle()
		Assert.assertTrue(pageTitle.contains("Manufacturing Order. Open"))
	}
	
	@Test
	def void ReleaseForPicking() {

		var schedNo = "178"

		loginPage.GoTo()
		homePage.GoToPMS100()
		var pageTitle = pms100.getpageTitle()
		Assert.assertTrue(pageTitle.contains("Manufacturing Order. Open"))

		pms100_b.SearchScheduleNo(schedNo)

		var firstSchedNo = pms100_b.GetFirstRowScheduleNumber()
		Assert.assertEquals(firstSchedNo, schedNo,
			"Could not find the schedule number " + schedNo + " found " + firstSchedNo)

		pms100_b.goToDeliveryToolbox()

		mws410b.selectView("A84-MO Schedules/Work centers")
	}
	
//	def void RwaMeterialIssuingProcess(){
//		
//		
//		mws410b.GoToMWS410();
//		
//		mws410b.selectComboValuesView("A84-MO Schedules/Work centers");
//		
//		mws410b.MarkRelaseForPicking();
//		
//		mws410b.AddToPickingList();
		
//		mws410b.MoveToPickingList();
//		
//		// confirmation for 90 need to select element
//		mws410b.ConfirmIssues();
//		
//		mws410b.ReleaseForPicking();
//		
//		
//		// Navigate to PMS70 Next process	 
//		mws410b.GoTopms70();
//		
//	}
	
	
}