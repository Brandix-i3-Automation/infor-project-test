package bi3.tests.fnb;

import bi3.configuration.settings.MMS001SettingsTest;
import bi3.configuration.settings.OIS101SettingsTest;
import bi3.configuration.settings.PDS001SettingsTest;
import bi3.configuration.settings.PMS001SettingsTest;
import bi3.configuration.settings.PMS100SettingsTest;
import bi3.configuration.settings.PPS300SettingsTest;
import bi3.configuration.settings.PPS310SettingsTest;
import bi3.configuration.settings.PPS320SettingsTest;
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
import bi3.pages.mms080.MMS080B1;
import bi3.pages.mms121.MMS121B1;
import bi3.pages.mws060.MWS060B;
import bi3.pages.mws410.MWS410B;
import bi3.pages.mws410.MWS410E;
import bi3.pages.mws410.MWS410I;
import bi3.pages.mws420.MWS420B;
import bi3.pages.mws420.MWS420B1;
import bi3.pages.mws460.MWS460B;
import bi3.pages.ois100.OIS100A;
import bi3.pages.ois100.OIS100G;
import bi3.pages.ois100.OIS100H;
import bi3.pages.ois101.OIS101B1;
import bi3.pages.ois101.OIS101E;
import bi3.pages.ois145.OIS145E;
import bi3.pages.ois300.OIS300;
import bi3.pages.ois300.OIS300Availability;
import bi3.pages.ois300.OIS300CutomerOrderOpenLines;
import bi3.pages.ois300.OIS300MaterialPlan;
import bi3.pages.ois300.OIS300PlannedPurchaseOrder;
import bi3.pages.ois300.OIS300SimulateForMaterial;
import bi3.pages.pcs200.PCS200E;
import bi3.pages.pcs200.PCS200F;
import bi3.pages.pcs300.PCS300;
import bi3.pages.pds001.PDS001;
import bi3.pages.pds001.PDS001ConnectMaterialOperation;
import bi3.pages.pds001.PDS001ConnectOperations;
import bi3.pages.pds001.PDS001E;
import bi3.pages.pds001.PDS001F;
import bi3.pages.pds001.PDS600E;
import bi3.pages.pms040.PMS040B;
import bi3.pages.pms050.PMS050A;
import bi3.pages.pms050.PMS050B1;
import bi3.pages.pms050.PMS050E;
import bi3.pages.pms070.PMS070A;
import bi3.pages.pms070.PMS070B1;
import bi3.pages.pms070.PMS070E;
import bi3.pages.pms100.PMS100_B;
import bi3.pages.pms170.PMS170;
import bi3.pages.pms170.PMS170A;
import bi3.pages.pms170.PMS170B;
import bi3.pages.pms170.PMS170E;
import bi3.pages.pms270.PMS270E;
import bi3.pages.pps220.PPS220B;
import bi3.pages.pps220.PPS220G1;
import bi3.pages.pps220.PPS220J1;
import bi3.pages.pps250.PPS250B1;
import bi3.pages.pps270.PPS270B1;
import bi3.pages.pps270.PPS270E;
import bi3.pages.pps300.PPS300B;
import bi3.pages.pps300.PPS300E;
import bi3.pages.pps310.PPS310B1;
import bi3.pages.pps310.PPS310E;
import bi3.pages.pps320.PPS320B1;
import bi3.pages.pps320.PPS320E;
import bi3.pages.pps330.PPS330B;
import bi3.pages.pps600.PPS600E;
import bi3.pages.pps600.PPS600F;
import bi3.pages.pps600.PPS600SelectMedia;
import bi3.tests.BaseTest;
import bi3.tests.fnb.moDto;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class EndToEndMadeToOrderTest extends BaseTest {
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
  
  private OIS100H ois100H;
  
  private MMS080B1 mms080b1;
  
  private PMS270E pms270e;
  
  private OIS145E ois145e;
  
  private PCS200E pcs200e;
  
  private PCS200F pcs200f;
  
  private PCS300 pcs300;
  
  private PPS220B pps220B;
  
  private PPS600E pps600E;
  
  private PPS600F pps600F;
  
  private PPS600SelectMedia pps600SelectMedia;
  
  private PPS250B1 pps250B1;
  
  private PPS270B1 pps270B1;
  
  private PPS270E pps270E;
  
  private PPS300E pps300e;
  
  private PPS300SettingsTest pps300Settings;
  
  private PPS320SettingsTest pps320Settings;
  
  private PPS310SettingsTest pps310Settings;
  
  private PMS040B pms040b;
  
  private MMS121B1 mms121b1;
  
  private PMS050E pms050e;
  
  private MWS420B1 mws420b1;
  
  public EndToEndMadeToOrderTest(final WebDriver driver) {
    BaseTest.driver = driver;
    this.Initialize();
  }
  
  public EndToEndMadeToOrderTest() {
  }
  
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
    PPS300SettingsTest _pPS300SettingsTest = new PPS300SettingsTest(BaseTest.driver);
    this.pps300Settings = _pPS300SettingsTest;
    PPS320SettingsTest _pPS320SettingsTest = new PPS320SettingsTest(BaseTest.driver);
    this.pps320Settings = _pPS320SettingsTest;
    PPS310SettingsTest _pPS310SettingsTest = new PPS310SettingsTest(BaseTest.driver);
    this.pps310Settings = _pPS310SettingsTest;
    OIS100H _oIS100H = new OIS100H(BaseTest.driver);
    this.ois100H = _oIS100H;
    MMS080B1 _mMS080B1 = new MMS080B1(BaseTest.driver);
    this.mms080b1 = _mMS080B1;
    PMS270E _pMS270E = new PMS270E(BaseTest.driver);
    this.pms270e = _pMS270E;
    OIS145E _oIS145E = new OIS145E(BaseTest.driver);
    this.ois145e = _oIS145E;
    PCS200E _pCS200E = new PCS200E(BaseTest.driver);
    this.pcs200e = _pCS200E;
    PCS200F _pCS200F = new PCS200F(BaseTest.driver);
    this.pcs200f = _pCS200F;
    PCS300 _pCS300 = new PCS300(BaseTest.driver);
    this.pcs300 = _pCS300;
    PPS220B _pPS220B_1 = new PPS220B(BaseTest.driver);
    this.pps220B = _pPS220B_1;
    PPS600E _pPS600E = new PPS600E(BaseTest.driver);
    this.pps600E = _pPS600E;
    PPS600F _pPS600F = new PPS600F(BaseTest.driver);
    this.pps600F = _pPS600F;
    PPS600SelectMedia _pPS600SelectMedia = new PPS600SelectMedia(BaseTest.driver);
    this.pps600SelectMedia = _pPS600SelectMedia;
    PPS250B1 _pPS250B1 = new PPS250B1(BaseTest.driver);
    this.pps250B1 = _pPS250B1;
    PPS270B1 _pPS270B1 = new PPS270B1(BaseTest.driver);
    this.pps270B1 = _pPS270B1;
    PPS270E _pPS270E = new PPS270E(BaseTest.driver);
    this.pps270E = _pPS270E;
    PPS300E _pPS300E = new PPS300E(BaseTest.driver);
    this.pps300e = _pPS300E;
    PMS040B _pMS040B = new PMS040B(BaseTest.driver);
    this.pms040b = _pMS040B;
    MMS121B1 _mMS121B1 = new MMS121B1(BaseTest.driver);
    this.mms121b1 = _mMS121B1;
    PMS050E _pMS050E = new PMS050E(BaseTest.driver);
    this.pms050e = _pMS050E;
    MWS420B1 _mWS420B1 = new MWS420B1(BaseTest.driver);
    this.mws420b1 = _mWS420B1;
  }
  
  /**
   * @TestCaseID: MTO001
   * @CloudSuite: F&B
   * @Description: This test case includes the End to End Made to Order Test
   * @author:	rasithae
   * @author: dasunik
   */
  @Test
  public void EndToEndMadeToOrderTest() {
    String finishedGoodTemplateItemNo = "DORD01";
    String rawMaterialTemplateItemNo = "DRM001";
    String newItemNumber = this.copyFinishedGoodItem(finishedGoodTemplateItemNo);
    System.out.println(("copyFinishedGoodItem Finished:" + newItemNumber));
    String newRawMatNumber = this.copyRawMaterialItem(rawMaterialTemplateItemNo);
    System.out.println(("copyRawMaterialItem Finished" + newRawMatNumber));
    this.pds001SettingsTest.updateProductVariantSetting("2-Always update");
    this.createProductStructure(newItemNumber, newRawMatNumber);
    System.out.println("createProductStructure Finished");
    this.StandardCosting(newItemNumber, "3");
    String createCustomerOrder = this.createCustomerOrder(newItemNumber);
    this.POCreation(createCustomerOrder, newRawMatNumber);
    moDto moDto1 = this.MOPVerification("001", newItemNumber);
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
    Assert.assertTrue(this.mms001.GetItemNumberList().contains(newItemNumber), (("Item number" + newItemNumber) + 
      "is not found in the grid"));
    System.out.println("Set Item Warehouse Information");
    this.mms001.setItemWarehouse(newItemNumber);
    this.mms001ConnectWarehouse.changeWarehouse();
    Assert.assertTrue(this.connectWarehouseE.getPageSubTitle().contains("Planning Parameters"), 
      "Did not reach the Main warehouse change page");
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
    try {
      this.homePage.GoToMMS001();
      this.mms001.SearchByItemNumber(templateItemNumber);
      this.mms001.CopyItem(templateItemNumber);
      Thread.sleep(1000);
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
      Assert.assertTrue(this.mms001.GetItemNumberList().contains(newRawMatNumber), (("Item number" + newRawMatNumber) + 
        "is not found in the grid"));
      System.out.println(newRawMatNumber);
      this.mms001.close();
      return newRawMatNumber;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void createProductStructure(final String newItemNumber, final String newRawMatNumber) {
    this.mms001E.closeAllTabs();
    this.homePage.GoToPDS001();
    this.pds001.SearchByItemNumber(newItemNumber);
    this.pds001.FillItemNumber(newItemNumber, 0);
    this.pds001.FillSerialNumber("001", 0);
    this.pds001.FillFacility("A01", 0);
    this.pds001.createButton();
    this.pds001.clickNext();
    this.pds001.clickNext();
    this.pds001.clickGridNext();
    this.connectMaterialOperation.setSno("140");
    this.connectMaterialOperation.setOperation("10");
    this.connectMaterialOperation.setComponent(newRawMatNumber);
    this.connectMaterialOperation.clickAddButton();
    this.pds002E.setQuantity("10");
    this.pds001.clickNext();
    this.pds001.clickNext();
    String lastAddedComponentId = this.connectMaterialOperation.getLastAddedComponentId();
    Assert.assertEquals(lastAddedComponentId, newRawMatNumber, ((("Actual value :" + lastAddedComponentId) + " value expected is ") + newItemNumber));
    this.connectMaterialOperation.clearTextSno();
    this.connectMaterialOperation.selectOperationFromLookUp("Y0010");
    this.connectMaterialOperation.clickAddButton();
    this.connectOperations.setRuntime("10");
    this.pds001.clickNext();
    this.pds001.clickNext();
    lastAddedComponentId = this.connectMaterialOperation.getLastAddedComponentId();
    Assert.assertTrue(lastAddedComponentId.contains("Y0010"), (("Actual value :" + lastAddedComponentId) + " value expected is YACUT01"));
    this.connectMaterialOperation.closeAllTabs();
  }
  
  public String createCustomerOrder(final String newItemNumber) {
    this.pds001.closeAllTabs();
    this.homePage.GoToOIS100();
    InputOutput.<String>print("Went inside GoToOIS100");
    this.ois100A.clearCOno();
    this.ois100A.clearCustomer();
    this.ois100A.fillCustomer("D10000");
    this.ois100A.fillCOType("F10");
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
    this.ois100A.clickNext();
    InputOutput.<String>println("completed here ois300 ");
    this.ois100H.FillPicingAndConditionsFNB("BEZ", "CRE");
    this.ois100H.ClickPrevious();
    this.ois101B1.CustomerOrderOPenLine(newItemNumber, "72", "72");
    this.ois101B1.ClickAdd();
    this.ois145e.Update();
    String coNumber = this.ois101B1.GetCONumber();
    InputOutput.<String>println(("CO Number " + coNumber));
    this.ois101B1.closeAllTabs();
    return coNumber;
  }
  
  public moDto MOPVerification(final String warehouse, final String newItemNumber) {
    this.homePage.GoToMMS080();
    this.mms080b1.setHeaderDetails(newItemNumber, warehouse);
    this.mms080b1.calculateMRPAndRefreshPage();
    this.mms080b1.SearchByOct("100");
    String orderNo = this.mms080b1.GetOrderNoOfRecordWithOct("100");
    System.out.println(("Order number from MMS080 is " + orderNo));
    this.mms080b1.closeAllTabs();
    this.homePage.GoToPMS170();
    this.pms170b.SelectSortingOrder("99-PlanOrder");
    this.pms170b.clearResponsible();
    this.pms170b.SearchWithPlanOrderNo(orderNo);
    this.pms170b.JointSchedulling();
    String scheduleNo = this.pms270e.GetSchedNo();
    System.out.println(("Schedule Number : " + scheduleNo));
    this.pms270e.clickNext();
    this.pms170b.ReleaseItem();
    Assert.assertEquals(this.pms170b.GetStsOfPlnOrd(orderNo), "60", (("MOP with Order num " + orderNo) + " was not released"));
    this.pms170b.closeAllTabs();
    this.homePage.goToHome();
    this.homePage.GoToPMS100();
    boolean _contains = this.pms100_b.getPageId().contains("PMS100/A");
    if (_contains) {
      this.pms100_b.closeAllTabs();
      PMS100SettingsTest pms100Settings = new PMS100SettingsTest(BaseTest.driver);
      pms100Settings.SetOpeningPanel("B-Browse");
    }
    this.pms100_b.SelectSortingOrder("91-SchNo/Product");
    this.pms100_b.EnterMainProduct(newItemNumber);
    String shortSched = scheduleNo.replaceFirst("^0+(?!$)", "");
    this.pms100_b.ClearMoNo();
    this.pms100_b.SearchScheduleNo(shortSched);
    String MONumber = this.pms100_b.GetMONumOfSchedule(shortSched);
    List<String> listStatus = this.pms100_b.GetStatusesWithSorting91(shortSched);
    Assert.assertEquals(listStatus.get(0), "20", "Status 1 is incorrect");
    Assert.assertEquals(listStatus.get(1), "22", "Ho is incorrect");
    Assert.assertEquals(listStatus.get(2), "40", "Status 2 is incorrect");
    this.pms100_b.goToCheckCompAvailability(MONumber);
    this.pms040b.changeFirstRecord();
    this.mms121b1.AddAllocatedQty();
    this.mms121b1.ClickPrevious();
    this.pms040b.clickRefresh();
    Assert.assertEquals(this.pms040b.getStatusOfFirstRecord(), "33", "Status was not 33 at PMS040");
    this.pms040b.closeAllTabs();
    System.out.println("Material Allocating completed.");
    this.homePage.GoToPMS100();
    this.pms100_b.SelectSortingOrder("91-SchNo/Product");
    this.pms100_b.EnterMainProduct(newItemNumber);
    this.pms100_b.ClearMoNo();
    this.pms100_b.SearchScheduleNo(shortSched);
    this.pms100_b.goToDeliveryToolbox();
    this.mws410b.relaseForPicking();
    Assert.assertEquals(this.mws410b.getRIPOFRow1(), "1");
    this.mws410b.MoveToPickingList();
    this.mws420b1.ConfirmIssues();
    Assert.assertEquals(this.mws420b1.getPiSOfFirstRow(), "90");
    this.mws420b1.closeAllTabs();
    this.homePage.GoToPMS070();
    this.pms070a.setSchedNumberFromLookUp(shortSched);
    this.pms070a.clearMONumber();
    this.pms070a.clearProductNo();
    this.pms070a.Next();
    this.pms070b1.confirmGridRow(0);
    String stat = this.pms070b1.getStatusOfGridRow(0);
    Assert.assertEquals(stat, "80", "Status was not 80 at PMS070 after confirming");
    this.pms070b1.closeOperationsWithStatus80();
    stat = this.pms070b1.getStatusOfGridRow(0);
    Assert.assertEquals(stat, "90", "Status was not 90 at PMS070 after closing operation");
    this.pms070b1.closeAllTabs();
    System.out.println("Material Issuing Completed ");
    this.homePage.GoToPMS050();
    this.pms050a.setSchedNumberFromLookUp(shortSched);
    this.pms050a.clearMONumber();
    this.pms050a.clearProductNo();
    this.pms050a.Next();
    this.pms050b1.goToChangeOfGridRow(0);
    this.pms050e.enterManufQtyAsOrderQty();
    this.pms050e.ClickNext();
    this.pms050e.ClickNext();
    this.pms050e.ClickNext();
    this.pms050b1.refreshPage();
    stat = this.pms050b1.getStatusOfGridRow(0);
    Assert.assertEquals(stat, "90");
    System.out.println("FG Reporting Executed ");
    this.pms050a.closeAllTabs();
    moDto data = new moDto();
    data.setLastJointSchNo(shortSched);
    data.setFullScheduleNo(scheduleNo);
    data.setMoNum(MONumber);
    return data;
  }
  
  public void StandardCosting(final String finishedGood, final String costingtype) {
    this.homePage.goToHome();
    this.homePage.GoToPDS001();
    this.pds001.SearchByItemNumber(finishedGood);
    this.pds001.goToCalculateProductCost();
    this.pcs200e.SetCostingType(costingtype);
    this.pcs200e.SelectPrtCosting("0-No");
    this.pcs200e.SetCostingName("STD");
    this.pcs200e.SelectAllLevels("1-Explosion, all");
    this.pcs200e.SetView("STD");
    this.pcs200e.SelectCalspurchdist("3-Yes, purch & distr items & subcontr op");
    this.pcs200e.clickNext();
    this.pcs200e.clickNext();
    this.pcs200f.clickNext();
    this.pds001.SearchByItemNumber(finishedGood);
    this.pds001.goToDisplayProductCosting();
    final String gridcostingtype = this.pcs300.getDataOfItem(costingtype).get(0);
    Assert.assertEquals(gridcostingtype, costingtype);
    this.pcs300.closeAllTabs();
  }
  
  public void POCreation(final String coNumber, final String newRawMaterialNumber) {
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
    this.ois300MaterialPlan.searchForStat("251");
    String PoNumber = this.ois300MaterialPlan.getTheOrderNumber("251");
    InputOutput.<String>println(("PO Number is " + PoNumber));
    this.ois300MaterialPlan.closeAllTabs();
    this.homePage.GoToPPS220();
    this.pps220B.searchPONumber(PoNumber);
    Assert.assertTrue(this.pps220B.checkTheLst("15"));
    this.pps220B.closeAllTabs();
    this.homePage.GoToPPS600();
    this.pps600E.FillPONumbers(PoNumber);
    this.pps600E.FillLowestStatus("15");
    this.pps600E.FillHighestStatus("15");
    this.pps600E.clickNext();
    this.pps600F.FillReportText(PoNumber);
    this.pps600F.clickNext();
    this.pps600SelectMedia.ConfirmOutput();
    this.pps600SelectMedia.closeAllTabs();
    this.homePage.GoToPPS220();
    this.pps220B.searchPONumber(PoNumber);
    Assert.assertEquals(this.pps220B.voidCheckTheStatus(PoNumber), "20");
    this.pps220B.closeAllTabs();
    this.homePage.GoToPPS250();
    this.pps250B1.enterPoNumber(PoNumber);
    this.pps250B1.clickConfirmation(newRawMaterialNumber);
    Assert.assertEquals(this.pps250B1.checkStatus(newRawMaterialNumber), "35");
    this.pps250B1.closeAllTabs();
    this.homePage.GoToPPS270();
    this.pps270B1.enterPoNumber(PoNumber);
    this.pps270B1.goToChange();
    this.pps270E.clickNext();
    Assert.assertEquals(this.pps270B1.checkStatus(newRawMaterialNumber), "45");
    this.pps270B1.closeAllTabs();
    this.homePage.GoToPPS300();
    boolean _contains = this.pps300b.getPageId().contains("PPS300/B1");
    boolean _not = (!_contains);
    if (_not) {
      this.pps300b.closeAllTabs();
      this.pps300Settings.SetOpeningPanel("B-Browse");
    }
    this.pps300b.setSortingOrder("1-Open lines");
    this.pps300b.enterPONum(PoNumber);
    this.pps300b.goToChange();
    this.pps300e.SetRecieveQtyAsConfirmedQty();
    this.pps300e.ClickNext();
    this.pps300e.closeAllTabs();
    this.homePage.GoToPPS330();
    this.pps330b.searchPONum(PoNumber);
    Assert.assertTrue(this.pps330b.checkStatusForPO(PoNumber, "50"));
    String recievingNo = this.pps330b.getRecievingNoOf(PoNumber);
    this.pps330b.closeAllTabs();
    this.homePage.GoToPPS320();
    boolean _contains_1 = this.pps320b1.getPageId().contains("PPS320/B1");
    boolean _not_1 = (!_contains_1);
    if (_not_1) {
      this.pps320b1.closeAllTabs();
      this.pps320Settings.SetOpeningPanel("B-Browse");
    }
    this.pps320b1.enterTheRecivingNo(recievingNo);
    this.pps320b1.clickApply();
    this.pps320b1.editFirstRow();
    this.pps320e.EnterStoredQtyAsRecieved();
    this.pps320e.Next();
    this.pps320b1.closeAllTabs();
    this.homePage.GoToPPS330();
    this.pps330b.searchPONum(PoNumber);
    Assert.assertTrue(this.pps330b.checkStatusForPO(PoNumber, "51"));
    this.pps330b.closeAllTabs();
    this.homePage.GoToPPS310();
    boolean _contains_2 = this.pps310b1.getPageId().contains("PPS310/B1");
    boolean _not_2 = (!_contains_2);
    if (_not_2) {
      this.pps310b1.closeAllTabs();
      this.pps310Settings.SetOpeningPanel("B-Browse");
    }
    this.pps310b1.enterTheRecivingNo(recievingNo);
    this.pps310b1.clickApply();
    this.pps310b1.editFirstRecord();
    this.pps310e.enterApprovedQty();
    this.pps310e.Next();
    this.pps310b1.closeAllTabs();
    this.homePage.GoToPPS330();
    this.pps330b.searchPONum(PoNumber);
    this.pps330b.checkStatusForPO(PoNumber, "65");
    this.pps330b.closeAllTabs();
    this.homePage.GoToMWS060();
    this.mws060b.enterItemNumber(newRawMaterialNumber);
    Assert.assertEquals(this.mws060b.checkStatus(newRawMaterialNumber), "2", "Status at MWS060 was not 2");
    this.mws060b.closeAllTabs();
  }
}
