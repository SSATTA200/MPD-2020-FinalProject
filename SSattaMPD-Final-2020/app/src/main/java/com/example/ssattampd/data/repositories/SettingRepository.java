package com.example.ssattampd.data.repositories;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import android.content.Context;

import com.example.ssattampd.data.models.UserUpdateRange;
import com.example.ssattampd.data.sources.locale.UserSettingsManager;

public class SettingRepository {

    private UserSettingsManager userSettingsManager = UserSettingsManager.getInstance();

    public void setUserUpdateRange(Context context, UserUpdateRange userUpdateRange) {
        userSettingsManager.setUpdateRange(context, userUpdateRange);
    }

    public UserUpdateRange getUserUpdateRange(Context context) {
        return userSettingsManager.getUserUpdateRange(context);
    }
}
