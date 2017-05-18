package bi3.pages.mms001;

import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001E extends BasePage {
  public MMS001E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WEITNO")
  private WebElement txtItemNumber;
  
  @FindBy(id = "MMSTCD-shdo")
  private WebElement cmbInvAccounting;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listInvAccounting;
  
  @FindBy(id = "MMINDI-shdo")
  private WebElement cmbLotCtrlMethod;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listLotCtrlMethod;
  
  @FindBy(id = "MMBACD-shdo")
  private WebElement cmbLotNumbMethod;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listLotNumbMethod;
  
  @FindBy(id = "MMSTAT-shdo")
  private WebElement cmbStatus;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listStatus;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void Next() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void SelectInvAccounting(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbInvAccounting, this.listInvAccounting, value);
    BasePage.waitForLoadingComplete();
  }
  
  public void SelectLotCtrlMethod(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbLotCtrlMethod, this.listLotCtrlMethod, value);
    BasePage.waitForLoadingComplete();
  }
  
  public void SelectLotNumbMethod(final String value) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbLotNumbMethod, this.listLotNumbMethod, value);
    BasePage.waitForLoadingComplete();
  }
  
  public String GetItemNumber() {
    BasePage.waitForLoadingComplete();
    return BasePage.GetTextBoxvalue(this.txtItemNumber);
  }
  
  public void setStatus(final String status) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbStatus, this.listStatus, status);
    BasePage.waitForLoadingComplete();
  }
}
