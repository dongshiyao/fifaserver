package ccs.neu.edu.cs5200.fifaserver.domain.squad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Formation")
public class Formation {
  @Id
  @Column(nullable = false, name = "FormationName")
  private String formationName;

  @Column(nullable = false, name = "FormationPhoto")
  private String formationPhoto;

  @Column(nullable = false, name = "Pos1")
  private Position pos1;

  @Column(nullable = false, name = "Pos2")
  private Position pos2;

  @Column(nullable = false, name = "Pos3")
  private Position pos3;

  @Column(nullable = false, name = "Pos4")
  private Position pos4;

  @Column(nullable = false, name = "Pos5")
  private Position pos5;

  @Column(nullable = false, name = "Pos6")
  private Position pos6;

  @Column(nullable = false, name = "Pos7")
  private Position pos7;

  @Column(nullable = false, name = "Pos8")
  private Position pos8;

  @Column(nullable = false, name = "Pos9")
  private Position pos9;

  @Column(nullable = false, name = "Pos10")
  private Position pos10;

  @Column(nullable = false, name = "Pos11")
  private Position pos11;

  public Formation() {
  }

  public Formation(String formationName, String formationPhoto, Position pos1, Position pos2,
                   Position pos3, Position pos4, Position pos5, Position pos6, Position pos7,
                   Position pos8, Position pos9, Position pos10, Position pos11) {
    this.formationName = formationName;
    this.formationPhoto = formationPhoto;
    this.pos1 = pos1;
    this.pos2 = pos2;
    this.pos3 = pos3;
    this.pos4 = pos4;
    this.pos5 = pos5;
    this.pos6 = pos6;
    this.pos7 = pos7;
    this.pos8 = pos8;
    this.pos9 = pos9;
    this.pos10 = pos10;
    this.pos11 = pos11;
  }

  public String getFormationName() {
    return formationName;
  }

  public void setFormationName(String formationName) {
    this.formationName = formationName;
  }

  public String getFormationPhoto() {
    return formationPhoto;
  }

  public void setFormationPhoto(String formationPhoto) {
    this.formationPhoto = formationPhoto;
  }

  public Position getPos1() {
    return pos1;
  }

  public void setPos1(Position pos1) {
    this.pos1 = pos1;
  }

  public Position getPos2() {
    return pos2;
  }

  public void setPos2(Position pos2) {
    this.pos2 = pos2;
  }

  public Position getPos3() {
    return pos3;
  }

  public void setPos3(Position pos3) {
    this.pos3 = pos3;
  }

  public Position getPos4() {
    return pos4;
  }

  public void setPos4(Position pos4) {
    this.pos4 = pos4;
  }

  public Position getPos5() {
    return pos5;
  }

  public void setPos5(Position pos5) {
    this.pos5 = pos5;
  }

  public Position getPos6() {
    return pos6;
  }

  public void setPos6(Position pos6) {
    this.pos6 = pos6;
  }

  public Position getPos7() {
    return pos7;
  }

  public void setPos7(Position pos7) {
    this.pos7 = pos7;
  }

  public Position getPos8() {
    return pos8;
  }

  public void setPos8(Position pos8) {
    this.pos8 = pos8;
  }

  public Position getPos9() {
    return pos9;
  }

  public void setPos9(Position pos9) {
    this.pos9 = pos9;
  }

  public Position getPos10() {
    return pos10;
  }

  public void setPos10(Position pos10) {
    this.pos10 = pos10;
  }

  public Position getPos11() {
    return pos11;
  }

  public void setPos11(Position pos11) {
    this.pos11 = pos11;
  }
}
