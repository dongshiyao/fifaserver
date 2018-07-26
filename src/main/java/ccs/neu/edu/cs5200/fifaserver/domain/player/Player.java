package ccs.neu.edu.cs5200.fifaserver.domain.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import ccs.neu.edu.cs5200.fifaserver.domain.squad.Position;

@Entity
@Table(name = "Player")
@Inheritance(strategy = InheritanceType.JOINED)
public class Player {
  @Id
  @Column(name = "PlayerID")
  private Long playerId;

  @Column(nullable = false, name = "PlayerName")
  private String playerName;

  @Column(nullable = false, name = "Nation")
  private String nation;

  @Column(nullable = false, name = "Flag")
  private String flag;

  @Column(nullable = false, name = "ClubName")
  private String clubName;

  @Column(nullable = false, name = "ClubLogo")
  private String clubLogo;

  @Column(nullable = false, name = "LeagueName")
  private String leagueName;

  @Column(nullable = false, name = "Photo")
  private String photo;

  @Column(nullable = false, name = "Skills")
  private Integer skills;

  @Column(nullable = false, name = "WeakFoot")
  private Integer weakFoot;

  @Column(nullable = false, name = "Height")
  private Integer height;

  @Column(nullable = false, name = "Weight")
  private Integer weight;

  @Column(nullable = false, name = "Overall")
  private Integer overall;

  @Column(nullable = false, name = "Position")
  private Position position;

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

  public Player() {
  }

  public Long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(Long playerId) {
    this.playerId = playerId;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
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

  public String getLeagueName() {
    return leagueName;
  }

  public void setLeagueName(String leagueName) {
    this.leagueName = leagueName;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public Integer getSkills() {
    return skills;
  }

  public void setSkills(Integer skills) {
    this.skills = skills;
  }

  public Integer getWeakFoot() {
    return weakFoot;
  }

  public void setWeakFoot(Integer weakFoot) {
    this.weakFoot = weakFoot;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Integer getOverall() {
    return overall;
  }

  public void setOverall(Integer overall) {
    this.overall = overall;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
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
