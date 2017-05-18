package bi3.pages.pms170

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import java.util.List
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid

class PMS170B extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(css="#WWQTTP-shdo")
	WebElement cmdSortingOrder;

	@FindBy(css="#dropdown-list li")
	List<WebElement> listSortingOrder;

	@FindBy(xpath="//*[contains(text(),'Sched no')]")
	WebElement lblSchNo;

	@FindBy(css="#W3OBKV")
	WebElement txtMainProduct;

	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;

	@FindBy(xpath="//a[contains(text(),'Related')]")
	WebElement linkRelated;

	@FindBy(xpath="//a/span[contains(text(),'Joint Scheduling')]")
	WebElement linkJointScheduling;

	@FindBy(id="Next")
	WebElement btnNext;

	@FindBy(xpath=".//*[@fkey='F5']")
	WebElement btnRefresh;

	@FindBy(xpath="//a/span[contains(text(),'Release')]")
	WebElement linkRelease;

	@FindBy(css="#W2OBKV")
	WebElement txtSchNo;
	
	@FindBy(id="W1RESP")
	WebElement respLookUpText
	
	@FindBy(id="W1OBKV")
	WebElement txtSearchResp

	@FindBy(css="div[id*='PMA170BS'][class*='inforDataGrid']") 
 	WebElement gridElement;
 	
 	@FindBy(id = "W1OBKV")
	WebElement txtPlnOrdNo
 
	def void SelectSortingOrder(String value) {
		//Thread.sleep(1000);
		waitForLoadingComplete();
		selectFromDropdown(cmdSortingOrder, listSortingOrder, value);
		waitForAnyText(lblSchNo, 100);
	}

	def void EnterMainProduct(String mainProduct) {
		waitForLoadingComplete();
		txtMainProduct.clearRobustly();
		txtMainProduct.sendKeys(mainProduct);
		waitToBeDisplayed(txtMainProduct);
		txtMainProduct.sendKeys(Keys.ENTER);
	}

	def void JointSchedulling() {
		waitForLoadingComplete();
		rightClick(gridFirstLine);
		waitToBeClickable(linkRelated);
		linkRelated.click();
		linkJointScheduling.click();
		waitForLoadingComplete();
	}

	def void clickNext() {
        
		btnNext.click()
		waitForLoadingComplete()
	}

	def RefreshPage() {
		btnRefresh.click();
		waitForLoadingComplete()
	}

	def void ReleaseItem() {
		waitForLoadingComplete();
		rightClick(gridFirstLine);
		waitToBeClickable(linkRelated);
		linkRelated.click();
		linkRelease.click();
		waitForLoadingComplete();
	}

	def SearchScheduleNo(String schNo) {
		waitForLoadingComplete();
		txtSchNo.click();
		txtSchNo.sendKeys(schNo);
		txtSchNo.sendKeys(Keys.ENTER);

	}

	def EnterScheduleNo(String scheduleNo) {
		txtSchNo.click();
		txtSchNo.sendKeys(scheduleNo);
		txtSchNo.sendKeys(Keys.ENTER);

	}
	
	def String getScheduleNumberOf(String newItemNumber){
		var InforGrid grid= new InforGrid(gridElement);
		var cells = grid.getCellsFromRow(0)
		if(cells.get(2).text.equals(newItemNumber)){
			System.out.println("Last schedule number :"+ cells.get(1).text )
			return cells.get(1).text
		}
		else{
			System.out.println("Entered item number was not found in PMS170 grid")
			return ""
		}
	}
	
	def void clearResponsible(){
 		waitToBeClickable(respLookUpText)
 		respLookUpText.click()
 		respLookUpText.clearRobustly()
 	}
 	
 	def void enterRespSearchKey(String resp)
 	{
 		waitToBeClickable(txtSearchResp)
 		txtSearchResp.click()
 		txtSearchResp.clearRobustly()
 		txtSearchResp.sendKeys(resp)
 		txtSearchResp.sendKeys(Keys.ENTER)
 		waitForLoadingComplete()
 	}
 	
	def void SearchWithPlanOrderNo(String PlnOrd){
		txtPlnOrdNo.EnterText(PlnOrd)
		txtPlnOrdNo.sendKeys(Keys.ENTER)
	}
	
	def String GetStsOfPlnOrd(String plnOrd){
		var InforGrid grid= new InforGrid(gridElement)
		var data = grid.getDataOfRowContainingTextInColumn(1,plnOrd.replaceFirst("^0+(?!$)", ""))
		return data.get(7)
	}
}
