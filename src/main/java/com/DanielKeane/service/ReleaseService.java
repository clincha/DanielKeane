package com.DanielKeane.service;

import com.DanielKeane.entities.Album;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;

@Service
public class ReleaseService {

  @Value("${spotify.connection.id}")
  private String CLIENT_ID;

  @Value("${spotify.connection.secret}")
  private String CLIENT_SECRET;

  public ArrayList<Album> getReleases() throws IOException, ParseException {
    HttpUriRequest request;
    CloseableHttpResponse response;
    LinkedHashMap<String, Object> responseJson;

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

    request = RequestBuilder.get()
      .setUri("https://api.spotify.com/v1/artists/7GijLdxqYBxYpORf7W5ex1/albums")
      .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
      .build();

    response = client.execute(request);

    responseJson = new JSONParser(response.getEntity().getContent()).parseObject();

    ArrayList<LinkedHashMap<String, Object>> albumsJson = (ArrayList<LinkedHashMap<String, Object>>) responseJson.get("items");

    ArrayList<Album> albums = new ArrayList<>(albumsJson.size());

    for (LinkedHashMap<String, Object> albumJson : albumsJson) {
      Album album = new Album(
        albumJson.get("id").toString(),
        albumJson.get("name").toString(),
        albumJson.get("album_group").toString(),
        ((BigInteger) albumJson.get("total_tracks")).intValue(),
        LocalDate.parse((CharSequence) albumJson.get("release_date"))
      );
      albums.add(album);
    }
    albums.removeIf(album -> album.getAlbumGroup().equals("appears_on"));
    return albums;
  }

  private String getEncodedClientDetails() {
    return Base64.getEncoder().withoutPadding().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes());
  }
}
