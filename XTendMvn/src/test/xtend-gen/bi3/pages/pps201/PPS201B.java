package bi3.pages.pps201;

import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS201B extends BasePage {
  public PPS201B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'PPA201BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  public boolean CheckIfDetailsGridEmpty() {
    InforGrid grid = new InforGrid(this.gridElement);
    int _rowCount = grid.getRowCount();
    boolean _equals = (_rowCount == 0);
    if (_equals) {
      return true;
    } else {
      return false;
    }
  }
}
