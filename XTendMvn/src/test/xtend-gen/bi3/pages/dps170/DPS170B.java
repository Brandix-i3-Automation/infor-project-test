package bi3.pages.dps170;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class DPS170B extends BasePage {
  public DPS170B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1OBKV")
  private WebElement txtResp;
  
  @FindBy(id = "W2OBKV")
  private WebElement txtFwh;
  
  @FindBy(id = "W3OBKV")
  private WebElement txtTwh;
  
  @FindBy(id = "W4OBKV")
  private WebElement txtItemNumber;
  
  @FindBy(linkText = "Related")
  private WebElement linkRelated;
  
  @FindBy(xpath = ".//a/span[contains(text(),\'Release\')]")
  private WebElement linkPreAllocation;
  
  @FindBy(css = ".slick-cell.l0.r0")
  private WebElement gridFirstLine;
  
  @FindBy(xpath = ".//a/span[contains(text(),\'Release\')]")
  private WebElement linkRelease;
  
  @FindBy(css = "div[id*=\'DPA170BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElementDistrOrder;
  
  public void SearchItem(final String resp, final String fwh, final String twh, final String itemnumber) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeDisplayed(this.txtResp);
    BasePage.clearRobustly(this.txtResp);
    this.txtResp.sendKeys(resp);
    BasePage.clearRobustly(this.txtFwh);
    this.txtFwh.sendKeys(fwh);
    BasePage.clearRobustly(this.txtTwh);
    this.txtTwh.sendKeys(twh);
    BasePage.clearRobustly(this.txtItemNumber);
    this.txtItemNumber.sendKeys(itemnumber);
    this.txtItemNumber.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public String goToRelatedOption(final String option) {
    String _xblockexpression = null;
    {
      BasePage.waitForLoadingComplete();
      InforGrid grid = new InforGrid(this.gridElementDistrOrder);
      WebElement gridRow = null;
      int _rowCount = grid.getRowCount();
      boolean _greaterThan = (_rowCount > 0);
      if (_greaterThan) {
        gridRow = grid.getRow(0);
        gridRow.click();
        this.rightClick(gridRow, Boolean.valueOf(true), option);
      }
      BasePage.waitForLoadingComplete();
      _xblockexpression = InputOutput.<String>print("DOP Released");
    }
    return _xblockexpression;
  }
  
  public void releaseDOP() {
    InforGrid grid = new InforGrid(this.gridElementDistrOrder);
    WebElement gridRow = null;
    int _rowCount = grid.getRowCount();
    boolean _greaterThan = (_rowCount > 0);
    if (_greaterThan) {
      gridRow = grid.getRow(0);
      gridRow.click();
      BasePage.waitForLoadingComplete();
      String _plus = (Keys.CONTROL + "11");
      gridRow.sendKeys(_plus);
    }
    BasePage.waitForLoadingComplete();
  }
}
