package com.partyMaker.partyMaker.service;

import com.partyMaker.partyMaker.dto.PartyDTO;
import com.partyMaker.partyMaker.model.PartyEntity;
import com.partyMaker.partyMaker.repository.OrganizerRepository;
import com.partyMaker.partyMaker.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartyService {

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private OrganizerRepository organizerRepository;

    public Integer createParty(PartyDTO partyInfo) {
        final PartyEntity partyEntity = new PartyEntity();
        partyEntity.setAttendersLimit(partyInfo.getAttendersLimit());
        partyEntity.setDate(partyInfo.getDate());
        partyEntity.setDescription(partyInfo.getDescription());
        partyEntity.setHashtagBox(partyInfo.getHashtagBox());
        partyEntity.setOrganizer(organizerRepository.getOne(partyInfo.getOrganizerId()));
        partyEntity.setTicketPrice(partyInfo.getTicketPrice());
        partyEntity.setPartyType(partyInfo.getPartyType());

        return partyRepository.save(partyEntity).getId();
    }
}
