package bi3.pages.pps600


import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid
import org.testng.Assert
import java.util.List
import com.gargoylesoftware.htmlunit.ElementNotFoundException
import org.openqa.selenium.ElementNotVisibleException

class PPS600E extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WFPUNO")
	WebElement txtPONumberFrom;
	
	@FindBy(id="WTPUNO")
	WebElement txtPONumberTo;
	
	@FindBy(id="WTPUSL")
	WebElement txtLowestStatusTo;
	
	@FindBy(id="WTPUST")
	WebElement txtHighestStatusTo;
	
	@FindBy(id="Next")
	WebElement btnNext;
	
	def void FillPONumbers(String PONumber)
	{
		waitForLoadingComplete();
		txtPONumberFrom.click();
		txtPONumberFrom.clearRobustly();
		txtPONumberFrom.sendKeys(PONumber);
		txtPONumberTo.click();
		txtPONumberTo.clearRobustly();
		txtPONumberTo.sendKeys(PONumber);
		
	}
	
	def void FillLowestStatus(String lowestStaus)
	{
		waitForLoadingComplete();
		txtLowestStatusTo.click();
		txtLowestStatusTo.clearRobustly();
		txtLowestStatusTo.sendKeys(lowestStaus);
	}
	
	def void FillHighestStatus(String highestStatus)
	{
		waitForLoadingComplete();
		txtHighestStatusTo.click();
		txtHighestStatusTo.clearRobustly();
		txtHighestStatusTo.sendKeys(highestStatus);
	}
	
	def void clickNext()
	{
		waitForLoadingComplete()
		btnNext.click()
		waitForLoadingComplete()
	}
}