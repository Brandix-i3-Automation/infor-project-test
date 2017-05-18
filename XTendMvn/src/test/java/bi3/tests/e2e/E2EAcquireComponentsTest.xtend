package bi3.tests.e2e

import bi3.pages.ProgramCommons
import bi3.pages.LoginPage
import bi3.pages.HomePage
import org.openqa.selenium.WebDriver
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class E2EAcquireComponentsTest extends ProgramCommons{
	
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
	 * @TestCaseID: 003
	 * @CloudSuite: F&B
	 * @Description: Test the PO workflow and purchase raw materials & ingredients to be used in manufacturing
	 * @author:	
	 */
	@Test
	def void E2EAcquireComponentsTest() {
		loginPage.GoTo()
		
		//xxxxx
	}
}