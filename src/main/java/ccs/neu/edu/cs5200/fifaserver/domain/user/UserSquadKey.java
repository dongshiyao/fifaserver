package ccs.neu.edu.cs5200.fifaserver.domain.user;

import java.io.Serializable;

public class UserSquadKey implements Serializable {
  private String userName;
  private Long squadId;

  public UserSquadKey() {
  }

  public UserSquadKey(String userName, Long squadId) {
    this.userName = userName;
    this.squadId = squadId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Long getSquadId() {
    return squadId;
  }

  public void setSquadId(Long squadId) {
    this.squadId = squadId;
  }
}
