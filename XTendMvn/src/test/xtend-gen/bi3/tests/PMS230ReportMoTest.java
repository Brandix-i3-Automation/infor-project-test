package bi3.tests;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.mws410.MWS410B;
import bi3.pages.pms050.PMS050A;
import bi3.pages.pms050.PMS050B1;
import bi3.pages.pms070.PMS070A;
import bi3.pages.pms070.PMS070B1;
import bi3.pages.pms100.PMS100_B;
import bi3.pages.pms230.PMS060B1;
import bi3.pages.pms230.PMS230B1;
import bi3.pages.pms230.PMS230S;
import bi3.tests.BaseTest;
import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class PMS230ReportMoTest extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private PMS230B1 pms230b1;
  
  private PMS230S pms230s;
  
  private PMS060B1 pms060b1;
  
  private PMS070A pms070a;
  
  private PMS070B1 pms070b1;
  
  private PMS050A pms050a;
  
  private PMS050B1 pms050b1;
  
  private PMS100_B pms100_b;
  
  private MWS410B mws410b;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    PMS230B1 _pMS230B1 = new PMS230B1(BaseTest.driver);
    this.pms230b1 = _pMS230B1;
    PMS230S _pMS230S = new PMS230S(BaseTest.driver);
    this.pms230s = _pMS230S;
    PMS060B1 _pMS060B1 = new PMS060B1(BaseTest.driver);
    this.pms060b1 = _pMS060B1;
    PMS070A _pMS070A = new PMS070A(BaseTest.driver);
    this.pms070a = _pMS070A;
    PMS070B1 _pMS070B1 = new PMS070B1(BaseTest.driver);
    this.pms070b1 = _pMS070B1;
    PMS050A _pMS050A = new PMS050A(BaseTest.driver);
    this.pms050a = _pMS050A;
    PMS050B1 _pMS050B1 = new PMS050B1(BaseTest.driver);
    this.pms050b1 = _pMS050B1;
    PMS100_B _pMS100_B = new PMS100_B(BaseTest.driver);
    this.pms100_b = _pMS100_B;
    MWS410B _mWS410B = new MWS410B(BaseTest.driver);
    this.mws410b = _mWS410B;
  }
  
  @Test
  public void ReportMo() {
    this.loginPage.GoTo();
    this.homePage.GoToPMS230();
    this.pms230b1.SelectScheduleNo();
    this.pms230s.SelectingScheduleNo("430");
    this.pms230s.ClickNext();
    this.pms230b1.ClickReportIssue();
    Assert.assertEquals(this.pms060b1.getlblValue(), "Manufact Order. Report Issue");
    this.pms060b1.SelectAllRows();
    String schNo = this.pms060b1.getSelectedSchNo();
    this.pms060b1.Confirmation();
    this.pms060b1.ClickPrev();
    this.pms230b1.SelectFirstRow();
    this.pms230b1.ClickReportOperations();
    Assert.assertEquals(this.pms070a.getOperationReportlblValue(), "MO Operation. Report");
    this.pms070a.clearProductNo();
    this.pms070a.clearMONumber();
    this.pms070a.Next();
    this.pms070b1.SelectAllRows();
    this.pms070b1.ConfirmationRecord(0);
    this.pms070b1.closeAllTabs();
    this.homePage.GoToPMS050();
    Assert.assertEquals(this.pms050a.getMoReportReceiptlblValue(), "Manufact Order. Report Receipt");
    this.pms050a.EnterScheduleNo(schNo);
    this.pms050a.clearProductNo();
    this.pms050a.clearMONumber();
    this.pms050a.Next();
    this.pms050b1.SelectAllRows();
    this.pms050b1.Confirmation();
    this.pms070b1.closeAllTabs();
    this.homePage.GoToPMS100();
    this.pms100_b.ClearProduct();
    this.pms100_b.ClearMoNo();
    this.pms100_b.selectRowsWithSchedNum(schNo);
    List<String> listStatus = this.pms100_b.GetStatuses(schNo);
    if (((Objects.equal(listStatus.get(0), "90") && Objects.equal(listStatus.get(1), "90")) && Objects.equal(listStatus.get(2), "99"))) {
      Assert.assertEquals(listStatus.get(0), "90", "Status 1 is incorrect");
      Assert.assertEquals(listStatus.get(1), "90", "Ho is incorrect");
      Assert.assertEquals(listStatus.get(2), "99", "Status 2 is incorrect");
    } else {
      this.pms100_b.DeliveryToolBox();
      this.mws410b.SelectAllRows();
      this.mws410b.relaseForPicking();
      List<String> RipValues = this.mws410b.TakeRipValue();
      Assert.assertEquals(RipValues.get(0), "1", "Status 1 is incorrect");
      Assert.assertEquals(RipValues.get(1), "1", "Status 1 is incorrect");
      Assert.assertEquals(RipValues.get(2), "1", "Status 1 is incorrect");
      this.mws410b.SelectAllRows();
      this.mws410b.PackingList();
      this.mws410b.ConfirmIssues();
      this.mws410b.ClickPrev();
      this.mws410b.ConfirmIssues();
      this.mws410b.ClickPrev();
      this.mws410b.ConfirmIssues();
      this.mws410b.ClickPrev();
      this.mws410b.ClickPrev();
    }
    if (((Objects.equal(listStatus.get(0), "90") && Objects.equal(listStatus.get(1), "90")) && Objects.equal(listStatus.get(2), "99"))) {
      Assert.assertEquals(listStatus.get(0), "90", "Status 1 is incorrect");
      Assert.assertEquals(listStatus.get(1), "90", "Ho is incorrect");
      Assert.assertEquals(listStatus.get(2), "99", "Status 2 is incorrect");
    } else {
      this.doAdditionalStepsToStatusChange(schNo);
    }
  }
  
  public void doAdditionalStepsToStatusChange(final String schedNum) {
    try {
      this.pms100_b.closeAllTabs();
      this.loginPage.GoTo();
      this.homePage.GoToPMS070();
      Thread.sleep(1000);
      this.pms070a.enterScheduleNo(schedNum);
      this.pms070a.Next();
      this.pms070b1.SelectAllRows();
      this.pms070b1.closeOperationsWithStatus80();
      this.pms070b1.closeAllTabs();
      this.loginPage.GoTo();
      this.homePage.GoToPMS050();
      this.pms050a.EnterScheduleNo(schedNum);
      this.pms050a.Next();
      this.pms050b1.SelectAllRows();
      this.pms050b1.Confirmation();
      this.pms050b1.closeAllTabs();
      this.homePage.GoToPMS100();
      this.pms100_b.selectRowsWithSchedNum(schedNum);
      List<String> listStatus = this.pms100_b.GetStatuses(schedNum);
      Assert.assertEquals(listStatus.get(0), "90", "Status 1 is incorrect");
      Assert.assertEquals(listStatus.get(1), "90", "Ho is incorrect");
      Assert.assertEquals(listStatus.get(2), "99", "Status 2 is incorrect");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
