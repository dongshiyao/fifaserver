package ccs.neu.edu.cs5200.fifaserver.domain.user;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Premium")
public class PremiumUser extends User {
//  @Id
//  @Column(name = "user_name")
//  private String userName;

  @Column(nullable = false, name = "vipexp")
  private Date vipExp;

  @Column(nullable = false, name = "viplevel")
  private Integer vipLevel;

  @Column(nullable = false, name = "creditcardnum")
  private Long creditCardNum;

  @Column(nullable = false, name = "creditcardexp")
  private Date creditCardExp;

  public PremiumUser() {
  }

  public PremiumUser(String userName, String password, String email, Date vipExp, Integer vipLevel, Long creditCardNum, Date creditCardExp) {
    super(userName, password, email, true);
    this.vipExp = vipExp;
    this.vipLevel = vipLevel;
    this.creditCardNum = creditCardNum;
    this.creditCardExp = creditCardExp;
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
