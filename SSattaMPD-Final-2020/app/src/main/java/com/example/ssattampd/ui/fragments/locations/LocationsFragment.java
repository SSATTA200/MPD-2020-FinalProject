package com.example.ssattampd.ui.fragments.locations;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.ssattampd.R;
import com.example.ssattampd.data.models.Location;
import com.example.ssattampd.databinding.FragmentLocationsBinding;
import com.example.ssattampd.ui.fragments.BaseFragment;
import com.example.ssattampd.ui.fragments.location_weather.LocationWeatherPagerFragment;

public class LocationsFragment extends BaseFragment {

    private LocationsViewModel viewModel;

    private FragmentLocationsBinding binding;
    private LocationsAdapter locationsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentLocationsBinding.inflate(inflater, container, false);
        initView();
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    private void initView() {

        locationsAdapter = new LocationsAdapter(location -> {

            getMainActivity().replaceFragment(R.id.action_locationFragment_to_locationWeatherPagerFragment,
                    LocationWeatherPagerFragment.getBundle(location));

        });
        binding.recyclerViewLocations.setAdapter(locationsAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(LocationsViewModel.class);
        viewModel.locations.observe(getViewLifecycleOwner(), locations -> locationsAdapter.setData(locations));

        viewModel.fetchData();
    }

    @Override
    public String getToolbarTitle() {
        return getString(R.string.location_fragment);
    }

    public interface OnLocationClickListener {
        void onClick(Location location);
    }

    @Override
    protected boolean canShowBack() {
        return false;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.item_settings) {

            getMainActivity().replaceFragment(R.id.action_global_settingsFragment, null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
