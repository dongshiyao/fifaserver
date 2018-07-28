package ccs.neu.edu.cs5200.fifaserver.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FreeUser")
public class FreeUser extends User{
//  @Id
//  @Column(name = "user_name")
//  private String userName;

  @Column(nullable = false, name = "search_credit")
  private Integer searchCredit;

  public FreeUser() {
  }

  public FreeUser(Integer searchCredit) {
    super();
    this.searchCredit = searchCredit;
  }

  public Integer getSearchCredit() {
    return searchCredit;
  }

  public void setSearchCredit(Integer searchCredit) {
    this.searchCredit = searchCredit;
  }
}
