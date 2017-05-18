package bi3.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import bi3.framework.exceptions.FrameworkException;

/**
 * The Class ExcelFileReader.
 */
public class ExcelUtil {

	/** The logger. */
	//private static Logger logger = Logger.getLogger(ExcelFileReader.class);

	/** The path. */
	public String path;

	/** The fis. */
	public FileInputStream fis = null;

	/** The file out. */
	public FileOutputStream fileOut = null;

	/** The workbook. */
	private static HSSFWorkbook workbook = null;

	/** The sheet. */
	private static HSSFSheet sheet = null;

	/** The row. */
	private static HSSFRow row = null;

	/** The cell. */
	private static HSSFCell cell = null;

	/** The sheet name. */
	private static String sheetName;

	/**
	 * Instantiates a new excel file reader.
	 *
	 * @param path
	 *            : Fully qualified name where the excel file is, including the
	 *            file name
	 * @param givenSheetName
	 *            : - Method name should have it's own sheet to pull the data,
	 *            and param should be the name of the method
	 */
	public ExcelUtil(final String path, final String givenSheetName) {
		sheetName = givenSheetName;
		this.path = path;
		try {
			fis = new FileInputStream(new File(path));
			workbook = new HSSFWorkbook(fis);

			int sheetNumbers = workbook.getNumberOfSheets();
			for (int i = 0; i < sheetNumbers; i++) {
				if (givenSheetName.equals(workbook.getSheetName(i))) {
					workbook.setActiveSheet(i);
					sheet = workbook.getSheetAt(i);
					return;
				}
			}
			throw new Exception("File " + path + " does not contains the sheet " + givenSheetName);

		} catch (Exception e) {
			//logger.error("ERROR in ExcelFileReader", e);
			throw new FrameworkException("ERROR in ExcelFileReader", e);
		}

	}

	/**
	 * Gets the row count in an active sheet of the opened excel sheet
	 *
	 * @return the row count active sheet
	 */
	public int getRowCountActiveSheet() {
		int number = sheet.getLastRowNum() + 1;
		return number;
	}

	/**
	 * Gets the excel active sheet first two column data.
	 *
	 * @return the excel active sheet first two column data
	 * @throws Exception
	 *             the exception
	 */

	public HashMap<String, String> getExcelActiveSheetFirstTwoColumnData() throws Exception {
		HashMap<String, String> recordsMap = new HashMap<String, String>();
		int lastRow = sheet.getLastRowNum() + 2;
		try {
			// Finding whether shee has any data...
			if (lastRow < 1) {
				throw new Exception("Give sheet " + sheet.getSheetName() + "Does not have any records");
			}
			for (int i = 1; i < lastRow; i++) {
				recordsMap.put(getCellData(0, i), getCellData(1, i));
			}

			return recordsMap;
		} catch (Exception e) {
			//logger.error("ERROR in getExcelActiveSheetFirstTwoColumnData", e);
			throw new FrameworkException("date sheet seems to be empty or some other error", e);
		}
	}

	/**
	 * Gets the row count.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @return returns the row count in a sheet
	 */
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			return 0;
		} else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}

	/**
	 * Gets the cell data.
	 *
	 * @param colNum
	 *            the col num
	 * @param rowNum
	 *            the row num
	 * @return the cell data
	 */
	private String getCellData(final int colNum, final int rowNum) {

		try {
			if (rowNum <= 0) {
				return "";
			}
			row = sheet.getRow(rowNum - 1);
			if (row == null) {
				return "";
			}
			cell = row.getCell(colNum);
			if (cell == null) {
				return "";
			}
			cell.setCellType(Cell.CELL_TYPE_STRING);
			return cell.getStringCellValue().trim();
		} catch (Exception e) {
			//logger.error("ERROR in getCellData", e);
			throw new FrameworkException("ERROR in getCellData", e);
		}

	}

	/**
	 * Gets the cell data.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @param colName
	 *            the col name
	 * @param rowNum
	 *            the row num
	 * @return returns the data from a cell
	 */
	public String getCellData(final String sheetName, final String colName, final int rowNum) {
		try {
			if (rowNum <= 0) {
				return "";
			}

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1) {
				return "";
			}

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1) {
				return "";
			}

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null) {
				return "";
			}
			cell = row.getCell(col_Num);

			if (cell == null) {
				return "";
			}
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			}
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
					|| cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/"
							+ cellText;
				}

				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}
			else {
				return String.valueOf(cell.getBooleanCellValue());
			}

		} catch (Exception e) {
			//logger.error("ERROR in getCellData", e);
			throw new FrameworkException("ERROR in getCellData", e);
		}
	}

	/**
	 * Gets the cell data.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @param colNum
	 *            the col num
	 * @param rowNum
	 *            the row num
	 * @return the cell data
	 */
	public String getCellData(final String sheetName, final int colNum, final int rowNum) {
		try {
			if (rowNum <= 0) {
				return "";
			}

			int index = workbook.getSheetIndex(sheetName);

			if (index == -1) {
				return "";
			}

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null) {
				return "";
			}
			cell = row.getCell(colNum);
			if (cell == null) {
				return "";
			}

			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			}
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
					|| cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/"
							+ cellText;
				}

				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}
			else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			//logger.error("ERROR in getCellData", e);
			throw new FrameworkException("ERROR in getCellData", e);
		}
	}

	/**
	 * Gets the date from a cell of the active sheet
	 *
	 * @param colName
	 *            the col name
	 * @param rowNum
	 *            the row num
	 * @return the celldata from active sheet
	 */
	public String getCelldataFromActiveSheet(final String colName, final int rowNum) {
		try {
			if (rowNum <= 0) {
				return "";
			}

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1) {
				return "";
			}

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1) {
				return "";
			}

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null) {
				return "";
			}
			cell = row.getCell(col_Num);

			if (cell == null) {
				return "";
			}
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			}
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
					|| cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/"
							+ cellText;
				}

				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}

		} catch (Exception e) {
			//logger.error("ERROR in getCellData", e);
			throw new FrameworkException("ERROR in getCellData", e);
		}
	}

	/**
	 * Checks if is sheet exist.
	 *
	 * @param sheetName
	 *            the sheet name
	 * @return true, if is sheet exist
	 */
	public boolean isSheetExist(final String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			return false;
			
		} else {
			return true;
		}
	}
}
