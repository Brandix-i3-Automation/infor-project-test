package bi3.pages.ois390;

import bi3.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("all")
public class OIS390B1 extends BasePage {
  public OIS390B1(final WebDriver driver) {
    super(driver);
  }
  
  @FindBy(id = "Next")
  private WebElement btnNext;
  
  @FindBy(css = ".slick-cell.l1.r1")
  private WebElement firstGridCell;
  
  @FindBy(css = "#W1REPN")
  private WebElement txtRecvngNo;
  
  public void selectFirstRows() {
    BasePage.waitForLoadingComplete();
    this.firstGridCell.click();
    BasePage.waitForLoadingComplete();
  }
  
  public void enterRecvnNo(final String recvnNo) {
    BasePage.waitForLoadingComplete();
    BasePage.clearRobustly(this.txtRecvngNo);
    this.txtRecvngNo.sendKeys(recvnNo);
    this.txtRecvngNo.sendKeys(Keys.ENTER);
    BasePage.waitForLoadingComplete();
  }
}
