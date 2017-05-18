package bi3.pages.ois275

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import bi3.framework.elements.inforelements.InforGrid
import org.openqa.selenium.Keys
import java.lang.Thread.State

class OIS275B_1 extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	//Elements(Page Objects)
	@FindBy(id="W1OBKV")
	WebElement txtCoNumber
	
	@FindBy(css="div[id*='OIA275BS'][class*='inforDataGrid']") 
	WebElement gridElement;
	
	@FindBy(linkText = "Related")
    WebElement linkRelated;
    
    @FindBy(xpath="//div[@class='inforMenu submenu']/ul/li/a/span[contains(text(),'Check/release')]")
    WebElement linkRelease;
    
    
	
	
	def void enterTemporaryOrdrNo(String temporaryOrderNo){
		waitForLoadingComplete()
		txtCoNumber.click()
		txtCoNumber.sendKeys(temporaryOrderNo);
		txtCoNumber.sendKeys(Keys.ENTER)
		waitForLoadingComplete();
		var InforGrid grid= new InforGrid(gridElement);
		grid.getRow(0).click();
		waitForLoadingComplete();
		
	}
	
	
}