package bi3.tests;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.ToolbarPage;
import bi3.pages.ois100.OIS100H;
import bi3.pages.ois101.OIS101E;
import bi3.pages.ois275.OIS275B_1;
import bi3.pages.ois276.OIS276B;
import bi3.pages.ois300.OIS300B;
import bi3.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class OIS275Tests extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private OIS275B_1 OIS275b_1;
  
  private OIS100H ois100h;
  
  private OIS276B ois276b;
  
  private OIS101E ois101e;
  
  private ToolbarPage toolBarPage;
  
  private OIS300B ois300b;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    OIS275B_1 _oIS275B_1 = new OIS275B_1(BaseTest.driver);
    this.OIS275b_1 = _oIS275B_1;
    OIS100H _oIS100H = new OIS100H(BaseTest.driver);
    this.ois100h = _oIS100H;
    OIS276B _oIS276B = new OIS276B(BaseTest.driver);
    this.ois276b = _oIS276B;
    OIS101E _oIS101E = new OIS101E(BaseTest.driver);
    this.ois101e = _oIS101E;
    ToolbarPage _toolbarPage = new ToolbarPage(BaseTest.driver);
    this.toolBarPage = _toolbarPage;
    OIS300B _oIS300B = new OIS300B(BaseTest.driver);
    this.ois300b = _oIS300B;
  }
  
  @Test
  public void CustomerOrderReturn() {
    this.loginPage.GoTo();
    this.homePage.GoToOIS275();
    this.toolBarPage.clickRelated("Check/release");
    this.ois100h.FillTax("NOT");
    this.ois100h.ClickNext();
    this.ois276b.ClickPreviousPage();
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
  }
}
