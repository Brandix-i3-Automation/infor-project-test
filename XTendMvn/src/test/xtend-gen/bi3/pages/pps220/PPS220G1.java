package bi3.pages.pps220;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS220G1 extends BasePage {
  public PPS220G1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Prev")
  private WebElement btnPrevious;
  
  @FindBy(css = "div[id*=\'PPA220GS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(id = "ActionsBtn")
  private WebElement btnAction;
  
  @FindBy(css = "ul[id*=\'ActionsMenu\']>li")
  private List<WebElement> listActions;
  
  @FindBy(id = "WGSORN")
  private WebElement txtSupplOrderNo;
  
  @FindBy(id = "WGYRE1")
  private WebElement txtYourRef;
  
  public String getPONumberOfRow(final int rowId) {
    InforGrid grid = new InforGrid(this.gridElement);
    List<String> po = grid.getDataOfRow(rowId);
    return po.get(0);
  }
  
  public void goBack() {
    WebDriverExtensions.waitToBeClickable(this.btnPrevious);
    this.btnPrevious.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void selectAction(final String action) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.btnAction, this.listActions, action);
    BasePage.waitForLoadingComplete();
  }
  
  public void setHeaderDetails(final String supplOrderNo, final String yourRef) {
    BasePage.waitForLoadingComplete();
    this.txtSupplOrderNo.sendKeys(supplOrderNo);
    this.txtYourRef.sendKeys(yourRef);
    BasePage.waitForLoadingComplete();
  }
}
