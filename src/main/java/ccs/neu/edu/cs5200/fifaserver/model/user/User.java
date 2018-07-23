package ccs.neu.edu.cs5200.fifaserver.model.user;

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
  private long userId;

  @Column(nullable = false, name = "UserName")
  private String userName;

  @Column(nullable = false, name = "Password")
  private String password;

  @Column(nullable = false, name = "Admin")
  private boolean admin;

  public User() {
  }

  public User(String userName, String password, boolean admin) {
    this.userName = userName;
    this.password = password;
    this.admin = admin;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
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

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }
}
