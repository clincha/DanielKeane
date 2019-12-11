package com.DanielKeane.controller;

import com.DanielKeane.dao.GigDao;
import com.DanielKeane.service.GigsService;
import com.DanielKeane.service.PlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GigsController {

  private GigsService gigsService;
  private PlaceService placeService;

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
  public String saveGig(GigDao gigDao) {
    gigsService.save(gigDao);
    return "redirect:/home";
  }

}
