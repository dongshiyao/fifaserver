package ccs.neu.edu.cs5200.fifaserver.domain.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
  @Column(name = "player_id")
  private Long playerId;

  @Column(nullable = false, name = "player_name")
  private String playerName;

  @Column(nullable = false, name = "nation")
  private String nation;

  @Column(nullable = false, name = "flag")
  private String flag;

  @Column(nullable = false, name = "club")
  private String club;

  @Column(nullable = false, name = "club_logo")
  private String clubLogo;

  @Column(nullable = false, name = "league")
  private String league;

  @Column(nullable = false, name = "photo")
  private String photo;

  @Column(nullable = false, name = "skills")
  private Integer skills;

  @Column(nullable = false, name = "weak_foot")
  private Integer weakFoot;

  @Column(nullable = false, name = "height")
  private Integer height;

  @Column(nullable = false, name = "weight")
  private Integer weight;

  @Column(nullable = false, name = "overall")
  private Integer overall;

  @Column(nullable = false, name = "pos")
  @Enumerated(EnumType.STRING)
  private Position position;

  @Column(nullable = false, name = "pace")
  private Integer pace;

  @Column(nullable = false, name = "dribbling")
  private Integer dribbling;

  @Column(nullable = false, name = "shooting")
  private Integer shooting;

  @Column(nullable = false, name = "defending")
  private Integer defending;

  @Column(nullable = false, name = "physicality")
  private Integer physicality;

  @Column(nullable = false, name = "passing")
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

  public String getClub() {
    return club;
  }

  public void setClub(String club) {
    this.club = club;
  }

  public String getClubLogo() {
    return clubLogo;
  }

  public void setClubLogo(String clubLogo) {
    this.clubLogo = clubLogo;
  }

  public String getLeague() {
    return league;
  }

  public void setLeague(String league) {
    this.league = league;
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
