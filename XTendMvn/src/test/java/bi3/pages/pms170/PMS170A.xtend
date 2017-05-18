package bi3.pages.pms170

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class PMS170A extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(id="W1PRNO")
	WebElement txtProduct;

	@FindBy(css="#W1PRNOContainer button")
	WebElement btnPrduct;

	@FindBy(css="#POS")
	WebElement txtSku;

	@FindBy(css="div[row='0']>div[class='slick-cell l0 r0  uppercase']")
	WebElement firstGridCell;

	@FindBy(id="BTN_L52T24")
	WebElement btnSelect;

	@FindBy(id="Next")
	WebElement btnNext;

	def EnterProduct(String product) {
		waitToBeDisplayed(txtProduct)
		txtProduct.click();
		txtProduct.clearRobustly();
		txtProduct.sendKeys(product);

	}

	def void ClickProduct() {
		waitForLoadingComplete()
		btnPrduct.click();

	}

	def void EnterSku(String sku) {
		waitForLoadingComplete()
		txtSku.clearRobustly();
		txtSku.sendKeys(sku);
		txtSku.sendKeys(Keys.ENTER);
		

	}

	def void SelectFirstRow() {
		Thread.sleep(1000);
		firstGridCell.click();

	}

	def void SelectSku() {
		Thread.sleep(1000);
		btnSelect.click();

	}

	def void clickNext() {
        Thread.sleep(1000);
		btnNext.click()
		waitForLoadingComplete()
	}

}
