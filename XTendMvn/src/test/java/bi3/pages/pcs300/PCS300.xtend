package bi3.pages.pcs300

import bi3.pages.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import java.util.List
import bi3.framework.elements.inforelements.InforGrid

class PCS300 extends BasePage{
	
	new(WebDriver driver) {
		super(driver)
	}
	
@FindBy(css="div[id*='PCA300BS'][class*='inforDataGrid']")
WebElement gridPCS300

def List<String> getDataOfItem(String CostingType){
		waitForLoadingComplete();
		var InforGrid grid = new InforGrid(gridPCS300);
		var dataList = grid.getDataOfRowContainingTextInColumn(1, CostingType);
		return dataList;


}
}


