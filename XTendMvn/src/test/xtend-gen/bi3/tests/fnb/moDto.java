package bi3.tests.fnb;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class moDto {
  private String lastJointSchNo;
  
  private String fullScheduleNo;
  
  private String moNum;
  
  @Pure
  public String getLastJointSchNo() {
    return this.lastJointSchNo;
  }
  
  public void setLastJointSchNo(final String lastJointSchNo) {
    this.lastJointSchNo = lastJointSchNo;
  }
  
  @Pure
  public String getFullScheduleNo() {
    return this.fullScheduleNo;
  }
  
  public void setFullScheduleNo(final String fullScheduleNo) {
    this.fullScheduleNo = fullScheduleNo;
  }
  
  @Pure
  public String getMoNum() {
    return this.moNum;
  }
  
  public void setMoNum(final String moNum) {
    this.moNum = moNum;
  }
}
