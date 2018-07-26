package ccs.neu.edu.cs5200.fifaserver.domain.squad;

public enum Position {
  RW("RW"),
  RF("RF"),
  RM("RM"),
  RB("RB"),
  ST("ST"),
  CF("CF"),
  CAM("CAM"),
  CDM("CDM"),
  CM("CM"),
  CB("CB"),
  LW("LW"),
  LM("LM"),
  LB("LB"),
  LF("LF"),
  GK("GK");

  private String name;

  Position(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
