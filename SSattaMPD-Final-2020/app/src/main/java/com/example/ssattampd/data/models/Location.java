package com.example.ssattampd.data.models;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import java.io.Serializable;

public class Location implements Serializable {

    private String city;
    private String university;
    private long locationId;

    public Location(String city, String university, long locationId) {
        this.city = city;
        this.university = university;
        this.locationId = locationId;
    }

    public String getCity() {
        return city;
    }

    public String getUniversity() {
        return university;
    }

    public long getLocationId() {
        return locationId;
    }
}
