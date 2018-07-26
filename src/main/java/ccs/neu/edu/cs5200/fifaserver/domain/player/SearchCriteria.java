package ccs.neu.edu.cs5200.fifaserver.domain.player;

import ccs.neu.edu.cs5200.fifaserver.domain.squad.Position;

public class SearchCriteria {
  private String nation;
  private String league;
  private String club;
  private Position position;
  private SortCriteria sortCriteria;

  public SearchCriteria() {
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public String getLeague() {
    return league;
  }

  public void setLeague(String league) {
    this.league = league;
  }

  public String getClub() {
    return club;
  }

  public void setClub(String club) {
    this.club = club;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public SortCriteria getSortCriteria() {
    return sortCriteria;
  }

  public void setSortCriteria(SortCriteria sortCriteria) {
    this.sortCriteria = sortCriteria;
  }
}
