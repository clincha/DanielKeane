package com.DanielKeane.entities;

import java.time.LocalDate;

/**
 * @author Angus Clinch
 * @version 11/11/2019
 **/
public class Gig {

  private String location;
  private LocalDate time;

  public Gig(String location, LocalDate time) {
    this.location = location;
    this.time = time;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public LocalDate getTime() {
    return time;
  }

  public void setTime(LocalDate time) {
    this.time = time;
  }
}
