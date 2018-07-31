package ccs.neu.edu.cs5200.fifaserver.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Free")
public class FreeUser extends User{
//  @Id
//  @Column(name = "user_name")
//  private String userName;

  @Column(nullable = false, name = "searchcredit")
  private Integer searchCredit;

  public FreeUser() {
  }

  public FreeUser(String userName, String password, String email, Integer searchCredit) {
    super(userName, password, email, false);
    this.searchCredit = searchCredit;
  }

  public Integer getSearchCredit() {
    return searchCredit;
  }

  public void setSearchCredit(Integer searchCredit) {
    this.searchCredit = searchCredit;
  }
}
