package bi3.pages.pps600;

import bi3.pages.BasePage;
import bi3.pages.ProgramCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class PPS600SelectMedia extends ProgramCommons {
  public PPS600SelectMedia(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "WCN1915")
  private WebElement btnConfirmOutput;
  
  public void ConfirmOutput() {
    String warningMsg = "";
    BasePage.waitForLoadingComplete();
    do {
      {
        this.btnConfirmOutput.click();
        BasePage.waitForLoadingComplete();
        warningMsg = this.lblFooterMessage.getText();
      }
    } while((!warningMsg.contains("Job PPS601CL has been submitted")));
  }
}
