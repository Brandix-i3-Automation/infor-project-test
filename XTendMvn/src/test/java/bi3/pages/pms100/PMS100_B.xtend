package bi3.pages.pms100

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import java.util.List
import java.util.ArrayList
import org.openqa.selenium.interactions.Actions
import java.awt.Robot
import java.awt.event.KeyEvent
import java.util.concurrent.TimeUnit

class PMS100_B extends BasePage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(id="W1OBKV")
	WebElement txtScheduleNo;

	@FindBy(css="div[id*='PMA100BS'][class*='inforDataGrid']")
	WebElement gridElement;

	@FindBy(xpath="//a[text()='Related']")
	WebElement linkRelated;

	@FindBy(xpath="//a/span[contains(text(),'Delivery Toolbox')]")
	WebElement linkDeliveryToolbox;

	@FindBy(css="#W2OBKV")
	WebElement txtProduct;

	@FindBy(css="#W3OBKV")
	WebElement txtMoNo;

	@FindBy(css="div[id*='PMA100BS'][class*='inforDataGrid']")
	WebElement gridPMS100;

	@FindBy(css="div[row='0'] > div")
	WebElement firstGridCell;

	@FindBy(xpath="//a/span[contains(text(),'Delivery Toolbox')]")
	WebElement linkDeliveyToolBox;
	
	@FindBy(css="#WWQTTP-shdo")
	WebElement cmdSortingOrder;

	@FindBy(css="#dropdown-list li")
	List<WebElement> listSortingOrder;
	
	@FindBy(xpath="//a/span[contains(text(),'Check Component Availability')]")
	WebElement linkCheckCompAvailability;

	def void EnterSchNo(String ScNo) {

		txtScheduleNo.clearRobustly();
		txtScheduleNo.click();
		txtScheduleNo.sendKeys(ScNo);
		txtScheduleNo.sendKeys(Keys.ENTER);
		waitForLoadingComplete();

	}

	def void selectRowsWithSchedNum(String SchedNum) {
	 waitForLoadingComplete();
		txtScheduleNo.clearRobustly();
		txtScheduleNo.click();
		txtScheduleNo.sendKeys(SchedNum);
		txtScheduleNo.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
		var List<String> rowsWithMatchingSchedNum = new ArrayList<String>();
		var InforGrid grid = new InforGrid(gridPMS100);
		var List<String> data = grid.getDataOfColumn(0);

		var int rowCount = data.length();

		try {
			for (var i = 0; i < rowCount; i++) {
				if (data.get(i).equals(SchedNum)) {

					rowsWithMatchingSchedNum.add(SchedNum);
				}
			}
		} catch (Exception e) {
			println("Failed to find elements with matching sched Num:" + SchedNum);
		}

		var int num = rowsWithMatchingSchedNum.length;

		firstGridCell.click();

		for (var y = 1; y < num; y++) {

			var Robot rb = new Robot()
			rb.keyPress(KeyEvent.VK_SHIFT);
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_SHIFT);
		}
	}

	def void DeliveryToolBox() {
		waitForLoadingComplete();
		rightClick(firstGridCell);
		waitToBeClickable(linkRelated);
		linkRelated.click();
		linkDeliveyToolBox.click();
		waitForLoadingComplete();
	}

	def void EnterMainProduct(String mainProduct) {
		txtProduct.clearRobustly();
		txtProduct.sendKeys(mainProduct);

	}

	def void SearchScheduleNo(String ScheduleNo) {

		try {
			waitForLoadingComplete();
			txtScheduleNo.click();
			clearRobustly(txtScheduleNo);

			txtScheduleNo.sendKeys(ScheduleNo);
			txtScheduleNo.sendKeys(Keys.ENTER);
			waitForLoadingComplete();

			var InforGrid grid = new InforGrid(gridElement);
			var int maxTime = 30000;
			var int sleepTime = 10000;
			var boolean time = true;
			while (grid.getRowContainingTextInColumn(1, ScheduleNo) == null && time) {
				
				Thread.sleep(sleepTime);
				txtScheduleNo.click();
				txtScheduleNo.clearRobustly();
				txtScheduleNo.sendKeys(Keys.ENTER);
				waitForLoadingComplete();

				// txtScheduleNo.click();	
				txtScheduleNo.sendKeys(ScheduleNo);
				txtScheduleNo.sendKeys(Keys.ENTER);
				waitForLoadingComplete();
				
				maxTime	= maxTime - sleepTime;
				if(maxTime < 1){
					time = false;
				}			

			}
		} catch (Exception exception) {
			System.out.println("Schedule No cannot be found");
		}

	}

	def List<String> GetStatuses(String ScheduleNo) {
		waitForLoadingComplete();
		Thread.sleep(3000);
		var InforGrid grid = new InforGrid(gridElement);
		var data = grid.getDataOfRowContainingTextInColumn(1, ScheduleNo);

		var newList = new ArrayList<String>();
		newList.add(0, data.get(7).toString);
		newList.add(1, data.get(8).toString);
		newList.add(2, data.get(9).toString);

		return newList;

	}

	def String GetFirstRowScheduleNumber() {
		var InforGrid grid = new InforGrid(gridElement);

		var schedCol = grid.getCellsFromColumn(1)
		return schedCol.get(0).text;
	}

	def void goToDeliveryToolbox() {
		var InforGrid grid = new InforGrid(gridElement);

		var schedCol = grid.getCellsFromColumn(1)
		var firstCell = schedCol.get(0)

		rightClick(firstCell)
		waitForLoadingComplete()

		linkRelated.click()
		waitForLoadingComplete()

		linkDeliveryToolbox.click()
		waitForLoadingComplete()
	}

	def ClearProduct() {
		txtProduct.clearRobustly();

	}

	def ClearMoNo() {
		txtMoNo.clearRobustly();

	}
	
	def void SelectSortingOrder(String value) {
		waitForLoadingComplete();
		selectFromDropdown(cmdSortingOrder, listSortingOrder, value);
		waitForLoadingComplete();
	}
	
	def List<String> GetStatusesWithSorting91(String ScheduleNo) {
		waitForLoadingComplete();
		Thread.sleep(3000);
		var InforGrid grid = new InforGrid(gridElement);
		var data = grid.getDataOfRowContainingTextInColumn(1, ScheduleNo);

		var newList = new ArrayList<String>();
		newList.add(0, data.get(3).toString);
		newList.add(1, data.get(4).toString);
		newList.add(2, data.get(5).toString);

		return newList;

	}
	
	def String GetMONumOfSchedule(String sched){
		var InforGrid grid = new InforGrid(gridElement);
		var data = grid.getDataOfRowContainingTextInColumn(1, sched);
		return data.get(2)
	}
	
	def void goToCheckCompAvailability(String mo) {
		var InforGrid grid = new InforGrid(gridElement);

		var colId = grid.getColumnIndexByname("MO no     ")
		System.out.println("Mo is in columns : "+colId)
		//var row = grid.getRowContainingTextInColumn(colId,mo)
		var row = grid.getRowContainingTextInColumn(3,mo)
		row.rightClick()
		
		linkRelated.waitToBeClickable()
		linkRelated.click()

		linkCheckCompAvailability.waitToBeClickable()
		linkCheckCompAvailability.click()
		waitForLoadingComplete()
	}
	
}
