package bi3.pages.pps310

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.security.Key
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid

class PPS310B1 extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(id="WWREPN")
	WebElement txtRecivingNo;
	
	@FindBy(id="WWREPN")
	WebElement btnApply
	
	@FindBy(id="div[id*='PPA310BS'][class*='inforDataGrid']")
	WebElement inforGridPPS310;
	
	@FindBy(css="button[class='inforIconButton edit']")
	WebElement btnEdit;
	
	@FindBy(css="div[class='slick-cell l0 r0  alignRight']")
	WebElement firstGridCell
	
	def void enterTheRecivingNo(String recivingNo)
	{
		waitForLoadingComplete();
		txtRecivingNo.waitToBeClickable()
		txtRecivingNo.click()
		txtRecivingNo.clearRobustly();
		txtRecivingNo.sendKeys(recivingNo);
		txtRecivingNo.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}
	
	def void editFirstRecord()
	{
		waitToBeClickable(firstGridCell)
		firstGridCell.click();
		btnEdit.click();
		waitForLoadingComplete();
		
	}
	
	def void clickApply(){
		waitToBeClickable(btnApply)
		btnApply.click()
		waitForLoadingComplete()
	}
}