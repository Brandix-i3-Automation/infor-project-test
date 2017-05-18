package bi3.pages.ois300

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class OIS300Availability extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(xpath="//a/span[contains(text(),'Material Plan')]")
	WebElement linkMaterialPlan;
	
	@FindBy(linkText="Related")
	WebElement linkRelated;
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	def void goToMaterilaPlan()
	{
		waitForLoadingComplete();
		rightClick(gridFirstLine);
		
		waitToBeClickable(linkRelated);
		linkRelated.click();
		
		waitToBeClickable(linkMaterialPlan);
		linkMaterialPlan.click();
		
		waitForLoadingComplete();
	}
	
}