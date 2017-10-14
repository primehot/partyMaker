package com.partyMaker.partyMaker.rest;

import com.google.gson.Gson;
import com.partyMaker.partyMaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartyUserRestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    private ResponseEntity getUsers() {
        return new ResponseEntity<>(new Gson().toJson(userRepository.findAll()), HttpStatus.OK);
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    private ResponseEntity getUserById(@PathVariable Integer userId) {
        return new ResponseEntity<>(new Gson().toJson(userRepository.findById(userId)), HttpStatus.OK);
    }

    @RequestMapping(path = "/{userName}", method = RequestMethod.GET)
    private ResponseEntity getUserByName(@PathVariable Integer userName) {
        return new ResponseEntity<>(new Gson().toJson(userRepository.findById(userName)), HttpStatus.OK);
    }

}
