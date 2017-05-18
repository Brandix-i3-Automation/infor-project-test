package bi3.pages.ois276;

import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS276B extends BasePage {
  public OIS276B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[id*=\'OIA276BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(linkText = "Related")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//div[@class=\'inforMenu submenu\']/ul/li/a/span[contains(text(),\'Check/release\')]")
  private WebElement linkRelease;
  
  @FindBy(id = "dbtnok")
  private WebElement btnOk;
  
  @FindBy(id = "OAORNO")
  private WebElement txtCoNumber;
  
  @FindBy(css = "#tabsList > li.ui-tabs-selected.ui-state-active > button")
  private WebElement btnClose;
  
  @FindBy(id = "Prev")
  private WebElement btnPrev;
  
  public void Release() {
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    grid.getRow(0).click();
    BasePage.waitForLoadingComplete();
  }
  
  public String CopyCoNumber(final String CoNumber) {
    return this.txtCoNumber.getText();
  }
  
  public String CopyCONumber() {
    BasePage.waitForLoadingComplete();
    final String CONumber = BasePage.GetTextBoxvalue(this.txtCoNumber);
    System.out.println(CONumber);
    return CONumber;
  }
  
  public void ClickWarningOkButton() {
    BasePage.waitForLoadingComplete();
    this.btnOk.click();
  }
  
  public void close() {
    this.btnClose.click();
    System.out.println("OIS276B tab closed");
  }
  
  public void ClickPreviousPage() {
    BasePage.waitForLoadingComplete();
    this.btnPrev.click();
    BasePage.waitForLoadingComplete();
  }
}
