package ccs.neu.edu.cs5200.fifaserver.domain.player;

import java.sql.Date;

public class CreditCard {
  private Long creditCardNum;
  private Date creditCardExp;

  public CreditCard(Long creditCardNum, Date creditCardExp) {
    this.creditCardNum = creditCardNum;
    this.creditCardExp = creditCardExp;
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
