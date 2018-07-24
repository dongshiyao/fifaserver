package ccs.neu.edu.cs5200.fifaserver.domain.club;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClubLogo")
public class ClubLogo {
  @Id
  @Column(name = "ClubName")
  private String clubName;

  @Column(nullable = false, name = "ClubLogo")
  private String clubLogo;

  public ClubLogo() {
  }

  public ClubLogo(String clubName, String clubLogo) {
    this.clubName = clubName;
    this.clubLogo = clubLogo;
  }

  public String getClubName() {
    return clubName;
  }

  public void setClubName(String clubName) {
    this.clubName = clubName;
  }

  public String getClubLogo() {
    return clubLogo;
  }

  public void setClubLogo(String clubLogo) {
    this.clubLogo = clubLogo;
  }
}
