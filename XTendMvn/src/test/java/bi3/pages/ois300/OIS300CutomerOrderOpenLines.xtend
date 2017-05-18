package bi3.pages.ois300

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys
import bi3.pages.BasePage
import java.util.List

class OIS300CutomerOrderOpenLines extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(linkText="Related")
	WebElement linkRelated;
	
	@FindBy(xpath="//a/span[contains(text(),'Sim comp avail')]")
	WebElement linkSimCompAvail;
	
	@FindBy(css=".slick-cell.l0.r0")
	WebElement gridFirstLine;
	
	def void goToSimCopAvail()
	{
		waitForLoadingComplete();
		rightClick(gridFirstLine);
		
		waitToBeClickable(linkRelated);
		linkRelated.click();
		
		waitToBeClickable(linkSimCompAvail);
		linkSimCompAvail.click();
		
		waitForLoadingComplete();
	}
	
	
}
