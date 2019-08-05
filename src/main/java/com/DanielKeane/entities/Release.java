package com.DanielKeane.entities;

public class Release {

  private String name;
  private String description;
  private String spotifyPlayerUrl;

  public Release(String name, String description, String spotifyPlayerUrl) {
    this.name = name;
    this.description = description;
    this.spotifyPlayerUrl = spotifyPlayerUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSpotifyPlayerUrl() {
    return spotifyPlayerUrl;
  }

  public void setSpotifyPlayerUrl(String spotifyPlayerUrl) {
    this.spotifyPlayerUrl = spotifyPlayerUrl;
  }
}
