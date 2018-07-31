package ccs.neu.edu.cs5200.fifaserver.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
  @Id
  @Column(name = "username")
  private String userName;

  @Column(nullable = false, name = "password")
  private String password;

  @Column(nullable = false, name = "email")
  private String email;

  @Column(nullable = false, name = "ispremium")
  private Boolean isPremium;

  public User() {
  }

  public User(String userName, String password, String email, Boolean isPremium) {
    this.userName = userName;
    this.password = password;
    this.email = email;
    this.isPremium = isPremium;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getIsPremium() {
    return isPremium;
  }

  public void setIsPremium(Boolean premium) {
    isPremium = premium;
  }
}
