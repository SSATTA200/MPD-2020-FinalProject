package com.example.ssattampd.data.models;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "channel")
public class Channel {
    @Element
    private String title;
    @Element
    private String description;
    @Element(name = "image")
    private LocationImage image;

    @ElementList(name = "item", inline = true)
    private ArrayList<WeatherDay> weatherDaysList;

    public List<WeatherDay> getWeatherDaysList() {
        return weatherDaysList;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocationImage getImage() {
        return image;
    }
}
