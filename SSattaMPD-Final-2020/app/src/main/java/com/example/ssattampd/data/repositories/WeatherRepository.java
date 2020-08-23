package com.example.ssattampd.data.repositories;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ssattampd.Utils;
import com.example.ssattampd.data.models.Channel;
import com.example.ssattampd.data.models.UserUpdateRange;
import com.example.ssattampd.data.models.WeatherDay;
import com.example.ssattampd.data.models.responses.LocationWeatherResponse;
import com.example.ssattampd.data.sources.remote.WeatherApiClient;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    private static final long ONE_MINUTE = 1000 * 60;
    private MutableLiveData<Channel> _channel = new MutableLiveData<>();
    public LiveData<Channel> channel = _channel;
    private MutableLiveData<String> _errorMessage = new MutableLiveData<>();
    public LiveData<String> errorMessage = _errorMessage;
    private MutableLiveData<Date> _updatedAt = new MutableLiveData<>();
    public LiveData<Date> updatedAt = _updatedAt;
    public MutableLiveData<Boolean> _fetchingData = new MutableLiveData<>();
    public LiveData<Boolean> fetchingData = _fetchingData;

    private long locationId;
    private Timer timer;
    private UserUpdateRange userUpdateRange;

    public WeatherRepository(UserUpdateRange userUpdateRange) {
        this.userUpdateRange = userUpdateRange;
    }

    public void fetchData(long locationId) {
        Log.d("com.test", "" + userUpdateRange.getMin() + " - " + userUpdateRange.getMax());
        this.locationId = locationId;
        _fetchingData.postValue(true);
        WeatherApiClient.getInstance().getThreeDaysWeather(locationId).enqueue(
                new Callback<LocationWeatherResponse>() {

                    @Override
                    public void onResponse(Call<LocationWeatherResponse> call, Response<LocationWeatherResponse> response) {
                        Channel channel = response.body().getChannel();
                        for (WeatherDay weatherDay : channel.getWeatherDaysList()) {
                            weatherDay.refillAttributes();
                        }
                        _channel.postValue(channel);
                        _updatedAt.postValue(new Date());

                        startRefreshingTimer();
                        _fetchingData.postValue(false);
                    }

                    @Override
                    public void onFailure(Call<LocationWeatherResponse> call, Throwable t) {

                        Log.e("com.test", "" + t.getMessage());
                        _errorMessage.postValue(t.getMessage());
                        _fetchingData.postValue(false);
                    }
                }
        );

    }

    private void startRefreshingTimer() {
        cancelTimer();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                int updatedHour = Utils.getHour(updatedAt.getValue());
                int currentHour = Utils.getHour(new Date());
                // if you want to test it you can uncomment the next lines
//                updatedHour = 19; // not in default range
//                currentHour = 21; // in the default range
                if (inRange(updatedHour) && !inRange(currentHour) ||
                        !inRange(updatedHour) && inRange(currentHour)) {

                    cancelTimer();
                    fetchData(locationId);
                }
            }
        }, ONE_MINUTE, ONE_MINUTE);
    }

    private boolean inRange(int hour) {
        return hour >= userUpdateRange.getMin() && hour <= userUpdateRange.getMax();
    }

    private void cancelTimer() {
        if (timer != null) {
            try {
                timer.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        timer = null;
    }
}
