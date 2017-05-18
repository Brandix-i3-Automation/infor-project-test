package bi3.framework.util

import java.util.Date
import java.text.SimpleDateFormat

/**
 * Date util class.
 * @author OsandaF
 */
class DateUtil {
	
	/* Date format yyMMddHHmm. */
	public static String DATE_FORMAT = "yyMMddHHmm";
	
	/**
	 * Return the time stamp as a string.
	 * @return String time stamp
	 */
	def static String GetTimestamp() {
		var SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		return formatter.format(DateUtil.getCurrentDate());
	}
	
	/**
	 * Return the current date.
	 * @return Date Current date
	 */
	def static Date getCurrentDate() {
		return new Date();
	}
}