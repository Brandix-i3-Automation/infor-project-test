package bi3.pages.pms170

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid
import java.util.List
import org.openqa.selenium.Keys

class PMS170 extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(id="ActionsBtn")
	WebElement btnAction;

	@FindBy(xpath="//*[contains(text(),'Create MOP')]")
	WebElement btnCreatMop;

	@FindBy(id="WESCHN")
	WebElement txtSch;

	@FindBy(css="#startDiv")
	WebElement btnStart;

	@FindBy(css="#WWTX40")
	WebElement lastSchNo;

	@FindBy(css="div[id*='PMA170BS'][class*='inforDataGrid']")
	WebElement gridPMS170;

	def String getLastJoindScheduleNo() {
		waitToBeDisplayed(lastSchNo)
		return lastSchNo.GetTextBoxvalue();
	}

	def SelectCreatMop() {
		btnAction.click();
		btnCreatMop.click();
		waitForLoadingComplete()

	}

	def void EnterSchedule(String i) {
		txtSch.click();
		txtSch.sendKeys(i);

	}

	def void GoToHomePage() {
		btnStart.click();

	}


   	def List<String> getDataFromRow(int rowIndex){
   		waitForLoadingComplete();		
  		var InforGrid grid = new InforGrid(gridPMS170);	
  		
  		var x=  grid.getDataOfRow(rowIndex)	;
  		
  		return x	
  	}
  	
}
