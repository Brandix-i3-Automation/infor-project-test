package bi3.infor.templates;

import bi3.infor.templates.dto.ItemTemplate;
import bi3.pages.mms001.MMS001;
import bi3.pages.mms001.MMS001C;
import bi3.pages.mms001.MMS001E;
import bi3.pages.mms001.MMS001F;
import bi3.pages.mms001.MMS001G;
import bi3.pages.mms001.MMS001H;
import bi3.pages.mms001.MMS001I;
import bi3.pages.mms001.MMS001J;
import bi3.pages.mms001.MMS001K;
import bi3.pages.mms001.MMS001L;
import bi3.pages.mms001.MMS001M;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Infor business process template class for item creation.
 * 
 * @author Niranga
 */
@SuppressWarnings("all")
public class ItemCreationTemplate {
  /**
   * WebDriver.
   */
  private WebDriver driver = null;
  
  /**
   * Page MMS001.
   */
  private MMS001 mms001;
  
  /**
   * Page MMS001C.
   */
  private MMS001C mms001C;
  
  /**
   * Page MMS001E.
   */
  private MMS001E mms001E;
  
  /**
   * Page MMS001F.
   */
  private MMS001F mms001F;
  
  /**
   * Page MMS001G.
   */
  private MMS001G mms001G;
  
  /**
   * Page MMS001H.
   */
  private MMS001H mms001H;
  
  /**
   * Page MMS001I.
   */
  private MMS001I mms001I;
  
  /**
   * Page MMS001J.
   */
  private MMS001J mms001J;
  
  /**
   * Page MMS001K.
   */
  private MMS001K mms001K;
  
  /**
   * Page MMS001L.
   */
  private MMS001L mms001L;
  
  /**
   * Page MMS001M.
   */
  private MMS001M mms001M;
  
  public ItemCreationTemplate(final WebDriver driver) {
    this.driver = driver;
    this.init();
  }
  
  /**
   * Method init.
   */
  private MMS001M init() {
    MMS001M _xblockexpression = null;
    {
      MMS001 _mMS001 = new MMS001(this.driver);
      this.mms001 = _mMS001;
      MMS001C _mMS001C = new MMS001C(this.driver);
      this.mms001C = _mMS001C;
      MMS001E _mMS001E = new MMS001E(this.driver);
      this.mms001E = _mMS001E;
      MMS001F _mMS001F = new MMS001F(this.driver);
      this.mms001F = _mMS001F;
      MMS001G _mMS001G = new MMS001G(this.driver);
      this.mms001G = _mMS001G;
      MMS001H _mMS001H = new MMS001H(this.driver);
      this.mms001H = _mMS001H;
      MMS001I _mMS001I = new MMS001I(this.driver);
      this.mms001I = _mMS001I;
      MMS001J _mMS001J = new MMS001J(this.driver);
      this.mms001J = _mMS001J;
      MMS001K _mMS001K = new MMS001K(this.driver);
      this.mms001K = _mMS001K;
      MMS001L _mMS001L = new MMS001L(this.driver);
      this.mms001L = _mMS001L;
      MMS001M _mMS001M = new MMS001M(this.driver);
      _xblockexpression = this.mms001M = _mMS001M;
    }
    return _xblockexpression;
  }
  
  /**
   * Method createItem.
   * Copy given item and complete the Item creation
   */
  private ItemTemplate ItemTemplate;
  
  public ItemTemplate createItem(final String itemNumber) {
    try {
      boolean methodExecutionStatus = false;
      try {
        ItemTemplate _itemTemplate = new ItemTemplate();
        this.ItemTemplate = _itemTemplate;
        this.mms001.SearchByItemNumber(itemNumber);
        this.mms001.CopyItem(itemNumber);
        this.mms001C.Next();
        this.mms001E.SelectInvAccounting("1-Inv accounting");
        this.mms001E.SelectLotCtrlMethod("3-In lot master");
        this.mms001E.SelectLotNumbMethod("5-Auto order no");
        String newItemNumber = this.mms001E.GetItemNumber();
        this.ItemTemplate.setItemCode(newItemNumber);
        this.mms001E.Next();
        this.mms001F.Next();
        this.mms001G.SelectSalesItem("1-Sales item");
        this.mms001G.Next();
        this.mms001H.Next();
        this.mms001I.Next();
        this.mms001J.Next();
        this.mms001K.Next();
        this.mms001M.Next();
        this.mms001.SearchByItemNumber(newItemNumber);
        this.ItemTemplate.setMethodExecutionStatus(Boolean.valueOf(true));
        Assert.assertTrue(this.mms001.GetItemNumberList().contains(newItemNumber), (("Item number" + newItemNumber) + "is not found in the grid"));
        System.out.println("ItemCreationTemplate Executed ");
        return this.ItemTemplate;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
          throw ex;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
