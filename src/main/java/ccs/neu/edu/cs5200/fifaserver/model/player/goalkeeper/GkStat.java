package ccs.neu.edu.cs5200.fifaserver.model.player.goalkeeper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GKStat")
public class GkStat {
  @Id
  @Column(name = "PlayerID")
  private long playerId;

  @Column(nullable = false, name = "Diving")
  private int diving;

  @Column(nullable = false, name = "Handling")
  private int handling;

  @Column(nullable = false, name = "Reflexes")
  private int reflexes;

  @Column(nullable = false, name = "Speed")
  private int speed;

  @Column(nullable = false, name = "Kicking")
  private int kicking;

  @Column(nullable = false, name = "Positioning")
  private int positioning;

  public GkStat() {
  }

  public GkStat(long playerId, int diving, int handling, int reflexes, int speed, int kicking,
                int positioning) {
    this.playerId = playerId;
    this.diving = diving;
    this.handling = handling;
    this.reflexes = reflexes;
    this.speed = speed;
    this.kicking = kicking;
    this.positioning = positioning;
  }

  public long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(long playerId) {
    this.playerId = playerId;
  }

  public int getDiving() {
    return diving;
  }

  public void setDiving(int diving) {
    this.diving = diving;
  }

  public int getHandling() {
    return handling;
  }

  public void setHandling(int handling) {
    this.handling = handling;
  }

  public int getReflexes() {
    return reflexes;
  }

  public void setReflexes(int reflexes) {
    this.reflexes = reflexes;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getKicking() {
    return kicking;
  }

  public void setKicking(int kicking) {
    this.kicking = kicking;
  }

  public int getPositioning() {
    return positioning;
  }

  public void setPositioning(int positioning) {
    this.positioning = positioning;
  }
}
