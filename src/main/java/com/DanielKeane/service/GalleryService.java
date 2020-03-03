package com.DanielKeane.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GalleryService {

  public List<String> getImageURIs() {
    try {
      String galleryDirectory = "/app/DanielKeane/src/main/resources/static/images/gallery";

      return Files.list(new File(galleryDirectory).toPath())
        .map(path -> "/images/gallery/" + path.getFileName().toString())
        .collect(Collectors.toList());
    } catch (IOException e) {
      System.out.println("Gallery not loaded correctly");
      return null;
    }
  }
}
