package bi3.pages.pds001;

import bi3.framework.core.DefaultWebDriver;
import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import bi3.pages.ois100.OIS100G;
import bi3.pages.ois101.OIS101E;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PDS600E extends BasePage {
  private OIS100G ois100G;
  
  private OIS101E ois101e;
  
  public void Initialize() {
    OIS101E _oIS101E = new OIS101E(DefaultWebDriver.driver);
    this.ois101e = _oIS101E;
    OIS100G _oIS100G = new OIS100G(DefaultWebDriver.driver);
    this.ois100G = _oIS100G;
  }
  
  public PDS600E(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "#W01OPTContainer>button")
  private WebElement colorSelectArrow;
  
  @FindBy(id = "POS")
  private WebElement txtSearchBoxPOS;
  
  @FindBy(css = "#W02OPTContainer>button")
  private WebElement sizeSelectArrow;
  
  @FindBy(css = "div[id*=\'BROWSE_LIST\'] div.slick-cell.l0.r0")
  private WebElement gridFirstRowColor;
  
  @FindBy(id = "BTN_L52T24")
  private WebElement btnSelect;
  
  @FindBy(css = "div[id*=\'BROWSE_LIST\'] div.slick-cell.l0.r0")
  private WebElement gridFirstRowSize;
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "dbtnok")
  private WebElement btnOK_PopUp;
  
  @FindBy(id = "dbtnyes")
  private WebElement btnYes_PopUp;
  
  public void fillMatrix(final String POS_no, final String Size) {
    this.colorSelectArrow.click();
    BasePage.waitForLoadingComplete();
    BasePage.clickWhenReady(this.txtSearchBoxPOS);
    this.txtSearchBoxPOS.sendKeys(POS_no);
    this.txtSearchBoxPOS.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    BasePage.clickWhenReady(this.gridFirstRowColor);
    BasePage.clickWhenReady(this.btnSelect);
    WebDriverExtensions.waitToBeClickable(this.sizeSelectArrow);
    this.sizeSelectArrow.click();
    BasePage.waitForLoadingComplete();
    BasePage.clickWhenReady(this.txtSearchBoxPOS);
    this.txtSearchBoxPOS.sendKeys(Size);
    this.txtSearchBoxPOS.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
    BasePage.clickWhenReady(this.gridFirstRowSize);
    BasePage.clickWhenReady(this.btnSelect);
    BasePage.waitForLoadingComplete();
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
}
