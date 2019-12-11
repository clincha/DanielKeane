package com.DanielKeane.service;

import com.DanielKeane.entities.Place;
import com.DanielKeane.exception.MapsApiConnectionException;
import com.DanielKeane.repository.PlaceRepository;
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
public class PlaceService {

  private PlaceRepository placeRepository;
  private Logger logger = LoggerFactory.getLogger(PlaceService.class);

  public PlaceService(PlaceRepository placeRepository) {
    this.placeRepository = placeRepository;
  }

  Place getPlace(String placeId) {
    return placeRepository
      .findById(placeId)
      .orElse(populateDetailsFromId(placeId));
  }

  private Place populateDetailsFromId(String placeId) {
    Place place = new Place(placeId);
    String JSONString = makeMapsAPICall(placeId);
    try {
      LinkedHashMap responseJson = new JSONParser(JSONString).parseObject();
      LinkedHashMap result = (LinkedHashMap) responseJson.get("result");
      LinkedHashMap geometry = (LinkedHashMap) result.get("geometry");
      LinkedHashMap location = (LinkedHashMap) geometry.get("location");

      place.setLatLng(new LatLng(((BigDecimal) location.get("lat")).floatValue(), ((BigDecimal) location.get("lng")).floatValue()));
    } catch (ParseException e) {
      logger.error("Problem reading API return data");
      throw new MapsApiConnectionException("Problem reading API return data", e);
    }
    placeRepository.save(place);
    return place;
  }

  String makeMapsAPICall(String placeId) {
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
    } catch (IOException e) {
      throw new MapsApiConnectionException("Problem with internet connection", e);
    }

    try {
      String content = IOUtils.toString(response.getEntity().getContent());
      try {
        LinkedHashMap responseJson = new JSONParser(content).parseObject();
        if (responseJson.get("status").equals("OK")) {
          client.close();
          return content;
        } else {
          client.close();
          throw new MapsApiConnectionException("Invalid response. Response was: " + content);
        }
      } catch (ParseException e) {
        client.close();
        throw new MapsApiConnectionException("Could not parse JSON content of maps API response", e);
      }
    } catch (IOException e) {
      throw new MapsApiConnectionException("Could not read content of maps API response", e);
    }
  }
}
