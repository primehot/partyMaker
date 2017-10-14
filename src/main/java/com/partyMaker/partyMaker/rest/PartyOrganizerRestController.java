package com.partyMaker.partyMaker.rest;

import com.partyMaker.partyMaker.model.OrganizerEntity;
import com.partyMaker.partyMaker.model.UserEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("/organizers")
public class PartyOrganizerRestController {

    @RequestMapping(method = RequestMethod.GET)
    private Collection<OrganizerEntity> getOrganizers() {
        OrganizerEntity organizer1 = new OrganizerEntity();
        OrganizerEntity organizer2 = new OrganizerEntity();

        organizer1.setId(1);
        organizer1.setName("O1");
        organizer2.setId(2);
        organizer2.setName("O2");

        return Arrays.asList(organizer1, organizer2);
    }

    @RequestMapping(path = "/{organizerId}", method = RequestMethod.GET)
    private OrganizerEntity getOrganizer2(@PathVariable Integer organizerId) {
        OrganizerEntity organizer1 = new OrganizerEntity();
        organizer1.setId(1);
        organizer1.setName("O1");

        return organizer1;
    }
}
