package com.DanielKeane.entities;

import com.DanielKeane.dao.GigDao;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime dateTime;

  private String link;

  @ManyToOne
  private Place place;

  public Gig() {
  }

  private Gig(String placeId, LocalDateTime dateTime, String link) {
    this.dateTime = dateTime;
    this.link = link;
    this.place = new Place(placeId);
  }

  public static Gig of(GigDao gigDao) {
    LocalDateTime localDateTime = LocalDateTime.of(gigDao.getDate(), gigDao.getTime());
    return new Gig(gigDao.getPlaceId(), localDateTime, gigDao.getLink());
  }

  public String getFormattedTime() {
    return this.dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
  }

  @Override
  public String toString() {
    return "Gig{" +
      "ID=" + ID +
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

  public Place getPlace() {
    return place;
  }

  public void setPlace(Place place) {
    this.place = place;
  }
}
