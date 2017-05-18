package bi3.pages.pms230;

import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS230S extends BasePage {
  public PMS230S(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "#WFSCHN")
  private WebElement txtSchNo;
  
  @FindBy(xpath = ".//*[@id=\'WFSCHNContainer\']//span")
  private WebElement btnOpenSchNo;
  
  @FindBy(css = "div[row=\'0\']")
  private WebElement firstGridCell;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  public void SelectingScheduleNo(final String ScNOs) {
    this.txtSchNo.click();
    this.txtSchNo.sendKeys(ScNOs);
    BasePage.waitForLoadingComplete();
  }
  
  public void SelectFirstRow() {
    this.firstGridCell.click();
  }
  
  public void PickScheduleNo() {
    this.btnSelect.click();
  }
  
  public void ClickNext() {
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
