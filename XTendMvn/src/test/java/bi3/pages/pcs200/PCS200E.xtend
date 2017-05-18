package bi3.pages.pcs200

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import java.util.List
import bi3.framework.elements.inforelements.InforGrid

class PCS200E extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
		
	@FindBy(id="WWPCTP") 
	WebElement txtCostingType;
	
	@FindBy(id="WWPRTC-shdo") 
	WebElement cmbPrtCosting;
	
	@FindBy(css="ul[id='dropdown-list'] li")
	List<WebElement> lstPrtCosting
	
	@FindBy(id="WWCOSN") 
	WebElement txtCostingName;
	
	@FindBy(id="WWALVL-shdo") 
	WebElement cmbAllLevels;
	
	@FindBy(css="ul[id='dropdown-list'] li")
	List<WebElement> lstAllLevels
	
	@FindBy(id="WWCOUP-shdo") 
	WebElement cmbCalcpurchdist;
	
	@FindBy(css="ul[id='dropdown-list'] li")
	List<WebElement> lstCalcpurchdist
	
	@FindBy(id="WWPAVR") 
	WebElement txtView;

	
	@FindBy(id="Next")
	WebElement btnNext;
	
	//Page Actions
	
	def void clickNext(){		
		btnNext.click()
		waitForLoadingComplete()
	}
	

	def void SelectPrtCosting(String value) {
		waitForLoadingComplete();
		selectFromDropdown(cmbPrtCosting, lstPrtCosting, value);
	}

	def void SelectAllLevels(String value) {
		waitForLoadingComplete();
		selectFromDropdown(cmbAllLevels, lstAllLevels, value);
	}

	def void SelectCalspurchdist(String value) {
		waitForLoadingComplete();
		selectFromDropdown(cmbCalcpurchdist, lstCalcpurchdist, value);
	}
	
	def SetCostingType(String CostingType) {
		waitForLoadingComplete();
		txtCostingType.click();
		txtCostingType.clearRobustly();
		
		txtCostingType.sendKeys(CostingType);
		//txtCostingType.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	
	}
	def SetCostingName(String CostingName) {
		waitForLoadingComplete();
		txtCostingName.click();
		txtCostingName.clearRobustly();
		
		txtCostingName.sendKeys(CostingName);
		//txtCostingName.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		
		}
		
		
	def SetView(String View) {
		waitForLoadingComplete();
		txtView.click();
		txtView.clearRobustly();
		
		txtView.sendKeys(View);
		//txtView.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		
		}
	}