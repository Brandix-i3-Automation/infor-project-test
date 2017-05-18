package bi3.pages.pms100

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class PMS100 extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[class='tabTitle'][title]")
	WebElement pageTitle
	
	@FindBy(id="W1OBKV")
	WebElement txtSchedNo
	
	@FindBy(id="W2OBKV")
	WebElement txtProdNo
	
	@FindBy(id="W3OBKV")
	WebElement txtMoNo
	
	@FindBy(css="div[row='0']>div.l0.r0")
	WebElement schedNoRow1
	
	@FindBy(css="div[row='0']>div.l2.r2")
	WebElement prodNoRow1
	
	@FindBy(css="div[row='0']>div.l4.r4")
	WebElement MONoRow1
	
	def String getScedNoOfRow1(){
		waitToBeDisplayed(schedNoRow1)
		return schedNoRow1.text;
	}
	
	def String getProdNoOfRow1(){
		waitToBeDisplayed(prodNoRow1)
		return prodNoRow1.text;
	}
	
	def String getpageTitle(){
		waitForLoadingComplete()
		return pageTitle.text;
	}
	
	def void setSchedNo(String schedNo){
		waitForLoadingComplete();
		txtSchedNo.click();
		txtSchedNo.clearRobustly();
		txtSchedNo.sendKeys(schedNo);
	}
	
	def void setProdNo(String prodNo){
		waitForLoadingComplete();
		txtProdNo.click();
		txtProdNo.clearRobustly();
		txtProdNo.sendKeys(prodNo);
	}
	
	def void clearMONoText(){
		waitForLoadingComplete();
		txtMoNo.click();
		txtMoNo.clearRobustly();
	}	
	
	def void searchMOBy(String schedNo,String prodNo){
		setSchedNo(schedNo)
		txtSchedNo.sendKeys(Keys.ENTER)
		//setProdNo(prodNo)
		//txtProdNo.sendKeys(Keys.ENTER)
		
		waitForLoadingComplete()
	}
}