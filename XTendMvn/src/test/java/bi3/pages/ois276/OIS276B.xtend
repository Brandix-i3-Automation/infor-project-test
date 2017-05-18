package bi3.pages.ois276

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import bi3.framework.elements.inforelements.InforGrid

class OIS276B extends BasePage {
	
	new(WebDriver driver) {
		super(driver)
	}
	
	@FindBy(css="div[id*='OIA276BS'][class*='inforDataGrid']") 
	WebElement gridElement;

	@FindBy(linkText = "Related")
    WebElement linkRelated;
    
    @FindBy(xpath="//div[@class='inforMenu submenu']/ul/li/a/span[contains(text(),'Check/release')]")
    WebElement linkRelease;

	@FindBy(id="dbtnok")
	WebElement btnOk
	
	@FindBy(id="OAORNO")
	WebElement txtCoNumber
	
	@FindBy(css="#tabsList > li.ui-tabs-selected.ui-state-active > button")
	WebElement btnClose
	
	@FindBy(id="Prev")
	WebElement btnPrev;
	
	def void Release(){
		waitForLoadingComplete()
		var InforGrid grid= new InforGrid(gridElement);
		grid.getRow(0).click();
//		linkRelated.click();	
//		linkRelease.click();
		waitForLoadingComplete();
		
	}
	def String CopyCoNumber(String CoNumber){
		return txtCoNumber.text	
		
	}
	
	def String CopyCONumber()
	{
		waitForLoadingComplete();
		val CONumber = txtCoNumber.GetTextBoxvalue();
		System.out.println(CONumber);
		return CONumber;
	}
	
	def void ClickWarningOkButton(){
		waitForLoadingComplete();
		btnOk.click();
		
	}
	def close() {
		btnClose.click()
		System.out.println("OIS276B tab closed")
	}
	
		def void ClickPreviousPage(){
		waitForLoadingComplete()
		//waitToBeClickable(btnPrev);
	    btnPrev.click()
		waitForLoadingComplete()
		
	}
}