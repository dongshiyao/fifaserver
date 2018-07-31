package ccs.neu.edu.cs5200.fifaserver.domain.user;

import java.sql.Date;

public class PremInput extends User {
  private Long creditCardNum;
  private Date creditCardExp;

  public PremInput() {
  }

  public PremInput(String userName, String password, String email, Boolean isPremium, Long creditCardNum, Date creditCardExp) {
    super(userName, password, email, isPremium);
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

  public User buildUser() {
    return new User(this.getUserName(), this.getPassword(), this.getEmail(), this.getIsPremium());
  }
}
