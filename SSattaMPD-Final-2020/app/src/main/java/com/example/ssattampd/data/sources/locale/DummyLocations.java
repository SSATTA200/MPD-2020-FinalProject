package com.example.ssattampd.data.sources.locale;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import com.example.ssattampd.data.models.Location;

import java.util.ArrayList;

public class DummyLocations {

    public static ArrayList<Location> getDummyLocations() {

        ArrayList<Location> data = new ArrayList<>();

        //Will use GCU Glasgow/London/NewYork
        //I need to choose which part of Oman, Bangla, Maur to choose (Come back to thsi)
        //Some locations not working. Need to Come back to this
        //Fixed
        //remember to delete unneeded comments

        data.add(new Location("Glasgow", "Glasgow Caledonian University", 2648579));
        data.add(new Location("London", "GCU London", 2643743));
        data.add(new Location("New York", "CGU New York", 5128581));
        data.add(new Location("Muscat", "Oman - Sultan Qaboos University", 287286));
        data.add(new Location("Mauritius", "University of Mauritius", 934154));
        data.add(new Location("Dhaka", "Bangladesh - University of Dhaka", 1185241));

        return data;
    }
}
