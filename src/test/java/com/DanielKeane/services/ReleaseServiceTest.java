package com.DanielKeane.services;

import org.apache.tomcat.util.json.ParseException;
import org.junit.Test;

import java.io.IOException;


public class ReleaseServiceTest {

  private final ReleaseService releaseService;

  public ReleaseServiceTest() {
    releaseService = new ReleaseService();
  }

  @Test
  public void testGetSpotifyReleases() throws IOException, ParseException {
    System.out.println(releaseService.getReleases());
  }
}