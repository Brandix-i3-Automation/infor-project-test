package bi3.pages.pms100;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import com.google.common.base.Objects;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS100_B extends BasePage {
  public PMS100_B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1OBKV")
  private WebElement txtScheduleNo;
  
  @FindBy(css = "div[id*=\'PMA100BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Delivery Toolbox\')]")
  private WebElement linkDeliveryToolbox;
  
  @FindBy(css = "#W2OBKV")
  private WebElement txtProduct;
  
  @FindBy(css = "#W3OBKV")
  private WebElement txtMoNo;
  
  @FindBy(css = "div[id*=\'PMA100BS\'][class*=\'inforDataGrid\']")
  private WebElement gridPMS100;
  
  @FindBy(css = "div[row=\'0\'] > div")
  private WebElement firstGridCell;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Delivery Toolbox\')]")
  private WebElement linkDeliveyToolBox;
  
  @FindBy(css = "#WWQTTP-shdo")
  private WebElement cmdSortingOrder;
  
  @FindBy(css = "#dropdown-list li")
  private List<WebElement> listSortingOrder;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Check Component Availability\')]")
  private WebElement linkCheckCompAvailability;
  
  public void EnterSchNo(final String ScNo) {
    BasePage.clearRobustly(this.txtScheduleNo);
    this.txtScheduleNo.click();
    this.txtScheduleNo.sendKeys(ScNo);
    this.txtScheduleNo.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void selectRowsWithSchedNum(final String SchedNum) {
    try {
      BasePage.waitForLoadingComplete();
      BasePage.clearRobustly(this.txtScheduleNo);
      this.txtScheduleNo.click();
      this.txtScheduleNo.sendKeys(SchedNum);
      this.txtScheduleNo.sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
      List<String> rowsWithMatchingSchedNum = new ArrayList<String>();
      InforGrid grid = new InforGrid(this.gridPMS100);
      List<String> data = grid.getDataOfColumn(0);
      final List<String> _converted_data = (List<String>)data;
      int rowCount = ((Object[])Conversions.unwrapArray(_converted_data, Object.class)).length;
      try {
        for (int i = 0; (i < rowCount); i++) {
          boolean _equals = data.get(i).equals(SchedNum);
          if (_equals) {
            rowsWithMatchingSchedNum.add(SchedNum);
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          InputOutput.<String>println(("Failed to find elements with matching sched Num:" + SchedNum));
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final List<String> _converted_rowsWithMatchingSchedNum = (List<String>)rowsWithMatchingSchedNum;
      int num = ((Object[])Conversions.unwrapArray(_converted_rowsWithMatchingSchedNum, Object.class)).length;
      this.firstGridCell.click();
      for (int y = 1; (y < num); y++) {
        {
          Robot rb = new Robot();
          rb.keyPress(KeyEvent.VK_SHIFT);
          rb.keyPress(KeyEvent.VK_DOWN);
          rb.keyRelease(KeyEvent.VK_DOWN);
          rb.keyRelease(KeyEvent.VK_SHIFT);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void DeliveryToolBox() {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.firstGridCell);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    this.linkDeliveyToolBox.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void EnterMainProduct(final String mainProduct) {
    BasePage.clearRobustly(this.txtProduct);
    this.txtProduct.sendKeys(mainProduct);
  }
  
  public void SearchScheduleNo(final String ScheduleNo) {
    try {
      BasePage.waitForLoadingComplete();
      this.txtScheduleNo.click();
      BasePage.clearRobustly(this.txtScheduleNo);
      this.txtScheduleNo.sendKeys(ScheduleNo);
      this.txtScheduleNo.sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
      InforGrid grid = new InforGrid(this.gridElement);
      int maxTime = 30000;
      int sleepTime = 10000;
      boolean time = true;
      while ((Objects.equal(grid.getRowContainingTextInColumn(1, ScheduleNo), null) && time)) {
        {
          Thread.sleep(sleepTime);
          this.txtScheduleNo.click();
          BasePage.clearRobustly(this.txtScheduleNo);
          this.txtScheduleNo.sendKeys(Keys.ENTER);
          BasePage.waitForLoadingComplete();
          this.txtScheduleNo.sendKeys(ScheduleNo);
          this.txtScheduleNo.sendKeys(Keys.ENTER);
          BasePage.waitForLoadingComplete();
          maxTime = (maxTime - sleepTime);
          if ((maxTime < 1)) {
            time = false;
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exception = (Exception)_t;
        System.out.println("Schedule No cannot be found");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public List<String> GetStatuses(final String ScheduleNo) {
    try {
      BasePage.waitForLoadingComplete();
      Thread.sleep(3000);
      InforGrid grid = new InforGrid(this.gridElement);
      List<String> data = grid.getDataOfRowContainingTextInColumn(1, ScheduleNo);
      ArrayList<String> newList = new ArrayList<String>();
      newList.add(0, data.get(7).toString());
      newList.add(1, data.get(8).toString());
      newList.add(2, data.get(9).toString());
      return newList;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String GetFirstRowScheduleNumber() {
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> schedCol = grid.getCellsFromColumn(1);
    return schedCol.get(0).getText();
  }
  
  public void goToDeliveryToolbox() {
    InforGrid grid = new InforGrid(this.gridElement);
    List<WebElement> schedCol = grid.getCellsFromColumn(1);
    WebElement firstCell = schedCol.get(0);
    this.rightClick(firstCell);
    BasePage.waitForLoadingComplete();
    this.linkRelated.click();
    BasePage.waitForLoadingComplete();
    this.linkDeliveryToolbox.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void ClearProduct() {
    BasePage.clearRobustly(this.txtProduct);
  }
  
  public void ClearMoNo() {
    BasePage.clearRobustly(this.txtMoNo);
  }
  
  public void SelectSortingOrder(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmdSortingOrder, this.listSortingOrder, value);
    BasePage.waitForLoadingComplete();
  }
  
  public List<String> GetStatusesWithSorting91(final String ScheduleNo) {
    try {
      BasePage.waitForLoadingComplete();
      Thread.sleep(3000);
      InforGrid grid = new InforGrid(this.gridElement);
      List<String> data = grid.getDataOfRowContainingTextInColumn(1, ScheduleNo);
      ArrayList<String> newList = new ArrayList<String>();
      newList.add(0, data.get(3).toString());
      newList.add(1, data.get(4).toString());
      newList.add(2, data.get(5).toString());
      return newList;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String GetMONumOfSchedule(final String sched) {
    InforGrid grid = new InforGrid(this.gridElement);
    List<String> data = grid.getDataOfRowContainingTextInColumn(1, sched);
    return data.get(2);
  }
  
  public void goToCheckCompAvailability(final String mo) {
    InforGrid grid = new InforGrid(this.gridElement);
    int colId = grid.getColumnIndexByname("MO no     ");
    System.out.println(("Mo is in columns : " + Integer.valueOf(colId)));
    WebElement row = grid.getRowContainingTextInColumn(3, mo);
    this.rightClick(row);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkCheckCompAvailability);
    this.linkCheckCompAvailability.click();
    BasePage.waitForLoadingComplete();
  }
}
