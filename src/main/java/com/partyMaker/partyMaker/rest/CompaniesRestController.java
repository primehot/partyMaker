package com.partyMaker.partyMaker.rest;

import com.google.gson.Gson;
import com.partyMaker.partyMaker.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompaniesRestController {

    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value = "/companies")
    private ResponseEntity getParties() {
        return new ResponseEntity<>(new Gson().toJson(companyRepository.findAll()), HttpStatus.OK);
    }
}
