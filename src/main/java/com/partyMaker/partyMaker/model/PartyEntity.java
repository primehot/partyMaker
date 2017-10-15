package com.partyMaker.partyMaker.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class PartyEntity extends AbstractEntity {

    @ManyToOne
    private UserEntity organizer;
    @ManyToMany
    private List<UserEntity> users;
    @Enumerated(EnumType.STRING)
    private PartyType partyType;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToMany
    private List<TicketEntity> tickets;
    private String hashtagBox;

    public List<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketEntity> tickets) {
        this.tickets = tickets;
    }

    public UserEntity getOrganizer() {
        return organizer;
    }

    public void setOrganizer(UserEntity organizer) {
        this.organizer = organizer;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public PartyType getPartyType() {
        return partyType;
    }

    public void setPartyType(PartyType partyType) {
        this.partyType = partyType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHashtagBox() {
        return hashtagBox;
    }

    public void setHashtagBox(String hashtagBox) {
        this.hashtagBox = hashtagBox;
    }
}
