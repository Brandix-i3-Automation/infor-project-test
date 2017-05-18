package bi3.pages.pds001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import java.util.List
import bi3.framework.elements.inforelements.InforGrid
import bi3.framework.util.ExcelUtil

class PDS001 extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[class='tabTitle'][title]")
	WebElement pageTitle;
	
	@FindBy(id="W1OBKV") 
	List<WebElement> txtItemNumber;
	
	@FindBy(css="input[type='text'][id='W2OBKV']")
	List<WebElement> listTxtSerialNumber
	
	@FindBy(css="input[type='text'][id='W3OBKV']")
	List<WebElement> listTxtFacilityNumber
	
	@FindBy(css="button[class='inforIconButton new']")
	List<WebElement> btnPlus
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	@FindBy(xpath="//a[text()='Related']")
	WebElement linkRelated;
	
	@FindBy(xpath="//div[@class='inforMenu submenu']//a/span[contains(text(),'Material and Operation')]")
	WebElement linkMaterialAndOperation;
	
	@FindBy(xpath="//div[@class='inforMenu submenu']//a/span[contains(text(),'Calculate Product Cost')]")
	WebElement linkCalculateProductCost;
	
	@FindBy(id="Next")
	WebElement btnNext
	
	@FindBy(xpath="//button[@id='dbtnent']")
	WebElement btnGridNext
	
	@FindBy(css="#tabsList > li.ui-tabs-selected.ui-state-active > button")
	WebElement btnClose
	
	@FindBy(css="div[id*='PDA001BS'][class*='inforDataGrid']")
	WebElement gridPDS001
	
	@FindBy(css="XT_0168")
	WebElement btnApply
	
	@FindBy(xpath="//a[text()='Change']")
	WebElement linkChange;
	
	@FindBy(css="div.listHeaderToolTip")
	WebElement tooltip;
	
	@FindBy(xpath="//input[@id='WMMSEQ']")
	WebElement txtseqNum;
	
	@FindBy(xpath ="//input[@id='WBOPNO']")
	WebElement txtopNo;
	
	@FindBy(xpath="//input[@id='WWMTPL']")
	WebElement txtcmpNum;
	
	@FindBy(xpath="//button[@class='inforIconButton new']")
	WebElement btnCrt
	
	@FindBy(id="W1CNQT")
	WebElement txtQty;
	
	@FindBy(xpath="//button[@class='inforIconButton refresh']")
	WebElement btnRefresh;
	
	@FindBy(xpath="//span[text()='Options/Line']/ancestor::a[@href='#14']")
	WebElement linkOptionLine
	
	@FindBy(xpath="//input[@id='WNOTYP']")
	WebElement txtStp;
	
	@FindBy(xpath="//input[@id='WNFTID']")
	WebElement txtSelecId;
	
	@FindBy(css="div[id*='BROWSE_LIST'][class*='inforDataGrid']")
	WebElement gridSize;
	
	@FindBy(id="BTN_L52T24") 
	WebElement btnSelect;
	
	@FindBy(xpath="//input [@id='WNOPTN']")
	WebElement txtSetExctSize;
	
	@FindBy(id="WNOPTN")
	WebElement txtOption;
	
	//@FindBy(css="div[id*='BROWSE_LIST'][class*='inforDataGrid']")
	
	@FindBy(xpath="//div[text()='X016']")
	WebElement gridExctSize;
	
	@FindBy(xpath="//span[text()='Indented BoM']/ancestor::a[@href='#22']")
	WebElement linkIndentendBoM
	
	
	
	def void FillItemNumber(String itemNumber,int tab) {
		waitForLoadingComplete();
		waitToBeDisplayed(txtItemNumber.get(tab))
		waitToBeClickable(txtItemNumber.get(tab))
		txtItemNumber.get(tab).click();
		txtItemNumber.get(tab).clearRobustly();
		
		txtItemNumber.get(tab).sendKeys(itemNumber);		
	}
	
	def void FillSerialNumber(String serialNumber, int tab) {
		waitForLoadingComplete();
		
		waitToBeDisplayed(listTxtSerialNumber.get(tab))
		waitToBeClickable(listTxtSerialNumber.get(tab))
		listTxtSerialNumber.get(tab).click();
		listTxtSerialNumber.get(tab).clearRobustly();
		
		listTxtSerialNumber.get(tab).sendKeys(serialNumber);		
	}
	
	def void FillFacility(String facility,int tab) {
		waitForLoadingComplete();
		
		waitToBeDisplayed(listTxtFacilityNumber.get(tab))
		waitToBeClickable(listTxtFacilityNumber.get(tab))
		listTxtFacilityNumber.get(tab).click();
		listTxtFacilityNumber.get(tab).clearRobustly();
		
		listTxtFacilityNumber.get(tab).sendKeys(facility);		
	}
	
	
	def String getpageTitle(){
		waitForLoadingComplete()
		return pageTitle.text;
	}
	
	def void CreateProductStructure(int tab) {
		btnPlus.get(tab).click()
	}
	
	def SearchByItemNumber(String itemNumber) {
		waitForLoadingComplete();
		txtItemNumber.get(0).click();
		txtItemNumber.get(0).clearRobustly();
		
		txtItemNumber.get(0).sendKeys(itemNumber);
		txtItemNumber.get(0).sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		
		tooltip.waitToBeHidden();		
		
	}
	
	def goToMaterialAndOperations(String itemNumber){
		waitForLoadingComplete();
		/* 
		var InforGrid grid = new InforGrid(gridPDS001);
		var WebElement cellElement = grid.getCell(0,itemNumber);
		cellElement.sendKeys(Keys.chord(Keys.CONTROL, "11"));
		
		waitForLoadingComplete();
		*/ 
		rightClick(gridFirstLine);
		
		waitToBeClickable(linkRelated);
		linkRelated.click();
		
		waitToBeClickable(linkMaterialAndOperation);
		linkMaterialAndOperation.click();		
		waitForLoadingComplete();		
	}
	
	def goToCalculateProductCost(){
		waitForLoadingComplete();
		/* 
		var InforGrid grid = new InforGrid(gridPDS001);
		var WebElement cellElement = grid.getCell(0,itemNumber);
		cellElement.sendKeys(Keys.chord(Keys.CONTROL, "11"));
		
		waitForLoadingComplete();
		*/ 
		//rightClick(gridFirstLine);
		
		rightClick(gridFirstLine, true , "Calculate Product Cost")
		
		//waitToBeClickable(linkRelated);
		//linkRelated.click();
		
		//waitToBeClickable(linkCalculateProductCost);
		//linkCalculateProductCost.click();		
		//waitForLoadingComplete();		
	}
	
	def goToDisplayProductCosting(){
		waitForLoadingComplete();
		/* 
		var InforGrid grid = new InforGrid(gridPDS001);
		var WebElement cellElement = grid.getCell(0,itemNumber);
		cellElement.sendKeys(Keys.chord(Keys.CONTROL, "11"));
		
		waitForLoadingComplete();
		*/ 
		//rightClick(gridFirstLine);
		
		rightClick(gridFirstLine, true , "Display Product Costing")
		
		//waitToBeClickable(linkRelated);
		//linkRelated.click();
		
		//waitToBeClickable(linkCalculateProductCost);
		//linkCalculateProductCost.click();		
		//waitForLoadingComplete();		
		}
		
	def void clickNext(){		
		btnNext.click()
		waitForLoadingComplete()
	}
	
	def void createButton(){
		btnCrt.click
		waitForLoadingComplete()
	}
	
	def void clickGridNext(){		
		btnGridNext.click()
		waitForLoadingComplete()
	}
	
	def close() {
		btnClose.click()
		System.out.println("PDS001 tab closed")
	}
	
	def void clickApply(){
		btnApply.clickWhenReady();
		waitForLoadingComplete();
	}
	
	def void EditItem(String itemNumber) {
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(gridPDS001);
		var List<WebElement> cell = grid.getCellsFromRow(0);
//		
//		cell.rightClick();
//		linkChange.waitToBeClickable();
//		linkChange.click();
//			
		cell.get(2).click();	
		cell.get(2).sendKeys(Keys.CONTROL + "2");
		waitForLoadingComplete();					
	}
	
	def List<String> getDataOfItem(String itemNumber){
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(gridPDS001);
		var dataList = grid.getDataOfRowContainingTextInColumn(1, itemNumber);
		return dataList;		
	}
	
	def void addOneMoreButtton(String sn, String opno, String cmpNo, String qty){
		waitForLoadingComplete();
		txtseqNum.clear
		txtseqNum.sendKeys(sn)
		txtopNo.clear
		txtopNo.sendKeys(opno)
		txtcmpNum.clear
		txtcmpNum.sendKeys(cmpNo)
		Thread.sleep(1000)
		btnCrt.click
		txtQty.clear
		txtQty.sendKeys(qty)
		btnNext.click
		waitForLoadingComplete();
		btnNext.click
		waitForLoadingComplete();
		btnRefresh.click
		waitForLoadingComplete();
		
	}
	
	def goToOptionLine(){
		
		rightClick(gridFirstLine);
		
		waitToBeClickable(linkRelated);
		linkRelated.click();
		waitForLoadingComplete();	
		waitToBeClickable(linkOptionLine);
		linkOptionLine.click();		
		waitForLoadingComplete();	
		
	}
	
	/*def addButtonSize(String stp, String btnSize){
		
		txtStp.sendKeys(stp)
		txtSelecId.sendKeys(Keys.F4)
		waitToBeClickable(gridSize);
		gridSize.click();	
		btnSelect.click
		txtSetExctSize.sendKeys(Keys.F4)
			
	}*/
	
	def void selectItemFromM3Browse(String stp, int cellNum, String btnSiz,int cellNum2, String exctSize){
		waitForLoadingComplete();	
		//div[id*='MMA001BS'][class*='inforDataGrid']
		txtStp.sendKeys(stp)
		txtSelecId.sendKeys(Keys.F4)
		
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(gridSize)
		System.out.println("Test");
		grid.getCell(cellNum,btnSiz).click();
		waitForLoadingComplete();	
		btnSelect.click
		txtOption.sendKeys(Keys.F4)
		//var InforGrid grid1 = new InforGrid(gridExctSize)
		////div[text()='X016']
		waitForLoadingComplete();
		gridExctSize.click
		btnSelect.click
		waitForLoadingComplete();	
	}
	
	def void creationProcess() {
		waitForLoadingComplete();
		btnCrt.click
		waitForLoadingComplete();
		btnNext.click
		waitForLoadingComplete();
		btnNext.click
		waitForLoadingComplete();
		btnClose.click
		waitForLoadingComplete();
		btnClose.click
	}
	
	def void intendedBom(){
		rightClick(gridFirstLine);
		waitToBeClickable(linkRelated);
		linkRelated.click();
		waitForLoadingComplete();
		waitToBeClickable(linkIndentendBoM);
		linkIndentendBoM.click	
		

		
	}
	
}