package ccs.neu.edu.cs5200.fifaserver.model.player.nongoalkeeper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NonGKStat")
public class NonGKStat {
  @Id
  @Column(name = "PlayerID")
  private long playerId;

  @Column(nullable = false, name = "Pace")
  private int pace;

  @Column(nullable = false, name = "Dribbling")
  private int dribbling;

  @Column(nullable = false, name = "Shooting")
  private int shooting;

  @Column(nullable = false, name = "Defending")
  private int defending;

  @Column(nullable = false, name = "Physicality")
  private int physicality;

  @Column(nullable = false, name = "Passing")
  private int passing;

  public NonGKStat() {
  }

  public NonGKStat(long playerId, int pace, int dribbling, int shooting, int defending, int physicality, int passing) {
    this.playerId = playerId;
    this.pace = pace;
    this.dribbling = dribbling;
    this.shooting = shooting;
    this.defending = defending;
    this.physicality = physicality;
    this.passing = passing;
  }

  public long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(long playerId) {
    this.playerId = playerId;
  }

  public int getPace() {
    return pace;
  }

  public void setPace(int pace) {
    this.pace = pace;
  }

  public int getDribbling() {
    return dribbling;
  }

  public void setDribbling(int dribbling) {
    this.dribbling = dribbling;
  }

  public int getShooting() {
    return shooting;
  }

  public void setShooting(int shooting) {
    this.shooting = shooting;
  }

  public int getDefending() {
    return defending;
  }

  public void setDefending(int defending) {
    this.defending = defending;
  }

  public int getPhysicality() {
    return physicality;
  }

  public void setPhysicality(int physicality) {
    this.physicality = physicality;
  }

  public int getPassing() {
    return passing;
  }

  public void setPassing(int passing) {
    this.passing = passing;
  }
}
