package bi3.framework.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date util class.
 * @author OsandaF
 */
@SuppressWarnings("all")
public class DateUtil {
  /**
   * Date format yyMMddHHmm.
   */
  public static String DATE_FORMAT = "yyMMddHHmm";
  
  /**
   * Return the time stamp as a string.
   * @return String time stamp
   */
  public static String GetTimestamp() {
    SimpleDateFormat formatter = new SimpleDateFormat(DateUtil.DATE_FORMAT);
    return formatter.format(DateUtil.getCurrentDate());
  }
  
  /**
   * Return the current date.
   * @return Date Current date
   */
  public static Date getCurrentDate() {
    return new Date();
  }
}
