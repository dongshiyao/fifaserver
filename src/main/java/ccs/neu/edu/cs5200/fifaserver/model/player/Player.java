package ccs.neu.edu.cs5200.fifaserver.model.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ccs.neu.edu.cs5200.fifaserver.model.squad.Position;

@Entity
@Table(name = "Player")
public class Player {
  @Id
  @Column(name = "PlayerID")
  private long playerId;

  @Column(nullable = false, name = "PlayerName")
  private String playerName;

  @Column(nullable = false, name = "Nation")
  private String nation;

  @Column(nullable = false, name = "ClubName")
  private String clubName;

  @Column(nullable = false, name = "LeagueName")
  private String leagueName;

  @Column(nullable = false, name = "Photo")
  private String photo;

  @Column(nullable = false, name = "Skills")
  private int skills;

  @Column(nullable = false, name = "WeakFoot")
  private int weakFoot;

  @Column(nullable = false, name = "Height")
  private int height;

  @Column(nullable = false, name = "Weight")
  private int weight;

  @Column(nullable = false, name = "Overall")
  private int overall;

  @Column(nullable = false, name = "Position")
  private Position position;

  public Player() {
  }

  public Player(long playerId, String playerName, String nation, String clubName, String leagueName,
                String photo, int skills, int weakFoot, int height, int weight, int overall,
                Position position) {
    this.playerId = playerId;
    this.playerName = playerName;
    this.nation = nation;
    this.clubName = clubName;
    this.leagueName = leagueName;
    this.photo = photo;
    this.skills = skills;
    this.weakFoot = weakFoot;
    this.height = height;
    this.weight = weight;
    this.overall = overall;
    this.position = position;
  }

  public long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(long playerId) {
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

  public String getClubName() {
    return clubName;
  }

  public void setClubName(String clubName) {
    this.clubName = clubName;
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

  public int getSkills() {
    return skills;
  }

  public void setSkills(int skills) {
    this.skills = skills;
  }

  public int getWeakFoot() {
    return weakFoot;
  }

  public void setWeakFoot(int weakFoot) {
    this.weakFoot = weakFoot;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getOverall() {
    return overall;
  }

  public void setOverall(int overall) {
    this.overall = overall;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }
}
