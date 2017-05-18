package bi3.pages.mms101;

import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS101B extends BasePage {
  public MMS101B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'MMA101BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElementDistrOrder;
  
  /**
   * navigate to related option.
   */
  public void goToRelatedOption(final String option) {
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
  }
}
