package com.DanielKeane.repository;

import com.DanielKeane.entities.Gig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GigsRepository extends CrudRepository<Gig, Long> {
}
