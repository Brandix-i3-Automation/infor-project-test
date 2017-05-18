package bi3.pages.mms080;

import bi3.framework.elements.inforelements.InforGrid;
import bi3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@SuppressWarnings("all")
public class MMS080_B1 extends BasePage {
  public MMS080_B1(final WebDriver driver) {
    super(driver);
  }
  
  /**
   * PAGE OBJECTS
   */
  @FindBy(id = "WWITNO")
  private WebElement txtBoxItemNo;
  
  @FindBy(id = "div[id*=\'MMA080B1\']")
  private WebElement grid;
  
  @FindBy(css = "div[class=\'slick-cell l4 r4  alignRight uppercase selected\']")
  private WebElement assertNumber;
  
  /**
   * ACTIONS ( TEST METHODS )
   */
  public void fillPageMMS080_B1(final String itemNo, final String PIdt, final String ATPcum) {
    BasePage.waitForLoadingComplete();
    this.txtBoxItemNo.click();
    this.txtBoxItemNo.sendKeys();
    this.txtBoxItemNo.click();
    InforGrid InforGrid = new bi3.framework.elements.inforelements.InforGrid(this.grid);
    Assert.assertEquals(this.assertNumber.getText(), "999999999");
  }
}
