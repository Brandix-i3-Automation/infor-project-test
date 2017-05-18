package bi3.pages.pds001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid

class PDS001ConnectMaterialOperation extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WMMSEQ")
	WebElement txtSno
	
	@FindBy(id="WBOPNO")
	WebElement txtOp
	
	@FindBy(id="WWMTPL")
	WebElement txtComp
	
	@FindBy(css="button[class='inforIconButton new']")
	WebElement btnAdd
	
	@FindBy(css="div[class='grid-canvas grid-canvas-top grid-canvas-left']>div[role='row']:last-child>div:nth-child(4)")
	WebElement lastAddedComponentId
	
	@FindBy(id="POS")
	WebElement txtOperationId
	
	@FindBy(css="div[row='0']>div[class='slick-cell l0 r0  uppercase']")
	WebElement firstGridCell
	
	@FindBy(id="BTN_L52T24")
	WebElement btnSelect
	
	@FindBy(css="#tabsList > li.ui-tabs-selected.ui-state-active > button")
	WebElement btnClose
	
	@FindBy(css="div[id*='PDA002US'][class*='inforDataGrid'")
	WebElement inforGridPDS001
	
	@FindBy(xpath="//a[text()='Related']")
	WebElement linkRelated;
	
	@FindBy(xpath= "//div[@class='inforMenu submenu']//a/span[contains(text(),'Options/Line')]")
	WebElement linkOptionsLine;
	
	def void setSno(String sno){
		waitToBeDisplayed(txtSno)
		waitToBeClickable(txtSno)
		txtSno.click();
		txtSno.clearRobustly();
		
		txtSno.sendKeys(sno);
	}
	
	def void clearTextSno(){
		waitToBeDisplayed(txtSno)
		waitToBeClickable(txtSno)
		txtSno.click();
		txtSno.clearRobustly();
	}
	
	def void setOperation(String op){
		waitToBeDisplayed(txtOp)
		waitToBeClickable(txtOp)
		txtOp.click();
		txtOp.clearRobustly();
		
		txtOp.sendKeys(op);
	}
	
	def void setComponent(String comp){
		waitToBeDisplayed(txtComp)
		waitToBeClickable(txtComp)
		txtComp.click();
		txtComp.clearRobustly();
		
		txtComp.sendKeys(comp);
	}
	
	def void selectOperationFromLookUp(String operationId){
		waitToBeDisplayed(txtComp)
		waitToBeClickable(txtComp)
		txtComp.click();
		txtComp.clearRobustly();		
		txtComp.sendKeys(Keys.F4);
		
		waitForLoadingComplete()
		Thread.sleep(2000);
		
		txtOperationId.click();
		txtOperationId.clearRobustly();
		txtOperationId.sendKeys(operationId)
		txtOperationId.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
		Thread.sleep(2000);
		
		if(firstGridCell.text==operationId)
		{
			firstGridCell.click();
			btnSelect.click();
		}
		else
		{
			System.out.println("Operation ID "+operationId+" not found");
		}
		waitForLoadingComplete()
	}
	
//	def void selectOperation(){
//		
//	}
	
	def void clickAddButton(){
		btnAdd.click()
		waitForLoadingComplete()
	}
	
	def String getLastAddedComponentId(){
		waitToBeDisplayed(lastAddedComponentId)
		return lastAddedComponentId.text;
	}
	
	def close() {
		btnClose.click()
		waitForLoadingComplete();
		System.out.println("PDS001 Connect Materials/Operation tab closed")
	}
	
	def void selectOperation(String value)
	{
		waitForLoadingComplete();
		
		var InforGrid inforGridPDS001 = new InforGrid(inforGridPDS001);
		
		var selectedCell= inforGridPDS001.getCell("Comp no/Wrk ctr", value);
		
		selectedCell.rightClick();
		
		linkRelated.click();
		linkOptionsLine.click();
		
		
	}
	
	
}