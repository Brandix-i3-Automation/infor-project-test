package bi3.pages.pps220;

import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS220J1 extends BasePage {
  public PPS220J1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'PPA220JS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(id = "ActionsBtn")
  private WebElement btnAction;
  
  @FindBy(css = "ul[id*=\'ActionsMenu\']>li")
  private List<WebElement> listActions;
  
  public String getPONumberOfRow(final int rowId) {
    InforGrid grid = new InforGrid(this.gridElement);
    List<String> po = grid.getDataOfRow(rowId);
    return po.get(0);
  }
  
  public void selectAction(final String action) {
    this.selectFromDropdown(this.btnAction, this.listActions, action);
  }
}
