package bi3.tests

import org.testng.annotations.BeforeTest
import bi3.pages.HomePage
import bi3.pages.LoginPage
import org.testng.annotations.Test
import bi3.pages.cas950.CAS950E

class CostingMoTest extends BaseTest {

	HomePage homePage
	LoginPage loginPage
	CAS950E cas950_e

	@BeforeTest
	def void Initialize() {

		homePage = new HomePage(driver)
		loginPage = new LoginPage(driver)
		cas950_e = new CAS950E(driver)

	}

	@Test
	def void ProductOrderProposal() {
		loginPage.GoTo();
		homePage.GoToCAS950();
		// YYMMDD
		cas950_e.selectFromDate("170502");
		cas950_e.selectToDate("170503");
		cas950_e.checkStockTrance();
		cas950_e.checkOpTranceMo();
		cas950_e.checkOtherTrance();
		cas950_e.checkOpTranceWo()
		cas950_e.checkOrderCosting();
		cas950_e.Next();

	}

}
