package ccs.neu.edu.cs5200.fifaserver.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FreeUser")
public class FreeUser {
  @Id
  @Column(name = "UserID")
  private Long userId;

  @Column(nullable = false, name = "SearchCredit")
  private Integer searchCredit;

  public FreeUser() {
  }

  public FreeUser(Long userId, Integer searchCredit) {
    this.userId = userId;
    this.searchCredit = searchCredit;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Integer getSearchCredit() {
    return searchCredit;
  }

  public void setSearchCredit(Integer searchCredit) {
    this.searchCredit = searchCredit;
  }
}
