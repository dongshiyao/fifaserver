package ccs.neu.edu.cs5200.fifaserver.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FreeUser")
public class FreeUser {
  @Id
  @Column(name = "UserID")
  private long userId;

  @Column(nullable = false, name = "SearchCredit")
  private int searchCredit;

  public FreeUser(long userId, int searchCredit) {
    this.userId = userId;
    this.searchCredit = searchCredit;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public int getSearchCredit() {
    return searchCredit;
  }

  public void setSearchCredit(int searchCredit) {
    this.searchCredit = searchCredit;
  }
}
