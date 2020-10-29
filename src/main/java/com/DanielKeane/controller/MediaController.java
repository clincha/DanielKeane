package com.DanielKeane.controller;

import com.DanielKeane.service.GalleryService;
import com.DanielKeane.service.ReleaseService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MediaController {

    private final GalleryService galleryService;
    ReleaseService releaseService;

    public MediaController(ReleaseService releaseService, GalleryService galleryService) {
        this.releaseService = releaseService;
        this.galleryService = galleryService;
    }

    @GetMapping("music")
    public ModelAndView music() throws IOException, ParseException {
        return new ModelAndView("music")
                .addObject("albums", releaseService.getReleases());
    }

    @GetMapping("consultancy")
    public ModelAndView consultancy() {
        return new ModelAndView("consultancy")
                .addObject("gallery", galleryService.getImageURIs());
    }

    @GetMapping("podcast")
    public ModelAndView podcast() {
        return new ModelAndView("podcast");
    }

}
