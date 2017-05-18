package bi3.pages.pms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PMS001 extends BasePage {
  public PMS001(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WAPRNO")
  private WebElement txtProductNo;
  
  @FindBy(id = "WASTRT")
  private WebElement txtStrType;
  
  @FindBy(css = "button[class=\'inforIconButton new\']")
  private WebElement btnAdd;
  
  @FindBy(css = "div[row=\'0\']>div.l0.r0")
  private WebElement firstGridCell;
  
  public void setProductNo(final String itemNumber) {
    BasePage.waitForLoadingComplete();
    this.txtProductNo.click();
    BasePage.clearRobustly(this.txtProductNo);
    this.txtProductNo.sendKeys(itemNumber);
  }
  
  public void setStructureType(final String strType) {
    BasePage.waitForLoadingComplete();
    this.txtStrType.click();
    BasePage.clearRobustly(this.txtStrType);
    this.txtStrType.sendKeys(strType);
  }
  
  public void clearStructureType() {
    BasePage.waitForLoadingComplete();
    this.txtStrType.click();
    BasePage.clearRobustly(this.txtStrType);
  }
  
  public void searchForMOWithItemNo(final String itemNo) {
    this.clearStructureType();
    this.setProductNo(itemNo);
    this.txtProductNo.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
  
  public void clickAddButton() {
    this.btnAdd.click();
    BasePage.waitForLoadingComplete();
  }
  
  public String getItemNumberOfFirstRecord() {
    try {
      WebDriverExtensions.waitToBeDisplayed(this.firstGridCell);
      String firstGridText = this.firstGridCell.getText();
      return firstGridText;
    } catch (final Throwable _t) {
      if (_t instanceof ElementNotFoundException) {
        final ElementNotFoundException e = (ElementNotFoundException)_t;
        e.printStackTrace();
        return "Null";
      } else if (_t instanceof Exception) {
        final Exception e_1 = (Exception)_t;
        e_1.printStackTrace();
        return "Null";
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
