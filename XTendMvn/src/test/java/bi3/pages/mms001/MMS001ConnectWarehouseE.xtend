package bi3.pages.mms001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import java.util.List

class MMS001ConnectWarehouseE extends BasePage {
	
	new(WebDriver driver) { // Constructor
		super(driver)
	}
	
	@FindBy(id="LBL_L1T6")
	WebElement pageSubTitle;
	
	@FindBy(id="MBMSCH-shdo")
	WebElement btnMastrScheduled
	
	@FindBy(id="list-option2")
	WebElement listItemMastrSchedule
	
	@FindBy(id="list-option0")
	WebElement listItemMastrScheduleCO
	
	@FindBy(css="ul#dropdown-list li")
	List<WebElement> listItemMastrSchedule1
	
	@FindBy(css="div[id='MBPLCDContainer']>button")
	WebElement btnPlanningPolicyOpen
	
	@FindBy(css="#POS")
	WebElement txtPolicy
	
	@FindBy(css=".slick-cell.l0.r0.uppercase")
	WebElement firstGridCell
	
	@FindBy(id="BTN_L52T24")
	WebElement btnPPSelect
	
	@FindBy(css="div[id='MBSCPOContainer']>button")
	WebElement btnSupplyPolicyOpen
	
	@FindBy(id="MBCONC")
	WebElement checkContNetChange;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	def String getPageSubTitle(){
		waitForLoadingComplete()
		return pageSubTitle.text;
	}
	
	//Set the mastr schedule as 2-conf mastr sched
	def void setMastrSchedule(String mastrScheduled){
		//btnMastrScheduled.click()
		//listItemMastrSchedule.click()	
		waitForLoadingComplete();
		selectFromDropdown(btnMastrScheduled, listItemMastrSchedule1, mastrScheduled);	
	}
	//Set the mstr schedule as 0-Not mstr scdl it
	def void setMastrScheduleCO()
	{
		btnMastrScheduled.click();
		listItemMastrScheduleCO.click();
	}
	
	def void setPlanningPolicy(String planningPolicy){
		
		btnPlanningPolicyOpen.click();
		waitForLoadingComplete()
		txtPolicy.waitToBeClickable();
		txtPolicy.clickWhenReady();
		txtPolicy.clearRobustly();
		txtPolicy.sendKeys(planningPolicy)
		txtPolicy.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		Thread.sleep(2000);
		System.out.println("First cell content : "+firstGridCell.text)
		
		if(firstGridCell.text==planningPolicy)
		{
			firstGridCell.click();
			btnPPSelect.click();
		}
		else
		{
			System.out.println("Planning Policy "+planningPolicy+" not found");
		}
		waitForLoadingComplete()
	}
	
	def void setSupplyPolicy(String supplyPolicy){
		
		btnSupplyPolicyOpen.click();
		waitForLoadingComplete()
		txtPolicy.waitToBeClickable();
		txtPolicy.clickWhenReady();
		txtPolicy.clearRobustly();
		txtPolicy.sendKeys(supplyPolicy)
		txtPolicy.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		Thread.sleep(2000);
		
		if(firstGridCell.text==supplyPolicy)
		{
			firstGridCell.click();
			btnPPSelect.click();
		}
		else
		{
			System.out.println("Supply Policy "+supplyPolicy+" not found");
		}
		waitForLoadingComplete()
	}
	
	def void selectContNetChange(){
		
		var checked = checkContNetChange.getAttribute("aria-checked")
		
		if(checked=="false")
		{
			checkContNetChange.click();	
		}			
	}
	
	def void clickNext()
	{
		waitForLoadingComplete()
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void selectItemMastrSchedule(String value)
	{
		waitForLoadingComplete();
		selectFromDropdown(btnMastrScheduled, listItemMastrSchedule1, value);
			
	}
	
}