package com.DanielKeane.services;

import com.DanielKeane.entities.Gig;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Angus Clinch
 * @version 11/11/2019
 **/
@Service
public class GigsService {

  public Gig[] getGigs() {
    Gig gig = new Gig("Cherry Tree", LocalDateTime.now(), "fb.com/hi");
    return new Gig[]{gig};
  }

}
