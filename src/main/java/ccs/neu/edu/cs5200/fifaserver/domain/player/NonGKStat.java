package ccs.neu.edu.cs5200.fifaserver.domain.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NonGKStat")
public class NonGKStat {
  @Id
  @Column(name = "PlayerID")
  private Long playerId;

  @Column(nullable = false, name = "Pace")
  private Integer pace;

  @Column(nullable = false, name = "Dribbling")
  private Integer dribbling;

  @Column(nullable = false, name = "Shooting")
  private Integer shooting;

  @Column(nullable = false, name = "Defending")
  private Integer defending;

  @Column(nullable = false, name = "Physicality")
  private Integer physicality;

  @Column(nullable = false, name = "Passing")
  private Integer passing;

  public NonGKStat() {
  }

  public NonGKStat(Long playerId, Integer pace, Integer dribbling, Integer shooting,
                   Integer defending, Integer physicality, Integer passing) {
    this.playerId = playerId;
    this.pace = pace;
    this.dribbling = dribbling;
    this.shooting = shooting;
    this.defending = defending;
    this.physicality = physicality;
    this.passing = passing;
  }

  public Long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(Long playerId) {
    this.playerId = playerId;
  }

  public Integer getPace() {
    return pace;
  }

  public void setPace(Integer pace) {
    this.pace = pace;
  }

  public Integer getDribbling() {
    return dribbling;
  }

  public void setDribbling(Integer dribbling) {
    this.dribbling = dribbling;
  }

  public Integer getShooting() {
    return shooting;
  }

  public void setShooting(Integer shooting) {
    this.shooting = shooting;
  }

  public Integer getDefending() {
    return defending;
  }

  public void setDefending(Integer defending) {
    this.defending = defending;
  }

  public Integer getPhysicality() {
    return physicality;
  }

  public void setPhysicality(Integer physicality) {
    this.physicality = physicality;
  }

  public Integer getPassing() {
    return passing;
  }

  public void setPassing(Integer passing) {
    this.passing = passing;
  }
}
