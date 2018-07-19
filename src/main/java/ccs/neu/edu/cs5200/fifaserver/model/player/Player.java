package ccs.neu.edu.cs5200.fifaserver.model.player;

public class Player {
  private int playerId;
  private String playerName;
  private String nation;
  private String club;
  private String league;
  private int skills;
  private int weakFoot;
  private int height;
  private int weight;
  private int age;
  private int statId;
  private int positionScoreId;

  public Player(int playerId, String playerName, String nation, String club, String league,
                int skills, int weakFoot, int height, int weight, int age, int statId,
                int positionScoreId) {
    this.playerId = playerId;
    this.playerName = playerName;
    this.nation = nation;
    this.club = club;
    this.league = league;
    this.skills = skills;
    this.weakFoot = weakFoot;
    this.height = height;
    this.weight = weight;
    this.age = age;
    this.statId = statId;
    this.positionScoreId = positionScoreId;
  }

  public int getPlayerId() {
    return playerId;
  }

  public void setPlayerId(int playerId) {
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

  public String getClub() {
    return club;
  }

  public void setClub(String club) {
    this.club = club;
  }

  public String getLeague() {
    return league;
  }

  public void setLeague(String league) {
    this.league = league;
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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getStatId() {
    return statId;
  }

  public void setStatId(int statId) {
    this.statId = statId;
  }

  public int getPositionScoreId() {
    return positionScoreId;
  }

  public void setPositionScoreId(int positionScoreId) {
    this.positionScoreId = positionScoreId;
  }
}
