package bi3.pages.mws420;

import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MWS420B1 extends BasePage {
  @FindBy(css = "div[id*=\'MWA420BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElementPickingList;
  
  public MWS420B1(final WebDriver driver) {
    super(driver);
  }
  
  /**
   * navigate to related option.
   */
  public void goToRelatedOption(final String option) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElementPickingList);
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
  
  public String getPiSOfFirstRow() {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElementPickingList);
    List<WebElement> cellElementList = grid.getCellsFromRow(0);
    WebElement cellPiS = cellElementList.get(1);
    String PiS = cellPiS.getText();
    InputOutput.<String>println("PiS value Returned");
    return PiS;
  }
}
