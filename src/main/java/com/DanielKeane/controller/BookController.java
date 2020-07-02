package com.DanielKeane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @GetMapping("book")
    public ModelAndView book() {
        return new ModelAndView("book");
    }

}
