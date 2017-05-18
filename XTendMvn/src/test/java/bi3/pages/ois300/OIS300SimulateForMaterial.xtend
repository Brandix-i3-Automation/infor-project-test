package bi3.pages.ois300

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys
import bi3.pages.BasePage
import java.util.List

class OIS300SimulateForMaterial extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(linkText="Related")
	WebElement linkRelated;
	
	@FindBy(xpath="//a/span[contains(text(),'Material Plan')]")
	WebElement linkMaterialPlan;
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	def void goToMaterialPlan()
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
