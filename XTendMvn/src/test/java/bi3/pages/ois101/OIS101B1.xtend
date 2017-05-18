package bi3.pages.ois101

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import java.util.List
import java.util.ArrayList
import org.openqa.selenium.StaleElementReferenceException

class OIS101B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	//Elements(Page Objects)
	@FindBy(id="WWBITNO")
	WebElement txtItem
	
	@FindBy(id="WBORQA")
	WebElement txtQuantity
	
	@FindBy(id="WAD74C0")
	WebElement addBtn
	
	@FindBy(css="#WBITNOContainer>button")
	WebElement itemSelectArrow
	
	@FindBy(css="#WBITNO")
	WebElement itemName
	
    @FindBy(css="#WBSAPR")
	WebElement itemSalesPrice
	
	@FindBy(id="POS")
	WebElement txtSearchBoxPOS
	
	@FindBy(id="BTN_L52T24")
	WebElement btnSelect
		
	@FindBy(css="div[id*='BROWSE_LIST'] div.slick-cell.l0.r0")
	WebElement gridFirstLine
	
    @FindBy(css="#tabsList > li.ui-tabs-selected.ui-state-active > button")
	WebElement btnClose
	
	
	@FindBy(id="OAORNO")
	WebElement txtCONumber;
	
	@FindBy(css = "#OAEXCD")
	WebElement txtServiceNumber;
	
	@FindBy(css = "#OAPYCD")
	WebElement txtPaymentMtd;
	
	@FindBy(css = "#OATAXC")
	WebElement taxCode;
	
    @FindBy(css = "#OAORNO")
	WebElement textCoCode;
	
	//Total_table
	@FindBy(css="div[id*='pRow9'][class*='lawsonModuleRow']")
	WebElement COtable
	
	@FindBy(id = "WAD74C0")
	WebElement btnAdd
	
	//Page Actions
	//ElementId = "Y3171-Y01-010"
//	def boolean checkItemPresence(String ElementId){
//		waitForLoadingComplete();
//		var InforGrid grid = new InforGrid(COtable);
////		var allData = new ArrayList <String>();
////		allData = grid.getDataOfColumn(3).toString;
//		if(grid.getDataOfColumn(3).contains(ElementId)){
//			System.out.println("Item Exists")
//			return true;
//		}
//		else{
//			System.out.println("Item Doesn't Exists")
//			return false;
//		}
	def List<String> checkItemPresence(){
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(COtable);
//		var allData = new ArrayList <String>();
//		allData = grid.getDataOfColumn(3).toString;
		System.out.println(grid.getDataOfColumn(2));
		return grid.getDataOfColumn(2);
		

	}
	
	def void fillOrderLine(String Item,String Quantity){
		//waitToBeClickable(itemSelectArrow)
		//txtItem.sendKeys(Item)
//		waitToBeClickable(itemSelectArrow)
//		itemSelectArrow.click()
//		waitToBeClickable(txtSearchBoxPOS)
//		waitForLoadingComplete()
//		txtSearchBoxPOS.click();
//		txtSearchBoxPOS.clearRobustly();
//		txtSearchBoxPOS.sendKeys(Item)
//		txtSearchBoxPOS.sendKeys(Keys.ENTER)
//		waitForLoadingComplete()
//		//try-catch to re-try inserting if failed 
//		try{
//			gridFirstLine.click()
//		}
//		catch(StaleElementReferenceException ex){
//			waitForLoadingComplete()
//			gridFirstLine.click()
//		}
//		btnSelect.click()
//		waitForLoadingComplete()
//				
//		waitToBeClickable(txtQuantity)
//		waitToBeDisplayed(txtQuantity)	
//		txtQuantity.sendKeys(Quantity)

//		txtServiceNumber.click();
//		txtServiceNumber.sendKeys("BEZ");		
//		txtServiceNumber.sendKeys(Keys.ENTER);
		
	
		txtPaymentMtd.click();
		txtPaymentMtd.sendKeys("BEZ");		
		//txtPaymentMtd.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		taxCode.click();
		taxCode.sendKeys("CRE");		
		//taxCode.sendKeys(Keys.ENTER);
		Thread.sleep(1000);


		
	}
	
	def String getTheCONumber()
	{
		waitForLoadingComplete();
		val CONumber = txtCONumber.GetTextBoxvalue();
		System.out.println(CONumber);
		return CONumber;
	}
	
	def void closeN1(){
		
		btnClose.click();
		System.out.println("PDS001 tab closed")
		
	}
	
	def void CustomerOrderOPenLine(String item,String qty, String salesPrice){
		
		itemName.click();
		itemName.sendKeys(item);	
		
		txtQuantity.click();
		txtQuantity.sendKeys(qty);
		
		itemSalesPrice.click();
		itemSalesPrice.sendKeys(salesPrice);
		
	}
	
	def String GetCONumber(){
		 
		var co =  textCoCode.GetTextBoxvalue();
		return co;
	}
	
	def void ClickAdd(){
		btnAdd.waitToBeClickable()
		btnAdd.click()
		waitForLoadingComplete()
	}
}