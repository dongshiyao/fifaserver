package ccs.neu.edu.cs5200.fifaserver.domain.squad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "user_squad_junction")
@IdClass(value = UserSquadKey.class)
public class UserSquadJunction {
  @Id
  @Column(name = "username")
  private String userName;

  @Id
  @Column(name = "squad_id")
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
