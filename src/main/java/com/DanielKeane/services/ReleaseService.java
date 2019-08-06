package com.DanielKeane.services;

import com.DanielKeane.entities.Album;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;

@Service
public class ReleaseService {


  private static final String CLIENT_ID = "47317c5eed3b4029973a44bdfd82dbda";
  private static final String CLIENT_SECRET = "";

  public ArrayList<Album> getReleases() throws IOException, ParseException {
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
      .setUri("https://api.spotify.com/v1/artists/7GijLdxqYBxYpORf7W5ex1/albums")
      .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
      .build();

    response = client.execute(request);

    responseJson = new JSONParser(response.getEntity().getContent()).parseObject();

    ArrayList<LinkedHashMap<Object, Object>> albumsJson = (ArrayList<LinkedHashMap<Object, Object>>) responseJson.get("items");

    ArrayList<Album> albums = new ArrayList<>(albumsJson.size());

    for (LinkedHashMap<Object, Object> albumJson : albumsJson) {
      Album album = new Album(
        albumJson.get("id").toString(),
        albumJson.get("name").toString(),
        albumJson.get("album_group").toString(),
        ((BigInteger) albumJson.get("total_tracks")).intValue(),
        LocalDate.parse((CharSequence) albumJson.get("release_date"))
      );

      albums.add(album);
    }

    return albums;
  }


  private String getEncodedClientDetails() {
    return Base64.getEncoder().withoutPadding().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes());
  }
}
