package com.example.ssattampd.data.models;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "image")
public class LocationImage {
    @Element
    private String url;

    public String getUrl() {
        return url;
    }
}
