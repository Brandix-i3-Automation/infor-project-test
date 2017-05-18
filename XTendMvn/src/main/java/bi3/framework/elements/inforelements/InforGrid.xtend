package bi3.framework.elements.inforelements

import org.openqa.selenium.WebElement
import java.util.List
import org.openqa.selenium.By
import bi3.framework.core.WebDriverExtensions
import bi3.pages.BasePage
import java.util.concurrent.TimeUnit
import bi3.framework.exceptions.FrameworkException

class InforGrid extends WebDriverExtensions {

	private WebElement gridElement; // Eg:- div[id*='MMA001BS'][class*='inforDataGrid']
	var String headerElements = "div.slick-header-column span.slick-column-name"; // Column Header
	var String headerRow2Elements = "div.slick-headerrow-column"; // Second Column Header row with serach fields
	var String rowElements = "div.slick-row";
	var String cellElements = "div.slick-cell";

	new(WebElement element) {
		this.gridElement = element;
	}

	def void waitTillReady() {
		waitTillReady(30);
	}

	def void waitTillReady(int waitTimeInSeconds) {
		try {
			BasePage.waitForLoadingComplete();
			gridElement.waitToBeDisplayed(waitTimeInSeconds);
			gridElement.findElement(By.cssSelector(headerElements)).waitToBeDisplayed(waitTimeInSeconds);
		} catch (Exception e) {
			println("Failed to display grid: " + gridElement);
		}
	}

	def List<String> getColumnHeaders() {
		var List<WebElement> headerElementList = gridElement.findElements(By.cssSelector(headerElements));
		return headerElementList.getTextList();
	}

	def List<WebElement> getCellsFromRow(int rowIndex) {
		var WebElement matchingRow = getRow(rowIndex);
		var List<WebElement> cellElementList = matchingRow.findElements(By.cssSelector(cellElements));
		return cellElementList;
	}

	def List<WebElement> getCellsFromRow(WebElement rowElement) {
		var WebElement matchingRow = rowElement;
		var List<WebElement> cellElementList = matchingRow.findElements(By.cssSelector(cellElements));
		return cellElementList;
	}

	def List<String> getDataOfRow(int rowIndex) {
		var List<WebElement> cellList = getCellsFromRow(rowIndex);
		return cellList.getTextList();
	}

	def List<WebElement> getCellsFromColumn(int columnIndex) {
		var String cssPath = "div.slick-cell.l" + columnIndex + ".r" + columnIndex;
		var List<WebElement> cellList = gridElement.findElements(By.cssSelector(cssPath));
		return cellList;
	}

	def List<String> getDataOfColumn(String columnName) {
		var int columnIndex = getColumnIndexByname(columnName);
		var List<WebElement> cellList = getCellsFromColumn(columnIndex);
		return cellList.getTextList();
	}

	def List<String> getDataOfColumn(int columnIndex) {
		var List<WebElement> cellList = getCellsFromColumn(columnIndex);
		return cellList.getTextList();
	}

	def WebElement setValueToColumnSearchField(int columnId, String searchValue) {
		try {
			var List<WebElement> headerRow2ElementList = gridElement.findElements(By.cssSelector(headerRow2Elements));
			var WebElement matchingElement = headerRow2ElementList.get(columnId); // Finds the element we required using column index
			var WebElement searchTextbox = matchingElement.findElement(By.cssSelector("input.inforTextbox"));
			searchTextbox.waitToBeClickable(30);
			searchTextbox.click();
			searchTextbox.clearRobustly();
			searchTextbox.sendKeys(searchValue);
			return searchTextbox;
		} catch (Exception ex) {
			throw ex;
		}
	}

	def WebElement setValueToColumnSearchField(String columnName, String searchValue) {
		try {
			var int columnIndex = getColumnIndexByname(columnName);
			var List<WebElement> headerRow2ElementList = gridElement.findElements(By.cssSelector(headerRow2Elements));
			var WebElement matchingElement = headerRow2ElementList.get(columnIndex); // Finds the element we required using column index
			var WebElement searchTextbox = matchingElement.findElement(By.cssSelector("input.inforTextbox"));
			searchTextbox.waitToBeClickable(30);
			searchTextbox.click();
			searchTextbox.clearRobustly();
			searchTextbox.sendKeys(searchValue);
			return searchTextbox;
		} catch (Exception ex) {
			throw ex;
		}
	}

	def int getColumnIndexByname(String columnName) {
		var List<String> columnNames = getColumnHeaders();
		return columnNames.indexOf(columnName);
	}

	def String getColumnNameByIndex(int columnIndex) {
		var List<String> columnNames = getColumnHeaders();
		return columnNames.get(columnIndex);
	}

	def WebElement getCell(int columnIndex, String value) {
		var List<WebElement> cellList = getCellsFromColumn(columnIndex);
		var List<String> cellDataList = cellList.getTextList();
		var int matchingElementIndex = cellDataList.indexOf(value);

		var WebElement matchingElement = cellList.get(matchingElementIndex);
		return matchingElement;
	}

	def WebElement getCell(String columnName, String value) {
		var int columnIndex = getColumnIndexByname(columnName);

		var List<WebElement> cellList = getCellsFromColumn(columnIndex);
		var List<String> cellDataList = cellList.getTextList();
		var int matchingElementIndex = cellDataList.indexOf(value);

		var WebElement matchingElement = cellList.get(matchingElementIndex);
		return matchingElement;
	}

	def WebElement getRowContainingText(String value) {
	}

	/**
	 * @param columnIndex Column index starts from 1
	 */
	def WebElement getRowContainingTextInColumn(int columnIndex, String value) {
		var String xpath = ".//div[contains(@class,'slick-row')]/div[contains(@class, 'slick-cell')][" + columnIndex +
			"][contains(., '" + value + "')]/..";
		var WebElement element;
		try {
			element = gridElement.findElement(By.xpath(xpath));
		} catch (Exception e) {
		}
		return element;
	}

	/**
	 * @param columnIndex Column index starts from 1
	 */
	def List<WebElement> getRowsContainingTextInColumn(int columnIndex, String value) {
		var String xpath = ".//div[contains(@class,'slick-row')]/div[contains(@class, 'slick-cell')][" + columnIndex +
			"][contains(., '" + value + "')]/..";
		var List<WebElement> elements;
		try {
			elements = gridElement.findElements(By.xpath(xpath));
		} catch (Exception e) {
		}
		return elements;
	}

	/**
	 * @param columnIndex Column index starts from 1
	 */
	def List<String> getDataOfRowContainingTextInColumn(int columnIndex, String value) {
		var WebElement matchingRow = this.getRowContainingTextInColumn(columnIndex, value);
		var List<WebElement> cellElementList = matchingRow.findElements(By.cssSelector(cellElements));
		return cellElementList.getTextList();
	}

	/**
	 * @param rowIndex Row index starts from 0
	 */
	def WebElement getRow(int rowIndex) {
		var List<WebElement> rowElementList = gridElement.findElements(By.cssSelector(rowElements));
		var WebElement matchingRow = rowElementList.get(rowIndex);
		return matchingRow;
	}

	def List<WebElement> getAllRows() {
		var List<WebElement> rowElementList = gridElement.findElements(By.cssSelector(rowElements));
		return rowElementList;
	}

	def int getRowCount() {
		var int count = 0;
		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			var rows = getAllRows();
			count = rows.length();
		} catch (Exception e) {
			println("Exception occurred when returning row count" + e.message);
		} finally {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		return count;
	}

	/**
	 * Get column value using column header name and row index.
	 */
	def String getColumnValByColumnHeader(String colHeaderName, int rowIndex) {
		var InforGrid grid = new InforGrid(gridElement);
		var List<String> colHeaders = grid.columnHeaders;
		var boolean validHeader = colHeaders.contains(colHeaderName);
		var int colIndex = 0;
		if (validHeader) {
			colIndex = grid.getColumnIndexByname(colHeaderName);
			var List<String> colValList = grid.getDataOfRow(rowIndex);
			return colValList.get(colIndex);
		} else {
			throw new FrameworkException(
				"bi3.framework.elements.inforelements.InforGrid.getColumnValByColumnHeader(): Invalid column header!");
		}
	}
}
