package bi3.pages.mms001;

import bi3.framework.core.WebDriverExtensions;
import bi3.pages.BasePage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class MMS001ConnectWarehouse extends BasePage {
  public MMS001ConnectWarehouse(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div[class=\'tabTitle\'][title]")
  private WebElement pageTitle;
  
  @FindBy(css = ".slick-cell.l1.r1")
  private WebElement gridFirstLine;
  
  @FindBy(xpath = "//a/span[contains(text(),\'Change\')]")
  private WebElement linkChange;
  
  @FindBy(id = "startDiv")
  private WebElement btnStart;
  
  @FindBy(css = "#tabsList > li.ui-tabs-selected.ui-state-active > button")
  private WebElement btnClose;
  
  public String getpageTitle() {
    BasePage.waitForLoadingComplete();
    return this.pageTitle.getText();
  }
  
  public void changeWarehouse() {
    try {
      BasePage.waitForLoadingComplete();
      Thread.sleep(500);
      this.rightClick(this.gridFirstLine);
      WebDriverExtensions.waitToBeClickable(this.linkChange);
      this.linkChange.click();
      BasePage.waitForLoadingComplete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void close() {
    this.btnClose.click();
    System.out.println("Connect Warehouse tab closed");
  }
}
