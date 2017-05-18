package bi3.framework.data;

import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("all")
public class DataHelper {
  private static Date today;
  
  private static SimpleDateFormat DATE_FORMAT;
  
  private static String timestamp;
  
  public static String GetTimestamp() {
    Date _date = new Date();
    DataHelper.today = _date;
    SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("yyMMddHHmm");
    DataHelper.DATE_FORMAT = _simpleDateFormat;
    DataHelper.timestamp = DataHelper.DATE_FORMAT.format(DataHelper.today);
    return DataHelper.timestamp;
  }
}
