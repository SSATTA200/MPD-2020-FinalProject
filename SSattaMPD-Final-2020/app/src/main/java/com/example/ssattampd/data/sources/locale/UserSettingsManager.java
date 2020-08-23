package com.example.ssattampd.data.sources.locale;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.ssattampd.data.models.UserUpdateRange;
import com.google.gson.Gson;

public class UserSettingsManager
{
    private static final UserSettingsManager _instance = new UserSettingsManager();
    private static final String USER_UPDATE_RANGE = "USER_UPDATE_RANGE";

    public static UserSettingsManager getInstance() {
        return _instance;
    }

    //private static final UserSettingsManager _instance = new UserSettingsManager();
   //private static final String USER

    private UserSettingsManager() {
    }

    public void setUpdateRange(Context context, UserUpdateRange userUpdateRange) {

        getPreferences(context).edit().putString(USER_UPDATE_RANGE, new Gson().toJson(userUpdateRange)).apply();
    }


    public UserUpdateRange getUserUpdateRange(Context context) {

        UserUpdateRange userUpdateRange = new UserUpdateRange();
        String cachedString = getPreferences(context).getString(USER_UPDATE_RANGE, null);
        if (cachedString != null) {

            Gson gson = new Gson();
            userUpdateRange = gson.fromJson(cachedString, UserUpdateRange.class);
        }
        return userUpdateRange;
    }

    private SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
