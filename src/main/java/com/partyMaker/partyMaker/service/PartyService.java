package com.partyMaker.partyMaker.service;

import com.partyMaker.partyMaker.dto.PartyDTO;
import com.partyMaker.partyMaker.model.PartyEntity;
import com.partyMaker.partyMaker.model.TicketEntity;
import com.partyMaker.partyMaker.repository.PartyRepository;
import com.partyMaker.partyMaker.repository.TicketRepository;
import com.partyMaker.partyMaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartyService {

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public Integer createParty(PartyDTO partyInfo) {
        PartyEntity partyEntity = new PartyEntity();
        partyEntity.setDate(partyInfo.getDate());
        partyEntity.setDescription(partyInfo.getDescription());
        partyEntity.setHashtagBox(partyInfo.getHashtagBox());
        partyEntity.setOrganizer(userRepository.getOne(partyInfo.getOrganizerId()));
        partyEntity.setPartyType(partyInfo.getPartyType());
        partyEntity = partyRepository.save(partyEntity);

        generateTickets(partyInfo.getAttendersLimit(), partyInfo.getTicketPrice(), partyEntity);

        return partyEntity.getId();
    }

    private void generateTickets(Integer attendersLimit, Double price, PartyEntity partyEntity) {
        for(int i = 0; i < attendersLimit; i++) {
            TicketEntity ticket = new TicketEntity();
            ticket.setParty(partyEntity);
            ticket.setPrice(price);
            ticketRepository.save(ticket);
        }
    }
}
