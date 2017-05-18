package bi3.framework.util;

import bi3.framework.util.DateUtil;
import java.text.SimpleDateFormat;

@SuppressWarnings("all")
public class DataUtil {
  /**
   * Return the time stamp as a string.
   * @return String time stamp
   */
  public static String get10DigitId() {
    String DATE_FORMAT = "MMddHHmmss";
    SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
    return formatter.format(DateUtil.getCurrentDate());
  }
}
