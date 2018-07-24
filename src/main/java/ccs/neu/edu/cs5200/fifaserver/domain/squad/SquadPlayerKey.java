package ccs.neu.edu.cs5200.fifaserver.domain.squad;

import java.io.Serializable;

public class SquadPlayerKey implements Serializable {
  private Long squadId;
  private Long playerId;

  public SquadPlayerKey() {
  }

  public SquadPlayerKey(Long squadId, Long playerId) {
    this.squadId = squadId;
    this.playerId = playerId;
  }

  public Long getSquadId() {
    return squadId;
  }

  public void setSquadId(Long squadId) {
    this.squadId = squadId;
  }

  public Long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(Long playerId) {
    this.playerId = playerId;
  }
}
