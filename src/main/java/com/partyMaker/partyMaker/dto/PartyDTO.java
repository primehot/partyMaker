package com.partyMaker.partyMaker.dto;


import com.partyMaker.partyMaker.model.types.PartyType;

import java.util.Collection;
import java.util.Date;

public class PartyDTO {

    private Integer id;
    private Integer organizerId;
    private Collection<Integer> usersId;
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

    public Integer getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Integer organizerId) {
        this.organizerId = organizerId;
    }

    public Collection<Integer> getUsersId() {
        return usersId;
    }

    public void setUsersId(Collection<Integer> usersId) {
        this.usersId = usersId;
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
