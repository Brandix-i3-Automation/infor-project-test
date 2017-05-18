package bi3.pages.ois300

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys
import bi3.pages.BasePage
import java.util.List
import bi3.framework.elements.inforelements.InforGrid

class OIS300MaterialPlan extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(xpath="//a/span[contains(text(),'Change')]")
	WebElement linkChange;
	
	@FindBy(css="div[id*='MMA080B1'][class*='inforDataGrid'")
	WebElement inforGridOIS300;
	//MMA080B1
	@FindBy(id="W1ORCA")
	WebElement txtOct;
	
	@FindBy(css="button[class='inforIconButton refresh']")
	WebElement btnRefresh;
	
	@FindBy(id="ActionsBtn")
	WebElement btnAction;
	
	@FindBy(css="ul[class='inforContextMenu inforMenuOptions'] >li")
	List <WebElement> listActionbtn;
	
	def String getTheOrderNumber(String stat)
	{
		var InforGrid inforGridOIS300 = new InforGrid(inforGridOIS300);
		
		val data = inforGridOIS300.getDataOfRowContainingTextInColumn(6,stat);
		System.out.println(data);
		val orderNo = data.get(8).toString;
		System.out.println(orderNo);
		return orderNo;		
	}
	
	def void changeMaterialPlan(String orderNo)
	{
		var InforGrid inforGridOIS300 = new InforGrid(inforGridOIS300);
		
		waitForLoadingComplete();
		val  element  = inforGridOIS300.getRowContainingTextInColumn(9,orderNo);
		System.out.println(element);
		element.rightClick();
		linkChange.click();
		waitForLoadingComplete();
		
	
	}
	
	def void refreshTheGrid()
	{
		waitForLoadingComplete();
		txtOct.clearRobustly();
		btnRefresh.click();
		waitForLoadingComplete();
	}
	
	def void calculateMRP()
	{
		waitForLoadingComplete();
		selectFromDropdown(btnAction, listActionbtn, "Calculate MRP")
		Thread.sleep(10000);
		btnRefresh.click();
		waitForLoadingComplete();
	}
	
	def boolean isGridEmpty()
	{
		waitForLoadingComplete();
		var InforGrid inforGridOIS300 = new InforGrid(inforGridOIS300);
		txtOct.sendKeys("250")
		txtOct.sendKeys(Keys.ENTER)
		waitForLoadingComplete();
				
		//val data = inforGridOIS300.getDataOfRowContainingTextInColumn(6,"250");
		System.out.println(inforGridOIS300);
		if(inforGridOIS300.rowCount ==0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	
	}
	
	def void searchForStat(String stat){
		txtOct.waitToBeClickable()
		txtOct.click()
		txtOct.clearRobustly()	
		txtOct.sendKeys(stat)
		txtOct.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
	}
}
 