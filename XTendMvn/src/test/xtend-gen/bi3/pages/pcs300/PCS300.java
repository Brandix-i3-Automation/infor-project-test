package bi3.pages.pcs300;

import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PCS300 extends BasePage {
  public PCS300(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'PCA300BS\'][class*=\'inforDataGrid\']")
  private WebElement gridPCS300;
  
  public List<String> getDataOfItem(final String CostingType) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridPCS300);
    List<String> dataList = grid.getDataOfRowContainingTextInColumn(1, CostingType);
    return dataList;
  }
}
