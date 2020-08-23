package com.example.ssattampd.data.models.responses;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import com.example.ssattampd.data.models.Channel;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss")
public class LocationWeatherResponse {

    @Element
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }
}
