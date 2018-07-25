package ccs.neu.edu.cs5200.fifaserver.domain.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GKStat")
public class GkStat {
  @Id
  @Column(name = "PlayerID")
  private Long playerId;

  @Column(nullable = false, name = "Diving")
  private Integer diving;

  @Column(nullable = false, name = "Handling")
  private Integer handling;

  @Column(nullable = false, name = "Reflexes")
  private Integer reflexes;

  @Column(nullable = false, name = "Speed")
  private Integer speed;

  @Column(nullable = false, name = "Kicking")
  private Integer kicking;

  @Column(nullable = false, name = "Positioning")
  private Integer positioning;

  public GkStat() {
  }

  public GkStat(Long playerId, Integer diving, Integer handling, Integer reflexes, Integer speed,
                Integer kicking, Integer positioning) {
    this.playerId = playerId;
    this.diving = diving;
    this.handling = handling;
    this.reflexes = reflexes;
    this.speed = speed;
    this.kicking = kicking;
    this.positioning = positioning;
  }

  public Long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(Long playerId) {
    this.playerId = playerId;
  }

  public Integer getDiving() {
    return diving;
  }

  public void setDiving(Integer diving) {
    this.diving = diving;
  }

  public Integer getHandling() {
    return handling;
  }

  public void setHandling(Integer handling) {
    this.handling = handling;
  }

  public Integer getReflexes() {
    return reflexes;
  }

  public void setReflexes(Integer reflexes) {
    this.reflexes = reflexes;
  }

  public Integer getSpeed() {
    return speed;
  }

  public void setSpeed(Integer speed) {
    this.speed = speed;
  }

  public Integer getKicking() {
    return kicking;
  }

  public void setKicking(Integer kicking) {
    this.kicking = kicking;
  }

  public Integer getPositioning() {
    return positioning;
  }

  public void setPositioning(Integer positioning) {
    this.positioning = positioning;
  }
}
