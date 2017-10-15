package com.partyMaker.partyMaker.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity extends AbstractEntity {

    private String name;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @ManyToMany
    private List<PartyEntity> parties;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<PartyEntity> getParties() {
        return parties;
    }

    public void setParties(List<PartyEntity> parties) {
        this.parties = parties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
