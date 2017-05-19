package bi3.framework.core

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import java.util.concurrent.TimeoutException
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import java.util.List
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.NoSuchElementException
import java.util.concurrent.TimeUnit
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.Keys
import org.openqa.selenium.By

class WebDriverExtensions extends DefaultWebDriver {


	//
	/**
	 * Wait for an element to be Displayed
	 * @param element WebElement
	 * @param timeoutInSeconds Timeout in seconds
	 */
	def static void waitToBeDisplayed(WebElement element, int timeoutInSeconds) {
		try {
			var wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException timeoutex) {
			var errorMessage = "After " + timeoutInSeconds + "ms, failed to display element ";
		// logger.error(errorMessage);
		} catch (Exception ex) {
			// logger.error("Error in waitToBeDisplayed: " + ex.getMessage());
		}
	}

	/**
	 * Wait for an element to be Displayed
	 * @param element WebElement
	 */
	def static void waitToBeDisplayed(WebElement element) {
		waitToBeDisplayed(element, 60);
	// TODO Get the default timeout from property file.
	}

	/**
	 * Wait for an element to be Clickable
	 * @param element WebElement
	 * @param timeOutInSeconds Timeout in seconds
	 */
	def static void waitToBeClickable(WebElement element, int timeOutInSeconds) {
		try {
			var wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException timeoutex) {
			var errorMessage = "After " + timeOutInSeconds + "ms, element failed to be clickable";
		// logger.error(errorMessage);
		} catch (Exception ex) {
			// logger.error("Error in waitToBeClickable: " + ex.getMessage());
		}
	}

	/**
	 * Wait for an element to be Clickable
	 * @param element WebElement
	 */
	def static void waitToBeClickable(WebElement element) {
		waitToBeClickable(element, 60);
	// TODO Get the default timeout from property file.
	}

	/**
	 * Wait for an element to be Hidden/ Not Visible
	 * @param element WebElement
	 * @param timeOutInSeconds Timeout in seconds
	 */
	def static void waitToBeHidden(WebElement element, int timeOutInSeconds) {
		// TODO "We might need to set the Implicit wait to 0 here - verify later" ;
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		var elements = newArrayList;
		try {
			// First add the element to a list because ExpectedConditions.invisibilityOfAllElements only accepts a list
			elements.add(element);
			var wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
		} catch (TimeoutException timeoutex) {
			var errorMessage = "After " + timeOutInSeconds + "ms, element is not hidden";
			// logger.error(errorMessage);
			throw timeoutex;
		} catch (Exception ex) {
			// logger.error("Error in waitToBeHidden: " + ex.getMessage());
		} finally {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	/**
	 * Wait for an element to be Hidden/ Not Visible
	 * @param element WebElement
	 */
	def static void waitToBeHidden(WebElement element) {
		waitToBeHidden(element, 60);
	// TODO Get the default timeout from property file.
	}

	/**
	 * Wait for an element to contain any text
	 * Checks the element.getText().length() != 0
	 * @param element WebElement
	 * @param timeOutInSeconds Timeout in seconds
	 */
	def static void waitForAnyText(WebElement element, int timeOutInSeconds) {
		try {
			var wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(new ExpectedCondition<Boolean>() {
				override Boolean apply(WebDriver d) {
					return element.getText().length() != 0;
				}
			});
		} catch (TimeoutException timeoutex) {
			var errorMessage = "After " + timeOutInSeconds + "ms, element failed to contain any text";
			// logger.error(errorMessage);
			throw timeoutex;
		} catch (Exception ex) {
			// logger.error("Error in waitForAnyText: " + ex.getMessage());
		}
	}

	/**
	 * Wait for an element to contain given text
	 * @param element WebElement
	 * @param text Text to contain
	 * @param timeOutInSeconds Timeout in seconds
	 */
	def static void waitForContainText(WebElement element, String text, long timeOutInSeconds) {
		try {
			var wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		} catch (TimeoutException timeoutex) {
			var errorMessage = "After " + timeOutInSeconds + "ms, element failed to contain given text: " + text;
			// logger.error(errorMessage);
			throw timeoutex;
		} catch (Exception ex) {
			// logger.error("Error in waitForContainText: " + ex.getMessage());
		}
	}

	// Web Element List Related Helper Functions
	/**
	 * Get text value list of List<WebElement>
	 * @param elements List<WebElement> WebElement List
	 * @return list of text values in the element list
	 */
	def List<String> getTextList(List<WebElement> elements) {
		var textList = newArrayList;
		var elementText = "";
		try {
			for (WebElement e : elements) {
				elementText = e.getText().trim();
				textList.add(elementText);
			}
		} catch (Exception ex) {
			// logger.error("Error in waitForAnyText: " + ex.getMessage());
		}
		return textList;
	}

	/**
	 * Get WebElement containing the given text
	 * @param elements List<WebElement> WebElement List
	 * @param text Text
	 * @return WebElement with the given text
	 */
	def WebElement getElementByPartialText(List<WebElement> elements, String text) {
		// logger.debug("Finding element containing text:" + text);
		// var WebElement element = null;
		var elementText = "";
		// waitToBePresent();
		try {
			if (elements !== null && elements.size() > 0) {
				for (WebElement e : elements) {
					elementText = e.getText().trim();
					if (elementText.contains(text)) {
						return e;
					}
				}
			}
		} catch (Exception ex) {
			// logger.error("Error in getElementByPartialText: " + ex.getMessage());
		}
		// logger.debug((element == null ? "Element not found" : "Found element with text: " + text) + this.toString());
		return null;
	}

	/**
	 * Get WebElement matching exact given text
	 * @param elements List<WebElement> WebElement List
	 * @param text Text
	 * @return WebElement with the given text
	 */
    def WebElement getElementByText(List<WebElement> elements, String text) {
        //logger.debug("Finding element with text:" + text);
        var WebElement element = null;
        var elementText = "";
        // waitToBePresent();
        try {
            if (elements != null && elements.size() > 0) {
                for (WebElement e : elements) {
                    elementText = e.getText().trim();
                    if (elementText == text) {
                        element = e;
                        return e;
                    }
                }
            }
        } catch (Exception ex) {
            //logger.error("Error in getElementByText: " + ex.getMessage());
        }
        //logger.debug((element == null ? "Element not found" : "Found element with text: " + text) + this.toString());
        return element;
    }
//
//    /**
//     * Click on element which contains given text
//     * @param elements List<WebElement> WebElement List
//     * @param text Text
//     */
//    def void clickElementContainingText(List<WebElement> elements, String text) {
//        WebElement element = null;
//        // waitToBePresent();
//        try {
//            element = getElementByPartialText(elements, text);
//            //logger.debug((element == null ? "Element not found" : "Found element with text: " + text
//                    +" Clicking on Element"));
//            if(element != null){
//                waitToBeDisplayed(element);
//                element.click();
//            }
//        }
//        catch (Exception ex){
//            //logger.error("Error in clickElementContainingText: " + ex.getMessage());
//            throw new TestAutomationException(ex.getMessage());
//        }
//    }
	/**
	 * Click on element matching exact given text
	 * @param elements List<WebElement> WebElement List
	 * @param text Text
	 */
//    def void clickElementWithExactText(List<WebElement> elements, String text) {
//        WebElement element = null;
//        // waitToBePresent();
//        try {
//            element = getElementByText(elements, text);
//            //logger.debug((element == null ? "Element not found" : "Found element with text: " + text
//                    +" Clicking on Element"));
//            if(element != null){
//                waitToBeDisplayed(element);
//                element.click();
//            }
//        }
//        catch (Exception ex){
//            //logger.error("Error in clickElementWithExactText: " + ex.getMessage());
//            throw new TestAutomationException(ex.getMessage());
//        }
//    }
	def void rightClick(WebElement element) {
		try {
			var Actions action = new Actions(driver).contextClick(element);
			action.build().perform();
			System.out.println("Sucessfully Right clicked on the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
		}
	}

	// Right click and Navigate to Related
	def void rightClick(WebElement element , Boolean relatedStatus, String option ) {
		try {
			var Actions action = new Actions(driver).contextClick(element);
			action.build().perform();		
			
			//var String dropDownOption = "//div[contains(text(),'"+option+"')]";
			
			if(relatedStatus){	
				var String related = "//a[text()='Related']";
				driver.findElement(By.xpath(related)).click
				Thread.sleep(1000);
				
				//clicks the parameter ralate value
				var String dropDownOption = "//a//*[contains(text(), '"+option+"')]";
				System.out.println("Element is "+dropDownOption)
				driver.findElement(By.xpath(dropDownOption)).click
										
				System.out.println("Element clicked " + option)
				
				}
				else{
//					
				var String dropDownOption = "//a//*[contains(text(), '"+option+"')]";
				System.out.println("Element is "+dropDownOption)
				driver.findElement(By.xpath(dropDownOption)).click										
				System.out.println("Element clicked From the Main menue" + option)
			}

			System.out.println("Sucessfully Right clicked on the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
		}
	}
	
	def static selectFromDropdown(WebElement element, String text) {
		var select = new Select(element);
		select.selectByVisibleText(text);
	}

	def void selectFromDropdown(WebElement btn, List<WebElement> optionsList, String text) {
		btn.click();
		var matchingElement = getElementByPartialText(optionsList, text);
		matchingElement.click();
	}

	def static String GetTextBoxvalue(WebElement element) {
		return element.getAttribute("value");
	}

	def static clearRobustly(WebElement element) {
		try {
			element.clear();
			
			// Clear robustly
			if (element.GetTextBoxvalue().trim().length() != 0) {				
				element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				element.sendKeys(Keys.chord(Keys.DELETE));
			}
			//System.out.println("Sucessfully cleared the element");
		} catch (Exception e) {
			System.out.println("Element " + element + " cannot be cleared " + e.getStackTrace());
		}
	}
	
	def static void pressEnterKey(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}
	/**
	 * SendKeys on element with the given text
	 * @param element WebElement
	 * @param text Text to contain
	 */
	def static void EnterText(WebElement element,String text){
		
		element.waitToBeClickable();
		element.click();
		element.clearRobustly();
		element.sendKeys(text);
		
	}
	
}
