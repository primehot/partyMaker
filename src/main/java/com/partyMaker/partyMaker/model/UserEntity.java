package com.partyMaker.partyMaker.model;

import com.partyMaker.partyMaker.model.types.UserType;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity extends AbstractEntity {

    private String name;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @ManyToMany
    private List<PartyEntity> parties;
    @OneToMany
    private List<TicketEntity> tickets;

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

    public List<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketEntity> tickets) {
        this.tickets = tickets;
    }
}
