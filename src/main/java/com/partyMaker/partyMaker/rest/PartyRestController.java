package com.partyMaker.partyMaker.rest;

import com.partyMaker.partyMaker.dto.PartyDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parties")
public class PartyRestController {

    @RequestMapping(method = RequestMethod.POST)
    private void createParty(@RequestBody PartyDTO partyInfo) {

    }

}
