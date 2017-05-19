package bi3.tests.fnb;

import bi3.configuration.settings.OIS390SettingTest;
import bi3.framework.config.ConfigKeys;
import bi3.framework.util.ExcelUtil;
import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.ToolbarPage;
import bi3.pages.ois100.OIS100H;
import bi3.pages.ois101.OIS101E;
import bi3.pages.ois275.OIS275B_1;
import bi3.pages.ois276.OIS276B;
import bi3.pages.ois300.OIS300B;
import bi3.pages.ois390.OIS390A;
import bi3.pages.ois390.OIS390B1;
import bi3.pages.ois390.OIS390E;
import bi3.pages.ois390.OIS391B1;
import bi3.pages.ois390.OIS391E;
import bi3.pages.ois390.OIS392E;
import bi3.pages.ois390.OIS393B;
import bi3.tests.BaseTest;
import java.util.HashMap;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class CustomerReturnTest extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private OIS390A ois390a;
  
  private OIS390E ois390e;
  
  private OIS391E ois391e;
  
  private OIS392E ois392e;
  
  private OIS391B1 ois391b1;
  
  private ToolbarPage toolbarPage;
  
  private OIS390SettingTest ois390settingTest;
  
  private OIS390B1 ois390b1;
  
  private OIS393B ois393b;
  
  private OIS275B_1 OIS275b_1;
  
  private OIS100H ois100h;
  
  private OIS276B ois276b;
  
  private OIS101E ois101e;
  
  private ToolbarPage toolBarPage;
  
  private OIS300B ois300b;
  
  private ExcelUtil ois390Adata;
  
  private HashMap<String, String> hashMap;
  
  @BeforeMethod
  public void Initialize() {
    try {
      LoginPage _loginPage = new LoginPage(BaseTest.driver);
      this.loginPage = _loginPage;
      HomePage _homePage = new HomePage(BaseTest.driver);
      this.homePage = _homePage;
      OIS390A _oIS390A = new OIS390A(BaseTest.driver);
      this.ois390a = _oIS390A;
      OIS390E _oIS390E = new OIS390E(BaseTest.driver);
      this.ois390e = _oIS390E;
      ToolbarPage _toolbarPage = new ToolbarPage(BaseTest.driver);
      this.toolbarPage = _toolbarPage;
      OIS391E _oIS391E = new OIS391E(BaseTest.driver);
      this.ois391e = _oIS391E;
      OIS392E _oIS392E = new OIS392E(BaseTest.driver);
      this.ois392e = _oIS392E;
      OIS391B1 _oIS391B1 = new OIS391B1(BaseTest.driver);
      this.ois391b1 = _oIS391B1;
      OIS390SettingTest _oIS390SettingTest = new OIS390SettingTest(BaseTest.driver);
      this.ois390settingTest = _oIS390SettingTest;
      OIS390B1 _oIS390B1 = new OIS390B1(BaseTest.driver);
      this.ois390b1 = _oIS390B1;
      OIS393B _oIS393B = new OIS393B(BaseTest.driver);
      this.ois393b = _oIS393B;
      OIS275B_1 _oIS275B_1 = new OIS275B_1(BaseTest.driver);
      this.OIS275b_1 = _oIS275B_1;
      OIS100H _oIS100H = new OIS100H(BaseTest.driver);
      this.ois100h = _oIS100H;
      OIS276B _oIS276B = new OIS276B(BaseTest.driver);
      this.ois276b = _oIS276B;
      OIS101E _oIS101E = new OIS101E(BaseTest.driver);
      this.ois101e = _oIS101E;
      ToolbarPage _toolbarPage_1 = new ToolbarPage(BaseTest.driver);
      this.toolBarPage = _toolbarPage_1;
      OIS300B _oIS300B = new OIS300B(BaseTest.driver);
      this.ois300b = _oIS300B;
      final String path = ConfigKeys.DATA_HELPER_PATH;
      final String sheetOIS390A = "OIS390A";
      ExcelUtil _excelUtil = new ExcelUtil(path, sheetOIS390A);
      this.ois390Adata = _excelUtil;
      this.hashMap = this.ois390Adata.getExcelActiveSheetFirstTwoColumnData();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void CustomerOrderCreation() {
    String warehouse = this.hashMap.get("Warehouse").toString();
    String coNumber = this.hashMap.get("Refordercat").toString();
    String transReason = this.hashMap.get("TransReason").toString();
    String returnedQty = this.hashMap.get("ReturnedQty").toString();
    String rejectedQty = this.hashMap.get("RejectedQty").toString();
    String location = this.hashMap.get("Location").toString();
    this.ois390settingTest.SetOpeningPanel("A-Entry");
    this.ois390a.SetPanelSqequence(warehouse);
    this.ois390a.selectCoNumber(coNumber);
    this.ois390a.clickNext();
    Assert.assertEquals(this.ois390a.getM3lblValue(), ((("Order already returned Order number " + "00") + coNumber) + ""));
    this.ois390a.confirmInfoBox();
    this.ois390e.selectTransReason(transReason);
    this.ois390e.clickNext();
    String receivingNo = this.ois391b1.getReceivingNoValue();
    this.toolbarPage.ClickAction_Retrieve();
    this.ois391e.SelectFirstRows();
    this.toolbarPage.ClickOption_Change();
    this.ois391e.enterReturnedQty(returnedQty);
    this.ois391e.clickNext();
    this.ois391e.clickNext();
    this.ois392e.enterRejectedQty(rejectedQty);
    String lotNumber = this.ois392e.getLotValue();
    this.ois392e.enterLotNumber(lotNumber);
    this.ois392e.enterLocation(location);
    this.ois392e.clickNext();
    this.toolbarPage.ClickAction_Update();
    this.toolbarPage.clickRelated("Inspection");
    this.ois392e.enterLotNumber(lotNumber);
    this.ois392e.enterLocation(location);
    this.toolbarPage.ClickAction_Update();
    this.ois391b1.closeAllTabs();
    this.ois390settingTest.SetOpeningPanel("B-Browse");
    this.ois390b1.enterRecvnNo(receivingNo);
    this.ois390b1.selectFirstRows();
    this.toolbarPage.clickRelated("Crt credit");
    this.toolbarPage.ClickAction_Update();
    String[] temporaryOrder = this.ois393b.getTemporaryOrderValue().split(" ");
    String genaratedtemporaryOrder = temporaryOrder[4];
    this.ois390b1.closeAllTabs();
    this.homePage.GoToOIS275();
    this.OIS275b_1.enterTemporaryOrdrNo(genaratedtemporaryOrder);
    this.toolBarPage.clickRelated("Check/release");
    this.ois100h.FillTax("NOT");
    this.ois100h.ClickNext();
    this.ois276b.ClickPreviousPage();
    this.OIS275b_1.enterTemporaryOrdrNo(genaratedtemporaryOrder);
    this.toolBarPage.clickRelated("Check/release");
    this.ois276b.Release();
    this.ois276b.ClickWarningOkButton();
    this.ois101e.clickNext();
    this.toolBarPage.ClickAction_Refresh();
    String CONumber = this.ois276b.CopyCONumber();
    System.out.println(("CO Number :" + CONumber));
    this.ois276b.closeAllTabs();
    this.homePage.GoToOIS300();
    this.ois300b.searchCONumber(CONumber);
    this.ois300b.setSortingOrder("1-Order Number");
    String status = this.ois300b.getFirstRowStatus();
    Assert.assertEquals(status, "66");
  }
}
