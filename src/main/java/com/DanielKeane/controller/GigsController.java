package com.DanielKeane.controller;

import com.DanielKeane.entities.Gig;
import com.DanielKeane.repository.GigsRepository;
import com.DanielKeane.services.GigsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GigsController {

  private GigsService gigsService;
  private GigsRepository gigsRepository;

  public GigsController(GigsService gigsService, GigsRepository gigsRepository) {
    this.gigsService = gigsService;
    this.gigsRepository = gigsRepository;
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
  public ModelAndView saveGig(Gig gig) {
    gigsRepository.save(gig);
    return new ModelAndView("gigs").addObject("gigList", new Gig[]{gig});
  }

}
