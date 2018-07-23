package ccs.neu.edu.cs5200.fifaserver.model.squad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Squad")
public class Squad {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "SquadID")
  private long squadId;

  @Column(nullable = false, name = "SquadName")
  private String squadName;

  @Column(nullable = false, name = "FormationName")
  private String formationName;

  @Column(name = "PlayerID1")
  private int playerId1;

  @Column(name = "PlayerID2")
  private int playerId2;

  @Column(name = "PlayerID3")
  private int playerId3;

  @Column(name = "PlayerID4")
  private int playerId4;

  @Column(name = "PlayerID5")
  private int playerId5;

  @Column(name = "PlayerID6")
  private int playerId6;

  @Column(name = "PlayerID7")
  private int playerId7;

  @Column(name = "PlayerID8")
  private int playerId8;

  @Column(name = "PlayerID9")
  private int playerId9;

  @Column(name = "PlayerID10")
  private int playerId10;

  @Column(name = "PlayerID11")
  private int playerId11;

  @Column(name = "Chemistry")
  private int chemistry;

  @Column(name = "Rating")
  private int rating;

  public Squad() {
  }

  public Squad(String squadName, String formationName) {
    this.squadName = squadName;
    this.formationName = formationName;
  }

  public long getSquadId() {
    return squadId;
  }

  public void setSquadId(long squadId) {
    this.squadId = squadId;
  }

  public String getSquadName() {
    return squadName;
  }

  public void setSquadName(String squadName) {
    this.squadName = squadName;
  }

  public String getFormationName() {
    return formationName;
  }

  public void setFormationName(String formationName) {
    this.formationName = formationName;
  }

  public int getPlayerId1() {
    return playerId1;
  }

  public void setPlayerId1(int playerId1) {
    this.playerId1 = playerId1;
  }

  public int getPlayerId2() {
    return playerId2;
  }

  public void setPlayerId2(int playerId2) {
    this.playerId2 = playerId2;
  }

  public int getPlayerId3() {
    return playerId3;
  }

  public void setPlayerId3(int playerId3) {
    this.playerId3 = playerId3;
  }

  public int getPlayerId4() {
    return playerId4;
  }

  public void setPlayerId4(int playerId4) {
    this.playerId4 = playerId4;
  }

  public int getPlayerId5() {
    return playerId5;
  }

  public void setPlayerId5(int playerId5) {
    this.playerId5 = playerId5;
  }

  public int getPlayerId6() {
    return playerId6;
  }

  public void setPlayerId6(int playerId6) {
    this.playerId6 = playerId6;
  }

  public int getPlayerId7() {
    return playerId7;
  }

  public void setPlayerId7(int playerId7) {
    this.playerId7 = playerId7;
  }

  public int getPlayerId8() {
    return playerId8;
  }

  public void setPlayerId8(int playerId8) {
    this.playerId8 = playerId8;
  }

  public int getPlayerId9() {
    return playerId9;
  }

  public void setPlayerId9(int playerId9) {
    this.playerId9 = playerId9;
  }

  public int getPlayerId10() {
    return playerId10;
  }

  public void setPlayerId10(int playerId10) {
    this.playerId10 = playerId10;
  }

  public int getPlayerId11() {
    return playerId11;
  }

  public void setPlayerId11(int playerId11) {
    this.playerId11 = playerId11;
  }

  public int getChemistry() {
    return chemistry;
  }

  public void setChemistry(int chemistry) {
    this.chemistry = chemistry;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }
}
