package bi3.tests.e2e

import bi3.pages.LoginPage
import bi3.pages.HomePage
import org.openqa.selenium.WebDriver
import org.testng.annotations.BeforeMethod
import bi3.pages.ProgramCommons
import org.testng.annotations.Test

class E2EOrderEntryTest extends ProgramCommons {
	
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
	 * @TestCaseID: 005
	 * @CloudSuite: F&B
	 * @Description: Test the Order entry flow including integration to Search, IDM and Infor BI.
	 * @author:	
	 */
	@Test
	def void E2EOrderEntryTest() {
		loginPage.GoTo()
	}
}
