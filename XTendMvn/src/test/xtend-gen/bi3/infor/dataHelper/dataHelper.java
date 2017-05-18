package bi3.infor.dataHelper;

import bi3.framework.config.ConfigKeys;
import bi3.framework.util.ExcelUtil;
import java.util.HashMap;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class dataHelper {
  private String itemNumber;
  
  private ExcelUtil data;
  
  private HashMap<String, String> hashMap;
  
  public Object dataHelper() {
    return null;
  }
  
  public HashMap<String, String> test() {
    try {
      HashMap<String, String> _xblockexpression = null;
      {
        final String path = ConfigKeys.DATA_HELPER_PATH;
        final String sheetName = "Sheet1";
        ExcelUtil _excelUtil = new ExcelUtil(path, sheetName);
        this.data = _excelUtil;
        _xblockexpression = this.hashMap = this.data.getExcelActiveSheetFirstTwoColumnData();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getItemNumber() {
    this.test();
    String _get = this.hashMap.get("ItemNumber");
    String _plus = ("Item Number " + _get);
    InputOutput.<String>print(_plus);
    this.itemNumber = this.hashMap.get("ItemNumber").toString();
    return this.itemNumber;
  }
}
