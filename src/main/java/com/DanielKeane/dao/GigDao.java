package com.DanielKeane.dao;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class GigDao {

  private String venue;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private LocalTime time;

  private String link;

  public GigDao(String venue, LocalDate date, LocalTime time, String link) {
    this.venue = venue;
    this.date = date;
    this.time = time;
    this.link = link;
  }

  @Override
  public String toString() {
    return "GigDao{" +
      "venue='" + venue + '\'' +
      ", date=" + date +
      ", time=" + time +
      ", link='" + link + '\'' +
      '}';
  }

  public String getVenue() {
    return venue;
  }

  public void setVenue(String venue) {
    this.venue = venue;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalTime getTime() {
    return time;
  }

  public void setTime(LocalTime time) {
    this.time = time;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
}
