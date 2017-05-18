package bi3.pages.pps320

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid

class PPS320B1 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(id="WWREPN")
	WebElement txtReceivingNo;
	
	@FindBy(css="button[class='inforIconButton edit']")
	WebElement btnEdit;
	
	@FindBy(css="div[id*='PPA320BS'][class*='inforDataGrid']")
	WebElement inforGridPPS320;
	
	@FindBy(id = "XT_0168")
	WebElement btnApply
	
	@FindBy(css = "div[class='slick-cell l0 r0  alignRight']")
	WebElement firstGridCell
	
	
	def void enterTheRecivingNo(String recivingNo)
	{
		waitForLoadingComplete();
		txtReceivingNo.clearRobustly();
		txtReceivingNo.sendKeys(recivingNo);
		txtReceivingNo.sendKeys(Keys.ENTER);
		waitForLoadingComplete();
	}
	def void editFirstRow()
	{
		waitToBeClickable(firstGridCell)
		firstGridCell.click()
		btnEdit.click();
		waitForLoadingComplete();
		
	}
	
	def void clickApply(){
		waitToBeClickable(btnApply)
		btnApply.click()
		waitForLoadingComplete()
	}
}