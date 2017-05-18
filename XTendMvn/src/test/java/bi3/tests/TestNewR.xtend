package bi3.tests

import bi3.pages.LoginPage
import bi3.pages.HomePage
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import bi3.pages.pds001.PDS001

class TestNewR extends BaseTest{
	
	
	LoginPage loginPage
	HomePage homePage
	PDS001 pds001
	
	
	
	@BeforeMethod
	def void Initialize() {
		loginPage = new LoginPage(driver)
		homePage = new HomePage(driver)
		pds001 = new PDS001(driver)
		
		}
		
	@Test
	def void createT(){
		
		loginPage.GoTo
		homePage.GoToPDS001
		pds001.SearchByItemNumber("Y3594")
		pds001.goToMaterialAndOperations("Y3594")
		pds001.addOneMoreButtton("27","22","Y80091","1")
		pds001.goToOptionLine
		pds001.selectItemFromM3Browse("3",1,"ExSze8-16",6,"X016")
		pds001.creationProcess
		pds001.intendedBom
		
		
		
	}
}