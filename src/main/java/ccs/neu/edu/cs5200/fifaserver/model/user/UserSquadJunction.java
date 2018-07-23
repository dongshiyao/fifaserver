package ccs.neu.edu.cs5200.fifaserver.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "UserSquadJunction")
public class UserSquadJunction {
  @Column(nullable = false, name = "UserID")
  private long userId;

  @Column(nullable = false, name = "SquadID")
  private long squadId;

  public UserSquadJunction() {
  }

  public UserSquadJunction(long userId, long squadId) {
    this.userId = userId;
    this.squadId = squadId;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getSquadId() {
    return squadId;
  }

  public void setSquadId(long squadId) {
    this.squadId = squadId;
  }
}
