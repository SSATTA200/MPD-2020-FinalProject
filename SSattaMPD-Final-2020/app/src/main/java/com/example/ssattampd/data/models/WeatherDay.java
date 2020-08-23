package com.example.ssattampd.data.models;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Root(name = "item")
public class WeatherDay implements Serializable {

    @Element
    private String title;
    @Element
    private String link;
    @Element
    private String description;
    @Element
    private String pubDate;
    @Element
    private String guid;

    private String temperature;
    private String windDirection;
    private String windSpeed;
    private String visibility;
    private String pressure;
    private String humidity;
    private String uv;
    private String pollution;
    private String sunset;


    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getGuid() {
        return guid;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getUv() {
        return uv;
    }

    public String getPollution() {
        return pollution;
    }

    public String getSunset() {
        return sunset;
    }

    public void refillAttributes() {
        String[] a = description.split(",");

        // for only today the description will have 10 attributes not just nine
        // it will have min and max temperature
        int offset = a.length == 9 ? 0 : 1;
        temperature = getItem(a, offset + 0);
        windDirection = getItem(a, offset + 1);
        windSpeed = getItem(a, offset + 2);
        visibility = getItem(a, offset + 3);
        pressure = getItem(a, offset + 4);
        humidity = getItem(a, offset + 5);
        uv = getItem(a, offset + 6);
        pollution = getItem(a, offset + 7);
        sunset = getItem(a, offset + 8);
    }

    private String getItem(String[] a, int index) {
        if (a == null || a.length <= index)
            return "";

        String[] split = a[index].split("(\\w| )+:");
        String s = "";
        for (int i = 1; i < split.length; i++)
            s += split[i];
        return s.trim();
    }
}
