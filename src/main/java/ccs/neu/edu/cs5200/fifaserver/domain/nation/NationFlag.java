package ccs.neu.edu.cs5200.fifaserver.domain.nation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NationFlag")
public class NationFlag {
  @Id
  @Column(name = "Nation")
  private String nation;

  @Column(nullable = false, name = "Flag")
  private String flag;

  public NationFlag() {
  }

  public NationFlag(String nation, String flag) {
    this.nation = nation;
    this.flag = flag;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }
}
