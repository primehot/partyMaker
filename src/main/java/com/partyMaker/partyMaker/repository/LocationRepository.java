package com.partyMaker.partyMaker.repository;

import com.partyMaker.partyMaker.model.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {
}
