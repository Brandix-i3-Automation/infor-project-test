package bi3.tests;

import bi3.pages.HomePage;
import bi3.pages.LoginPage;
import bi3.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class RTest extends BaseTest {
  private LoginPage loginPage;
  
  private HomePage homePage;
  
  @BeforeMethod
  public void Initialize() {
    LoginPage _loginPage = new LoginPage(BaseTest.driver);
    this.loginPage = _loginPage;
    HomePage _homePage = new HomePage(BaseTest.driver);
    this.homePage = _homePage;
  }
  
  @Test
  public void createT() {
    this.loginPage.GoTo();
    this.homePage.GoToPDS001();
  }
}
