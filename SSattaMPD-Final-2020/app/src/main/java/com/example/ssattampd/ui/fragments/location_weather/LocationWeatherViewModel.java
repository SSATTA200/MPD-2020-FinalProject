package com.example.ssattampd.ui.fragments.location_weather;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ssattampd.data.models.Channel;
import com.example.ssattampd.data.repositories.WeatherRepository;
import com.example.ssattampd.data.sources.locale.UserSettingsManager;

import java.util.Date;

public class LocationWeatherViewModel extends AndroidViewModel {

    public LiveData<Channel> channel;
    public LiveData<String> errorMessage;
    public LiveData<Date> updatedAt;
    public LiveData<Boolean> fetchingData;
    private WeatherRepository weatherRepository;

    public LocationWeatherViewModel(@NonNull Application application) {
        super(application);

        weatherRepository = new WeatherRepository(UserSettingsManager.getInstance().getUserUpdateRange(getApplication()));
        channel = weatherRepository.channel;
        errorMessage = weatherRepository.errorMessage;
        updatedAt = weatherRepository.updatedAt;
        fetchingData = weatherRepository.fetchingData;
    }


    public void fetchData(long locationId) {
        weatherRepository.fetchData(locationId);
    }
}
