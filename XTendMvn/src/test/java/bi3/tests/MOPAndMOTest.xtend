package bi3.tests

import bi3.framework.util.DateUtil
import bi3.pages.HomePage
import bi3.pages.LoginPage
import bi3.pages.crs207.CRS207_B
import bi3.pages.mms001.MMS001
import bi3.pages.pms001.PMS001
import bi3.pages.pms001.PMS001_B
import bi3.pages.pms001.PMS001_E
import bi3.pages.pms001.PMS001_F
import bi3.pages.pms001.PMS270_B1
import bi3.pages.pms001.PMS270_E
import bi3.pages.pms100.PMS100_B
import bi3.pages.pms170.PMS170
import bi3.pages.pms170.PMS170A
import bi3.pages.pms170.PMS170B
import bi3.pages.pms170.PMS170E
import org.testng.Assert
import org.testng.annotations.Test
import org.testng.annotations.BeforeMethod

class MOPAndMOTest extends BaseTest {
	
	LoginPage loginPage
	HomePage homePage
	PMS001 pms001
	PMS001_B pms001_b
	PMS001_E pms001_e
	PMS001_F pms001_f
	PMS270_B1 pms270_b1
	PMS270_E pms270_e
	CRS207_B crs207_b
	MMS001 mms001
	PMS100_B pms100_b
	PMS170 pms170
	PMS170A pms170a
    PMS170E pms170e
    PMS170B pms170b
			
	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver)
		homePage = new HomePage(driver)
		pms001=new PMS001(driver);
		pms001_b= new PMS001_B(driver);
		pms001_e= new PMS001_E(driver);
		pms001_f= new PMS001_F(driver);
		pms270_b1= new PMS270_B1(driver);
		pms270_e=new PMS270_E(driver);
		crs207_b=new CRS207_B(driver);
		mms001=new MMS001(driver);
		pms100_b=new PMS100_B(driver);
		pms170 = new PMS170(driver);
		pms170a = new PMS170A (driver);
		pms170e = new PMS170E (driver);
		pms170b = new PMS170B (driver);
		
	}
	
	@Test
	def  void CreateMO(){	
		loginPage.GoTo();
		homePage.GoToPMS001();
		
		var prodNo="Y3187";
		pms001_b.EnterProductNumber(prodNo);
		pms001_b.ClickOnCreate();
		
		pms001_e.EnterFinishDate("170815");
		pms001_e.clickNext();
		
		pms001_f.ClickScheduleNoLookUp();
		pms001_f.EnterF4();
		
        var scheduleNo = DateUtil.GetTimestamp();
        pms270_b1.EnterScheduleNo(scheduleNo);
        pms270_b1.ClickOnCreate();
        
        pms270_e.EnterDescription(scheduleNo);
        pms270_e.clickNext();
        
        pms270_b1.EnterF12();
        
        pms001_f.EnterScheduleNo(scheduleNo);
        pms001_f.clickNext();
        
        crs207_b.EnterDescriptionGrid("200");
        crs207_b.clickNext();
        
        mms001.close();
		 
		homePage.GoToPMS100();

		pms100_b.SearchScheduleNo(scheduleNo);
		var listStatus=pms100_b.GetStatuses(scheduleNo);
		Assert.assertEquals(listStatus.get(0),"20","Status 1 is incorrect");
		Assert.assertEquals(listStatus.get(1),"40","Ho is incorrect");
		Assert.assertEquals(listStatus.get(2),"22","Status 2 is incorrect");		
	}
	
	@Test
	def void CreatMop() {

		loginPage.GoTo();
		homePage.GoToPMS170();
		pms170.SelectCreatMop();
		pms170a.EnterProduct("Y3007-Y03-016");
	/*	pms170a.ClickProduct();
		pms170a.EnterSku("Y3007-Y03-016");
		pms170a.SelectFirstRow();
		pms170a.SelectSku();*/
		pms170a.clickNext();
		/*YYMMDD*/
		pms170e.EnterFinishDate("170625");
		pms170e.EnterPlanQty("60");
		pms170e.SelectStatus("10-Planned order");
		pms170e.SelectOrderType("A01");
		pms170e.clickNext();
		pms170e.clickNext();
		/*pms170e.ClickPrev();
		pms170e.ClickPrev()*/
		pms170e.closeAllTabs()
		homePage.GoToPMS170()

		pms170b.SelectSortingOrder("73-Rsp/Sch/St/Dt");
		pms170b.EnterMainProduct("Y3007");
		pms170b.JointSchedulling();
		var lastJointSchNo = pms170.getLastJoindScheduleNo().substring(8);
		pms170b.clickNext();
		pms170b.RefreshPage();
		pms170b.SearchScheduleNo(lastJointSchNo);
		var lastJointSchNoFromSearch = pms170.getDataFromRow(0).get(1);
		Assert.assertEquals(lastJointSchNo, lastJointSchNoFromSearch, "Schedule Number Is Incorrect");
		pms170b.ReleaseItem();
		mms001.close();
		homePage.GoToPMS100();
		
		pms100_b.EnterMainProduct("Y3007")
		pms100_b.SearchScheduleNo(lastJointSchNoFromSearch);
		pms170b.RefreshPage();

		var listStatus = pms100_b.GetStatuses(lastJointSchNo);
		Assert.assertEquals(listStatus.get(0), "20", "Status 1 is incorrect");
		Assert.assertEquals(listStatus.get(1), "90", "Ho is incorrect");
		Assert.assertEquals(listStatus.get(2), "99", "Status 2 is incorrect");

	}

	
	

	
	
}