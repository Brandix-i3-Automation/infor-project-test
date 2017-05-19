package bi3.infor.templates

import bi3.infor.templates.dto.ItemTemplate
import bi3.pages.mms001.MMS001
import bi3.pages.mms001.MMS001C
import bi3.pages.mms001.MMS001E
import bi3.pages.mms001.MMS001F
import bi3.pages.mms001.MMS001G
import bi3.pages.mms001.MMS001H
import bi3.pages.mms001.MMS001I
import bi3.pages.mms001.MMS001J
import bi3.pages.mms001.MMS001K
import bi3.pages.mms001.MMS001L
import bi3.pages.mms001.MMS001M
import org.openqa.selenium.WebDriver
import org.testng.Assert

/**
 * Infor business process template class for item creation.
 * 
 * @author Niranga
 */
public class ItemCreationTemplate {

	/** WebDriver. */
	private WebDriver driver = null;

	/** Page MMS001. */
	private MMS001 mms001;
	
	/** Page MMS001C. */
	private MMS001C mms001C;
	
    /** Page MMS001E. */
	private MMS001E mms001E;
	
	/** Page MMS001F. */
	private MMS001F mms001F;
	
	/** Page MMS001G. */
	private MMS001G mms001G;
	
	/** Page MMS001H. */
	private MMS001H mms001H;
	
	/** Page MMS001I. */
	private MMS001I mms001I;
	
	/** Page MMS001J. */
	private MMS001J mms001J;
	
	/** Page MMS001K. */
	private MMS001K mms001K;
	
	/** Page MMS001L. */
	private MMS001L mms001L;
	
	/** Page MMS001M. */
	private MMS001M mms001M;

	new(WebDriver driver) {
		this.driver = driver;
		this.init();
	}
		
	/**
	 * Method init.
	 */
	private def init() {
		mms001  = new MMS001(this.driver);
		mms001C = new MMS001C(this.driver);
		mms001E = new MMS001E(this.driver);
		mms001F = new MMS001F(this.driver);
		mms001G = new MMS001G(this.driver);
		mms001H = new MMS001H(this.driver);
		mms001I = new MMS001I(this.driver);
		mms001J = new MMS001J(this.driver);
		mms001K = new MMS001K(this.driver);
		mms001L = new MMS001L(this.driver);
		mms001M = new MMS001M(this.driver);
	}

	/**
	 * Method createItem.
	 * Copy given item and complete the Item creation
	 */
	 
	 ItemTemplate ItemTemplate
	
	def ItemTemplate createItem(String itemNumber) {
		
		var boolean  methodExecutionStatus = false;
		
		try{	
			 
			ItemTemplate = new ItemTemplate();		
			mms001.SearchByItemNumber(itemNumber)
			mms001.CopyItem(itemNumber)
	
			mms001C.Next();
			mms001E.SelectInvAccounting("1-Inv accounting");
			mms001E.SelectLotCtrlMethod("3-In lot master");
			mms001E.SelectLotNumbMethod("5-Auto order no");
		    var newItemNumber = mms001E.GetItemNumber();
		    ItemTemplate.setItemCode(newItemNumber);
			mms001E.Next();
			mms001F.Next();
			mms001G.SelectSalesItem("1-Sales item");
			mms001G.Next();
			mms001H.Next();
			mms001I.Next();
			mms001J.Next();
			mms001K.Next();
			mms001M.Next();
			
			mms001.SearchByItemNumber(newItemNumber);				
	        ItemTemplate.setMethodExecutionStatus(true);	        
			Assert.assertTrue(mms001.GetItemNumberList().contains(newItemNumber),"Item number" + newItemNumber + "is not found in the grid"); //Check if item is created.		
			//List<ItemTemplate> ItemTemplate; 	
			System.out.println("ItemCreationTemplate Executed ");				 
			return ItemTemplate;
			

		
		} catch (Exception ex) {
			
			// catch the logs and logging should goes here
			throw ex;
			
		}
	}
	


	
}
