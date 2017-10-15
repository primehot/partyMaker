package com.partyMaker.partyMaker.dto;

import com.partyMaker.partyMaker.model.types.PartyType;

import java.util.Date;

public class PartyFilter {
    private PartyType partyType;
    private Date date;

    public PartyType getPartyType() {
        return partyType;
    }

    public void setPartyType(PartyType partyType) {
        this.partyType = partyType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
