package ccs.neu.edu.cs5200.fifaserver.model.league;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LeagueLogo")
public class LeagueLogo {
  @Id
  @Column(name = "LeagueName")
  private String leagueName;

  @Column(nullable = false, name = "LeagueLogo")
  private String leagueLogo;

  public LeagueLogo() {
  }

  public LeagueLogo(String leagueName, String leagueLogo) {
    this.leagueName = leagueName;
    this.leagueLogo = leagueLogo;
  }

  public String getLeagueName() {
    return leagueName;
  }

  public void setLeagueName(String leagueName) {
    this.leagueName = leagueName;
  }

  public String getLeagueLogo() {
    return leagueLogo;
  }

  public void setLeagueLogo(String leagueLogo) {
    this.leagueLogo = leagueLogo;
  }
}
