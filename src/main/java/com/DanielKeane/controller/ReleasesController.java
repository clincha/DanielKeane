package com.DanielKeane.controller;

import com.DanielKeane.service.ReleaseService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ReleasesController {

  private final ReleaseService releaseService;

  public ReleasesController(ReleaseService releaseService) {
    this.releaseService = releaseService;
  }

  @GetMapping("/releases")
  public ModelAndView releases() throws IOException, ParseException {
    return new ModelAndView("releases")
      .addObject("albumList", releaseService.getReleases())
      .addObject("manageMode", false);
  }

  @GetMapping("/releases/manage")
  public ModelAndView manageReleases() throws IOException, ParseException {
    return new ModelAndView("releases")
      .addObject("albumList", releaseService.getReleases())
      .addObject("manageMode", true);
  }

  @PostMapping("/releases/manage")
  public ModelAndView manageReleases(@RequestParam(name = "albumId") String albumId,
                                     @RequestParam(name = "card-text") String cardText) throws IOException, ParseException {
    releaseService.setReleaseText(albumId, cardText);
    return new ModelAndView("releases")
      .addObject("albumList", releaseService.getReleases())
      .addObject("manageMode", true);
  }

}
