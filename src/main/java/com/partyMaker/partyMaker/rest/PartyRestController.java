package com.partyMaker.partyMaker.rest;

import com.google.gson.Gson;
import com.partyMaker.partyMaker.dto.PartyDTO;
import com.partyMaker.partyMaker.model.PartyEntity;
import com.partyMaker.partyMaker.model.types.PartyType;
import com.partyMaker.partyMaker.repository.PartyRepository;
import com.partyMaker.partyMaker.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class PartyRestController {

    @Autowired
    private PartyService partyService;

    @Autowired
    private PartyRepository partyRepository;

    @RequestMapping(value = "/createParty", method = RequestMethod.POST)
    private ResponseEntity createParty(@RequestBody PartyDTO partyInfo) {
        return new ResponseEntity<>("Party Id : " + partyService.createParty(partyInfo) + " was successfully created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/parties")
    private ResponseEntity getParties() {
        return new ResponseEntity<>(new Gson().toJson(partyRepository.findAll()), HttpStatus.OK);
    }

    @RequestMapping(value = "/getFilteredParties/{partyType}")
    private ResponseEntity getFilteredParties(@PathVariable PartyType partyType) {
        List<PartyEntity> items = partyRepository
                .findAll()
                .stream()
                .filter(item -> item.getPartyType() == partyType)
                .collect(Collectors.toList());

        return new ResponseEntity<>(new Gson().toJson(items), HttpStatus.OK);
    }
}
