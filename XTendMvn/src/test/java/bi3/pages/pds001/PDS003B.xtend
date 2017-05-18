package bi3.pages.pds001

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import org.openqa.selenium.StaleElementReferenceException

class PDS003B extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WNOTYP")
	WebElement txtStp;
	
	@FindBy(id="WNFTID")
	WebElement txtSelectionId;
	
	@FindBy(id="WNOPTN")
	WebElement txtOption;
	
	@FindBy(id="POS")
	WebElement txtFeature;
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	@FindBy(id="BTN_L52T24")
	WebElement btnSelect;
	
	def void setstp(String stp)
	{
		waitForLoadingComplete();
		txtStp.clearRobustly();
		txtStp.sendKeys(stp);
		
	}
	
	def void setSelectId(String Id)
	{
		waitForLoadingComplete();
		txtSelectionId.clearRobustly();
		txtSelectionId.sendKeys(Keys.F4);
		waitForLoadingComplete();
		txtFeature.sendKeys(Id);
		txtFeature.sendKeys(Keys.ENTER);
		try
		{
			gridFirstLine.click();
		
		}
		catch(StaleElementReferenceException ex)
		{
			Thread.sleep(2000);
			waitToBeDisplayed(gridFirstLine);
			gridFirstLine.click();
		}
		btnSelect.click();
		
	}
	
	def void setOption(String option)
	{
		waitForLoadingComplete();
		txtOption.clearRobustly();
		txtOption.sendKeys(Keys.F4);
		waitForLoadingComplete();
		txtOption.sendKeys(option);
		txtOption.sendKeys(Keys.ENTER);
		gridFirstLine.click();
		btnSelect.click();
	}
}