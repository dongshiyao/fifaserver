package ccs.neu.edu.cs5200.fifaserver.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "UserID")
  private Long userId;

  @Column(nullable = false, name = "UserName")
  private String userName;

  @Column(nullable = false, name = "Password")
  private String password;

  @Column(nullable = false, name = "Email")
  private String email;

  @Column(nullable = false, name = "IsAdmin")
  private Boolean isAdmin;

  public User() {
  }

  public User(String userName, String password, String email, Boolean isAdmin) {
    this.userName = userName;
    this.password = password;
    this.email = email;
    this.isAdmin = isAdmin;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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

  public Boolean getAdmin() {
    return isAdmin;
  }

  public void setAdmin(Boolean admin) {
    isAdmin = admin;
  }
}
