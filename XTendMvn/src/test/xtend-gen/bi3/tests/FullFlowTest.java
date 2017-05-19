package bi3.tests;

import bi3.configuration.settings.MMS001SettingsTest;
import bi3.configuration.settings.OIS101SettingsTest;
import bi3.configuration.settings.PDS001SettingsTest;
import bi3.configuration.settings.PMS001SettingsTest;
import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.crs207.CRS207_B;
import bi3.pages.mms001.MMS001;
import bi3.pages.mms001.MMS001C;
import bi3.pages.mms001.MMS001ConnectWarehouse;
import bi3.pages.mms001.MMS001ConnectWarehouseE;
import bi3.pages.mms001.MMS001ConnectWarehouseF;
import bi3.pages.mms001.MMS001ConnectWarehouseG;
import bi3.pages.mms001.MMS001ConnectWarehouseH;
import bi3.pages.mms001.MMS001ConnectWarehouseI;
import bi3.pages.mms001.MMS001E;
import bi3.pages.mms001.MMS001F;
import bi3.pages.mms001.MMS001G;
import bi3.pages.mms001.MMS001H;
import bi3.pages.mms001.MMS001I;
import bi3.pages.mms001.MMS001ItemFacility;
import bi3.pages.mms001.MMS001ItemFacilityE;
import bi3.pages.mms001.MMS001ItemFacilityF;
import bi3.pages.mms001.MMS001J;
import bi3.pages.mms001.MMS001K;
import bi3.pages.mms001.MMS001L;
import bi3.pages.mms001.MMS001M;
import bi3.pages.mms077.MMS077;
import bi3.pages.mms077.MMS077_SelectMedia;
import bi3.pages.mws060.MWS060B;
import bi3.pages.mws410.MWS410B;
import bi3.pages.mws410.MWS410E;
import bi3.pages.mws410.MWS410I;
import bi3.pages.mws420.MWS420B;
import bi3.pages.mws460.MWS460B;
import bi3.pages.ois100.OIS100A;
import bi3.pages.ois100.OIS100G;
import bi3.pages.ois101.OIS101B1;
import bi3.pages.ois101.OIS101E;
import bi3.pages.ois300.OIS300;
import bi3.pages.ois300.OIS300Availability;
import bi3.pages.ois300.OIS300CutomerOrderOpenLines;
import bi3.pages.ois300.OIS300MaterialPlan;
import bi3.pages.ois300.OIS300PlannedPurchaseOrder;
import bi3.pages.ois300.OIS300SimulateForMaterial;
import bi3.pages.pds001.PDS001;
import bi3.pages.pds001.PDS001ConnectMaterialOperation;
import bi3.pages.pds001.PDS001ConnectOperations;
import bi3.pages.pds001.PDS001E;
import bi3.pages.pds001.PDS001F;
import bi3.pages.pds001.PDS600E;
import bi3.pages.pms050.PMS050A;
import bi3.pages.pms050.PMS050B1;
import bi3.pages.pms070.PMS070A;
import bi3.pages.pms070.PMS070B1;
import bi3.pages.pms070.PMS070E;
import bi3.pages.pms100.PMS100_B;
import bi3.pages.pms170.PMS170;
import bi3.pages.pms170.PMS170A;
import bi3.pages.pms170.PMS170B;
import bi3.pages.pms170.PMS170E;
import bi3.pages.pps220.PPS220B;
import bi3.pages.pps220.PPS220G1;
import bi3.pages.pps220.PPS220J1;
import bi3.pages.pps300.PPS300B;
import bi3.pages.pps310.PPS310B1;
import bi3.pages.pps310.PPS310E;
import bi3.pages.pps320.PPS320B1;
import bi3.pages.pps320.PPS320E;
import bi3.pages.pps330.PPS330B;
import bi3.tests.BaseTest;
import bi3.tests.moDto;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class FullFlowTest extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private MMS001 mms001;
  
  private MMS001C mms001C;
  
  private MMS001E mms001E;
  
  private MMS001F mms001F;
  
  private MMS001G mms001G;
  
  private MMS001H mms001H;
  
  private MMS001I mms001I;
  
  private MMS001J mms001J;
  
  private MMS001K mms001K;
  
  private MMS001L mms001L;
  
  private MMS001M mms001M;
  
  private MMS077 mms077;
  
  private MMS077_SelectMedia mms077_SelectMedia;
  
  private MMS001ConnectWarehouse mms001ConnectWarehouse;
  
  private MMS001ConnectWarehouseE connectWarehouseE;
  
  private MMS001ConnectWarehouseF connectWarehouseF;
  
  private MMS001ConnectWarehouseG connectWarehouseG;
  
  private MMS001ConnectWarehouseH connectWarehouseH;
  
  private MMS001ConnectWarehouseI connectWarehouseI;
  
  private MMS001ItemFacility itemFacility;
  
  private MMS001ItemFacilityE itemFacilityE;
  
  private MMS001ItemFacilityF itemFacilityF;
  
  private PDS001 pds001;
  
  private PDS001F pds001F;
  
  private PDS001ConnectMaterialOperation connectMaterialOperation;
  
  private PDS001E pds001E;
  
  private PDS001E pds002E;
  
  private PDS001ConnectOperations connectOperations;
  
  private OIS100A ois100A;
  
  private OIS100G ois100G;
  
  private OIS101B1 ois101B1;
  
  private PDS600E pds600E;
  
  private OIS101E ois101e;
  
  private CRS207_B crs207B;
  
  private OIS300 ois300;
  
  private OIS300Availability ois300Availability;
  
  private OIS300CutomerOrderOpenLines ois300CustomerOrderOpenLines;
  
  private OIS300MaterialPlan ois300MaterialPlan;
  
  private OIS300PlannedPurchaseOrder ois300PlannedPurchaseOrder;
  
  private OIS300SimulateForMaterial ois300SimulateForMaterial;
  
  private PMS170 pms170;
  
  private PMS170A pms170a;
  
  private PMS170E pms170e;
  
  private PMS170B pms170b;
  
  private PMS100_B pms100_b;
  
  private PPS220B pps220b;
  
  private PPS220G1 pps220g1;
  
  private PPS220J1 pps220j1;
  
  private PPS300B pps300b;
  
  private PPS330B pps330b;
  
  private PPS310B1 pps310b1;
  
  private PPS310E pps310e;
  
  private PPS320B1 pps320b1;
  
  private PPS320E pps320e;
  
  private MWS410B mws410b;
  
  private PMS070A pms070a;
  
  private PMS070B1 pms070b1;
  
  private PMS070E pms070e;
  
  private PMS050A pms050a;
  
  private PMS050B1 pms050b1;
  
  private MWS060B mws060b;
  
  private MWS460B mws460b;
  
  private MWS420B mws420b;
  
  private MWS410E mws410e;
  
  private MWS410I mws410i;
  
  private MMS001SettingsTest mms001SettingsTest;
  
  private PDS001SettingsTest pds001SettingsTest;
  
  private PMS001SettingsTest pms001SettingsTest;
  
  private OIS101SettingsTest ois101SettingsTest;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    MMS001 _mMS001 = new MMS001(BaseTest.driver);
    this.mms001 = _mMS001;
    MMS001C _mMS001C = new MMS001C(BaseTest.driver);
    this.mms001C = _mMS001C;
    MMS001E _mMS001E = new MMS001E(BaseTest.driver);
    this.mms001E = _mMS001E;
    MMS001F _mMS001F = new MMS001F(BaseTest.driver);
    this.mms001F = _mMS001F;
    MMS001G _mMS001G = new MMS001G(BaseTest.driver);
    this.mms001G = _mMS001G;
    MMS001H _mMS001H = new MMS001H(BaseTest.driver);
    this.mms001H = _mMS001H;
    MMS001I _mMS001I = new MMS001I(BaseTest.driver);
    this.mms001I = _mMS001I;
    MMS001J _mMS001J = new MMS001J(BaseTest.driver);
    this.mms001J = _mMS001J;
    MMS001K _mMS001K = new MMS001K(BaseTest.driver);
    this.mms001K = _mMS001K;
    MMS001L _mMS001L = new MMS001L(BaseTest.driver);
    this.mms001L = _mMS001L;
    MMS001M _mMS001M = new MMS001M(BaseTest.driver);
    this.mms001M = _mMS001M;
    MMS077 _mMS077 = new MMS077(BaseTest.driver);
    this.mms077 = _mMS077;
    MMS077_SelectMedia _mMS077_SelectMedia = new MMS077_SelectMedia(BaseTest.driver);
    this.mms077_SelectMedia = _mMS077_SelectMedia;
    MMS001ConnectWarehouse _mMS001ConnectWarehouse = new MMS001ConnectWarehouse(BaseTest.driver);
    this.mms001ConnectWarehouse = _mMS001ConnectWarehouse;
    MMS001ConnectWarehouseE _mMS001ConnectWarehouseE = new MMS001ConnectWarehouseE(BaseTest.driver);
    this.connectWarehouseE = _mMS001ConnectWarehouseE;
    MMS001ConnectWarehouseF _mMS001ConnectWarehouseF = new MMS001ConnectWarehouseF(BaseTest.driver);
    this.connectWarehouseF = _mMS001ConnectWarehouseF;
    MMS001ConnectWarehouseG _mMS001ConnectWarehouseG = new MMS001ConnectWarehouseG(BaseTest.driver);
    this.connectWarehouseG = _mMS001ConnectWarehouseG;
    MMS001ConnectWarehouseH _mMS001ConnectWarehouseH = new MMS001ConnectWarehouseH(BaseTest.driver);
    this.connectWarehouseH = _mMS001ConnectWarehouseH;
    MMS001ConnectWarehouseI _mMS001ConnectWarehouseI = new MMS001ConnectWarehouseI(BaseTest.driver);
    this.connectWarehouseI = _mMS001ConnectWarehouseI;
    MMS001ItemFacility _mMS001ItemFacility = new MMS001ItemFacility(BaseTest.driver);
    this.itemFacility = _mMS001ItemFacility;
    MMS001ItemFacilityE _mMS001ItemFacilityE = new MMS001ItemFacilityE(BaseTest.driver);
    this.itemFacilityE = _mMS001ItemFacilityE;
    MMS001ItemFacilityF _mMS001ItemFacilityF = new MMS001ItemFacilityF(BaseTest.driver);
    this.itemFacilityF = _mMS001ItemFacilityF;
    PDS001 _pDS001 = new PDS001(BaseTest.driver);
    this.pds001 = _pDS001;
    PDS001F _pDS001F = new PDS001F(BaseTest.driver);
    this.pds001F = _pDS001F;
    PDS001ConnectMaterialOperation _pDS001ConnectMaterialOperation = new PDS001ConnectMaterialOperation(BaseTest.driver);
    this.connectMaterialOperation = _pDS001ConnectMaterialOperation;
    PDS001E _pDS001E = new PDS001E(BaseTest.driver);
    this.pds001E = _pDS001E;
    PDS001E _pDS001E_1 = new PDS001E(BaseTest.driver);
    this.pds002E = _pDS001E_1;
    PDS001ConnectOperations _pDS001ConnectOperations = new PDS001ConnectOperations(BaseTest.driver);
    this.connectOperations = _pDS001ConnectOperations;
    OIS100A _oIS100A = new OIS100A(BaseTest.driver);
    this.ois100A = _oIS100A;
    OIS100G _oIS100G = new OIS100G(BaseTest.driver);
    this.ois100G = _oIS100G;
    OIS101B1 _oIS101B1 = new OIS101B1(BaseTest.driver);
    this.ois101B1 = _oIS101B1;
    PDS600E _pDS600E = new PDS600E(BaseTest.driver);
    this.pds600E = _pDS600E;
    OIS101E _oIS101E = new OIS101E(BaseTest.driver);
    this.ois101e = _oIS101E;
    CRS207_B _cRS207_B = new CRS207_B(BaseTest.driver);
    this.crs207B = _cRS207_B;
    OIS300Availability _oIS300Availability = new OIS300Availability(BaseTest.driver);
    this.ois300Availability = _oIS300Availability;
    OIS300CutomerOrderOpenLines _oIS300CutomerOrderOpenLines = new OIS300CutomerOrderOpenLines(BaseTest.driver);
    this.ois300CustomerOrderOpenLines = _oIS300CutomerOrderOpenLines;
    OIS300MaterialPlan _oIS300MaterialPlan = new OIS300MaterialPlan(BaseTest.driver);
    this.ois300MaterialPlan = _oIS300MaterialPlan;
    OIS300PlannedPurchaseOrder _oIS300PlannedPurchaseOrder = new OIS300PlannedPurchaseOrder(BaseTest.driver);
    this.ois300PlannedPurchaseOrder = _oIS300PlannedPurchaseOrder;
    OIS300SimulateForMaterial _oIS300SimulateForMaterial = new OIS300SimulateForMaterial(BaseTest.driver);
    this.ois300SimulateForMaterial = _oIS300SimulateForMaterial;
    OIS300 _oIS300 = new OIS300(BaseTest.driver);
    this.ois300 = _oIS300;
    PPS220B _pPS220B = new PPS220B(BaseTest.driver);
    this.pps220b = _pPS220B;
    PPS220G1 _pPS220G1 = new PPS220G1(BaseTest.driver);
    this.pps220g1 = _pPS220G1;
    PPS220J1 _pPS220J1 = new PPS220J1(BaseTest.driver);
    this.pps220j1 = _pPS220J1;
    PPS300B _pPS300B = new PPS300B(BaseTest.driver);
    this.pps300b = _pPS300B;
    PPS330B _pPS330B = new PPS330B(BaseTest.driver);
    this.pps330b = _pPS330B;
    PPS310B1 _pPS310B1 = new PPS310B1(BaseTest.driver);
    this.pps310b1 = _pPS310B1;
    PPS310E _pPS310E = new PPS310E(BaseTest.driver);
    this.pps310e = _pPS310E;
    PPS320B1 _pPS320B1 = new PPS320B1(BaseTest.driver);
    this.pps320b1 = _pPS320B1;
    PPS320E _pPS320E = new PPS320E(BaseTest.driver);
    this.pps320e = _pPS320E;
    PMS170 _pMS170 = new PMS170(BaseTest.driver);
    this.pms170 = _pMS170;
    PMS170A _pMS170A = new PMS170A(BaseTest.driver);
    this.pms170a = _pMS170A;
    PMS170E _pMS170E = new PMS170E(BaseTest.driver);
    this.pms170e = _pMS170E;
    PMS170B _pMS170B = new PMS170B(BaseTest.driver);
    this.pms170b = _pMS170B;
    PMS100_B _pMS100_B = new PMS100_B(BaseTest.driver);
    this.pms100_b = _pMS100_B;
    MWS410B _mWS410B = new MWS410B(BaseTest.driver);
    this.mws410b = _mWS410B;
    PMS070A _pMS070A = new PMS070A(BaseTest.driver);
    this.pms070a = _pMS070A;
    PMS070B1 _pMS070B1 = new PMS070B1(BaseTest.driver);
    this.pms070b1 = _pMS070B1;
    PMS070E _pMS070E = new PMS070E(BaseTest.driver);
    this.pms070e = _pMS070E;
    PMS050A _pMS050A = new PMS050A(BaseTest.driver);
    this.pms050a = _pMS050A;
    PMS050B1 _pMS050B1 = new PMS050B1(BaseTest.driver);
    this.pms050b1 = _pMS050B1;
    MWS060B _mWS060B = new MWS060B(BaseTest.driver);
    this.mws060b = _mWS060B;
    MWS460B _mWS460B = new MWS460B(BaseTest.driver);
    this.mws460b = _mWS460B;
    MWS420B _mWS420B = new MWS420B(BaseTest.driver);
    this.mws420b = _mWS420B;
    MWS410E _mWS410E = new MWS410E(BaseTest.driver);
    this.mws410e = _mWS410E;
    MWS410I _mWS410I = new MWS410I(BaseTest.driver);
    this.mws410i = _mWS410I;
    MMS001SettingsTest _mMS001SettingsTest = new MMS001SettingsTest(BaseTest.driver);
    this.mms001SettingsTest = _mMS001SettingsTest;
    PDS001SettingsTest _pDS001SettingsTest = new PDS001SettingsTest(BaseTest.driver);
    this.pds001SettingsTest = _pDS001SettingsTest;
    PMS001SettingsTest _pMS001SettingsTest = new PMS001SettingsTest(BaseTest.driver);
    this.pms001SettingsTest = _pMS001SettingsTest;
    OIS101SettingsTest _oIS101SettingsTest = new OIS101SettingsTest(BaseTest.driver);
    this.ois101SettingsTest = _oIS101SettingsTest;
  }
  
  @Test
  public void FullFlow() {
    this.mms001SettingsTest.updateItemsSetting("2-Always update");
    String finishedGoodTemplateItemNo = "Y3001";
    String rawMaterialTemplateItemNo = "Y7005";
    String newItemNumber = this.copyFinishedGoodItem(finishedGoodTemplateItemNo);
    String newRawMatNumber = this.copyRawMaterialItem(rawMaterialTemplateItemNo);
    this.createSku(newItemNumber, newRawMatNumber);
    this.pds001SettingsTest.updateProductVariantSetting("2-Always update");
    this.createProductStructure(newItemNumber, newRawMatNumber);
    String CONumber = this.createCustomerOrder(newItemNumber);
    String PONumber = this.poCreation(CONumber);
    moDto data = this.createMOP(newItemNumber);
    String lastJointSchNo = data.getLastJointSchNo();
    String fullScheduleNo = data.getFullScheduleNo();
    this.readyToDeliverReleaseForPickingAndInvoice(lastJointSchNo, fullScheduleNo, CONumber);
  }
  
  public String copyFinishedGoodItem(final String templateItemNumber) {
    this.loginPage.GoTo();
    this.homePage.GoToMMS001();
    this.mms001.SearchByItemNumber(templateItemNumber);
    this.mms001.CopyItem(templateItemNumber);
    this.mms001C.Next();
    this.mms001E.SelectInvAccounting("1-Inv accounting");
    this.mms001E.SelectLotCtrlMethod("3-In lot master");
    this.mms001E.SelectLotNumbMethod("5-Auto order no");
    String newItemNumber = this.mms001E.GetItemNumber();
    this.mms001E.Next();
    this.mms001F.Next();
    this.mms001G.SelectSalesItem("1-Sales item");
    this.mms001G.Next();
    this.mms001H.Next();
    this.mms001I.Next();
    this.mms001J.Next();
    this.mms001K.Next();
    this.mms001M.Next();
    this.mms001.SearchByItemNumber(newItemNumber);
    Assert.assertTrue(this.mms001.GetItemNumberList().contains(newItemNumber), (("Item number" + newItemNumber) + "is not found in the grid"));
    this.mms001.setItemWarehouse(newItemNumber);
    this.mms001ConnectWarehouse.changeWarehouse();
    Assert.assertTrue(this.connectWarehouseE.getPageSubTitle().contains("Planning Parameters"), "Did not reach the Main warehouse change page");
    this.connectWarehouseE.setMastrSchedule("0-Not mstr sch it");
    this.connectWarehouseE.setPlanningPolicy("A6");
    this.connectWarehouseE.setSupplyPolicy("A01");
    this.connectWarehouseE.selectContNetChange();
    this.connectWarehouseE.clickNext();
    this.connectWarehouseF.clickNext();
    this.connectWarehouseG.untickCrossDock();
    this.connectWarehouseG.clickNext();
    this.connectWarehouseH.clickNext();
    this.connectWarehouseI.clickNext();
    System.out.println(("Copied Item Number : " + newItemNumber));
    this.mms001ConnectWarehouse.close();
    this.mms001.setItemFacility(newItemNumber);
    this.itemFacility.selectChnage();
    this.itemFacilityE.selectInvAccMethod("1-Standard cost");
    this.itemFacilityE.clickNext();
    this.itemFacilityF.clickNext();
    this.mms001.close();
    this.mms001.close();
    this.mms001.closeAllTabs();
    this.mms001.goToHome();
    return newItemNumber;
  }
  
  public String copyRawMaterialItem(final String templateItemNumber) {
    this.homePage.GoToMMS001();
    this.mms001.SearchByItemNumber(templateItemNumber);
    this.mms001.CopyItem(templateItemNumber);
    this.mms001C.Next();
    this.mms001E.SelectInvAccounting("1-Inv accounting");
    this.mms001E.SelectLotCtrlMethod("3-In lot master");
    this.mms001E.SelectLotNumbMethod("3-Auto, seq no");
    String newRawMatNumber = this.mms001E.GetItemNumber();
    this.mms001E.Next();
    this.mms001F.Next();
    this.mms001G.Next();
    this.mms001H.setPurchasePrice("200");
    this.mms001H.Next();
    this.mms001I.Next();
    this.mms001J.Next();
    this.mms001K.Next();
    this.mms001L.Next();
    this.mms001M.Next();
    this.mms001.SearchByItemNumber(newRawMatNumber);
    Assert.assertTrue(this.mms001.GetItemNumberList().contains(newRawMatNumber), (("Item number" + newRawMatNumber) + "is not found in the grid"));
    System.out.println(newRawMatNumber);
    this.mms001.close();
    return newRawMatNumber;
  }
  
  public void createSku(final String newItemNumber, final String newRawMatNumber) {
    this.mms001.goToHome();
    this.homePage.GoToMMS077();
    this.mms077.CreateItemsByMatrix(newItemNumber);
    this.mms077.navigateToselectMedia();
    this.mms077_SelectMedia.ConfirmOutput();
    Assert.assertEquals(this.mms077.ConfirmMsg(), "Job MMS078CL has been submitted");
    this.mms077.CreateItemsByMatrix(newRawMatNumber);
    this.mms077.navigateToselectMedia();
    this.mms077_SelectMedia.ConfirmOutput();
    Assert.assertEquals(this.mms077.ConfirmMsg(), "Job MMS078CL has been submitted");
    this.mms077.closeAllTabs();
    this.mms077.goToHome();
    this.homePage.GoToMMS001();
    this.mms001.SearchByItemNumber(newItemNumber);
    List<String> itemData = this.mms001.getDataOfItem(newItemNumber);
    Assert.assertEquals(itemData.get(3), "20-Released", "Finished Good item status is not 20-Released");
    this.mms001.SearchByItemNumber(newRawMatNumber);
    List<String> rawItemData = this.mms001.getDataOfItem(newRawMatNumber);
    Assert.assertEquals(rawItemData.get(3), "20-Released", "Raw Material item status is not 20-Released");
    this.mms001.EditItem(newRawMatNumber);
    this.mms001E.setStatus("20-Released");
    this.mms001E.Next();
    this.mms001E.closeAllTabs();
    this.mms001E.goToHome();
    this.homePage.GoToMMS001();
    this.mms001.SearchByItemNumber(newRawMatNumber);
    List<String> rawItemData_sku1 = this.mms001.getDataOfItem((newRawMatNumber + "-Y01"));
    Assert.assertEquals(rawItemData_sku1.get(3), "20-Released", "Raw Material item status is not 20-Released");
    this.mms001.closeAllTabs();
  }
  
  public void createProductStructure(final String newItemNumber, final String newRawMatNumber) {
    this.mms001E.closeAllTabs();
    this.mms001E.goToHome();
    this.homePage.GoToPDS001();
    this.pds001.SearchByItemNumber(newItemNumber);
    this.pds001.goToMaterialAndOperations(newItemNumber);
    this.connectMaterialOperation.setSno("10");
    this.connectMaterialOperation.setOperation("10");
    this.connectMaterialOperation.setComponent(newRawMatNumber);
    this.connectMaterialOperation.clickAddButton();
    this.pds002E.setQuantity("10");
    this.pds001.clickNext();
    this.pds001.clickNext();
    String lastAddedComponentId = this.connectMaterialOperation.getLastAddedComponentId();
    Assert.assertEquals(lastAddedComponentId, newRawMatNumber, ((("Actual value :" + lastAddedComponentId) + " value expected is ") + newItemNumber));
    this.connectMaterialOperation.clearTextSno();
    this.connectMaterialOperation.selectOperationFromLookUp("YACUT01");
    this.connectMaterialOperation.clickAddButton();
    this.connectOperations.setRuntime("10");
    this.pds001.clickNext();
    this.pds001.clickNext();
    lastAddedComponentId = this.connectMaterialOperation.getLastAddedComponentId();
    Assert.assertTrue(lastAddedComponentId.contains("YACUT01"), (("Actual value :" + lastAddedComponentId) + " value expected is YACUT01"));
    InputOutput.<String>println(("-----Item Number: " + newItemNumber));
    InputOutput.<String>println(("-----Raw Material Number: " + newRawMatNumber));
    this.connectMaterialOperation.close();
    this.pds001.SearchByItemNumber(newRawMatNumber);
    this.pds001.EditItem(newRawMatNumber);
    this.pds001E.setStatus("20-Released");
    this.pds001E.Next();
    this.pds001E.closeAllTabs();
    this.pds001E.goToHome();
    this.homePage.GoToPDS001();
    this.pds001.SearchByItemNumber(newRawMatNumber);
    List<String> psData_sku1 = this.pds001.getDataOfItem((newRawMatNumber + "-Y01"));
    Assert.assertEquals(psData_sku1.get(7), "20-Released", "Product Structure SKU item status is not 20-Released");
  }
  
  public String createCustomerOrder(final String newItemNumber) {
    this.pds001.closeAllTabs();
    this.homePage.GoToOIS100();
    this.ois100A.clearCOno();
    this.ois100A.clearCustomer();
    this.ois100A.fillCustomer("Y00001");
    this.ois100A.fillCOType("A01");
    this.ois100A.fillReqDeliveryDate("170810");
    this.ois100A.clickNext();
    this.ois100G.handleAbnormalException();
    this.ois100A.clickNext();
    boolean _equals = this.ois100A.getPageId().equals("OIS100/G");
    if (_equals) {
      this.ois100G.fillCustomerOrd("Y00001-190");
      this.ois100G.clickNext();
      this.ois100G.handleWarning();
    }
    this.ois101SettingsTest.customerOrderOpenLineSettingSetUp("EFGIV", "YMD-Year month day", "2-Matrix (CRS207)", "45678");
    this.ois101B1.fillOrderLine(newItemNumber, "30");
    this.crs207B.fillMatrix("10");
    this.crs207B.clickNext();
    this.crs207B.handleAbnormalException();
    this.ois101e.fillPricingInformation("350", "200");
    Assert.assertTrue(this.ois101B1.checkItemPresence().contains((newItemNumber + "-Y01-010")));
    String coNumber = this.ois101B1.getTheCONumber();
    System.out.println(("CO Number :" + coNumber));
    return coNumber;
  }
  
  public String poCreation(final String coNumber) {
    this.ois300.closeAllTabs();
    this.homePage.GoToOIS300();
    this.ois300.setSortingOrder("1-Order Number");
    this.ois300.searchCONumber(coNumber);
    this.ois300.goToOrderLines();
    this.ois300CustomerOrderOpenLines.goToSimCopAvail();
    this.ois300SimulateForMaterial.goToMaterialPlan();
    this.ois300MaterialPlan.calculateMRP();
    final String orderNumber = this.ois300MaterialPlan.getTheOrderNumber("250");
    this.ois300MaterialPlan.changeMaterialPlan(orderNumber);
    this.ois300PlannedPurchaseOrder.setStatus("60-Released");
    this.ois300PlannedPurchaseOrder.Next();
    this.ois300PlannedPurchaseOrder.Next();
    this.ois300PlannedPurchaseOrder.Next();
    this.ois300PlannedPurchaseOrder.clearBuyerFrom();
    this.ois300PlannedPurchaseOrder.clearBuyerTo();
    this.ois300PlannedPurchaseOrder.Next();
    this.ois300MaterialPlan.refreshTheGrid();
    this.ois300MaterialPlan.refreshTheGrid();
    Assert.assertTrue(this.ois300MaterialPlan.isGridEmpty());
    InputOutput.<String>println("-------------------------------------------");
    InputOutput.<String>println("-----------MOP Creation Flow Start---------");
    this.ois300MaterialPlan.searchForStat("251");
    String newPONum = this.ois300MaterialPlan.getTheOrderNumber("251");
    this.ois300MaterialPlan.closeAllTabs();
    this.homePage.GoToPPS220();
    this.pps220b.searchPONumber(newPONum);
    this.pps220b.confirmOrder(newPONum);
    Assert.assertEquals(this.pps220g1.getPONumberOfRow(0), newPONum);
    this.pps220g1.selectAction("Confirm Update");
    System.out.println("Confirmed the order");
    this.pps220b.searchPONumber(newPONum);
    this.pps220b.goodsReceipt(newPONum);
    Assert.assertEquals(this.pps220j1.getPONumberOfRow(0), newPONum);
    this.pps220j1.selectAction("Confirm Update");
    System.out.println("Goods reciept completed");
    this.pps220b.closeAllTabs();
    this.homePage.GoToPPS300();
    this.pps300b.enterPONum(newPONum);
    this.pps300b.clickApply();
    this.pps300b.closeAllTabs();
    this.homePage.GoToPPS330();
    this.pps330b.searchPONum(newPONum);
    String recievingNo = this.pps330b.getRecievingNoOf(newPONum);
    System.out.println(("Recieving number : " + recievingNo));
    this.pps330b.closeAllTabs();
    this.homePage.GoToPPS310();
    this.pps310b1.enterTheRecivingNo(recievingNo);
    this.pps310b1.clickApply();
    this.pps310b1.editFirstRecord();
    this.pps310e.enterApprovedQty();
    this.pps310e.Next();
    this.pps310b1.closeAllTabs();
    this.homePage.GoToPPS320();
    this.pps320b1.enterTheRecivingNo(recievingNo);
    this.pps320b1.clickApply();
    this.pps320b1.editFirstRow();
    this.pps320e.enterStoredQty();
    this.pps320e.Next();
    this.pps320b1.closeAllTabs();
    this.homePage.GoToPPS330();
    this.pps330b.searchPONum(newPONum);
    Assert.assertTrue(this.pps330b.checkStatus75ForPO(newPONum), ("Status 75 was not found for PO number " + newPONum));
    this.pps330b.closeAllTabs();
    this.pps330b.goToHome();
    return newPONum;
  }
  
  public moDto createMOP(final String newItemNumber) {
    this.homePage.GoToPMS170();
    this.pms170.SelectCreatMop();
    this.pms170a.EnterProduct((newItemNumber + "-Y01-010"));
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
    this.pms170b.clearResponsible();
    this.pms170b.enterRespSearchKey("FSHPLANNER");
    this.pms170b.EnterMainProduct(newItemNumber);
    this.pms170b.JointSchedulling();
    String lastJointSchNo = this.pms170.getLastJoindScheduleNo().substring(8);
    String fullScheduleNo = this.pms170.getLastJoindScheduleNo();
    System.out.println(("Last Joint Schedule Number :" + lastJointSchNo));
    System.out.println(("Full Schedule Number :" + fullScheduleNo));
    this.pms170b.clickNext();
    this.pms170b.RefreshPage();
    this.pms170b.SearchScheduleNo(lastJointSchNo);
    String lastJointSchNoFromSearch = this.pms170.getDataFromRow(0).get(1);
    Assert.assertEquals(lastJointSchNo, lastJointSchNoFromSearch, "Schedule Number Is Incorrect");
    this.pms170b.ReleaseItem();
    this.mms001.close();
    this.homePage.GoToPMS100();
    this.pms100_b.EnterMainProduct(newItemNumber);
    this.pms100_b.SearchScheduleNo(lastJointSchNoFromSearch);
    this.pms170b.RefreshPage();
    List<String> listStatus = this.pms100_b.GetStatuses(lastJointSchNo);
    Assert.assertEquals(listStatus.get(0), "20", "Status 1 is incorrect");
    Assert.assertEquals(listStatus.get(1), "40", "Ho is incorrect");
    Assert.assertEquals(listStatus.get(2), "33", "Status 2 is incorrect");
    this.pms170b.closeAllTabs();
    moDto data = new moDto();
    data.setLastJointSchNo(lastJointSchNo);
    data.setFullScheduleNo(fullScheduleNo);
    return data;
  }
  
  public void readyToDeliverReleaseForPickingAndInvoice(final String lastJointSchNo, final String fullScheduleNo, final String CONumber) {
    this.homePage.GoToPMS100();
    this.pms100_b.SearchScheduleNo(lastJointSchNo);
    this.pms100_b.goToDeliveryToolbox();
    this.mws410b.selectComboValuesView("A84-MO Schedules/Work centers");
    this.mws410b.searchConsignee(fullScheduleNo);
    boolean released = this.mws410b.relaseForPicking();
    Assert.assertTrue(released, "Not successfully released.");
    this.mws410b.MoveToPickingList();
    this.mws410b.ConfirmIssues();
    this.mws410b.closeAllTabs();
    this.homePage.GoToPMS070();
    this.pms070a.setSchedNumberFromLookUp(lastJointSchNo);
    this.pms070a.clearMONumber();
    this.pms070a.clearProductNo();
    this.pms070a.Next();
    this.pms070b1.goToChangeOfGridRow(0);
    this.pms070e.setLabRuntime("10");
    this.pms070e.clickNext();
    String stat = this.pms070b1.getStatusOfGridRow(0);
    Assert.assertEquals(stat, "90");
    this.pms070b1.ConfirmationRecord(0);
    this.pms070b1.closeAllTabs();
    this.homePage.GoToPMS050();
    this.pms050a.EnterScheduleNo(lastJointSchNo);
    this.pms050a.clearProductNo();
    this.pms050a.clearMONumber();
    this.pms050a.Next();
    this.pms050b1.Confirmation();
    stat = this.pms050b1.getStatusOfGridRow(0);
    System.out.println(("Status : " + stat));
    this.pms050b1.closeAllTabs();
    this.homePage.GoToOIS300();
    this.ois300.searchCONumber(CONumber);
    this.ois300.goToDeliveryToolbox();
    this.mws410b.selectComboValuesView("A84-MO Schedules/Work centers");
    this.mws410b.changeRecord();
    this.mws410e.GoToPanel("I");
    this.mws410i.setTransId("FC01");
    this.mws410i.Next();
    this.mws420b.ConfirmIssues();
    String pis = this.mws420b.getPiSOfRow(0);
    System.out.println(("PiS after releasing is " + pis));
    Assert.assertEquals(pis, "90", "PiS was not 90");
  }
}
