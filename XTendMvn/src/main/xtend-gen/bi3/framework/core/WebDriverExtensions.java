package bi3.framework.core;

import bi3.framework.core.DefaultWebDriver;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("all")
public class WebDriverExtensions extends DefaultWebDriver {
  /**
   * Wait for an element to be Displayed
   * @param element WebElement
   * @param timeoutInSeconds Timeout in seconds
   */
  public static void waitToBeDisplayed(final WebElement element, final int timeoutInSeconds) {
    try {
      WebDriverWait wait = new WebDriverWait(DefaultWebDriver.driver, timeoutInSeconds);
      wait.<WebElement>until(ExpectedConditions.visibilityOf(element));
    } catch (final Throwable _t) {
      if (_t instanceof TimeoutException) {
        final TimeoutException timeoutex = (TimeoutException)_t;
        String errorMessage = (("After " + Integer.valueOf(timeoutInSeconds)) + "ms, failed to display element ");
      } else if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Wait for an element to be Displayed
   * @param element WebElement
   */
  public static void waitToBeDisplayed(final WebElement element) {
    WebDriverExtensions.waitToBeDisplayed(element, 60);
  }
  
  /**
   * Wait for an element to be Clickable
   * @param element WebElement
   * @param timeOutInSeconds Timeout in seconds
   */
  public static void waitToBeClickable(final WebElement element, final int timeOutInSeconds) {
    try {
      WebDriverWait wait = new WebDriverWait(DefaultWebDriver.driver, timeOutInSeconds);
      wait.<WebElement>until(ExpectedConditions.elementToBeClickable(element));
    } catch (final Throwable _t) {
      if (_t instanceof TimeoutException) {
        final TimeoutException timeoutex = (TimeoutException)_t;
        String errorMessage = (("After " + Integer.valueOf(timeOutInSeconds)) + "ms, element failed to be clickable");
      } else if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Wait for an element to be Clickable
   * @param element WebElement
   */
  public static void waitToBeClickable(final WebElement element) {
    WebDriverExtensions.waitToBeClickable(element, 60);
  }
  
  /**
   * Wait for an element to be Hidden/ Not Visible
   * @param element WebElement
   * @param timeOutInSeconds Timeout in seconds
   */
  public static void waitToBeHidden(final WebElement element, final int timeOutInSeconds) {
    try {
      DefaultWebDriver.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      ArrayList<WebElement> elements = CollectionLiterals.<WebElement>newArrayList();
      try {
        elements.add(element);
        WebDriverWait wait = new WebDriverWait(DefaultWebDriver.driver, timeOutInSeconds);
        wait.<Boolean>until(ExpectedConditions.invisibilityOfAllElements(elements));
      } catch (final Throwable _t) {
        if (_t instanceof TimeoutException) {
          final TimeoutException timeoutex = (TimeoutException)_t;
          String errorMessage = (("After " + Integer.valueOf(timeOutInSeconds)) + "ms, element is not hidden");
          throw timeoutex;
        } else if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        DefaultWebDriver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Wait for an element to be Hidden/ Not Visible
   * @param element WebElement
   */
  public static void waitToBeHidden(final WebElement element) {
    WebDriverExtensions.waitToBeHidden(element, 60);
  }
  
  /**
   * Wait for an element to contain any text
   * Checks the element.getText().length() != 0
   * @param element WebElement
   * @param timeOutInSeconds Timeout in seconds
   */
  public static void waitForAnyText(final WebElement element, final int timeOutInSeconds) {
    try {
      try {
        WebDriverWait wait = new WebDriverWait(DefaultWebDriver.driver, timeOutInSeconds);
        wait.<Boolean>until(new ExpectedCondition<Boolean>() {
          public Boolean apply(final WebDriver d) {
            int _length = element.getText().length();
            return Boolean.valueOf((_length != 0));
          }
        });
      } catch (final Throwable _t) {
        if (_t instanceof TimeoutException) {
          final TimeoutException timeoutex = (TimeoutException)_t;
          String errorMessage = (("After " + Integer.valueOf(timeOutInSeconds)) + "ms, element failed to contain any text");
          throw timeoutex;
        } else if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Wait for an element to contain given text
   * @param element WebElement
   * @param text Text to contain
   * @param timeOutInSeconds Timeout in seconds
   */
  public static void waitForContainText(final WebElement element, final String text, final long timeOutInSeconds) {
    try {
      try {
        WebDriverWait wait = new WebDriverWait(DefaultWebDriver.driver, timeOutInSeconds);
        wait.<Boolean>until(ExpectedConditions.textToBePresentInElement(element, text));
      } catch (final Throwable _t) {
        if (_t instanceof TimeoutException) {
          final TimeoutException timeoutex = (TimeoutException)_t;
          String errorMessage = ((("After " + Long.valueOf(timeOutInSeconds)) + "ms, element failed to contain given text: ") + text);
          throw timeoutex;
        } else if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Get text value list of List<WebElement>
   * @param elements List<WebElement> WebElement List
   * @return list of text values in the element list
   */
  public List<String> getTextList(final List<WebElement> elements) {
    ArrayList<String> textList = CollectionLiterals.<String>newArrayList();
    String elementText = "";
    try {
      for (final WebElement e : elements) {
        {
          elementText = e.getText().trim();
          textList.add(elementText);
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return textList;
  }
  
  /**
   * Get WebElement containing the given text
   * @param elements List<WebElement> WebElement List
   * @param text Text
   * @return WebElement with the given text
   */
  public WebElement getElementByPartialText(final List<WebElement> elements, final String text) {
    String elementText = "";
    try {
      if (((elements != null) && (elements.size() > 0))) {
        for (final WebElement e : elements) {
          {
            elementText = e.getText().trim();
            boolean _contains = elementText.contains(text);
            if (_contains) {
              return e;
            }
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return null;
  }
  
  /**
   * Get WebElement matching exact given text
   * @param elements List<WebElement> WebElement List
   * @param text Text
   * @return WebElement with the given text
   */
  public WebElement getElementByText(final List<WebElement> elements, final String text) {
    WebElement element = null;
    String elementText = "";
    try {
      if (((!Objects.equal(elements, null)) && (elements.size() > 0))) {
        for (final WebElement e : elements) {
          {
            elementText = e.getText().trim();
            boolean _equals = Objects.equal(elementText, text);
            if (_equals) {
              element = e;
              return e;
            }
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return element;
  }
  
  /**
   * Click on element matching exact given text
   * @param elements List<WebElement> WebElement List
   * @param text Text
   */
  public void rightClick(final WebElement element) {
    try {
      Actions action = new Actions(DefaultWebDriver.driver).contextClick(element);
      action.build().perform();
      System.out.println("Sucessfully Right clicked on the element");
    } catch (final Throwable _t) {
      if (_t instanceof StaleElementReferenceException) {
        final StaleElementReferenceException e = (StaleElementReferenceException)_t;
        StackTraceElement[] _stackTrace = e.getStackTrace();
        String _plus = ("Element is not attached to the page document " + _stackTrace);
        System.out.println(_plus);
      } else if (_t instanceof NoSuchElementException) {
        final NoSuchElementException e_1 = (NoSuchElementException)_t;
        StackTraceElement[] _stackTrace_1 = e_1.getStackTrace();
        String _plus_1 = ((("Element " + element) + " was not found in DOM ") + _stackTrace_1);
        System.out.println(_plus_1);
      } else if (_t instanceof Exception) {
        final Exception e_2 = (Exception)_t;
        StackTraceElement[] _stackTrace_2 = e_2.getStackTrace();
        String _plus_2 = ((("Element " + element) + " was not clickable ") + _stackTrace_2);
        System.out.println(_plus_2);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void rightClick(final WebElement element, final Boolean relatedStatus, final String option) {
    try {
      Actions action = new Actions(DefaultWebDriver.driver).contextClick(element);
      action.build().perform();
      if ((relatedStatus).booleanValue()) {
        String related = "//a[text()=\'Related\']";
        DefaultWebDriver.driver.findElement(By.xpath(related)).click();
        Thread.sleep(1000);
        String dropDownOption = (("//a//*[contains(text(), \'" + option) + "\')]");
        System.out.println(("Element is " + dropDownOption));
        DefaultWebDriver.driver.findElement(By.xpath(dropDownOption)).click();
        System.out.println(("Element clicked " + option));
      } else {
        String dropDownOption_1 = (("//a//*[contains(text(), \'" + option) + "\')]");
        System.out.println(("Element is " + dropDownOption_1));
        DefaultWebDriver.driver.findElement(By.xpath(dropDownOption_1)).click();
        System.out.println(("Element clicked From the Main menue" + option));
      }
      System.out.println("Sucessfully Right clicked on the element");
    } catch (final Throwable _t) {
      if (_t instanceof StaleElementReferenceException) {
        final StaleElementReferenceException e = (StaleElementReferenceException)_t;
        StackTraceElement[] _stackTrace = e.getStackTrace();
        String _plus = ("Element is not attached to the page document " + _stackTrace);
        System.out.println(_plus);
      } else if (_t instanceof NoSuchElementException) {
        final NoSuchElementException e_1 = (NoSuchElementException)_t;
        StackTraceElement[] _stackTrace_1 = e_1.getStackTrace();
        String _plus_1 = ((("Element " + element) + " was not found in DOM ") + _stackTrace_1);
        System.out.println(_plus_1);
      } else if (_t instanceof Exception) {
        final Exception e_2 = (Exception)_t;
        StackTraceElement[] _stackTrace_2 = e_2.getStackTrace();
        String _plus_2 = ((("Element " + element) + " was not clickable ") + _stackTrace_2);
        System.out.println(_plus_2);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public static void selectFromDropdown(final WebElement element, final String text) {
    Select select = new Select(element);
    select.selectByVisibleText(text);
  }
  
  public void selectFromDropdown(final WebElement btn, final List<WebElement> optionsList, final String text) {
    btn.click();
    WebElement matchingElement = this.getElementByPartialText(optionsList, text);
    matchingElement.click();
  }
  
  public static String GetTextBoxvalue(final WebElement element) {
    return element.getAttribute("value");
  }
  
  public static void clearRobustly(final WebElement element) {
    try {
      element.clear();
      int _length = WebDriverExtensions.GetTextBoxvalue(element).trim().length();
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
  
  public static void pressEnterKey(final WebElement element) {
    element.sendKeys(Keys.ENTER);
  }
  
  /**
   * SendKeys on element with the given text
   * @param element WebElement
   * @param text Text to contain
   */
  public static void EnterText(final WebElement element, final String text) {
    WebDriverExtensions.waitToBeClickable(element);
    element.click();
    WebDriverExtensions.clearRobustly(element);
    element.sendKeys(text);
  }
}
