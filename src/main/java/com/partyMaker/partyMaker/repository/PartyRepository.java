package com.partyMaker.partyMaker.repository;

import com.partyMaker.partyMaker.model.PartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<PartyEntity, Integer> {
    PartyEntity findById(Integer id);
}
