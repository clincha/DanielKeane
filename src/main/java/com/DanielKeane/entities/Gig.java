package com.DanielKeane.entities;

import com.DanielKeane.dao.GigDao;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Angus Clinch
 * @version 11/11/2019
 **/
@Entity
public class Gig {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long ID;

  private String venue;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime dateTime;

  private String link;

  public Gig() {
  }

  private Gig(String venue, LocalDateTime dateTime, String link) {
    this.venue = venue;
    this.dateTime = dateTime;
    this.link = link;
  }

  public static Gig of(GigDao gigDao) {
    LocalDateTime localDateTime = LocalDateTime.of(gigDao.getDate(), gigDao.getTime());
    return new Gig(gigDao.getVenue(), localDateTime, gigDao.getLink());
  }

  public String getFormattedTime() {
    return this.dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
  }

  @Override
  public String toString() {
    return "Gig{" +
      "ID=" + ID +
      ", venue='" + venue + '\'' +
      ", dateTime=" + dateTime +
      ", link='" + link + '\'' +
      '}';
  }

  public Long getID() {
    return ID;
  }

  public void setID(Long ID) {
    this.ID = ID;
  }

  public String getVenue() {
    return venue;
  }

  public void setVenue(String venue) {
    this.venue = venue;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
}
