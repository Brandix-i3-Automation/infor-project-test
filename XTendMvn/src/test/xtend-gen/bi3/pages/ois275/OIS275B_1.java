package bi3.pages.ois275;

import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS275B_1 extends BasePage {
  public OIS275B_1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "W1OBKV")
  private WebElement txtCoNumber;
  
  @FindBy(css = "div[id*=\'OIA275BS\'][class*=\'inforDataGrid\']")
  private WebElement gridElement;
  
  @FindBy(linkText = "Related")
  private WebElement linkRelated;
  
  @FindBy(xpath = "//div[@class=\'inforMenu submenu\']/ul/li/a/span[contains(text(),\'Check/release\')]")
  private WebElement linkRelease;
  
  public void enterTemporaryOrdrNo(final String temporaryOrderNo) {
    BasePage.waitForLoadingComplete();
    this.txtCoNumber.click();
    this.txtCoNumber.sendKeys(temporaryOrderNo);
    this.txtCoNumber.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    InforGrid grid = new InforGrid(this.gridElement);
    grid.getRow(0).click();
    BasePage.waitForLoadingComplete();
  }
}
