package com.partyMaker.partyMaker.rest;

import com.partyMaker.partyMaker.model.UserEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("/users")
public class PartyUserRestController {

    @RequestMapping(method = RequestMethod.GET)
    private Collection<UserEntity> getUsers() {
        UserEntity user1 = new UserEntity();
        UserEntity user2 = new UserEntity();

        user1.setId(1);
        user1.setName("U1");
        user2.setId(2);
        user2.setName("U2");

        return Arrays.asList(user1, user2);
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    private UserEntity getUser(@PathVariable Integer userId) {
        UserEntity user1 = new UserEntity();
        user1.setId(1);
        user1.setName("U1");

        return user1;
    }

}
