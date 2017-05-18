package bi3.tests.e2e

import bi3.pages.LoginPage
import bi3.pages.HomePage
import bi3.pages.ProgramCommons
import org.openqa.selenium.WebDriver
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class E2EManufactureTest extends ProgramCommons {

	LoginPage loginPage
	HomePage homePage

	new(WebDriver driver) {
		super(driver)
	}

	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver)
		homePage = new HomePage(driver)
	}

	/**
	 * @TestCaseID: 004
	 * @CloudSuite: F&B
	 * @Description: Test the MO workflow and manufacture component and the finished goods.
	 * @author:	
	 */
	@Test
	def void E2EManufactureTest() {
		loginPage.GoTo()
	}
}
