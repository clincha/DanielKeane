package com.DanielKeane;

import com.DanielKeane.repository.GigsRepository;
import com.DanielKeane.service.GigsService;
import com.google.maps.model.LatLng;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class gigServiceTest {

  @MockBean
  private GigsRepository gigsRepository;

  private GigsService gigsService;

  public gigServiceTest() {
    gigsService = new GigsService(gigsRepository);
  }

  @Test
  public void getPlaceDetails() {
    LatLng actual = gigsService.getLatLong("ChIJrTLr-GyuEmsRBfy61i59si0");
    LatLng expected = new LatLng(-33.8675921, 151.2015849);
    assertEquals(expected.lat, actual.lat, 0.0001);
    assertEquals(expected.lng, actual.lng, 0.0001);
  }

}
