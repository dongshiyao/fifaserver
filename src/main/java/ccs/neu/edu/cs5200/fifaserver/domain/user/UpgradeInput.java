package ccs.neu.edu.cs5200.fifaserver.domain.user;

import java.sql.Date;

public class UpgradeInput {
  private String userName;
  private Long creditCardNum;
  private Date creditCardExp;

  public UpgradeInput() {
  }

  public UpgradeInput(String userName, Long creditCardNum, Date creditCardExp) {
    this.userName = userName;
    this.creditCardNum = creditCardNum;
    this.creditCardExp = creditCardExp;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Long getCreditCardNum() {
    return creditCardNum;
  }

  public void setCreditCardNum(Long creditCardNum) {
    this.creditCardNum = creditCardNum;
  }

  public Date getCreditCardExp() {
    return creditCardExp;
  }

  public void setCreditCardExp(Date creditCardExp) {
    this.creditCardExp = creditCardExp;
  }
}
