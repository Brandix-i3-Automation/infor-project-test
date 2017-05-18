package bi3.tests.fnb;

import bi3.configuration.settings.MMS001SettingsTest;
import bi3.configuration.settings.OIS101SettingsTest;
import bi3.configuration.settings.PDS001SettingsTest;
import bi3.configuration.settings.PMS001SettingsTest;
import bi3.configuration.settings.PPS310SettingsTest;
import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.ToolbarPage;
import bi3.pages.dps170.DPS170B;
import bi3.pages.fcs350.FCS350_B;
import bi3.pages.mms080.MMS080B1;
import bi3.pages.mms100.MMS100B;
import bi3.pages.mms100.MMS100B1;
import bi3.pages.mms101.MMS101B;
import bi3.pages.mms101.MMS101B1;
import bi3.pages.mms121.MMS121B1;
import bi3.pages.mns212.MNS212B1;
import bi3.pages.mws410.MWS410B;
import bi3.pages.mws420.MWS420B1;
import bi3.pages.mws423.MWS423B1;
import bi3.pages.mws442.MWS442B;
import bi3.pages.mws445.MWS445B;
import bi3.pages.pps170.PPS170B;
import bi3.pages.pps220.PPS220B;
import bi3.pages.pps220.PPS220G1;
import bi3.pages.pps220.PPS220H1;
import bi3.pages.pps220.PPS220I1;
import bi3.pages.pps270.PPS270E;
import bi3.pages.pps300.PPS300A;
import bi3.pages.pps300.PPS300E;
import bi3.pages.pps300.PPS300SettingsPage;
import bi3.pages.pps310.PPS310A;
import bi3.pages.pps310.PPS310E;
import bi3.pages.pps320.PPS320A;
import bi3.pages.pps320.PPS320E;
import bi3.pages.pps320.PPS320SettingsPage;
import bi3.pages.pps330.PPS330B;
import bi3.pages.pps330.PPS330B1;
import bi3.pages.pps913.PPS913E;
import bi3.tests.BaseTest;
import bi3.tests.fnb.FnBCommons;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class DistributionOrderFlowTest extends FnBCommons {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private FCS350_B fcs350b;
  
  private MMS080B1 mms080b1;
  
  private PPS220B pps220B;
  
  private PPS220H1 pps220H1;
  
  private ToolbarPage toolBarPage;
  
  private PPS220I1 pps220I1;
  
  private PPS270E pps270E;
  
  private PPS300SettingsPage pps300settingsPage;
  
  private PPS300A pps300A;
  
  private PPS300E pps300E;
  
  private PPS330B pps330B;
  
  private PPS320SettingsPage pps320settingsPage;
  
  private PPS320A pps320A;
  
  private PPS320E pps320E;
  
  private MNS212B1 mns212B1;
  
  private PPS310A pps310a;
  
  private PPS310E pps310e;
  
  private MNS212B1 mns212b1;
  
  private PPS330B1 pps330b1;
  
  private PPS310SettingsTest pps310SettingsTest;
  
  private MMS001SettingsTest mms001SettingsTest;
  
  private PDS001SettingsTest pds001SettingsTest;
  
  private PMS001SettingsTest pms001SettingsTest;
  
  private OIS101SettingsTest ois101SettingsTest;
  
  private DPS170B dps170b;
  
  private MMS100B1 mms100b1;
  
  private MMS101B mms101b;
  
  private MMS121B1 mms121b1;
  
  private MMS101B1 mms101b1;
  
  private MWS423B1 mws423b1;
  
  private MWS410B mws410b;
  
  private PPS170B pps170;
  
  private MMS080B1 mmso80b1;
  
  private PPS913E pps913e;
  
  private PPS220B pps220b;
  
  private PPS220G1 pps220g1;
  
  private MWS420B1 mws420b1;
  
  private MMS100B mms100b;
  
  private MWS442B mws442b;
  
  private MWS445B mws445b;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    FCS350_B _fCS350_B = new FCS350_B(BaseTest.driver);
    this.fcs350b = _fCS350_B;
    MMS080B1 _mMS080B1 = new MMS080B1(BaseTest.driver);
    this.mms080b1 = _mMS080B1;
    PPS310A _pPS310A = new PPS310A(BaseTest.driver);
    this.pps310a = _pPS310A;
    PPS310SettingsTest _pPS310SettingsTest = new PPS310SettingsTest(BaseTest.driver);
    this.pps310SettingsTest = _pPS310SettingsTest;
    PPS310E _pPS310E = new PPS310E(BaseTest.driver);
    this.pps310e = _pPS310E;
    MNS212B1 _mNS212B1 = new MNS212B1(BaseTest.driver);
    this.mns212b1 = _mNS212B1;
    PPS330B1 _pPS330B1 = new PPS330B1(BaseTest.driver);
    this.pps330b1 = _pPS330B1;
    MMS001SettingsTest _mMS001SettingsTest = new MMS001SettingsTest(BaseTest.driver);
    this.mms001SettingsTest = _mMS001SettingsTest;
    PDS001SettingsTest _pDS001SettingsTest = new PDS001SettingsTest(BaseTest.driver);
    this.pds001SettingsTest = _pDS001SettingsTest;
    PMS001SettingsTest _pMS001SettingsTest = new PMS001SettingsTest(BaseTest.driver);
    this.pms001SettingsTest = _pMS001SettingsTest;
    OIS101SettingsTest _oIS101SettingsTest = new OIS101SettingsTest(BaseTest.driver);
    this.ois101SettingsTest = _oIS101SettingsTest;
    PPS170B _pPS170B = new PPS170B(BaseTest.driver);
    this.pps170 = _pPS170B;
    MMS080B1 _mMS080B1_1 = new MMS080B1(BaseTest.driver);
    this.mmso80b1 = _mMS080B1_1;
    PPS913E _pPS913E = new PPS913E(BaseTest.driver);
    this.pps913e = _pPS913E;
    PPS220B _pPS220B = new PPS220B(BaseTest.driver);
    this.pps220b = _pPS220B;
    PPS220G1 _pPS220G1 = new PPS220G1(BaseTest.driver);
    this.pps220g1 = _pPS220G1;
    PPS220B _pPS220B_1 = new PPS220B(BaseTest.driver);
    this.pps220B = _pPS220B_1;
    PPS220H1 _pPS220H1 = new PPS220H1(BaseTest.driver);
    this.pps220H1 = _pPS220H1;
    ToolbarPage _toolbarPage = new ToolbarPage(BaseTest.driver);
    this.toolBarPage = _toolbarPage;
    PPS220I1 _pPS220I1 = new PPS220I1(BaseTest.driver);
    this.pps220I1 = _pPS220I1;
    PPS270E _pPS270E = new PPS270E(BaseTest.driver);
    this.pps270E = _pPS270E;
    PPS300SettingsPage _pPS300SettingsPage = new PPS300SettingsPage(BaseTest.driver);
    this.pps300settingsPage = _pPS300SettingsPage;
    PPS300A _pPS300A = new PPS300A(BaseTest.driver);
    this.pps300A = _pPS300A;
    PPS300E _pPS300E = new PPS300E(BaseTest.driver);
    this.pps300E = _pPS300E;
    PPS330B _pPS330B = new PPS330B(BaseTest.driver);
    this.pps330B = _pPS330B;
    PPS320SettingsPage _pPS320SettingsPage = new PPS320SettingsPage(BaseTest.driver);
    this.pps320settingsPage = _pPS320SettingsPage;
    PPS320A _pPS320A = new PPS320A(BaseTest.driver);
    this.pps320A = _pPS320A;
    PPS320E _pPS320E = new PPS320E(BaseTest.driver);
    this.pps320E = _pPS320E;
    MNS212B1 _mNS212B1_1 = new MNS212B1(BaseTest.driver);
    this.mns212B1 = _mNS212B1_1;
    DPS170B _dPS170B = new DPS170B(BaseTest.driver);
    this.dps170b = _dPS170B;
    MMS100B1 _mMS100B1 = new MMS100B1(BaseTest.driver);
    this.mms100b1 = _mMS100B1;
    MMS101B _mMS101B = new MMS101B(BaseTest.driver);
    this.mms101b = _mMS101B;
    MMS121B1 _mMS121B1 = new MMS121B1(BaseTest.driver);
    this.mms121b1 = _mMS121B1;
    MMS101B1 _mMS101B1 = new MMS101B1(BaseTest.driver);
    this.mms101b1 = _mMS101B1;
    MWS423B1 _mWS423B1 = new MWS423B1(BaseTest.driver);
    this.mws423b1 = _mWS423B1;
    MWS410B _mWS410B = new MWS410B(BaseTest.driver);
    this.mws410b = _mWS410B;
    MWS420B1 _mWS420B1 = new MWS420B1(BaseTest.driver);
    this.mws420b1 = _mWS420B1;
    MMS100B _mMS100B = new MMS100B(BaseTest.driver);
    this.mms100b = _mMS100B;
    MWS442B _mWS442B = new MWS442B(BaseTest.driver);
    this.mws442b = _mWS442B;
    MWS445B _mWS445B = new MWS445B(BaseTest.driver);
    this.mws445b = _mWS445B;
  }
  
  /**
   * @TestCaseID: DOT001
   * @CloudSuite: F&B
   * @Description: This test case includes the Distribution Order Flow
   * @author:	rasithae
   */
  @Test
  public void DistributionOrderFlowTest() {
    try {
      String newItemNumber = "";
      String newRawMaterialNumber = "";
      String periodFrame = "170505";
      String periodType = "1-Period type";
      String periodWithinCalYear = "1705";
      String fcQty = "25";
      String warehouse2Id = "002";
      String finishedGoodTemplateItemNo = "D10031";
      String rawMaterialTemplateItemNo = "D50011";
      String pps170SortingOrder = "1-Buy,Sup,Whs,Ite";
      String pps170View = "PANEL3-Buyer, supplier, warehouse, item";
      this.loginPage.GoTo();
      this.mms001SettingsTest.updateItemsSetting("2-Always update");
      newItemNumber = this.copyFinishedGoodItem(finishedGoodTemplateItemNo);
      System.out.println(("copyFinishedGoodItem Finished: " + newItemNumber));
      newRawMaterialNumber = this.copyRawMaterialItem(rawMaterialTemplateItemNo);
      System.out.println(("copyRawMaterialItem Finished: " + newRawMaterialNumber));
      this.pds001SettingsTest.updateProductVariantSetting("2-Always update");
      this.createProductStructure(newItemNumber, newRawMaterialNumber);
      System.out.println("createProductStructure Finished");
      this.homePage.GoToFCS350();
      this.fcs350b.setHeaderDetails(newItemNumber, periodFrame, periodType);
      String frDt = this.fcs350b.setFCQtyForTheEmptyPeriod(periodWithinCalYear, fcQty);
      this.fcs350b.Next();
      this.fcs350b.closeAllTabs();
      this.homePage.goToHome();
      this.homePage.GoToMMS080();
      this.mms080b1.setHeaderDetails(newItemNumber, "");
      List<String> dataList = this.mms080b1.getDetailsFromGrid(periodWithinCalYear);
      Assert.assertEquals(dataList.get(4), "999999999", "ATP cum is not correct");
      this.mms080b1.calculateMRPAndRefreshPage();
      dataList = this.mms080b1.getDetailsFromGrid(16, "F20");
      Assert.assertEquals(dataList.get(5), "100", "Oct is not 100");
      this.mms080b1.setHeaderDetails(newRawMaterialNumber, "");
      this.mms080b1.calculateMRPAndRefreshPage();
      dataList = this.mms080b1.getDetailsFromGrid(16, "D19");
      Assert.assertEquals(dataList.get(5), "500", "Oct is not 500");
      this.mms080b1.setHeaderDetails(newRawMaterialNumber, warehouse2Id);
      this.mms080b1.calculateMRPAndRefreshPage();
      dataList = this.mms080b1.getDetailsFromGrid(16, "D20");
      Assert.assertEquals(dataList.get(5), "250", "Oct is not 250");
      this.mms080b1.closeAllTabs();
      this.homePage.goToHome();
      this.homePage.GoToPPS170();
      this.pps170.setFilterOptions(pps170SortingOrder, pps170View);
      this.pps170.fillTableHeaderInformation("FABPLANNER", "Y50001", warehouse2Id, newRawMaterialNumber);
      this.pps170.releaseLine(newRawMaterialNumber);
      this.pps170.CloseActiveTab();
      this.pps913e.clearBuyer();
      this.pps913e.Next();
      this.homePage.goToHome();
      this.homePage.GoToMMS080();
      this.mms080b1.setHeaderDetails(newRawMaterialNumber, warehouse2Id);
      dataList = this.mms080b1.getDetailsFromGrid(16, "D20");
      Assert.assertEquals(dataList.get(5), "251", "Oct is not 251");
      String newPoNumber = dataList.get(8);
      InputOutput.<String>println(("New PO number is : " + newPoNumber));
      this.mms080b1.closeAllTabs();
      this.homePage.goToHome();
      this.homePage.GoToPPS220();
      this.pps220b.searchPONumber(newPoNumber);
      this.pps220b.confirmOrder(newPoNumber);
      this.pps220g1.setHeaderDetails(("SUP" + newRawMaterialNumber), ("SUP" + newRawMaterialNumber));
      this.pps220g1.selectAction("Confirm Update");
      System.out.println("Confirmed the order");
      List<String> pps220DataList = this.pps220b.getDetailsFromGrid(1, newPoNumber);
      Assert.assertEquals(pps220DataList.get(12), "35", "Lst is not 35");
      Assert.assertEquals(pps220DataList.get(13), "35", "Hst is not 35");
      this.pps220g1.closeAllTabs();
      this.homePage.GoToPPS220();
      this.pps220B.searchPONumber(newPoNumber);
      Assert.assertEquals("35", this.pps220B.getLstOfFirstRow());
      Assert.assertEquals("35", this.pps220B.getHstOfFirstRow());
      this.pps220B.GotoRelatedAndAdviceShipment();
      this.pps220H1.fillDelyNote("DELN001");
      this.pps220H1.fillPackageNo("PKG001");
      this.pps220H1.fillSSCCNumber("123456");
      this.toolBarPage.ClickAction();
      this.pps220H1.clickConfirmUpdate();
      Assert.assertEquals("40", this.pps220B.getLstOfFirstRow());
      Assert.assertEquals("40", this.pps220B.getHstOfFirstRow());
      this.pps220B.goToRelatedAndClickTransportNotification();
      this.pps220I1.clickChange();
      this.pps270E.fillFwd("FEDEX");
      this.pps270E.fillBilOfLading("BOL001");
      this.pps270E.fillCarrierName("CARRIER");
      this.pps270E.clickNext();
      this.toolBarPage.ClickAction();
      this.pps220I1.clickConfirmUpdate();
      Assert.assertEquals("45", this.pps220B.getLstOfFirstRow());
      Assert.assertEquals("45", this.pps220B.getHstOfFirstRow());
      this.pps220B.closeAllTabs();
      this.homePage.GoToPPS300();
      boolean _equals = this.pps220B.getPageId().equals("PPS300/B1");
      if (_equals) {
        this.toolBarPage.ClickAction();
        this.pps300settingsPage.goToSettings();
        this.pps300settingsPage.changeOpeningPanel();
        this.pps300settingsPage.clickNext();
      }
      this.pps300A.setPONum(newPoNumber);
      this.pps300A.setWarehouse(warehouse2Id);
      this.pps300A.fillPOtxtBox1("1");
      this.pps300A.ClickNext();
      this.pps300A.ClickNext();
      this.pps300E.SetRecieveQtyAsConfirmedQty();
      this.pps300E.fillRemarks("GOOD");
      this.pps300E.ClickNext();
      this.pps300A.goToStartPage();
      this.homePage.GoToPPS220();
      this.pps220B.searchPONumber(newPoNumber);
      Assert.assertEquals("50", this.pps220B.getLstOfFirstRow());
      Assert.assertEquals("50", this.pps220B.getHstOfFirstRow());
      this.pps220B.goToRelatedAndClickPurchaseOrderTransactions();
      Assert.assertEquals(true, this.pps330B.checkStatusForPO(newPoNumber, "50"));
      this.pps330B.closeAllTabs();
      this.homePage.GoToPPS320();
      boolean _equals_1 = this.pps320A.getPageId().equals("PPS320/B");
      if (_equals_1) {
        this.toolBarPage.ClickAction();
        this.pps320settingsPage.goToSettings();
        this.pps320settingsPage.changeOpeningPanel();
        this.pps320settingsPage.clickNext();
      }
      this.pps320A.closeAllTabs();
      this.homePage.GoToPPS330();
      this.pps330B.searchForPO(newPoNumber, warehouse2Id);
      String ReceivingNo = this.pps330B.getRecievingNoOf(newPoNumber);
      this.pps330B.closeAllTabs();
      this.homePage.GoToPPS320();
      this.pps320A.setWarehouse(warehouse2Id);
      this.pps320A.setReceivingNo(ReceivingNo);
      this.pps320A.ClickNext();
      this.pps320A.ClickNext();
      this.pps320E.EnterStoredQtyAsRecieved();
      this.pps320E.SetLocationFromText("YCD");
      this.pps320E.Next();
      this.pps320A.GoToOutputSelectMedia();
      this.mns212B1.ConfirmOutput();
      this.homePage.closeAllTabs();
      this.homePage.GoToPPS330();
      this.pps330B.searchForPO(newPoNumber, warehouse2Id);
      Assert.assertEquals(true, this.pps330B.checkStatusForPO(newPoNumber, "51"));
      this.homePage.closeAllTabs();
      this.pps310SettingsTest.SetOpeningPanel("A-Entry");
      this.pps310a.EditDetails(newPoNumber);
      this.pps310a.GoToPPS310E();
      this.pps310e.enterApprovedQty();
      this.pps310e.Next();
      this.pps310a.PressF12();
      this.mns212b1.ConfirmOutput();
      this.homePage.GoToPPS330();
      this.pps330b1.SearchPO(newPoNumber);
      Assert.assertTrue(this.pps330b1.checkStatus65ForPO(newPoNumber));
      InputOutput.<String>println("Inspection done");
      this.homePage.closeAllTabs();
      this.pps330b1.GoToStart();
      this.homePage.GoToDPS170();
      this.dps170b.SearchItem("FABPLANNER", "002", "001", newRawMaterialNumber);
      this.dps170b.goToRelatedOption("Release");
      this.homePage.closeAllTabs();
      this.homePage.GoToMMS080();
      this.mms080b1.setHeaderDetails(newRawMaterialNumber, warehouse2Id);
      List<String> data = this.mms080b1.getDataOfRow("Oct", "511");
      String orderNo = data.get(8);
      InputOutput.<String>println(orderNo);
      this.homePage.closeAllTabs();
      this.homePage.GoToMMS100();
      this.mms100b1.selectSortingOrder("1-Order number");
      this.mms100b1.SearchOrder(orderNo, "FABPLANNER");
      this.mms100b1.goToRelatedOption("Order Lines");
      this.mms101b.goToRelatedOption("Allocate");
      this.mms121b1.AddAllocatedQty();
      this.mms101b1.GoBack();
      this.mms101b1.GoBack();
      this.mms100b1.GoToDeliveryToolbox();
      this.mws410b.goToRelatedOption("Release for Picking");
      Thread.sleep(6000);
      this.mws410b.refreshPage();
      this.mws410b.refreshPage();
      this.mws410b.MoveToPickingList();
      this.mws420b1.goToRelatedOption("Confirm Issues");
      Assert.assertEquals(this.mws420b1.getPiSOfFirstRow(), "70");
      this.homePage.closeAllTabs();
      this.homePage.goToHome();
      this.homePage.GoToMMS100();
      this.mms100b.selectSortingOrder("1-Order number");
      this.mms100b.searchOrderNum(orderNo);
      this.mms100b.goToDOROToolbox(orderNo);
      this.mws442b.goToDOROReceiptOfRow(0);
      this.mws445b.ConfirmAll();
      this.mws445b.ClickPrevious();
      this.mws442b.ClickPrevious();
      Assert.assertEquals(this.mms100b.GetLwsOfOrder(orderNo), "99", "Lws stat was incorrect");
      Assert.assertEquals(this.mms100b.GetHisOfOrder(orderNo), "99", "His stat was incorrect");
      this.mms100b.closeAllTabs();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
