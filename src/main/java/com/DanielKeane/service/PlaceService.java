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
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Angus Clinch
 * @version 11/11/2019
 **/
@Service
public class PlaceService {

  private PlaceRepository placeRepository;

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

    place.setLatLng(getGeoDetails(placeId));

    place.setName(getPlaceName(placeId));

    placeRepository.save(place);
    return place;
  }

  String getPlaceName(String placeId) {
    LinkedHashMap responseJson = makeMapsAPICall(placeId, List.of("name"));

    return responseJson.get("name").toString();
  }

  LatLng getGeoDetails(String placeId) {
    LinkedHashMap responseJson = makeMapsAPICall(placeId, List.of("geometry"));
    LinkedHashMap geometry = (LinkedHashMap) responseJson.get("geometry");
    LinkedHashMap location = (LinkedHashMap) geometry.get("location");

    return new LatLng(((BigDecimal) location.get("lat")).floatValue(), ((BigDecimal) location.get("lng")).floatValue());
  }

  LinkedHashMap makeMapsAPICall(String placeId, List<String> fields) {
    HttpUriRequest request;
    CloseableHttpResponse response;
    CloseableHttpClient client = HttpClientBuilder.create().build();

    request = RequestBuilder.get()
      .setUri("https://maps.googleapis.com/maps/api/place/details/json")
      .addParameter("key", "AIzaSyB2Z-2p3uKZfwIja4VukAHGYV9r_9xejQ4")
      .addParameter("place_id", placeId)
      .addParameter("fields", String.join(",", fields))
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
          return (LinkedHashMap) new JSONParser(content).parseObject().get("result");
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
