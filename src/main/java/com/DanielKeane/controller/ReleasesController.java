package com.DanielKeane.controller;

import com.DanielKeane.services.ReleaseService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
      .addObject("albumList", releaseService.getReleases());
  }



}
