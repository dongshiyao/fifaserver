package ccs.neu.edu.cs5200.fifaserver.domain.squad;

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
  @Column(name = "squad_id")
  private Long squadId;

  @Column(nullable = false, name = "squadname")
  private String squadName;

  @Column(nullable = false, name = "formation_name")
  private String formationName;

  @Column(name = "chemistry")
  private Integer chemistry;

  @Column(name = "rating")
  private Integer rating;

  public Squad() {
  }

  public Squad(String squadName, String formationName) {
    this.squadName = squadName;
    this.formationName = formationName;
    this.chemistry = 0;
    this.rating = 0;
  }

  public Long getSquadId() {
    return squadId;
  }

  public void setSquadId(Long squadId) {
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

  public Integer getChemistry() {
    return chemistry;
  }

  public void setChemistry(Integer chemistry) {
    this.chemistry = chemistry;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }
}
