package bi3.pages.pms170;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS170 extends BasePage {
  public PMS170(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "ActionsBtn")
  private WebElement btnAction;
  
  @FindBy(xpath = "//*[contains(text(),\'Create MOP\')]")
  private WebElement btnCreatMop;
  
  @FindBy(id = "WESCHN")
  private WebElement txtSch;
  
  @FindBy(css = "#startDiv")
  private WebElement btnStart;
  
  @FindBy(css = "#WWTX40")
  private WebElement lastSchNo;
  
  @FindBy(css = "div[id*=\'PMA170BS\'][class*=\'inforDataGrid\']")
  private WebElement gridPMS170;
  
  public String getLastJoindScheduleNo() {
    WebDriverExtensions.waitToBeDisplayed(this.lastSchNo);
    return BasePage.GetTextBoxvalue(this.lastSchNo);
  }
  
  public void SelectCreatMop() {
    this.btnAction.click();
    this.btnCreatMop.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void EnterSchedule(final String i) {
    this.txtSch.click();
    this.txtSch.sendKeys(i);
  }
  
  public void GoToHomePage() {
    this.btnStart.click();
  }
  
  public List<String> getDataFromRow(final int rowIndex) {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridPMS170);
    List<String> x = grid.getDataOfRow(rowIndex);
    return x;
  }
}
