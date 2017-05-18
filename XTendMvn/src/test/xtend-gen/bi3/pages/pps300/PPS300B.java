package bi3.pages.pps300;

import bi3.framework.core.WebDriverExtensions;
import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS300B extends BasePage {
  public PPS300B(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "XT_0168")
  private WebElement btnApply;
  
  @FindBy(id = "WWPUNO")
  private WebElement txtPONum;
  
  @FindBy(id = "WWQTTP-shdo")
  private WebElement cmbSortingOrder;
  
  @FindBy(css = "#dropdown-list li")
  private List<WebElement> listSortingOrder;
  
  @FindBy(xpath = "//a/span[text()=\'Change\']")
  private WebElement linkChange;
  
  @FindBy(css = "div[id*=\'PPA300BS\'][class*=\'inforDataGrid\']")
  private WebElement inforGrid;
  
  public void enterPONum(final String po) {
    WebDriverExtensions.waitToBeClickable(this.txtPONum);
    this.txtPONum.click();
    BasePage.clearRobustly(this.txtPONum);
    this.txtPONum.sendKeys(po);
    this.txtPONum.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void clickApply() {
    WebDriverExtensions.waitToBeClickable(this.btnApply);
    this.btnApply.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void setSortingOrder(final String value) {
    try {
      BasePage.waitForLoadingComplete();
      Thread.sleep(3000);
      this.selectFromDropdown(this.cmbSortingOrder, this.listSortingOrder, value);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void goToChange() {
    BasePage.waitForLoadingComplete();
    InforGrid inforGrid = new InforGrid(this.inforGrid);
    WebElement matchingElement = inforGrid.getRow(0);
    InputOutput.<String>println(("WEbELement " + matchingElement));
    this.rightClick(matchingElement);
    BasePage.clickWhenReady(this.linkChange);
    BasePage.waitForLoadingComplete();
  }
}
