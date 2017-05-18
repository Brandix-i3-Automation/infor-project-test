package bi3.pages.ois100

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import org.openqa.selenium.StaleElementReferenceException

class OIS100H extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="#OATAXCContainer > button")
	WebElement btnTaxCode;

	@FindBy(css="#POS")
	WebElement txtTax;
	
	@FindBy(css="div[id*='BROWSE_LIST'][class*='inforDataGrid']")
	WebElement gridOIS100H;
	
	@FindBy(id="BTN_L52T24")
	WebElement btnSelect
	
	@FindBy(css="#OATAXC")
	WebElement txtTaxN;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(id="Prev")
	WebElement btnPrev;
	
	@FindBy(css="#tabsList > li.ui-tabs-selected.ui-state-active > button")
	WebElement btnClose
	
	@FindBy(css="input[id='OAPYCD']")
	WebElement txtMtdAR;
	
	@FindBy(css="input[id='OATAXC']")
	WebElement txtTaxCode;
	
	
	def void FillTax(String Keyvalue){
		waitForLoadingComplete()
		txtTaxN.sendKeys(Keyvalue);
		
//		btnTaxCode.click();
//		waitForLoadingComplete();
//		txtTax.clearRobustly();
//		txtTax.sendKeys("NOT");
//		txtTax.sendKeys(Keys.ENTER);
//		
//		var InforGrid inforGrid = new InforGrid(gridOIS100H);
//		var WebElement matchingCell = inforGrid.getCell("Key value",Keyvalue);
//		
//		if(matchingCell.isDisplayed()){
//			matchingCell.click();
//			btnSelect.click();		
//		}

	
	
	}
	
	def void ClickNext(){
		waitForLoadingComplete()
		btnNext.click();
		waitForLoadingComplete()
	}
	
	def void ClickPreviousPage(){
		
		waitToBeClickable(btnPrev);
	   btnPrev.click()
		waitForLoadingComplete()
		
	}
	
	def close() {
		btnClose.click()
		System.out.println("OIS276B tab closed")
	}
	
	def void FillPicingAndConditionsFNB(String mtdAR, String taxCode){
		EnterText(txtMtdAR,mtdAR);
		EnterText(txtTaxCode,taxCode);
		ClickNext();
	}
	
}