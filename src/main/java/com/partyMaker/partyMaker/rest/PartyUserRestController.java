package com.partyMaker.partyMaker.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartyUserRestController {

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    private ResponseEntity getUsers() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    private ResponseEntity getUserById(@PathVariable Integer userId) {

        return new ResponseEntity(HttpStatus.OK);
    }

}
