package bi3.pages.pms170;

import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS170E extends BasePage {
  public PMS170E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WEFIDT")
  private WebElement txtDate;
  
  @FindBy(id = "WEORQA")
  private WebElement txtPlaneQty;
  
  @FindBy(id = "WEPSTS-shdo")
  private WebElement cmbStatus;
  
  @FindBy(css = "#dropdown-list li")
  private List<WebElement> listStatus;
  
  @FindBy(id = "WEORTY")
  private WebElement txtOrderType;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = "#Prev")
  private WebElement btnPrev;
  
  public void EnterFinishDate(final String date) {
    this.txtDate.sendKeys(date);
  }
  
  public void EnterPlanQty(final String qty) {
    this.txtPlaneQty.sendKeys(qty);
  }
  
  public void SelectStatus(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbStatus, this.listStatus, value);
  }
  
  public void SelectOrderType(final String orderType) {
    this.txtOrderType.click();
    this.txtOrderType.sendKeys(orderType);
  }
  
  public void clickNext() {
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void ClickPrev() {
    this.btnPrev.click();
    BasePage.waitForLoadingComplete();
  }
}
