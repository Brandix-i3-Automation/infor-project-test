package bi3.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys
import org.openqa.selenium.By

class ToolbarPage extends BasePage {

	new(WebDriver driver) { // Constructor
		super(driver)
	}
	
	
	 
	/*
	 * 
	 * Page Objects
	   List Elements in Action Tabs
	 * 
	 * 
	 */

	/*MAIN ELEMENTS ON TOP */
	@FindBy(id = "ActionsBtn")
    public WebElement btnActionBtn;
    
    @FindBy(id = "OptionsBtn")
    public WebElement btnOptionBtn;
    
    @FindBy(id = "RelatedBtn")
    public WebElement btnRelatedBtn;
    
    @FindBy(id = "ToolsBtn")
    public WebElement btnToolsBtn;
    
    /*Logo Buttons 
     * 
     * ( some elements are commented until assigning a suitable name for elements )
     * */
    @FindBy(css = "div[class=cmdBarLeft2] button:nth-child(1)")
    WebElement btnCreateLogo;
    
    @FindBy(css = "div[class=cmdBarLeft2] button:nth-child(2)")
    WebElement btnSelectLogo;
    
    @FindBy(css = "div[class=cmdBarLeft2] button:nth-child(3)")
    WebElement btnChangeLogo;
    
//    @FindBy(css = "div[class=cmdBarLeft2] button:nth-child(4)")
//    WebElement btnCreate;
//    
//    @FindBy(css = "div[class=cmdBarLeft2] button:nth-child(5)")
//    WebElement btnCreate;
    
    @FindBy(css = "div[class=cmdBarLeft2] button:nth-child(6)")
    WebElement btnDisplayLogo;
    
//    @FindBy(css = "div[class=cmdBarLeft2] button:nth-child(7)")
//    WebElement btnCreate;
//    
//    @FindBy(css = "div[class=cmdBarLeft2] button:nth-child(8)")
//    WebElement btnCreate;
    
    @FindBy(id = "pSeqBtn")
    WebElement btnPanelNavigatorLogo;
    
    @FindBy(id = "qn")
    WebElement btnQuickNote;
    
    @FindBy(id = "helpIcon")
    WebElement btnHelpLogo;
    
    @FindBy(id = "toolBoxBtnCont")
    WebElement btnExpandToolbox;
     
    /*Logo Button Ends */
    
    
    
    /*ELEMENTS INSIDE DROPDOWNS */
    
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Settings')]")
    WebElement btnSettings;
    
      @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Update')]")
    WebElement btnUpdate;
    
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Retrieve')]")
    WebElement btnRetrieve;
     
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Browse')]")
    WebElement btnBrowse;
    
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Field Help')]")
    WebElement btnFieldHelp;
    
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Refresh')]")
    WebElement btnRefresh;
    
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Cancel')]")
    WebElement btnCancel;
    
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Select all')]")
    WebElement btnSelectAll;
    
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Confirm All')]")
    WebElement btnConfirmAll;
    
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Close')]")
    WebElement btnClose;
    
    /*
     * List Elements in Options Tab
     * 
     * 
     */
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Select')]]")
    WebElement btnSelect;
    
    @FindBy(xpath="//a[contains(text(),'Change')]")
    WebElement btnChange;
    
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Copy')]]")
    WebElement btnCopy;
    
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Delete')]]")
    WebElement btnDelete;
    
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Display')]]")
    WebElement btnDisplay;
    
    @FindBy(xpath="//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'Copy to Clipboard')]]")
    WebElement btnCopyToClipBoard;

    
    /*
     * 
     * Page Actions FOR ACTION TAB
     * 
     */
     
	def void ClickAction() {
		waitForLoadingComplete();
		btnActionBtn.click()
	}
	
	def void ClickOption() {
		waitToBeClickable(btnOptionBtn)
		btnOptionBtn.click()
	}
	
	def void ClickAction_Settings() {
		waitToBeClickable(btnActionBtn)
		Thread.sleep(3000);
		btnActionBtn.click()
		waitForLoadingComplete()
		btnSettings.click()	
	}
	
		def void ClickAction_Update() {
		waitToBeClickable(btnActionBtn)
		Thread.sleep(3000);
		btnActionBtn.click()
		waitForLoadingComplete()
		btnUpdate.waitToBeClickable()
		btnUpdate.click()	
	}
	
		def void ClickAction_Retrieve() {
		waitToBeClickable(btnActionBtn)
		Thread.sleep(3000);
		btnActionBtn.click()
		waitForLoadingComplete()
		btnRetrieve.click()	
	}
	
	def void ClickAction_Browse() {
		waitToBeClickable(btnActionBtn)
		btnActionBtn.click()
		waitForLoadingComplete()
		btnBrowse.click()	
	}
	def void ClickAction_FieldHelp() {
		waitToBeClickable(btnActionBtn)
		btnActionBtn.click()
		waitForLoadingComplete()
		btnFieldHelp.click()	
	}
	def void ClickAction_Refresh() {
		waitToBeClickable(btnActionBtn)
		btnActionBtn.click()
		waitForLoadingComplete()
		btnRefresh.click()	
	}
	def void ClickAction_Cancel() {
		waitToBeClickable(btnActionBtn)
		btnActionBtn.click()
		waitForLoadingComplete()
		btnCancel.click()	
	}
	
	def void ClickAction_SelectAll() {
		waitToBeClickable(btnActionBtn)
		btnActionBtn.click()
		waitForLoadingComplete()
		btnSelectAll.click()	
	}
	
	def void ClickAction_Close() {
		waitToBeClickable(btnActionBtn)
		btnActionBtn.click()
		waitForLoadingComplete()
		btnClose.click()	
	}
	
	def void ClickAction_ConfirmAll() {
		waitToBeClickable(btnActionBtn)
		btnActionBtn.click()
		waitForLoadingComplete()
		btnConfirmAll.waitToBeClickable()
		btnConfirmAll.click()
		waitForLoadingComplete()	
	}
	
	/*
	 * Page Actions FOR OPTIONS TAB
	 * 
	 */
	 
	def void ClickOption_Select() {
		waitToBeClickable(btnOptionBtn)
		btnOptionBtn.click()
		waitForLoadingComplete()
		btnSelect.click()	
	}
	
	def void ClickOption_Change() {
		waitToBeClickable(btnOptionBtn)
		btnOptionBtn.click()
		waitForLoadingComplete()
		btnChange.click()	
	}
	
	def void ClickOption_Copy() {
		waitToBeClickable(btnOptionBtn)
		btnOptionBtn.click()
		waitForLoadingComplete()
		btnCopy.click()	
	}
	
	def void ClickOption_Delete() {
		waitToBeClickable(btnOptionBtn)
		btnOptionBtn.click()
		waitForLoadingComplete()
		btnDelete.click()	
	}
	
	def void ClickOption_Display() {
		waitToBeClickable(btnOptionBtn)
		btnOptionBtn.click()
		waitForLoadingComplete()
		btnDisplay.click()	
	}
	
	def void ClickOption_CopyToClipboard() {
		waitToBeClickable(btnOptionBtn)
		btnOptionBtn.click()
		waitForLoadingComplete()
		btnCopyToClipBoard.click()	
	}
	
	/*
	 * Page actions for RELATED  TOOLS 
	 * 
	 */
	 
	 def WebElement findElementInRelated(String DropDownElement){
	 	var element = "//ul[@class='inforContextMenu inforMenuOptions']//li/a[contains(text(),'"+DropDownElement+"')]"
	 	return driver.findElement(By.xpath(element))
	 }
	 
	 
	 def WebElement findElementInTools(String DropDownElement){
	 	var element = "//ul[@class='inforContextMenu ToolsMenu inforMenuOptions']//li/a[contains(text(),'"+DropDownElement+"')]"
	 	return driver.findElement(By.xpath(element))
	 }
	 
	 def void clickRelated(String DropDownElement){
	 	waitToBeClickable(btnRelatedBtn)
	 	btnRelatedBtn.click()
	 	waitForLoadingComplete()
	 	findElementInRelated(DropDownElement).click()
	 }
	 
	  def void clickTools(String DropDownElement){
	  	waitToBeClickable(btnToolsBtn)
	 	btnToolsBtn.click()
	 	waitForLoadingComplete()
	 	findElementInTools(DropDownElement).click()
	 }
	 
	 /*
	  * 
	  * Actions to click LOGO's
	  * 
	  */
	def void clickCreateLogo(){
		waitToBeClickable(btnCreateLogo)
		btnCreateLogo.click()
		waitForLoadingComplete()
	}
	
	def void clickSelectLogo(){
		waitToBeClickable(btnSelectLogo)
		btnSelectLogo.click()
		waitForLoadingComplete()
	}
	
	def void clickChangeLogo(){
		waitToBeClickable(btnChangeLogo)
		btnChangeLogo.click()
		waitForLoadingComplete()
	}
	
	def void clickDisplayLogo(){
		waitToBeClickable(btnDisplayLogo)
		btnDisplayLogo.click()
		waitForLoadingComplete()
	}
	
	def void clickPanelNavigatorLogo(){
		waitToBeClickable(btnPanelNavigatorLogo)
		btnPanelNavigatorLogo.click()
		waitForLoadingComplete()
	}
	
	def void clickHelpLogo(){
		 waitToBeClickable(btnHelpLogo)
		btnHelpLogo.click()
		waitForLoadingComplete()
	}
	
	def void clickExpandToolboxLogo(){
		waitToBeClickable(btnExpandToolbox)
		btnExpandToolbox.click()
		waitForLoadingComplete()
	}
}