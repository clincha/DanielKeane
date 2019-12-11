package com.DanielKeane.service;

import com.DanielKeane.repository.PlaceRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MapsApiTests {

  @Mock
  private PlaceRepository placeRepository;
  private PlaceService placeService;

  public MapsApiTests() {
    placeService = new PlaceService(placeRepository);
  }

  @Test
  public void testMapsApiCall() throws ParseException {
    String JSONString = placeService.makeMapsAPICall("ChIJ3euM5ZVO0xQRilR8Be2HpLA");
    LinkedHashMap JSONResponse = new JSONParser(JSONString).parseObject();
    assertEquals("OK", JSONResponse.get("status"));
  }

}
