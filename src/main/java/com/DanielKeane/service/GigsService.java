package com.DanielKeane.service;

import com.DanielKeane.entities.Gig;
import com.DanielKeane.repository.GigsRepository;
import com.google.maps.model.LatLng;
import io.micrometer.core.instrument.util.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;

/**
 * @author Angus Clinch
 * @version 11/11/2019
 **/
@Service
public class GigsService {

  private Logger log = LoggerFactory.getLogger(GigsService.class);

  private GigsRepository gigsRepository;

  public GigsService(GigsRepository gigsRepository) {
    this.gigsRepository = gigsRepository;
  }

  public Iterable<Gig> getGigs() {
    return gigsRepository.findAll();
  }

  public void save(Gig gig) {
    gig.setLatLng(getLatLong(gig.getPlaceId()));
    gigsRepository.save(gig);
  }

  public LatLng getLatLong(String placeId) {
    HttpUriRequest request;
    CloseableHttpResponse response;

    CloseableHttpClient client = HttpClientBuilder.create().build();

    request = RequestBuilder.get()
      .setUri("https://maps.googleapis.com/maps/api/place/details/json")
      .addParameter("key", "AIzaSyB2Z-2p3uKZfwIja4VukAHGYV9r_9xejQ4")
      .addParameter("place_id", placeId)
      .addParameter("fields", "geometry")
      .build();

    try {
      response = client.execute(request);
      String JSONString = IOUtils.toString(response.getEntity().getContent());
      LinkedHashMap responseJson = new JSONParser(JSONString).parseObject();
      LinkedHashMap result = (LinkedHashMap) responseJson.get("result");
      LinkedHashMap geometry = (LinkedHashMap) result.get("geometry");
      LinkedHashMap location = (LinkedHashMap) geometry.get("location");
      return new LatLng(((BigDecimal) location.get("lat")).floatValue(), ((BigDecimal) location.get("lng")).floatValue());
    } catch (IOException | ParseException e) {
      log.error("Problem with to maps API");
      e.printStackTrace();
    }
    return null;
  }
}
