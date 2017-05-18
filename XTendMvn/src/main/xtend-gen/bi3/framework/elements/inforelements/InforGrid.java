package bi3.framework.elements.inforelements;

import bi3.framework.core.DefaultWebDriver;
import bi3.framework.core.WebDriverExtensions;
import bi3.framework.exceptions.FrameworkException;
import bi3.pages.BasePage;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@SuppressWarnings("all")
public class InforGrid extends WebDriverExtensions {
  private WebElement gridElement;
  
  private String headerElements = "div.slick-header-column span.slick-column-name";
  
  private String headerRow2Elements = "div.slick-headerrow-column";
  
  private String rowElements = "div.slick-row";
  
  private String cellElements = "div.slick-cell";
  
  public InforGrid(final WebElement element) {
    this.gridElement = element;
  }
  
  public void waitTillReady() {
    this.waitTillReady(30);
  }
  
  public void waitTillReady(final int waitTimeInSeconds) {
    try {
      BasePage.waitForLoadingComplete();
      WebDriverExtensions.waitToBeDisplayed(this.gridElement, waitTimeInSeconds);
      WebDriverExtensions.waitToBeDisplayed(this.gridElement.findElement(By.cssSelector(this.headerElements)), waitTimeInSeconds);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        InputOutput.<String>println(("Failed to display grid: " + this.gridElement));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public List<String> getColumnHeaders() {
    List<WebElement> headerElementList = this.gridElement.findElements(By.cssSelector(this.headerElements));
    return this.getTextList(headerElementList);
  }
  
  public List<WebElement> getCellsFromRow(final int rowIndex) {
    WebElement matchingRow = this.getRow(rowIndex);
    List<WebElement> cellElementList = matchingRow.findElements(By.cssSelector(this.cellElements));
    return cellElementList;
  }
  
  public List<WebElement> getCellsFromRow(final WebElement rowElement) {
    WebElement matchingRow = rowElement;
    List<WebElement> cellElementList = matchingRow.findElements(By.cssSelector(this.cellElements));
    return cellElementList;
  }
  
  public List<String> getDataOfRow(final int rowIndex) {
    List<WebElement> cellList = this.getCellsFromRow(rowIndex);
    return this.getTextList(cellList);
  }
  
  public List<WebElement> getCellsFromColumn(final int columnIndex) {
    String cssPath = ((("div.slick-cell.l" + Integer.valueOf(columnIndex)) + ".r") + Integer.valueOf(columnIndex));
    List<WebElement> cellList = this.gridElement.findElements(By.cssSelector(cssPath));
    return cellList;
  }
  
  public List<String> getDataOfColumn(final String columnName) {
    int columnIndex = this.getColumnIndexByname(columnName);
    List<WebElement> cellList = this.getCellsFromColumn(columnIndex);
    return this.getTextList(cellList);
  }
  
  public List<String> getDataOfColumn(final int columnIndex) {
    List<WebElement> cellList = this.getCellsFromColumn(columnIndex);
    return this.getTextList(cellList);
  }
  
  public WebElement setValueToColumnSearchField(final int columnId, final String searchValue) {
    try {
      try {
        List<WebElement> headerRow2ElementList = this.gridElement.findElements(By.cssSelector(this.headerRow2Elements));
        WebElement matchingElement = headerRow2ElementList.get(columnId);
        WebElement searchTextbox = matchingElement.findElement(By.cssSelector("input.inforTextbox"));
        WebDriverExtensions.waitToBeClickable(searchTextbox, 30);
        searchTextbox.click();
        WebDriverExtensions.clearRobustly(searchTextbox);
        searchTextbox.sendKeys(searchValue);
        return searchTextbox;
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
  
  public WebElement setValueToColumnSearchField(final String columnName, final String searchValue) {
    try {
      try {
        int columnIndex = this.getColumnIndexByname(columnName);
        List<WebElement> headerRow2ElementList = this.gridElement.findElements(By.cssSelector(this.headerRow2Elements));
        WebElement matchingElement = headerRow2ElementList.get(columnIndex);
        WebElement searchTextbox = matchingElement.findElement(By.cssSelector("input.inforTextbox"));
        WebDriverExtensions.waitToBeClickable(searchTextbox, 30);
        searchTextbox.click();
        WebDriverExtensions.clearRobustly(searchTextbox);
        searchTextbox.sendKeys(searchValue);
        return searchTextbox;
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
  
  public int getColumnIndexByname(final String columnName) {
    List<String> columnNames = this.getColumnHeaders();
    return columnNames.indexOf(columnName);
  }
  
  public String getColumnNameByIndex(final int columnIndex) {
    List<String> columnNames = this.getColumnHeaders();
    return columnNames.get(columnIndex);
  }
  
  public WebElement getCell(final int columnIndex, final String value) {
    List<WebElement> cellList = this.getCellsFromColumn(columnIndex);
    List<String> cellDataList = this.getTextList(cellList);
    int matchingElementIndex = cellDataList.indexOf(value);
    WebElement matchingElement = cellList.get(matchingElementIndex);
    return matchingElement;
  }
  
  public WebElement getCell(final String columnName, final String value) {
    int columnIndex = this.getColumnIndexByname(columnName);
    List<WebElement> cellList = this.getCellsFromColumn(columnIndex);
    List<String> cellDataList = this.getTextList(cellList);
    int matchingElementIndex = cellDataList.indexOf(value);
    WebElement matchingElement = cellList.get(matchingElementIndex);
    return matchingElement;
  }
  
  public WebElement getRowContainingText(final String value) {
    return null;
  }
  
  /**
   * @param columnIndex Column index starts from 1
   */
  public WebElement getRowContainingTextInColumn(final int columnIndex, final String value) {
    String xpath = ((((".//div[contains(@class,\'slick-row\')]/div[contains(@class, \'slick-cell\')][" + Integer.valueOf(columnIndex)) + 
      "][contains(., \'") + value) + "\')]/..");
    WebElement element = null;
    try {
      element = this.gridElement.findElement(By.xpath(xpath));
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return element;
  }
  
  /**
   * @param columnIndex Column index starts from 1
   */
  public List<WebElement> getRowsContainingTextInColumn(final int columnIndex, final String value) {
    String xpath = ((((".//div[contains(@class,\'slick-row\')]/div[contains(@class, \'slick-cell\')][" + Integer.valueOf(columnIndex)) + 
      "][contains(., \'") + value) + "\')]/..");
    List<WebElement> elements = null;
    try {
      elements = this.gridElement.findElements(By.xpath(xpath));
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return elements;
  }
  
  /**
   * @param columnIndex Column index starts from 1
   */
  public List<String> getDataOfRowContainingTextInColumn(final int columnIndex, final String value) {
    WebElement matchingRow = this.getRowContainingTextInColumn(columnIndex, value);
    List<WebElement> cellElementList = matchingRow.findElements(By.cssSelector(this.cellElements));
    return this.getTextList(cellElementList);
  }
  
  /**
   * @param rowIndex Row index starts from 0
   */
  public WebElement getRow(final int rowIndex) {
    List<WebElement> rowElementList = this.gridElement.findElements(By.cssSelector(this.rowElements));
    WebElement matchingRow = rowElementList.get(rowIndex);
    return matchingRow;
  }
  
  public List<WebElement> getAllRows() {
    List<WebElement> rowElementList = this.gridElement.findElements(By.cssSelector(this.rowElements));
    return rowElementList;
  }
  
  public int getRowCount() {
    int count = 0;
    try {
      DefaultWebDriver.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
      List<WebElement> rows = this.getAllRows();
      final List<WebElement> _converted_rows = (List<WebElement>)rows;
      count = ((Object[])Conversions.unwrapArray(_converted_rows, Object.class)).length;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        String _message = e.getMessage();
        String _plus = ("Exception occurred when returning row count" + _message);
        InputOutput.<String>println(_plus);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      DefaultWebDriver.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    return count;
  }
  
  /**
   * Get column value using column header name and row index.
   */
  public String getColumnValByColumnHeader(final String colHeaderName, final int rowIndex) {
    InforGrid grid = new InforGrid(this.gridElement);
    List<String> colHeaders = grid.getColumnHeaders();
    boolean validHeader = colHeaders.contains(colHeaderName);
    int colIndex = 0;
    if (validHeader) {
      colIndex = grid.getColumnIndexByname(colHeaderName);
      List<String> colValList = grid.getDataOfRow(rowIndex);
      return colValList.get(colIndex);
    } else {
      throw new FrameworkException(
        "bi3.framework.elements.inforelements.InforGrid.getColumnValByColumnHeader(): Invalid column header!");
    }
  }
}
