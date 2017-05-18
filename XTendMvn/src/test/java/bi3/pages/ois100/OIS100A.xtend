package bi3.pages.ois100

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import org.openqa.selenium.StaleElementReferenceException

class OIS100A extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}	
	
	@FindBy(css="#OACUNOContainer > button")
	WebElement btnCustomer;
	
	@FindBy(css="#OAORTPContainer > button")
	WebElement btnCOtype;
	
	@FindBy(css="input[hlp='OIS10004']")
	WebElement txtReqDeliveryDate;

	@FindBy(css="div[class='slick-headerrow-column l0 r0']>input")
	WebElement gridSearchKey;
	
	@FindBy(css=".slick-cell.l0.r0.uppercase")
	WebElement firstGridCell
	
	@FindBy(id="BTN_L52T24")
	WebElement btnSelect
	
	@FindBy(id="dbtnok")
	WebElement btnOK_PopUp
	
	@FindBy(id="dbtnok")
	WebElement btnOk;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	@FindBy(css="div[id*='BROWSE_LIST'][class*='inforDataGrid']")
	WebElement gridOIS100A;
	
	@FindBy(css="#OAORNO")
	WebElement txtCOno;
	
	
	@FindBy(css="#OACUNO")
	WebElement txtCustomer;
	
	
	def String getCONumber(){
		waitToBeDisplayed(txtCOno)
		return txtCOno.text
	}
	def void clickNext()
	{
		btnNext.click()
		waitForLoadingComplete()
	}

	def clearCOno(){
		waitForLoadingComplete();
		txtCOno.clearRobustly();
	}
	
	def clearCustomer(){
		waitForLoadingComplete();
		txtCustomer.clearRobustly();
		waitForLoadingComplete();
	}

	def fillCustomer(String customer){
		btnCustomer.click();
		waitForLoadingComplete();

		waitToBeDisplayed(gridSearchKey);
		waitToBeClickable(gridSearchKey);
		try{
			gridSearchKey.click();
		}
		catch(StaleElementReferenceException ex){
			Thread.sleep(2000);
			waitForLoadingComplete();

			waitToBeDisplayed(gridSearchKey);
			waitToBeClickable(gridSearchKey);
			gridSearchKey.click();
		}
		
		gridSearchKey.clearRobustly();
		
		try{
			gridSearchKey.sendKeys(customer);
		}
		catch(StaleElementReferenceException ex){
			Thread.sleep(2000);
			waitForLoadingComplete();

			gridSearchKey.clearRobustly();
			gridSearchKey.sendKeys(customer);
		}
		
		gridSearchKey.sendKeys(Keys.ENTER);
		
		waitForLoadingComplete();		
		Thread.sleep(2000);
		
		var InforGrid inforGrid = new InforGrid(gridOIS100A);
		var WebElement matchingCell = inforGrid.getCell("Customer",customer);
		if(matchingCell.isDisplayed()){
			matchingCell.click();
			btnSelect.click();		
		}
		else{
			System.out.println("Customer "+customer+" not found.")
		}		
		waitForLoadingComplete();				
	}
	
	def fillCOType(String COType){
		btnCOtype.click();
		waitForLoadingComplete();
		
		waitToBeDisplayed(gridSearchKey);
		waitToBeClickable(gridSearchKey)
		try{
			gridSearchKey.click();
		}
		catch(StaleElementReferenceException ex){
			Thread.sleep(2000);
			waitForLoadingComplete();

			waitToBeDisplayed(gridSearchKey);
			waitToBeClickable(gridSearchKey);
			gridSearchKey.click();
		}
		gridSearchKey.clearRobustly();
		try{
			gridSearchKey.sendKeys(COType);
		}
		catch(StaleElementReferenceException ex){
			Thread.sleep(2000);
			waitForLoadingComplete();

			gridSearchKey.clearRobustly();
			gridSearchKey.sendKeys(COType);
		}
		gridSearchKey.sendKeys(Keys.ENTER);
		
		waitForLoadingComplete();
		Thread.sleep(2000);

		var InforGrid inforGrid = new InforGrid(gridOIS100A);
		var WebElement matchingCell=inforGrid.getCell("Otp",COType);
		if(matchingCell.isDisplayed()){
			matchingCell.click();
			btnSelect.click();
		
		}
		else{
			System.out.println("CO Type "+COType+" not found.")
		}
		waitForLoadingComplete();
				
	}
	
	def void fillReqDeliveryDate(String Date){
		txtReqDeliveryDate.clearRobustly();
		txtReqDeliveryDate.sendKeys(Date);
	}
	}
	
	