package ccs.neu.edu.cs5200.fifaserver.domain.squad;

public enum PosNum {
  ONE("ONE"),
  TWO("TWO"),
  THREE("THREE"),
  FOUR("FOUR"),
  FIVE("FIVE"),
  SIX("SIX"),
  SEVEN("SEVEN"),
  EIGHT("EIGHT"),
  NINE("NINE"),
  TEN("TEN"),
  ELEVEN("ELEVEN");

  private String name;

  PosNum(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
