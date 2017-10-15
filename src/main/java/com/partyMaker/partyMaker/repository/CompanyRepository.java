package com.partyMaker.partyMaker.repository;

import com.partyMaker.partyMaker.model.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
}
