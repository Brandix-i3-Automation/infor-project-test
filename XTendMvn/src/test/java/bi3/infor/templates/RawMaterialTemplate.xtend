package bi3.infor.templates

import org.openqa.selenium.WebDriver
import org.apache.log4j.Logger

/**
 * Infor business process template class for raw material creation.
 * 
 * @author OsandaF
 */
class RawMaterialTemplate {
	
	/** WebDriver. */
	private WebDriver driver = null;
	
	/** The Constant LOG. */
	final static Logger LOG = Logger.getLogger(RawMaterialTemplate);
	
	new(WebDriver driver) {
		this.driver = driver;
		this.init();
	}
	
	/**
	 * Method init.
	 */
	private def init() {
		LOG.trace("Trace Message!");
	  	LOG.debug("Debug Message!");
	  	LOG.info("Info Message!");
	  	LOG.warn("Warn Message!");
	  	LOG.error("Error Message!");
	  	LOG.fatal("Fatal Message!");
	}
}