package com.DanielKeane.controller;

import com.DanielKeane.entities.Gig;
import com.DanielKeane.services.GigsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GigsController {

  private GigsService gigsService;

  @Autowired
  public GigsController(GigsService gigsService) {
    this.gigsService = gigsService;
  }

  @GetMapping("/gigs")
  public ModelAndView gigs() {
    return new ModelAndView("gigs").addObject("gigList", gigsService.getGigs());
  }

  @GetMapping("/gigs/manage")
  public ModelAndView manageGigs() {
    return new ModelAndView("manageGigs");
  }

  @PostMapping("/gigs/manage")
  public ModelAndView saveGig(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Gig gig) {
    System.out.println(gig);
    return new ModelAndView("gigs").addObject("gigList", new Gig[]{gig});
  }

}
