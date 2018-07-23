package ccs.neu.edu.cs5200.fifaserver.model.user;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PremiumUser")
public class PremiumUser {
  @Id
  @Column(name = "UserID")
  private long userId;

  @Column(nullable = false, name = "VIPExp")
  private Date vipExp;

  @Column(nullable = false, name = "VIPLevel")
  private int vipLevel;

  @Column(nullable = false, name = "CreditCardNum")
  private long creditCardNum;

  @Column(nullable = false, name = "CreditCardExp")
  private Date creditCardExp;

  public PremiumUser(long userId, Date vipExp, int vipLevel, long creditCardNum, Date creditCardExp) {
    this.userId = userId;
    this.vipExp = vipExp;
    this.vipLevel = vipLevel;
    this.creditCardNum = creditCardNum;
    this.creditCardExp = creditCardExp;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public Date getVipExp() {
    return vipExp;
  }

  public void setVipExp(Date vipExp) {
    this.vipExp = vipExp;
  }

  public int getVipLevel() {
    return vipLevel;
  }

  public void setVipLevel(int vipLevel) {
    this.vipLevel = vipLevel;
  }

  public long getCreditCardNum() {
    return creditCardNum;
  }

  public void setCreditCardNum(long creditCardNum) {
    this.creditCardNum = creditCardNum;
  }

  public Date getCreditCardExp() {
    return creditCardExp;
  }

  public void setCreditCardExp(Date creditCardExp) {
    this.creditCardExp = creditCardExp;
  }
}
