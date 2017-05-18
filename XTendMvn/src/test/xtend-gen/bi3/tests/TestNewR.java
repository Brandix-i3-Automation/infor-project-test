package bi3.tests;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.pages.pds001.PDS001;
import bi3.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class TestNewR extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  private PDS001 pds001;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
    PDS001 _pDS001 = new PDS001(BaseTest.driver);
    this.pds001 = _pDS001;
  }
  
  @Test
  public void createT() {
    this.loginPage.GoTo();
    this.homePage.GoToPDS001();
    this.pds001.SearchByItemNumber("Y3594");
    this.pds001.goToMaterialAndOperations("Y3594");
    this.pds001.addOneMoreButtton("27", "22", "Y80091", "1");
    this.pds001.goToOptionLine();
    this.pds001.selectItemFromM3Browse("3", 1, "ExSze8-16", 6, "X016");
    this.pds001.creationProcess();
    this.pds001.intendedBom();
  }
}
