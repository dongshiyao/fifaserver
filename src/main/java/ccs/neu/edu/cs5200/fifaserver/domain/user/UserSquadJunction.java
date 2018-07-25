package ccs.neu.edu.cs5200.fifaserver.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "UserSquadJunction")
@IdClass(value = UserSquadKey.class)
public class UserSquadJunction {
  @Id
  @Column(name = "UserName")
  private String userName;

  @Id
  @Column(name = "SquadID")
  private Long squadId;

  public UserSquadJunction() {
  }

  public UserSquadJunction(String userName, Long squadId) {
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
