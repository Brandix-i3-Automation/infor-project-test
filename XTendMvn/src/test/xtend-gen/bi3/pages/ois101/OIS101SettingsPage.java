package bi3.pages.ois101;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS101SettingsPage extends BasePage {
  public OIS101SettingsPage(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(id = "WWDSEQ")
  private WebElement txtPanelSequence;
  
  @FindBy(id = "WWDTFM-shdo")
  private WebElement cmbBoxDateFormat;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listDateFormat;
  
  @FindBy(css = "ul#dropdown-list li")
  private List<WebElement> listFullScreenOpt;
  
  @FindBy(id = "WWSIMU")
  private WebElement chkBoxPriceSimulatn;
  
  @FindBy(id = "WWXO73")
  private WebElement txtSearchSeqAli;
  
  @FindBy(id = "WWXMAT-shdo")
  private WebElement cmbBoxFullScreenOpt;
  
  public void clickNext() {
    WebDriverExtensions.waitToBeClickable(this.btnNext);
    this.btnNext.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void enterPanelSequence(final String panelSequence) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtPanelSequence);
    this.txtPanelSequence.click();
    BasePage.clearRobustly(this.txtPanelSequence);
    this.txtPanelSequence.sendKeys(panelSequence);
  }
  
  public void selectDateFormat(final String optionDate) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbBoxDateFormat, this.listDateFormat, optionDate);
  }
  
  public void unselectCheckboxPriceSimulatn() {
    boolean _isSelected = this.chkBoxPriceSimulatn.isSelected();
    if (_isSelected) {
      this.chkBoxPriceSimulatn.click();
      BasePage.waitForLoadingComplete();
    }
  }
  
  public void selectFullScreenOpt(final String optionScreenOpt) {
    BasePage.waitForLoadingComplete();
    this.selectFromDropdown(this.cmbBoxFullScreenOpt, this.listFullScreenOpt, optionScreenOpt);
  }
  
  public void enterSearchSeqAli(final String valueSeqAli) {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.txtSearchSeqAli);
    this.txtSearchSeqAli.click();
    BasePage.clearRobustly(this.txtSearchSeqAli);
    this.txtSearchSeqAli.sendKeys(valueSeqAli);
  }
  
  public void customerOrderOpenLineSettingSetUp(final String panelSequence, final String optionDate, final String optionScreenOpt, final String valueSeqAli) {
    BasePage.waitForLoadingComplete();
    this.enterPanelSequence(panelSequence);
    this.selectDateFormat(optionDate);
    this.unselectCheckboxPriceSimulatn();
    this.selectFullScreenOpt(optionScreenOpt);
    this.enterSearchSeqAli(valueSeqAli);
    this.clickNext();
  }
}
