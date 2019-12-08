package com.DanielKeane.controller;

import com.DanielKeane.service.GigsService;
import com.DanielKeane.service.ReleaseService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class HomeController {

  private final ReleaseService releaseService;
  private final GigsService gigsService;

  public HomeController(ReleaseService releaseService, GigsService gigsService) {
    this.releaseService = releaseService;
    this.gigsService = gigsService;
  }

  @GetMapping("/home")
  public ModelAndView home() throws IOException, ParseException {
    return new ModelAndView("home")
      .addObject("albums", releaseService.getReleases())
      .addObject("gigs", gigsService.getGigs());
  }

  @GetMapping("/")
  public String root() {
    return "redirect:/home";
  }

}
