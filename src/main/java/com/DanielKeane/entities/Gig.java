package com.DanielKeane.entities;

import com.DanielKeane.dao.GigDao;
import com.google.maps.model.LatLng;
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

  private String placeId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime dateTime;

  private String link;
  private LatLng latLng;

  public Gig() {
  }

  public Gig(String placeId, LocalDateTime dateTime, String link, LatLng latLng) {
    this.placeId = placeId;
    this.dateTime = dateTime;
    this.link = link;
    this.latLng = latLng;
  }

  public static Gig of(GigDao gigDao) {
    LocalDateTime localDateTime = LocalDateTime.of(gigDao.getDate(), gigDao.getTime());
    return new Gig(gigDao.getPlaceId(), localDateTime, gigDao.getLink(), null);
  }

  public String getFormattedTime() {
    return this.dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
  }

  @Override
  public String toString() {
    return "Gig{" +
      "ID=" + ID +
      ", venueId='" + placeId + '\'' +
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

  public String getPlaceId() {
    return placeId;
  }

  public void setPlaceId(String placeId) {
    this.placeId = placeId;
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

  public LatLng getLatLng() {
    return latLng;
  }

  public void setLatLng(LatLng latLng) {
    this.latLng = latLng;
  }
}
