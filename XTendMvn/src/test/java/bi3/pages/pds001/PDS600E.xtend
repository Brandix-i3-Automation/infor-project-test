package bi3.pages.pds001

//SK
import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.pages.ois101.OIS101E
import bi3.pages.ois100.OIS100G

class PDS600E extends BasePage {
	OIS100G ois100G
	OIS101E ois101e

	def void Initialize() {
		ois101e = new OIS101E(driver)
		ois100G = new OIS100G(driver)
	}

	new(WebDriver driver) {
		super(driver)
	}

	// PAGE OBJECTS
//	@FindBy(css="#W01OPTContainer>button[class='inforTriggerButton inforBrowseIcon']")
//	WebElement colorSelectArrow
	@FindBy(css="#W01OPTContainer>button")
	WebElement colorSelectArrow

	@FindBy(id="POS")
	WebElement txtSearchBoxPOS

//	@FindBy(id="#W01OPT")
//	WebElement colorInput
	@FindBy(css="#W02OPTContainer>button")
	WebElement sizeSelectArrow

	@FindBy(css="div[id*='BROWSE_LIST'] div.slick-cell.l0.r0")
	WebElement gridFirstRowColor

	@FindBy(id="BTN_L52T24")
	WebElement btnSelect

	@FindBy(css="div[id*='BROWSE_LIST'] div.slick-cell.l0.r0")
	WebElement gridFirstRowSize

	@FindBy(id="Next")
	WebElement btnNext

	@FindBy(id="dbtnok")
	WebElement btnOK_PopUp

	@FindBy(id="dbtnyes")
	WebElement btnYes_PopUp

	// PAGE ACTIONS
	def void fillMatrix(String POS_no, String Size) {
		// Color 
		colorSelectArrow.click()
		waitForLoadingComplete()
		txtSearchBoxPOS.clickWhenReady()
		txtSearchBoxPOS.sendKeys(POS_no)
		txtSearchBoxPOS.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		gridFirstRowColor.clickWhenReady()
		btnSelect.clickWhenReady()

		// Size
		waitToBeClickable(sizeSelectArrow)
		sizeSelectArrow.click()
		waitForLoadingComplete()
		txtSearchBoxPOS.clickWhenReady()
		txtSearchBoxPOS.sendKeys(Size)
		txtSearchBoxPOS.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		gridFirstRowSize.clickWhenReady()
		btnSelect.clickWhenReady()
		waitForLoadingComplete()

		// Closing Pop-up
		// click NEXT
		btnNext.click()
		waitForLoadingComplete()
	}
}
