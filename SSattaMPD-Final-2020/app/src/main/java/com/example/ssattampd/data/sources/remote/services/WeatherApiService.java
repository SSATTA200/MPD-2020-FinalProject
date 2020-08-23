package com.example.ssattampd.data.sources.remote.services;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import com.example.ssattampd.data.models.responses.LocationWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherApiService {

    @GET("3day/{locationID}")
    Call<LocationWeatherResponse> getThreeDaysWeather(@Path("locationID") long locationId);
}
