package bi3.pages.ois150;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS150_b1 extends BasePage {
  public OIS150_b1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1OBKV")
  private WebElement txtFac;
  
  @FindBy(id = "W2OBKV")
  private WebElement txtCONumber;
  
  @FindBy(css = "div[id*=\'OIA150BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(linkText = "Related")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//div[@class=\'inforMenu submenu\']//a/span[contains(text(),\'Sel to invoice\')]")
  private WebElement linkSet;
  
  @FindBy(id = "ActionsBtn")
  private WebElement BtnAction;
  
  @FindBy(xpath = "//ul[@class=\'inforContextMenu inforMenuOptions\']//li/a[contains(text(),\'Launch invoice\')]")
  private WebElement linkLaunchInvoice;
  
  public void EnterCoNumbers(final String CoNumber) {
    WebDriverExtensions.waitToBeDisplayed(this.txtCONumber);
    this.txtCONumber.sendKeys(CoNumber);
    this.txtCONumber.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void EnterFacNumber() {
    this.txtFac.sendKeys("A01");
  }
  
  public void ClickSelToInvoice() {
    InforGrid grid = new InforGrid(this.gridElement);
    this.rightClick(grid.getRow(0));
    this.linkRelated.click();
    this.linkSet.click();
  }
  
  public void LaunchInvoice() {
    WebDriverExtensions.waitToBeDisplayed(this.linkLaunchInvoice);
    this.linkLaunchInvoice.click();
  }
}
