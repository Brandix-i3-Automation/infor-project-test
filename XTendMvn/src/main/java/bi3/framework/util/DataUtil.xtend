package bi3.framework.util

import java.text.SimpleDateFormat

class DataUtil {

	/**
	 * Return the time stamp as a string.
	 * @return String time stamp
	 */
	def static String get10DigitId() {
		var String DATE_FORMAT = "MMddHHmmss";
		var SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		return formatter.format(DateUtil.getCurrentDate());
	}
}