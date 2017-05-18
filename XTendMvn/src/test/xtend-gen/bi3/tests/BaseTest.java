package bi3.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@SuppressWarnings("all")
public class BaseTest {
  public static WebDriver driver;
  
  @BeforeMethod
  public void BeforeTest() {
    System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    ChromeDriver _chromeDriver = new ChromeDriver(options);
    BaseTest.driver = _chromeDriver;
  }
  
  @AfterMethod
  public void AfterTest() {
  }
}
