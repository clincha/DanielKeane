package com.DanielKeane.service;

import com.DanielKeane.repository.PlaceRepository;
import com.google.maps.model.LatLng;
import com.sun.tools.javac.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class MapsApiTests {

  @Mock
  private PlaceRepository placeRepository;
  private PlaceService placeService;

  public MapsApiTests() {
    placeService = new PlaceService(placeRepository);
  }

  @Test
  public void placeNameTest() {
    String name = placeService.getPlaceName("ChIJ3euM5ZVO0xQRilR8Be2HpLA");
    assertEquals(name, "ANKAmall");
  }

  @Test
  public void placeGeoTest() {
    LatLng latLng = placeService.getGeoDetails("ChIJ3euM5ZVO0xQRilR8Be2HpLA");
    assertEquals(39.95100784301758, latLng.lat, 0.0001);
    assertEquals(32.83171081542969, latLng.lng, 0.0001);
  }

  @Test
  public void testMapsApiCall() {
    LinkedHashMap JSONResponse = placeService.makeMapsAPICall("ChIJ3euM5ZVO0xQRilR8Be2HpLA", List.of("name"));
    assertNotNull(JSONResponse.get("name"));

    JSONResponse = placeService.makeMapsAPICall("ChIJ3euM5ZVO0xQRilR8Be2HpLA", List.of("geometry"));
    assertNotNull(JSONResponse.get("geometry"));
  }

}
