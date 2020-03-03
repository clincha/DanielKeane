package com.DanielKeane.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GalleryService {

  private static final String GALLERY_DIRECTORY = "src/main/resources/static/images/gallery";

  public List<String> getImageURIs() {
    try {

      return Files.list(new File(GALLERY_DIRECTORY).toPath())
        .map(path -> "/images/gallery/" + path.getFileName().toString())
        .collect(Collectors.toList());
    } catch (IOException e) {
      System.out.println("Gallery not loaded correctly");
      return null;
    }
  }
}
