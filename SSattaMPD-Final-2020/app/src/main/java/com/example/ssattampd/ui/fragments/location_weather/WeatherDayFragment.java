package com.example.ssattampd.ui.fragments.location_weather;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ssattampd.data.models.WeatherDay;
import com.example.ssattampd.databinding.FragmentWeatherDayBinding;
import com.example.ssattampd.ui.fragments.BaseFragment;

public class WeatherDayFragment extends BaseFragment {

    private static final String WEATHER_DAY = "WEATHER_DAY";
    private FragmentWeatherDayBinding binding;
    private WeatherDay weatherDay;

    public static WeatherDayFragment newInstance(WeatherDay weatherDay) {

        Bundle args = new Bundle();

        WeatherDayFragment fragment = new WeatherDayFragment();
        args.putSerializable(WEATHER_DAY, weatherDay);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weatherDay = (WeatherDay) getArguments().getSerializable(WEATHER_DAY);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentWeatherDayBinding.inflate(inflater, container, false);
        binding.setWeatherDay(weatherDay);
        return binding.getRoot();
    }

    @Override
    public String getToolbarTitle() {
        return null;
    }
}
