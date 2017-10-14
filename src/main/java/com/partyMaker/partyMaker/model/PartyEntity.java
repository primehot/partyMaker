package com.partyMaker.partyMaker.model;

import java.util.Collection;
import java.util.Date;

public class PartyEntity {

    private Integer id;
    private OrganizerEntity organizer;
    private Collection<UserEntity> users;
    private PartyType partyType;
    private Double ticketPrice;
    private String description;
    private Date date;
    private Integer attendersLimit;
    private String hashtagBox;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrganizerEntity getOrganizer() {
        return organizer;
    }

    public void setOrganizer(OrganizerEntity organizer) {
        this.organizer = organizer;
    }

    public Collection<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserEntity> users) {
        this.users = users;
    }

    public PartyType getPartyType() {
        return partyType;
    }

    public void setPartyType(PartyType partyType) {
        this.partyType = partyType;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
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

    public Integer getAttendersLimit() {
        return attendersLimit;
    }

    public void setAttendersLimit(Integer attendersLimit) {
        this.attendersLimit = attendersLimit;
    }

    public String getHashtagBox() {
        return hashtagBox;
    }

    public void setHashtagBox(String hashtagBox) {
        this.hashtagBox = hashtagBox;
    }
}
