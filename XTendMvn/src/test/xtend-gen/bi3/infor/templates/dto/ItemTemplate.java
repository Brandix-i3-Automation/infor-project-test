package bi3.infor.templates.dto;

/**
 * Returns a Item Template
 * 
 * @author Niranga
 */
@SuppressWarnings("all")
public class ItemTemplate {
  /**
   * Method execution passed or failed
   */
  private boolean methodExecutionStatus1;
  
  /**
   * New item code number
   */
  private String itemCode;
  
  /**
   * Gets the method execution status
   */
  public boolean getMethodExecutionStatus() {
    return this.getMethodExecutionStatus();
  }
  
  /**
   * Gets the method execution status
   */
  public void setMethodExecutionStatus(final Boolean methodExecutionStatus) {
    this.methodExecutionStatus1 = (methodExecutionStatus).booleanValue();
  }
  
  /**
   * sets item code
   */
  public void setItemCode(final String itemCode) {
    this.itemCode = itemCode;
  }
  
  /**
   * Gets the item code
   */
  public String getItemCode() {
    return this.itemCode;
  }
}
