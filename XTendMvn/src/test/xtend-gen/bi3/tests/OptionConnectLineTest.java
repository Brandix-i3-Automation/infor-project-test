package bi3.tests;

import bi3.infor.templates.ItemCreationTemplate;
import bi3.infor.templates.dto.ItemTemplate;
import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.ToolbarPage;
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
import bi3.pages.pds001.PDS001;
import bi3.pages.pds001.PDS001ConnectMaterialOperation;
import bi3.pages.pds001.PDS001ConnectOperations;
import bi3.pages.pds001.PDS001E;
import bi3.pages.pds001.PDS001F;
import bi3.pages.pds001.PDS003B;
import bi3.pages.pds001.PDS003E;
import bi3.tests.BaseTest;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class OptionConnectLineTest extends BaseTest {
  private HomePage homePage;
  
  private LoginPage loginPage;
  
  private PDS001 pds001;
  
  private PDS001ConnectMaterialOperation pds001ConnectMaterialOperation;
  
  private ToolbarPage toolbarPage;
  
  private PDS001E pds001E;
  
  private PDS001F pds001F;
  
  private PDS003B pds003B;
  
  private PDS003E pds003E;
  
  private PDS001E pds002E;
  
  private ItemCreationTemplate ItemCreationTemplate;
  
  private ItemTemplate ItemTemplate;
  
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
  
  private PDS001ConnectOperations connectOperations;
  
  @BeforeMethod
  public void Initialize() {
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    PDS001 _pDS001 = new PDS001(BaseTest.driver);
    this.pds001 = _pDS001;
    PDS001ConnectMaterialOperation _pDS001ConnectMaterialOperation = new PDS001ConnectMaterialOperation(BaseTest.driver);
    this.pds001ConnectMaterialOperation = _pDS001ConnectMaterialOperation;
    ToolbarPage _toolbarPage = new ToolbarPage(BaseTest.driver);
    this.toolbarPage = _toolbarPage;
    PDS001E _pDS001E = new PDS001E(BaseTest.driver);
    this.pds001E = _pDS001E;
    PDS001F _pDS001F = new PDS001F(BaseTest.driver);
    this.pds001F = _pDS001F;
    PDS003B _pDS003B = new PDS003B(BaseTest.driver);
    this.pds003B = _pDS003B;
    PDS003E _pDS003E = new PDS003E(BaseTest.driver);
    this.pds003E = _pDS003E;
    PDS001ConnectOperations _pDS001ConnectOperations = new PDS001ConnectOperations(BaseTest.driver);
    this.connectOperations = _pDS001ConnectOperations;
    PDS001E _pDS001E_1 = new PDS001E(BaseTest.driver);
    this.pds002E = _pDS001E_1;
    ItemCreationTemplate _itemCreationTemplate = new ItemCreationTemplate(BaseTest.driver);
    this.ItemCreationTemplate = _itemCreationTemplate;
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
  }
  
  @Test
  public void optionConnectTest() {
    this.loginPage.GoTo();
    this.homePage.GoToMMS001();
    ItemTemplate _itemTemplate = new ItemTemplate();
    this.ItemTemplate = _itemTemplate;
    this.ItemTemplate = this.ItemCreationTemplate.createItem("Y3001");
    String newItemNumber = this.ItemTemplate.getItemCode();
    this.mms001.setItemWarehouse(newItemNumber);
    this.mms001ConnectWarehouse.changeWarehouse();
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
    this.homePage.GoToMMS001();
    this.mms001.SearchByItemNumber("Y7005");
    this.mms001.CopyItem("Y7005");
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
    System.out.println(newRawMatNumber);
    this.mms001.close();
    this.mms001.goToHome();
    this.homePage.GoToMMS077();
    this.mms077.CreateItemsByMatrix(newItemNumber);
    this.mms077.navigateToselectMedia();
    this.mms077_SelectMedia.ConfirmOutput();
    this.mms077.CreateItemsByMatrix(newRawMatNumber);
    this.mms077.navigateToselectMedia();
    this.mms077_SelectMedia.ConfirmOutput();
    this.mms077.closeAllTabs();
    this.mms077.goToHome();
    this.homePage.GoToMMS001();
    this.mms001.SearchByItemNumber(newItemNumber);
    List<String> itemData = this.mms001.getDataOfItem(newItemNumber);
    this.mms001.SearchByItemNumber(newRawMatNumber);
    this.mms001.EditItem(newRawMatNumber);
    this.mms001E.setStatus("20-Released");
    this.mms001E.Next();
    this.mms001E.closeAllTabs();
    this.mms001E.goToHome();
    this.homePage.GoToMMS001();
    this.mms001.SearchByItemNumber(newRawMatNumber);
    this.mms001E.closeAllTabs();
    this.mms001E.goToHome();
    this.homePage.GoToPDS001();
    this.pds001.SearchByItemNumber(newItemNumber);
    this.pds001.goToMaterialAndOperations(newItemNumber);
    this.pds001ConnectMaterialOperation.setSno("10");
    this.pds001ConnectMaterialOperation.setOperation("10");
    this.pds001ConnectMaterialOperation.setComponent(newRawMatNumber);
    this.pds001ConnectMaterialOperation.clickAddButton();
    this.pds002E.setQuantity("10");
    this.pds001.clickNext();
    this.pds001.clickNext();
    String lastAddedComponentId = this.pds001ConnectMaterialOperation.getLastAddedComponentId();
    this.pds001ConnectMaterialOperation.clearTextSno();
    this.pds001ConnectMaterialOperation.selectOperationFromLookUp("YACUT01");
    this.pds001ConnectMaterialOperation.clickAddButton();
    this.connectOperations.setRuntime("10");
    this.pds001.clickNext();
    this.pds001.clickNext();
    lastAddedComponentId = this.pds001ConnectMaterialOperation.getLastAddedComponentId();
    InputOutput.<String>println(("-----Item Number: " + newItemNumber));
    InputOutput.<String>println(("-----Raw Material Number: " + newRawMatNumber));
    this.pds001ConnectMaterialOperation.close();
    this.pds001.SearchByItemNumber(newRawMatNumber);
    this.pds001.EditItem(newRawMatNumber);
    this.pds001E.setStatus("20-Released");
    this.pds001E.Next();
    this.pds001E.closeAllTabs();
    this.homePage.GoToPDS001();
    this.pds001.SearchByItemNumber(newItemNumber);
    this.pds001.goToMaterialAndOperations("Y3645");
    this.pds001ConnectMaterialOperation.setSno("25");
    this.pds001ConnectMaterialOperation.setOperation("20");
    this.pds001ConnectMaterialOperation.setComponent("Y80012");
    this.toolbarPage.clickCreateLogo();
    this.pds001E.setQuantity("1");
    this.pds001E.Next();
    this.pds001F.Next();
    this.toolbarPage.ClickAction_Refresh();
    this.pds001ConnectMaterialOperation.selectOperation("Y80012");
    this.pds003B.setstp("3");
    this.pds003B.setSelectId("XY01");
    this.pds003B.setOption("X016");
    this.toolbarPage.clickCreateLogo();
    this.pds003E.selectFromInclExcl("1-Include");
    this.pds003E.clickNext();
    this.pds003E.closeAllTabs();
    this.homePage.GoToPDS001();
    this.pds001.SearchByItemNumber(newItemNumber);
  }
}
