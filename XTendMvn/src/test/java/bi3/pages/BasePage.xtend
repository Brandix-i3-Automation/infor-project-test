package bi3.pages

import bi3.framework.core.WebDriverExtensions
import java.util.List
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class BasePage extends WebDriverExtensions {

	// public static WebDriver driver;
	new(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="inforLoadingOverlay")
	static WebElement loadingIcon;

	@FindBy(id="showProgramShortName")
	static WebElement pageId;

	@FindBy(id="startDiv")
	WebElement btnStart
	
	@FindBy(css = ".previousBtn")
	WebElement btnPrev
	
	@FindBy(css = "li[class='ui-tabs-selected ui-state-active']>button[class='inforTabCloseButton']")
	WebElement btnActiveTabClose

	def static void waitForLoadingComplete() {
		waitToBeHidden(loadingIcon);
	}

	def static clickWhenReady(WebElement element) {
		try {
			waitForLoadingComplete();
			element.waitToBeDisplayed(60000);
			element.click();
		} catch (StaleElementReferenceException ex) {
			Thread.sleep(3000);
			element.click();
		} catch (Exception e) {
			System.out.println("Click on " + element + " Failed " + e.getStackTrace());
		}
	}

	def String getPageId() {
		System.out.println(pageId.getText());
		return pageId.getText();
	}

	def static String GetTextBoxvalue(WebElement element) {
		return element.getAttribute("value");
	}

	def static clearRobustly(WebElement element) {
		try {
			element.clear();

			// Clear robustly
			if (element.GetTextBoxvalue().trim().length() != 0) {
				element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				element.sendKeys(Keys.chord(Keys.DELETE));
			}
		// System.out.println("Sucessfully cleared the element");
		} catch (Exception e) {
			System.out.println("Element " + element + " cannot be cleared " + e.getStackTrace());
		}
	}
    
    def static SelectAllGridRows(WebElement element) {
		try {
			element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		} catch (Exception e) {
			System.out.println("Element " + element + " cannot select All Rows" + e.getStackTrace());
		}
	}

	def void closeAllTabs() {
		try {
			var List<WebElement> listBtnClose = driver.findElements(
				By.cssSelector("li.ui-state-active button.inforTabCloseButton"));
			do {
				listBtnClose.get(0).click();
				waitForLoadingComplete()
				listBtnClose = driver.findElements(By.cssSelector("li.ui-state-active button.inforTabCloseButton"));
			} while (listBtnClose.size != 0);
		} catch (Exception e) {
			System.out.println("Error on closing tabs " + e.getStackTrace());

		}
	}

	def void goToHome() {
		btnStart.click()
		waitForLoadingComplete();
	}
	
	def void ClickPrevious(){
		waitForLoadingComplete()
		btnPrev.waitToBeClickable()
		btnPrev.click()
		waitForLoadingComplete()
	}
	
	def void CloseActiveTab(){
		btnActiveTabClose.waitToBeClickable()
		btnActiveTabClose.click()
		waitForLoadingComplete()
	}
}
