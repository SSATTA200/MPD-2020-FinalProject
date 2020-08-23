package com.example.ssattampd.ui.fragments.settings;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.ssattampd.data.models.UserUpdateRange;
import com.example.ssattampd.data.repositories.SettingRepository;

public class SettingsViewModel extends AndroidViewModel {

    private SettingRepository settingRepository;

    public SettingsViewModel(@NonNull Application application) {
        super(application);
        settingRepository = new SettingRepository();
    }

    public void setUserRange(int min, int max) {
        settingRepository.setUserUpdateRange(getApplication(), new UserUpdateRange(min, max));
    }

    public void getUserRange(int min, int max) {
        settingRepository.setUserUpdateRange(getApplication(), new UserUpdateRange(min, max));
    }

    public UserUpdateRange getUserUpdateRange() {
        return settingRepository.getUserUpdateRange(getApplication());
    }
}
