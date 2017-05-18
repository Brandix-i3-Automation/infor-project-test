package bi3.pages;

import bi3.pages.ToolbarPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains elements and methods which are common to all programs in M3
 * @author rasithae
 */
@SuppressWarnings("all")
public class ProgramCommons extends ToolbarPage {
  public ProgramCommons(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(css = "div.lawsonMessageBar .inforLabel")
  public WebElement lblFooterMessage;
  
  @FindBy(id = "showProgramShortName")
  public WebElement lblFooterProgramShortName;
  
  @FindBy(id = "cmpDivInfo")
  public WebElement lblFooterCompanyInfo;
}
