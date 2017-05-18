package bi3.pages.pms230;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS060B1 extends BasePage {
  public PMS060B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[row=\'0\']>div")
  private WebElement firstGridCell;
  
  @FindBy(id = "RelatedBtn")
  private WebElement btnRealted;
  
  @FindBy(xpath = "//*[contains(text(),\'Confirmation\')]/span")
  private WebElement btnConfirmation;
  
  @FindBy(css = "#WMSCHN")
  private WebElement selectedSchNo;
  
  @FindBy(xpath = ".//*[@href=\'#tabhost_0\']/div/div")
  private WebElement lblMoReportIssue;
  
  @FindBy(css = "#Prev")
  private WebElement btnPrev;
  
  public String getSelectedSchNo() {
    WebDriverExtensions.waitToBeDisplayed(this.selectedSchNo);
    return BasePage.GetTextBoxvalue(this.selectedSchNo);
  }
  
  public String getlblValue() {
    WebDriverExtensions.waitToBeDisplayed(this.lblMoReportIssue);
    return this.lblMoReportIssue.getText();
  }
  
  public void SelectAllRows() {
    BasePage.waitForLoadingComplete();
    this.firstGridCell.click();
    BasePage.SelectAllGridRows(this.firstGridCell);
  }
  
  public void Confirmation() {
    this.btnRealted.click();
    this.btnConfirmation.click();
  }
  
  public void ClickPrev() {
    BasePage.waitForLoadingComplete();
    this.btnPrev.click();
    BasePage.waitForLoadingComplete();
  }
}
