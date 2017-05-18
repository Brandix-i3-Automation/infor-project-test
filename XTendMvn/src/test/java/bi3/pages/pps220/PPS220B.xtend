package bi3.pages.pps220

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import org.testng.Assert
import java.util.List
import com.gargoylesoftware.htmlunit.ElementNotFoundException
import org.openqa.selenium.ElementNotVisibleException
import org.openqa.selenium.By

class PPS220B extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="W1OBKV")
	WebElement txtPOSearch
	
	@FindBy(css="div[id*='PPA220BS'][class*='inforDataGrid']") 
 	WebElement gridElement;
 	
 	@FindBy(xpath="//a[text()='Related']")
 	WebElement linkRelated
 	
 	@FindBy(xpath="//a/span[text()='Confirm Order']")
 	WebElement linkConfirmOrder
 	
 	@FindBy(xpath="//a/span[text()='Goods Receipt']")
 	WebElement linkGoodsRec
 	
 	@FindBy(css = "button[class='inforTabCloseButton'][title='Close']")
 	List<WebElement> btnClose
 	
 	
 	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	@FindBy(xpath="//a/span[text()='Advise Shipment']")
 	WebElement linkAdviseShipment
 	
 	@FindBy(id="W1OBKV")
 	WebElement txtPOno
 	
 	@FindBy(xpath="//a/span[contains(text(),'Transport Notification')]")
	WebElement linkTransportNotification;
 	
 	@FindBy(id="MyCanvasLbl")
 	WebElement linkStart
 	
 	@FindBy(xpath="//a/span[contains(text(),'Purchase Order Transactions')]")
	WebElement linkPurchaseOrderTransactions;
 	
 	
	
	def void searchPONumber(String po){
		waitToBeClickable(txtPOSearch)
		txtPOSearch.click()
		txtPOSearch.clearRobustly()
		txtPOSearch.sendKeys(po)
		txtPOSearch.sendKeys(Keys.ENTER)
		waitForLoadingComplete()
	}
	
	def void confirmOrder(String po){
		var InforGrid grid = new InforGrid(gridElement);
		var row = grid.getCellsFromRow(0)
		System.out.println("row.get(1) : "+row.get(1).text)
		//if(row.get(1).equals(po)){
			row.get(1).rightClick()
			linkRelated.click()
			waitToBeClickable(linkConfirmOrder)
			linkConfirmOrder.click()
			waitForLoadingComplete()
		//}
		//else{
			//Assert.fail("New PO number was not found in PPS220B")
		//}
		
	}
	
	def void goodsReceipt(String po){
		var InforGrid grid = new InforGrid(gridElement);
		var row = grid.getRow(0)
		//if(row.get(1).equals(po)){
			row.rightClick()
			linkRelated.waitToBeDisplayed()
			linkRelated.click()
			waitToBeClickable(linkGoodsRec)
			linkGoodsRec.click()
			waitForLoadingComplete()
		//}
		//else{
			//Assert.fail("New PO number was not found in PPS220B")
		//}
		
	}
	
	def boolean close(){
		try{
			if(btnClose.size==2){
				waitToBeClickable(btnClose.get(1))
				btnClose.get(1).click()
				waitForLoadingComplete()
			}				
			return true;
		}
		catch(ElementNotFoundException e){
			return false;
		}
		catch(ElementNotVisibleException e){
			return false;
		}
	}
	
	//Distribution Order Flow
	
	def void GotoRelatedAndAdviceShipment(){
		waitForLoadingComplete();

		waitToBeClickable(gridFirstLine);		
		rightClick(gridFirstLine);
		
		waitToBeClickable(linkRelated);
		linkRelated.click();
		
		//Thread.sleep(3000);
		waitToBeClickable(linkAdviseShipment);
		linkAdviseShipment.click();
				
		waitForLoadingComplete();
		
	}
	
	def String getLstOfFirstRow(){
		waitForLoadingComplete();
		
		var InforGrid grid = new InforGrid(gridElement);
		var List<WebElement> cellElementList =  grid.getCellsFromRow(0);
		
		var cellLst = cellElementList.get(12);
		var Lst = cellLst.text;
		
		println("Lst value returned");
		return Lst;
	}
	
	def String getHstOfFirstRow(){
		waitForLoadingComplete();
		
		var InforGrid grid = new InforGrid(gridElement);
		var List<WebElement> cellElementList =  grid.getCellsFromRow(0);
		
		var cellHst = cellElementList.get(13);
		var Hst = cellHst.text;
		
		println("Hst value returned");
		return Hst;
	}
	
	def void goToRelatedAndClickTransportNotification(){
		waitForLoadingComplete();
		
		rightClick(gridFirstLine);
		
		waitToBeClickable(linkRelated);
		linkRelated.click();
		
		waitToBeClickable(linkTransportNotification);
		linkTransportNotification.click();
		
		waitForLoadingComplete();
	}
	
	def void goToStartPage(){
		waitForLoadingComplete();
		waitToBeClickable(linkStart);
		linkStart.click();
		
	}
	
	def void goToRelatedAndClickPurchaseOrderTransactions(){
		waitForLoadingComplete();
		
		rightClick(gridFirstLine);
		
		waitToBeClickable(linkRelated);
		linkRelated.click();
		
		waitToBeClickable(linkPurchaseOrderTransactions);
		linkPurchaseOrderTransactions.click();
		
		waitForLoadingComplete();
	}
	
		/**
	 * @param columnIndex Column index starts from 1
	 */
	def List<String> getDetailsFromGrid(int columnIndex, String value){
		var InforGrid grid = new InforGrid(gridElement);
		var List<String> dataList = grid.getDataOfRowContainingTextInColumn(columnIndex,value);		
		return dataList;
	}
	def boolean checkTheLst(String sts)
	{
		waitForLoadingComplete();
		
		var InforGrid grid = new InforGrid(gridElement);
		var List<WebElement> cellElementList =  grid.getCellsFromRow(0);
		
		var cellLst = cellElementList.get(12);
		var Lst = cellLst.text;
		
		println("Lst value returned");
		if(Lst==sts)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	def String voidCheckTheStatus(String PONumber)
	{
		var InforGrid inforGrid = new InforGrid(gridElement);
		var row = inforGrid.getRowContainingTextInColumn(1,PONumber)
		println("WebElement of Row "+row);
		var cells = inforGrid.getCellsFromRow(row);
		println("Cell List  "+cells);
		var status = cells.get(12).text;
		println("Status is " +status);
		
		return status;
		
	}
	
}