package bi3.infor.templates.dto

import org.eclipse.xtend.lib.annotations.Accessors


/**
 * Returns a Item Template
 * 
 * @author Niranga
 */
public class ItemTemplate {

	/** Method execution passed or failed */
	private boolean methodExecutionStatus1;

	/** New item code number */
	private String itemCode;


	/** Gets the method execution status */
	def public boolean getMethodExecutionStatus() {
		return methodExecutionStatus;
	}

	/** Gets the method execution status */
	def public void setMethodExecutionStatus(Boolean methodExecutionStatus) {
		this.methodExecutionStatus1 = methodExecutionStatus;
	}

	/** sets item code */
	def public void setItemCode(String itemCode) {

		this.itemCode = itemCode;
	}

	/**  Gets the item code */
	def public String getItemCode() {

		return this.itemCode;
	}

}
