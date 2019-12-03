package com.DanielKeane.controller;

import com.DanielKeane.services.ReleaseService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class HomeController {

  final ReleaseService releaseService;

  public HomeController(ReleaseService releaseService) {
    this.releaseService = releaseService;
  }

  @GetMapping("/home")
  public ModelAndView home() throws IOException, ParseException {
    return new ModelAndView("home").addObject("albumList", releaseService.getReleases());
  }

  @GetMapping("/")
  public String root() {
    return "redirect:/home";
  }

}
