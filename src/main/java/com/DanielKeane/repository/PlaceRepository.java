package com.DanielKeane.repository;

import com.DanielKeane.entities.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends CrudRepository<Place, String> {
}
