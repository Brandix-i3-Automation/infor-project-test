package bi3.infor.templates;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Infor business process template class for raw material creation.
 * 
 * @author OsandaF
 */
@SuppressWarnings("all")
public class RawMaterialTemplate {
  /**
   * WebDriver.
   */
  private WebDriver driver = null;
  
  /**
   * The Constant LOG.
   */
  private final static Logger LOG = Logger.getLogger(RawMaterialTemplate.class);
  
  public RawMaterialTemplate(final WebDriver driver) {
    this.driver = driver;
    this.init();
  }
  
  /**
   * Method init.
   */
  private void init() {
    RawMaterialTemplate.LOG.trace("Trace Message!");
    RawMaterialTemplate.LOG.debug("Debug Message!");
    RawMaterialTemplate.LOG.info("Info Message!");
    RawMaterialTemplate.LOG.warn("Warn Message!");
    RawMaterialTemplate.LOG.error("Error Message!");
    RawMaterialTemplate.LOG.fatal("Fatal Message!");
  }
}
