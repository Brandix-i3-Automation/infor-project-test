package bi3.pages.fcs350;

import bi3.framework.core.DefaultWebDriver;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import com.google.common.base.Objects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class FCS350_B extends BasePage {
  public FCS350_B(final WebDriver driver) {
    super(driver);
  }
  
  /**
   * PAGE OBJECTS
   */
  @FindBy(id = "WWITNO")
  private WebElement txtBoxItemNo;
  
  @FindBy(id = "WWSTDT")
  private WebElement txtPeriodframeDate;
  
  @FindBy(id = "WWPETP-shdo")
  private WebElement cmbPeriodType;
  
  @FindBy(css = "#dropdown-list li")
  private List<WebElement> listPeriodType;
  
  @FindBy(id = "XT_0168")
  private WebElement btnApply;
  
  @FindBy(css = "div[id*=\'FCA350BS\'][class*=\'inforDataGrid\']")
  private WebElement gridFCS350;
  
  @FindBy(id = "Next")
  private WebElement nextBtn;
  
  /**
   * Set values to the fields in header section and click apply button
   */
  public void setHeaderDetails(final String itemNumber, final String periodFrame, final String periodType) {
    boolean _notEquals = (!Objects.equal(itemNumber, ""));
    if (_notEquals) {
      BasePage.waitForLoadingComplete();
      this.txtBoxItemNo.click();
      BasePage.clearRobustly(this.txtBoxItemNo);
      this.txtBoxItemNo.sendKeys(itemNumber);
    }
    boolean _notEquals_1 = (!Objects.equal(periodType, ""));
    if (_notEquals_1) {
      BasePage.waitForLoadingComplete();
      this.selectFromDropdown(this.cmbPeriodType, this.listPeriodType, periodType);
    }
    boolean _notEquals_2 = (!Objects.equal(periodFrame, ""));
    if (_notEquals_2) {
      BasePage.waitForLoadingComplete();
      this.txtPeriodframeDate.clear();
      this.txtPeriodframeDate.sendKeys(periodFrame);
    }
    BasePage.clickWhenReady(this.btnApply);
    BasePage.waitForLoadingComplete();
  }
  
  /**
   * Set forcasting qty for a empty grid cell
   */
  public String setFCQtyForTheEmptyPeriod(final String periodWithinCalYear, final String fcQty) {
    InforGrid grid = new InforGrid(this.gridFCS350);
    boolean _notEquals = (!Objects.equal(periodWithinCalYear, ""));
    if (_notEquals) {
      grid.setValueToColumnSearchField("Per", periodWithinCalYear).sendKeys(Keys.ENTER);
      BasePage.waitForLoadingComplete();
    }
    BasePage.clickWhenReady(grid.getCell("F/C qty", "").findElement(By.cssSelector("div.edit-cell")));
    grid.getCell("F/C qty", "").findElement(By.cssSelector("input.inforTextbox")).sendKeys(fcQty);
    WebElement frdtElement = DefaultWebDriver.driver.findElement(By.cssSelector("div.slick-row.active div:nth-child(2)"));
    return frdtElement.getText();
  }
  
  /**
   * Click Next
   */
  public void Next() {
    BasePage.waitForLoadingComplete();
    this.nextBtn.click();
    BasePage.waitForLoadingComplete();
  }
}
