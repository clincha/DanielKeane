package com.DanielKeane.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Angus Clinch
 * @version 11/11/2019
 **/
public class Gig {

  private String venue;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime datetime;

  private String eventLink;

  public Gig(String venue, LocalDateTime datetime, String eventLink) {
    this.venue = venue;
    this.datetime = datetime;
    this.eventLink = eventLink;
  }

  @Override
  public String toString() {
    return "Gig{" +
      "venue='" + venue + '\'' +
      ", datetime=" + datetime +
      ", eventLink='" + eventLink + '\'' +
      '}';
  }

  public String getVenue() {
    return venue;
  }

  public void setVenue(String venue) {
    this.venue = venue;
  }

  public String getDatetime() {
    return datetime.format(DateTimeFormatter.ISO_DATE_TIME);
  }

  public void setDatetime(LocalDateTime datetime) {
    this.datetime = datetime;
  }

  public String getEventLink() {
    return eventLink;
  }

  public void setEventLink(String eventLink) {
    this.eventLink = eventLink;
  }
}
