package bi3.pages.fcs350

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List
import bi3.framework.elements.inforelements.InforGrid
import org.openqa.selenium.Keys
import org.openqa.selenium.By
import java.util.concurrent.TimeUnit
import bi3.infor.templates.ItemCreationTemplate

class FCS350_B extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	/*
	 * PAGE OBJECTS
	 * 
	 */
	@FindBy(id="WWITNO") 
	WebElement txtBoxItemNo;
	
	@FindBy(id="WWSTDT") 
	WebElement txtPeriodframeDate;
		
	@FindBy(id="WWPETP-shdo") 
	WebElement cmbPeriodType;
	
	@FindBy(css="#dropdown-list li") 
	List<WebElement> listPeriodType;
	
	@FindBy(id="XT_0168") 
	WebElement btnApply;
	
	@FindBy(css="div[id*='FCA350BS'][class*='inforDataGrid']") 
	WebElement gridFCS350;
	
	@FindBy(id="Next") 
	WebElement nextBtn;
	
	/*
	 * ACTIONS ( TEST METHODS )
	 * 
	 */	
	/**
	 * Set values to the fields in header section and click apply button
	 */
	def void setHeaderDetails(String itemNumber, String periodFrame, String periodType) {

		if (itemNumber != "") {
			waitForLoadingComplete()
			txtBoxItemNo.click()
			txtBoxItemNo.clearRobustly
			txtBoxItemNo.sendKeys(itemNumber)
		}

		if (periodType != "") {
			waitForLoadingComplete();
			selectFromDropdown(cmbPeriodType, listPeriodType, periodType);
		}

		if (periodFrame != "") {
			waitForLoadingComplete();
			txtPeriodframeDate.clear();
			txtPeriodframeDate.sendKeys(periodFrame);
		}
		
		// Click Apply	
		btnApply.clickWhenReady();
		waitForLoadingComplete();
	}
	
	/**
	 * Set forcasting qty for a empty grid cell
	 */
	def String setFCQtyForTheEmptyPeriod(String periodWithinCalYear, String fcQty) {
		var InforGrid grid = new InforGrid(gridFCS350);
		if (periodWithinCalYear != "") {
			grid.setValueToColumnSearchField("Per", periodWithinCalYear).sendKeys(Keys.ENTER);
			waitForLoadingComplete();			
		}

		// 1. First, get the cell without a value
		// 2. Click on it
		// 3. Type in the textbox
		grid.getCell("F/C qty", "").findElement(By.cssSelector("div.edit-cell")).clickWhenReady();
		grid.getCell("F/C qty", "").findElement(By.cssSelector("input.inforTextbox")).sendKeys(fcQty);

		// 4. Return Fr dt of the row
		var WebElement frdtElement = driver.findElement(By.cssSelector("div.slick-row.active div:nth-child(2)"));
		return frdtElement.text;
	}
	
	/**
	 * Click Next
	 */
	def void Next(){
		//Click NextBtn
		waitForLoadingComplete();
		nextBtn.click();
		waitForLoadingComplete();
	}
	
}