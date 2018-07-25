package ccs.neu.edu.cs5200.fifaserver.domain.user;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PremiumUser")
public class PremiumUser {
  @Id
  @Column(name = "UserName")
  private String userName;

  @Column(nullable = false, name = "VIPExp")
  private Date vipExp;

  @Column(nullable = false, name = "VIPLevel")
  private Integer vipLevel;

  @Column(nullable = false, name = "CreditCardNum")
  private Long creditCardNum;

  @Column(nullable = false, name = "CreditCardExp")
  private Date creditCardExp;

  public PremiumUser() {
  }

  public PremiumUser(String userName, Date vipExp, Integer vipLevel, Long creditCardNum, Date creditCardExp) {
    this.userName = userName;
    this.vipExp = vipExp;
    this.vipLevel = vipLevel;
    this.creditCardNum = creditCardNum;
    this.creditCardExp = creditCardExp;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Date getVipExp() {
    return vipExp;
  }

  public void setVipExp(Date vipExp) {
    this.vipExp = vipExp;
  }

  public Integer getVipLevel() {
    return vipLevel;
  }

  public void setVipLevel(Integer vipLevel) {
    this.vipLevel = vipLevel;
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
