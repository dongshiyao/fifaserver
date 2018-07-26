package ccs.neu.edu.cs5200.fifaserver.domain.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "GKStat")
public class GKStat extends Player {

  @Column(nullable = false, name = "gk")
  private Integer gk;

  public GKStat() {
  }

  public Integer getGk() {
    return gk;
  }

  public void setGk(Integer gk) {
    this.gk = gk;
  }
}
