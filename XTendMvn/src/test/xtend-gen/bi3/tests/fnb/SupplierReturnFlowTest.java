package bi3.tests.fnb;

import bi3.configuration.settings.PPS300SettingsTest;
import bi3.configuration.settings.PPS310SettingsTest;
import bi3.configuration.settings.PPS320SettingsTest;
import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.mms100.MMS100B1;
import bi3.pages.mns212.MNS212B;
import bi3.pages.mns212.MNS212B1;
import bi3.pages.mws410.MWS410B;
import bi3.pages.mws420.MWS420B1;
import bi3.pages.pps200.PPS200B;
import bi3.pages.pps200.PPS200C;
import bi3.pages.pps200.PPS200E;
import bi3.pages.pps200.PPS200F;
import bi3.pages.pps200.PPS200G;
import bi3.pages.pps200.PPS200H;
import bi3.pages.pps201.PPS201B;
import bi3.pages.pps300.PPS300A;
import bi3.pages.pps300.PPS300E;
import bi3.pages.pps310.PPS310A;
import bi3.pages.pps310.PPS310E;
import bi3.pages.pps311.PPS311E;
import bi3.pages.pps320.PPS320A;
import bi3.pages.pps320.PPS320E;
import bi3.pages.pps330.PPS330B;
import bi3.pages.pps390.PPS390;
import bi3.pages.pps390.PPS390B;
import bi3.pages.pps390.PPS390B1;
import bi3.pages.pps390.PPS390E;
import bi3.pages.pps390.PPS390F;
import bi3.pages.pps390.PPS390G;
import bi3.pages.pps820.PPS820E;
import bi3.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class SupplierReturnFlowTest extends BaseTest {
  private HomePage homePage;
  
  private LoginPage loginPage;
  
  private PPS390 pps390;
  
  private PPS820E pps820e;
  
  private MNS212B1 mns212b1;
  
  private MMS100B1 mms100b1;
  
  private MWS410B mws410b;
  
  private MWS420B1 mws420b1;
  
  private PPS390B1 pps390b1;
  
  private PPS200B pps200b;
  
  private PPS200C pps200c;
  
  private PPS200E pps200e;
  
  private PPS200F pps200f;
  
  private PPS200G pps200g;
  
  private PPS200H pps200h;
  
  private PPS201B pps201b;
  
  private PPS300SettingsTest pps300Settings;
  
  private PPS300A pps300a;
  
  private PPS300E pps300e;
  
  private PPS330B pps330b;
  
  private PPS320SettingsTest pps320Settings;
  
  private PPS320A pps320a;
  
  private PPS320E pps320e;
  
  private MNS212B mns212b;
  
  private PPS310SettingsTest pps310Settings;
  
  private PPS310A pps310a;
  
  private PPS310E pps310e;
  
  private PPS311E pps311e;
  
  private PPS390B pps390b;
  
  private PPS390E pps390e;
  
  private PPS390F pps390f;
  
  private PPS390G pps390g;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    PPS390 _pPS390 = new PPS390(BaseTest.driver);
    this.pps390 = _pPS390;
    PPS820E _pPS820E = new PPS820E(BaseTest.driver);
    this.pps820e = _pPS820E;
    MNS212B1 _mNS212B1 = new MNS212B1(BaseTest.driver);
    this.mns212b1 = _mNS212B1;
    MMS100B1 _mMS100B1 = new MMS100B1(BaseTest.driver);
    this.mms100b1 = _mMS100B1;
    MWS410B _mWS410B = new MWS410B(BaseTest.driver);
    this.mws410b = _mWS410B;
    MWS420B1 _mWS420B1 = new MWS420B1(BaseTest.driver);
    this.mws420b1 = _mWS420B1;
    PPS390B1 _pPS390B1 = new PPS390B1(BaseTest.driver);
    this.pps390b1 = _pPS390B1;
    PPS200B _pPS200B = new PPS200B(BaseTest.driver);
    this.pps200b = _pPS200B;
    PPS200C _pPS200C = new PPS200C(BaseTest.driver);
    this.pps200c = _pPS200C;
    PPS200E _pPS200E = new PPS200E(BaseTest.driver);
    this.pps200e = _pPS200E;
    PPS200F _pPS200F = new PPS200F(BaseTest.driver);
    this.pps200f = _pPS200F;
    PPS200G _pPS200G = new PPS200G(BaseTest.driver);
    this.pps200g = _pPS200G;
    PPS200H _pPS200H = new PPS200H(BaseTest.driver);
    this.pps200h = _pPS200H;
    PPS201B _pPS201B = new PPS201B(BaseTest.driver);
    this.pps201b = _pPS201B;
    PPS300SettingsTest _pPS300SettingsTest = new PPS300SettingsTest(BaseTest.driver);
    this.pps300Settings = _pPS300SettingsTest;
    PPS300A _pPS300A = new PPS300A(BaseTest.driver);
    this.pps300a = _pPS300A;
    PPS300E _pPS300E = new PPS300E(BaseTest.driver);
    this.pps300e = _pPS300E;
    PPS330B _pPS330B = new PPS330B(BaseTest.driver);
    this.pps330b = _pPS330B;
    PPS320SettingsTest _pPS320SettingsTest = new PPS320SettingsTest(BaseTest.driver);
    this.pps320Settings = _pPS320SettingsTest;
    PPS320A _pPS320A = new PPS320A(BaseTest.driver);
    this.pps320a = _pPS320A;
    PPS320E _pPS320E = new PPS320E(BaseTest.driver);
    this.pps320e = _pPS320E;
    MNS212B _mNS212B = new MNS212B(BaseTest.driver);
    this.mns212b = _mNS212B;
    PPS310SettingsTest _pPS310SettingsTest = new PPS310SettingsTest(BaseTest.driver);
    this.pps310Settings = _pPS310SettingsTest;
    PPS310A _pPS310A = new PPS310A(BaseTest.driver);
    this.pps310a = _pPS310A;
    PPS310E _pPS310E = new PPS310E(BaseTest.driver);
    this.pps310e = _pPS310E;
    PPS311E _pPS311E = new PPS311E(BaseTest.driver);
    this.pps311e = _pPS311E;
    PPS390B _pPS390B = new PPS390B(BaseTest.driver);
    this.pps390b = _pPS390B;
    PPS390E _pPS390E = new PPS390E(BaseTest.driver);
    this.pps390e = _pPS390E;
    PPS390F _pPS390F = new PPS390F(BaseTest.driver);
    this.pps390f = _pPS390F;
    PPS390G _pPS390G = new PPS390G(BaseTest.driver);
    this.pps390g = _pPS390G;
  }
  
  /**
   * @TestCaseID: SRT001
   * @CloudSuite: F&B
   * @Description: This test case includes the Supplier Return Flow
   * @author:	rasithae
   */
  @Test
  public void SupplierReturnFlowTest() {
    String sortingOrderLabel = "3-Ref order cat";
    String roc = "9";
    String relatedOption1 = "Picking Lists";
    String relatedOption2 = "Delivery Toolbox";
    String relatedOption3 = "Confirm Issues";
    String poNumCopied = "2000157";
    String newPONum = "";
    String warehouse = "002";
    String facility = "A01";
    String location = "YRA0104";
    String QIResult = "4-Rejected";
    String rejReasonCode = "01";
    this.loginPage.GoTo();
    this.homePage.GoToPPS200();
    this.pps200b.SearchPONo(poNumCopied);
    this.pps200b.copyPO(poNumCopied);
    this.pps200c.ClearNewPONumber();
    this.pps200c.ClickNext();
    newPONum = this.pps200e.getNewPONumber();
    System.out.println(("New PO Number :" + newPONum));
    this.pps200e.ClickNext();
    this.pps200f.ClickNext();
    this.pps200g.ClickNext();
    Assert.assertEquals(this.pps201b.getPageId(), "PPS201/B1");
    Assert.assertFalse(this.pps201b.CheckIfDetailsGridEmpty(), "Details grid in PPS201B was empty");
    this.pps201b.ClickPrevious();
    this.pps200g.ClickPrevious();
    this.pps200f.ClickPrevious();
    this.pps200e.ClickPrevious();
    Assert.assertTrue(this.pps200b.SearchPONo(newPONum), "Copied PO was not found in the PPS200 grid");
    this.pps200b.closeAllTabs();
    this.pps300Settings.SetOpeningPanel("A-Entry");
    this.pps300a.setPONum(newPONum);
    this.pps300a.SetPurchaseOrderLineFromLookUp(newPONum);
    this.pps300a.setWarehouse(warehouse);
    this.pps300a.ClickNext();
    boolean _contains = this.pps300a.getPageId().contains("PPS300/A");
    if (_contains) {
      this.pps300a.ClickNext();
    }
    boolean _contains_1 = this.pps300a.getPageId().contains("PPS300/A");
    if (_contains_1) {
      this.pps300a.ClickNext();
    }
    this.pps300e.SetRecieveQtyAsConfirmedQty();
    this.pps300e.ClickNext();
    this.pps300a.closeAllTabs();
    this.homePage.GoToPPS330();
    this.pps330b.searchForPO(newPONum, warehouse);
    String recievingNo = this.pps330b.getRecievingNoOf(newPONum);
    System.out.println(("Recieving Number : " + recievingNo));
    this.pps330b.closeAllTabs();
    this.pps320Settings.SetOpeningPanel("A-Entry");
    this.pps320a.setReceivingNo(recievingNo);
    this.pps320a.setWarehouse(warehouse);
    this.pps320a.ClickNext();
    boolean _contains_2 = this.pps320a.getPageId().contains("PPS320/A");
    if (_contains_2) {
      this.pps320a.ClickNext();
    }
    this.pps320e.EnterStoredQtyAsRecieved();
    this.pps320e.SetLocationFromText(location);
    this.pps320e.Next();
    this.pps320e.ClickPrevious();
    this.mns212b.ConfirmOutput();
    this.mns212b.closeAllTabs();
    this.pps310Settings.SetOpeningPanel("A-Entry");
    this.pps310a.SetWarehouse(warehouse);
    this.pps310a.SetRecievingNo(recievingNo);
    this.pps310a.ClickNext();
    boolean _contains_3 = this.pps310a.getPageId().contains("PPS310/A");
    if (_contains_3) {
      this.pps310a.ClickNext();
    }
    this.pps310e.SetQIResult(QIResult);
    this.pps310e.EnterRejectedQtyAsRecieved();
    this.pps310e.EnterRejectReason(rejReasonCode);
    this.pps310e.Next();
    this.pps311e.ClickNext();
    this.pps310a.ClickPrevious();
    this.mns212b.ConfirmOutput();
    this.mns212b.closeAllTabs();
    this.homePage.GoToPPS390();
    this.pps390b.SelectSortingOrder("5-Facility, warehouse, PO no, return no");
    this.pps390b.SearchBy(newPONum, facility, warehouse);
    this.pps390b.ChangeRecordWithPO(newPONum);
    this.pps390e.SelectStatusAs("06-Active");
    String rtsNo = this.pps390e.GetRtsOrderNo();
    System.out.println(("RTS Order No : " + rtsNo));
    this.pps390e.ClickNext();
    this.pps390f.ClickNext();
    this.pps390g.ClickNext();
    this.pps390g.closeAllTabs();
    this.homePage.goToHome();
    this.homePage.GoToPPS200();
    this.pps200b.SearchPONo(newPONum);
    String stat = this.pps200b.GetLstOfRecordWithPO(newPONum);
    Assert.assertEquals(stat, "15", "Status was not 15 in PPS200b");
    this.pps200b.closeAllTabs();
    this.homePage.GoToPPS390();
    this.pps390b1.selectLastRow();
    this.pps390.goToPrintPage();
    this.pps820e.clearReference();
    this.pps820e.fillRtsOrderNo(rtsNo);
    this.mns212b1.confirmOutPut();
    this.pps390b1.refreshPage();
    this.pps390b1.changeSortingOrder("1-Our responsible, warehouse, return no");
    this.pps390b1.refreshPage();
    this.pps390b1.filterGrid("FABPLANNER", "002", rtsNo);
    Assert.assertEquals(this.pps390b1.getColumnVal("Lst"), "20");
    Assert.assertEquals(this.pps390b1.getColumnVal("Hst"), "20");
    this.mns212b1.closeAllTabs();
    this.homePage.GoToMMS100();
    this.mms100b1.selectSortingOrder(sortingOrderLabel);
    this.mms100b1.filterRequestOrder(roc, rtsNo);
    this.mms100b1.goToRelatedOption(relatedOption2);
    this.mws410b.goToRelatedOption(relatedOption1);
    this.mws420b1.goToRelatedOption(relatedOption3);
    this.mws420b1.ClickPrevious();
    this.mws410b.refreshPage();
    this.mws410b.ClickPrevious();
    this.mms100b1.refreshPage();
    Assert.assertEquals(this.mms100b1.getColumnVal("Lws", 0), "99");
    Assert.assertEquals(this.mms100b1.getColumnVal("His", 0), "99");
  }
}
