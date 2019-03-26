package com.DanielKeane.controller;

import com.DanielKeane.entities.Gig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GigsController {

    @GetMapping("/gigs")
    public ModelAndView gigs() {
        List<Gig> gigList = new ArrayList<>(3);
        gigList.add(new Gig("Cherry Tree", LocalDateTime.now(), 100));
        gigList.add(new Gig("Spoons", LocalDateTime.now(), 100));
        gigList.add(new Gig("Black Griffin", LocalDateTime.now(), 100));
        return new ModelAndView("gigs")
                .addObject("gigList", gigList);
    }

}
