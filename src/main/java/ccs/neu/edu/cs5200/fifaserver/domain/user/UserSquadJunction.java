package ccs.neu.edu.cs5200.fifaserver.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "UserSquadJunction")
@IdClass(value = UserSquadKey.class)
public class UserSquadJunction {
  @Id
  @Column(name = "UserID")
  private Long userId;

  @Id
  @Column(name = "SquadID")
  private Long squadId;

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
