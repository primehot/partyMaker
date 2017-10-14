package com.partyMaker.partyMaker.repository;


import com.partyMaker.partyMaker.model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
