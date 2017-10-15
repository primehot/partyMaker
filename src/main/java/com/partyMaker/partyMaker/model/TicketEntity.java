package com.partyMaker.partyMaker.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class TicketEntity extends AbstractEntity {

    private Double price;
    @ManyToOne
    private PartyEntity party;
    private String qrCode;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PartyEntity getParty() {
        return party;
    }

    public void setParty(PartyEntity party) {
        this.party = party;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
