package ccs.neu.edu.cs5200.fifaserver.domain.user;

public class LoginPair {
  private String userName;
  private String password;

  public LoginPair(String userName, String password) {
    this.userName = userName;
    this.password = password;
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
}
