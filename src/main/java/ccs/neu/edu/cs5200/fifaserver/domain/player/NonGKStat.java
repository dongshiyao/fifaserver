package ccs.neu.edu.cs5200.fifaserver.domain.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NonGKStat")
public class NonGKStat extends Player {

  @Column(nullable = false, name = "rw")
  private Integer rw;

  @Column(nullable = false, name = "rf")
  private Integer rf;

  @Column(nullable = false, name = "rm")
  private Integer rm;

  @Column(nullable = false, name = "rb")
  private Integer rb;

  @Column(nullable = false, name = "st")
  private Integer st;

  @Column(nullable = false, name = "cf")
  private Integer cf;

  @Column(nullable = false, name = "cam")
  private Integer cam;

  @Column(nullable = false, name = "cm")
  private Integer cm;

  @Column(nullable = false, name = "cdm")
  private Integer cdm;

  @Column(nullable = false, name = "cb")
  private Integer cb;

  @Column(nullable = false, name = "lw")
  private Integer lw;

  @Column(nullable = false, name = "lf")
  private Integer lf;

  @Column(nullable = false, name = "lm")
  private Integer lm;

  @Column(nullable = false, name = "lb")
  private Integer lb;

  public NonGKStat() {
  }

  public Integer getRw() {
    return rw;
  }

  public void setRw(Integer rw) {
    this.rw = rw;
  }

  public Integer getRf() {
    return rf;
  }

  public void setRf(Integer rf) {
    this.rf = rf;
  }

  public Integer getRm() {
    return rm;
  }

  public void setRm(Integer rm) {
    this.rm = rm;
  }

  public Integer getRb() {
    return rb;
  }

  public void setRb(Integer rb) {
    this.rb = rb;
  }

  public Integer getSt() {
    return st;
  }

  public void setSt(Integer st) {
    this.st = st;
  }

  public Integer getCf() {
    return cf;
  }

  public void setCf(Integer cf) {
    this.cf = cf;
  }

  public Integer getCam() {
    return cam;
  }

  public void setCam(Integer cam) {
    this.cam = cam;
  }

  public Integer getCm() {
    return cm;
  }

  public void setCm(Integer cm) {
    this.cm = cm;
  }

  public Integer getCdm() {
    return cdm;
  }

  public void setCdm(Integer cdm) {
    this.cdm = cdm;
  }

  public Integer getCb() {
    return cb;
  }

  public void setCb(Integer cb) {
    this.cb = cb;
  }

  public Integer getLw() {
    return lw;
  }

  public void setLw(Integer lw) {
    this.lw = lw;
  }

  public Integer getLf() {
    return lf;
  }

  public void setLf(Integer lf) {
    this.lf = lf;
  }

  public Integer getLm() {
    return lm;
  }

  public void setLm(Integer lm) {
    this.lm = lm;
  }

  public Integer getLb() {
    return lb;
  }

  public void setLb(Integer lb) {
    this.lb = lb;
  }
}
