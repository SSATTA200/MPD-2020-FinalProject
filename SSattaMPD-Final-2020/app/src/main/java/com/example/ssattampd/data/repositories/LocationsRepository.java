package com.example.ssattampd.data.repositories;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ssattampd.data.models.Location;
import com.example.ssattampd.data.sources.locale.DummyLocations;

import java.util.ArrayList;

public class LocationsRepository {

    private MutableLiveData<ArrayList<Location>> _locations = new MutableLiveData<>();
    public LiveData<ArrayList<Location>> locations = _locations;

    public void fetchData() {
        _locations.postValue(DummyLocations.getDummyLocations());
    }
}
