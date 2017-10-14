package com.partyMaker.partyMaker.rest;

import com.partyMaker.partyMaker.dto.PartyDTO;
import com.partyMaker.partyMaker.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/parties")
public class PartyRestController {

    @Autowired
    private PartyService partyService;

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity createParty(@RequestBody PartyDTO partyInfo) {
        return new ResponseEntity<>("Party Id : " + partyService.createParty(partyInfo) + " was successfully created", HttpStatus.CREATED);
    }

}
