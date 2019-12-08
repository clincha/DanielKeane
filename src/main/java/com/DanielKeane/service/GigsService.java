package com.DanielKeane.service;

import com.DanielKeane.entities.Gig;
import com.DanielKeane.repository.GigsRepository;
import org.springframework.stereotype.Service;

/**
 * @author Angus Clinch
 * @version 11/11/2019
 **/
@Service
public class GigsService {

  private GigsRepository gigsRepository;

  public GigsService(GigsRepository gigsRepository) {
    this.gigsRepository = gigsRepository;
  }

  public Iterable<Gig> getGigs() {
    return gigsRepository.findAll();
  }

  public void save(Gig gig) {
    gigsRepository.save(gig);
  }
}
