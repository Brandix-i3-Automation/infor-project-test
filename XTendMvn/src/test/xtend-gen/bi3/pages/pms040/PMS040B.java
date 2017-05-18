package bi3.pages.pms040;

import bi3.framework.core.DefaultWebDriver;
import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import bi3.pages.ToolbarPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS040B extends BasePage {
  public PMS040B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'PMA040BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(xpath = "//a/span[text()=\'Change\']")
  private WebElement linkChange;
  
  public void changeFirstRecord() {
    InforGrid grid = new InforGrid(this.gridElement);
    WebElement row = grid.getRow(0);
    WebDriverExtensions.waitToBeClickable(row);
    this.rightClick(row);
    WebDriverExtensions.waitToBeClickable(this.linkChange);
    this.linkChange.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String getStatusOfFirstRecord() {
    InforGrid grid = new InforGrid(this.gridElement);
    int colId = grid.getColumnIndexByname("Sts");
    List<String> data = grid.getDataOfRow(0);
    return data.get(colId);
  }
  
  public void clickRefresh() {
    ToolbarPage toolbar = new ToolbarPage(DefaultWebDriver.driver);
    toolbar.ClickAction_Refresh();
    BasePage.waitForLoadingComplete();
  }
}
