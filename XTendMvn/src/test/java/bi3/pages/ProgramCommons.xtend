package bi3.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

/**
 * This class contains elements and methods which are common to all programs in M3
 * @author rasithae
 */
class ProgramCommons extends ToolbarPage {

	new(WebDriver driver) {
		super(driver)
	}

	@FindBy(css="div.lawsonMessageBar .inforLabel")
	public WebElement lblFooterMessage;

	@FindBy(id="showProgramShortName")
	public WebElement lblFooterProgramShortName;

	@FindBy(id="cmpDivInfo")
	public WebElement lblFooterCompanyInfo;
	
}
