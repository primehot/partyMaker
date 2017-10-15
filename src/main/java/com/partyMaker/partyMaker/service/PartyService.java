package com.partyMaker.partyMaker.service;

import com.partyMaker.partyMaker.dto.PartyDTO;
import com.partyMaker.partyMaker.model.PartyEntity;
import com.partyMaker.partyMaker.model.TicketEntity;
import com.partyMaker.partyMaker.model.UserEntity;
import com.partyMaker.partyMaker.repository.PartyRepository;
import com.partyMaker.partyMaker.repository.TicketRepository;
import com.partyMaker.partyMaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static com.partyMaker.partyMaker.service.OperationProgressDescription.*;

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

    public List<TicketEntity> generateTickets(Integer attendersLimit, Double price, PartyEntity partyEntity) {
        for (int i = 0; i < attendersLimit; i++) {
            TicketEntity ticket = new TicketEntity();
            ticket.setParty(partyEntity);
            ticket.setPrice(price);
            ticket.setQrCode(UUID.randomUUID().toString());
            partyEntity.getTickets().add(ticket);
            ticketRepository.save(ticket);
        }
        return ticketRepository.findAll();
    }

    public OperationProgressDescription buyTicket(Integer usedId, Integer partyId) {
        UserEntity user = userRepository.findById(usedId);
        if(user == null) {
            return USER_ISSUE;
        }
        PartyEntity party = partyRepository.findById(partyId);
        if(party == null) {
            return PARTY_ISSUE;
        }
        if(party.getTickets().isEmpty()) {
            return LIMIT_ISSUE;
        }
        TicketEntity ticket = party.getTickets().get(0);

        user.getParties().add(party);
        user.getTickets().add(ticket);

        return OK;
    }
}
