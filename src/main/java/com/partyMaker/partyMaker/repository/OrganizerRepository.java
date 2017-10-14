package com.partyMaker.partyMaker.repository;

import com.partyMaker.partyMaker.model.OrganizerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<OrganizerEntity, Integer> {
    OrganizerEntity findById(Integer id);
    OrganizerEntity findByName(String name);
}
