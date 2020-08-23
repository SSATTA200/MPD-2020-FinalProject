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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;

import com.example.ssattampd.R;
import com.example.ssattampd.Utils;
import com.example.ssattampd.data.models.Location;
import com.example.ssattampd.data.models.WeatherDay;
import com.example.ssattampd.databinding.FragmentLocationWeatherPagerBinding;
import com.example.ssattampd.ui.fragments.BaseFragment;

import java.util.Calendar;
import java.util.List;

public class LocationWeatherPagerFragment extends BaseFragment {

    private static final String LOCATION = "LOCATION";
    private Location location;

    public static Bundle getBundle(Location location) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(LOCATION, location);
        return bundle;
    }

    private LocationWeatherViewModel viewModel;
    private FragmentLocationWeatherPagerBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        location = (Location) getArguments().getSerializable(LOCATION);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentLocationWeatherPagerBinding.inflate(inflater, container, false);
        binding.swipeRefresh.setOnRefreshListener(() -> {
            viewModel.fetchData(location.getLocationId());
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(LocationWeatherViewModel.class);
        viewModel.channel.observe(getViewLifecycleOwner(), channel -> {

            binding.setChannel(channel);
            setUpViewPager(channel.getWeatherDaysList());
        });
        viewModel.errorMessage.observe(getViewLifecycleOwner(), this::showErrorMessage);
        viewModel.updatedAt.observe(getViewLifecycleOwner(), date -> {
            binding.txtUpdatedAt.setText(getString(R.string.updated_at, Utils.formatDate(date)));
        });
        viewModel.fetchingData.observe(getViewLifecycleOwner(), b -> binding.swipeRefresh.setRefreshing(b));
        viewModel.fetchData(location.getLocationId());
    }

    private void setUpViewPager(List<WeatherDay> weatherDays) {

        binding.pagerWeather.setAdapter(new WeatherPagerAdapter(weatherDays, getChildFragmentManager()));
        binding.tabsWeatherDays.setupWithViewPager(binding.pagerWeather);
    }

    @Override
    public String getToolbarTitle() {
        return getString(R.string.three_days_weather);
    }

    private class WeatherPagerAdapter extends FragmentPagerAdapter {
        private List<WeatherDay> weatherDays;

        public WeatherPagerAdapter(List<WeatherDay> weatherDays, FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            this.weatherDays = weatherDays;
        }


        @Override
        public int getCount() {
            return weatherDays.size();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            return WeatherDayFragment.newInstance(weatherDays.get(position));
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) { // today
                return getString(R.string.today);
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE, position);
                return Utils.getDay(calendar.getTime());
            }
        }

    }
}
