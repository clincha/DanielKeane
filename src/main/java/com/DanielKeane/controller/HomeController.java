package com.DanielKeane.controller;

import com.DanielKeane.service.ReleaseService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class HomeController {

  private final ReleaseService releaseService;
  private final Counter counter;
  private com.DanielKeane.service.galleryService galleryService;

  public HomeController(ReleaseService releaseService, MeterRegistry meterRegistry, com.DanielKeane.service.galleryService galleryService) {
    this.releaseService = releaseService;
    this.counter = Counter.builder("hits.homepage").register(meterRegistry);
    this.galleryService = galleryService;
  }

  @GetMapping("/home")
  public ModelAndView home() throws IOException, ParseException {
    counter.increment();
    return new ModelAndView("home")
      .addObject("albums", releaseService.getReleases())
      .addObject("gallery", galleryService.getImageURIs());
  }

  @GetMapping("/")
  public String root() {
    return "redirect:/home";
  }

}
