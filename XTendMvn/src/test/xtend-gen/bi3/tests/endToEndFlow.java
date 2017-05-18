package bi3.tests;

import bi3.framework.config.ConfigKeys;
import bi3.framework.util.ExcelUtil;
import bi3.tests.BaseTest;
import java.util.HashMap;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class endToEndFlow extends BaseTest {
  private ExcelUtil data;
  
  private HashMap<String, String> hashMap;
  
  @BeforeMethod
  public void Initialize() {
    try {
      final String path = ConfigKeys.DATA_HELPER_PATH;
      final String sheetName = "Sheet1";
      ExcelUtil _excelUtil = new ExcelUtil(path, sheetName);
      this.data = _excelUtil;
      this.hashMap = this.data.getExcelActiveSheetFirstTwoColumnData();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void endToEndTest() {
  }
}
