package bi3.pages.ois150

import org.openqa.selenium.WebDriver
import bi3.pages.BasePage
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import java.util.List

class OIS150_b1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	//Elements(Page Objects)
	@FindBy(id="W1OBKV")
	WebElement txtFac
	
	@FindBy(id="W2OBKV")
	WebElement txtCONumber
	
	
	@FindBy(css="div[id*='OIA150BS'][class*='inforDataGrid']") 
	WebElement gridElement;
	
	
	@FindBy(linkText = "Related")
    WebElement linkRelated;
	
	//@FindBy(css="div[class='inforMenu submenu']>ul >li:nth-child(12)")
		//WebElement linkSet;
		
	@FindBy(xpath="//div[@class='inforMenu submenu']//a/span[contains(text(),'Sel to invoice')]")
	WebElement linkSet;
	

	
	@FindBy(id="ActionsBtn")
	WebElement BtnAction	
	
	@FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Launch invoice')]")
    WebElement linkLaunchInvoice;
	
	//@FindBy(css="ul[id*='host_0_ActionsMenumb']>li:nth-child(7)") 
	//WebElement linkLaunchInvoice;
	
	//@FindBy(linkText="Launch invoice") 
	//WebElement linkLaunchInvoice;
	
	
	
//	def void searchCONumber(String CONumber)
//	{
//		waitForLoadingComplete();
//		txtCONumber.click();
//		txtCONumber.clearRobustly();
//		
//		txtCONumber.waitToBeDisplayed();
//		txtCONumber.sendKeys(CONumber);
//		txtCONumber.sendKeys(Keys.ENTER);
//		waitForLoadingComplete();
//		
//	}
	
	
	def void EnterCoNumbers(String CoNumber){
		
		//txtFac.sendKeys("A01");
		waitToBeDisplayed(txtCONumber)
		txtCONumber.sendKeys(CoNumber);
		txtCONumber.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		
	}
	

	def void EnterFacNumber(){
	txtFac.sendKeys("A01");
	
}
	
	def void ClickSelToInvoice(){
//		txtFac.sendKeys("A01");
//		waitToBeDisplayed(txtCoNo)
//		txtCoNo.sendKeys("0011000036");
//		txtCoNo.sendKeys(Keys.ENTER);
//		waitForLoadingComplete();
		var InforGrid grid= new InforGrid(gridElement);
		grid.getRow(0).rightClick();
	//	row.rightClick();
		//grid.getRow(0).sendKeys(Keys.CONTROL+"24");
		linkRelated.click();		
		linkSet.click();
		
		
		//BtnAction.click();
		
	//	linkLaunchInvoice.click();
		
	}
	
	
	
	def void LaunchInvoice(){
		
		waitToBeDisplayed(linkLaunchInvoice);
		linkLaunchInvoice.click();
	}
	
}