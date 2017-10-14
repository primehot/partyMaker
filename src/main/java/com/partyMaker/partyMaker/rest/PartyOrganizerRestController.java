package com.partyMaker.partyMaker.rest;

import com.partyMaker.partyMaker.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PartyOrganizerRestController {

    @Autowired
    private OrganizerRepository organizerRepository;

    @RequestMapping(path = "/organizers", method = RequestMethod.GET)
    private ResponseEntity getOrganizers() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/{organizerId}", method = RequestMethod.GET)
    private ResponseEntity getOrganizerById(@PathVariable Integer organizerId) {

        return new ResponseEntity(HttpStatus.OK);
    }
}
