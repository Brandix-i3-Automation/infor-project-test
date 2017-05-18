package bi3.pages;

import bi3.framework.core.DefaultWebDriver;
import bi3.framework.core.WebDriverExtensions;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("all")
public class BasePage extends WebDriverExtensions {
  public BasePage(final WebDriver driver) {
    DefaultWebDriver.driver = driver;
    PageFactory.initElements(driver, this);
  }
  
  @FindBy(id = "inforLoadingOverlay")
  private static WebElement loadingIcon;
  
  @FindBy(id = "showProgramShortName")
  private static WebElement pageId;
  
  @FindBy(id = "startDiv")
  private WebElement btnStart;
  
  @FindBy(css = ".previousBtn")
  private WebElement btnPrev;
  
  @FindBy(css = "li[class=\'ui-tabs-selected ui-state-active\']>button[class=\'inforTabCloseButton\']")
  private WebElement btnActiveTabClose;
  
  public static void waitForLoadingComplete() {
    WebDriverExtensions.waitToBeHidden(BasePage.loadingIcon);
  }
  
  public static void clickWhenReady(final WebElement element) {
    try {
      try {
        BasePage.waitForLoadingComplete();
        WebDriverExtensions.waitToBeDisplayed(element, 60000);
        element.click();
      } catch (final Throwable _t) {
        if (_t instanceof StaleElementReferenceException) {
          final StaleElementReferenceException ex = (StaleElementReferenceException)_t;
          Thread.sleep(3000);
          element.click();
        } else if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          StackTraceElement[] _stackTrace = e.getStackTrace();
          String _plus = ((("Click on " + element) + " Failed ") + _stackTrace);
          System.out.println(_plus);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getPageId() {
    System.out.println(BasePage.pageId.getText());
    return BasePage.pageId.getText();
  }
  
  public static String GetTextBoxvalue(final WebElement element) {
    return element.getAttribute("value");
  }
  
  public static void clearRobustly(final WebElement element) {
    try {
      element.clear();
      int _length = BasePage.GetTextBoxvalue(element).trim().length();
      boolean _notEquals = (_length != 0);
      if (_notEquals) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.chord(Keys.DELETE));
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        StackTraceElement[] _stackTrace = e.getStackTrace();
        String _plus = ((("Element " + element) + " cannot be cleared ") + _stackTrace);
        System.out.println(_plus);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public static void SelectAllGridRows(final WebElement element) {
    try {
      element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        StackTraceElement[] _stackTrace = e.getStackTrace();
        String _plus = ((("Element " + element) + " cannot select All Rows") + _stackTrace);
        System.out.println(_plus);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void closeAllTabs() {
    try {
      List<WebElement> listBtnClose = DefaultWebDriver.driver.findElements(
        By.cssSelector("li.ui-state-active button.inforTabCloseButton"));
      do {
        {
          listBtnClose.get(0).click();
          BasePage.waitForLoadingComplete();
          listBtnClose = DefaultWebDriver.driver.findElements(By.cssSelector("li.ui-state-active button.inforTabCloseButton"));
        }
      } while((listBtnClose.size() != 0));
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        StackTraceElement[] _stackTrace = e.getStackTrace();
        String _plus = ("Error on closing tabs " + _stackTrace);
        System.out.println(_plus);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void goToHome() {
    this.btnStart.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void ClickPrevious() {
    BasePage.waitForLoadingComplete();
    WebDriverExtensions.waitToBeClickable(this.btnPrev);
    this.btnPrev.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void CloseActiveTab() {
    WebDriverExtensions.waitToBeClickable(this.btnActiveTabClose);
    this.btnActiveTabClose.click();
    BasePage.waitForLoadingComplete();
  }
}
