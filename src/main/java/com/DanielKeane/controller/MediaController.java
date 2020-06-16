package com.DanielKeane.controller;

import com.DanielKeane.service.ReleaseService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MediaController {

    ReleaseService releaseService;

    public MediaController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping("music")
    public ModelAndView music() throws IOException, ParseException {
        return new ModelAndView("music")
                .addObject("albums", releaseService.getReleases());
    }

}