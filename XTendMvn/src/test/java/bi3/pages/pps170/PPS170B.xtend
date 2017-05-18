package bi3.pages.pps170

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager
import java.util.List
import org.openqa.selenium.Keys
import bi3.framework.elements.inforelements.InforGrid

class PPS170B extends BasePage{
	new(WebDriver driver) {
		super(driver)
	}
	
	/*
	 * PAGE OBJECTS
	 * 
	 */
	@FindBy(id="WWQTTP-shdo") 
	WebElement cmbSortingOrder;
	
	@FindBy(css="ul#dropdown-list li") 
	List<WebElement> listSortingOrder;
	
	@FindBy(id="WOPAVR-shdo") 
	WebElement cmbView;
	
	@FindBy(css="ul#dropdown-list li") 
	List<WebElement> listView;
	
	@FindBy(id="W1OBKV") 
	WebElement txtBoxbuyer;
	
	@FindBy(id="W3OBKV") 
	WebElement txtWhs;
	
	@FindBy(id="W2OBKV") 
	WebElement txtSupplier;
	
	@FindBy(id="W4OBKV") 
	WebElement txtItemNumber;
	
	@FindBy(css="div[id*='PPA170BS'][class*='inforDataGrid']") 
	WebElement gridPPS170;
	
	
	 /*
	  *  ACTIONS
	  * 
	  */
	 
	 def void fillHeaderInformation(){	
	 	selectFromDropdown(cmbSortingOrder,"1-Buy,Sup,Whs,Ite")	 	
	 }
	 
	 def void fillTableHeaderInformation(String buyer, String supplier, String whs, String itemNo) {
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(gridPPS170);
		grid.setValueToColumnSearchField("Buyer", buyer);
		grid.setValueToColumnSearchField("Supplier", supplier);
		grid.setValueToColumnSearchField("Whs", whs);
		grid.setValueToColumnSearchField("Item number", itemNo).sendKeys(Keys.ENTER);
	}
	 
	 /**
	  * Set filter options
	  */
	 def void setFilterOptions(String sortingOrder, String view) {
		waitForLoadingComplete()	 	
		if (sortingOrder != "") {
			selectFromDropdown(cmbSortingOrder, listSortingOrder, sortingOrder);
			waitForLoadingComplete();
		}
		if (view != "") {
			selectFromDropdown(cmbView, listView, view);
			waitForLoadingComplete();
		}
	}
	
	/**
	 * Release purchase order
	 */
	def void releaseLine(String itemNumber){
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(gridPPS170);
		var WebElement matchingCell = grid.getCell("Item number",itemNumber);
		matchingCell.rightClick(true,"Release Line");
		waitForLoadingComplete();
	}
	
	/**
	 * Check whether POP exist in PPS170
	 */
	
	def List<String> getItemNumberFromGrid(){
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(gridPPS170);
		var List<String> dataList = grid.getDataOfColumn("Item number");
		waitForLoadingComplete();	
		System.out.println(dataList);	
		return dataList;
	}
}















