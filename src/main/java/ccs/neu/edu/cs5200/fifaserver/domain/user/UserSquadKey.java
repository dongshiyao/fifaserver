package ccs.neu.edu.cs5200.fifaserver.domain.user;

import java.io.Serializable;

public class UserSquadKey implements Serializable {
  private Long userId;
  private Long squadId;

  public UserSquadKey() {
  }

  public UserSquadKey(Long userId, Long squadId) {
    this.userId = userId;
    this.squadId = squadId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getSquadId() {
    return squadId;
  }

  public void setSquadId(Long squadId) {
    this.squadId = squadId;
  }
}
