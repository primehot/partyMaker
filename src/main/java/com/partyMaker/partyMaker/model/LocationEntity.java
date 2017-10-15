package com.partyMaker.partyMaker.model;

import javax.persistence.Entity;

@Entity
public class LocationEntity extends AbstractEntity {

    private Integer attendersLimit;
    private String address;
    private String geoLocation;

    public Integer getAttendersLimit() {
        return attendersLimit;
    }

    public void setAttendersLimit(Integer attendersLimit) {
        this.attendersLimit = attendersLimit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }
}
