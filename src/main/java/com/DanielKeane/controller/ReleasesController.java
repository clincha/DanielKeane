package com.DanielKeane.controller;

import com.DanielKeane.entities.Cd;
import com.DanielKeane.entities.Tshirt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReleasesController {

    @GetMapping("/releases")
    public ModelAndView releases() {
        Cd cd = new Cd("Suburban Ballet",
                "https://i.scdn.co/image/b56cdf27681ccca512849e74c4e03029960ae7e8",
                "This is a EP about love");

        List<Tshirt> tShirts = new ArrayList<>(1);
        tShirts.add(new Tshirt("Test Shirt",
                "https://popcollectorsalliance.com/wp-content/uploads/2018/12/mockup-bb5fc23c.jpg",
                100
        ));
        tShirts.add(new Tshirt("Test Shirt",
                "https://popcollectorsalliance.com/wp-content/uploads/2018/12/mockup-bb5fc23c.jpg",
                100
        ));
        tShirts.add(new Tshirt("Test Shirt",
                "https://popcollectorsalliance.com/wp-content/uploads/2018/12/mockup-bb5fc23c.jpg",
                100
        ));
        tShirts.add(new Tshirt("Test Shirt",
                "https://popcollectorsalliance.com/wp-content/uploads/2018/12/mockup-bb5fc23c.jpg",
                100
        ));
        tShirts.add(new Tshirt("Test Shirt",
                "https://popcollectorsalliance.com/wp-content/uploads/2018/12/mockup-bb5fc23c.jpg",
                100
        ));

        return new ModelAndView("releases")
                .addObject("cd", cd)
                .addObject("tShirtsList", tShirts);
    }

}
