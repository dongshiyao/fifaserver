package ccs.neu.edu.cs5200.fifaserver.domain.squad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "SquadPlayerJunction")
@IdClass(value = SquadPlayerKey.class)
public class SquadPlayerJunction {
  @Id
  @Column(name = "squad_id")
  private Long squadId;

  @Id
  @Column(name = "player_id")
  private Long playerId;

  @Column(nullable = false, name = "pos_number")
  private PosNum posNumber;

  public SquadPlayerJunction() {
  }

  public SquadPlayerJunction(Long squadId, Long playerId, PosNum posNumber) {
    this.squadId = squadId;
    this.playerId = playerId;
    this.posNumber = posNumber;
  }

  public PosNum getPosNumber() {
    return posNumber;
  }

  public void setPosNumber(PosNum posNumber) {
    this.posNumber = posNumber;
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
