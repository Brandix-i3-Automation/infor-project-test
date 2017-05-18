package bi3.pages.pps600

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.pages.ProgramCommons

class PPS600SelectMedia extends ProgramCommons {
	
	new(WebDriver driver) {
		super(driver)
	}
	@FindBy(id="WCN1915")
	WebElement btnConfirmOutput;
	
	def void ConfirmOutput() {
		var String warningMsg = "";
		waitForLoadingComplete();
		do {
			btnConfirmOutput.click();
			waitForLoadingComplete();

			warningMsg = lblFooterMessage.text;
		} while (!warningMsg.contains("Job PPS601CL has been submitted"))
	}
}