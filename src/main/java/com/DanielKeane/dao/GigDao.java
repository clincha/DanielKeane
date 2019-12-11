package com.DanielKeane.dao;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class GigDao {

  private String placeId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private LocalTime time;

  private String link;

  @Override
  public String toString() {
    return "GigDao{" +
      "placeId='" + placeId + '\'' +
      ", date=" + date +
      ", time=" + time +
      ", link='" + link + '\'' +
      '}';
  }

  public GigDao(String placeId, LocalDate date, LocalTime time, String link) {
    this.placeId = placeId;
    this.date = date;
    this.time = time;
    this.link = link;
  }

  public String getPlaceId() {
    return placeId;
  }

  public void setPlaceId(String placeId) {
    this.placeId = placeId;
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
