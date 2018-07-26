package ccs.neu.edu.cs5200.fifaserver.domain.player;

public enum SortCriteria {
  OVERALL("Overall"),
  PACE("Pace"),
  DRIBBLING("Dribbling"),
  SHOOTING("Shooting"),
  DEFENDING("Defending"),
  PHYSICALITY("Physicality"),
  PASSING("Passing");

  private String name;

  SortCriteria(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
