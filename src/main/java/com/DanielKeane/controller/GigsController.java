package com.DanielKeane.controller;

import com.DanielKeane.dao.GigDao;
import com.DanielKeane.entities.Gig;
import com.DanielKeane.repository.GigsRepository;
import com.DanielKeane.service.GigsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GigsController {

  private GigsService gigsService;

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
    Gig gig = Gig.of(gigDao);
    gigsService.save(gig);
    return "redirect:/home";
  }

}
