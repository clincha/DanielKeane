package com.DanielKeane.services;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.time.Instant;
import java.util.Base64;
import java.util.LinkedHashMap;

@Service
public class ReleaseService {


  private static final String CLIENT_ID = "47317c5eed3b4029973a44bdfd82dbda";
  private static final String CLIENT_SECRET = "6c4db1dab1224cf5aea69cdd77772d6d";

  public void getAllReleases() throws IOException, ParseException {
    getSpotifyReleases();
  }

  private void getSpotifyReleases() throws IOException, ParseException {
    HttpUriRequest request;
    CloseableHttpResponse response;
    LinkedHashMap responseJson;

    CloseableHttpClient client = HttpClientBuilder.create().build();

    request = RequestBuilder.post()
      .setUri("https://accounts.spotify.com/api/token")
      .setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded")
      .setHeader(HttpHeaders.AUTHORIZATION, "Basic " + getEncodedClientDetails())
      .addParameter("grant_type", "client_credentials")
      .build();

    response = client.execute(request);

    responseJson = new JSONParser(response.getEntity().getContent()).parseObject();

    final String accessToken = responseJson.get("access_token").toString();

    final BigInteger expires_in = (BigInteger) responseJson.get("expires_in");
    final Instant expiry = Instant.now().plusSeconds(expires_in.longValue());

    request = RequestBuilder.get()
      .setUri("https://api.spotify.com/v1/artists/7GijLdxqYBxYpORf7W5ex1")
      .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
      .addParameter("grant_type", "client_credentials")
      .build();

    response = client.execute(request);

    responseJson = new JSONParser(response.getEntity().getContent()).parseObject();

    System.out.println(responseJson);
    // This gets the JSON for Daniel Keane's spotify artist
    response.close();
  }


  private String getEncodedClientDetails() {
    return Base64.getEncoder().withoutPadding().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes());
  }
}
