package ccs.neu.edu.cs5200.fifaserver.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FreeUser")
public class FreeUser {
  @Id
  @Column(name = "UserName")
  private String userName;

  @Column(nullable = false, name = "SearchCredit")
  private Integer searchCredit;

  public FreeUser() {
  }

  public FreeUser(String userName, Integer searchCredit) {
    this.userName = userName;
    this.searchCredit = searchCredit;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getSearchCredit() {
    return searchCredit;
  }

  public void setSearchCredit(Integer searchCredit) {
    this.searchCredit = searchCredit;
  }
}
