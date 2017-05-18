package bi3.tests;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.mms001.MMS001;
import bi3.pages.pms100.PMS100_B;
import bi3.pages.pms170.PMS170;
import bi3.pages.pms170.PMS170A;
import bi3.pages.pms170.PMS170B;
import bi3.pages.pms170.PMS170E;
import bi3.tests.BaseTest;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class PMS170MopCreationTest extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private PMS170 pms170;
  
  private PMS170A pms170a;
  
  private PMS170E pms170e;
  
  private PMS170B pms170b;
  
  private MMS001 mms001;
  
  private PMS100_B pms100_b;
  
  @BeforeTest
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    PMS170 _pMS170 = new PMS170(BaseTest.driver);
    this.pms170 = _pMS170;
    PMS170A _pMS170A = new PMS170A(BaseTest.driver);
    this.pms170a = _pMS170A;
    PMS170E _pMS170E = new PMS170E(BaseTest.driver);
    this.pms170e = _pMS170E;
    PMS170B _pMS170B = new PMS170B(BaseTest.driver);
    this.pms170b = _pMS170B;
    MMS001 _mMS001 = new MMS001(BaseTest.driver);
    this.mms001 = _mMS001;
    PMS100_B _pMS100_B = new PMS100_B(BaseTest.driver);
    this.pms100_b = _pMS100_B;
  }
  
  @Test
  public void CreatMop() {
    this.loginPage.GoTo();
    this.homePage.GoToPMS170();
    this.pms170.SelectCreatMop();
    this.pms170a.EnterProduct("Y3007");
    this.pms170a.ClickProduct();
    this.pms170a.EnterSku("Y3007-Y03-016");
    this.pms170a.SelectFirstRow();
    this.pms170a.SelectSku();
    this.pms170a.clickNext();
    this.pms170e.EnterFinishDate("170425");
    this.pms170e.EnterPlanQty("60");
    this.pms170e.SelectStatus("10-Planned order");
    this.pms170e.SelectOrderType("A01");
    this.pms170e.clickNext();
    this.pms170e.clickNext();
    this.pms170e.ClickPrev();
    this.pms170e.ClickPrev();
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
    this.pms100_b.SearchScheduleNo(lastJointSchNoFromSearch);
    this.pms170b.RefreshPage();
    List<String> listStatus = this.pms100_b.GetStatuses(lastJointSchNo);
    Assert.assertEquals(listStatus.get(0), "20", "Status 1 is incorrect");
    Assert.assertEquals(listStatus.get(1), "90", "Ho is incorrect");
    Assert.assertEquals(listStatus.get(2), "99", "Status 2 is incorrect");
  }
}
