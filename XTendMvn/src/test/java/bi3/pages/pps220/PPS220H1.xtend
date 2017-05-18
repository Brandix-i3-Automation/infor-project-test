package bi3.pages.pps220

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import bi3.framework.elements.inforelements.InforGrid
import java.util.List
import org.openqa.selenium.By
import bi3.pages.ToolbarPage

class PPS220H1 extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[id*='PPA220HS'][class*='inforDataGrid']")
	WebElement gridPPS220H1;
	
	@FindBy(xpath="//a[text()='Confirm Update']")
 	WebElement linkConfirmUpdate
	
	
	
	def void fillDelyNote(String DelyNote){
		waitForLoadingComplete();

		var InforGrid grid = new InforGrid(gridPPS220H1);
		var List<WebElement> cellElementList =  grid.getCellsFromRow(0);
		
		var cellDelyNote = cellElementList.get(10);
		
		waitToBeClickable(cellDelyNote);
		cellDelyNote.click();
		
		var inputDelyNote = cellDelyNote.findElement(By.id("R1C11"));
		//Thread.sleep(3000);
		inputDelyNote.clearRobustly();
		inputDelyNote.sendKeys(DelyNote);
	
	}
	
	def void fillPackageNo(String Package){
		waitForLoadingComplete();

		var InforGrid grid = new InforGrid(gridPPS220H1);
		var List<WebElement> cellElementList =  grid.getCellsFromRow(0);
		
		var cellPackageNo = cellElementList.get(16);
		
		waitToBeClickable(cellPackageNo);
		cellPackageNo.click();
		
		var inputPackageNo = cellPackageNo.findElement(By.id("R1C17"));
		//Thread.sleep(3000);
		inputPackageNo.clearRobustly();
		inputPackageNo.sendKeys(Package);
	
	}
	
	def void fillSSCCNumber(String SSCC){
		waitForLoadingComplete();

		var InforGrid grid = new InforGrid(gridPPS220H1);
		var List<WebElement> cellElementList =  grid.getCellsFromRow(0);
		
		var cellSSCCNo = cellElementList.get(19);
		
		waitToBeClickable(cellSSCCNo);
		cellSSCCNo.click();
		
		var inputSSCCNo = cellSSCCNo.findElement(By.id("R1C20"));
		//Thread.sleep(3000);
		inputSSCCNo.clearRobustly();
		inputSSCCNo.sendKeys(SSCC);
	
	}
	
	def void clickConfirmUpdate(){
		waitToBeDisplayed(linkConfirmUpdate);
		waitToBeClickable(linkConfirmUpdate);
		linkConfirmUpdate.click();
		
	}
	

	
	
	
	
}