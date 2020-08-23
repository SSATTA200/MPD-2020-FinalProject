package com.example.ssattampd.data.sources.remote;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import com.example.ssattampd.data.sources.remote.services.WeatherApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class WeatherApiClient {

    private static WeatherApiService _instance;

    public static synchronized WeatherApiService getInstance() {
        if (_instance == null) {

            _instance = new Retrofit.Builder()
//                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                    .baseUrl("https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/")
                    .build()
                    .create(WeatherApiService.class);
        }
        return _instance;
    }
}
