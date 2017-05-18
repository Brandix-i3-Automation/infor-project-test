package bi3.tests;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
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
import bi3.pages.mms001.MMS001J;
import bi3.pages.mms001.MMS001K;
import bi3.pages.mms001.MMS001L;
import bi3.pages.mms001.MMS001M;
import bi3.pages.pds001.PDS001;
import bi3.pages.pds001.PDS001ConnectMaterialOperation;
import bi3.pages.pds001.PDS001ConnectOperations;
import bi3.pages.pds001.PDS001E;
import bi3.pages.pds001.PDS001F;
import bi3.pages.pms001.PMS001;
import bi3.pages.pms001.PMS001E;
import bi3.pages.pms001.PMS001F;
import bi3.pages.pms100.PMS100;
import bi3.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class PMS001Test extends BaseTest {
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
  
  private MMS001ConnectWarehouse mms001ConnectWarehouse;
  
  private MMS001ConnectWarehouseE connectWarehouseE;
  
  private MMS001ConnectWarehouseF connectWarehouseF;
  
  private MMS001ConnectWarehouseG connectWarehouseG;
  
  private MMS001ConnectWarehouseH connectWarehouseH;
  
  private MMS001ConnectWarehouseI connectWarehouseI;
  
  private PDS001 pds001;
  
  private PDS001F pds001F;
  
  private PDS001ConnectMaterialOperation connectMaterialOperation;
  
  private PDS001E pds001E;
  
  private PDS001ConnectOperations connectOperations;
  
  private PMS001 pms001;
  
  private PMS001E pms001E;
  
  private PMS001F pms001F;
  
  private PMS100 pms100;
  
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
    PDS001 _pDS001 = new PDS001(BaseTest.driver);
    this.pds001 = _pDS001;
    PDS001F _pDS001F = new PDS001F(BaseTest.driver);
    this.pds001F = _pDS001F;
    PDS001ConnectMaterialOperation _pDS001ConnectMaterialOperation = new PDS001ConnectMaterialOperation(BaseTest.driver);
    this.connectMaterialOperation = _pDS001ConnectMaterialOperation;
    PDS001E _pDS001E = new PDS001E(BaseTest.driver);
    this.pds001E = _pDS001E;
    PDS001ConnectOperations _pDS001ConnectOperations = new PDS001ConnectOperations(BaseTest.driver);
    this.connectOperations = _pDS001ConnectOperations;
    PMS001 _pMS001 = new PMS001(BaseTest.driver);
    this.pms001 = _pMS001;
    PMS001E _pMS001E = new PMS001E(BaseTest.driver);
    this.pms001E = _pMS001E;
    PMS001F _pMS001F = new PMS001F(BaseTest.driver);
    this.pms001F = _pMS001F;
    PMS100 _pMS100 = new PMS100(BaseTest.driver);
    this.pms100 = _pMS100;
  }
  
  @Test
  public void CreateNewMO() {
    this.loginPage.GoTo();
    this.homePage.GoToMMS001();
    this.mms001.SearchByItemNumber("Y3001");
    this.mms001.CopyItem("Y3001");
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
    this.mms001.SearchByItemNumber("Y7001");
    this.mms001.CopyItem("Y7001");
    this.mms001C.Next();
    this.mms001E.SelectInvAccounting("1-Inv accounting");
    this.mms001E.SelectLotCtrlMethod("3-In lot master");
    this.mms001E.SelectLotNumbMethod("5-Auto order no");
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
    System.out.println(("Created raw material ID : " + newRawMatNumber));
    this.mms001.close();
    this.homePage.GoToPDS001();
    this.pds001.FillItemNumber(newItemNumber, 0);
    this.pds001.FillSerialNumber("001", 0);
    this.pds001.FillFacility("A01", 0);
    this.pds001.CreateProductStructure(0);
    this.pds001.clickNext();
    this.pds001.clickNext();
    this.pds001F.setM3Text(("Creating product structure for item " + newItemNumber));
    this.connectMaterialOperation.setSno("10");
    this.connectMaterialOperation.setOperation("10");
    this.connectMaterialOperation.setComponent(newRawMatNumber);
    this.connectMaterialOperation.clickAddButton();
    this.pds001E.setQuantity("10");
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
    this.pds001.closeAllTabs();
    this.homePage.GoToPMS001();
    this.pms001.setProductNo(newItemNumber);
    this.pms001.setStructureType("001");
    this.pms001.clickAddButton();
    this.pms001E.setOrderQuantity("100");
    this.pms001E.setFinishDate("170412");
    this.pms001E.setStartDate("170411");
    this.pms001E.clickNext();
    this.pms001F.selectSchedNoFromLookUp("12");
    this.pms001F.clickNext();
    this.pms001.searchForMOWithItemNo(newItemNumber);
    String firstGridItemText = this.pms001.getItemNumberOfFirstRecord();
    Assert.assertEquals(firstGridItemText, newItemNumber);
    this.pms001.closeAllTabs();
    this.homePage.GoToPMS100();
    this.pms100.searchMOBy("12", newItemNumber);
    Assert.assertEquals(this.pms100.getScedNoOfRow1(), "12");
    Assert.assertEquals(this.pms100.getProdNoOfRow1(), newItemNumber);
  }
}
