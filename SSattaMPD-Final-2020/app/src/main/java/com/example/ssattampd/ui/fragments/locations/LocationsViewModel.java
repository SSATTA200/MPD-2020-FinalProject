package com.example.ssattampd.ui.fragments.locations;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ssattampd.data.models.Location;
import com.example.ssattampd.data.repositories.LocationsRepository;

import java.util.ArrayList;

public class LocationsViewModel extends AndroidViewModel {

    private LocationsRepository locationsRepository;
    public LiveData<ArrayList<Location>> locations;

    public LocationsViewModel(@NonNull Application application) {
        super(application);
        locationsRepository = new LocationsRepository();
        locations = locationsRepository.locations;
    }

    public void fetchData() {
        locationsRepository.fetchData();
    }
}
