package bi3.pages.pds001;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PDS001E extends BasePage {
  public PDS001E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1CNQT")
  private WebElement txtQuantity;
  
  public void setQuantity(final String qty) {
    WebDriverExtensions.waitToBeDisplayed(this.txtQuantity);
    BasePage.clearRobustly(this.txtQuantity);
    this.txtQuantity.sendKeys(qty);
  }
  
  @FindBy(id = "div[id*=\'OIA101BS\'][class*=\'inforDataGrid\']")
  private WebElement gridOIS100;
  
  public void getDetails() {
    InforGrid grid = new InforGrid(this.gridOIS100);
    this.rightClick(grid.getCell(1, "A1000"));
    grid.getDataOfRowContainingTextInColumn(1, "Y121212");
  }
  
  @FindBy(id = "WHSTAT-shdo")
  private WebElement cmbStatus;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listStatus;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void setStatus(final String status) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbStatus, this.listStatus, status);
    BasePage.waitForLoadingComplete();
  }
  
  public void Next() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
