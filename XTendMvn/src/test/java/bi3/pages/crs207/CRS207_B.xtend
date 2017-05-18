package bi3.pages.crs207

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List
import bi3.framework.elements.inforelements.InforGrid
import org.openqa.selenium.Keys
import org.openqa.selenium.By
import java.util.concurrent.TimeUnit

class CRS207_B extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div.slick-viewport.slick-viewport-top.slick-viewport-left div.edit-cell") 
	List<WebElement> listTxtDescription;
	
	@FindBy(id="Next") 
	WebElement btnNext;
	
	@FindBy(css="div[id*='CRA207BS'][class*='inforDataGrid']") 
	WebElement gridElement;
	
	@FindBy(id="dbtnok")
	WebElement btnOk;
	
	def void EnterDescriptionGrid(String qty){
		
		/*for(WebElement element : listTxtDescription){
			element.sendKeys(qty);
			waitForLoadingComplete();
		}*/
		var InforGrid grid= new InforGrid(gridElement);
		val row=grid.getRowContainingTextInColumn(1,"Black");
		System.out.println(row);
		val cells=grid.getCellsFromRow(row);
		System.out.println(cells.size);
		
				System.out.println(cells.get(1).text);
		
		cells.get(1).click();
		cells.get(1).findElement(By.cssSelector("input")).sendKeys(qty);

	}
	
	def void clickNext(){
		waitToBeClickable(btnNext)
		btnNext.click();
		waitForLoadingComplete();
	}
	
//	@FindBy(css="div[id*='PMA100BS'][class*='inforDataGrid']") 
//	WebElement gridElement;
	
	def void searchBySchedule(){
		var InforGrid grid= new InforGrid(gridElement);
		grid.getCell("Sched no","131300").rightClick();
		
		grid.getCell(0,"131300").rightClick();
		
		grid.setValueToColumnSearchField("","");
		
	}
	
	//CO creation-fill matrix
	def void fillMatrix(String qty){
		waitForLoadingComplete();
		var InforGrid grid= new InforGrid(gridElement);
		
		//fill qty for color Black, size 10
		val rowBlack=grid.getRowContainingTextInColumn(1,"Black");
		val cellsBlack=grid.getCellsFromRow(rowBlack);		
		cellsBlack.get(3).click();
		waitForLoadingComplete();
		cellsBlack.get(3).findElement(By.cssSelector("input")).sendKeys(qty);
		
//		//fill qty for color Green, size 12
//		val rowGreen=grid.getRowContainingTextInColumn(1,"Green");
//		val cellsGreen=grid.getCellsFromRow(rowGreen);		
//		cellsGreen.get(4).click();
//		cellsGreen.get(4).findElement(By.cssSelector("input")).sendKeys(qty);
//		
//		//fill qty for color Red, size 12
//		val rowRed=grid.getRowContainingTextInColumn(1,"Red");
//		val cellsRed=grid.getCellsFromRow(rowRed);		
//		cellsRed.get(4).click();
//		cellsRed.get(4).findElement(By.cssSelector("input")).sendKeys(qty);
				
	}
	
	def void handleWarning() {
		waitForLoadingComplete();
		btnOk.click();
	}
	
	def void handleAbnormalException() {
		try {
			waitForLoadingComplete();
        	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			while (btnOk.isDisplayed()) {
				btnOk.clickWhenReady();
				waitForLoadingComplete();
			}
		} catch (Exception e) {
		}
		finally{
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);			
		}
	}
	
	
}