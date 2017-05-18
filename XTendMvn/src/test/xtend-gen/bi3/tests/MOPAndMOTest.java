package bi3.tests;

import bi3.framework.util.DateUtil;
import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.crs207.CRS207_B;
import bi3.pages.mms001.MMS001;
import bi3.pages.pms001.PMS001;
import bi3.pages.pms001.PMS001_B;
import bi3.pages.pms001.PMS001_E;
import bi3.pages.pms001.PMS001_F;
import bi3.pages.pms001.PMS270_B1;
import bi3.pages.pms001.PMS270_E;
import bi3.pages.pms100.PMS100_B;
import bi3.pages.pms170.PMS170;
import bi3.pages.pms170.PMS170A;
import bi3.pages.pms170.PMS170B;
import bi3.pages.pms170.PMS170E;
import bi3.tests.BaseTest;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class MOPAndMOTest extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private PMS001 pms001;
  
  private PMS001_B pms001_b;
  
  private PMS001_E pms001_e;
  
  private PMS001_F pms001_f;
  
  private PMS270_B1 pms270_b1;
  
  private PMS270_E pms270_e;
  
  private CRS207_B crs207_b;
  
  private MMS001 mms001;
  
  private PMS100_B pms100_b;
  
  private PMS170 pms170;
  
  private PMS170A pms170a;
  
  private PMS170E pms170e;
  
  private PMS170B pms170b;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    PMS001 _pMS001 = new PMS001(BaseTest.driver);
    this.pms001 = _pMS001;
    PMS001_B _pMS001_B = new PMS001_B(BaseTest.driver);
    this.pms001_b = _pMS001_B;
    PMS001_E _pMS001_E = new PMS001_E(BaseTest.driver);
    this.pms001_e = _pMS001_E;
    PMS001_F _pMS001_F = new PMS001_F(BaseTest.driver);
    this.pms001_f = _pMS001_F;
    PMS270_B1 _pMS270_B1 = new PMS270_B1(BaseTest.driver);
    this.pms270_b1 = _pMS270_B1;
    PMS270_E _pMS270_E = new PMS270_E(BaseTest.driver);
    this.pms270_e = _pMS270_E;
    CRS207_B _cRS207_B = new CRS207_B(BaseTest.driver);
    this.crs207_b = _cRS207_B;
    MMS001 _mMS001 = new MMS001(BaseTest.driver);
    this.mms001 = _mMS001;
    PMS100_B _pMS100_B = new PMS100_B(BaseTest.driver);
    this.pms100_b = _pMS100_B;
    PMS170 _pMS170 = new PMS170(BaseTest.driver);
    this.pms170 = _pMS170;
    PMS170A _pMS170A = new PMS170A(BaseTest.driver);
    this.pms170a = _pMS170A;
    PMS170E _pMS170E = new PMS170E(BaseTest.driver);
    this.pms170e = _pMS170E;
    PMS170B _pMS170B = new PMS170B(BaseTest.driver);
    this.pms170b = _pMS170B;
  }
  
  @Test
  public void CreateMO() {
    this.loginPage.GoTo();
    this.homePage.GoToPMS001();
    String prodNo = "Y3187";
    this.pms001_b.EnterProductNumber(prodNo);
    this.pms001_b.ClickOnCreate();
    this.pms001_e.EnterFinishDate("170815");
    this.pms001_e.clickNext();
    this.pms001_f.ClickScheduleNoLookUp();
    this.pms001_f.EnterF4();
    String scheduleNo = DateUtil.GetTimestamp();
    this.pms270_b1.EnterScheduleNo(scheduleNo);
    this.pms270_b1.ClickOnCreate();
    this.pms270_e.EnterDescription(scheduleNo);
    this.pms270_e.clickNext();
    this.pms270_b1.EnterF12();
    this.pms001_f.EnterScheduleNo(scheduleNo);
    this.pms001_f.clickNext();
    this.crs207_b.EnterDescriptionGrid("200");
    this.crs207_b.clickNext();
    this.mms001.close();
    this.homePage.GoToPMS100();
    this.pms100_b.SearchScheduleNo(scheduleNo);
    List<String> listStatus = this.pms100_b.GetStatuses(scheduleNo);
    Assert.assertEquals(listStatus.get(0), "20", "Status 1 is incorrect");
    Assert.assertEquals(listStatus.get(1), "40", "Ho is incorrect");
    Assert.assertEquals(listStatus.get(2), "22", "Status 2 is incorrect");
  }
  
  @Test
  public void CreatMop() {
    this.loginPage.GoTo();
    this.homePage.GoToPMS170();
    this.pms170.SelectCreatMop();
    this.pms170a.EnterProduct("Y3007-Y03-016");
    this.pms170a.clickNext();
    this.pms170e.EnterFinishDate("170625");
    this.pms170e.EnterPlanQty("60");
    this.pms170e.SelectStatus("10-Planned order");
    this.pms170e.SelectOrderType("A01");
    this.pms170e.clickNext();
    this.pms170e.clickNext();
    this.pms170e.closeAllTabs();
    this.homePage.GoToPMS170();
    this.pms170b.SelectSortingOrder("73-Rsp/Sch/St/Dt");
    this.pms170b.EnterMainProduct("Y3007");
    this.pms170b.JointSchedulling();
    String lastJointSchNo = this.pms170.getLastJoindScheduleNo().substring(8);
    this.pms170b.clickNext();
    this.pms170b.RefreshPage();
    this.pms170b.SearchScheduleNo(lastJointSchNo);
    String lastJointSchNoFromSearch = this.pms170.getDataFromRow(0).get(1);
    Assert.assertEquals(lastJointSchNo, lastJointSchNoFromSearch, "Schedule Number Is Incorrect");
    this.pms170b.ReleaseItem();
    this.mms001.close();
    this.homePage.GoToPMS100();
    this.pms100_b.EnterMainProduct("Y3007");
    this.pms100_b.SearchScheduleNo(lastJointSchNoFromSearch);
    this.pms170b.RefreshPage();
    List<String> listStatus = this.pms100_b.GetStatuses(lastJointSchNo);
    Assert.assertEquals(listStatus.get(0), "20", "Status 1 is incorrect");
    Assert.assertEquals(listStatus.get(1), "90", "Ho is incorrect");
    Assert.assertEquals(listStatus.get(2), "99", "Status 2 is incorrect");
  }
}
