package bi3.pages.mms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001 extends BasePage {
  public MMS001(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1OBKV")
  private WebElement txtItemNumber;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Copy\')]")
  private WebElement linkCopy;
  
  @FindBy(css = "div.slick-cell.l0.r0>a")
  private List<WebElement> listItemNumbers;
  
  @FindBy(css = "#tabsList > li.ui-tabs-selected.ui-state-active > button")
  private WebElement btnClose;
  
  @FindBy(xpath = "//a[text()=\'Related\']")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Item/Warehouse\')]")
  private WebElement linkItemWarehouse;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Item/Facility\')]")
  private WebElement linkItemFacility;
  
  @FindBy(css = "div[id*=\'MMA001BS\'][class*=\'inforDataGrid\']")
  private WebElement gridMMS001;
  
  @FindBy(css = "button.inforIconButton.edit")
  private WebElement btnEdit;
  
  @FindBy(id = "CPITNO")
  private WebElement txtChangeItemNumber;
  
  public void SearchByItemNumber(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    this.txtItemNumber.click();
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtItemNumber);
    WebDriverExtensions.waitToBeDisplayed(this.txtItemNumber);
    this.txtItemNumber.sendKeys(itemNumber);
    BasePage.waitForLoadingComplete();
    this.txtItemNumber.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void CopyItem(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeDisplayed(this.linkCopy);
    WebDriverExtensions.waitToBeClickable(this.linkCopy);
    this.linkCopy.click();
    BasePage.waitForLoadingComplete();
  }
  
  public List<String> GetItemNumberList() {
    BasePage.waitForLoadingComplete();
    return this.getTextList(this.listItemNumbers);
  }
  
  public void setItemWarehouse(final String itemNumber) {
    try {
      this.gridFirstLine.sendKeys(Keys.chord(Keys.CONTROL, "11"));
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void close() {
    this.btnClose.click();
    System.out.println("MMS001 tab closed");
  }
  
  /**
   * Navigate to Item Warehouse link in Item
   */
  public void ItemWarehouse(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    this.gridFirstLine.sendKeys(Keys.chord(Keys.CONTROL, "11"));
    BasePage.waitForLoadingComplete();
  }
  
  public void setItemFacility(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    this.rightClick(this.gridFirstLine);
    WebDriverExtensions.waitToBeClickable(this.linkRelated);
    this.linkRelated.click();
    WebDriverExtensions.waitToBeClickable(this.linkItemFacility);
    this.linkItemFacility.click();
    BasePage.waitForLoadingComplete();
  }
  
  public List<String> getDataOfItem(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridMMS001);
    List<String> dataList = grid.getDataOfRowContainingTextInColumn(1, itemNumber);
    return dataList;
  }
  
  public void EditItem(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridMMS001);
    WebElement cell = grid.getCell("Item number", itemNumber);
    WebDriverExtensions.waitToBeClickable(cell);
    cell.click();
    BasePage.waitForLoadingComplete();
    BasePage.clickWhenReady(this.btnEdit);
    BasePage.waitForLoadingComplete();
  }
  
  public void clearItemInsertNewNo(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    this.txtChangeItemNumber.clear();
    this.txtChangeItemNumber.sendKeys(itemNumber);
  }
}
