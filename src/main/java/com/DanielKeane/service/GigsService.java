package com.DanielKeane.service;

import com.DanielKeane.dao.GigDao;
import com.DanielKeane.entities.Gig;
import com.DanielKeane.repository.GigsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Angus Clinch
 * @version 11/11/2019
 **/
@Service
public class GigsService {

  private Logger logger = LoggerFactory.getLogger(GigsService.class);

  private GigsRepository gigsRepository;

  private PlaceService placeService;

  public GigsService(GigsRepository gigsRepository, PlaceService placeService) {
    this.gigsRepository = gigsRepository;
    this.placeService = placeService;
  }

  public Iterable<Gig> getGigs() {
    return gigsRepository.findAll();
  }

  private void save(Gig gig) {
    gigsRepository.save(gig);
  }

  public void save(GigDao gigDao) {
    Gig gig = Gig.of(gigDao);
    gig.setPlace(placeService.getPlace(gigDao.getPlaceId()));
    save(gig);
  }
}
